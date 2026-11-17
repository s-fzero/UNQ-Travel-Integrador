package ar.edu.unq.po2.tpIntegrador;
//ARRIBA LO MÍO; ABAJO COPIADO

package catalogo.servicios;

import java.util.ArrayList;
import java.util.List;

public final class PaqueteTuristico extends Servicio{
    private double descuento;
    private List<Servicio> servicios;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void agregarServicio(Servicio servicio){
        this.getServicios().add(servicio);
    }

    public void eliminarServicio(Servicio servicio){
        this.getServicios().remove(servicio);
    }

    public PaqueteTuristico(String nombre, String descripcion, Double descuento) {
        super(nombre, descripcion);
        this.descuento = descuento;
        servicios = new ArrayList<Servicio>();
    }
    @Override
    public double getPrecio(){
        return this.getServicios().stream().mapToDouble(Servicio::getPrecio).sum() * this.getDescuento();
    }

    public double setDescuento(double descuento){
        return this.descuento = descuento;
    }

    private double getDescuento() {
        return 1 - descuento;
    }
}
