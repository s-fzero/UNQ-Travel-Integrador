package ar.edu.unq.po2.tpIntegrador;

public class CriterioPorDisponibilidad implements CriterioBusqueda{
    public boolean cumple(Servicio s){
        return(s.estaDisponible());
    }
}