package catalogo.servicios;

import java.time.LocalDate;

public abstract class Servicio {
    private String nombre;
    private String descripcion;
    private GestorCupo gestorCupo;

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gestorCupo = new GestorCupo();
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract double getPrecio();

    public String getDescripcion() {
        return this.descripcion;
    }

    public boolean estaDisponible(LocalDate fechaDesde, LocalDate fechaHasta) {
        return gestorCupo.estaDisponible(fechaDesde,fechaHasta);
    }

    public void agregarProgramacion(LocalDate fechaDeIncio, LocalDate fechaFinalizacion, Integer cantCupos){
        gestorCupo.agregarProgramacion(fechaDeIncio,fechaFinalizacion,cantCupos);
    }

    public void reservarCupo(LocalDate fechaDesde, LocalDate fechaHasta){
        if (this.estaDisponible(fechaDesde,fechaHasta)){
            gestorCupo.reservarCupo(fechaDesde,fechaHasta);
        }
    }

    public void devolverCupo(LocalDate fechaDesde, LocalDate fechaHasta){
        gestorCupo.devolverCupo(fechaDesde,fechaHasta);
    }

//    public transferir(int monto){
//        this.transferenciaInmediata();
//    }
//    public transferir(int monto, LocalDate dia){
//        this.transferenciaProgramada();
//    }
}
