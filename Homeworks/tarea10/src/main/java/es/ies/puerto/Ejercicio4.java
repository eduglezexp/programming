package es.ies.puerto;

import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean eliminarElemento(List<Integer> lista, int valor) {
        for (Integer numero : lista) {
            if (numero.equals(valor)) {
                lista.remove(valor);
                break;
            }
        }
        return true;
    }
}