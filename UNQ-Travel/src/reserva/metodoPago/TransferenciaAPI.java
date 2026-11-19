package reserva.metodoPago;

import java.time.LocalDate;

public interface TransferenciaAPI {
    String trasferenciaProgramada(Double montoAPagar, LocalDate fechaTransferencia);

    String transferenciaInmediata(Double montoAPagar);

    boolean validarCBU(String cbu, String alias);

    void generarComprobante(String nroTransaccion);
}
