package es.ies.puerto.file.tres;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileArmaXmlTest {
    FileArmasXml fileArmasXml;

    @BeforeEach
    void beforeEach() {
        fileArmasXml = new FileArmasXml();
    }

    @Test
    void armaTest() {
        fileArmasXml.volcarArmasXml();
    }
}   
