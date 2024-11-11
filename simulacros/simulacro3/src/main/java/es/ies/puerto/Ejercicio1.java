package es.ies.puerto;

/**
 * Ejercicio 1 Contador de dígitos
 * Descripción: El objetivo de este ejercicio es escribir un programa en que permita 
 * contar cuántos dígitos tiene un número entero positivo. El programa debe recibir 
 * un número entero positivo como entrada del usuario y luego determinar cuántos 
 * dígitos tiene dicho número.
 * A tener en cuenta:
 *  El número debe ser un número entero positivo (es decir, mayor que cero).
 *  El programa debe ser capaz de manejar números de cualquier longitud (desde un 
 *  solo dígito hasta varios dígitos).
 *  El programa no debe aceptar números negativos o cero.
 * Algoritmo
 *  Verificar si el número ingresado es positivo.
 *  Dividir el número entre 10 repetidamente, incrementando un contador por cada 
 *  división. Esto eliminará el último dígito del número en cada iteración.
 *  El número de iteraciones realizadas (o el valor del contador) será igual a la 
 *  cantidad de dígitos en el número original.
 *  Mostrar el resultado, que es el número total de dígitos del número ingresado.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Numero de digitos: ");
        System.out.println(contarDigitos(252));
        System.out.println(otroContarDigitos(25));
    }
    
    /**
     * Funcion que cuenta el numero de digitos
     * @param numero
     * @return el numero de digitos
     */
    public static int contarDigitos(Integer numero) {
        if (numero == null || numero < 1) {
            return 0;
            
        }
        return numero.toString().length();
    }

    /**
     * Funcion que cuenta el numero de digitos, otra forma de hacerlo
     * @param numero
     * @return el numero de digitos
     */
    public static int otroContarDigitos(Integer numero) {
        if (numero == null || numero < 1) {
            return 0;
            
        }
        return String.valueOf(numero).length();
    }
}