package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Rectangulo;

/**
 * Crea un objeto de la clase Rectangulo con base 5 y altura 10. 
 * Muestra el área calculada del rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    static Rectangulo rectangulo;
    public static void main(String[] args) {
        rectangulo = new Rectangulo(5, 10);
        float area = rectangulo.calcularArea();
        System.out.println(rectangulo+ " Area: " +area);
    }
}
