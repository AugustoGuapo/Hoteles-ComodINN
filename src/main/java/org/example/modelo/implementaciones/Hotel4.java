package org.example.modelo.implementaciones;

import org.example.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel4 extends Hotel {

    public Hotel4() {
        super();
        setServiciosPermitidos((ArrayList<String>) List.of("Frigobar", "Spa"));
        setCostoNoche(10000);
    }

}
