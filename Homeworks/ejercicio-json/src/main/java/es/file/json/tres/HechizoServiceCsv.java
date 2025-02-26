package es.file.json.tres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class HechizoServiceCsv extends HechizoService{
    String path = "src/main/resources/csv/hechizos.csv";
    File file;
    Hechizo hechizo;

    @Override
    public String toString() {
        return hechizo.getId() + "," + hechizo.getNombre() + "," + hechizo.getTipo() 
        + "," + hechizo.getEsOscuro() + "," + hechizo.getFechaCreacion();
    }

    /**
     * Metodo para escribir la lista de hechizos en el archivo CSV
     */
    public void guardarhechizos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (Hechizo hechizo : hechizos) {
                this.hechizo = hechizo;
                bw.write(this.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
