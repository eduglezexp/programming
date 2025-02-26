package es.file.csv;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.uno.CaballeroServiceCsv;

public class CaballeroServiceCsvTest {
    CaballeroServiceCsv caballeroServiceCsv;

    @BeforeEach 
    void beforeEach() {
        caballeroServiceCsv = new CaballeroServiceCsv();
    }

    @Test
    void caballeroList() {
        caballeroServiceCsv.guardarCaballeros();
    }
}
