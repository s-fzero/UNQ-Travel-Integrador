package reserva.notificacion;

import catalogo.Servicio;
import reserva.Reserva;

import java.util.Date;
import java.util.List;

public class Comprobante implements Adjunto {
    String descripcion;
    Date fecha;
    Reserva reserva;

    public Comprobante(String descripcion, Date fecha, Reserva res) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reserva = res;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }
}
