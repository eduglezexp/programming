package es.ies.puerto;

import java.util.Objects;

/**
 * Ejercicio 3: Cuanta Bancaria
 * Descripción Crea una clase llamada CuentaBancaria que represente una cuenta 
 * bancaria sencilla. La cuenta debe poder realizar depósitos, retiros y mostrar 
 * el saldo actual. Además, incluye un método que determine si la cuenta tiene 
 * fondos suficientes para realizar una operación de retiro.
 * Atributos:
 *  numeroCuenta (tipo String): El número único de la cuenta.
 *  titular (tipo String): El nombre del titular de la cuenta.
 *  saldo (tipo double): El saldo actual de la cuenta.
 * Métodos:
 *  depositar(double cantidad): Agrega la cantidad especificada al saldo.
 *  retirar(double cantidad): Verifica si hay suficiente saldo en la cuenta. 
 *  Si es así, descuenta la cantidad del saldo, y retorna true; si no, retorna false.
 *  consultarSaldo(): Muestra el saldo actual de la cuenta.
 *  tieneFondosSuficientes(double cantidad): Devuelve true si el saldo es suficiente 
 *  para realizar un retiro de esa cantidad; de lo contrario, devuelve false.
 * @author eduglezexp
 * @version 1.0.0
 */

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private Double saldo;

    /**
     * Constructor por defecto
     */
    public CuentaBancaria() {
    }

    /**
     * Constructor con todas las propiedades
     * @param numeroCuenta
     * @param titular
     * @param saldo
     */
    public CuentaBancaria(String numeroCuenta, String titular, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Getters and Setters
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo para depositar dinero
     * @param cantidad
     * @return true/false
     */
    public boolean depositar(double cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        saldo += cantidad;
        return true;
    }

    /**
     * Metodo para retirar dinero
     * @param cantidad
     * @return true/false
     */
    public boolean retirar(double cantidad) {
        if (!tieneFondosSuficientes(cantidad)) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }

    /**
     * Metodo para consultar el saldo
     * @return saldo
     */
    public String consultarSaldo() {
        return "Saldo actual: " +saldo;
    }   

    /**
     * Meetodo para ver si tiene un saldo suficiente 
     * para retirar una cantidad especifica de dinero
     * @param cantidad
     * @return true/false
     */
    public boolean tieneFondosSuficientes(double cantidad) {
        return saldo >= cantidad;
    }

    @Override
    public String toString() {
        return "{" +
            " numeroCuenta='" + getNumeroCuenta() + "'" +
            ", titular='" + getTitular() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria cuentaBancaria = (CuentaBancaria) o;
        return Objects.equals(numeroCuenta, cuentaBancaria.numeroCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta);
    }
}