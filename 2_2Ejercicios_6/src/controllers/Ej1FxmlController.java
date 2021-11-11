package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.scene.control.TableColumn;

public class Ej1FxmlController implements Initializable{
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
	private Button eliminar;
	@FXML
	private Button modificar;
	@FXML
	private Button agregar;
	@FXML
	private Button importar;
	@FXML
	private Button exportar;
	

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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/agregarPersona.fxml"));
				Parent root = loader.load();
				agregarPersonaController controlador = loader.getController();
				controlador.setPersonas(personas);
				controlador.setPersona(p);
				controlador.cargarDatos();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				Stage myStage = (Stage) this.agregar.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle("Modificar Persona");
				stage.showAndWait();
				personas = controlador.getPersonas();
			}
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Selecciona una persona valida");
			alert.showAndWait();
		}
	}
	// Event Listener on Button[#agregar].onAction
	@FXML
	public void agregrar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/agregarPersona.fxml"));
			Parent root = loader.load();
			agregarPersonaController controlador = loader.getController();
			controlador.setPersonas(personas);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.agregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar Persona");
			stage.showAndWait();
			personas = controlador.getPersonas();
		} catch (IOException e) {
			e.printStackTrace(); 
			Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText(null);
			 alert.setTitle("Error");
			 alert.setContentText(e.getMessage());
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
