package es.ies.puerto;

/**
 * Ejercicio 10
 * Crea una clase CuentaBancaria con los atributos titular y saldo. 
 * Implementa un método para transferir dinero entre dos cuentas.
 * Instancia y uso de la clase
 * Crea dos objetos de la clase CuentaBancaria con titulares "Pedro" y "Laura", 
 * y con saldo inicial de 1500 y 1000 respectivamente. Transfiere 500 de la 
 * cuenta de Pedro a la cuenta de Laura y muestra los saldos de ambas cuentas.
 * Ejercicio 11
 * Modifica la clase CuentaBancaria para que la transferencia 
 * no pueda realizarse si el saldo de la cuenta es insuficiente.
 * Instancia y uso de la clase
 * Crea dos objetos de la clase CuentaBancaria con titulares "Luis" y "Sofía", 
 * con saldos de 500 y 3000 respectivamente. Intenta transferir 1000 de la cuenta 
 * de Luis y muestra un mensaje de saldo insuficiente.
 * @author eduglezexp
 * @version 1.0.0
 */

public class CuentaBancaria {
    private String titular;
    private float saldo;
    
    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String transferirDinero(CuentaBancaria cuentaDestino, float dinero) {
        if (this.saldo < dinero) {
            return "Saldo insuficiente para transferir " +dinero;
        } 
        this.saldo -= dinero;
        cuentaDestino.saldo += dinero;
        return "Ingresado: " +dinero+ " a " + cuentaDestino.getTitular();
    }
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria("Pedro", 1500);
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria("Laura", 1000);
        cuentaBancaria1.transferirDinero(cuentaBancaria2, 500);
        System.out.println("Saldo Pedro: " +cuentaBancaria1.getSaldo());
        System.out.println("Saldo Laura: " +cuentaBancaria2.getSaldo());
        CuentaBancaria cuentaBancaria3 = new CuentaBancaria("Luis", 500);
        CuentaBancaria cuentaBancaria4 = new CuentaBancaria("Sofía", 3000);
        String transferirDinero = cuentaBancaria3.transferirDinero(cuentaBancaria4, 500);
        System.out.println(transferirDinero);
    }
}
