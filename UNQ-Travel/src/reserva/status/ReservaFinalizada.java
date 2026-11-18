package reserva.status;

import reserva.Reserva;

public class ReservaFinalizada extends ReservaStatus{
    public ReservaFinalizada(){

    }

    @Override
    public void procesarReserva(Reserva r) {

    }

    @Override
    public void cancelarReserva(Reserva r) {

    }

    @Override
    public boolean debeEnviarMail() { return true;}
    public boolean debeGenerarComprobante() { return true;}
    public boolean debeGenerarVoucher() { return true;}
    public boolean estaFinalizada() { return true; }
}
