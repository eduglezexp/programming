package es.ies.puerto;

/**
 * Ejercicio 7
 * Crea una clase Banco con un atributo privado saldo. 
 * Implementa métodos para depositar y retirar dinero, 
 * y un método getter para consultar el saldo.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Banco con un saldo inicial de 1000. 
 * Deposita 500, retira 200 y muestra el saldo actual.
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
    
    public static void main(String[] args) {
        Banco banco = new Banco(1000);
        banco.depositarDinero(500);
        String retirarDinero = banco.retirarDinero(200);
        System.out.println("Saldo actual: " +banco.getSaldo());
        System.out.println(retirarDinero);
    }
}