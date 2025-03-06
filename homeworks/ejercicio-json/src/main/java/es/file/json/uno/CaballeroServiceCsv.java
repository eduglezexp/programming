package es.file.json.uno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class CaballeroServiceCsv extends CaballeroService{
    String path = "src/main/resources/csv/caballeros.csv";
    File file;
    Caballero caballero;

    @Override
    public String toString() {
        return caballero.getId() + "," + caballero.getNombre() + "," + caballero.getConstelacion() 
        + "," + caballero.getNivel() + "," + caballero.getFechaIngreso();
    }

    /**
     * Metodo para escribir la lista de caballeros en el archivo CSV
     */
    public void guardarCaballeros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (Caballero caballero : caballeros) {
                this.caballero = caballero;
                bw.write(this.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}