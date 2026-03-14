package Modelo;

public interface IHabitante {
    String getNombreCompleto();
    String getReinoProcedencia();
    int getId();
    boolean getHonorabilidad();

    void setNombreCompleto(String nombreCompleto);
    void setReinoProcedencia(String reinoProcedencia);
    void setId(int id);
    void setHonorabilidad(boolean honorabilidad);
}
