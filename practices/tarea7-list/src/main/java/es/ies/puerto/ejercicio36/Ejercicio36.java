package es.ies.puerto.ejercicio36;

/**
 * 36. Clase Colección de Monedas
 * Crea una clase ColeccionMonedas que almacene una lista (array) de monedas (clase Moneda). 
 * Implementa métodos para agregar monedas y listar todas las monedas. 
 * Usa toString() para mostrar detalles de la colección.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio36 {
    public static void main(String[] args) {
        ColeccionMonedas coleccion = new ColeccionMonedas("Mis Monedas");
        Moneda moneda1 = new Moneda("Euro", 1.0f, "Unión Europea");
        Moneda moneda2 = new Moneda("Dólar", 1.1f, "Estados Unidos");
        Moneda moneda3 = new Moneda("Yen", 0.007f, "Japón");
        coleccion.addMoneda(moneda1);
        coleccion.addMoneda(moneda2);
        coleccion.addMoneda(moneda3);
        System.out.println(coleccion);
    }
}