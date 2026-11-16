package catalogo.atributos;

public class Boolean implements ValorGenerico{
    private java.lang.Boolean bool;

    public Boolean(java.lang.Boolean _bool) {
        this.bool = _bool;
    }

    @Override
    public void setValor(Object valor) {
        if (!(valor instanceof java.lang.Boolean)) {
            throw new IllegalArgumentException("Error: El valor dado no es de tipo boolean.");
        }
        this.bool = (java.lang.Boolean) valor;
    }

    @Override
    public Object getValor() {
        return bool;
    }
}
