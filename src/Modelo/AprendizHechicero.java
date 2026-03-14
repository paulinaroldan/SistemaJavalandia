package Modelo;

public class AprendizHechicero extends Habitante{
    private String artefactoMagicoEsp;

    public AprendizHechicero(String nombreCompleto, String reinoProcedencia, int id, boolean honorabilidad, String artefactoMagicoEsp) {
        super(nombreCompleto, reinoProcedencia, id, honorabilidad);
        this.artefactoMagicoEsp = artefactoMagicoEsp;
    }
}
