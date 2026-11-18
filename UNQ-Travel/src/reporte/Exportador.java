package reporte;

//Patron Visitor
//Rol: Visitor
public interface Exportador {
    public void visitarMasReservados(MasReservados m);
    public void visitarCuposTotales(CuposTotales c);
    public void visitarExposicionOperador(ExposicionOperador e);
}
