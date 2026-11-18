package catalogo.Criterios;

public class CriterioPorDisponibilidad implements CriterioBusqueda{
    public boolean cumple(Servicio s){
        return(s.estaDisponible());
    }
}