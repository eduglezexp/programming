package es.file.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.uno.CaballeroServiceXml;

public class CaballeroServiceXmlTest {
    CaballeroServiceXml caballeroServiceXml;

    @BeforeEach 
    void beforeEach() {
        caballeroServiceXml = new CaballeroServiceXml();
    }

    @Test
    void caballeroList() {
        caballeroServiceXml.volcarCaballerosXml();
    }
}