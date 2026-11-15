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
        if(estado instanceof ReservaFinalizada ||
           estado instanceof ReservaConfirmada ||
           estado instanceof ReservaEnCurso) {
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
