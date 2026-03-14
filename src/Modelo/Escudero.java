package Modelo;

import java.util.ArrayList;

public class Escudero extends Habitante{
    ArrayList <Arma> listaArmas;

    public Escudero(String nombreCompleto, String reinoProcedencia, int id, boolean honorabilidad) {
        super(nombreCompleto, reinoProcedencia, id, honorabilidad);
        this.listaArmas = new ArrayList<>();
    }
}
