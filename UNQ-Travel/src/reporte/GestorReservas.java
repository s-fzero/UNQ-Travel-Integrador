package reporte;

import catalogo.*;
import reserva.Reserva;
import reserva.traslado.MetodoTraslado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public void crearReserva(String mail, int pasajeros, LocalDate fechaTraslado, String destino, MetodoTraslado metodoTraslado) {
        new Reserva(mail, pasajeros, fechaTraslado, destino, metodoTraslado);
    }

    public List<Reserva> reservasFinalizadas() {
        //List<Reserva> reservas =
        return List.of();
    }
}
