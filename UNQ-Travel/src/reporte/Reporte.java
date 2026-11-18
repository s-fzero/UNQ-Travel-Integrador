package reporte;

import catalogo.Catalogo;

public abstract class Reporte {
    private Catalogo catalogo;
    public abstract void aceptar(Exportador v);
    public Reporte(Catalogo catalogo) { this.catalogo = catalogo; }
}
