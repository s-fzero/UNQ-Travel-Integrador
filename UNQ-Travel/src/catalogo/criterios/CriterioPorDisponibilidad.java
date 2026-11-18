package catalogo.criterios;

import catalogo.servicios.Servicio;

public class CriterioPorDisponibilidad implements CriterioBusqueda{
    public boolean cumple(Servicio s){
        return(s.estaDisponible());
    }
}