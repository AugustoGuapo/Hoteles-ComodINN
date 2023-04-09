package org.example.modelo.implementaciones;

import java.util.List;

public class Habitacion {
    private int capacidad;
    private int nroHabitacion;
    private List<Huesped> huespedes;

    public Habitacion(int capacidad, int nroHabitacion) {
        this.capacidad = capacidad;
        this.nroHabitacion = nroHabitacion;
    }

    public Habitacion() {

    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }
}
