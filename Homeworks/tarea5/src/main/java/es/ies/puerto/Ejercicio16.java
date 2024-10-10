package es.ies.puerto;

/**
 * Dado un número de experiencia XP como entero, determina cuántos niveles 
 * ha ganado un jugador si cada nivel requiere 500 XP (usa Math.floor()).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        int xp = 2300;
        int niveles = (int) Math.floor(xp / 500);
        System.out.println(niveles);
    }
}