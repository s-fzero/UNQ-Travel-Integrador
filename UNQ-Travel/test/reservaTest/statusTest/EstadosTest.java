package reservaTest.statusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reserva.Reserva;
import reserva.notificacion.*;
import reserva.status.*;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;
import reserva.traslado.TrasladoEstandar;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstadosTest {
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        reserva = new Reserva(
                "cliente@test.com",
                2,
                LocalDate.now().plusDays(2),
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                "Aeropuerto",
                new TrasladoEstandar());
    }

    @Test
    void testCicloDeVida() {
        assertInstanceOf(ReservaPendiente.class, reserva.getStatus());

        reserva.procesarReserva();
        assertInstanceOf(ReservaConfirmada.class, reserva.getStatus());

        reserva.procesarReserva();
        assertInstanceOf(ReservaCheckIn.class, reserva.getStatus());

        reserva.procesarReserva();
        assertInstanceOf(ReservaEnCurso.class, reserva.getStatus());

        reserva.procesarReserva();
        assertInstanceOf(ReservaFinalizada.class, reserva.getStatus());
    }

    @Test
    void testNoPuedeCancelarseLaCancelada() {
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());

    }
}
