package es.ies.puerto;

/**
 * Dado el nombre "Thor Odinson", crea un programa que 
 * imprima solo el apellido usando substring() y indexOf().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio21 {
    public static void main(String[] args) {
        String nombreCompleto = "Thor Odinson";
        int espacio = nombreCompleto.indexOf(" ");
        String apellido = nombreCompleto.substring(espacio + 1);
        System.out.println(apellido);
    }
}