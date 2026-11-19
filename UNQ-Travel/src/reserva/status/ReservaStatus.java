package reserva.status;

import reserva.Reserva;

public abstract class ReservaStatus {
    public void cambiarEstado(Reserva r, ReservaStatus nuevoEstado){
        r.cambiarEstado(nuevoEstado);
    }
    public abstract void procesarReserva(Reserva r);
    public void cancelarReserva(Reserva r){
        this.cambiarEstado(r,new ReservaCancelada());
    }
    public boolean debeEnviarMail() {return false;}
    public boolean debeGenerarComprobante() {return false;}
    public boolean debeGenerarVoucher() {return false;}
    public boolean debeFidelizar() {return false;}
    public boolean estaFinalizada() {return false;}
    public boolean puedeDisfrutar() {return false;}
}
