package catalogo.Criterios;

import catalogo.servicios.Servicio;

public class CriterioPorPrecio implements CriterioBusqueda {
    private double precio;

    public CriterioPorPrecio(double v) {
        this.precio = v;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean cumple(Servicio s){
        return(this.getPrecio() >= s.getPrecio());
    }
}
