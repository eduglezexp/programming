package es.ies.puerto.ejercicio24;

/**
 * 24. Clase Zoológico con Animales
 * Crea una clase Zoologico que almacene una lista (array) (array) de animales 
 * (clase Animal) con atributos nombre y especie. Implementa métodos para agregar, 
 * eliminar y listar animales. Usa toString() para describir el zoológico.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio24 {
    static Zoologico zoologico;
    public static void main(String[] args) {
        Animal animal1 = new Animal("Julian", "León");
        zoologico = new Zoologico("Loro Parque");
        zoologico.addAnimal(animal1);
        System.out.println(zoologico);    
    }
}
