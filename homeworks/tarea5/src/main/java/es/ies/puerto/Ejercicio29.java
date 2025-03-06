package es.ies.puerto;

/**
 * Simula un combate Pokémon y genera un daño aleatorio entre 50 y 100 
 * usando Math.random().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio29 {
    public static void main(String[] args) {
        int danio = (int) Math.round(Math.random() * 50) + 50;
        System.out.println(danio);
    }
}