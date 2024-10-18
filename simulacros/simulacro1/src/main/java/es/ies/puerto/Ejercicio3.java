package es.ies.puerto;

/**
 * Escribe un programa que imprima los números del 1 al 100. Para múltiplos de 3, 
 * imprime Fizz, para múltiplos de 5, imprime Buzz y para múltiplos de ambos imprime 
 * FizzBuzz. En caso de que no se cumpla ninguna condición no imprime nada para ese 
 * número.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        imprimirFizzBuzz();
    }

    public static void imprimirFizzBuzz() {
        String mensaje = "";
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                mensaje = "Fizz";
            } 
            if (i % 5 == 0) {
                mensaje += "Buzz";
            } 
            if (mensaje.isEmpty()) {
                System.out.println(i);
            }
        }
    }
}