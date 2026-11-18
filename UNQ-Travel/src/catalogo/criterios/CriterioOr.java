package catalogo.criterios;

import catalogo.servicios.Servicio;

import java.util.ArrayList;
import java.util.List;

public class CriterioOr implements CriterioBusqueda {
    private List<CriterioBusqueda> criterios;

    public CriterioOr() {
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
        return(i > 0);
    }
}
