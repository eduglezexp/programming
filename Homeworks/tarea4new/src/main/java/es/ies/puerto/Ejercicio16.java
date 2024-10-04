package es.ies.puerto;

/**
 * El equipo de científicos del Área 51 ha registrado una lista de criaturas hostiles, 
 * y tu misión es eliminar una criatura específica del registro. Escribe un programa 
 * que elimine la criatura que ya ha sido contenida.
 * @author eduglezexp
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        String[] criaturas = {"Alien", "Monstruo del Pantano", "Demonio", "Serpiente Gigante"};
        String criaturaAEliminar = "Demonio"; 
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
