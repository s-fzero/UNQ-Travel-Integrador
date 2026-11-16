package catalogo.atributos;

import java.time.LocalDate;

public class Fecha implements ValorGenerico {
    private LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public void setValor(Object valor) {
        if (!(valor instanceof LocalDate)) {
            throw new IllegalArgumentException("Error: El valor dado no es de tipo Fecha.");
        }
        this.fecha = (LocalDate) valor;
    }

    @Override
    public Object getValor() {
        return this.fecha;
    }
}
