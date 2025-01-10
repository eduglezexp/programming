package es.ies.puerto.list;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.*;

public class AnimalList {
    private List<Animal> animales;

    /**
     * Constructor por defecto
     */
    public AnimalList() {
        this.animales = new ArrayList<>();
    }

    /**
     * Funcion para agregar un animal a la lista
     * @param animal
     * @return true/false
     */
    public boolean agregar(Animal animal) {
        if (!animales.contains(animal)) {
            return animales.add(animal);
        } 
        return false;
    }

    /**
     * Funcion para listar los animales
     * @return arrayList con la lista animales
     */
    public List<Animal> listar() {
        return new ArrayList<>(animales);
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
        int posicion = animales.indexOf(animalBuscar);
        if (posicion < 0) {
            return false;
        }
        animales.set(posicion, nuevoAnimal);
        return true;
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