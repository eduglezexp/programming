package es.ies.puerto;

/**
 * Según tus respuestas en el sombrero seleccionador, te pueden asignar 
 * a Gryffindor, Slytherin, Ravenclaw o Hufflepuff. Elige entre valiente, 
 * astuto, sabio o leal y el programa te asignará una casa. 
 * Crea un programa que te asigne una casa según tu elección.
 * @author eduglezexp
 */

import java.util.Scanner;

public class Ejercicio10 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Elige entre valiente, astuto, sabio o leal: ");
        String eleccion = scanner.nextLine();
        eleccion = eleccion.toLowerCase();
        
        switch (eleccion) {
            case "valiente":
                System.out.println("Eres de la casa Gryffindor");
                break;
            case "astuto":
                System.out.println("Eres de la casa Slytherin");
                break;
            case "sabio":
                System.out.println("Eres de la casa Ravenclaw");
            case "leal":
                System.out.println("Eres de la casa Hufflepuff");
            default:
                System.out.println("No eres de ninguna casa, no has elegido " +
                "entre valiente, astuto, sabio o leal");
                break;
        }
    }
}
