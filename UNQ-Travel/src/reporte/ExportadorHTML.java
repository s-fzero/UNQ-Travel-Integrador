package reporte;

//Patron Visitor
//Rol: Concrete Visitor
public class ExportadorHTML implements Exportador {
    @Override
    public void visitarMasReservados(MasReservados m) {
        System.out.println("Exportando Reporte Más Reservados a HTML...");
    }

    @Override
    public void visitarCuposTotales(CuposTotales c) {
        System.out.println("Exportando Reporte Cupos Totales a HTML...");
    }

    @Override
    public void visitarExposicionOperador(ExposicionOperador e) {
        System.out.println("Exportando Reporte por Exposición Operador a HTML...");
    }
}
