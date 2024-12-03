package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        List<String> listaNombres = inicializarLista();
        System.out.println("Lista original: " + listaNombres);
        char letraEspecifica = 'A'; 
        String nuevoNombre = "Generico"; 
        actualizarNombres(listaNombres, letraEspecifica, nuevoNombre);
        System.out.println("Lista después de la actualización: " + listaNombres);
    }

    /**
     * Inicializa la lista con algunos nombres
     * @return La lista de nombres
     */
    public static List<String> inicializarLista() {
        List<String> lista = new ArrayList<>();
        lista.add("Ana");
        lista.add("Juan");
        lista.add("Pedro");
        lista.add("Lucía");
        lista.add("Alejandro");
        lista.add("Carlos");
        return lista;
    }

    /**
     * Actualiza los nombres que comienzan con una letra específica con un nuevo valor
     * @param lista 
     * @param letraEspecifica 
     * @param nuevoNombre 
     */
    public static void actualizarNombres(List<String> lista, char letraEspecifica, String nuevoNombre) {
        for (int i = 0; i < lista.size(); i++) {
            String nombre = lista.get(i);
            if (nombre.charAt(0) == letraEspecifica) {
                lista.set(i, nuevoNombre);
            }
        }
    }
}