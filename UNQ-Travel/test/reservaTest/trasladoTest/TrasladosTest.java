package reservaTest.trasladoTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reserva.notificacion.*;
import reserva.traslado.*;
import reserva.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrasladosTest {
    private TrasladoEstandar te;
    private TrasladoVIP tv;
    private TrasladoPuntoEncuentro tpe;
    private Reserva r;
    private Reserva r2;
    private Reserva r3;
    private AdapterTrasladoEstandar ate;
    private PlataformaTransporte pt;

    @BeforeEach
    public void setUp(){
        te = new TrasladoEstandar();
        tv = new TrasladoVIP(0.10, 500d);
        tpe = new TrasladoPuntoEncuentro("Leeds", 0);
        r = new Reserva("cliente1@gmail",
                3,
                LocalDate.of(1987, 10, 31),
                LocalDate.of(1987, 10, 31),
                LocalDate.of(1987, 11, 3),
                "York",
                te);
        r2 = new Reserva("cliente2@gmail",
                5,
                LocalDate.of(2015, 10, 31),
                LocalDate.of(2015, 10, 31),
                LocalDate.of(2015, 11, 3),
                "Liverpool",
                tv);
        r3 = new Reserva("cliente2@gmail",
                1,
                LocalDate.of(2008, 10, 31),
                LocalDate.of(2008, 10, 31),
                LocalDate.of(2008, 11, 3),
                "Manchester",
                tpe);
        ate = new AdapterTrasladoEstandar();
        pt = new PlataformaTransporte();
        te.setAdapter(ate);
        ate.setPlataforma(pt);
    }

    @Test
    public void test001_SePuedeCalcularElCostoDeUnTrasladoEstandarSabiendoLaCantidadDePasajerosYDistanciaHastaElDestino(){
        assertEquals(100d, te.calcularCosto(r3));
    }

    @Test
    public void test002_SePuedeCalcularElCostoDeUnTrasladoVIPSabiendoElCostoTotalDeUnaReserva(){
        assertEquals(500d, tv.calcularCosto(r2));
    }

    @Test
    public void test003_ElCostoDeUnTrasladoConPuntoDeEncuentroEsSiempreCero(){
        assertEquals(0, tpe.calcularCosto(r3));
    }

    @Test
    public void test004_UnaReservaConoceElCostoDeSuTraslado(){
        assertEquals(300d, r.getMetodoTraslado().calcularCosto(r));
    }

    @Test
    public void test005_UnTrasladoPorPuntoDeEncuentroSabeSiTieneCupos(){
        assertEquals(0, tpe.getCuposGuias());
    }

    @Test
    public void test006_UnTrasladoPorPuntoDeEncuentroConoceSuPuntoDeEncuentro(){
        assertEquals("Leeds", tpe.getPuntoEncuentro());
    }

    @Test
    public void test007_UnTrasladoVIPConoceSuPorcentajeDeDescuento(){
        assertEquals(0.10, tv.getDescuento());
    }

    @Test
    public void test008_UnTrasladoVIPConoceSuCargoBase(){
        assertEquals(500d, tv.getCargoBase());
    }

    @Test
    public void test009_AUnTrasladoVIPSeLePuedeReasignarElCargoBase(){
        tv.setCargoBase(600d);
        assertEquals(600d, tv.getCargoBase());
    }

    @Test
    public void test010_AUnTrasladoVIPSeLePuedeReasignarElPorcentajeDeDescuento(){
        tv.setDescuento(0.20);
        assertEquals(0.20, tv.getDescuento());
    }

    @Test
    public void test011_AUnTrasladoPorPuntoDeEncuentroSeLePuedeReasignarSuPuntoDeEncuentro(){
        tpe.setPuntoEncuentro("Bath");
        assertEquals("Bath", tpe.getPuntoEncuentro());
    }

    @Test
    public void test012_AUnTrasladoPorPuntoDeEncuentroSeLePuedeCambiarSuCantidadDeCupos(){
        tpe.setCuposGuias(3);
        assertEquals(3, tpe.getCuposGuias());
    }

    @Test
    public void test013_UnTrasladoPorPuntoDeEncuentroSabeSiTieneDisponibilidad(){
        assertFalse(tpe.hayDisponibilidad(r3));
    }

    @Test
    public void cambiarTrasladoEstandarAVip(){
        r.setMetodoTraslado(tv);
        assertInstanceOf(TrasladoVIP.class, r.getMetodoTraslado());
    }
}