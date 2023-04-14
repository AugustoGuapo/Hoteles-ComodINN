package augusto.prog3.modelo.implementaciones;

import augusto.prog3.modelo.abstractas.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel4 extends Hotel {

    public Hotel4() {
        super();
        setServiciosPermitidos(new ArrayList<>(Arrays.asList("Frigobar", "Spa")));
        setCostoNoche(10000);
    }

}
