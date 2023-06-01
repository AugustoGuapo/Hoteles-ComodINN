package augusto.prog3.modelo.implementaciones;

import augusto.prog3.excepciones.HuespedNoEncontrado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Huesped> huespedes;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Huesped titular;
    private List<ServicioAdicional> serviciosAdicionales;
    private float costo;
    private int indiceHotel;
    private boolean pagada;


    public Factura() {
        huespedes = new ArrayList<>();
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public Huesped getHuesped(String nroIdentificacion) {
        return huespedes.stream()
                .filter(l -> l.getNroIdentificacion()
                        .equals(nroIdentificacion))
                .findFirst().orElse(null);
    }

    public void setHuesped(int indice, Huesped huesped) {
        this.huespedes.set(indice, huesped);
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Huesped getTitular() {
        return titular;
    }

    public void setTitular(Huesped titular) {
        this.titular = titular;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean valor) {
        pagada = valor;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void anadirServicioAdicional(ServicioAdicional servicioAdicional) {
        this.serviciosAdicionales.add(servicioAdicional);
        costo+= servicioAdicional.getCostoTotal();
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public String toString() {
        return "Factura{" +
                ", habitacion=" + habitacion.getNroHabitacion() +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", serviciosAdicionales=" + serviciosAdicionales +
                ", costo=" + costo +
                ", pagada=" + pagada +
                '}';
    }

    /**
     * @return the indiceHotel
     */
    public int getIndiceHotel() {
        return indiceHotel;
    }

    /**
     * @param indiceHotel the indiceHotel to set
     */
    public void setIndiceHotel(int indiceHotel) {
        this.indiceHotel = indiceHotel;
    }
    
    
}
