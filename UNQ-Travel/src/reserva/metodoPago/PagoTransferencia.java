package reserva.metodoPago;

import java.time.LocalDate;

public class PagoTransferencia extends ProcesadorPago{
    private TransferenciaAPI transferencia;
    private LocalDate fechaTransferencia;
    private String cbu;
    private String alias;

    public PagoTransferencia(Double montoAPagar, TransferenciaAPI transferencia, LocalDate fechaTransferencia) {
        super(montoAPagar);
        this.transferencia = transferencia;
        this.fechaTransferencia = fechaTransferencia;
    }

    public PagoTransferencia(Double montoAPagar, TransferenciaAPI transferencia) {
        super(montoAPagar);
        this.transferencia = transferencia;
    }

    @Override
    public void validarDatos() {
        transferencia.validarCBU(cbu, alias);
    }

    @Override
    public void reservarFondos() {

    }

    @Override
    public void ejecutarTransaccion() {
        if(this.fechaTransferencia == null){
            transferencia.transferenciaInmediata(this.getMontoAPagar());
        }
        else{
            transferencia.trasferenciaProgramada(this.getMontoAPagar(),fechaTransferencia);
        }
    }

    @Override
    public void notificarTransaccion() {
        transferencia.generarComprobante("");
    }
}
