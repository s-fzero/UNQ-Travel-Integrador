package catalogo;

public abstract class Servicio implements Item{
    private String nombre;
    private String descripcion;
    private Double precioBase;

    @Override
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public String getDescripcion(){
        return this.descripcion;
    }
    @Override
    public Double getPrecioBase(){
        return this.precioBase;
    }
}
