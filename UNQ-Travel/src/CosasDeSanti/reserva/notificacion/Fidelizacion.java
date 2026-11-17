package ar.edu.unq.po2.tpIntegrador.reserva.notificacion;

import ar.edu.unq.po2.tpIntegrador.reserva.status.Reserva;
import ar.edu.unq.po2.tpIntegrador.reserva.status.ReservaStatus;

import java.util.Date;

public class Fidelizacion implements Subsistema{

    @Override
    public void actualizar(Reserva res) {
        ReservaStatus estado = res.getStatus();
        generarCupon(res, estado);
    }

    private void generarCupon(Reserva res, ReservaStatus estado) {
        if(estado.debeFidelizar()){
            this.enviarCupon(res);
        }
    }

    public void enviarCupon(Reserva res){
            Adjunto cupon = new Cupon("Cupón por cancelación", new Date(), 0.5);
            res.agregarAdjunto(cupon);
    }
}
