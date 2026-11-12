package reserva.status;

import reserva.Reserva;

public class ReservaEnCurso extends ReservaStatus {
    public ReservaEnCurso(){

    }
    @Override
    public void procesarReserva(Reserva r) {
        this.cambiarEstado(r, new ReservaFinalizada());
    }

    @Override
    public void cancelarReserva(Reserva r) {
        r.reembolsarReserva(); // reembolsar servicios q no se usaron.
        super.cancelarReserva(r);
    }
}
