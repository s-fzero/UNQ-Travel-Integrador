package catalogo;

import catalogo.servicios.Servicio;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Servicio> services;

    public Catalogo() {
        this.services = new ArrayList<>();
    }

    public List<Servicio> getServicios() {
        return services;
    }

    public void agregarItem(Servicio servicio){
        this.getServicios().add(servicio);
    }
    public void eliminarItem(Servicio servicio){
        //this.getServicios().removeIf(item -> item.getNombre().equals(servicio.getNombre()));
        this.getServicios().remove(servicio);
    }

}
