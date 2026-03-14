package Modelo;

import java.util.ArrayList;

public class Arma {
private String nombre;
private String categoria;
private int cantidadDisponible;
private ArrayList<String> listaArmas;

    public Arma(String nombre, String categoria, int cantidadDisponible, ArrayList<String> listaArmas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.listaArmas = listaArmas;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", listaArmas=" + listaArmas +
                '}';
    }
}
