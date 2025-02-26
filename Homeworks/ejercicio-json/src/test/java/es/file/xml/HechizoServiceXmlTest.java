package es.file.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.tres.HechizoServiceXml;

public class HechizoServiceXmlTest {
    HechizoServiceXml hechizoServiceXml;

    @BeforeEach 
    void beforeEach() {
        hechizoServiceXml = new HechizoServiceXml();
    }

    @Test
    void caballeroList() {
        hechizoServiceXml.volcarHechizosXml();
    }
}
