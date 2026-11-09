package catalogo.atributos;

public class Texto implements ValorGenerico{
    private String texto;

    public Texto(String _texto) {
        this.texto = _texto;
    }

    @Override
    public void setValor(Object valor) {
        try {
            this.texto = String.valueOf(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: El valor dado no es un texto valido.");
        }
    }

    @Override
    public Object getValor() {
        return texto;
    }
}
