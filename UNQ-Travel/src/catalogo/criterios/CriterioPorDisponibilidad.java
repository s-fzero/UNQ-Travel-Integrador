package catalogo.criterios;

import catalogo.servicios.Servicio;

import java.time.LocalDate;

public class CriterioPorDisponibilidad implements CriterioBusqueda{
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

    public CriterioPorDisponibilidad(LocalDate fechaDesde, LocalDate fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public boolean cumple(Servicio s){
        return(s.estaDisponible(fechaDesde,fechaHasta));
    }
}