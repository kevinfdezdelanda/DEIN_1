package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.GestionUbicaciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;

import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Ubicacion;
import util.Messages;

public class UbicacionesController implements Initializable {
	@FXML
	private TableView<Ubicacion> tablaUbicaciones;
	@FXML
	private TableColumn<Ubicacion, String> colSeccion;
	@FXML
	private TableColumn<Ubicacion, String> colUbicacion;
	@FXML
	private ImageView imagen;

	private ObservableList<Ubicacion> personas;

	// Event Listener on TableView[#tablaUbicaciones].onMouseClicked
	@FXML
	public void cargarImg(MouseEvent event) {
		Ubicacion u = (Ubicacion) tablaUbicaciones.getSelectionModel().getSelectedItem();

		if (u != null) {
			File file = new File("src/imagenes/" + u.getImagen());
			if(file.exists()) {
				Image image = new Image(file.toURI().toString());
				imagen.setImage(image);
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText(Messages.getString("error1"));
				alert.showAndWait();
				imagen.setImage(null);
			}
			
		}
	}

	// Event Listener on ImageView[#imagen].onMouseClicked
	@FXML
	public void abrirImagen(MouseEvent event) {
		try {
			Ubicacion u = (Ubicacion) tablaUbicaciones.getSelectionModel().getSelectedItem();
			File file = new File("src/imagenes/" + u.getImagen());
			if (u != null && file.exists()) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Imagen.fxml"));
				Parent root = loader.load();
				ImagenController controlador = loader.getController();
				controlador.cargarImagen(u.getImagen());
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				Stage myStage = (Stage) this.imagen.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle(u.toString());
				stage.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(Messages.getString("error2"));
			alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		personas = FXCollections.observableArrayList();
		tablaUbicaciones.setItems(personas);
		colSeccion.setCellValueFactory(new PropertyValueFactory<Ubicacion, String>("seccion"));
		colUbicacion.setCellValueFactory(new PropertyValueFactory<Ubicacion, String>("ubicacion"));

		cargarUbicaciones();
	}

	public void cargarUbicaciones() {
		GestionUbicaciones gu = new GestionUbicaciones();

		ArrayList<Ubicacion> u = gu.obtenerUbicacions();

		personas.clear();
		personas.addAll(u);
	}
}
