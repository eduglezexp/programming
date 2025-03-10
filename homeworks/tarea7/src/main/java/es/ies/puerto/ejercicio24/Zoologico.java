package es.ies.puerto.ejercicio24;

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
     * Getters and Setters
     */
    public int getNumeroAnimales() {
        return numeroAnimales;
    }

    public void setNumeroAnimales(int numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    } 

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
     * Metodo para incluir un animal a la lista
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

    /**
     * Metodo para eliminar un animal
     * @param animalEliminar
     * @return true/false
     */
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
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar a un animal
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null) {
                animales[index++] = animales[i];
            }
        }
        while (index < animales.length) {
            animales[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (Animal animal : animales) {
            if (animal != null) {
                mensaje += animal.toString();
            }
        }
        return mensaje;
    }  
}