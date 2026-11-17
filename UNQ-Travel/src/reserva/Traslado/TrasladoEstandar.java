package ar.edu.unq.po2.tpIntegrador;

import ar.edu.unq.po2.tpIntegrador.reserva.status.Reserva;

public class TrasladoEstandar implements MetodoTraslado {
    private AdapterTrasladoEstandar adapter;

    public void setAdapter(AdapterTrasladoEstandar adapter){
        this.adapter = adapter;
    }

    public AdapterTrasladoEstandar getAdapter(){
        return this.adapter;
    }

    @Override
    public double calcularCosto(Reserva r) {
        return adapter.estimarTraslado(r.getCantPasajeros(), r.getDestinoTraslado());
    }
}
