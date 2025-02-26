package es.file.json.uno;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class CaballeroServiceXml extends CaballeroService {
    String path = "src/main/resources/xml/caballeros.xml";
    File file;

    /**
     * Constructor por defecto
     */
    public CaballeroServiceXml() {
        file = new File(path);
    }

    /**
     * Metodo para escribir la lista de caballeros en el archivo XML
     */
    public void volcarCaballerosXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("caballeros"); 
            doc.appendChild(root);

            for (Caballero caballero : caballeros) {
                Element caballeroXml = doc.createElement("caballero");
                root.appendChild(caballeroXml);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(caballero.getId())));
                caballeroXml.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(caballero.getNombre()));
                caballeroXml.appendChild(nombre);

                Element constelacion = doc.createElement("constelacion");
                constelacion.appendChild(doc.createTextNode(caballero.getConstelacion()));
                caballeroXml.appendChild(constelacion);

                Element nivel = doc.createElement("nivel");
                nivel.appendChild(doc.createTextNode(String.valueOf(caballero.getNivel())));
                caballeroXml.appendChild(nivel);

                Element fechaIngreso = doc.createElement("fechaIngreso");
                fechaIngreso.appendChild(doc.createTextNode(caballero.getFechaIngreso()));
                caballeroXml.appendChild(fechaIngreso);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo XML: " + e.getMessage());
        }
    }
}