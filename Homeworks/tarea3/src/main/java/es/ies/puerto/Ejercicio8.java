package es.ies.puerto;

/**
 * Rick ha activado su pistola de portales. Si ingresa un número divisible por 3, 
 * el portal lleva a la dimensión A. Si es divisible por 5, lleva a la dimensión B. 
 * Si es divisible por ambos, lleva a la dimensión C.
 * Crea un programa que determine a qué dimensión llega el portal según el número 
 * ingresado.
 * @author eduglezexp
 */

import java.util.Scanner;

public class Ejercicio8 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Ingrese un numero para saber a que dimension ira Rick: ");
        int numero = scanner.nextInt();
            
        if (numero % 3 == 0 && numero % 5 == 0) {
            System.out.println("Entrando a la dimension C");
        } else if (numero % 3 == 0) {
            System.out.println("Entrando en la dimension A");
        } else if (numero % 5 == 0) {
            System.out.println("Entrando en la dimension B");
        } else {
            System.out.println("Ingrese un numero entero valido");
        }
        scanner.close();
    }
}
