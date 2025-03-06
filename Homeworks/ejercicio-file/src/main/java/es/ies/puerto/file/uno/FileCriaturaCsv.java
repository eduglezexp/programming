package es.ies.puerto.file.uno;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCriaturaCsv extends FileXmlCriatura{
    String path = "src/main/resources/uno.csv";
    File file;
    Criatura criatura;

    public FileCriaturaCsv() {
        file = new File(path);
        criatura = new Criatura();
    }

    @Override
    public String toString() {
        return criatura.getId() + "," + criatura.getNombre() + "," + criatura.getDescripcion() + "," + criatura.getCategoria();
    }

    /**
     * Metodo para escribir la lista de armas en el archivo CSV
     */
    public void guardarCriaturas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (Criatura criatura : criaturas) {
                this.criatura = criatura;
                bw.write(this.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}