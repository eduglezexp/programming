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

public class FileXmlCriatura {
    public static List<Criatura> criaturas;
    static File archivo = new File("src/main/resources/uno.xml");
    static DocumentBuilder builder;
    static Document doc;

    /**
     * Constructor vacio
     * @throws Exception
     */
    public FileXmlCriatura() throws Exception{
        criaturas = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.parse(archivo);
        prepararLista();
    }

    /**
     * metodo que devuelve todas las criaturas
     * @return List<Criatura>
     */
    public List<Criatura> obtenerCriaturas() {
        return criaturas;
    }

    /**
     * metodo que busca una criatra
     * @param criatura
     * @return Criatura
     */
    public Criatura obtener(Criatura criatura) {
        if (criatura == null || !criaturas.contains(criatura)) {
            return null;
        }
        int posicion = criaturas.indexOf(criatura);
        return criaturas.get(posicion);
    }

    /**
     * Metodo que permite agregar criaturas
     * @param criatura
     * @throws Exception
     */
    public void addCriatura(Criatura criatura) throws Exception{
        if (criatura == null || criaturas.contains(criatura)) {
            return;
        }
        criaturas.add(criatura);
        volcarCriatura();
    }

    /**
     * Metodo que elimina una criatura
     * @param criatura
     * @throws Exception
     */
    public void deleteCriatura(Criatura criatura) throws Exception {
        if (criatura == null || !criaturas.contains(criatura)) {
            return;
        }
        criaturas.remove(criatura);
        volcarCriatura();
    }

    /**
     * Metodo que actualiza la informacion de una criatura
     * @param criatura
     * @throws Exception
     */
    public void updateCriatura(Criatura criatura) throws Exception {
        if (criatura == null || !criaturas.contains(criatura)) {
            return;
        }
        criaturas.remove(criatura);
        criaturas.add(criatura);
        volcarCriatura();
    }

    /**
     * Metodo para volcar todas las criaturas al fichero
     * @throws Exception
     */
    private void volcarCriatura() throws Exception{
        doc = builder.newDocument();

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
        StreamResult result = new StreamResult(archivo);
        transformer.transform(source, result);
        doc = builder.parse(archivo);
    }

    /**
     * metodo para hacer que la lista statica tenga toda la informacion del fichero
     * @throws Exception
     */
    private void prepararLista(){
        NodeList lista = doc.getElementsByTagName("criatura");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String ID = elemento.getElementsByTagName("id").item(0).getTextContent();
                String Nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                Criatura criatura = new Criatura(ID, Nombre, descripcion, categoria);
                criaturas.add(criatura);
            }
        }
    }
}
