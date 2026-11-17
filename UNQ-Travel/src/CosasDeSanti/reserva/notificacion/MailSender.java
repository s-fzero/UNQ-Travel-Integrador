package ar.edu.unq.po2.tpIntegrador.reserva.notificacion;

public interface MailSender {
    public void enviarMail(String direccionDestino, String titulo, String mensaje, Object adjunto);
}
