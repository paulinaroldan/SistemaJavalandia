package Repositorio;

public interface IRepositorio <T, K>{
    void registrar(T elemento);
    boolean eliminar(K id);
    String buscar(K id);
    String listar();
    int contar();
}
