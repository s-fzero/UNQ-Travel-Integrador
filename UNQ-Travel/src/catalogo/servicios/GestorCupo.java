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

    public boolean estaDisponible(LocalDate fechaDesde, LocalDate fechaHasta) {
        return programaciones.stream().anyMatch(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta));
    }

    public void reservarCupo(LocalDate fechaDesde, LocalDate fechaHasta) {
        programaciones.stream()
                .filter(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta))
                .findFirst()
                .ifPresentOrElse(programacion -> programacion.reservarCupo(),() -> new RuntimeException("Programacion no encontrada"));
    }

    public boolean estaDisponibleEnFechas(Programacion programacion, LocalDate fechaDesde, LocalDate fechaHasta){
        return programacion.getFechaDeInicio().equals(fechaDesde) && programacion.getFechaFinalizacion().equals(fechaHasta);
    }

    public void devolverCupo(LocalDate fechaDesde, LocalDate fechaHasta) {
        programaciones.stream()
                .filter(programacion -> this.estaDisponibleEnFechas(programacion,fechaDesde,fechaHasta))
                .findFirst()
                .ifPresentOrElse(programacion -> programacion.devolverCupo(),() -> new RuntimeException("Programacion no encontrada"));
    }
}
