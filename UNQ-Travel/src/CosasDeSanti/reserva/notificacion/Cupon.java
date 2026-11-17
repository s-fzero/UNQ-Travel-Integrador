package ar.edu.unq.po2.tpIntegrador.reserva.notificacion;

import java.util.Date;

public class Cupon implements Adjunto {
    String titulo;
    Date fecha;
    Double descuento;

    public Cupon(String descripcion, Date fecha, Double descuento) {
        this.titulo = descripcion;
        this.fecha = fecha;
        this.descuento = descuento;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }
    @Override
    public String getTitulo() {
        return titulo;
    }
    public Double getDescuento() { return descuento; }
}
