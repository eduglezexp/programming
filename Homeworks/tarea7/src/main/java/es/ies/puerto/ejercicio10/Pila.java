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
    private int[] items;        
    private int tope;       

    /**
     * Constructor por defecto
     */
    public Pila() {

    }

    /**
     * Constructor con todas las propiedades
     * @param capacidad
     */
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.items = new int[capacidad];
        this.tope = -1; 
    }
    
    /**
     * Metodo para apilar un elemento
     * @param valor 
     */
    public void apilar(int valor) {
        if (tope < capacidad - 1) {
            items[++tope] = valor;
        } else {
            System.out.println("La pila está llena. No se puede apilar " + valor);
        }
    }
    
    /**
     * funcion para deapilar un elemento
     * @return 
     */
    public int desapilar() {
        if (tope >= 0) { 
            return items[tope--];
        } else {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return -1;
        }
    }
    
    @Override
    public String toString() {
        if (tope == -1) {
            return "La pila está vacía";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Contenido de la pila: ");
        for (int i = tope; i >= 0; i--) {
            sb.append(items[i]).append(" ");
        }
        return sb.toString();
    }
}