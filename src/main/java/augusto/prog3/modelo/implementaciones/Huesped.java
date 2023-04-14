package augusto.prog3.modelo.implementaciones;

import java.util.ArrayList;

public class Huesped {

    private String nombre;
    private String nroIdentificacion;
    private ArrayList<Factura> facturas;
    
    public Huesped () {
        this.facturas = new ArrayList();
    }
    
    public Huesped (String nombre, String nroIdentificacion) {
        this.nombre = nombre;
        this.nroIdentificacion = nroIdentificacion;
        this.facturas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public Factura getFactura(int indice) {
        return facturas.get(indice);
    }

    public void setFactura(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Huesped{" + "nombre=" + nombre + ", nroIdentificacion=" + nroIdentificacion + ", facturas=" + facturas + '}';
    }

    
}
