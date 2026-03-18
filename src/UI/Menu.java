package UI;

import Excepcion.*;
import Modelo.*;
import Repositorio.IRepositorio;
import Repositorio.RepositorioHabitante;

import java.util.Scanner;

public class Menu {
    private IRepositorio repositorio;
    private ForjaReal forja;
    private ArchivoBibliotecaReal archivoBibliotecaReal;
    private final String archivo = "armasForjadas";

    public Menu() {
        this.repositorio = new RepositorioHabitante();
        this.forja = new ForjaReal();
        this.archivoBibliotecaReal = new ArchivoBibliotecaReal();
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
            System.out.println("6. Actualizar cantidad disponible armas");
            System.out.println("7. Guardar armas en JSON");
            System.out.println("8. Mostrar archivo JSON");
            System.out.println("9. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    elegirCargar();
                    break;
                case 2:
                    elegirMostrar();
                    break;
                case 3:
                    elegirBuscar();
                    break;
                case 4:
                    elegirEliminar();
                    break;
                case 5:
                    elegirContar();
                    break;
                case 6:
                    System.out.println("Ingrese nombre del arma");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese nueva cantidad disponible armas");
                    int nuevaCant = sc.nextInt();
                    System.out.println(forja.actualizarCantDisponible(nombre, nuevaCant));
                    break;
                case 7:
                    archivoBibliotecaReal.objetoAjson(forja);
                    archivoBibliotecaReal.escribirArchivo(archivo);
                    break;
                case 8:
                    String contenidoArchivo=archivoBibliotecaReal.mostrarArchivo(archivo);
                    System.out.println(contenidoArchivo);
                    break;
                case 9:
                    seguir = 'n';
                    break;
            }
            if (opcion != 9) {
                System.out.println("Quiere elegir otra opcion del menu? s-n");
                seguir = sc.next().charAt(0);
            }
        } while (seguir == 's' && opcion != 9);
    }

    private void elegirCargar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea cargar?");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real (armas)");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                cargarHabitante();
                break;
            case 2:
                cargarArma();
                break;
            default:
                System.out.println("opcion incorrecta");
                break;
        }
    }

    private void cargarHabitante() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        char seguir = 's';
        String nombreC = "";
        String reinoProcedencia = "";
        int id = 0;
        boolean honorabilidad = false;

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
                    } else {
                        honorabilidad = false;
                    }
                    Escudero esc = new Escudero(nombreC, reinoProcedencia, id, honorabilidad);
                    System.out.println("Cuantas armas desea cargar?");
                    int cantArmas = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < cantArmas; i++) {
                        System.out.println("Ingrese nombre del arma");
                        String nombreArma = sc.nextLine();
                        IArma arma = forja.buscarNombre(nombreArma);
                        if (arma != null) {
                            esc.cargarListaArmas(arma);
                        } else {
                            System.out.println("Arma no encontrada en la forja");
                        }
                    }
                    try {
                        repositorio.registrar(esc);
                        System.out.println("se registro el escudero");
                    } catch (HabitanteDuplicadoEx e) {
                        System.out.println(e.getMessage());
                    } catch (DatosIncompletosEx e) {
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
                    } else {
                        honorabilidad = false;
                    }
                    System.out.println("Ingrese el privilegio real del noble");
                    String privilegioReal = sc.nextLine();
                    try {
                        repositorio.registrar(new Noble(nombreC, reinoProcedencia, id, honorabilidad, privilegioReal));
                        System.out.println("se registro el noble");
                    } catch (HabitanteDuplicadoEx e) {
                        System.out.println(e.getMessage());
                    } catch (DatosIncompletosEx e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
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
                    } else {
                        honorabilidad = false;
                    }
                    System.out.println("Ingrese el artefacto magico del hechicero");
                    String artefactoMagico = sc.nextLine();
                    try {
                        repositorio.registrar(new AprendizHechicero(nombreC, reinoProcedencia, id, honorabilidad, artefactoMagico));
                        System.out.println("se registro el hechicero");
                    } catch (HabitanteDuplicadoEx e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    seguir = 'n';
                    break;
            }
            if (opcion != 4) {
                System.out.println("desea cargar otro habitante? s-n");
                seguir = sc.next().charAt(0);
            }
        } while (seguir == 's' && opcion != 4);
    }

    private void cargarArma() {
        Scanner sc = new Scanner(System.in);
        char seguir = 's';
        while (seguir == 's') {
            System.out.println("Ingrese nombre del arma");
            String nombre = sc.nextLine();
            System.out.println("Ingrese categoria del arma");
            String categoria = sc.nextLine();
            System.out.println("Ingrese cantidad disponible");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese cantidad de los materiales de creacion");
            int cantidadDeMateriales = sc.nextInt();
            sc.nextLine();
            Arma a1 = new Arma(nombre, categoria, cantidad);
            try {
                forja.registrar(a1);
            } catch (ArmaDuplicadaEx e) {
                System.out.println(e.getMessage());
            } catch (DatosIncompletosEx e) {
                System.out.println(e.getMessage());
            }

            for (int i = 0; i < cantidadDeMateriales; i++) {
                System.out.println("Ingrese nombre del material de creacion");
                String nombreMaterial = sc.nextLine();
                a1.cargarMaterialCreacion(nombreMaterial);
            }

            System.out.println("Quiere cargar otra arma s-n?");
            seguir = sc.next().charAt(0);
            sc.nextLine();

        }

    }

    private void elegirMostrar() {
        Scanner sc = new Scanner(System.in);
        char seguir = 's';
        while (seguir == 's') {
            System.out.println("Que desea mostrar");
            System.out.println("1. Habitantes");
            System.out.println("2. Forja real");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(repositorio.listar());
                    break;
                case 2:
                    System.out.println(forja.listar());
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println("quiere mostrar otra opcion? s-n");
            seguir = sc.next().charAt(0);
            sc.nextLine();
        }

    }

    private void elegirEliminar() {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        System.out.println("Que desea eliminar");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("ingrese id el habitante a eliminar");
                int id = sc.nextInt();
                sc.nextLine();
                try {
                    encontrado = repositorio.eliminar(id);
                    if (encontrado == true) {
                        System.out.println("el habitante eliminado con exito");
                    } else {
                        System.out.println("no se elimino el habitante");
                    }
                } catch (HabitanteNoEncontradoEx e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("ingrese nombre de arma a eliminar");
                String nombre = sc.nextLine();
                try {
                    encontrado = forja.eliminar(nombre);
                    if (encontrado == true) {
                        System.out.println("arma eliminado con exito");
                    } else {
                        System.out.println("no se elimino arma con exito");
                    }
                } catch (ArmaNoEncontradaEx e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private void elegirContar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea contar");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                int cant = repositorio.contar();
                System.out.println("Cantidad de habitantes: " + cant);
                break;
            case 2:
                cant = forja.contar();
                System.out.println("Cantidad de Armas: " + cant);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private void elegirBuscar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea buscar");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("ingrese id habitante a buscar");
                int id = sc.nextInt();
                sc.nextLine();
                try {
                    System.out.println(repositorio.buscar(id));
                }catch (HabitanteNoEncontradoEx e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 2:
                System.out.println("ingrese nombre de arma a buscar");
                String nombre = sc.nextLine();
                try {
                    System.out.println(forja.buscar(nombre));
                }catch (ArmaNoEncontradaEx e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
}
