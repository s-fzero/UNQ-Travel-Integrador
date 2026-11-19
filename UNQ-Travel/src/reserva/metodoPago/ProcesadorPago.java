package reserva.metodoPago;

public abstract class ProcesadorPago {

    private Double montoAPagar;

    public ProcesadorPago(Double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public void procesarPago(){
        this.validarDatos();
        this.reservarFondos();
        this.ejecutarTransaccion();
        this.notificarTransaccion();
    }

    public abstract void validarDatos();

    public abstract void reservarFondos();

    public abstract void ejecutarTransaccion();

    public abstract void notificarTransaccion();

    public Double getMontoAPagar() {
        return this.montoAPagar;
    }
}
