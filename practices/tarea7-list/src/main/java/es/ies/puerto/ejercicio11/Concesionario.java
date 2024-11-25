package es.ies.puerto.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private String nombre;
    private List<Vehiculo> vehiculos;

    /**
     * Constructor por defecto
     */
    public Concesionario() {
        vehiculos = new ArrayList<>();
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Concesionario(String nombre) {
        this.nombre = nombre;
        vehiculos = new ArrayList<>();
    }

    /**
     * Metodo para agregar un vehiculo
     * @param vehiculo
     * @return true/false
     */
    public boolean agregar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        return vehiculos.add(vehiculo);
    }

    /**
     * Metodo para eliminar un vehiculo
     * @param vehiculo
     * @return true/false
     */
    public boolean eliminar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        return vehiculos.remove(vehiculo);
    }

    @Override
    public String toString() {
        return "{nombre=" + nombre + ", vehiculos=" + vehiculos +"}";
    }
}