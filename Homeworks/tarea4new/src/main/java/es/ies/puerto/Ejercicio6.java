package es.ies.puerto;

/**
 * Un droide está buscando un cristal Kyber en una lista de recursos recolectados 
 * por el equipo rebelde. Escribe un programa que busque un valor específico en el 
 * array y verifique si el cristal Kyber está presente.
 * @author euglezexp
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        String[] recursos = {"Bláster", "Cristal Kyber", "Sable de luz", "Pistola"}; 
        String recursoBuscado = "Cristal Kyber";
        boolean encontrado = false;
        for (String recurso : recursos) {
            if (recurso.equals(recursoBuscado)) {
                System.out.println(recursoBuscado + " se encuentra en el inventario.");
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            System.out.println(recursoBuscado + " no está en la lista.");
        }
    }
}
