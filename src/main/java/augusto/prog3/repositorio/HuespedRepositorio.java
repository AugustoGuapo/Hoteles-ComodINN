package augusto.prog3.repositorio;

import augusto.prog3.excepciones.HuespedNoEncontrado;
import augusto.prog3.modelo.implementaciones.Factura;
import augusto.prog3.modelo.implementaciones.Huesped;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HuespedRepositorio {

    List<Huesped> huespedes;

    public HuespedRepositorio() {
        huespedes = new ArrayList<>();
    }

    public void guardarHuesped(Huesped huesped) {
        if(!huespedes.contains(huesped)) huespedes.add(huesped);
    }

    public void guardarHuespedes(List<Huesped> huespedes) {
        this.huespedes.addAll(huespedes.stream()
                .filter(h -> !this.huespedes.contains(h))
                .collect(Collectors.toList()));
    }

    public Huesped buscarHuespedIdentificacion(String identificacion) {
        return huespedes.stream()
                .filter(h -> h.getNroIdentificacion().equalsIgnoreCase(identificacion))
                .findFirst()
                .orElseThrow(() -> new HuespedNoEncontrado("No se encontró un huesped con ese número de identificación"));
    }

    public void annadirFacturaHuesped(String identificacion, Factura nuevaFactura) {
        Huesped huesped = buscarHuespedIdentificacion(identificacion);
        huesped.setFactura(nuevaFactura);
    }
}
