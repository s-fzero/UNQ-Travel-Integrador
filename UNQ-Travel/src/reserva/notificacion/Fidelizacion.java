package reserva.notificacion;

import reserva.Reserva;

public class Fidelizacion implements Subsistema{
    Reserva reserva;

    @Override
    public void actualizar(Reserva res) {
        reserva = res;
    }

    public void enviarCupon(){
            Cupon cup = new Cupon("Cupón por cancelación", 0.5);
            reserva.agregarCupon(cup);

    }

}
