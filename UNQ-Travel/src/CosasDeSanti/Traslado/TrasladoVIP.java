package ar.edu.unq.po2.tpIntegrador;

import ar.edu.unq.po2.tpIntegrador.reserva.status.Reserva;

public class TrasladoVIP implements MetodoTraslado{
    private double descuento;
    private double cargoBase;

    public TrasladoVIP(double descuento, double cargoBase){
        this.descuento = descuento;
        this.cargoBase = cargoBase;
    }

    @Override
    public double calcularCosto(Reserva r) {
        return(r.cobrarServicios() * descuento + cargoBase);
    }

    public double getCargoBase() {
        return this.cargoBase;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public void setCargoBase(double cargoBase) {
        this.cargoBase = cargoBase;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
