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
}
