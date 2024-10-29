package es.ies.puerto.ejercicio24;

import java.util.Arrays;

/**
 * 24. Clase Zoológico con Animales
 * Crea una clase Zoologico que almacene una lista (array) (array) de animales 
 * (clase Animal) con atributos nombre y especie. Implementa métodos para agregar, 
 * eliminar y listar animales. Usa toString() para describir el zoológico.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Zoologico {
    private int numeroAnimales;
    private String nombre;
    private Animal[] animales;

    /**
     * Constructor por defecto
     */
    public Zoologico() {
        numeroAnimales = 0;
        animales = new Animal[5];
    }   

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Zoologico(String nombre) {
        this.nombre = nombre;
        numeroAnimales = 0;
        animales = new Animal[5];
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param animales
     */
    public Zoologico(String nombre, Animal[] animales) {
        this.nombre = nombre;
        this.animales = animales;
        numeroAnimales = 0;
        animales = new Animal[5];
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    public void setAnimales(Animal[] animales) {
        this.animales = animales;
    }

    /**
     * Funcion para incluir un animal a la lista
     * @param animal nuevo
     * @return true/false
     */
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (numeroAnimales >= animales.length) {
            return false;
        }
        animales[numeroAnimales] = animal;
        numeroAnimales++;  
        return true;
    }

    public boolean deleteAnimal(Animal animalEliminar) {
        if (animalEliminar == null) {
            return false;
        }
        if (numeroAnimales == 0) {
            return false;
        }
        for (int i = 0; i < animales.length; i++) {
            if (animalEliminar.equals(animales[i])) {
                animales[i] = null;
                numeroAnimales--;
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar a un animal
     */
    public void ordenarLista() {
        for (int i = 0; i < animales.length-1; i++) {
            if (animales[i] == null) {
                animales[i] = animales[i+1];
                animales[i+1] = null;
            }
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre+ "\n";
        for (Animal animal : animales) {
            if (animal != null) {
                mensaje += animal.toString();
            }
        }
        return mensaje;
    }

    public int getNumeroAnimales() {
        return numeroAnimales;
    }

    public void setNumeroAnimales(int numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    }   
}