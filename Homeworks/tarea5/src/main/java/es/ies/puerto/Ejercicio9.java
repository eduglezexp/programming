package es.ies.puerto;

/**
 * Dada la frase "Soy Batman", invierte la cadena usando métodos de StringBuilder.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        String frase = "Soy Batman";
        StringBuilder fraseBuilder = new StringBuilder(frase);
        fraseBuilder.reverse().toString();
        System.out.println(fraseBuilder);
    }
}