package reserva.status;

import reserva.Reserva;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;

public class ReservaFinalizada extends ReservaStatus{
    public ReservaFinalizada(){

    }

    @Override
    public void procesarReserva(Reserva r) {
        throw new OperacionDeEstadoInvalida("No puede procesarse una reserva ya finalizada.");
    }

    @Override
    public void cancelarReserva(Reserva r) {
        throw new OperacionDeEstadoInvalida("No puede cancelarse una reserva ya finalizada.");
    }

    @Override
    public boolean debeEnviarMail() { return true;}
    public boolean debeGenerarComprobante() { return true;}
    public boolean debeGenerarVoucher() { return true;}
    public boolean estaFinalizada() { return true; }
}
