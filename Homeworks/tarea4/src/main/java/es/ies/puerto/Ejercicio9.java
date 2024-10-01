package es.ies.puerto;

/**
 * Declara un array que contenga los nombres de los guerreros saiyajin. 
 * Luego, elimina a cada guerrero uno por uno (cambia su valor en el 
 * array a null) como si el planeta estuviera siendo destruido.
 * @author eduglezexp
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        String[] saiyajins = {"Goku", "Vegeta", "Nappa", "Raditz"};
        for (String saiyajin : saiyajins) {
            System.out.print(saiyajin+ " ");
        }
        System.out.println();
        for (int i = 0; i < saiyajins.length; i++) {
            saiyajins[i] = null;
            for (String saiyajin : saiyajins) {
                if (saiyajin != null) {
                    System.out.print(saiyajin + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
}