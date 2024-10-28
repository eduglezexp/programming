package es.ies.puerto.ejercicio10;

import java.util.Arrays;

/**
 * 10. Clase Pila con Métodos para Apilar y Desapilar
 * Crea una clase Pila (simulando una estructura de datos LIFO) con métodos apilar() 
 * y desapilar(). Usa un array para almacenar los datos y sobrescribe toString() para 
 * mostrar el contenido de la pila.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Pila {
    int[] datos;

    /**
     * Constructor por defecto
     */
    public Pila() {
    }

    /**
     * Constructor con todas las propiedades
     * @param datos de la pila
     */
    public Pila(int[] datos) {
        this.datos = datos;
    }

    /**
     * Getters and Setters
     */
    public int[] getDatos() {
        return datos;
    }

    public void setDatos(int[] datos) {
        this.datos = datos;
    }

    /**
     * Metodo para apilar los datos
     */
    public void apilar() {

    }

    /**
     * Metodo para desapilar los datos
     */
    public void desapilar() {

    }

    @Override
    public String toString() {
        return "Pila [datos=" + Arrays.toString(datos) + "]";
    }
}