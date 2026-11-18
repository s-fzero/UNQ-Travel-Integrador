package reserva;

import catalogo.servicios.Servicio;
import reserva.notificacion.Adjunto;
import reserva.notificacion.Subsistema;

import reserva.status.*;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;
import reserva.traslado.MetodoTraslado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String correo;
    private int cantPasajeros;
    private LocalDate fechaTraslado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String destinoTraslado;
    private MetodoTraslado metodoTraslado;

    private List<Servicio> servicios = new ArrayList<>();         // Lista de servicios por disfrutar. Una vez disfrutados, pasan a historialServicios
    private List<Servicio> historialServicios = new ArrayList<>(); // Lista de servicios disfrutados
    private List<Subsistema> subsistemas = new ArrayList<>();    // Lista de observers
    private List<Adjunto> adjuntos = new ArrayList<>();            // Para guardar los archivos adjuntos que recibe de subsistemas
    private ReservaStatus status = new ReservaPendiente();                // Estado de la reserva empieza en Pendiente

    public Reserva(String correo,
                   int cantPasajeros,
                   LocalDate fechaTraslado,
                   LocalDate fechaInicio,
                   LocalDate fechaFin,
                   String destinoTraslado,
                   MetodoTraslado metodoTraslado) {
        this.correo = correo;
        this.cantPasajeros = cantPasajeros;
        this.fechaTraslado = fechaTraslado;
        this.destinoTraslado = destinoTraslado;
        this.metodoTraslado = metodoTraslado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public LocalDate getFechaTraslado() {
        return fechaTraslado;
    }

    public String getDestinoTraslado() {
        return destinoTraslado;
    }

    public MetodoTraslado getMetodoTraslado() {
        return metodoTraslado;
    }

    public void setMetodoTraslado(MetodoTraslado metodoTraslado) {
        this.metodoTraslado = metodoTraslado;
    }

    // GETTERS
    public String getCorreo() { return this.correo; }
    public List<Servicio> getServicios() { return this.servicios; }
    private List<Servicio> getHistorialServicios() { return this.historialServicios; }
    public ReservaStatus getStatus() { return this.status;}
    //

    public void cambiarEstado(ReservaStatus nuevoEstado) { this.status = nuevoEstado; }

    public void procesarReserva(){
        this.notificarSubsistemas();
        try {
            this.status.procesarReserva(this);
        } catch (OperacionDeEstadoInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelarReserva(){
        this.notificarSubsistemas();
        try {
            this.status.cancelarReserva(this);
        } catch (OperacionDeEstadoInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void reservarCupos() {
        this.getServicios().forEach(servicio -> servicio.reservarCupo(fechaInicio, fechaFin));
    }

    public void devolverCupos(){
        this.getServicios().forEach(servicio -> servicio.devolverCupo(fechaInicio, fechaFin));
    }

    public double cobrarServicios() {
        return this.getServicios().stream().mapToDouble(servicio -> servicio.getPrecio()).sum();
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
