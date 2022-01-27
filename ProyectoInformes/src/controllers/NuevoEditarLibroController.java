package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Libro;

import java.net.URL;
import java.util.ResourceBundle;

import dao.GestionLibros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class NuevoEditarLibroController implements Initializable{
	@FXML
	private Label lbTitulo;
	@FXML
	private TextField tfTitulo;
	@FXML
	private TextField tfAutor;
	@FXML
	private TextField tfEditorial;
	@FXML
	private ComboBox<String> cbEstado;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	
	private Libro libro;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String editorial = tfEditorial.getText();
		
		if(titulo.equals("") || autor.equals("") || editorial.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes rellenar todos los campos");
			alert.showAndWait();
		}else {
			GestionLibros gl = new GestionLibros();
			Libro l = new Libro();
			l.setAutor(autor);
			l.setEditorial(editorial);
			l.setTitulo(titulo);
			l.setEstado(cbEstado.getSelectionModel().getSelectedItem());
			
			if(libro==null) {
				if(gl.nuevoLibro(l)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Libro creado");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al crear el libro");
					alert.showAndWait();
				}
			}else {
				l.setCodigo(libro.getCodigo());
				if(gl.editarLibro(l)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Libro editado");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al editar el libro");
					alert.showAndWait();
				}
			}
			
			
			Stage myStage = (Stage) this.btnCancelar.getScene().getWindow();
			myStage.close();
		}
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage = (Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbEstado.setItems(FXCollections.observableArrayList(
				"Nuevo", 
				"Usado nuevo", 
				"Usado seminuevo",
				"Usado estropeado", 
				"Restaurado"));
		
		cbEstado.getSelectionModel().select(0);
		
		
	}
	
	public void setLibro(Libro l) {
		libro = l;
		
		tfTitulo.setText(libro.getTitulo());
		tfEditorial.setText(libro.getEditorial());
		tfAutor.setText(libro.getAutor());
		
		cbEstado.getSelectionModel().select(libro.getEstado());;
	}
}
