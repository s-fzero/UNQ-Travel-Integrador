package reserva.status;

import reserva.Reserva;

public class ReservaPendiente extends ReservaStatus{

    public ReservaPendiente() {

    }

    @Override
    public void procesarReserva(Reserva r){
        r.reservarCupos();
        r.cobrarServicios();
        this.cambiarEstado(r, new ReservaConfirmada());
    }

    @Override
    public void cancelarReserva(Reserva r) {
        this.cambiarEstado(r , new ReservaCancelada());
    }

}
