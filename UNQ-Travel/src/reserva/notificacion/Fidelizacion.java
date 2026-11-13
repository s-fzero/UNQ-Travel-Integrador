package reserva.notificacion;

import reserva.Reserva;
import reserva.status.ReservaCancelada;

import java.util.Date;

public class Fidelizacion implements Subsistema{

    @Override
    public void actualizar(Reserva res) {
        if(res.getStatus() instanceof ReservaCancelada){ this.enviarCupon(res); }
    }

    public void enviarCupon(Reserva res){
            Adjunto cupon = new Cupon("Cupón por cancelación", new Date(), 0.5);
            res.agregarAdjunto(cupon);
    }
}
