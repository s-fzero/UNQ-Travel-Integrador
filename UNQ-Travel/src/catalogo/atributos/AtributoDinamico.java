package catalogo.atributos;

public class AtributoDinamico {
    private String  nombre;
    private Boolean esObligatorio;
    private Tipo valor;

    public AtributoDinamico(String _nombre, Boolean _esObligatorio, Tipo _valor) {
        this.nombre        = _nombre;
        this.esObligatorio = _esObligatorio;
        this.valor         = _valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getEsObligatorio() {
        return esObligatorio;
    }

    public Tipo getValor() {
        return valor;
    }
}
