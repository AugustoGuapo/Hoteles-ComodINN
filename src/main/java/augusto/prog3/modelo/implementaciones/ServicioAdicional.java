package augusto.prog3.modelo.implementaciones;

import java.time.LocalDate;

public class ServicioAdicional {

    private String nombre;
    private float costo;
    private float costoTotal;
    private LocalDate fechaConsumo;

    public ServicioAdicional(String nombre, float costo, int dias) {
        this.setNombre(nombre);
        this.setCosto(costo);
        setCostoTotal(dias);
        setFechaConsumo(LocalDate.now());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int dias) {
        costoTotal = costo * dias;
    }

    public LocalDate getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(LocalDate fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
}
