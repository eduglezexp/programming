package es.ies.puerto.ejercicio38;

/**
 * 38. Clase Juego con Jugadores
 * Crea una clase Juego que almacene una lista (array) de jugadores (clase Jugador). 
 * Implementa métodos para agregar y eliminar jugadores, y usar toString() para mostrar 
 * los detalles del juego.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Jugador {
    private String nombre;
    private int edad;
    private int puntos; 

    /**
     * Constructor por defecto
     */
    public Jugador() {
    }

    /**
     * Constructor con las propiedades nombre y edad
     * @param nombre
     * @param edad
     */
    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = 0; 
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    @Override
    public String toString() {
        return "\nJugador: " + nombre + ", Edad: " + edad + ", Puntos: " + puntos;
    }
}