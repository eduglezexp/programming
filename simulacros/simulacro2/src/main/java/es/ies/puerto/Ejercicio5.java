package es.ies.puerto;

import java.util.Scanner;

/**
 * Ejercicio 5: Gestión de Lista de Personas
 * Descripción: Usando la clase Persona creada anteriormente, implementa un programa 
 * que permita al usuario gestionar una lista de 5 personas como máximo, con las 
 * siguientes opciones.
 *  Crear: Permite al usuario añadir una nueva persona a la lista.
 *  Leer: Muestra la lista completa de personas almacenadas.
 *  Actualizar: Permite al usuario modificar los datos de una persona en la lista.
 *  Eliminar: Permite al usuario eliminar una persona de la lista.
 * Requisitos:
 *  Utiliza una estructura de datos como array para almacenar las personas.
 *  Implementa un menú en el programa para seleccionar las opciones de CRUD y 
 *  manipular la lista de personas.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    private static int numeroPersonas = 0;
    private static Persona[] personas = new Persona[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Crear persona");
            System.out.println("2. Leer lista de personas");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
                case 1:
                    Persona nuevaPersona = pedirPersona();
                    if (addPersona(nuevaPersona)) {
                        System.out.println("Persona añadida con éxito.");
                    } else {
                        System.out.println("Error al añadir persona. Lista llena.");
                    }
                    break;
                case 2:
                    showPersonas();
                    break;
                case 3:
                    System.out.println("Introduzca el DNI de la persona a actualizar:");
                    String dni = scanner.nextLine();
                    Persona personaActualizada = pedirPersona();
                    if (updatePersona(dni, personaActualizada)) {
                        System.out.println("Persona actualizada con éxito.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el DNI de la persona a eliminar:");
                    String dniEliminar = scanner.nextLine();
                    if (deletePersona(dniEliminar)) {
                        System.out.println("Persona eliminada con éxito.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intentelo de nuevo.");
            }
        } while(opcion != 5);
    }

    public static Persona pedirPersona() {
        System.out.print("Introduce el nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la edad de la persona: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Introduce el DNI de la persona: ");
        String dni = scanner.nextLine();
        return new Persona(nombre, edad, dni);
    }

    public static boolean addPersona(Persona persona) {
        if (persona == null) {
            return false;
        }
        if (numeroPersonas >= personas.length) {
            return false;
        }
        personas[numeroPersonas++] = persona;
        return true;
    }

    public static void showPersonas() {
        if (numeroPersonas == 0) {
            System.out.println("No hay personas en la lista.");
            return;
        }
        System.out.println("Lista de personas:");
        for (int i = 0; i < numeroPersonas; i++) {
            System.out.println((i + 1) + ". " + personas[i]);
        }
    }

    public static boolean deletePersona(String dni) {
        if (dni == null) {
            return false;
        }
        if (numeroPersonas == 0) {
            return false;
        }
        for (int i = 0; i < numeroPersonas; i++) {
            if (personas[i].getDni().equals(dni)) {
                personas[i] = null;
                ordenarLista();
                numeroPersonas--;
                return true;
            }
        }
        return false;
    }

    private static void ordenarLista() {
        int index = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                personas[index++] = personas[i];
            }
        }
        while (index < personas.length) {
            personas[index++] = null;
        }
    }

    public static boolean updatePersona(String dni, Persona nuevaPersona) {
        for (int i = 0; i < numeroPersonas; i++) {
            if (personas[i].getDni().equals(dni)) {
                personas[i] = nuevaPersona;
                return true;
            }
        }
        return false;
    }
}