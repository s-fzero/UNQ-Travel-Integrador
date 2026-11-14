package reserva.notificacion;

import catalogo.Servicio;
import reserva.Reserva;

import java.util.Date;
import java.util.List;

public class Comprobante implements Adjunto {
    String descripcion;
    Date fecha;
    Double precio;
    List<Servicio> servicios;

    public Comprobante(String descripcion, Date fecha, Reserva reserva) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = reserva.cobrarServicios();
        this.servicios = reserva.getServicios();
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
