package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Rectangulo;

/**
 * Crea un objeto de la clase Rectangulo con base 4 y altura 7. 
 * Muestra el perímetro calculado del rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    static Rectangulo rectangulo;
    public static void main(String[] args) {
        rectangulo = new Rectangulo(4, 7);
        float perimetro = rectangulo.calcularPerimetro();
        System.out.println(rectangulo+ " Perimetro: " +perimetro);
    }
}
