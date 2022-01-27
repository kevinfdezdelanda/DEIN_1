package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.GestionHistorioPrestamos;
import dao.GestionLibros;
import dao.GestionPrestamos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.HistorioPrestamos;
import model.Prestamo;

public class DevolverLibroController implements Initializable{
	@FXML
	private DatePicker fecha;
	@FXML
	private ComboBox<String> estado;
	
	private Prestamo prestamo;

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
		LocalDate d = fecha.getValue();
		if(d==null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes introducir la fecha de devolucion");
			alert.showAndWait();
		}else {
			HistorioPrestamos hp = new HistorioPrestamos();
			hp.setFechaDevolucion(Date.valueOf(d));
			prestamo.getLibro().setEstado(estado.getValue());
			hp.setFechaPrestamo(prestamo.getFechaPrestamo());
			hp.setAlumno(prestamo.getAlumno());
			hp.setLibro(prestamo.getLibro());
			hp.setIdPrestamo(prestamo.getId());
			
			GestionPrestamos gp = new GestionPrestamos();
			GestionLibros gl = new GestionLibros();
			GestionHistorioPrestamos gh = new GestionHistorioPrestamos();
			if(gl.editarLibro(prestamo.getLibro()) && gp.borrarPrestamo(prestamo) && gh.nuevoHistorioPrestamo(hp)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Exito");
				alert.setContentText("Libro devuelto");
				alert.showAndWait();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error al devolver el libro");
				alert.showAndWait();
			}
			
			Button b = (Button) event.getSource(); 
			Stage myStage = (Stage) b.getScene().getWindow();
			myStage.close();
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estado.setItems(FXCollections.observableArrayList(
				"Nuevo", 
				"Usado nuevo", 
				"Usado seminuevo",
				"Usado estropeado", 
				"Restaurado"));
		
		estado.getSelectionModel().select(0);
		
		fecha.setValue(LocalDate.now());
	}
	
	public void setPrestamo(Prestamo p) {
		prestamo = p;
		
		estado.setValue(p.getLibro().getEstado());
	}
}
