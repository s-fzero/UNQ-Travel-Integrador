package reporte;

//Patron Visitor
//Rol: Concrete Element
public class CuposTotales implements Reporte{
    @Override
    public void aceptar(Visitante v) {
        v.visitarCuposTotales(this); //Double dispatch del patron Visitor
    }
}
