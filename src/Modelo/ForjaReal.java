package Modelo;

import Excepcion.ArmaDuplicadaEx;
import Excepcion.ArmaNoEncontradaEx;
import Excepcion.DatosIncompletosEx;
import Repositorio.IRepositorio;

import java.util.HashMap;
import java.util.Map;

public class ForjaReal implements IRepositorio <IArma, String>{
    private Map <String, IArma> armas;

    public ForjaReal() {
        this.armas = new HashMap();
    }

    @Override
    public void registrar(IArma elemento) throws ArmaDuplicadaEx, DatosIncompletosEx{
       if (armas.containsKey(elemento.getNombre())) {
           throw new ArmaDuplicadaEx("Arma ya existente");
       }
       if (elemento.getNombre()==null || elemento.getNombre().isEmpty()) {
           throw new DatosIncompletosEx("el nombre no puede estar vacio");
       }
       armas.put(elemento.getNombre(), elemento);
    }

    @Override
    public boolean eliminar(String id) throws ArmaNoEncontradaEx {
        boolean encontrado=false;
        if(armas.containsKey(id)){
            armas.remove(id);
            encontrado=true;
        }else {
            throw new ArmaNoEncontradaEx("Arma no encontrada");
        }
        return encontrado;
    }

    @Override
    public String buscar(String id) throws ArmaNoEncontradaEx {
        String rta="";
        if (armas.containsKey(id)) {
            rta=armas.get(id).toString();
        }else {
            throw new ArmaNoEncontradaEx("Arma no encontrada");
        }
        return rta;
    }

    public IArma buscarNombre(String nombre) {
        return armas.get(nombre);
    }

    @Override
    public String listar() {
        String rta="";
        for (Map.Entry<String, IArma> entry : armas.entrySet()) {
            rta+=entry.toString();
        }
        return rta;
    }

    @Override
    public int contar() {
        return armas.size();
    }
}
