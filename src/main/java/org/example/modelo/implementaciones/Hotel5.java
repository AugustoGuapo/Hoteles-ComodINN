package org.example.modelo.implementaciones;

import org.example.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel5 extends Hotel {

    public Hotel5() {
        super();
        setServiciosPermitidos((ArrayList<String>) List.of("Frigobar"));
        setCostoNoche(15000);
    }
}
