package reporte;

import catalogo.Catalogo;
import catalogo.servicios.Servicio;
import reserva.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Patron Visitor
//Rol: Concrete Element
public class MasReservados extends Reporte{
    private Catalogo catalogo;
    private GestorReservas gestorReservas;

    public MasReservados(Catalogo catalogo, LocalDate inicio, LocalDate fin, GestorReservas gestorReservas) {
        super(catalogo, inicio, fin);
        this.catalogo = catalogo;
    }

    @Override
    public void aceptar(Exportador v) {
        v.visitarMasReservados(this); //Double dispatch del patron Visitor
    }

    public List<Servicio> ordernarMasReservados(){
        List<Reserva> finalizadas = gestorReservas.reservasFinalizadas();
        List<Servicio> servicios = catalogo.getServicios();
        //lo ordena ...
        return servicios;
    }

}
