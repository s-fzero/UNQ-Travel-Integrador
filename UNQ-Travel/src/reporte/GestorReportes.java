package reporte;

import catalogo.Catalogo;
import reserva.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorReportes {
    private Catalogo catalogo;
    private List<Reporte> reportes = new ArrayList<>();

    public GestorReportes(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void agregarReporte(Reporte reporte) {
        reportes.add(reporte);
    }

    public void eliminarReporte(Reporte r){
        reportes.remove(r);
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void exportarMasReservados(Exportador e, MasReservados r){
        e.visitarMasReservados(r);
    }

    public void exportarCuposTotales(Exportador e, CuposTotales r){
        e.visitarCuposTotales(r);
    }

    public void exportarExposicionOperador(Exportador e, ExposicionOperador r){
        e.visitarExposicionOperador(r);
    }
}
