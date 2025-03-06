package es.file.csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.tres.HechizoServiceCsv;

public class HechizoServiceCsvTest {
    HechizoServiceCsv hechizoServiceCsv;

    @BeforeEach 
    void beforeEach() {
        hechizoServiceCsv = new HechizoServiceCsv();
    }

    @Test
    void caballeroList() {
        hechizoServiceCsv.guardarhechizos();
    }
}