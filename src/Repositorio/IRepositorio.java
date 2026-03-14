package Repositorio;

public interface IRepositorio <T>{
    void registrar(T elemento);
    boolean eliminar(int id);
    boolean buscar(int id);
    String listar();
    int contar();
}
