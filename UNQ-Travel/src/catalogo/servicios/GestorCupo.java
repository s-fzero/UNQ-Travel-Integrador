package catalogo.servicios;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class GestorCupo {
    private List<Programacion> programaciones;

    public GestorCupo() {
        this.programaciones = new ArrayList<>();
    }

    public void agregarProgramacion(LocalDate fechaDeIncio, LocalDate fechaFinalizacion, Integer cantCupos){
        programaciones.add(new Programacion(fechaDeIncio,fechaFinalizacion,cantCupos));
    }

    public boolean estaDisponible(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos) {
        return programaciones.stream().anyMatch(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta)
                                                                            && this.tieneCuposDisponibles(cantCupos, programacion));
    }

    public void reservarCupo(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos) {
        programaciones.stream()
                .filter(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta) && this.tieneCuposDisponibles(cantCupos, programacion))
                .findFirst()
                .ifPresentOrElse(programacion -> programacion.reservarCupo(cantCupos),() -> new RuntimeException("Programacion no encontrada"));
    }

    public boolean estaDisponibleEnFechas(Programacion programacion, LocalDate fechaDesde, LocalDate fechaHasta){
        return programacion.getFechaDeInicio().equals(fechaDesde)
                && programacion.getFechaFinalizacion().equals(fechaHasta);
    }

    public void devolverCupo(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos) {
        programaciones.stream()
                .filter(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta) && this.tieneCuposDisponibles(cantCupos, programacion))
                .findFirst()
                .ifPresentOrElse(programacion -> programacion.devolverCupo(cantCupos),() -> new RuntimeException("Programacion no encontrada"));
    }

    public Integer cuposDisponibles(LocalDate fechaDesde, LocalDate fechaHasta) {
        return programaciones.stream()
                .filter(programacion -> estaDisponibleEnFechas(programacion, fechaDesde, fechaHasta))
                .findFirst()
                .map(Programacion::getCantCuposDisponibles)
                .orElseThrow(() -> new IllegalStateException("No hay servicio con esas fechas"));
    }

    public boolean tieneCuposDisponibles(int cantCupos, Programacion prog){
        return prog.getCantCuposDisponibles()>=cantCupos;
    }
}
