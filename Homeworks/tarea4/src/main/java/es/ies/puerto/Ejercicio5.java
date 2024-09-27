package es.ies.puerto;

/**
 * Crea una matriz de 5x5 (array bidimensional) que represente una ciudad del inframundo 
 * la serie "Stranger Things". Llénala con el valor 0 para indicar zonas seguras y 1 
 * para zonas con Demogorgons. Luego, recorre la matriz para imprimirla en formato de tablero.
 * @author eduglezexp
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] ciudad = new int[5][5];
        ciudad[0] = new int[]{0, 1, 0, 0, 1};
        ciudad[1] = new int[]{1, 0, 0, 1, 0};
        ciudad[2] = new int[]{0, 0, 1, 0, 0};
        ciudad[3] = new int[]{0, 1, 0, 1, 0};
        ciudad[4] = new int[]{1, 0, 0, 0, 1};

        System.out.println("Ciudad del Inframundo:");
        for (int i = 0; i < ciudad.length; i++) {
            for (int j = 0; j < ciudad[i].length; j++) {
                System.out.print(ciudad[i][j] + " "); 
            }
            System.out.println(); 
        }
    }
}
