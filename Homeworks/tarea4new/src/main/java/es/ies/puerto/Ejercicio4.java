package es.ies.puerto;

/**
 * Un cazador de tesoros ha recolectado una lista de objetos en el orden en que 
 * los encontró. Escribe un programa que invierta el orden de los objetos en su 
 * inventario para mostrar el último objeto primero.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String[] inventario = {"Espada", "Escudo", "Poción", "Gema", "Mapa"}; 
        int tamanio = inventario.length;
        for (int i = 0; i < tamanio / 2; i++) {
            String temporal = inventario[i];
            inventario[i] = inventario[tamanio-1-i];
            inventario[tamanio-1-i] = temporal;
        }
        for (int i = 0; i < inventario.length; i++) {
            System.out.print(inventario[i]+ " ");
        }

        /**
         * Otra forma de hacerlo, pero menos eficiente
        String[] invertido = new String[inventario.length];
        for (int i = 0; i < inventario.length; i++) {
            invertido[inventario.length -1 -i] = inventario[i];  
            System.out.println(inventario[i]);
        }
        */
    }
}
