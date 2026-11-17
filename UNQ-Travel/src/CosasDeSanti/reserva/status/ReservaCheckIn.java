package ar.edu.unq.po2.tpIntegrador.reserva.status;

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
