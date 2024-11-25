package es.ies.puerto.ejercicio38;

/**
 * 38. Clase Juego con Jugadores
 * Crea una clase Juego que almacene una lista (array) de jugadores (clase Jugador). 
 * Implementa métodos para agregar y eliminar jugadores, y usar toString() para mostrar 
 * los detalles del juego.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Juego {
    private int numeroJugadores;
    private String nombre;
    private Jugador[] jugadores;

    /**
     * Constructor por defecto
     */
    public Juego() {
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Juego(String nombre) {
        this.nombre = nombre;
        this.numeroJugadores = 0;
        this.jugadores = new Jugador[5]; 
    }

    /**
     * Metodo para agregar un jugador al juego
     * @param jugador 
     * @return true/false
     */
    public boolean addJugador(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        if (numeroJugadores >= jugadores.length) {
            return false;
        }
        jugadores[numeroJugadores] = jugador;
        numeroJugadores++;
        return true;
    }

    /**
     * Metodo para eliminar un jugador del juego
     * @param jugador
     * @return true/false
     */
    public boolean deleteJugador(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        if (numeroJugadores == 0) {
            return false;
        }
        for (int i = 0; i < jugadores.length; i++) {
            if (jugador.equals(jugadores[i])) {
                jugadores[i] = null;
                numeroJugadores--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un jugador
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                jugadores[index++] = jugadores[i];
            }
        }
        while (index < jugadores.length) {
            jugadores[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroJugadores; i++) {
            mensaje += jugadores[i];
        }
        return mensaje;
    }
}