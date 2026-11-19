package catalogo.criterios;

import catalogo.Catalogo;
import catalogo.servicios.Servicio;

import java.util.List;

public class Buscador {
    private CriterioBusqueda criterio;
    private Catalogo catalogo;

    public Buscador(CriterioBusqueda criterio, Catalogo catalogo) {
        this.criterio = criterio;
        this.catalogo = catalogo;
    }

    public List<Servicio> buscarServicios() {
        return catalogo.getServicios().stream().filter(criterio::cumple).toList();
    }

    public void setCriterio(CriterioBusqueda c){criterio = c;}
}
