package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        Vector<String> vectorA = new Vector<>();
        Vector<String> vectorB = new Vector<>();
        vectorA.add("Perro");
        vectorA.add("Gato");
        vectorB.add("Gato");
        vectorB.add("Caballo");
        System.out.println("Vector A: " + vectorA);
        System.out.println("Vector B: " + vectorB);
        Vector<String> combinado = fusionarVectores(vectorA, vectorB);
        System.out.println("Combinado: " +combinado);
    }
    
    /**
     * Metodo para fusionar dos vectores dados
     * @param vectorA
     * @param vectorB
     * @return vector combinado
     */
    public static Vector<String> fusionarVectores(Vector<String> vectorA, Vector<String> vectorB) {
        Vector<String> combinado = new Vector<>(vectorA);
        for (String elemento : vectorB) {
            if (!combinado.contains(elemento)) {
                combinado.add(elemento);
            }
        }
        return combinado;
    }
}