package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PasswordController extends ControllerAbstract{

    @FXML 
    private TextField textFieldEmail;

    @FXML 
    private Button buttonAceptar;

    @FXML 
    private Text textMensaje;

    @FXML
    protected void onPasswordButtonClick() {
        mostrarPantalla(buttonAceptar, "login.fxml", "Pantalla Principal");
    }
}