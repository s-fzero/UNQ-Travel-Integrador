package ar.edu.unq.po2.tpIntegrador.reserva.status;

public class ReservaCancelada extends ReservaStatus {
    public ReservaCancelada(){

    }

    @Override
    public void cancelarReserva(Reserva r) {

    }

    @Override
    public void procesarReserva(Reserva r) {

    }

    @Override
    public boolean debeGenerarVoucher() { return true; }
}
