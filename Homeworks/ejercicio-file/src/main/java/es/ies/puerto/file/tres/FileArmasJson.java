package es.ies.puerto.file.tres;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileArmasJson extends FileArmasCsv{
    ObjectMapper objectMapper;
    File file;
    String path = "src/main/resources/tres.json";

    /**
     * Constructor por defecto
     */
    public FileArmasJson() {
        objectMapper = new ObjectMapper();
        file = new File(path);
    }

    /**
     * Metodo para guardar un archivo
     * @param file del tributo
     * @param armas lista de tributos
     */
    public void saveFile(File file, List<Arma> armas) {
        try {
            objectMapper.writeValue(file, armas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}