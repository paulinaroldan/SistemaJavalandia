package Repositorio;

public interface IRepositorio <T>{
    void registrar(T elemento);
    boolean eliminar(int id);
    String buscar(int id);
    String listar();
    int contar();
}
