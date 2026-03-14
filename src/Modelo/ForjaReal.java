package Modelo;

import Repositorio.IRepositorio;

import java.util.Map;

public class ForjaReal implements IRepositorio {
    private Map<String, Arma> armas;

    @Override
    public void registrar(Object elemento) {

    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public String buscar(int id) {
        return false;
    }

    @Override
    public String listar() {
        return "";
    }

    @Override
    public int contar() {
        return 0;
    }
}
