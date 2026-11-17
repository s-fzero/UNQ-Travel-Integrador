package ar.edu.unq.po2.tpIntegrador.reserva.status;

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

    @Override
    public boolean debeEnviarMail() { return true; }
}
