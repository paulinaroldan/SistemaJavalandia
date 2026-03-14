package Repositorio;

import Excepcion.HabitanteDuplicadoEx;

import Excepcion.HabitanteNoEncontradoEx;
import Modelo.IHabitante;

import java.util.ArrayList;


public class RepositorioHabitante implements IRepositorio <IHabitante>{

    private ArrayList<IHabitante> listaHabitante;

    public RepositorioHabitante(){
        listaHabitante = new ArrayList<>();
    }

    @Override
    public void registrar(IHabitante elemento) throws HabitanteDuplicadoEx {
        for (IHabitante h:  listaHabitante){
            if (h.getId()==elemento.getId()){
                throw new HabitanteDuplicadoEx("Ya existe el habitante, no se puede agregar.");
            }
        }
        listaHabitante.add(elemento);
    }

    @Override
    public boolean eliminar(int id) throws HabitanteNoEncontradoEx {
        boolean encontrado=false;
        for (int i=0;i<listaHabitante.size();i++){
            if (listaHabitante.get(i).getId()==id){
                listaHabitante.remove(i);
                encontrado=true;
            }else {
                throw new HabitanteNoEncontradoEx("No se encontro un habitante con ese id");
            }
        }
        return encontrado;
    }

    @Override
    public String buscar(int id) throws HabitanteNoEncontradoEx {
        String rta="";
        for (IHabitante h:  listaHabitante){
            if (h.getId()==id){
                rta=h.toString();
            }else {
                throw new HabitanteNoEncontradoEx("No se encontro un habitante con ese id");
            }
        }

        return rta;
    }

    @Override
    public String listar() {
        String rta="";
        for (IHabitante h:  listaHabitante){
            rta+=h.toString();
        }
        return rta;
    }

    @Override
    public int contar() {
        return listaHabitante.size();
    }
}
