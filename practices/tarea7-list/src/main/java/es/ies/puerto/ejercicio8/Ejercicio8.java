package es.ies.puerto.ejercicio8;

/**
 * 8. Clase Fracción con Métodos Matemáticos
 * Crea una clase Fraccion con atributos numerador y denominador. Implementa métodos 
 * para sumar, restar, multiplicar y dividir fracciones. Sobrescribe toString() para 
 * mostrar la fracción en formato numerador/denominador.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        Fraccion fraccion = new Fraccion(2, 4);
        System.out.println(fraccion.sumar(fraccion));
        System.out.println(fraccion.restar(fraccion));
        System.out.println(fraccion.multiplicar(fraccion));
        System.out.println(fraccion.dividir(fraccion));
    }
}
