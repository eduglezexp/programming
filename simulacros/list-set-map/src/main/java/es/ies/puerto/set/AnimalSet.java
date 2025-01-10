package es.ies.puerto.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.ies.puerto.*;

public class AnimalSet {
    private Set<Animal> animales;

    public AnimalSet() {
        this.animales = new HashSet<>();
    }

    public boolean agregar(Animal animal) {
        if (!animales.contains(animal)) {
            return animales.add(animal);
        } else {
            return false;
        }
    }

    public Set<Animal> listarAnimales() {
        return new HashSet(animales);
    }

    public Animal buscar(String identificador) {
        return animales.stream().filter(p -> p.getIdentificador().equals(identificador)).findFirst().orElse(null);         
    }

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

    public boolean eliminar(String identificador) {
        Animal animalEliminar = new Animal(identificador);
        return animales.remove(animalEliminar); 
    }

}
