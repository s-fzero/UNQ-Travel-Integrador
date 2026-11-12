package reserva;

import catalogo.Servicio;
import reserva.notificacion.Adjunto;
import reserva.status.ReservaPendiente;
import reserva.status.ReservaStatus;
import reserva.notificacion.Subsistema;

import java.util.List;

public class Reserva {
    private List<Servicio> servicios;
    private List<Servicio> historialServicios;
    private List<Subsistema> subsistemas;
    private List<Adjunto> adjuntos;
    private ReservaStatus status;

    public Reserva() {
        this.status = new ReservaPendiente();
    }

    private List<Servicio> getServicios() {
        return this.servicios;
    }

    private List<Servicio> getHistorialServicios() {
        return this.historialServicios;
    }

    public ReservaStatus getStatus() { return this.status;}

    public void cambiarEstado(ReservaStatus nuevoEstado) { this.status = nuevoEstado; }

    public void procesarReserva(){ this.status.procesarReserva(this); }

    public void cancelarReserva(){
        this.notificarSubsistemas();
        this.status.cancelarReserva(this);
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

    public void notificarSubsistemas(){
        for(Subsistema s:subsistemas){
            s.actualizar(this);
        }
    }

    public void agregarSubsistema(Subsistema s){
        this.subsistemas.add(s);
    }

    public void eliminarSubsistema(Subsistema s){
        this.subsistemas.remove(s);
    }

    public void agregarAdjunto(Adjunto a){ this.adjuntos.add(a);}
}
