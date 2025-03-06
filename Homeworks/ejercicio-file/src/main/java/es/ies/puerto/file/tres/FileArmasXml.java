package es.ies.puerto.file.tres;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FileArmasXml extends FileArmasCsv{
    String path = "src/main/resources/tres.xml";
    File file;

    public FileArmasXml() {
        file = new File(path);
    }

    /**
     * Metodo para escribir la lista de criaturas en el archivo XML
     */
    public void volcarArmasXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("armas"); 
            doc.appendChild(root);

            for (Arma arma : armas) {
                Element criaturaXml = doc.createElement("arma");
                root.appendChild(criaturaXml);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(arma.getId()));
                criaturaXml.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(arma.getNombre()));
                criaturaXml.appendChild(nombre);

                Element descripcion = doc.createElement("descripcion");
                descripcion.appendChild(doc.createTextNode(arma.getDescripcion()));
                criaturaXml.appendChild(descripcion);

                Element origen = doc.createElement("origen");
                origen.appendChild(doc.createTextNode(arma.getOrigen()));
                criaturaXml.appendChild(origen);

                Element fuerza = doc.createElement("fuerza");
                fuerza.appendChild(doc.createTextNode(String.valueOf(arma.getFuerza())));
                criaturaXml.appendChild(fuerza);
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
