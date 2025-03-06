package es.ies.puerto;

/**
 * Declara un array de caracteres con la palabra "Hogwarts". Luego, mueve todas las 
 * letras dos posiciones a la derecha (la última letra pasa a ser la primera) e 
 * imprime el resultado.
 * @author eduglezexp
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        String palabra = "Hogwarts";
        char[] hogwarts = palabra.toCharArray();
        char ultima1 = hogwarts[hogwarts.length - 1];
        char ultima2 = hogwarts[hogwarts.length - 2];
        for (int i = hogwarts.length - 1; i >= 2; i--) {
            hogwarts[i] = hogwarts[i - 2];
        }
        hogwarts[0] = ultima2;
        hogwarts[1] = ultima1;
        System.out.println(hogwarts);
    }
}
