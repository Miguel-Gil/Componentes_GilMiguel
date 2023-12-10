package es.ieslosmontecillos.componentes_gilmiguel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CampoTextoNumerico extends TextField {

    //Constructor vacio
    public CampoTextoNumerico() {}

    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-z, A-Z]")) {
            super.replaceText(start, end, text);
        }
        super.setPromptText("Enter a numeric value");
    }

    @Override
    public void replaceSelection(String text) {
        if (!text.matches("[a-z, A-Z]")) {
            super.replaceSelection(text);
        }
    }

}