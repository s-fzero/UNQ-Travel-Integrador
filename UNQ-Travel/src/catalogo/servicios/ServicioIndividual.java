package catalogo.servicios;

import catalogo.atributos.AtributoDinamico;

import java.util.List;

public class ServicioIndividual extends Servicio{
    private Integer codigoReserva;
    private Double precioBase;
    private String operador;
    private String categoria;
    private List<AtributoDinamico> atributos;


    public ServicioIndividual(String nombre,String descripcion,Double precioBase ,Integer codigoReserva, String operador, String categoria) {
        super(nombre,descripcion);
        this.precioBase    = precioBase;
        this.codigoReserva = codigoReserva;
        this.operador      = operador;
        this.categoria     = categoria;
    }

    public List<AtributoDinamico> getAtributos() {
        return atributos;
    }

    public Double getPrecio(){
        return precioBase;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getOperador() {
        return operador;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }
}
