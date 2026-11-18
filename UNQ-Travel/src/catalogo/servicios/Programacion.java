package catalogo.servicios;

import java.time.LocalDate;

public final class Programacion {
    private LocalDate fechaDeInicio;
    private LocalDate fechaFinalizacion;
    private Integer cantCuposDisponibles;

    public Programacion(LocalDate fechaDeIncio, LocalDate fechaFinalizacion, Integer cantCupos) {
        this.fechaDeInicio = fechaDeIncio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.cantCuposDisponibles = cantCupos;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void reservarCupo() {

    }
}
