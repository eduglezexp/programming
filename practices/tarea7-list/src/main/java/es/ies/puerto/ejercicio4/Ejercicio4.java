package es.ies.puerto.ejercicio4;

/**
 * Crea una clase Rectangulo con atributos ancho y alto. Implementa los métodos carea() y 
 * perimetro(). Sobrescribe equals() para comparar rectángulos por sus dimensiones y toString() 
 * para describir el rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(5, 3);
        Rectangulo rectangulo2 = new Rectangulo(5, 3);
        Rectangulo rectangulo3 = new Rectangulo(4, 6);
        System.out.println("rectangulo1 es igual a rectangulo2? " 
        +rectangulo1.equals(rectangulo2)); 
        System.out.println("rectangulo1 es igual a rectangulo3? " 
        +rectangulo1.equals(rectangulo3)); 
    }
}
