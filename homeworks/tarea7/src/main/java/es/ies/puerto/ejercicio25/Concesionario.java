package es.ies.puerto.ejercicio25;

import es.ies.puerto.ejercicio11.Vehiculo;

public class Concesionario {
    private int numeroVehiculos;
    private String nombre;
    private Vehiculo[] vehiculos;

    /**
     * Constructor por defecto
     */
    public Concesionario() {
        numeroVehiculos = 0;
        vehiculos = new Vehiculo[5];
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Concesionario(String nombre) {
        this.nombre = nombre;
        numeroVehiculos = 0;
        vehiculos = new Vehiculo[5];
    }

    /**
     * Getters and Setters
     */
    public int getNumeroVehiculos() {
        return numeroVehiculos;
    }

    public void setNumeroVehiculos(int numeroVehiculos) {
        this.numeroVehiculos = numeroVehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Metodo para incluir un vehiculo a la lista
     * @param vehiculo
     * @return true/false
     */
    public boolean addVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        if (numeroVehiculos >= vehiculos.length) {
            return false;
        }
        vehiculos[numeroVehiculos] = vehiculo;
        numeroVehiculos++;
        return true;
    }

    /**
     * Metodo para eliminar un vehiculo de la lista
     * @param vehiculo
     * @return true/false
     */
    public boolean deleteVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        if (numeroVehiculos == 0)  {
            return false;
        }
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculo.equals(vehiculos[i])) {
                vehiculos[i] = null;
                numeroVehiculos--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un vehiculo
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                vehiculos[index++] = vehiculos[i];
            }
        }
        while (index < vehiculos.length) {
            vehiculos[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo != null) {
                mensaje += vehiculo.toString();
            }
        }
        return mensaje;
    }
}