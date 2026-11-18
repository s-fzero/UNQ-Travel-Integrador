package catalogo.servicios;

import catalogo.atributos.AtributoDinamico;

import java.util.List;

public class ServicioIndividual extends Servicio {
    private Integer codigoReserva;
    private Double precioBase;
    private String operador;
    private String categoria;
    private List<AtributoDinamico> atributos;


    public ServicioIndividual(String nombre, String descripcion, Double precioBase , Integer codigoReserva, String operador, String categoria) {
        super(nombre, descripcion);
        this.precioBase = precioBase;
        this.codigoReserva = codigoReserva;
        this.operador      = operador;
        this.categoria     = categoria;
    }

    public List<AtributoDinamico> getAtributos() {
        return this.atributos;
    }

    public double getPrecio(){
        return this.precioBase;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getOperador() {
        return this.operador;
    }

    public Integer getCodigoReserva() {
        return this.codigoReserva;
    }
}
