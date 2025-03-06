package es.ies.puerto;

/**
 * Declara una variable double para almacenar la raíz cuadrada de 2. 
 * Usa la clase Math para calcular el valor y muéstralo por pantalla.
 * @author eduglezexp
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        double raizCuadrada2 = Math.sqrt(2);
        System.out.println(String.format("La raíz cuadrada de 2 es: %.4f", raizCuadrada2));
    }
}