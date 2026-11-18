package reporte;

import catalogo.Catalogo;
import catalogo.criterios.CriterioBusqueda;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

//Patron Visitor
//Rol: Concrete Element
public class ExposicionOperador extends Reporte{
    public ExposicionOperador(Catalogo catalogo, LocalDate inicio, LocalDate fin) {
        super(catalogo, inicio, fin);
    }

    @Override
    public void aceptar(Exportador v) {v.visitarExposicionOperador(this);} //Double dispatch del patron Visitor

    public Map<CriterioBusqueda, Double> calcularPorcentajePorOperador(){
        //calcula y lo pone en un map
        return new HashMap<CriterioBusqueda, Double>();
    }
}
