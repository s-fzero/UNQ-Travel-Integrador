package reporte;

import catalogo.Catalogo;

//Patron Visitor
//Rol: Concrete Element
public class MasReservados extends Reporte{
    private GestorReservas gestorReservas;

    public MasReservados(Catalogo catalogo, GestorReservas gestor) {
        super(catalogo);
        this.gestorReservas = gestor;
    }

    @Override
    public void aceptar(Exportador v) {
        v.visitarMasReservados(this); //Double dispatch del patron Visitor
    }


}
