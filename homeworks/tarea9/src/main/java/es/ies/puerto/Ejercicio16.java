package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 * posible examen
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        List<List<String>> resultadoExamen = inicializarResultados();
        float promedio = calcularPromedio(resultadoExamen);
        List<List<String>> mejoresTres = obtenerMejoresTres(resultadoExamen);
        List<List<String>> debajoPromedio = filtrarPromedioPorDebajo(resultadoExamen, promedio);
        System.out.println("Tres mejores estudiantes:");
        for (List<String> estudiante : mejoresTres) {
            System.out.println("Nombre: " + estudiante.get(0) + ", Nota: " + estudiante.get(1));
        }

        System.out.println("\nEstudiantes por debajo del promedio:");
        for (List<String> estudiante : debajoPromedio) {
            System.out.println("Nombre: " + estudiante.get(0) + ", Nota: " + estudiante.get(1));
        }
        System.out.println("\nPromedio general: " +promedio);
    }

    /**
     * Metodo para agregar los resultados
     * @return lista con los resultados del examen
     */
    private static List<List<String>> inicializarResultados() {
        List<List<String>> resultadoExamen = new ArrayList<>();
        resultadoExamen.add(List.of("Juan", "85"));
        resultadoExamen.add(List.of("María", "90"));
        resultadoExamen.add(List.of("Pedro", "70"));
        resultadoExamen.add(List.of("Ana", "95"));
        resultadoExamen.add(List.of("Luis", "60"));
        resultadoExamen.add(List.of("Sofía", "88"));
        return resultadoExamen;
    }

    /**
     * Metodo para calcular el promedio de las notas
     * @param resultadoExamen
     * @return promedio de las notas
     */
    private static float calcularPromedio(List<List<String>> resultadoExamen) {
        int suma = 0;
        for (List<String> resultado : resultadoExamen) {
            suma += Integer.parseInt(resultado.get(1)); 
        }
        return suma / resultadoExamen.size(); 
    }

    /**
     * Metodo para obtener los tres mejores estudiantes
     * @param resultadoExamen
     * @return lista con los tres mejores estudiantes
     */
    private static List<List<String>> obtenerMejoresTres(List<List<String>> resultadoExamen) {
        resultadoExamen.sort((a, b) -> Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1))); 
        return resultadoExamen.subList(0, Math.min(3, resultadoExamen.size())); 
    }

    /**
     * Metodo para filtrar a los estudiantes por debajo del promedio
     * @param resultadoExamen
     * @param promedio
     * @return debajo del promedio
     */
    private static List<List<String>> filtrarPromedioPorDebajo(List<List<String>> resultadoExamen, float promedio) {
        List<List<String>> debajoPromedio = new ArrayList<>();
        for (List<String> resultado : resultadoExamen) {
            if (Integer.parseInt(resultado.get(1)) < promedio) {
                debajoPromedio.add(resultado);
            }
        }
        return debajoPromedio;
    }
}