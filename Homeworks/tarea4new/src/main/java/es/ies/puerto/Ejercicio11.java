package es.ies.puerto;

/**
 * Los héroes han bebido una poción mágica que multiplica su poder de ataque. 
 * Escribe un programa que multiplique cada valor de ataque en el array por 
 * un valor escalar (el poder de la poción).
 * @author eduglezexp
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        int[] poderesDeAtaque = {50, 70, 100}; 
        int[] nuevosPoderes = new int[poderesDeAtaque.length];
        int pocion = 2; 
        for (int i = 0; i < nuevosPoderes.length; i++) {
            nuevosPoderes[i] = poderesDeAtaque[i] * pocion;
        }
        for (int poder : nuevosPoderes) {
            System.out.print(poder + " ");
        }
    }
}