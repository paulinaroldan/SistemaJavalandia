package Repositorio;

import Modelo.Habitante;
import Modelo.IHabitante;

import java.util.Map;

public class RepositorioHabitante implements IRepositorio <IHabitante>{


    @Override
    public void registrar(IHabitante elemento) {

    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public boolean buscar(int id) {
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
