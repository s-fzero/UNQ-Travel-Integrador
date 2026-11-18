package catalogo.criterios;

import catalogo.servicios.Servicio;

import java.util.List;

public interface CriterioBusqueda {
    boolean cumple(Servicio s);
}
