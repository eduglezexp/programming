package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.CuentaBancaria;

/**
 * Crea dos objetos de la clase CuentaBancaria con titulares "Luis" y "Sofía", con saldos 
 * de 500 y 3000 respectivamente. Intenta transferir 1000 de la cuenta de Luis y muestra 
 * un mensaje de saldo insuficiente.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    static CuentaBancaria cuentaBancaria1;
    static CuentaBancaria cuentaBancaria2;
    public static void main(String[] args) {
        cuentaBancaria1 = new CuentaBancaria("Luis", 500);
        cuentaBancaria2 = new CuentaBancaria("Sofía", 3000);
        String transferirDinero = cuentaBancaria1.transferirDinero(cuentaBancaria2, 500);
        System.out.println(transferirDinero);
    }
}