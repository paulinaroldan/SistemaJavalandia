package Repositorio;

import Excepcion.DatosIncompletosEx;
import Excepcion.HabitanteDuplicadoEx;
import Modelo.IHabitante;

import java.util.ArrayList;


public class RepositorioHabitante implements IRepositorio <IHabitante, Integer> {

    private ArrayList<IHabitante> lista;

    public RepositorioHabitante(){
        lista = new ArrayList<>();
    }

    @Override
    public void registrar(IHabitante elemento) throws DatosIncompletosEx, HabitanteDuplicadoEx {
        for (IHabitante el: lista){
            if (el.getId()== elemento.getId()){
                throw new HabitanteDuplicadoEx("Ya existe, no se puede agregar");
            }
            if (elemento.getId()<=0){
                throw new DatosIncompletosEx("No puede estar el id vacio");
            }
        }
        lista.add(elemento);
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean encontrado=false;
        for (IHabitante el: lista){
            if (el.getId()==id){
                lista.remove(el);
                encontrado=true;
            }
        }
        return encontrado;
    }

    @Override
    public String buscar(Integer id) {
        String rta="";
        for (IHabitante el: lista){
            if (el.getId()==id){
                rta=el.toString();
            }
        }
        return rta;
    }

    @Override
    public String listar() {
        String rta="";
        for (IHabitante el: lista){
            rta+=el.toString();
        }
        return rta;
    }

    @Override
    public int contar() {
        return lista.size();
    }
}
