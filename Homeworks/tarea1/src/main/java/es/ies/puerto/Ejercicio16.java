package es.ies.puerto;

public class Ejercicio16 {
    public static void main(String[] args) {
        int numero1 = 17;
        int numero2 = 5;

        float division = (float) numero1 / numero2;

        int residuo = numero1 % numero2;

        System.out.println("El resultado de la division es: " +division+ 
        ", y el residuo es: " +residuo);
    }
}