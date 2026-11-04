package reporte;

//Patron Visitor
//Rol: Concrete Element
public class MasReservados implements Reporte{
    @Override
    public void aceptar(Visitante v) {
        v.visitarMasReservados(this); //Double dispatch del patron Visitor
    }
}
