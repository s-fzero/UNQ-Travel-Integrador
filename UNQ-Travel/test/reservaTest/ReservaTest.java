package reservaTest;

import catalogo.servicios.ServicioIndividual;
import reserva.Reserva;
import reserva.notificacion.*;
import reserva.status.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reserva.status.excepcionStatus.OperacionDeEstadoInvalida;
import reserva.traslado.TrasladoEstandar;
import reserva.traslado.TrasladoVIP;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    private Reserva reserva;
    private ServicioIndividual servicio;
    private ServicioIndividual otroServicio;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaTraslado;

    private TrasladoEstandar te;

    private final PrintStream salidaOriginal = System.out;  //Para testear el mensaje de salida
    private ByteArrayOutputStream capturaSalida;            //Para testear el mensaje de salida

    @BeforeEach
    void setUp() {

        // Setup

        fechaInicio = LocalDate.of(2026, 12, 10);
        fechaFin = LocalDate.of(2026, 12, 20);
        fechaTraslado = LocalDate.of(2026, 12, 9);
        te = new TrasladoEstandar();


        reserva = new Reserva(
                "correo@gmail.com",
                2,
                fechaTraslado,
                fechaInicio,
                fechaFin,
                "Bariloche",
                te
        );

        servicio = new ServicioIndividual(
                "Excursion",
                "Excursion de montaña",
                1500.0,
                1,
                "Operador A",
                "Aventura"
        );

        otroServicio = new ServicioIndividual(
                "Hotel",
                "Alojamiento",
                2500.0,
                2,
                "Operador B",
                "Hospedaje"
        );

    }

    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    @Test
    void reservaSeInicializaCorrectamente() {

        // Setup

        // Exercise
        String correo = reserva.getCorreo();
        int pasajeros = reserva.getCantPasajeros();

        LocalDate traslado = reserva.getFechaTraslado();

        String destino = reserva.getDestinoTraslado();

        // Verify
        assertEquals("correo@gmail.com", correo);
        assertEquals(2, pasajeros);
        assertEquals(fechaTraslado, traslado);
        assertEquals("Bariloche", destino);

        assertInstanceOf(
                ReservaPendiente.class,
                reserva.getStatus()
        );

        assertTrue(reserva.getServicios().isEmpty());
        assertTrue(reserva.getAdjuntos().isEmpty());
    }

    // ==========================================
    // SERVICIOS Y CUPOS
    // ==========================================

    @Test
    void reservarCuposDisminuyeLaCantidadDeCuposDisponibles() {

        // Setup
        servicio.agregarProgramacion(fechaInicio, fechaFin, 2);

        reserva.agregarServicio(servicio);

        // Exercise
        reserva.reservarCupos();

        // Debe seguir disponible porque reserva 2 y tiene 5 cupos
        assertFalse(servicio.estaDisponible(fechaInicio, fechaFin, reserva.getCantPasajeros()));

        assertEquals(0, servicio.cuposDisponibles(fechaInicio, fechaFin));
    }

    @Test
    void devolverCuposIncrementaLaCantidadDeCuposDisponibles() {

        // Setup
        servicio.agregarProgramacion(fechaInicio, fechaFin, 5);

        reserva.agregarServicio(servicio);

        reserva.reservarCupos();

        // Exercise
        reserva.devolverCupos();

        // Verify
        assertEquals(5, servicio.cuposDisponibles(fechaInicio, fechaFin));
    }

    @Test
    void reservarCuposReservaTodosLosServicios() {

        // Setup
        servicio.agregarProgramacion(fechaInicio, fechaFin, 5);
        otroServicio.agregarProgramacion(fechaInicio, fechaFin, 8);

        reserva.agregarServicio(servicio);
        reserva.agregarServicio(otroServicio);

        // Exercise
        reserva.reservarCupos();

        // Verify
        assertEquals(3, servicio.cuposDisponibles(fechaInicio, fechaFin));
        assertEquals(6, otroServicio.cuposDisponibles(fechaInicio, fechaFin));
    }

    @Test
    void devolverCuposDevuelveTodosLosServicios() {

        // Setup
        servicio.agregarProgramacion(fechaInicio, fechaFin, 5);
        otroServicio.agregarProgramacion(fechaInicio, fechaFin, 8);

        reserva.agregarServicio(servicio);
        reserva.getServicios().add(otroServicio);

        reserva.reservarCupos();

        // Exercise
        reserva.devolverCupos();

        // Verify
        assertEquals(5, servicio.cuposDisponibles(fechaInicio, fechaFin));
        assertEquals(8, otroServicio.cuposDisponibles(fechaInicio, fechaFin));
    }

    @Test
    void cobrarServiciosDevuelveLaSumaDeSusPrecios() {

        // Setup
        reserva.agregarServicio(servicio);
        reserva.getServicios().add(otroServicio);

        // Exercise
        double total = reserva.cobrarServicios();

        // Verify
        assertEquals(4000.0, total, 0.001);
    }

    @Test
    void cobrarServiciosSinServiciosDevuelveCero() {

        // Setup

        // Exercise
        double total = reserva.cobrarServicios();

        // Verify
        assertEquals(0.0, total, 0.001);
    }

    @Test
    void reembolsarReservaDevuelveElTotalDeLosServicios() {

        // Setup
        reserva.agregarServicio(servicio);
        reserva.getServicios().add(otroServicio);

        // Exercise
        double total = reserva.reembolsarReserva();

        // Verify
        assertEquals(4000.0, total, 0.001);
    }

    @Test
    void noPuedeDisfrutarseServicioSiNoEstaEnCurso(){
        reserva.agregarServicio(servicio);
        OperacionDeEstadoInvalida ex = assertThrows(
                OperacionDeEstadoInvalida.class,
                () -> reserva.disfrutarServicio(servicio)
        );
        assertTrue(reserva.getServicios().contains(servicio));
    }

    @Test
    void testDisfrutarServicioValidoMueveServicioAHistorial(){
        reserva.agregarServicio(servicio); // ajustá al nombre real de tu método si tiene otro
        reserva.procesarReserva(); //Confirmada
        reserva.procesarReserva(); //Check in
        reserva.procesarReserva(); //EN CURSO

        reserva.disfrutarServicio(servicio);

        assertFalse(reserva.getServicios().contains(servicio));
        assertTrue(reserva.getHistorialServicios().contains(servicio));
    }

}