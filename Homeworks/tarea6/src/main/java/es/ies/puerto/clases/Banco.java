package es.ies.puerto.clases;

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

    public boolean depositarDinero(float dinero) {
        if (dinero > 0) {
            saldo += dinero; 
            return true;  
        } 
        System.out.println("Error: La cantidad a depositar debe ser mayor que 0");
        return false;
    }

    public String retirarDinero(float dinero) {
        if (dinero > 0 && saldo > dinero) {
            saldo -= dinero;
            return "Dinero: " +dinero+ " retirado correctamente";
        } 
        return "Introduzca una cantidad de dinero valida o Saldo insuficiente";
    }
}