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
        String opcion = "";
        do {
            System.out.println("Elige una opcion para el inventario: (agregar o eliminar)");
            opcion = scanner.nextLine();
            opcion = opcion.toLowerCase();
        } while (!opcion.equals("agregar") && !opcion.equals("eliminar"));
        String[] objetos = {"batarangs", "ganchos", "bombas de humo"};
        switch (opcion) {
            case "agregar":
                for (int i = 0; i < objetos.length; i++) {
                    
                }
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
        }
        scanner.close();
    } 
}