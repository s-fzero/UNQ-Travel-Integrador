package reservaTest.statusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reserva.Reserva;
import reserva.notificacion.*;
import reserva.status.*;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;
import reserva.traslado.TrasladoEstandar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstadosTest {
    private Reserva reserva;

    private final PrintStream salidaOriginal = System.out;  //Para testear el mensaje de salida
    private ByteArrayOutputStream capturaSalida;            //Para testear el mensaje de salida

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

        capturaSalida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturaSalida));
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
    void testReembolsarAlCancelarConfirmada(){
        reserva.procesarReserva();
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());
    }


    @Test
    void testReembolsarAlCancelarCheckIn(){
        reserva.procesarReserva();
        reserva.procesarReserva();
        assertInstanceOf(ReservaCheckIn.class, reserva.getStatus());
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());    }

    @Test
    void testReembolsarAlCancelarEnCurso(){
        reserva.procesarReserva();
        reserva.procesarReserva();
        reserva.procesarReserva();
        assertInstanceOf(ReservaEnCurso.class, reserva.getStatus());
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());
    }

    @Test
    void testNoPuedeCancelarseLaCancelada() {
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());
        reserva.cancelarReserva();
        String salida = capturaSalida.toString();
        assertTrue(salida.contains("Error:"));  //Testeo la excepcion de esta forma porque se ataja
    }

    @Test
    void testNoPuedeProcesarseLaCancelada() {
        reserva.cancelarReserva();
        assertInstanceOf(ReservaCancelada.class, reserva.getStatus());
        reserva.procesarReserva();
        String salida = capturaSalida.toString();
        assertTrue(salida.contains("Error:"));  //Testeo la excepcion de esta forma porque se ataja
    }

    @Test
    void testNoPuedeCancelarseLaFinalizada() {
        reserva.procesarReserva();
        reserva.procesarReserva();
        reserva.procesarReserva();
        reserva.procesarReserva();
        assertInstanceOf(ReservaFinalizada.class, reserva.getStatus());
        reserva.cancelarReserva();
        String salida = capturaSalida.toString();
        assertTrue(salida.contains("Error:"));
    }

    @Test
    void testNoPuedeProcesarseLaFinalizada() {
        reserva.procesarReserva();
        reserva.procesarReserva();
        reserva.procesarReserva();
        reserva.procesarReserva();
        assertInstanceOf(ReservaFinalizada.class, reserva.getStatus());
        reserva.procesarReserva();
        String salida = capturaSalida.toString();
        assertTrue(salida.contains("Error:"));
    }
}
