package catalogo.criterios;

import catalogo.servicios.Servicio;

import java.time.LocalDate;

public class CriterioPorDisponibilidad implements CriterioBusqueda{
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private int cupos;

    public CriterioPorDisponibilidad(LocalDate fechaDesde, LocalDate fechaHasta, int cupos){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.cupos = cupos;
    }

    public boolean cumple(Servicio s){
        return(s.estaDisponible(fechaDesde,fechaHasta, cupos));
    }
}