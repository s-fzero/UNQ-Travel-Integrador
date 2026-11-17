package ar.edu.unq.po2.tpIntegrador.reserva.status;

public class ReservaConfirmada extends ReservaStatus {
    public ReservaConfirmada(){

    }

    @Override
    public void procesarReserva(Reserva r){
        r.realizarCheckIn();
        this.cambiarEstado(r, new ReservaCheckIn());
    }

    @Override
    public void cancelarReserva(Reserva r) {
        r.reembolsarReserva();
        super.cancelarReserva(r);
    }

    @Override
    public boolean debeEnviarMail() {return true;}

}
