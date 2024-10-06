package es.ies.puerto;

/**
 * Un equipo de aventureros ha derrotado a un dragón y ahora deben eliminarlo del 
 * registro de criaturas vivas. Escribe un programa que elimine a esta criatura 
 * específica del array.
 * @author euglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        String[] criaturas = {"Goblin", "Dragón", "Orco", "Troll"};
        String criaturaAEliminar = "Dragón"; 
        int tamanio = criaturas.length -1;
        String[] nuevasCriaturas = new String[tamanio];
        int indiceCriatura = 0;
        for (int i = 0; i < criaturas.length; i++) {
            if (!criaturaAEliminar.equals(criaturas[i])) {
                String temporal = criaturas[i];
                nuevasCriaturas[indiceCriatura] = temporal;
                indiceCriatura++;
            }
        }
        System.out.println(criaturaAEliminar + " ha sido eliminado del registro.");
        for (String nuevaCriatura : nuevasCriaturas) {
            System.out.print(nuevaCriatura+ " ");
        }

        /** Otra forma de hacerlo
        int nuevoTamanio = 0;
        for (String criatura : criaturas) {
            if (!criatura.equals(criaturaAEliminar)) {
                nuevoTamanio++;
            }
        }
        String[] nuevasCriaturas = new String[nuevoTamanio];
        int indice = 0;
        for (String criatura : criaturas) {
            if (!criatura.equals(criaturaAEliminar)) {
                nuevasCriaturas[indice++] = criatura;
            }
        }
        System.out.println(criaturaAEliminar + " ha sido eliminado del registro.");
        for (String nuevaCriatura : nuevasCriaturas) {
            System.out.print(nuevaCriatura+ " ");
        }
        */
    }
}
