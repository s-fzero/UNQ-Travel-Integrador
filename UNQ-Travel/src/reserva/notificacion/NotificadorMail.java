package reserva.notificacion;

import reserva.*;
import reserva.status.*;

import java.util.Date;

public class NotificadorMail implements Subsistema, MailSender{
    Reserva reserva;

    @Override
    public void actualizar(Reserva res) {
        reserva = res;
        ReservaStatus estado = res.getStatus();
        generarMail(res, estado);
    }

    private void generarMail(Reserva res, ReservaStatus estado) {
        if(estado.debeEnviarMail()) {
            this.enviarMail(res.getCorreo(),
                    "Estado de su reserva",
                    "Su reserva cambió al estado:" + estado.getClass().getSimpleName(),
                    null);
        }
    }

    @Override
    public void enviarMail(String direccionDestino, String titulo, String mensaje, Object adjunto) {
        Adjunto mail = new Mail(titulo, new Date(), direccionDestino, mensaje, adjunto);
        reserva.agregarAdjunto(mail);
    }
}
