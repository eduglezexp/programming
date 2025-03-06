package es.ies.puerto;

/**
 * En una batalla épica, dos ejércitos se han unido. Escribe un programa que sume los 
 * puntos de fuerza de los guerreros de dos ejércitos y muestre un nuevo array con las 
 * fuerzas combinadas de ambos.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        int[] ejercito1 = {50, 60, 70}; 
        int[] ejercito2 = {40, 80, 60}; 
        int[] nuevoEjercito = new int[ejercito1.length];
        for (int i = 0; i < nuevoEjercito.length; i++) {
                nuevoEjercito[i] += ejercito1[i];
                nuevoEjercito[i] += ejercito2[i];
        }
        for (int ejercito : nuevoEjercito) {
            System.out.print(ejercito+ " ");
        }
    }
}
