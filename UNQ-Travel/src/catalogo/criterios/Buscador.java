package catalogo.criterios;

import catalogo.Catalogo;
import catalogo.servicios.Servicio;

import java.util.List;

public class Buscador {
    private CriterioBusqueda criterio;
    private Catalogo catalogo;
    private List<Servicio> servicios = catalogo.getServicios();

    public Buscador(CriterioBusqueda criterio, Catalogo catalogo) {
        this.criterio = criterio;
        this.catalogo = catalogo;
    }

    public List<Servicio> buscarServicios() {
        return servicios.stream().filter(criterio::cumple).toList();
    }
}
