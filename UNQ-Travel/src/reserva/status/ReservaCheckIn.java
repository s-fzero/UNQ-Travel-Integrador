package reserva.status;

import reserva.Reserva;

public class ReservaCheckIn extends ReservaStatus {
    public ReservaCheckIn(){

    }

    @Override
    public void procesarReserva(Reserva r) {
        this.cambiarEstado(r, new ReservaEnCurso());
    }
    @Override
    public void cancelarReserva(Reserva r) {
        r.reembolsarReserva();
        super.cancelarReserva(r);
    }
}
