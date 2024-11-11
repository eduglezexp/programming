package es.ies.puerto;

/**
 * Ejercicio 2: Verificar si un número es un "Número de la Fuerza"
 * Descripción: En el universo de Star Wars, un "Número de la Fuerza" es un número 
 * especial que solo puede ser usado por un Jedi. Un "Número de la Fuerza" es un 
 * número que cumple con la siguiente condición:la suma de sus dígitos es divisible 
 * por el número de dígitos del mismo número. Si el número es un "Número de la Fuerza",
 * significa que tiene el potencial de ser utilizado por un Jedi para acceder al poder
 * de la Fuerza.
 * Tu misión, joven padawan, es crear un programa en que verifique si un número es un 
 * "Número de la Fuerza". Si lo es, muestra un mensaje diciendo "¡Este es un Número 
 * de la Fuerza!" y si no lo es, muestra "¡Este número no es digno de la Fuerza!".
 * Requisitos:
 *  El programa debe aceptar un número entero positivo.
 *  Debe calcular la suma de los dígitos del número.
 *  Debe dividir esa suma por la cantidad de dígitos del número.
 *  Si la suma de los dígitos es divisible por el número de dígitos, es un "Número de 
 *  la Fuerza".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        int numero = 123;
        if (esNumeroFuerza(numero)) {
            System.out.println("Este numero es digno de la fuerza");
        } else {
            System.out.println("Este numero NO es digno de la fuerza");
        }
    }

    /**
     * Metodo para sumar numeros dados un numero
     * @param numero
     * @return resto
     */
    public static boolean esNumeroFuerza(Integer numero) {
        if (numero == null || numero < 1) {
            return false;
        }
        int tamanio = String.valueOf(numero).length();
        int suma = 0;
        for (int i = 0; i < tamanio; i++) {
            suma += String.valueOf(numero).charAt(i);
        }
        int resto = suma % tamanio;
        return resto == 0 ? true: false;
    }
}