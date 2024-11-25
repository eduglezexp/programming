package es.ies.puerto.ejercicio3;

/**
 * Define la clase Coche con atributos marca, modelo, año y velocidad. Incluye métodos
 * acelerar() y frenar(), que modifiquen la velocidad. Usa getters y setters para 
 * controlar el acceso a los atributos.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Coche coche = new Coche("Ford", "Mustang", 1969, 90);
        System.out.println(coche);
        coche.acelerar(30);
        System.out.println(coche);
        coche.frenar(20);
        System.out.println(coche);
    }
}
