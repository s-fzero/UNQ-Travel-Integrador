package reservaTest.notificacionTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import reserva.notificacion.*;
import reserva.*;
import reserva.status.*;
import reserva.traslado.TrasladoEstandar;

import java.time.LocalDate;
import java.util.List;

class SubsistemasTest {

    private NotificadorMail notificadorEmail;
    private Generador generadorVoucher;
    private Fidelizacion fidelizacion;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        notificadorEmail = new NotificadorMail();
        generadorVoucher = new Generador();
        fidelizacion = new Fidelizacion();
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
    void testNotificadorEmailActuaEnConfirmada() {
        reserva.agregarSubsistema(notificadorEmail);        //Se agrega el notificador
        List<Adjunto> adjuntos = reserva.getAdjuntos();
        assertTrue(reserva.getAdjuntos().isEmpty());        //Cuando se crea la reserva no tiene ningun adjunto
        reserva.procesarReserva();                          //Se procesa, pasa a Confirmada porque empieza en Pendiente
        assertFalse(reserva.getAdjuntos().isEmpty(), "La lista de adjuntos no debería estar vacía"); //Porque se agrega Mail como adjunto
        assertInstanceOf(Mail.class, reserva.getAdjuntos().getFirst());
    }

    @Test
    void testGeneradorVoucherYComprobanteActuaEnFinalizada() {
        reserva.agregarSubsistema(generadorVoucher);
        List<Adjunto> adjuntos = reserva.getAdjuntos();
        assertTrue(reserva.getAdjuntos().isEmpty());
        reserva.procesarReserva(); //Confirmada
        reserva.procesarReserva(); //Check in
        reserva.procesarReserva(); //En curso
        reserva.procesarReserva(); //Finalizada
        assertFalse(reserva.getAdjuntos().isEmpty(), "La lista de adjuntos no debería estar vacía");
        assertInstanceOf(Comprobante.class, reserva.getAdjuntos().getFirst());
        assertInstanceOf(Voucher.class, reserva.getAdjuntos().getLast());
    }

    @Test
    void testGeneradorVoucherActuaAlCancelar() {
        reserva.agregarSubsistema(generadorVoucher);
        List<Adjunto> adjuntos = reserva.getAdjuntos();
        assertTrue(reserva.getAdjuntos().isEmpty());
        reserva.cancelarReserva();
        assertFalse(reserva.getAdjuntos().isEmpty(), "La lista de adjuntos no debería estar vacía");
        assertInstanceOf(Voucher.class, reserva.getAdjuntos().getFirst());
    }

    @Test
    void testFidelizacionActuaAlCancelar() {
        reserva.agregarSubsistema(fidelizacion);
        List<Adjunto> adjuntos = reserva.getAdjuntos();
        assertTrue(reserva.getAdjuntos().isEmpty());
        reserva.cancelarReserva();
        assertFalse(reserva.getAdjuntos().isEmpty(), "La lista de adjuntos no debería estar vacía");
        assertInstanceOf(Cupon.class, reserva.getAdjuntos().getFirst());
    }

}