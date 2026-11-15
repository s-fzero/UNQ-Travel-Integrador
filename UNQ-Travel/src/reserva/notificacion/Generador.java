package reserva.notificacion;

import reserva.Reserva;
import reserva.status.*;

import java.util.Date;

public class Generador implements Subsistema{
    @Override
    public void actualizar(Reserva res) {
        ReservaStatus estado = res.getStatus();
        if(estado instanceof ReservaFinalizada){
            this.crearComprobante(res);
            this.crearVoucher(res);
        }
        else if (estado instanceof ReservaCancelada){
            this.crearVoucher(res);
        }
    }

    public void crearComprobante(Reserva res){
        Adjunto comprobante = new Comprobante("Comprobante de reserva", new Date(), res);
        res.agregarAdjunto(comprobante);
    }

    public void crearVoucher(Reserva res){
        Adjunto voucher = new Comprobante("Voucher", new Date(), res);
        res.agregarAdjunto(voucher);
    }
}
