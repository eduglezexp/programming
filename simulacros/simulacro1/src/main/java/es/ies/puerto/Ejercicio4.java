package es.ies.puerto;

/**
 * Escribe un programa que reciba una cadena de texto y cuente cuántas vocales tiene.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String mensaje = "Hola, ¿cómo estás?";
        System.out.println(contarVocales(mensaje));
    }

    public static int contarVocales(String mensaje) {
        mensaje = mensaje.toLowerCase();
        String vocales = "aeiouáéíóú";
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            char letras = mensaje.charAt(i);
            if (vocales.indexOf(letras) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
