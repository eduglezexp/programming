package es.ies.puerto;

/**
 * Un equipo de aventureros ha derrotado a un dragón y ahora deben eliminarlo del 
 * registro de criaturas vivas. Escribe un programa que elimine a esta criatura 
 * específica del array.
 * @author euglezexp
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        String[] criaturas = {"Goblin", "Dragón", "Orco", "Troll"};
        String criaturaAEliminar = "Dragón"; 
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
    }
}
