package es.ies.puerto;

/**Un alquimista ha creado varias pociones y desea organizar su almacén. Las pociones 
 * curativas contienen la palabra "Curación". Escribe un programa que separe las pociones 
 * curativas de las otras.
 * @author eduglezexp
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        String[] pociones = {"Poción de Curación", "Poción de Veneno", "Curación Mayor", "Poción de Invisibilidad"}; 
        int contadorCurativas = 0;
        for (String pocion : pociones) {
            if (pocion.contains("Curación")) {
                contadorCurativas++;
            }
        }
        int tamanioOtrasPociones = pociones.length - contadorCurativas;
        String[] pocionesCurativas = new String[pociones.length]; 
        String[] otrasPociones = new String[tamanioOtrasPociones];
        int indiceCurativas = 0;
        int indiceOtras = 0;
        for (String pocion : pociones) {
            if (pocion.contains("Curación")) {
                pocionesCurativas[indiceCurativas] = pocion;
                indiceCurativas++;
            } else {
                otrasPociones[indiceOtras] = pocion;
                indiceOtras++;
            }
        }
        for (String pocion : pocionesCurativas) {

            System.out.print(pocion+ ", ");
        }
        for (String pocion : otrasPociones) {
            System.out.print(pocion+ ", ");
        }
    }
}
