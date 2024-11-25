package es.ies.puerto.ejercicio15;

/**
 * 15. Clase Polígono
 * Crea una clase Poligono con un método area(). 
 * Implementa los métodos toString()y equals.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        Poligono poligono1 = new Poligono(3, 4);
        Poligono poligono2 = new Poligono(3, 4);
        System.out.println(poligono2.calcularArea());
        System.out.println("¿Son los poligonos iguales? " +poligono1.equals(poligono2));
    }
}