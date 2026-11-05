package catalogoTest;

import catalogo.Catalogo;
import catalogo.servicios.Item;
import catalogo.servicios.ServicioIndividual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogoTest {
    private Catalogo catalogo;
    private Item servicio1;
    private Item servicio2;
    private Item servicio3;
    @BeforeEach
    public void setUp(){
        catalogo = new Catalogo();
        servicio1 = new ServicioIndividual("Servicio1", "Hoteles",
                                        90d, 939234,"Jaime", "Turismo");
        servicio2 = new ServicioIndividual("Servicio2", "guardar el auto",
                90d, 959234,"Jaime", "Estacionamiento");
    }

    @Test
    public void catalogoLista(){
        catalogo.agregarItem(servicio1);
        assertTrue(catalogo.getServicios().contains(servicio1));
        catalogo.eliminarItem(servicio1);
        assertFalse(catalogo.getServicios().contains(servicio1));
    }
}
