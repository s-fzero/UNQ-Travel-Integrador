package reporte;

import catalogo.Catalogo;

//Patron Visitor
//Rol: Concrete Element
public class ExposicionOperador extends Reporte{
    public ExposicionOperador(Catalogo catalogo) {
        super(catalogo);
    }

    @Override
    public void aceptar(Exportador v) {
        v.visitarExposicionOperador(this); //Double dispatch del patron Visitor
    }
}
