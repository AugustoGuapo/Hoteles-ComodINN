package org.example.modelo.implementaciones;

import org.example.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel3 extends Hotel {

    public Hotel3() {
        super();
        setServiciosPermitidos(new ArrayList<>(Arrays.asList("Frigobar", "Restaurante", "Estacionamiento")));
        setCostoNoche(5000);
    }
}
