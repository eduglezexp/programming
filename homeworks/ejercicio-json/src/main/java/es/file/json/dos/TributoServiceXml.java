package es.file.json.dos;

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

public class TributoServiceXml extends TributoService{
    String path = "src/main/resources/xml/tributos.xml";
    File file;

    /**
     * Constructor por defecto
     */
    public TributoServiceXml() {
        file = new File(path);
    }

    /**
     * Metodo para escribir la lista de tributos en el archivo XML
     */
    public void volcarTributosXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("tributos"); 
            doc.appendChild(root);

            for (Tributo tributo : tributos) {
                Element tributoXml = doc.createElement("tributo");
                root.appendChild(tributoXml);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(tributo.getId())));
                tributoXml.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(tributo.getNombre()));
                tributoXml.appendChild(nombre);

                Element distrito = doc.createElement("distrito");
                distrito.appendChild(doc.createTextNode(String.valueOf(tributo.getDistrito())));
                tributoXml.appendChild(distrito);

                Element voluntario = doc.createElement("voluntario");
                voluntario.appendChild(doc.createTextNode(String.valueOf(tributo.getVoluntario())));
                tributoXml.appendChild(voluntario);

                Element fechaSeleccion = doc.createElement("fechaSeleccion");
                fechaSeleccion.appendChild(doc.createTextNode(tributo.getFechaSeleccion()));
                tributoXml.appendChild(fechaSeleccion);
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
