package es.ies.puerto.ejercicio21;

import es.ies.puerto.ejercicio9.Empleado;

/**
 * 21. Clase Empresa con Empleados
 * Crea una clase Empresa con una lista (array) de empleados. Implementa métodos para agregar, 
 * eliminar y listar empleados. Usa toString() para mostrar los detalles de la empresa.
 * La lista (array) de empleados estará en un array de Empleados del ejercicio 9.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Empresa {
    private int numeroEmpleados;
    private String nombre;
    private Empleado[] empleados;

    /**
     * Constructor por defecto
     */
    public Empresa() {
        numeroEmpleados = 0;
        empleados = new Empleado[5]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
        numeroEmpleados = 0;
        empleados = new Empleado[5];
    }

    /**
     * Getters y Setters
     */
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    /**
     * Método para agregar un empleado al array de empleados.
     * @param empleado El nuevo empleado
     * @return true si se agregó con éxito, false si no hay espacio
     */
    public boolean addEmpleado(Empleado empleado) {
        if (empleado == null) { 
            return false;
        }
        if (numeroEmpleados >= empleados.length) {
            return false;
        }
        empleados[numeroEmpleados] = empleado;
        numeroEmpleados++;
        return true;
    }

    /**
     * Método para eliminar un empleado del array
     * @param empleadoEliminar El empleado a eliminar
     * @return true si se eliminó con éxito, false si no se encontró
     */
    public boolean deleteEmpleado(Empleado empleadoEliminar) {
        if (empleadoEliminar == null || numeroEmpleados == 0) {
            return false;
        }
        for (int i = 0; i < empleados.length; i++) {
            if (empleadoEliminar.equals(empleados[i])) {
                empleados[i] = null;
                numeroEmpleados--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar el array de empleados despues de una eliminacion
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null) {
                empleados[index++] = empleados[i];
            }
        }
        while (index < empleados.length) {
            empleados[index++] = null;
        }
    }

    /**
     * Metodo toString para mostrar detalles de la empresa y sus empleados
     */
    @Override
    public String toString() {
        String mensaje = "Nombre de Empresa: " + nombre + "\n";
        for (Empleado empleado : empleados) {
            if (empleado != null) {
                mensaje += empleado.toString(); 
            }
        }
        return mensaje;
    }
}