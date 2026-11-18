package catalogo.criterios;

import catalogo.servicios.Servicio;

public class CriterioNot implements CriterioBusqueda{
    private CriterioBusqueda criterio;

    public CriterioNot(CriterioBusqueda criterio) {
        this.criterio = criterio;
    }

    public CriterioBusqueda getCriterio() {
        return criterio;
    }

    @Override
    public boolean cumple(Servicio s){
        return(!criterio.cumple(s));
    }
}
