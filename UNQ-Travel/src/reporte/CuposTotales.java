package reporte;

import catalogo.Catalogo;

//Patron Visitor
//Rol: Concrete Element
public class CuposTotales extends Reporte{
    public CuposTotales(Catalogo catalogo) {
        super(catalogo);
    }

    @Override
    public void aceptar(Exportador v) {
        v.visitarCuposTotales(this); //Double dispatch del patron Visitor
    }
}
