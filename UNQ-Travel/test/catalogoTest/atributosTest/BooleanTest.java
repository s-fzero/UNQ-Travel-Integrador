package catalogoTest.atributosTest;

import catalogo.atributos.Boolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BooleanTest {
    private Boolean atributoBooleano;

    @BeforeEach
    public void setUp(){
        atributoBooleano = new Boolean(true);
    }

    @Test
    public void setearNuevoValorEnAtributoBooleanoDeTrueAFalse(){
        atributoBooleano.setValor(false);
        assertFalse((java.lang.Boolean) atributoBooleano.getValor());
    }
}
