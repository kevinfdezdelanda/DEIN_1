package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.GestionAlumnos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Alumno;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;

public class AlumnosController implements Initializable {
	@FXML
	private TableView<Alumno> tableAlumnos;
	@FXML
	private TableColumn<Alumno, String> colDni;
	@FXML
	private TableColumn<Alumno, String> colNombre;
	@FXML
	private TableColumn<Alumno, String> colApe1;
	@FXML
	private TableColumn<Alumno, String> colApe2;
	
	private ObservableList<Alumno> alumnos;

	// Event Listener on Button.onAction
	@FXML
	public void nuevoAlumno(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoEditarAlumno.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			Button b = (Button) event.getSource(); 
			Stage myStage = (Stage) b.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Nuevo Alumno");
			stage.showAndWait();
			cargarAlumnos();
		} catch (IOException e) {
			e.printStackTrace(); 
			Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText(null);
			 alert.setTitle("Error");
			 alert.setContentText(e.getMessage());
			 alert.showAndWait();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void editarAlumno(ActionEvent event) {
		Alumno a = tableAlumnos.getSelectionModel().getSelectedItem();
		if(a!=null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoEditarAlumno.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				NuevoEditarAlumnoController controlador = loader.getController();
				controlador.setAlumno(a);
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				Button b = (Button) event.getSource(); 
				Stage myStage = (Stage) b.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle("Editar Alumno");
				stage.showAndWait();
				cargarAlumnos();
			} catch (IOException e) {
				e.printStackTrace(); 
				Alert alert = new Alert(Alert.AlertType.ERROR);
				 alert.setHeaderText(null);
				 alert.setTitle("Error");
				 alert.setContentText(e.getMessage());
				 alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar un alumno para poder editarlo");
			alert.showAndWait();
		}
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void borrarAlumno(ActionEvent event) {
		GestionAlumnos ga = new GestionAlumnos();
		Alumno a = tableAlumnos.getSelectionModel().getSelectedItem();
		
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setHeaderText(null);
		alert1.setTitle("Seguro?");
		alert1.setContentText("Estas seguro de borrar el alumno: "+a+" ?");
		Optional<ButtonType> result = alert1.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			
			if(ga.borrarAlumno(a)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Exito");
				alert.setContentText("Alumno borrado");
				alert.showAndWait();
				cargarAlumnos();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error al borrar el alumnoo");
				alert.showAndWait();
			}
		} 
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		alumnos = FXCollections.observableArrayList();
		tableAlumnos.setItems(alumnos);
		colDni.setCellValueFactory(new PropertyValueFactory<Alumno, String>("dni"));
		colNombre.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
		colApe1.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellido1"));
		colApe2.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellido2"));
		
		cargarAlumnos();
	}
	
	public void cargarAlumnos() {
		GestionAlumnos ga = new GestionAlumnos();
		
		ArrayList<Alumno> a = ga.getAlumnos();
		
		alumnos.clear();
		alumnos.addAll(a);
	}
}
