package reserva;

import catalogo.Servicio;
import reserva.status.ReservaPendiente;
import reserva.status.ReservaStatus;

import java.util.List;

public class Reserva {
    private List<Servicio> servicios;
    private List<Servicio> historialServicios;
    private ReservaStatus status;
    public Reserva() {
        this.status = new ReservaPendiente();
    }

    private List<Servicio> getServicios() {
        return servicios;
    }

    private List<Servicio> getHistorialServicios() {
        return historialServicios;
    }

    public void cambiarEstado(ReservaStatus nuevoEstado) {
        status = nuevoEstado;
    }

    public void procesarReserva(){
        status.procesarReserva(this);
    }

    public void reservarCupos() {
        this.getServicios().forEach(Servicio::reservarCupo);
    }


    public double cobrarServicios() {
        return this.getServicios().stream().mapToDouble(servicio -> servicio.getPrecioBase()).sum();
        //Discutir el tipo de la funcion.
    }

    public void realizarCheckIn() {
        //Comportamiento.
    }

    public double reembolsarReserva() {
        //Nuevo voucher con monto a reembolsar.
        return this.cobrarServicios(); //Discutir dsp
    }
}
