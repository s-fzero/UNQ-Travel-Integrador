package reserva.traslado;

public class AdapterTrasladoEstandar {
    private PlataformaTransporte plataforma;

    public double estimarTraslado(int cantidadPasajeros, String destino) {
        float estimacion = plataforma.estimarTraslado(cantidadPasajeros, destino);
        double e = (double) estimacion;
        return e;
    }

    public void setPlataforma(PlataformaTransporte pt) {
        this.plataforma = pt;
    }
}
