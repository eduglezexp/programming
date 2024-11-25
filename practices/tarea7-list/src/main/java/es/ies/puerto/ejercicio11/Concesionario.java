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
        if (obtener(vehiculo) != null) {
            return false;
        }
        return vehiculos.add(vehiculo);
    }

    /**
     * Metodo para eliminar un vehiculo
     * @param vehiculo
     * @return true/false
     */
    public boolean eliminar() {
        vehiculos.remove(vehiculos.size()-1);
        return true;
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

    /**
     * Metodo para actualizar un vehiculo
     * @param vehiculo
     * @return true/false
     */
    public boolean actualizar(Vehiculo vehiculoActualizar) {
        if (vehiculoActualizar == null) {
            return false;
        }
        int posicion = vehiculos.indexOf(vehiculoActualizar);
        if (posicion < 0) {
            return false;
        }
        vehiculos.set(posicion, vehiculoActualizar);
        return true;
    }

    /**
     * Metodo para obtener un vehiculo por su matricula
     * @param matricula
     * @return vehiculo
     */
    public Vehiculo obtener(String matricula) {
        if (matricula == null) {
            return null;
        }
        Vehiculo vehiculoBuscar = new Vehiculo(matricula);
        return obtener(vehiculoBuscar);
    }
    
    /**
     * Metodo para obtener un vehiculo
     * @param vehiculo
     * @return vehiculo
     */
    public Vehiculo obtener(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return null;
        }
        int posicion = vehiculos.indexOf(vehiculo);
        return vehiculos.get(posicion);
    }

    @Override
    public String toString() {
        return "{nombre:" + nombre + ", vehiculos:" + vehiculos +"}";
    }
}