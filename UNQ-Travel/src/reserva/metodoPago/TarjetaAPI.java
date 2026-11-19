package reserva.metodoPago;

import java.time.LocalDate;

public interface TarjetaAPI {

    Boolean validarTarjeta(Integer nroTarjeta, Integer cvv, LocalDate fechaVencimiento);
    Boolean preAutorizar(Double montoAPagar);
    String  transferir(Double montoAPagar);
    void    generarVoucher(String nro);
}
