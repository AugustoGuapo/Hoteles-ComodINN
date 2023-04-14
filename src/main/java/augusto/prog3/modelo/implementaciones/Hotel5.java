package augusto.prog3.modelo.implementaciones;

import augusto.prog3.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel5 extends Hotel {

    public Hotel5() {
        super();
        setServiciosPermitidos(new ArrayList<>(Arrays.asList("Frigobar")));
        setCostoNoche(15000);
    }
}
