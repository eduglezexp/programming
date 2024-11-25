package es.ies.puerto.ejercicio14;

/**
 * 14. Clase Coordenada con Métodos Matemáticos
 *  Define una clase Coordenada con atributos x y y. Implementa métodos para calcular 
 * la distancia a otra coordenada y el desplazamiento a partir de un ángulo y una distancia. 
 * Sobrescribe toString() para mostrar la coordenada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        Coordenada punto1 = new Coordenada(3, 4);
        Coordenada punto2 = new Coordenada(6, 8);
        System.out.println(punto1); 
        System.out.println(punto2); 
        double distancia = punto1.calcularDistancia(punto2);
        System.out.println("Distancia entre punto1 y punto2: " + distancia);
        Coordenada nuevoPunto = punto1.desplazar(45, 5); 
        System.out.println("Nuevo punto tras el desplazamiento: " + nuevoPunto);
    }
}
