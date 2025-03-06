package es.ies.puerto;

/**
 * Crea un programa que dada la frase "Viva la Resistencia", cuente cuántas veces 
 * aparece la letra "a".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        String frase = "Viva la Resistencia";
        frase = frase.toLowerCase();
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a') {
                contador++;
            }
        }
        System.out.println(contador);
    }
}