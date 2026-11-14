package reserva.notificacion;

import reserva.Reserva;
import reserva.status.ReservaFinalizada;

import java.util.Date;

public class Generador implements Subsistema{
    @Override
    public void actualizar(Reserva res) {
        if(res.getStatus() instanceof ReservaFinalizada){
            this.crearComprobante(res);
            this.crearVoucher(res);
        }
    }

    public void crearComprobante(Reserva res){
        Adjunto comprobante = new Comprobante("Comprobante de reserva", new Date(), res);
        res.agregarAdjunto(comprobante);
    }
    public void crearVoucher(Reserva res){
        Adjunto voucher = new Voucher("Voucher de reserva", new Date(), res);
        res.agregarAdjunto(voucher);
    }
}
