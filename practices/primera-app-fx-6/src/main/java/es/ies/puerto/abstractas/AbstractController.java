package es.ies.puerto.abstractas;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AbstractController {

    static final String PATH_DB = "src/main/resources/usuarios.db";

    private UsuarioServiceModel usuarioServiceModel;

    public AbstractController() {
        try {
            usuarioServiceModel = new UsuarioServiceModel(PATH_DB);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    public Text textUsuario;

    @FXML
    public Text textContrasenia;

    public void cambiarIdioma() {
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
    }

    public UsuarioServiceModel getUsuarioServiceModel() {
        return usuarioServiceModel;
    }
}
