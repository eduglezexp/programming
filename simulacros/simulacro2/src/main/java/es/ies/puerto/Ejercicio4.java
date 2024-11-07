package es.ies.puerto;

/**
 * Ejercicio 4: Construcción de Clases - Clase Producto
 * Descripción: Crea una clase Producto con los siguientes atributos:
 *  codigo (String)
 *  nombre (String)
 *  precio (float)
 *  identificador (String)
 * Define los métodos necesarios:
 *  Constructor para inicializar todos los atributos, y para obteber los valores de 
 *  estos en cualquier momento(get/set).
 *  Método aplicarDescuento(double porcentaje) que reduzca el precio del producto en 
 *  el porcentaje indicado.
 * Ejemplo de uso:
 *  Crear un objeto de tipo Producto, aplicar un descuento y mostrar la información 
 *  actualizada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        Producto producto = new Producto("codigo1", "Nombre1",
        12.6f, "identificador1");
        System.out.println("El descuento es: " +producto.aplicarDescuento(20));
    }
}