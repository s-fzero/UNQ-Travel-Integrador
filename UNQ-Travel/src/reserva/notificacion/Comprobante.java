package reserva.notificacion;

import catalogo.servicios.Servicio;
import reserva.Reserva;

import java.util.Date;
import java.util.List;


public class Comprobante implements Adjunto {
    String titulo;
    Date fecha;
    Double precio;
    List<Servicio> servicios;
    //ProcesadorPago metodoPago;

    public Comprobante(String descripcion, Date fecha, Reserva reserva) {
        this.titulo = descripcion;
        this.fecha = fecha;
        this.precio = reserva.cobrarServicios();
        this.servicios = reserva.getServicios();
        //this.metodoPago = reserva.getMetodoDePago();
    }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public Date getFecha() {
        return fecha;
    }
}
