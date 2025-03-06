package es.ies.puerto;

/**
 * Declara un array que contenga las palabras de la frase "Por el poder de Grayskull, 
 * yo tengo el poder". Luego, imprime la frase palabra por palabra desde el último 
 * elemento hasta el primero.
 * @author eduglezexp
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        String frases[] = {"Por", "el", "poder", "de", "Grayskull,", "yo", "tengo", "el", "poder"};
        for(int i = frases.length - 1; i >= 0; i--) {
            System.out.print(frases[i] + " ");
        }
    }
}