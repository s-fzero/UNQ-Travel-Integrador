package ar.edu.unq.po2.tpIntegrador;

public abstract class Servicio {
    private String nombre;
    private String descripcion;

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract double getPrecio();

    public String getDescripcion() {
        return this.descripcion;
    }

    public boolean estaDisponible(){
        return true;            //CAMBIAR; SE DEBE CHEQUEAR SI HAY O NO CUPOS!!!!!!!
    }

    public void reservarCupo(){}

//    public transferir(int monto){
//        this.transferenciaInmediata();
//    }
//    public transferir(int monto, date dia){
//        this.transferenciaProgramada();
//    }
}
