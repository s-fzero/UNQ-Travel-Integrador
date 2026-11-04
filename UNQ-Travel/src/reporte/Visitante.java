package reporte;

//Patron Visitor
//Rol: Visitor
public interface Visitante {
    public void visitarMasReservados(MasReservados m);
    public void visitarCuposTotales(CuposTotales c);
    public void visitarExposicionOperador(ExposicionOperador e);
}
