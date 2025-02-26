package es.file.csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.dos.TributoServiceCsv;

public class TributoServiceCsvTest {
    TributoServiceCsv tributoServiceCsv;

    @BeforeEach 
    void beforeEach() {
        tributoServiceCsv = new TributoServiceCsv();
    }

    @Test
    void caballeroList() {
        tributoServiceCsv.guardarTributos();
    }
}