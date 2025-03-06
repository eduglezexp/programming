package es.ies.puerto.ejercicio18;

/**
 * 18. Clase Circulo con Métodos para Área y Perímetro
 * Define una clase Circulo con el atributo radio. Implementa los métodos area() y 
 * perimetro(). Usa equals() para comparar círculos por su radio.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(5);
        System.out.println("¿Es el circulo1 igual al circulo2? " 
        +circulo1.equals(circulo2));
    }
}
