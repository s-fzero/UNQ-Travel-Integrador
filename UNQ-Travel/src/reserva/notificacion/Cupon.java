package reserva.notificacion;

public class Cupon implements Adjunto {
    String descripcion;
    Double descuento;

    public Cupon(String des, Double desc) {
        this.descripcion = des;
        this.descuento = desc;
    }
}
