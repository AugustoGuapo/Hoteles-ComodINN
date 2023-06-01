package augusto.prog3.servicio;

import augusto.prog3.modelo.abstractas.Hotel;
import augusto.prog3.modelo.implementaciones.Factura;
import augusto.prog3.modelo.implementaciones.Habitacion;
import augusto.prog3.modelo.implementaciones.Huesped;
import augusto.prog3.modelo.implementaciones.ServicioAdicional;
import augusto.prog3.repositorio.FacturaRepositorio;
import augusto.prog3.repositorio.HotelRepositorio;
import augusto.prog3.repositorio.HuespedRepositorio;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelService {

    protected List<Hotel> hotel;
    private HotelRepositorio hotelRepositorio;
    private FacturaRepositorio facturaRepositorio;
    private HuespedRepositorio huespedRepositorio;

    public HotelService(Hotel hotel) {
        this.hotel = new ArrayList(Arrays.asList(hotel));
        this.hotelRepositorio = new HotelRepositorio();
        this.facturaRepositorio = new FacturaRepositorio();
        this.huespedRepositorio = new HuespedRepositorio();
        anadirHoteles();
    }

    public HotelService(List<Hotel> hoteles) {
        this.hotel = new ArrayList(hoteles);
        this.hotelRepositorio = new HotelRepositorio();
        this.facturaRepositorio = new FacturaRepositorio();
        this.huespedRepositorio = new HuespedRepositorio();
        anadirHoteles();
    }
    public Factura alojamientoInicial(List<Huesped> huespedes,
                                      Habitacion habitacion,
                                      LocalDate fechaEntrada,
                                      LocalDate fechaSalida,
                                      Huesped titular,
                                      List<ServicioAdicional> serviciosAdicionales,
                                      int indiceHotel) {
        Factura bus = facturaRepositorio.getFacturaByNroIdentificacion(titular.getNroIdentificacion());
        if (bus != null) titular = bus.getTitular();
        Factura fact = crearFactura(huespedes, habitacion, fechaEntrada, fechaSalida, titular, serviciosAdicionales, indiceHotel);
        hotel.get(indiceHotel).setHabitacion(habitacion);
        titular.setFactura(fact);
        huespedRepositorio.guardarHuespedes(huespedes);
        return facturaRepositorio.guardarFactura(hotel.get(indiceHotel), fact);
    }

    private Factura crearFactura(List<Huesped> huespedes, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida, Huesped titular, List<ServicioAdicional> serviciosAdicionales, int indiceHotel) {
        Factura fact = new Factura();
        fact.setHuespedes(huespedes);
        fact.setHabitacion(habitacion);
        fact.setCosto(calcularCostoInicial(fechaEntrada, fechaSalida, indiceHotel));
        fact.setFechaEntrada(fechaEntrada);
        fact.setFechaSalida(fechaSalida);
        fact.setTitular(titular);
        fact.setServiciosAdicionales(serviciosAdicionales);
        fact.setIndiceHotel(indiceHotel);
        return fact;
    }

    private float calcularCostoInicial(LocalDate fechaEntrada, LocalDate fechaSalida, int indiceHotel) {
        return DAYS.between(fechaEntrada, fechaSalida) * hotel.get(indiceHotel).getCostoNoche();
    }

    public void anadirServicioAdicional(ServicioAdicional servicio, String identificacionHuesped, int indiceHotel) {
        Factura facturaServicio = facturaRepositorio.getFacturaByNroIdentificacion(identificacionHuesped);
        facturaServicio.setCosto(facturaServicio.getCosto() + servicio.getCostoTotal());
        System.out.println(facturaRepositorio.getFacturaByNroIdentificacion(identificacionHuesped).getCosto());
    }

    public void anadirHoteles() {
        facturaRepositorio.guardarHoteles(this.hotel);
    }
    
    /**
     * 
     * @param nroPiso
     * @param tipoHotel
     * @param tipoHabitacion
     * @param huespedes
     * @param titular
     * @param indiceHotel
     * @return una habitación generada del 1 al 10, se toma como suposición que el hotel tiene 3 pisos nada más y cada piso tiene un solo tipo de habitación, esto con el fin de generarlas según la necesidad y no tener que cargar x numeros de habitaciones al compilar la aplicación, en un caso de uso real se cargarían las habitaciones desde una DB
     */
    
    public Habitacion generarHabitacion(int nroPiso, int tipoHotel, int tipoHabitacion, List<Huesped> huespedes, Huesped titular, int indiceHotel) {
        final String[] TIPOS_HABITACION = {"Individual", "Estándar", "Suite", "Suite", "Familiar", "Presidencial", "Suite", "Deluxe", "Loft"};
        int capacidadHabitacion = (int) Math.pow(2,nroPiso);
        int indiceHabitacion = tipoHotel*3+tipoHabitacion;
        return new Habitacion(capacidadHabitacion, generarNroHabitacion(nroPiso, indiceHotel), TIPOS_HABITACION[indiceHabitacion], huespedes, titular);
        
    }
    
    private int generarNroHabitacion(int nroPiso, int indiceHotel) {
        int nroHabitacionesPiso =(int) hotel.get(indiceHotel).getHabitaciones().stream()
                .filter(h -> Integer.toString(h.getNroHabitacion()).startsWith(Integer.toString(nroPiso)))
                .count();
        
        if (nroHabitacionesPiso < 10) return nroPiso * 100 + nroHabitacionesPiso+1;
        throw new RuntimeException("Todas las habitaciones ocupadas en ese piso, intentar de nuevo");
    }
    
    public Hotel getHotel(int indice) {
        return hotel.get(indice);
    }
    
    public List<Factura> getFacturas() {
        return facturaRepositorio.getFacturasVigentes();
    }
    
    
    public Huesped getClienteByIdentificacion(String identificacion) {
        return huespedRepositorio.buscarHuespedIdentificacion(identificacion);
    }


}
