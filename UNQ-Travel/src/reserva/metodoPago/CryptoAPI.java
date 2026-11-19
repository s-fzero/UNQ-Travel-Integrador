package reserva.metodoPago;

public interface CryptoAPI{
    Boolean validarSaldo(Double saldo);
    void bloquearSaldo(Double saldoABloquear);
    String acreditarVendedor(Double acreditacionMonto);
    void generarNotificacion(String notificacion);
}
