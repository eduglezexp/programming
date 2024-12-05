package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println(crearListaConsecutiva(-1, 5));
    }

    public static List<Integer> crearListaConsecutiva(int inicio, int cantidad) {
        List<Integer> lista = new ArrayList<>();
        for (int i = inicio; i < (cantidad+inicio); i++) {
            lista.add(i);
        }
        return lista;
    }
}