package augusto.prog3.modelo.implementaciones;

import augusto.prog3.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel3 extends Hotel {

    public Hotel3() {
        super();
        setServiciosPermitidos(new ArrayList<>(Arrays.asList("Frigobar", "Restaurante", "Estacionamiento")));
        setCostoNoche(5000);
    }
}
