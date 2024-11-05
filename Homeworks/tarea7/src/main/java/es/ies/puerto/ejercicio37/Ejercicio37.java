package es.ies.puerto.ejercicio37;

/**
 * 37. Clase Partido con Equipos y Resultados
 * Crea una clase Partido con atributos equipoLocal, equipoVisitante, y resultado. 
 * Implementa métodos para actualizar el resultado y usar toString() para mostrar 
 * los detalles del partido.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio37 {
    public static void main(String[] args) {
        Partido partido = new Partido("FC Barcelona", "Real Madrid");
        System.out.println(partido);
        partido.actualizarResultado(2, 1);
        System.out.println(partido);
    }
}
