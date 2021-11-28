package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Date;
import java.util.ResourceBundle;

import dao.GestionAlumnos;
import dao.GestionLibros;
import dao.GestionPrestamos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Alumno;
import model.Libro;
import model.Prestamo;

public class PrestarLibroController implements Initializable{
	@FXML
	private ComboBox<Libro> cbLibros;
	@FXML
	private ComboBox<Alumno> cbAlumnos;
	@FXML
	private DatePicker fecha;

	// Event Listener on Button.onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Button b = (Button) event.getSource(); 
		Stage myStage = (Stage) b.getScene().getWindow();
		myStage.close();
	}
	// Event Listener on Button.onAction
	@FXML
	public void guardar(ActionEvent event) {
		Libro l = cbLibros.getSelectionModel().getSelectedItem();
		Alumno a = cbAlumnos.getSelectionModel().getSelectedItem();
		LocalDate d = fecha.getValue();
		String error = "";
		
		if(d == null) {
			error += "Debes seleccionar una fecha \n";
		}
		
		if(a == null) {
			error += "Debes seleccionar un alumno (Si no existe crealo)";
		}
		
		if(error.equals("")) {
			Prestamo p = new Prestamo();
			p.setFechaPrestamo(Date.valueOf(d));
			p.setAlumno(a);
			p.setLibro(l);
			
			GestionPrestamos gp = new GestionPrestamos();
			if(gp.nuevoPrestamo(p)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Exito");
				alert.setContentText("Libro prestado");
				alert.showAndWait();
				
				Button b = (Button) event.getSource(); 
				Stage myStage = (Stage) b.getScene().getWindow();
				myStage.close();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error al prestar el libro");
				alert.showAndWait();
				
				Button b = (Button) event.getSource(); 
				Stage myStage = (Stage) b.getScene().getWindow();
				myStage.close();
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(error);
			alert.showAndWait();
		}
		
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void crearAlumno(ActionEvent event) {
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
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoEditarAlumno.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			NuevoEditarAlumnoController controlador = loader.getController();
			controlador.setAlumno(cbAlumnos.getValue());
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
	}
	// Event Listener on Button.onAction
	@FXML
	public void borrarAlumno(ActionEvent event) {
		GestionAlumnos ga = new GestionAlumnos();
		Alumno a = cbAlumnos.getValue();
		
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
		GestionLibros gl = new GestionLibros();
		ArrayList<Libro> libros = gl.getLibrosNoBajaNoPrestado();
		
		ObservableList<Libro>  olLibro = FXCollections.observableArrayList();
		olLibro.addAll(libros);
		cbLibros.setItems(olLibro);
		
		cbLibros.getSelectionModel().select(0);
		
		cargarAlumnos();
	}
	public void cargarAlumnos() {
		GestionAlumnos ga = new GestionAlumnos();
		ArrayList<Alumno> alumnos = ga.getAlumnos();
		
		ObservableList<Alumno>  olAlumno = FXCollections.observableArrayList();
		olAlumno.addAll(alumnos);
		cbAlumnos.setItems(olAlumno);
		
		cbAlumnos.getSelectionModel().select(0);
	}
	
	public void setLibro(Libro l) {
		cbLibros.getSelectionModel().select(l);
	}
}
