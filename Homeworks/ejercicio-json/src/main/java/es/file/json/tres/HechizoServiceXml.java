package es.file.json.tres;

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

public class HechizoServiceXml extends HechizoService{
    String path = "src/main/resources/xml/hechizos.xml";
    File file;

    /**
     * Constructor por defecto
     */
    public HechizoServiceXml() {
        file = new File(path);
    }

    /**
     * Metodo para escribir la lista de hechizos en el archivo XML
     */
    public void volcarHechizosXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("hechizos"); 
            doc.appendChild(root);

            for (Hechizo hechizo : hechizos) {
                Element tributoXml = doc.createElement("hechizo");
                root.appendChild(tributoXml);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(hechizo.getId())));
                tributoXml.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(hechizo.getNombre()));
                tributoXml.appendChild(nombre);

                Element tipo = doc.createElement("tipo");
                tipo.appendChild(doc.createTextNode(hechizo.getTipo()));
                tributoXml.appendChild(tipo);

                Element esOscuro = doc.createElement("esOscuro");
                esOscuro.appendChild(doc.createTextNode(String.valueOf(hechizo.getEsOscuro())));
                tributoXml.appendChild(esOscuro);

                Element fechaCreacion = doc.createElement("fechaCreacion");
                fechaCreacion.appendChild(doc.createTextNode(hechizo.getFechaCreacion()));
                tributoXml.appendChild(fechaCreacion);
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