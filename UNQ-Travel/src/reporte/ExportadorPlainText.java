package reporte;

//Patron Visitor
//Rol: Concrete Visitor
public class ExportadorPlainText implements Exportador {
    @Override
    public void visitarMasReservados(MasReservados m) {
        System.out.println("Exportando Reporte Más Reservados a PlainText...");
    }

    @Override
    public void visitarCuposTotales(CuposTotales c) {
        System.out.println("Exportando Reporte Cupos Totales a PlainText...");
    }

    @Override
    public void visitarExposicionOperador(ExposicionOperador e) {
        System.out.println("Exportando Reporte por Exposición Operador a PlainText...");
    }
}
