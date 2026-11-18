package reserva.status;

import reserva.Reserva;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;

public class ReservaCancelada extends ReservaStatus {
    public ReservaCancelada(){

    }

    @Override
    public void procesarReserva(Reserva r) {
        throw new OperacionDeEstadoInvalida("No puede procesarse una reserva ya cancelada.");
    }

    @Override
    public void cancelarReserva(Reserva r) {
        throw new OperacionDeEstadoInvalida("No puede cancelarse una reserva ya cancelada.");
    }

    @Override
    public boolean debeGenerarVoucher() { return true; }
}
