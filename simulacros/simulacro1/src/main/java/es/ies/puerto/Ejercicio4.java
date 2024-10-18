package es.ies.puerto;

/**
 * Escribe un programa que reciba una cadena de texto y cuente cuántas vocales tiene.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String mensaje = "Hola, ¿cómo estás?";
    }

    public static int contarVocales(String mensaje) {
        mensaje = mensaje.toLowerCase();
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            contador++;
        }
        return contador;
    }
}
