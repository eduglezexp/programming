package es.ies.puerto;

/**
 * Un cazador de tesoros ha recolectado una lista de objetos en el orden en que 
 * los encontró. Escribe un programa que invierta el orden de los objetos en su 
 * inventario para mostrar el último objeto primero.
 * @author eduglezexp
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String[] inventario = {"Espada", "Escudo", "Poción", "Gema", "Mapa"}; 
        String[] invertido = new String[inventario.length];
        for (int i = 0; i < inventario.length; i++) {
            invertido[inventario.length -1 -i] = inventario[i];  
            System.out.println(inventario[i]);
        }
    }
}