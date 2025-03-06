package es.ies.puerto.ejercicio10;

/**
 * 10. Clase Pila con Métodos para Apilar y Desapilar
 * Crea una clase Pila (simulando una estructura de datos LIFO) con métodos apilar() 
 * y desapilar(). Usa un array para almacenar los datos y sobrescribe toString() para 
 * mostrar el contenido de la pila.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Pila {     
    private int capacidad; 
    private Integer[] elementos;
    private int tope;             

    /**
     * Constructor por defecto
     */
    public Pila() {
        this.elementos = new Integer[capacidad];
        this.tope = 0;
    }

    /**
     * Constructor con todas las propiedades
     * @param capacidad
     */
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Integer[capacidad];
        this.tope = 0;
    }
    
    /**
     * Metodo para apilar un elemento
     * @param valor 
     */
    public boolean apilar(Integer numero) {
        if (numero == null) {
            return false;
        }
        if (tope >= elementos.length) {
            return false;
        }
        for (int i = elementos.length-1; i > 0; i--) {
            elementos[i] = elementos[i-1];
        }
        elementos[0] = numero;
        tope++;
        return true;
    }
    
    /**
     * funcion para deapilar un elemento
     * @return 
     */
    public boolean desapilar() {
        if (tope < 1) { 
            return false;
        } 
        for (int i = 0; i < elementos.length-1; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tope] = null;
        tope--;
        return true;
    }
    
    @Override
    public String toString() {
        String mensaje= "";
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                mensaje += "Posicion " +i+ " Valor: " +elementos[i]+ "\n";   
            }
        }
        return mensaje;
    }
}