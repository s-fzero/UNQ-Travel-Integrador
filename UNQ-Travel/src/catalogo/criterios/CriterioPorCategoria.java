package catalogo.criterios;

import catalogo.servicios.Servicio;
import catalogo.servicios.ServicioIndividual;

public class CriterioPorCategoria implements CriterioBusqueda {
    private String categoria;

    public CriterioPorCategoria(String c) {
        this.categoria = c;
    }

    public String getCategoria() {
        return this.categoria;
    }

    @Override
    public boolean cumple(Servicio s){
        return(s instanceof ServicioIndividual individual && individual.getCategoria() == categoria);
    }
}
