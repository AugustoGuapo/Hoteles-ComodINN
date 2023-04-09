package org.example.repositorio;

import org.example.modelo.abstractas.Hotel;
import org.example.modelo.implementaciones.Factura;
import org.example.modelo.implementaciones.Huesped;
import org.example.modelo.implementaciones.ServicioAdicional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FacturaRepositorio {
    private Map<Hotel, List<Factura>> facturasPorHotel;

    public FacturaRepositorio() {
        facturasPorHotel = new HashMap<>();
    }

    public void guardarHotel(Hotel hotel) {
        facturasPorHotel.put(hotel, new ArrayList<>());
    }

    public Factura guardarFactura(Hotel hotel, Factura fact) {
        facturasPorHotel.get(hotel).add(fact);
        return fact;
    }

    public List<Factura> getFacturasVigentes(Hotel hotel) {
        return facturasPorHotel.get(hotel).stream().filter(f -> !f.isPagada()).collect(Collectors.toList());
    }

    public Factura actualizarFactura(Hotel hotel, Huesped huesped, ServicioAdicional servicioAdicional) {
        Factura fact = getFacturaByNroIdentificacion(hotel, huesped.getNroIdentificacion());
        fact.anadirServicioAdicional(servicioAdicional);
        return fact;
    }

    public Factura getFacturaByNroIdentificacion(Hotel hotel, String nroIdentificacion) {
        return getFacturasVigentes(hotel).stream()
                .filter(l -> l.getHuesped(nroIdentificacion) != null)
                .findFirst()
                .orElseThrow();
    }
}