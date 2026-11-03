package catalogo;

public class ServicioIndividual extends Servicio{
    private Integer codigoReserva;
    private String nombre;
    private String operador;
    private String categoria;
    private Double precioBase;

    public ServicioIndividual(Integer _codigoReserva,String _nombre,String _operador,String _categoria,Double _precioBase) {
        this.codigoReserva = _codigoReserva;
        this.nombre        = _nombre;
        this.operador      = _operador;
        this.categoria     = _categoria;
        this.precioBase    = _precioBase;
    }

    @Override
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public String getDescripcion(){
        return "this.descripcion";
    }
    @Override
    public Double getPrecioBase(){
        return this.precioBase;
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
