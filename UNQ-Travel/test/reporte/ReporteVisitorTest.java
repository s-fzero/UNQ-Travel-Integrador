package reporte;

import catalogo.Catalogo;
import catalogo.servicios.GestorCupo;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.mockito.Mockito.*;

class ReporteVisitorTest {

    @Test
    void testMasReservadosAceptaExportador() {
        Catalogo catalogoMock = mock(Catalogo.class);
        GestorReservas gestorReservasMock = mock(GestorReservas.class);
        Exportador exportadorMock = mock(Exportador.class);

        MasReservados reporte = new MasReservados(catalogoMock, LocalDate.now(), LocalDate.now().plusDays(5), gestorReservasMock);

        reporte.aceptar(exportadorMock);

        verify(exportadorMock, times(1)).visitarMasReservados(reporte);
    }

    @Test
    void testCuposTotalesAceptaExportador() {
        Catalogo catalogoMock = mock(Catalogo.class);
        GestorCupo gestorCupoMock = mock(GestorCupo.class);
        Exportador exportadorMock = mock(Exportador.class);

        CuposTotales reporte = new CuposTotales(catalogoMock, LocalDate.now(), LocalDate.now().plusDays(5), gestorCupoMock);

        reporte.aceptar(exportadorMock);

        verify(exportadorMock, times(1)).visitarCuposTotales(reporte);
    }

    @Test
    void testExposicionOperadorAceptaExportador() {
        Catalogo catalogoMock = mock(Catalogo.class);
        Exportador exportadorMock = mock(Exportador.class);

        ExposicionOperador reporte = new ExposicionOperador(catalogoMock, LocalDate.now(), LocalDate.now().plusDays(5));

        reporte.aceptar(exportadorMock);

        verify(exportadorMock, times(1)).visitarExposicionOperador(reporte);
    }
}