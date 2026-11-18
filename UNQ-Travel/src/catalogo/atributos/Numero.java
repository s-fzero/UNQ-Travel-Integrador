package catalogo.atributos;

public class Numero implements ValorGenerico{
    private Double numero;

    @Override
    public void setValor(Object valor) {
        if (!(valor instanceof java.lang.Double)) {
            throw new IllegalArgumentException("Error: El valor dado no es de tipo Numero.");
        }
        this.numero = (java.lang.Double) valor;
    }

    @Override
    public Object getValor() {
        return numero;
    }
}
