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

public class HotelService {

    protected Hotel hotel;
    private HotelRepositorio hotelRepositorio;
    private FacturaRepositorio facturaRepositorio;
    private HuespedRepositorio huespedRepositorio;

    public HotelService(Hotel hotel) {
        this.hotel = hotel;
        this.hotelRepositorio = new HotelRepositorio();
        this.facturaRepositorio = new FacturaRepositorio();
        this.huespedRepositorio = new HuespedRepositorio();
        anadirHotel();
    }

    public Factura alojamientoInicial(List<Huesped> huespedes,
                                      Habitacion habitacion,
                                      LocalDate fechaEntrada,
                                      LocalDate fechaSalida,
                                      Huesped titular,
                                      List<ServicioAdicional> serviciosAdicionales) {
        Factura fact = crearFactura(huespedes, habitacion, fechaEntrada, fechaSalida, titular, serviciosAdicionales);
        hotel.setHabitacion(habitacion);
        titular.setFactura(fact);
        huespedRepositorio.guardarHuespedes(huespedes);
        return facturaRepositorio.guardarFactura(hotel, fact);
    }

    private Factura crearFactura(List<Huesped> huespedes, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida, Huesped titular, List<ServicioAdicional> serviciosAdicionales) {
        Factura fact = new Factura();
        fact.setHuespedes(huespedes);
        fact.setHabitacion(habitacion);
        fact.setCosto(calcularCostoInicial(fechaEntrada, fechaSalida));
        fact.setFechaEntrada(fechaEntrada);
        fact.setFechaSalida(fechaSalida);
        fact.setTitular(titular);
        fact.setServiciosAdicionales(serviciosAdicionales);
        return fact;
    }

    private float calcularCostoInicial(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return DAYS.between(fechaSalida, fechaEntrada) * hotel.getCostoNoche();
    }

    public void anadirServicioAdicional(ServicioAdicional servicio, String identificacionHuesped) {
        Factura facturaServicio = facturaRepositorio.getFacturaByNroIdentificacion(hotel, identificacionHuesped);
        facturaServicio.setCosto(facturaServicio.getCosto() + servicio.getCostoTotal());
        System.out.println(facturaRepositorio.getFacturaByNroIdentificacion(hotel, identificacionHuesped).getCosto());
    }

    public void anadirHotel() {
        facturaRepositorio.guardarHotel(this.hotel);
    }
    
    /**
     * 
     * @param nroPiso
     * @param tipoHotel
     * @param tipoHabitacion
     * @param huespedes
     * @return una habitación generada del 1 al 10, se toma como suposición que el hotel tiene 3 pisos nada más y cada piso tiene un solo tipo de habitación, esto con el fin de generarlas según la necesidad y no tener que cargar x numeros de habitaciones al compilar la aplicación, en un caso de uso real se cargarían las habitaciones desde una DB
     */
    
    public Habitacion generarHabitacion(int nroPiso, int tipoHotel, int tipoHabitacion, List<Huesped> huespedes) {
        final String[] TIPOS_HABITACION = {"Individual", "Estándar", "Suite", "Suite", "Familiar", "Presidencial", "Suite", "Deluxe", "Loft"};
        int capacidadHabitacion = (int) Math.pow(2,nroPiso);
        int indiceHabitacion = tipoHotel*3+tipoHabitacion;
        return new Habitacion(capacidadHabitacion, generarNroHabitacion(nroPiso), TIPOS_HABITACION[indiceHabitacion], huespedes);
        
    }
    
    private int generarNroHabitacion(int nroPiso) {
        int nroHabitacionesPiso =(int) hotel.getHabitaciones().stream()
                .filter(h -> Integer.toString(h.getNroHabitacion()).startsWith(Integer.toString(nroPiso)))
                .count();
        if (nroHabitacionesPiso < 10) return nroPiso * 100 + nroHabitacionesPiso+1;
        throw new RuntimeException("Todas las habitaciones ocupadas en ese piso, intentar de nuevo");
    }
    
    public Hotel getHotel() {
        return hotel;
    }


}
