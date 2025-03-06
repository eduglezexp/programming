package es.ies.puerto.file.uno;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileCriaturaJsonTest {
    FileCriaturaJson fileCriaturaJson;
    List<Criatura> criaturas;

    @BeforeEach
    void beforeEach() {
        fileCriaturaJson = new FileCriaturaJson();
        criaturas = fileCriaturaJson.obtenerCriaturas();
    }

    @Test
    void armaTest() {
        fileCriaturaJson.saveFile(fileCriaturaJson.file, criaturas);
    }
}
