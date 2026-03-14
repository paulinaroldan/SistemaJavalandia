package Modelo;

import java.util.ArrayList;

public class Escudero extends Habitante{
    ArrayList <Arma> listaArmas;

    public Escudero(String nombreCompleto, String reinoProcedencia, int id, boolean honorabilidad) {
        super(nombreCompleto, reinoProcedencia, id, honorabilidad);
        this.listaArmas = new ArrayList<>();
    }

    public void cargarListaArmas(Arma a1){
        listaArmas.add(a1);
    }

    @Override
    public String toString() {
        return super.toString()+"Escudero{" +
                "listaArmas=" + listaArmas +
                '}';
    }
}
