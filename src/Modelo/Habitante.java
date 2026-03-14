package Modelo;

public abstract class Habitante implements IHabitante {
    private String nombreCompleto;
    private String reinoProcedencia;
    private int id;
    private boolean honorabilidad; //(true si es leal al reino, false si tiene antecedentes dudosos).

    public Habitante(String nombreCompleto, String reinoProcedencia, int id, boolean honorabilidad) {
        this.nombreCompleto = nombreCompleto;
        this.reinoProcedencia = reinoProcedencia;
        this.id = id;
        this.honorabilidad = honorabilidad;
    }

    @Override
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    @Override
    public String getReinoProcedencia() {
        return this.reinoProcedencia;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean getHonorabilidad() {
        return this.honorabilidad;
    }

    @Override
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public void setReinoProcedencia(String reinoProcedencia) {
        this.reinoProcedencia = reinoProcedencia;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setHonorabilidad(boolean honorabilidad) {
        this.honorabilidad = honorabilidad;
    }

    @Override
    public String toString() {
        return "Habitante{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", reinoProcedencia='" + reinoProcedencia + '\'' +
                ", id=" + id +
                ", honorabilidad=" + honorabilidad +
                '}';
    }
}
