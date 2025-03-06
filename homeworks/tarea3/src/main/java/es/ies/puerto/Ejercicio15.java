package es.ies.puerto;

import java.util.Scanner;

/**
 * Link encuentra tres objetos en una mazmorra: una llave, una bomba y un arco. 
 * Si tiene la llave, puede abrir la puerta. Si tiene la bomba, puede destruir 
 * la puerta. Si tiene el arco, puede atacar a los enemigos desde lejos. 
 * Escribe un programa que determine qué puede hacer Link según el objeto que tenga.
 * @author eduglezexp
 */

public class Ejercicio15 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Cual objeto quieres usar: (llave, bomba, arco)");
        String objeto = scanner.nextLine();
        switch (objeto) {
            case "llave":
                System.out.println("¡Link ha usado la llave y ha abierto la puerta!");
                break;
            case "bomba":
                System.out.println("¡Link ha usado la bomba y ha destruido la puerta!");
                break;
            case "arco":
                System.out.println("¡Link puede atacar ahora a los enemigos desde lejos!");
                break;
            default:
                System.out.println("Ese objeto no es valido, introduce uno de los " +
                "siguientes objetos (llave, bomba, arco)");
                break;
        }
    }
}
