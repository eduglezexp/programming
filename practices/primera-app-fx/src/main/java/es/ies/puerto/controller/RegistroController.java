package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController {

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private Text textMensaje;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField repetirPasswordField;

    @FXML
    protected void onClickRegistrar() {
        if (passwordField == null || passwordField.getText().isEmpty() 
            || repetirPasswordField == null || repetirPasswordField.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }
        if (passwordField.getText().equals(repetirPasswordField.getText())) {
            textMensaje.setText("¡El password es correcto!");
            return;
        }
        textMensaje.setText("¡Valores no validos!");
    }
}