package es.ies.puerto.file.tres;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileArmaJsonTest {
    FileArmasJson fileArmasJson;
    List<Arma> armas;

    @BeforeEach
    void beforeEach() {
        fileArmasJson = new FileArmasJson();
        armas = fileArmasJson.obtenerArmas();
    }

    @Test
    void armaTest() {
        fileArmasJson.saveFile(fileArmasJson.file, armas);
    }
}
