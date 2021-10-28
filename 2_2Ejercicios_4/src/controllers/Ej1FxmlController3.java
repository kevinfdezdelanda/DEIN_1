package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class Ej1FxmlController3 implements Initializable{
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtEdad;
	@FXML
	private Button btnAgregar;
	@FXML
	private TableView<Persona> tabla;
	@FXML
	private TableColumn<Persona, String> colNombre;
	@FXML
	private TableColumn<Persona, String> colApellidos;
	@FXML
	private TableColumn<Persona, Integer> colEdad;
	
	private ObservableList<Persona> personas;
	@FXML
	private Button modificar;
	@FXML
	private Button eliminar;
	
	private Persona personaEditandose = null;

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
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
					if(personaEditandose == null) {
						personas.add(p);
					}else {
						personas.add(p);
						personas.remove(personaEditandose);
					}
					txtNombre.setText("");
					txtApellidos.setText("");
					txtEdad.setText("");
				}
				
			}catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Introduce una edad valida");
				alert.showAndWait();
			}
		}
	}
	// Event Listener on Button[#modificar].onAction
	@FXML
	public void modificar(ActionEvent event) {
		try {
			Persona p = tabla.getSelectionModel().getSelectedItem();
			if(p==null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Selecciona una persona valida");
				alert.showAndWait();
			}else {
				txtNombre.setText(p.getNombre());
				txtApellidos.setText(p.getApellidos());
				txtEdad.setText(p.getEdad()+"");
				personaEditandose = p;
			}
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Selecciona una persona valida");
			alert.showAndWait();
		}
		
	}
	// Event Listener on Button[#eliminar].onAction
	@FXML
	public void eliminar(ActionEvent event) {
		try {
			Persona p = tabla.getSelectionModel().getSelectedItem();
			if(p==null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Selecciona una persona valida");
				alert.showAndWait();
			}else {
				personas.remove(p);
			}
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Selecciona una persona valida");
			alert.showAndWait();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		personas = FXCollections.observableArrayList();
		tabla.setItems(personas);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
	}
}
