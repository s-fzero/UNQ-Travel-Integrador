package reserva.status;

import reserva.Reserva;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;

public class ReservaEnCurso extends ReservaStatus {
    public ReservaEnCurso(){

    }
    @Override
    public void procesarReserva(Reserva r) {
        if(r.todosFueronDisfrutados()) {
            this.cambiarEstado(r, new ReservaFinalizada());
        }
        else{
            throw new OperacionDeEstadoInvalida("No puede finalizar una reserva que no disfrutó todos sus servicios");
        }
    }

    @Override
    public void cancelarReserva(Reserva r) {
        r.reembolsarReserva(); // reembolsar servicios q no se usaron.
        super.cancelarReserva(r);
    }

    @Override
    public boolean debeEnviarMail() { return true; }

    @Override
    public boolean puedeDisfrutar() { return true; }
}
