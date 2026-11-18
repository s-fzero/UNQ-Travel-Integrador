package catalogo.criterios;

import catalogo.servicios.Servicio;

public class CriterioPorNombre implements CriterioBusqueda{
    private String nombre;

    public CriterioPorNombre(String n) {
        this.nombre = n;
    }

    @Override
    public boolean cumple(Servicio s) {
        return (this.getNombre().equals(s.getNombre()));
    }

    public String getNombre() {
        return this.nombre;
    }
}