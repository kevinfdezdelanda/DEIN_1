package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Help;

public class AyudaOnlineController implements Initializable{
	@FXML
	private WebView visor;
	private WebEngine webEngine;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Mostramos el contenido inicial en el visor de la derecha
		webEngine = visor.getEngine();
		webEngine.load("https://www.google.es/");
		
	}

	
}
