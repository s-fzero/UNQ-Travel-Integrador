package reserva.status;

import reserva.Reserva;

public class ReservaConfirmada extends ReservaStatus {
    @Override
    public void procesarReserva(Reserva r){
        r.realizarCheckIn();
        this.cambiarEstado(r, new ReservaCheckIn());
    }

    @Override
    public void cancelarReserva(Reserva r) {
        r.reembolsarReserva();
        this.cambiarEstado(r,new ReservaCancelada());
    }
}
