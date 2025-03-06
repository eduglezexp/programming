package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Banco;

/**
 * Crea un objeto de la clase Banco con un saldo inicial de 1000. Deposita 500, 
 * retira 200 y muestra el saldo actual.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    static Banco banco;
    public static void main(String[] args) {
        banco = new Banco(1000);
        banco.depositarDinero(500);
        String retirarDinero = banco.retirarDinero(200);
        System.out.println("Saldo actual: " +banco.getSaldo());
        System.out.println(retirarDinero);
    }
}
