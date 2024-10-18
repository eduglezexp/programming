package es.ies.puerto;

/**
 * Reto 5: Comparación de tres números
 * Solicita tres números al usuario y determina cuál de los tres es el mayor, cuál es el menor, 
 * o si son iguales.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Reto5 {
    public static void main(String[] args) {
        int numero1 = 5;
        int numero2 = 10;
        int numero3 = 7;
        System.out.println(compararNumeros(numero1, numero2, numero3));
    }

    public static String compararNumeros(int numero1, int numero2, int numero3) {
        if (numero1 == numero2 && numero2 == numero3) {
            return "Todos los numero son iguales";
        } 
        return "El numero mayor es el: " + numeroMayor(numero1, numero2, numero3) 
            + "\n" + "El numero menor es el: " + numeroMenor(numero1, numero2, numero3);
    }

    public static int numeroMayor(int numero1, int numero2, int numero3) {
        if (numero1 >= numero2 && numero1 >= numero3) {
            return numero1;
        } else if (numero2 >= numero1 && numero2 >= numero3) {
            return numero2;
        } else {
            return numero3;
        }
    }

    public static int numeroMenor(int numero1, int numero2, int numero3) {
        if (numero1 <= numero2 && numero1 <= numero3) {
            return numero1;
        } else if (numero2 <= numero1 && numero2 <= numero3) {
            return numero2;
        } else {
            return numero3;
        }
    }
}