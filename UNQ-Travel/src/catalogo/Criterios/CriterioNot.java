package ar.edu.unq.po2.tpIntegrador;

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
