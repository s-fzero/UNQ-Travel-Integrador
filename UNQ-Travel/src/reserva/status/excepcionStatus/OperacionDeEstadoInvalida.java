package reserva.status.excepcionStatus;

public class OperacionDeEstadoInvalida extends RuntimeException {
    public OperacionDeEstadoInvalida(String mensaje) {
        super(mensaje);
    }
}

