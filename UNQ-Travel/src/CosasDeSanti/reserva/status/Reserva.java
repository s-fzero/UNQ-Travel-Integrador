package ar.edu.unq.po2.tpIntegrador.reserva.status;

import ar.edu.unq.po2.tpIntegrador.MetodoTraslado;
import ar.edu.unq.po2.tpIntegrador.Servicio;
import ar.edu.unq.po2.tpIntegrador.reserva.notificacion.Adjunto;
import ar.edu.unq.po2.tpIntegrador.reserva.notificacion.Subsistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String correo;
    private List<Servicio> servicios;          // Lista de servicios por disfrutar. Una vez disfrutados, pasan a historialServicios
    private List<Servicio> historialServicios; // Lista de servicios disfrutados
    private List<Subsistema> subsistemas;      // Lista de observers
    private List<Adjunto> adjuntos;            // Para guardar los archivos adjuntos que recibe de subsistemas
    private ReservaStatus status;              // Estado de la reserva
    private int cantPasajeros;
    private LocalDate fechaTraslado;
    private String destinoTraslado;
    private MetodoTraslado metodoTraslado;

    public Reserva(String destinoTraslado,
                   int cantPasajeros,
                   LocalDate fechaTraslado,
                   MetodoTraslado metodoTraslado) {
        this.cantPasajeros = cantPasajeros;
        this.fechaTraslado = fechaTraslado;
        this.destinoTraslado = destinoTraslado;
        this.metodoTraslado = metodoTraslado;
        adjuntos = new ArrayList<Adjunto>();
        servicios = new ArrayList<Servicio>();
        historialServicios = new ArrayList<Servicio>();
        subsistemas = new ArrayList<Subsistema>();
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

    public Reserva() {
        this.status = new ReservaPendiente();  // La reserva empieza en estado "Solicitud pendiente"
    }

    // GETTERS
    public String getCorreo() {
        return this.correo;
    }

    public List<Servicio> getServicios() {
        return this.servicios;
    }

    private List<Servicio> getHistorialServicios() {
        return this.historialServicios;
    }

    public ReservaStatus getStatus() {
        return this.status;
    }
    //

    public void cambiarEstado(ReservaStatus nuevoEstado) {
        this.status = nuevoEstado;
    }

    public void procesarReserva() {
        this.status.procesarReserva(this);
    }

    public void cancelarReserva() {
        this.notificarSubsistemas();
        this.status.cancelarReserva(this);
    }

    public void reservarCupos() {
        this.getServicios().forEach(Servicio::reservarCupo);
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

    public void notificarSubsistemas() {
        for (Subsistema s : subsistemas) {
            s.actualizar(this);
        }
    }

    public void agregarSubsistema(Subsistema s) {
        this.subsistemas.add(s);
    }

    public void eliminarSubsistema(Subsistema s) {
        this.subsistemas.remove(s);
    }

    public void agregarAdjunto(Adjunto a) {
        this.adjuntos.add(a);
    }
}
