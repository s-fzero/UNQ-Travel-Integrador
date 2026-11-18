package reservaTest.notificacionTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import reserva.notificacion.*;
import reserva.*;
import reserva.status.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class SubsistemasTest {

    private MailSender mailSenderMock;
    private NotificadorMail notificadorEmail;
    private Generador generadorVoucher;
    private Fidelizacion fidelizacion;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        mailSenderMock = mock(MailSender.class);
        notificadorEmail = new NotificadorMail();
        generadorVoucher = new Generador(); // o mock si requiere dependencias
        fidelizacion = new Fidelizacion();
        reserva = new Reserva(
                "cliente@test.com",
                2,
                any(),
                any(),
                any(),
                "Aeropuerto",
                any());
    }

    @Test
    void testNotificadorEmailActuaEnConfirmada() {
        reserva.agregarSubsistema(notificadorEmail);

        // Transición a Confirmada (según tu State)
        reserva.procesarReserva();

        // Verifica que se invoca el mail sender con los parámetros exactos del UML
        verify(mailSenderMock, times(1)).enviarMail(eq("cliente@test.com"), anyString(), anyString(), isNull());
    }

    @Test
    void testGeneradorVoucherActuaEnFinalizada() {
        List<Adjunto> adjuntos = reserva.getAdjuntos();
        assertTrue(reserva.getAdjuntos().isEmpty());
        reserva.procesarReserva();
        generadorVoucher.actualizar(reserva);
        assertFalse(reserva.getAdjuntos().isEmpty(), "La lista de adjuntos no debería estar vacía");
    }

    @Test
    void testFidelizacionActuaAlCancelar() {
        reserva.agregarSubsistema(fidelizacion);

        // Cancelar la reserva
        reserva.cancelarReserva();

        // Verifica que Fidelizacion envía el mail con el cupón del 5%
        verify(mailSenderMock, times(1)).enviarMail(
                eq("cliente@test.com"),
                anyString(),
                contains("5%"),
                isNull()
        );
    }
}