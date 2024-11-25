package es.ies.puerto.ejercicio7;
import java.util.Objects;

/**
 * 7. Clase CuentaBancaria con Métodos Simples y equals()
 * Define una clase CuentaBancaria con los atributos saldo, titular, y numero. 
 * Implementa métodos depositar() y retirar(). Utiliza equals() para comparar dos 
 * cuentas por el número de cuenta y toString() para mostrar el estado actual de la cuenta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class CuentaBancaria {
    private String numero;
    private String titular;
    private float saldo;

    /**
     * Constructor por defecto
     */
    public CuentaBancaria() {
    }

    /**
     * Constructor con todas las propiedades
     * @param numero de la cuenta del banco
     * @param titular de la cuenta del banco
     * @param saldo de la cuenta del banco
     */
    public CuentaBancaria(String numero, String titular, float saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Getters and Setters
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
        } 
    }

    @Override
    public String toString() {
        return "CuentaBancaria [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria cuentaBancaria = (CuentaBancaria) o;
        return numero == cuentaBancaria.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}