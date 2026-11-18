package reporte;

import catalogo.*;
import reserva.Reserva;
import reserva.traslado.MetodoTraslado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public void crearReserva(String mail, int pasajeros, LocalDate inicio, LocalDate fin, LocalDate fechaTraslado, String destino, MetodoTraslado metodoTraslado) {
        reservas.add(new Reserva(mail, pasajeros, fechaTraslado, inicio, fin, destino, metodoTraslado));
    }

    public List<Reserva> reservasFinalizadas() {
        return this.reservas.stream().filter(reserva -> reserva.getStatus().estaFinalizada()).toList();
    }
}
