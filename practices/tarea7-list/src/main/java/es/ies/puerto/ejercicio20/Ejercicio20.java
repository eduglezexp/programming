package es.ies.puerto.ejercicio20;

/**
 * 20. Clase Factura con Métodos de Cálculo
 * Crea una clase Factura con atributos producto, cantidad y precio. Implementa métodos para 
 * calcular el total de la factura y usa toString() para mostrar la información de la factura.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        Factura factura = new Factura("Laptop", 3, 750.50f);
        System.out.println(factura);
        System.out.println("Total: " +factura.calcularTotal());
    }
}
