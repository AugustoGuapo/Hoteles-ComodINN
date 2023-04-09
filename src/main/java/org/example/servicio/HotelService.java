package org.example.servicio;

import org.example.modelo.abstractas.Hotel;
import org.example.modelo.implementaciones.Factura;
import org.example.modelo.implementaciones.Habitacion;
import org.example.modelo.implementaciones.Huesped;
import org.example.modelo.implementaciones.ServicioAdicional;
import org.example.repositorio.FacturaRepositorio;
import org.example.repositorio.HotelRepositorio;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class HotelService {

    protected Hotel hotel;
    private HotelRepositorio hotelRepositorio;
    private FacturaRepositorio facturaRepositorio;

    public HotelService(Hotel hotel) {
        this.hotel = hotel;
        this.hotelRepositorio = new HotelRepositorio();
        this.facturaRepositorio = new FacturaRepositorio();
        anadirHotel();
    }

    public Factura alojamientoInicial(List<Huesped> huespedes,
                                      Habitacion habitacion,
                                      LocalDate fechaEntrada,
                                      LocalDate fechaSalida,
                                      Huesped titular,
                                      List<ServicioAdicional> serviciosAdicionales) {
        Factura fact = new Factura();
        fact.setHuespedes(huespedes);
        fact.setHabitacion(habitacion);
        fact.setCosto(calcularCostoInicial(fechaEntrada, fechaSalida));
        fact.setFechaEntrada(fechaEntrada);
        fact.setFechaSalida(fechaSalida);
        fact.setTitular(titular);
        fact.setServiciosAdicionales(serviciosAdicionales);
        titular.setFactura(fact); //TODO hacer que esto baje a un repositorio de huespedes
        return facturaRepositorio.guardarFactura(hotel, fact);
    }

    protected float calcularCostoInicial(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return DAYS.between(fechaEntrada, fechaSalida) * hotel.getCostoNoche();
    }

    public void anadirServicioAdicional(ServicioAdicional servicio, String identificacionHuesped) {
        Factura facturaServicio = facturaRepositorio.getFacturaByNroIdentificacion(hotel, identificacionHuesped);
        facturaServicio.setCosto(facturaServicio.getCosto() + servicio.getCostoTotal());
        System.out.println(facturaRepositorio.getFacturaByNroIdentificacion(hotel, identificacionHuesped).getCosto());
    }

    public void anadirHotel() {
        facturaRepositorio.guardarHotel(this.hotel);
    }


}
