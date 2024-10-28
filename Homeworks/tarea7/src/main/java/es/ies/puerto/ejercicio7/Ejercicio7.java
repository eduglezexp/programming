package es.ies.puerto.ejercicio7;

/**
 * 7. Clase CuentaBancaria con Métodos Simples y equals()
 * Define una clase CuentaBancaria con los atributos saldo, titular, y numero. 
 * Implementa métodos depositar() y retirar(). Utiliza equals() para comparar dos 
 * cuentas por el número de cuenta y toString() para mostrar el estado actual de la cuenta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", "123456", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("María García", "789101", 500);
        CuentaBancaria cuenta3 = new CuentaBancaria("Luis Gómez", "123456", 1500);
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        cuenta1.depositar(250);
        cuenta1.retirar(100);
        System.out.println("Después de operaciones en cuenta1: " + cuenta1);
        System.out.println("cuenta1 es igual a cuenta3? " + cuenta1.equals(cuenta3)); 
        System.out.println("cuenta1 es igual a cuenta2? " + cuenta1.equals(cuenta2)); 
    }
}
