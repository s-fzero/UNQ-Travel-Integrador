package reporte;

import catalogo.Catalogo;
import catalogo.servicios.GestorCupo;
import catalogo.servicios.Servicio;

import java.time.LocalDate;

//Patron Visitor
//Rol: Concrete Element
public class CuposTotales extends Reporte{
    private GestorCupo cupos;

    public CuposTotales(Catalogo catalogo, LocalDate inicio, LocalDate fin, GestorCupo cupos) {
        super(catalogo, inicio, fin);
        this.cupos = cupos;
    }

    @Override
    public void aceptar(Exportador v) { v.visitarCuposTotales(this); } //Double dispatch del patron Visitor

    public int cuposTotalesEnCategoria(Servicio s){
        return cuposReservadosEnCategoria(s) + cuposLibresEnCategoria(s);
    }

    public int cuposReservadosEnCategoria(Servicio s){
        return 0; //deberia calcularse
    }

    public int cuposLibresEnCategoria(Servicio s){
        return 0; //deberia calcularse
    }
}
