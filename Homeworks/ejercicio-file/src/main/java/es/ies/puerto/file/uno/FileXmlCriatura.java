package es.ies.puerto.file.uno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class FileXmlCriatura {
    static List<Criatura> criaturas;
    String path = "src/main/resources/uno.xml";

    /**
     * Constructor por defecto
     */
    public FileXmlCriatura() throws Exception{
        criaturas = new ArrayList<>();
        File archivo = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        prepararLista(doc);
    }

    /**
     * Metodo para hacer que la lista tenga la informacion del fichero
     * @param doc para obtener el elemento por tag
     */
    private void prepararLista(Document doc){
        NodeList lista = doc.getElementsByTagName("criatura");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                Criatura criatura = new Criatura(id, nombre, descripcion, categoria);
                criaturas.add(criatura);
            }
        }
    }

    public static void volcarCriaturaXml() throws Exception  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("empleados");
        doc.appendChild(root);
        
        for (Criatura criatura : criaturas) {

            Element criaturaXml = doc.createElement("criatura");
            root.appendChild(criaturaXml);

            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(criatura.getId()));
            criaturaXml.appendChild(id);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(criatura.getNombre()));
            criaturaXml.appendChild(nombre);
            
            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode(criatura.getDescripcion()));
            criaturaXml.appendChild(descripcion);
            
            Element categoria = doc.createElement("categoria");
            categoria.appendChild(doc.createTextNode(criatura.getCategoria()));
            criaturaXml.appendChild(categoria);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/uno.xml"));
        transformer.transform(source, result);
    }

    public List<Criatura> obtenerCriaturas() {
        return criaturas;
    }

    public Criatura obtener(Criatura criatura) {
        if (criatura == null || !criaturas.contains(criatura)) {
            return null;
        }
        int posicion = criaturas.indexOf(criatura);
        return criaturas.get(posicion);
    }

    public void addCriatura(Criatura criatura) {
        if (criatura == null || criaturas.contains(criatura)) {
            return;
        }
        criaturas.add(criatura);
        volcarCriaturaXml();
    }

    public void deleteCriatura(Criatura criatura) {

    }
    public void updateCriatura(Criatura criatura) {

    }
}
