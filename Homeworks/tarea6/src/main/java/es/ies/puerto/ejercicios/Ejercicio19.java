package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Circulo;

/**
 * Crea un objeto de la clase Circulo con radio 5. Muestra el área y el perímetro del círculo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    static Circulo circulo;
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);
        float area = circulo.calcularArea();
        float perimetro = circulo.calcularPerimetro();
        System.out.println(area);
        System.out.println(perimetro);
    }
}
