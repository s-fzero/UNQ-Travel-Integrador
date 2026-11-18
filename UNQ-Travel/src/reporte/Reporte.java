package reporte;

import catalogo.Catalogo;

import java.time.LocalDate;

public abstract class Reporte {
    private Catalogo catalogo;
    private LocalDate periodoInicio;
    private LocalDate periodoFin;
    public abstract void aceptar(Exportador v);
    public Reporte(Catalogo catalogo, LocalDate inicio, LocalDate fin) {
        this.catalogo = catalogo;
        this.periodoInicio = inicio;
        this.periodoFin = fin;
    }
}
