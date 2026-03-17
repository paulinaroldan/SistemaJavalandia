package UI;

import Excepcion.DatosIncompletosEx;
import Excepcion.HabitanteDuplicadoEx;
import Modelo.*;
import Repositorio.IRepositorio;

import java.util.Scanner;

public class Menu {
    private IRepositorio repositorio;
    ForjaReal forja;

    public Menu() {
        this.repositorio = repositorio;
        this.forja = new ForjaReal();
    }

    public void menuFinal() {
        int opcion = 0;
        char seguir = 's';
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Cargar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Contar elementos");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    seguir = 'n';
                    break;
            }
            if (opcion!=6){
                System.out.println("Quiere elegir otra opcion del menu? s-n");
                seguir = sc.next().charAt(0);
            }
        } while (opcion == 's' && opcion != 6);
    }

    private void cargarHabitante(){
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        char seguir = 's';
        String nombreC="";
        String reinoProcedencia="";
        int id=0;
        boolean honorabilidad=false;

        do {
            System.out.println("Cargar Habitante");
            System.out.println("1. Cargar Escudero");
            System.out.println("2. Cargar Noble");
            System.out.println("3. Cargar Aprendizaje Hechicero");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del escudero");
                    nombreC = sc.nextLine();
                    System.out.println("Ingrese el reino de procedencia del escudero");
                    reinoProcedencia = sc.nextLine();
                    System.out.println("Ingrese el id del escudero");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el honorabilidad del escudero (true-false)");
                    String rta = sc.nextLine();
                    if (rta.equals("true")) {
                        honorabilidad = true;
                    }else {
                        honorabilidad = false;
                    }
                    Escudero esc = new Escudero(nombreC, reinoProcedencia, id, honorabilidad);
                    System.out.println("Cuantas armas desea cargar?");
                    int cantArmas = sc.nextInt();
                    sc.nextLine();
                    for (int i=0;i<cantArmas;i++){
                        System.out.println("Ingrese nombre del arma");
                        String nombreArma = sc.nextLine();
                        IArma arma=forja.buscarNombre(nombreArma);
                        if (arma != null) {
                            esc.cargarListaArmas(arma);
                        } else {
                            System.out.println("Arma no encontrada en la forja");
                        }
                    }
                    try {
                        repositorio.registrar(esc);
                        System.out.println("se registro el escudero");
                    }catch (HabitanteDuplicadoEx e){
                        System.out.println(e.getMessage());
                    }catch (DatosIncompletosEx e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Ingrese nombre del noble");
                    nombreC = sc.nextLine();
                    System.out.println("Ingrese el reino de procedencia del noble");
                    reinoProcedencia = sc.nextLine();
                    System.out.println("Ingrese el id del noble");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el honorabilidad del noble");
                    rta = sc.nextLine();
                    if (rta.equals("true")) {
                        honorabilidad = true;
                    }else {
                        honorabilidad = false;
                    }
                    System.out.println("Ingrese el privilegio real del noble");
                    String privilegioReal = sc.nextLine();
                    try {
                        repositorio.registrar(new Noble(nombreC, reinoProcedencia, id, honorabilidad, privilegioReal));
                        System.out.println("se registro el noble");
                    }catch (HabitanteDuplicadoEx e){
                        System.out.println(e.getMessage());
                    }catch (DatosIncompletosEx e){
                        System.out.println(e.getMessage());
                    }
                    break;
                    case  3:
                        System.out.println("Ingrese nombre del hechicero aprendiz");
                        nombreC = sc.nextLine();
                        System.out.println("Ingrese el reino de procedencia del hechicero");
                        reinoProcedencia = sc.nextLine();
                        System.out.println("Ingrese el id del hechicero");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el honorabilidad del hechicero");
                        rta = sc.nextLine();
                        if (rta.equals("true")) {
                            honorabilidad = true;
                        }else {
                            honorabilidad = false;
                        }
                        System.out.println("Ingrese el artefacto magico del hechicero");
                        String artefactoMagico = sc.nextLine();
                        try {
                            repositorio.registrar(new AprendizHechicero(nombreC, reinoProcedencia, id, honorabilidad, artefactoMagico));
                            System.out.println("se registro el hechicero");
                        }catch (HabitanteDuplicadoEx e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 4:
                    seguir='n';
                    break;
            }
            if (opcion!=4){
                System.out.println("desea cargar otro habitante? s-n");
                seguir = sc.next().charAt(0);
            }
        }while (seguir=='s' && opcion!=4);
    }

    private void cargarArma(){
        
    }
}
