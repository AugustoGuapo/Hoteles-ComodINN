package org.example.modelo.abstractas;

import org.example.modelo.implementaciones.Factura;
import org.example.modelo.implementaciones.Habitacion;

import java.util.ArrayList;
import java.util.List;

public abstract class Hotel {

    private ArrayList<Habitacion> habitaciones;
    private int tipo;
    private String tipoHotel;
    private ArrayList<String> serviciosPermitidos;
    private String nombreHotel;
    private float costoNoche;


    public Hotel() {
        setHabitaciones(new ArrayList<>());
        setTipoHotel("");
        setServiciosPermitidos(new ArrayList<>());
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Habitacion getHabitacion(int indice) {
        return this.habitaciones.get(indice);
    }

    public void setHabitacion( Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTipoHotel() {
        return tipoHotel;
    }

    public void setTipoHotel(String tipoHotel) {
        this.tipoHotel = tipoHotel;
    }

    public ArrayList<String> getServiciosPermitidos() {
        return serviciosPermitidos;
    }

    public void setServiciosPermitidos(ArrayList<String> serviciosPermitidos) {
        this.serviciosPermitidos = serviciosPermitidos;
    }


    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public float getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(float costoNoche) {
        this.costoNoche = costoNoche;
    }
}
