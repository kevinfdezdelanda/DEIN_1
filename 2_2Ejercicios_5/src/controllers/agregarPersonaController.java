package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Persona;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class agregarPersonaController{
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
	
	private Persona persona;

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
					if(persona == null) {
						personas.add(p);
					}else {
						personas.add(p);
						personas.remove(persona);
					}
					
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
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void cargarDatos() {
		if(persona!=null) {
			txtNombre.setText(persona.getNombre());
			txtApellidos.setText(persona.getApellidos());
			txtEdad.setText(persona.getEdad()+"");
		}
	}
	
	
}
