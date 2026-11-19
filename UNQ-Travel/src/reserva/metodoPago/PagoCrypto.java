package reserva.metodoPago;

public class PagoCrypto extends ProcesadorPago{
    private CryptoAPI cripto;
    private Double saldo;

    public PagoCrypto(Double montoAPagar, CryptoAPI cripto, Double saldo) {
        super(montoAPagar);
        this.cripto = cripto;
        this.saldo = saldo;
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
