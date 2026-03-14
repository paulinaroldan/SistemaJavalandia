package Modelo;

import java.util.ArrayList;

public class Arma {
private String nombre;
private String categoria;
private int cantidadDisponible;
private ArrayList<String> materialCreacion;

    public Arma(String nombre, String categoria, int cantidadDisponible, ArrayList<String> materialCreacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.materialCreacion = materialCreacion;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", materialCreacion=" + materialCreacion +
                '}';
    }
}
