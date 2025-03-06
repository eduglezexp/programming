package es.ies.puerto.ejercicio38;

/**
 * 38. Clase Juego con Jugadores
 * Crea una clase Juego que almacene una lista (array) de jugadores (clase Jugador). 
 * Implementa métodos para agregar y eliminar jugadores, y usar toString() para mostrar 
 * los detalles del juego.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio38 {
    public static void main(String[] args) {
        Juego juego = new Juego("Aventura");
        Jugador jugador1 = new Jugador("Alice", 25);
        Jugador jugador2 = new Jugador("Bob", 30);
        Jugador jugador3 = new Jugador("Charlie", 22);
        juego.addJugador(jugador1);
        juego.addJugador(jugador2);
        juego.addJugador(jugador3);
        System.out.println(juego);
        juego.deleteJugador(jugador2);
        System.out.println(juego);
    }
}
