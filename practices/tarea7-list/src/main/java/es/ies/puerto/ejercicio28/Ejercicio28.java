package es.ies.puerto.ejercicio28;

/**
 * 28. Clase Ciudad con Comparación por Población
 * Crea una clase Ciudad con atributos nombre, pais, y poblacion. 
 * Implementa métodos para comparar ciudades por su población con 
 * equals() y usar toString() para describir la ciudad.
 * @author edglezexp
 * @version 1.0.0
 */

public class Ejercicio28 {
    public static void main(String[] args) {
        Ciudad ciudad1 = new Ciudad("Tokio", "Japón", 13929286);
        Ciudad ciudad2 = new Ciudad("Delhi", "India", 13929286);
        Ciudad ciudad3 = new Ciudad("Nueva York", "Estados Unidos", 8419600);
        System.out.println(ciudad1);
        System.out.println(ciudad2);
        System.out.println(ciudad3);
        System.out.println("\n¿Tokio tiene la misma población que Delhi? " + ciudad1.equals(ciudad2));
        System.out.println("¿Tokio tiene la misma población que Nueva York? " + ciudad1.equals(ciudad3));
    }
}
