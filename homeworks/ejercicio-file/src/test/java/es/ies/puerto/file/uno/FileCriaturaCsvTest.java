package es.ies.puerto.file.uno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileCriaturaCsvTest {
    FileCriaturaCsv fileCriaturaCsv;

    @BeforeEach
    void beforeEach() {
        fileCriaturaCsv = new FileCriaturaCsv();
    }

    @Test
    void armaTest() {
        fileCriaturaCsv.guardarCriaturas();
    }
}
