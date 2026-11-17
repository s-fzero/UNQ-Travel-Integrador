package ar.edu.unq.po2.tpIntegrador;
//ARRIBA MÍO; ABAJO COPIADO
package catalogo;

import catalogo.servicios.Servicio;
//ESTOS DOS IMPORT LOS COMPARTIMOS :D
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

    public List<Servicio> buscarServicio(CriterioBusqueda cb) {
        return services.stream().filter(cb::cumple).toList();
        //equivalente a:
        //List<Servicio> servicios = new ArrayList<>();
        //for(s : services){
        //  if(cb.cumple(s){
        //    servicios.add(s);
        //  }
        //}
        //return servicios;
    }
}

