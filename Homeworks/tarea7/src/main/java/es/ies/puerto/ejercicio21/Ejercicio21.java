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

public class Ejercicio21 {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Pablo", "Cajero", 1500);
        Empleado empleado2 = new Empleado("Pedro", "Cajero", 1500);
        Empresa empresa = new Empresa("Leroy Merlin");
        empresa.addEmpleado(empleado1);
        empresa.addEmpleado(empleado2);
        System.out.println(empresa);
        empresa.deleteEmpleado(empleado1);
        System.out.println(empresa);
    }
}
