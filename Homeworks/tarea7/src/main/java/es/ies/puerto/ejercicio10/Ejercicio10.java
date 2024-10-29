package es.ies.puerto.ejercicio10;

/**
 * 10. Clase Pila con Métodos para Apilar y Desapilar
 * Crea una clase Pila (simulando una estructura de datos LIFO) con métodos apilar() 
 * y desapilar(). Usa un array para almacenar los datos y sobrescribe toString() para 
 * mostrar el contenido de la pila.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        Pila pila = new Pila(5); 
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
        System.out.println(pila);
        pila.desapilar();
        System.out.println(pila); 
    }
}
