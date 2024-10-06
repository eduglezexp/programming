package es.ies.puerto;

/**
 * Dos equipos de superhéroes han decidido fusionarse para enfrentar una amenaza mayor. 
 * Escribe un programa que combine ambos equipos en un solo array, sin que se repita 
 * ningún nombre.
 * @author
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        String[] equipo1 = {"Ironman", "Thor", "Hulk"}; 
        String[] equipo2 = {"Capitán América", "Thor", "Hawkeye"};
        int tamanioCompleto = equipo1.length + equipo2.length;
        String[] equipoCompleto = new String[tamanioCompleto];
        int indice = 0;
        for (int i = 0; i < equipo1.length; i++) {
            boolean duplicado = false;
            for (int j = 0; j < indice; j++) {
                if (equipoCompleto[j].equals(equipo1[i])) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                equipoCompleto[indice++] = equipo1[i];
            } 
        }
        for (int i = 0; i < equipo2.length; i++) {
            boolean duplicado = false;
            for (int j = 0; j < indice; j++) {
                if (equipoCompleto[j].equals(equipo2[i])) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                equipoCompleto[indice++] = equipo2[i];
            }
        }
        for (int i = 0; i < indice; i++) {
            System.out.print(equipoCompleto[i] + " ");
        }
    }
}
