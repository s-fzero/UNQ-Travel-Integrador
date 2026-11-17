package ar.edu.unq.po2.tpIntegrador.reserva.notificacion;

import java.util.Date;

public class Mail implements Adjunto{
    private String titulo;
    private Date fecha;
    private String destino;
    private String cuerpo;
    private Object adjunto;

    public Mail(String titulo, Date date, String direccionDestino, String mensaje, Object adjunto) {
        this.titulo = titulo;
        this.fecha = date;
        this.destino = direccionDestino;
        this.cuerpo = mensaje;
        this.adjunto = adjunto;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public Date getFecha() {
        return fecha;
    }
}
