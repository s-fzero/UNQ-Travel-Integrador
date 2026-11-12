package reserva.notificacion;

import reserva.Reserva;
import reserva.status.ReservaCancelada;
import reserva.status.ReservaFinalizada;

public class Generador implements Subsistema{
    @Override
    public void actualizar(Reserva res) {
        if(res.getStatus() instanceof ReservaFinalizada){
            this.crearComprobante(res);
            this.crearVoucher(res);
        }
    }

    public void crearComprobante(Reserva res){

    }
    public void crearVoucher(Reserva res){

    }
}
