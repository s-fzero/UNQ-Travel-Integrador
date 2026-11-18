package reporte;

import catalogo.Catalogo;
import reserva.Reserva;

public class GestorReservas {
    private Catalogo catalogo;
    private GestorReservas gestor;

    public GestorReservas(Catalogo catalogo, GestorReservas gestor) {
        this.catalogo = catalogo;
        this.gestor = gestor;
    }

    public void crearReserva(String mail){
        new Reserva(catalogo,gestor,mail);
    }
}
