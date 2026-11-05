package catalogo;

import catalogo.servicios.Item;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Item> services;

    public Catalogo() {
        this.services = new ArrayList<>();
    }

    public List<Item> getServicios() {
        return services;
    }

    public void agregarItem(Item servicio){
        this.getServicios().add(servicio);
    }
    public void eliminarItem(Item servicio){
        //this.getServicios().removeIf(item -> item.getNombre().equals(servicio.getNombre()));
        this.getServicios().remove(servicio);
    }

}
