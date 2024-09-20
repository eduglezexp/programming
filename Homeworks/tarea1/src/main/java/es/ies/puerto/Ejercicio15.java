package es.ies.puerto;

/**
 * Declara una variable de tipo char y asígnale un símbolo del teclado. 
 * Luego, muestra el código numérico ASCII de ese símbolo.
 * @author eduglezexp
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        char simbolo = '+';

        int codigoAscii = (int) simbolo;

        System.out.println("El símbolo '" + simbolo + "' " +
        "tiene el código ASCII: " + codigoAscii);
    }
}