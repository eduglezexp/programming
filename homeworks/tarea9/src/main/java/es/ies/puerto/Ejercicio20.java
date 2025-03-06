package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Juan", 
        "Pedro", "Lucía", "Carlos", "María"));
        System.out.println("Lista original: " +nombres);
        char letraEspecifica = 'A'; 
        String nuevoNombre = "Generico"; 
        actualizarNombres(nombres, letraEspecifica, nuevoNombre);
        System.out.println("Lista despues de la actualizacion: " +nombres);
    }

    /**
     * Actualiza los nombres que comienzan con una letra específica con un nuevo valor
     * @param lista 
     * @param letraEspecifica 
     * @param nuevoNombre 
     */
    public static List<String> actualizarNombres(List<String> lista, char letraEspecifica, String nuevoNombre) {
        for (int i = 0; i < lista.size(); i++) {
            String nombre = lista.get(i);
            if (nombre.charAt(0) == letraEspecifica) {
                lista.set(i, nuevoNombre);
            }
        }
        return lista;
    }
}