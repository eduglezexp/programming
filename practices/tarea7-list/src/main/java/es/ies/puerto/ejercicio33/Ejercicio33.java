package es.ies.puerto.ejercicio33;

/**
 * 33. Clase Computadora con Componentes
 * Crea una clase Computadora con atributos marca, modelo y una lista (array) de componentes 
 * (como Procesador, RAM, etc.). Implementa métodos para agregar componentes y usar toString() 
 * para describir la computadora.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio33 {
    public static void main(String[] args) {
        Computadora computadora = new Computadora("Dell", "Inspiron 15");
        Componente procesador = new Componente("Intel Core", "i7", "Procesador de 8 núcleos");
        Componente ram = new Componente("16GB", "DDR4", "Memoria RAM de alta velocidad");
        Componente discoDuro = new Componente("1TB", "HDD", "Disco duro de gran capacidad");
        computadora.addComponente(procesador);
        computadora.addComponente(ram);
        computadora.addComponente(discoDuro);
        System.out.println(computadora);
    }
}
