package catalogo.Criterios;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
