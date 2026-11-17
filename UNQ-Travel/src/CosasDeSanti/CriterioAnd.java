package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.List;

public class CriterioAnd implements CriterioBusqueda {
    private List<CriterioBusqueda> criterios;

    public CriterioAnd() {
        this.criterios = new ArrayList<>();
    }

    public List<CriterioBusqueda> getCriterios() {
        return criterios;
    }

    @Override
    public boolean cumple(Servicio s){
        int i = 0;
        for(CriterioBusqueda cb : criterios){
            if(cb.cumple(s)){
                i++;
            }
        }
        return(i == criterios.size());
    }
}
