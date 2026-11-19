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

    public boolean estaDisponible(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos) {
        return gestorCupo.estaDisponible(fechaDesde,fechaHasta, cantCupos);
    }

    public void agregarProgramacion(LocalDate fechaDeIncio, LocalDate fechaFinalizacion, Integer cantCupos){
        gestorCupo.agregarProgramacion(fechaDeIncio,fechaFinalizacion,cantCupos);
    }

    public void reservarCupo(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos){
        if (this.estaDisponible(fechaDesde,fechaHasta, cantCupos)){
            gestorCupo.reservarCupo(fechaDesde,fechaHasta, cantCupos);
        }
    }

    public void devolverCupo(LocalDate fechaDesde, LocalDate fechaHasta, int cantCupos){
        gestorCupo.devolverCupo(fechaDesde,fechaHasta, cantCupos);
    }

    public Integer cuposDisponibles(LocalDate fechaDesde, LocalDate fechaHasta) {
        return gestorCupo.cuposDisponibles(fechaDesde, fechaHasta);
    }
//    public transferir(int monto){
//        this.transferenciaInmediata();
//    }
//    public transferir(int monto, LocalDate dia){
//        this.transferenciaProgramada();
//    }
}
