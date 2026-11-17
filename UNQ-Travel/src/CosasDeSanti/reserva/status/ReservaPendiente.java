package ar.edu.unq.po2.tpIntegrador.reserva.status;

public class ReservaPendiente extends ReservaStatus{

    public ReservaPendiente() {}

    @Override
    public void procesarReserva(Reserva r){
        r.reservarCupos();
        r.cobrarServicios();
        this.cambiarEstado(r, new ReservaConfirmada());
    }

}
