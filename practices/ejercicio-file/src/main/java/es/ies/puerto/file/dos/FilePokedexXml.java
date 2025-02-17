package es.ies.puerto.file.dos;

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


public class FilePokedexXml {
    static List<Pokemon> pokedex;
    static File archivo = new File("src\\main\\resources\\dos.xml");
    static DocumentBuilder builder;
    static Document doc;

    /**
     * constructor vacio
     */
    public FilePokedexXml() throws Exception {
        pokedex = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            doc = builder.parse(archivo);
            prepararLista();
    }

    /**
     * metodo que devuelve todos los pokemon
     * @return List<Pokemon>
     */
    public List<Pokemon> obtenerPokemons() {
        return pokedex;
    }

    /**
     * metodo que devuelve un pokemon
     * @return List<Pokemon>
     */
    public Pokemon obtenerPokemon(Pokemon pokemon) {
        if (pokemon == null || !pokedex.contains(pokemon)) {
            return null;
        }
        int posicion = pokedex.indexOf(pokemon);
        return pokedex.get(posicion);
    }

    /**
     * Metodo que permite agregar pokemon
     * @param pokemon
     * @throws Exception
     */
    public void addPokemon(Pokemon pokemon) throws Exception {
        if (pokemon == null || pokedex.contains(pokemon)) {
            return;
        }
        pokedex.add(pokemon);
        volcarPokemon();
    }

    /**
     * Metodo que elimina un pokemon
     * @param pokemon
     * @throws Exception
     */
    public void deletePokemon(Pokemon pokemon) throws Exception {
        if (pokemon == null || pokedex.contains(pokemon)) {
            return;
        }
        pokedex.remove(pokemon);
        volcarPokemon();
    }

    /**
     * Metodo que actualiza la informacion de un pokemon
     * @param pokemon
     * @throws Exception
     */
    public void updatePokemon(Pokemon pokemon) throws Exception {
        if (pokemon == null || pokedex.contains(pokemon)) {
            return;
        }
        pokedex.remove(pokemon);
        pokedex.add(pokemon);
        volcarPokemon();
    }

    /**
     * Metodo para volcar todos los pokemon al fichero
     * @throws Exception
     */
    public void volcarPokemon() throws Exception{
        doc = builder.newDocument();

        Element root = doc.createElement("pokedex");
        doc.appendChild(root);

        for (Pokemon pokemon : pokedex) {

            Element pokemonXml = doc.createElement("pokemon");
            root.appendChild(pokemonXml);

            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(pokemon.getId()));
            pokemonXml.appendChild(id);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(pokemon.getNombre()));
            pokemonXml.appendChild(nombre);
            
            Element tipos = doc.createElement("tipos");
            pokemonXml.appendChild(tipos);
            
            for (int i = 0; i < pokemon.getTipos().size(); i++) {

                Element tipo = doc.createElement("tipos");
                tipo.appendChild(doc.createTextNode(pokemon.getTipos().get(i)));
                tipos.appendChild(tipo);
                
            }

            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode(pokemon.getDescripcion()));
            pokemonXml.appendChild(descripcion);
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
        NodeList lista = doc.getElementsByTagName("pokemon");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                NodeList tiposNodeList = elemento.getElementsByTagName("tipos").item(0).getChildNodes();
                List<String> tipos = new ArrayList<>();

                for (int j = 0; j < tiposNodeList.getLength(); j++) {
                    Node tipoNode = tiposNodeList.item(j);
                    if (tipoNode.getNodeType() == Node.ELEMENT_NODE) {
                        tipos.add(tipoNode.getTextContent());
                    }
                }
                
                Pokemon pokemon = new Pokemon(id, nombre, tipos, descripcion);
                pokedex.add(pokemon);
            }
        }
    }
}
