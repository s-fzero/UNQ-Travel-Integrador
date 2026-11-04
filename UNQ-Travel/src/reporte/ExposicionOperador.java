package reporte;

//Patron Visitor
//Rol: Concrete Element
public class ExposicionOperador implements Reporte{
    @Override
    public void aceptar(Visitante v) {
        v.visitarExposicionOperador(this); //Double dispatch del patron Visitor
    }
}
