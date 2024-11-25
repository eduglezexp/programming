package es.ies.puerto.ejercicio12;

/**
 * 12. Clase Calculadora con Métodos Estáticos
 * Crea una clase Calculadora con métodos estáticos para sumar, restar, multiplicar y dividir 
 * dos números.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(4, 2);
        System.out.println(calculadora.sumar());
        System.out.println(calculadora.restar());
        System.out.println(calculadora.multiplicar());
        System.out.println(calculadora.dividir());
    }
}
