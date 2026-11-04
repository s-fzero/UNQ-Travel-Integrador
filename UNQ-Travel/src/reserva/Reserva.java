package reserva;

import reserva.notificacion.Subsistema;

import java.util.ArrayList;

public class Reserva {
    private ArrayList<Subsistema> subsistemas = new ArrayList<Subsistema>();

    public void notificarSubsistema(){
        for(Subsistema s:subsistemas){
            s.actualizar(this);
        }
    }

    public void agregarSubsistema(Subsistema s){
        this.subsistemas.add(s);
    }

    public void eliminarSubsistema(Subsistema s){
        this.subsistemas.remove(s);
    }
}
