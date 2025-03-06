package es.ies.puerto.file.dos;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */
public class FilePokedexXml {
    private static final String PATH = "src/main/resources/dos.xml";
    private List<Pokemon> pokemons;

    /**
     * Constructor por defecto
     */
    public FilePokedexXml() {
        pokemons = new ArrayList<>();
        File archivo = new File(PATH);
        if (!archivo.exists()) {
            System.err.println("Archivo XML no encontrado: " + PATH);
            return;
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
     * Metodo para llenar la lista de Pokemon con la información del archivo XML
     * @param doc Documento XML a procesar
     */
    private void prepararLista(Document doc) {
        NodeList lista = doc.getElementsByTagName("pokemon");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                List<String> tipos = new ArrayList<>();
                NodeList listaTipos = elemento.getElementsByTagName("tipo");
                for (int j = 0; j < listaTipos.getLength(); j++) {
                    tipos.add(listaTipos.item(j).getTextContent());
                }
                pokemons.add(new Pokemon(id, nombre, tipos, descripcion));
            }
        }
    }

    /**
     * Metodo para escribir la lista de Pokémon en el archivo XML
     */
    public void volcarPokedexXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("pokedex");
            doc.appendChild(root);

            for (Pokemon pokemon : pokemons) {
                Element pokemonXml = doc.createElement("pokemon");
                root.appendChild(pokemonXml);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(pokemon.getId()));
                pokemonXml.appendChild(id);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(pokemon.getNombre()));
                pokemonXml.appendChild(nombre);

                Element tiposXml = doc.createElement("tipos");
                for (String tipo : pokemon.getTipos()) {
                    Element tipoXml = doc.createElement("tipo");
                    tipoXml.appendChild(doc.createTextNode(tipo));
                    tiposXml.appendChild(tipoXml);
                }
                pokemonXml.appendChild(tiposXml);

                Element descripcion = doc.createElement("descripcion");
                descripcion.appendChild(doc.createTextNode(pokemon.getDescripcion()));
                pokemonXml.appendChild(descripcion);
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
     * Metodo que obtiene la lista de todas los pokemons
     * @return Lista de pokemons almacenados
     */
    public List<Pokemon> obtenerPokemons() {
        return new ArrayList<>(pokemons);
    }

    /**
     * Metodo que obtiene a un pokemon en especifico por su ID
     * @param pokemon a buscar
     * @return pokemon si se encuentra
     */
    public Pokemon obtenerPokemon(Pokemon pokemon) {
        if (pokemon == null || !pokemons.contains(pokemon)) {
            return null;
        }
        int posicion = pokemons.indexOf(pokemon);
        return pokemons.get(posicion);
    }

    /**
     * Metodo para agrega una nuevo pokemon a la lista y la guarda en el XML
     * @param pokemon a agregar
     */
    public void addPokemon(Pokemon pokemon) {
        if (pokemon == null || pokemons.contains(pokemon)) {
            return;
        }
        pokemons.add(pokemon);
        volcarPokedexXml();
    }

    /**
     * Metodo para elimina a un pokemon de la lista y actualiza el XML
     * @param pokemon a eliminar
     */
    public void deletePokemon(Pokemon pokemon) {
        if (pokemon == null || !pokemons.contains(pokemon)) {
            return;
        }
        pokemons.remove(pokemon);
        volcarPokedexXml();
    }

    /**
     * Metodo que actualiza a un pokemon existente en la lista y en el XML
     * @param pokemon con los nuevos datos
     */
    public void updatePokemon(Pokemon pokemon) {
        if (pokemon == null) {
            return;
        }
        int index = pokemons.indexOf(pokemon);
        if (index >= 0) {
            pokemons.set(index, pokemon);
            volcarPokedexXml();
        }
    }
}