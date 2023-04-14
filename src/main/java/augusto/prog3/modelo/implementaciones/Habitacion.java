package augusto.prog3.modelo.implementaciones;

import java.util.List;

public class Habitacion {
    private int capacidad;
    private int nroHabitacion;
    private String tipoHabitacion;
    private List<Huesped> huespedes;

    public Habitacion(int capacidad, int nroHabitacion,String tipoHabitacion, List<Huesped> huespedes) {
        this.capacidad = capacidad;
        this.nroHabitacion = nroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.huespedes = huespedes;
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

    /**
     * @return the tipoHabitacion
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * @param tipoHabitacion the tipoHabitacion to set
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "capacidad=" + capacidad + ", nroHabitacion=" + nroHabitacion + ", tipoHabitacion=" + tipoHabitacion + ", huespedes=" + huespedes + '}';
    }
    
    
}
