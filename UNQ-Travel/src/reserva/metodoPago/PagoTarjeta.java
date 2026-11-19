package reserva.metodoPago;

public class PagoTarjeta extends ProcesadorPago{
    private TarjetaAPI tarjeta;

    public PagoTarjeta(Double montoAPagar,TarjetaAPI tarjeta) {
        super(montoAPagar);
        this.tarjeta = tarjeta;
    }

    @Override
    public void validarDatos() {

    }

    @Override
    public void reservarFondos() {

    }

    @Override
    public void ejecutarTransaccion() {

    }

    @Override
    public void notificarTransaccion() {

    }
}
