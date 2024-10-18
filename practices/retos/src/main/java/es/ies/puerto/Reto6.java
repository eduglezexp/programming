package es.ies.puerto;

/**
 * Reto 6: Calcular el descuento de una compra
 * Escribe un programa que calcule el descuento de una compra en función del monto total. 
 * Si el monto es mayor a 500, aplica un 10% de descuento. Si es menor, no aplica descuento.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto6 {
    public static void main(String[] args) {
        float montoTotal = 560;
        System.out.println(calcularDescuento(montoTotal));
    }

    public static String calcularDescuento(float montoTotal) {
        double descuento = 0;
        if (montoTotal > 500) {
            descuento = montoTotal * 0.10;
            float montoDescuento = montoTotal - (float) descuento;
            return "Tienes un descuento del 10%, \nPrecio original: " +montoTotal+ 
            "\nPrecio con descuento: " +montoDescuento;
        }
        return "No hay descuento para compras de menos de 500 euros";
    } 
}