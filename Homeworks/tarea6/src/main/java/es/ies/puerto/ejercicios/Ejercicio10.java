package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.CuentaBancaria;

/**
 * Crea dos objetos de la clase CuentaBancaria con titulares "Pedro" y "Laura", 
 * y con saldo inicial de 1500 y 1000 respectivamente. Transfiere 500 de la cuenta 
 * de Pedro a la cuenta de Laura y muestra los saldos de ambas cuentas.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    static CuentaBancaria cuentaBancaria1;
    static CuentaBancaria cuentaBancaria2;
    public static void main(String[] args) {
        cuentaBancaria1 = new CuentaBancaria("Pedro", 1500);
        cuentaBancaria2 = new CuentaBancaria("Laura", 1000);
        cuentaBancaria1.transferirDinero(cuentaBancaria2, 500);
        System.out.println("Saldo Pedro: " +cuentaBancaria1.getSaldo());
        System.out.println("Saldo Laura: " +cuentaBancaria2.getSaldo());
    }
}