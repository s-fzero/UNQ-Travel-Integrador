package reserva.notificacion;

import reserva.Reserva;

import java.util.Date;

public class Voucher extends Comprobante{

    public Voucher(String descripcion, Date fecha, Reserva reserva) {
        super(descripcion, fecha, reserva);
    }

    @Override
    public String getDescripcion() {
        return "";
    }

    @Override
    public Date getFecha() {
        return null;
    }
}
