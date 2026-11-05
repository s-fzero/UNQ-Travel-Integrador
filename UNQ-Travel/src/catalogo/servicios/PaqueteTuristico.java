package catalogo.servicios;

import java.util.List;

public final class PaqueteTuristico extends Servicio{
    private Double descuento;
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
    }
    @Override
    public Double getPrecio(){
        return this.getServicios().stream().mapToDouble(Servicio::getPrecio).sum() * this.getDescuento();
    }

    public Double setDescuento(Double descuento){
        return this.descuento = descuento;
    }

    private Double getDescuento() {
        return descuento;
    }
}
