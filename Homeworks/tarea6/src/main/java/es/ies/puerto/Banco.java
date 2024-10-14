package es.ies.puerto;

/**
 * Ejercicio 7
 * Crea una clase Banco con un atributo privado saldo. 
 * Implementa métodos para depositar y retirar dinero, 
 * y un método getter para consultar el saldo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Banco {
    private float saldo;

    public Banco() {

    }

    public Banco(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void depositarDinero(float dinero) {
        if (dinero > 0) {
            saldo += dinero;
        }
    }

    public String retirarDinero(float dinero) {
        if (dinero > 0) {
            saldo -= dinero;
        } else {
            return "Introduzca una cantidad de dinero valida";
        } 
        if (saldo < 0) {
            return "Saldo insuficiente";
        } else {
            return "El dinero retirado es " +dinero;
        }
    }
}