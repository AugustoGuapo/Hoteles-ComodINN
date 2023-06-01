package augusto.prog3.repositorio;

import augusto.prog3.modelo.implementaciones.Huesped;
import augusto.prog3.modelo.implementaciones.ServicioAdicional;
import augusto.prog3.modelo.abstractas.Hotel;
import augusto.prog3.modelo.implementaciones.Factura;

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
    
    public void guardarHoteles(List<Hotel> hoteles) {
        for (Hotel hotel : hoteles) {
            facturasPorHotel.put(hotel, new ArrayList<>());
        }
    }

    public Factura guardarFactura(Hotel hotel, Factura fact) {
        facturasPorHotel.get(hotel).add(fact);
        return fact;
    }

    public List<Factura> getFacturasVigentes() {
        ArrayList<Factura> facturasSalida = new ArrayList();
        for (Map.Entry<Hotel, List<Factura>> entry : facturasPorHotel.entrySet()) {
            facturasSalida.addAll(entry.getValue().stream().filter(f -> !f.isPagada()).collect(Collectors.toList()));
        }
        return facturasSalida;
    }

    public Factura actualizarFactura(Hotel hotel, Huesped huesped, ServicioAdicional servicioAdicional) {
        Factura fact = getFacturaByNroIdentificacion(huesped.getNroIdentificacion());
        fact.anadirServicioAdicional(servicioAdicional);
        return fact;
    }

    public Factura getFacturaByNroIdentificacion(String nroIdentificacion) {
        return getFacturasVigentes().stream()
                .filter(l -> l.getHuesped(nroIdentificacion) != null)
                .findFirst()
                .orElse(null);
    }
    
}
