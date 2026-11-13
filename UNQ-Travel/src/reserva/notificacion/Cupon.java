package reserva.notificacion;

import java.util.Date;

public class Cupon implements Adjunto {
    String descripcion;
    Date fecha;
    Double descuento;

    public Cupon(String des, Date fecha, Double desc) {
        this.descripcion = des;
        this.fecha = fecha;
        this.descuento = desc;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
