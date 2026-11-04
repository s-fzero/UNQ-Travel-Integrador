package reserva.notificacion;

import reserva.Reserva;

public class NotificadorMail implements Subsistema, MailSender{
    @Override
    public void actualizar(Reserva res) {

    }

    @Override
    public void enviarMail(String direccionDestino, String titulo, String mensaje, Object adjunto) {

    }
}
