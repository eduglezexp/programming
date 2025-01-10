package es.ies.puerto.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.ies.puerto.*;

public class AnimalSet {
    private Set<Animal> animales;
    
    /**
     * Constructor por defecto
     */
    public AnimalSet() {
        this.animales = new HashSet<>();
    }
    
    /**
     * Funcion para agregar un animal a la lista
     * @param animal
     * @return true/false
     */
    public boolean agregar(Animal animal) {
        if (!animales.contains(animal)) {
            return animales.add(animal);
        } else {
            return false;
        }
    }

    /**
     * Funcion para listar los animales
     * @return hashSet con la lista animales
     */
    public Set<Animal> listarAnimales() {
        return new HashSet(animales);
    }
    
    /**
     * Funcion para buscar animales
     * @param identificador 
     * @return animal buscado
     */
    public Animal buscar(String identificador) {
        return animales.stream().filter(p -> p.getIdentificador().equals(identificador)).findFirst().orElse(null);         
    }

    /**
     * Funcion para actualizar un animal
     * @param identificador
     * @param nuevoAnimal
     * @return true/false
     */
    public boolean actualizar(String identificador, Animal nuevoAnimal) {
        Animal animalBuscar = new Animal(identificador);
        for (Animal animal : animales) {
            if (animal.equals(animalBuscar)) {
                animal = nuevoAnimal;
                return true; 
            }
        }
        return false;
    }

    /**
     * Funcion para eliminar un animal
     * @param identificador
     * @return true/false
     */
    public boolean eliminar(String identificador) {
        Animal animalEliminar = new Animal(identificador);
        return animales.remove(animalEliminar); 
    }
}