package es.file.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.dos.TributoServiceXml;

public class TributoServiceXmlTest {
    TributoServiceXml tributoServiceXml;

    @BeforeEach 
    void beforeEach() {
        tributoServiceXml = new TributoServiceXml();
    }

    @Test
    void caballeroList() {
        tributoServiceXml.volcarTributosXml();
    }
}
