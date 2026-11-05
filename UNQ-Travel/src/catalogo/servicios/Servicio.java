package catalogo.servicios;

public abstract class Servicio implements Item{
    private String nombre;
    private String descripcion;

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public String getDescripcion(){
        return this.descripcion;
    }
    @Override
    public abstract Double getPrecio();
}
