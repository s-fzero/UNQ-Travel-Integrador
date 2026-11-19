package reservaTest.notificacionTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reserva.Reserva;
import reserva.notificacion.*;
import reserva.traslado.TrasladoEstandar;

import java.time.LocalDate;
import java.util.Date;

import static org.mockito.Mockito.mock;

public class AdjuntosTest {
    private Cupon cupon;
    private Comprobante comprobante;
    private Voucher voucher;
    private Mail mail;
    private Reserva reserva;
    private Date fecha;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        reserva = mock(Reserva.class);
        cupon = new Cupon("descuento", fecha, 0.5);
        comprobante = new Comprobante("pago", fecha, reserva);
        voucher = new Voucher("reembolso", fecha, reserva);
        mail = new Mail("mensaje", fecha, "random@mail", "hola", null);
    }

    @Test
    void testGetters(){
        assertEquals("descuento", cupon.getTitulo());
        assertEquals("pago", comprobante.getTitulo());
        assertEquals("reembolso", voucher.getTitulo());
        assertEquals("mensaje", mail.getTitulo());

        assertEquals(fecha, cupon.getFecha());
        assertEquals(fecha, comprobante.getFecha());
        assertEquals(fecha, voucher.getFecha());
        assertEquals(fecha, mail.getFecha());

        assertEquals(0.5, cupon.getDescuento());
    }
}
