package es.file.json.dos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class TributoServiceCsv extends TributoService{
    String path = "src/main/resources/csv/tributos.csv";
    File file;
    Tributo tributo;

    @Override
    public String toString() {
        return tributo.getId() + "," + tributo.getNombre() + "," + tributo.getDistrito() 
        + "," + tributo.getVoluntario() + "," + tributo.getFechaSeleccion();
    }

    /**
     * Metodo para escribir la lista de tributos en el archivo CSV
     */
    public void guardarTributos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (Tributo tributo : tributos) {
                this.tributo = tributo;
                bw.write(this.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
