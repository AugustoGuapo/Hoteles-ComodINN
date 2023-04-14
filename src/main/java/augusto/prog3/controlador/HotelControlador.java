package augusto.prog3.controlador;

import augusto.prog3.modelo.abstractas.Hotel;
import augusto.prog3.modelo.implementaciones.Factura;
import augusto.prog3.servicio.HotelService;

public class HotelControlador {
    HotelService hotelService;

    public HotelControlador(Hotel hotel) {
        this.hotelService = new HotelService(hotel);
    }
    //TODO: implementarla jejejeje

}
