package es.ies.puerto.file.uno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
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
    private static List<Criatura> criaturas;
    private static final String PATH = "src/main/resources/uno.xml";

    /**
     * Constructor por defecto 
     */
    public FileXmlCriatura() {
        criaturas = new ArrayList<>();
        File archivo = new File(PATH);
        if (!archivo.exists()) {
            System.err.println("Archivo XML no encontrado: " + PATH);
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivo);
            prepararLista(doc);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

    /**
     * Metodo para llenar la lista de criaturas con la información del archivo XML
     * @param doc Documento XML a procesar
     */
    private void prepararLista(Document doc) {
        NodeList lista = doc.getElementsByTagName("criatura");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                criaturas.add(new Criatura(id, nombre, descripcion, categoria));
            }
        }
    }

    /**
     * Metodo para escribir la lista de criaturas en el archivo XML
     */
    public static void volcarCriaturaXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("criaturas"); 
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
            StreamResult result = new StreamResult(new File(PATH));
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo XML: " + e.getMessage());
        }
    }

    /**
     * Metodo que obtiene la lista de todas las criaturas
     * @return Lista de criaturas almacenadas
     */
    public List<Criatura> obtenerCriaturas() {
        return new ArrayList<>(criaturas); 
    }

    /**
     * Metodo que obtiene una criatura especifica por su ID
     * @param criatura Criatura a buscar
     * @return criatura si se encuentra
     */
    public Criatura obtener(Criatura criatura) {
        if (criatura == null || !criaturas.contains(criatura)) {
            return null;
        }
        int posicion = criaturas.indexOf(criatura);
        return criaturas.get(posicion);
    }

    /**
     * Metodo para agrega una nueva criatura a la lista y la guarda en el XML
     * @param criatura Criatura a agregar
     */
    public void addCriatura(Criatura criatura) {
        if (criatura == null || criaturas.contains(criatura)) {
            return;
        }
        criaturas.add(criatura);
        volcarCriaturaXml();
    }

    /**
     * Metodo para elimina una criatura de la lista y actualiza el XML
     * @param criatura Criatura a eliminar.
     */
    public void deleteCriatura(Criatura criatura) {
        if (criatura == null || !criaturas.contains(criatura)) {
            return;
        }
        criaturas.remove(criatura);
        volcarCriaturaXml();
    }

    /**
     * Metodo que actualiza una criatura existente en la lista y en el XML
     * @param criatura Criatura con los nuevos datos
     */
    public void updateCriatura(Criatura criatura) {
        if (criatura == null) {
            return;
        }
        int index = criaturas.indexOf(criatura);
        if (index >= 0) {
            criaturas.set(index, criatura);
            volcarCriaturaXml();
        }
    }
}