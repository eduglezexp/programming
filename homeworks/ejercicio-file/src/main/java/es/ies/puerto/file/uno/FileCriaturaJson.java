package es.ies.puerto.file.uno;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileCriaturaJson extends FileXmlCriatura{
    ObjectMapper objectMapper;
    File file;
    String path = "src/main/resources/uno.json";

    public FileCriaturaJson() {
        objectMapper = new ObjectMapper();
        file = new File(path);
    }

    /**
     * Metodo para guardar un archivo
     * @param file del tributo
     * @param criaturas lista de tributos
     */
    public void saveFile(File file, List<Criatura> criaturas) {
        try {
            objectMapper.writeValue(file, criaturas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
