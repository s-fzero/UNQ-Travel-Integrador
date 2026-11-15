package reserva.notificacion;

import reserva.Reserva;
import reserva.status.*;

import java.util.Date;

public class Generador implements Subsistema{
    @Override
    public void actualizar(Reserva res) {
        ReservaStatus estado = res.getStatus();
        generarComprobante(res, estado);
        generarVoucher(res, estado);
    }

    private void generarVoucher(Reserva res, ReservaStatus estado) {
        if (estado.debeGenerarVoucher()){
            this.crearVoucher(res);
        }
    }

    private void generarComprobante(Reserva res, ReservaStatus estado) {
        if(estado.debeGenerarComprobante()){
            this.crearComprobante(res);
        }
    }

    public void crearComprobante(Reserva res){
        Adjunto comprobante = new Comprobante("Comprobante de reserva", new Date(), res);
        res.agregarAdjunto(comprobante);
    }

    public void crearVoucher(Reserva res){
        Adjunto voucher = new Voucher("Voucher", new Date(), res);
        res.agregarAdjunto(voucher);
    }
}
