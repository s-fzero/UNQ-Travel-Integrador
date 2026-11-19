package reporte;

import catalogo.Catalogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GestorReportesTest {

    private GestorReportes gestorReportes;
    private Catalogo catalogoMock;

    @BeforeEach
    void setUp() {
        catalogoMock = mock(Catalogo.class);
        gestorReportes = new GestorReportes(catalogoMock);
    }

    @Test
    void testAgregarYEliminarReporte() {
        Reporte reporteMock = mock(Reporte.class);

        gestorReportes.agregarReporte(reporteMock);
        assertEquals(1, gestorReportes.getReportes().size());
        assertTrue(gestorReportes.getReportes().contains(reporteMock));

        gestorReportes.eliminarReporte(reporteMock);
        assertTrue(gestorReportes.getReportes().isEmpty());
    }

    @Test
    void testExportarMasReservadosDelegaEnExportador() {
        Exportador exportadorMock = mock(Exportador.class);
        MasReservados reporteMock = mock(MasReservados.class);

        gestorReportes.exportarMasReservados(exportadorMock, reporteMock);

        verify(exportadorMock, times(1)).visitarMasReservados(reporteMock);
    }
}