package Modelo;

import org.json.JSONObject;

import java.util.ArrayList;

public interface IArma {
    String getNombre();
    String getCategoria();
    int getCantidadDisponible();
    ArrayList<String> getMaterialCreacion();
    void setNombre(String nombre);
    void setCategoria(String categoria);
    void setCantidadDisponible(int cantidadDisponible);
    void setMaterialCreacion(ArrayList<String> materialCreacion);
    JSONObject toJSON();
}
