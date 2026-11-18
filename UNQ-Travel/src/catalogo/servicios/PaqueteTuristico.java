package catalogo.servicios;

import java.util.ArrayList;
import java.util.List;

public final class PaqueteTuristico extends Servicio{
    private Double descuento;
    private List<Servicio> servicios;   // los servicios dentro deben tener programaciones que esten dentro de las programaciones de paquete turistico.

    public PaqueteTuristico(String nombre, String descripcion, Double descuento, List<Servicio> servicios) {
        super(nombre, descripcion);
        this.descuento = descuento;
        this.servicios = servicios;
    }

    public PaqueteTuristico(String nombre, String descripcion, Double descuento) {
        super(nombre, descripcion);
        this.descuento = descuento;
        this.servicios = new ArrayList<>();
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void agregarServicio(Servicio servicio){
        this.getServicios().add(servicio);
    }

    public void eliminarServicio(Servicio servicio){
        this.getServicios().remove(servicio);
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
