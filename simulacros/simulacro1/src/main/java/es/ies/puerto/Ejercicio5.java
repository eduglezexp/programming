package es.ies.puerto;

/**
 * Crear una instancia de la clase Círculo con un radio de 5.
 * Muestra el valor de circulo.
 * Mostrar el área y el perímetro del círculo.
 * Modificar el radio a 7 y mostrar nuevamente el área y el perímetro.
 * Muestra el valor de circulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5);
        System.out.println(circulo1);
        System.out.println(circulo1.calcularArea());
        System.out.println(circulo1.calcularPerimetro());
        Circulo circulo2 = new Circulo(7);
        System.out.println(circulo2.calcularArea());
        System.out.println(circulo2.calcularPerimetro());
        System.out.println(circulo2);
    }
}