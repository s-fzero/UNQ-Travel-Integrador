package catalogoTest;

import catalogo.*;
import catalogo.criterios.*;
import catalogo.servicios.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
// LOS IMPORTS DE ARRIBA SON MÍOS, DE SANTI; LOS DE ABAJO LOS COPIÉ TAL CUAL ESTABAN

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogoTest {
    private Catalogo catalogo;
    private Buscador buscador;
    private ServicioIndividual s1;
    private ServicioIndividual s2;
    private ServicioIndividual s3;
    private PaqueteTuristico s4;
    private CriterioPorNombre cb;
    private CriterioPorPrecio cb2;
    private CriterioPorCategoria cb3;
    private CriterioPorDisponibilidad cb4;
    private CriterioAnd cb5;
    private CriterioOr cb6;
    private CriterioNot cb7;
    // ARRIBA MÍO; ABAJO COPIADO
//    private Catalogo catalogo;
//    private Servicio servicio1;
//    private Servicio servicio2;
//    private Servicio servicio3;

    @BeforeEach
    public void setUp(){
        catalogo = new Catalogo();
        s1 = new ServicioIndividual("Noche de Hotel Central", "a", 15000d, 0514, "Travel", "Alojamiento");
        s2 = new ServicioIndividual("Excursión Guiada Museo", "a", 4000d, 1688, "Travel", "Excursión");
        s3 = new ServicioIndividual("Traslado Aeropuerto Hotel", "a", 2000d, 1896, "Travel", "Alquiler de Auto");
        s4 = new PaqueteTuristico("Pack Escapada Urbana", "a", 0.10d);
        s4.agregarServicio(s1);
        s4.agregarServicio(s2);
        catalogo.agregarItem(s1);
        catalogo.agregarItem(s2);
        catalogo.agregarItem(s3);
        catalogo.agregarItem(s4);
        cb = new CriterioPorNombre("Noche de Hotel Central");
        cb2 = new CriterioPorPrecio(10000d);
        cb3 = new CriterioPorCategoria("Alojamiento");
        cb4 = new CriterioPorDisponibilidad(LocalDate.of(2015, 10, 31),
                LocalDate.of(2015, 11, 3), 5);
        cb5 = new CriterioAnd();
        cb6 = new CriterioOr();
        cb7 = new CriterioNot(cb2);
        cb6.getCriterios().add(cb);
        cb6.getCriterios().add(cb2);
        cb5.getCriterios().add(cb);
        cb5.getCriterios().add(cb2);
        buscador = new Buscador(cb, catalogo);

        s1.agregarProgramacion(LocalDate.of(2015, 10, 31),
                LocalDate.of(2015, 11, 3), 5);
    }

    @Test
    public void test001_SePuedeFiltrarUnCatalogoPorNombre(){
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void test002_SePuedeFiltrarUnCatalogoPorPrecioMaximo(){
        buscador.setCriterio(cb2);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(2, listaFiltrada.size());
    }

    @Test
    public void test003_SePuedeFiltrarUnCatalogoPorCategoria(){
        buscador.setCriterio(cb3);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void test004_SePuedeFiltrarUnCatalogoPorDisponibilidad(){
        buscador.setCriterio(cb4);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void test005_SePuedeFiltrarUnCatalogoPorMasDeUnaCondicionALaVez(){
        buscador.setCriterio(cb5);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(0, listaFiltrada.size());
    }

    @Test
    public void test006_SePuedeFiltrarUnCatalogoSiSeCumpleAlMenosUnaEntreVariasCondiciones(){
        buscador.setCriterio(cb6);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(3, listaFiltrada.size());
    }

    @Test
    public void test007_SePuedeFiltrarUnCatalogoSiNoSeCumpleUnaCondicionEspecifica(){
        buscador.setCriterio(cb7);
        List<Servicio> listaFiltrada = buscador.buscarServicios();
        assertEquals(2, listaFiltrada.size());
    }

    @Test
    public void test008_SePuedeAgregarUnServicioAUnCatalogo(){
        Servicio s5 = new ServicioIndividual("Alojamiento en The Shambles", "a", 13000d, 4569, "Travel", "Alojamiento");
        catalogo.agregarItem(s5);
        assertEquals(5, catalogo.getServicios().size());
    }

    @Test
    public void test009_SePuedeEliminarUnServicioDeUnCatalogo(){
        catalogo.eliminarItem(s4);
        assertEquals(3, catalogo.getServicios().size());
    }
    //
    //ARRIBA MÍO; ABAJO COPIADO
    //
//    @Test
//    public void insercionDeServiciosAlCatalogo(){
//
//        catalogo.agregarItem(servicio1);
//        assertTrue(catalogo.getServicios().contains(servicio1));
//        catalogo.eliminarItem(servicio1);
//        assertFalse(catalogo.getServicios().contains(servicio1));
//
//
//    }
}
