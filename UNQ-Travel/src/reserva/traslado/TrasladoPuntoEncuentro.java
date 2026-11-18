package reserva.traslado;

import reserva.Reserva;

public class TrasladoPuntoEncuentro implements MetodoTraslado {
    private String puntoEncuentro;
    private int cuposGuias;

    public TrasladoPuntoEncuentro(String puntoEncuentro, int cuposGuias) {
        this.puntoEncuentro = puntoEncuentro;
        this.cuposGuias = cuposGuias;
    }

    @Override
    public double calcularCosto(Reserva r) {
        return 0;
    }

    public int getCuposGuias(){
        return this.cuposGuias;
    }

    public String getPuntoEncuentro(){
        return this.puntoEncuentro;
    }

    public void setCuposGuias(int cuposGuias) {
        this.cuposGuias = cuposGuias;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    public boolean hayDisponibilidad(Reserva r) {
        return cuposGuias != 0;
    }
}
