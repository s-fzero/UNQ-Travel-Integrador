package catalogoTest;

import catalogo.Catalogo;
import catalogo.servicios.Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogoTest {
    private Catalogo catalogo;
    private Servicio servicio1;
    private Servicio servicio2;
    private Servicio servicio3;
    @BeforeEach
    public void setUp(){
        catalogo = new Catalogo();

        servicio1 = mock(Servicio.class);
        servicio2 = mock(Servicio.class);
        servicio3 = mock(Servicio.class);
    }

    @Test
    public void insercionDeServiciosAlCatalogo(){

        catalogo.agregarItem(servicio1);
        assertTrue(catalogo.getServicios().contains(servicio1));
        catalogo.eliminarItem(servicio1);
        assertFalse(catalogo.getServicios().contains(servicio1));


    }
}
