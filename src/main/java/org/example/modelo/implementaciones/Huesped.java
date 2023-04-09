package org.example.modelo.implementaciones;

import java.util.ArrayList;
import java.util.Objects;

public class Huesped {

    private String nombre;
    private String nroIdentificacion;
    private ArrayList<Factura> facturas;

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

}
