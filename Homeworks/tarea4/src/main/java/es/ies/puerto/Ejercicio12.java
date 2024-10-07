package es.ies.puerto;

import java.util.Scanner;

/**
 * Crea un array que contenga los objetos del inventario del Batmóvil (por ejemplo, 
 * batarangs, ganchos, bombas de humo). Agrega una opción para que el usuario pueda 
 * agregar o eliminar elementos del inventario.
 * @author eduglezexp
 */

public class Ejercicio12 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] objetos = {"batarangs", "ganchos", "bombas de humo"};
        String opcion = "";
        do {
            System.out.println("Elige una opcion para el inventario: (agregar o eliminar)");
            opcion = scanner.nextLine();
            opcion = opcion.toLowerCase();
        } while (!opcion.equals("agregar") && !opcion.equals("eliminar"));
        switch (opcion) {
            case "agregar":
                System.out.println();
                System.out.println("***Inventario***");
                for (int i = 0; i < objetos.length; i++) {
                    System.out.println(" - " +objetos[i]);
                }
                System.out.println();
                System.out.println("¿Que objeto desea añadir al inventario?: ");
                String objetoAniadir = scanner.nextLine();
                objetos[objetos.length -1] += objetoAniadir;
                int contador = 0;
                String[] nuevosObjetos = new String[objetos.length + 1];
                System.out.println();
                System.out.println("***Inventario***");
                for (int i = 0; i < objetos.length; i++) {
                    System.out.println(" - " +objetos[i]);
                }
                break;
            case "eliminar":
                System.out.println();
                System.out.println("***Inventario***");
                for (int i = 0; i < objetos.length; i++) {  
                    System.out.println(" - " +objetos[i]);
                }
                System.out.println();
                System.out.println("¿Que objeto desea eliminar del inventario?: ");
                String objetoEliminar = scanner.nextLine();
                objetoEliminar = objetoEliminar.toLowerCase();
                break;
        }
        scanner.close();
    } 
}