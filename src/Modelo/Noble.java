package Modelo;

public class Noble extends Habitante{
    private String privilegioReal;

    public Noble(String nombreCompleto, String reinoProcedencia, int id, boolean honorabilidad, String privilegioReal) {
        super(nombreCompleto, reinoProcedencia, id, honorabilidad);
        this.privilegioReal = privilegioReal;
    }
}
