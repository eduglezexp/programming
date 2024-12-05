package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList("Hola", "Mundo", "Java"));
        int indice = 3;
        System.out.println(obtenerElemento(lista, indice));
    }

    public static String obtenerElemento(List<String> lista, int indice) {
        String vacio = "";
        if (lista == null || lista.isEmpty()) {
            return vacio;
        }
        if (indice < 0 || indice >= lista.size()) {
            return vacio;
        }
        return lista.get(indice);
    }
}