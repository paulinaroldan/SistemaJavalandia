package Modelo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Arma implements IArma {
    private String nombre;
    private String categoria;
    private int cantidadDisponible;
    private ArrayList<String> materialCreacion;

    public Arma(String nombre, String categoria, int cantidadDisponible) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.materialCreacion = new ArrayList<>();
    }

    public void cargarMaterialCreacion(String material) {
        materialCreacion.add(material);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getCategoria() {
        return this.categoria;
    }

    @Override
    public int getCantidadDisponible() {
        return this.cantidadDisponible;
    }

    @Override
    public ArrayList<String> getMaterialCreacion() {
        return this.materialCreacion;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public void setMaterialCreacion(ArrayList<String> materialCreacion) {
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

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre", this.nombre);
        jsonObject.put("categoria", this.categoria);
        jsonObject.put("cantidadDisponible", this.cantidadDisponible);

        JSONArray materiales = new JSONArray();
        for (String mat : this.materialCreacion) {
            materiales.put(mat);
        }

        jsonObject.put("materialCreacion", materiales);
        return jsonObject;
    }
}
