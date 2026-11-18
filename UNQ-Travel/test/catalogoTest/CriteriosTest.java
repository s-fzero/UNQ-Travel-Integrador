package ar.edu.unq.po2.tpIntegrador.test;

import ar.edu.unq.po2.tpIntegrador.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CriteriosTest {
    private CriterioPorNombre cb;
    private CriterioPorPrecio cb2;
    private CriterioPorCategoria cb3;
    private CriterioPorDisponibilidad cb4;
    private CriterioAnd cb5;
    private CriterioOr cb6;
    private CriterioNot cb7;

    @BeforeEach
    public void setUp(){
        cb = new CriterioPorNombre("Poet");
        cb2 = new CriterioPorPrecio(50000d);
        cb3 = new CriterioPorCategoria("Limpieza");
        cb4 = new CriterioPorDisponibilidad();
        cb5 = new CriterioAnd();
        cb6 = new CriterioOr();
        cb7 = new CriterioNot(cb2);
        cb6.getCriterios().add(cb);
        cb6.getCriterios().add(cb2);
        cb5.getCriterios().add(cb);
        cb5.getCriterios().add(cb2);
    }

    @Test
    public void test001_UnCriterioPorNombreConoceElNombrePorElCualFiltrar(){
        assertEquals(cb.getNombre(), "Poet");
    }

    @Test
    public void test002_UnCriterioPorPrecioConoceElMontoPoerElCualFiltrar(){
        assertEquals(cb2.getPrecio(), 50000d);
    }

    @Test
    public void test003_UnCriterioPorCategoriaConoceLaCategoriaPorLaCualFiltrar(){
        assertEquals(cb3.getCategoria(), "Limpieza");
    }

    @Test
    public void test004_UnCriterioAndConoceLosCriteriosPorLosCualesFiltrar(){
        assertEquals(cb5.getCriterios(), List.of(cb, cb2));
    }

    @Test
    public void test005_UnCriterioOrConoceLosCriteriosPorLosCualesFiltrar(){
        assertEquals(cb6.getCriterios(), List.of(cb, cb2));
    }

    @Test
    public void test006_UnCriterioNotConoceElCriterioPorElCualFiltrar(){
        assertEquals(cb7.getCriterio(), cb2);
    }

    @Test
    public void test007_AUnCriterioAndSeLePuedeAgregarUnCriterioPorElCualFiltrar(){
        cb5.getCriterios().add(cb3);
        assertEquals(cb5.getCriterios(), List.of(cb, cb2, cb3));
    }

    @Test
    public void test008_AUnCriterioOrSeLePuedeAgregarUnCriterioPorElCualFiltrar(){
        cb6.getCriterios().add(cb3);
        assertEquals(cb6.getCriterios(), List.of(cb, cb2, cb3));
    }

    @Test
    public void test009_AUnCriterioAndSeLePuedeSacarUnCriterioPorElCualFiltrar(){
        cb5.getCriterios().remove(cb2);
        assertEquals(cb5.getCriterios(), List.of(cb));
    }

    @Test
    public void test010_AUnCriterioOrSeLePuedeSacarUnCriterioPorElCualFiltrar(){
        cb6.getCriterios().remove(cb2);
        assertEquals(cb6.getCriterios(), List.of(cb));
    }
}