package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class agregarPersonaController {
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtEdad;
	@FXML
	private Button guardar;
	@FXML
	private Button cancelar;
	
	private ObservableList<Persona> personas;

	// Event Listener on Button[#guardar].onAction
	@FXML
	public void guardar(ActionEvent event) {
		
		String nombre = txtNombre.getText();
		String apellido = txtApellidos.getText();
		String strEdad = txtEdad.getText();
		
		if(nombre.equals("")||apellido.equals("")||strEdad.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes rellenar todos los campos");
			alert.showAndWait();
		}else {
			try {
				int edad = Integer.parseInt(strEdad);
				
				Persona p = new Persona(nombre, apellido, edad);
				
				if(personas.contains(p)) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Esa persona ya existe");
					alert.showAndWait();
				}else {
					personas.add(p);
				}
				Stage myStage = (Stage) this.cancelar.getScene().getWindow();
				myStage.close();
				
			}catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Introduce una edad valida");
				alert.showAndWait();
			}
		}
	}
	// Event Listener on Button[#cancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage = (Stage) this.cancelar.getScene().getWindow();
		myStage.close();
	}
	public ObservableList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(ObservableList<Persona> personas) {
		this.personas = personas;
	}
	
	
}
