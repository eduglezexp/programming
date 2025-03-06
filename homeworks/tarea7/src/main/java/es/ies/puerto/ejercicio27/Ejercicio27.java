package es.ies.puerto.ejercicio27;

/**
 * 27. Clase Planeta con Atributos Astronómicos
 * Define una clase Planeta con atributos nombre, masa, y radio. 
 * Implementa métodos para calcular la gravedad en la superficie del planeta. 
 * Usa toString() para describir el planeta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio27 {
    public static void main(String[] args) {
        Planeta tierra = new Planeta("Tierra", 5.972e24f, 6.371e6f);
        System.out.println(tierra);
    }
}
