package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Alumno;
import model.Libro;
import model.Prestamo;

import java.awt.Menu;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.GestionLibros;
import dao.GestionPrestamos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class PrestamosController implements Initializable {
	@FXML
	private TableView<Prestamo> tablaPrestamos;
	@FXML
	private TableColumn<Prestamo, Alumno> colAlumno;
	@FXML
	private TableColumn<Prestamo, Libro> colLibro;
	@FXML
	private TableColumn<Prestamo, Date> colFecha;

	private ObservableList<Prestamo> prestamos;

	@FXML
	private Button btnInformes;
	@FXML
	private Button btnHistorial;
	@FXML
	private Button btnDevolver;
	@FXML
	private TableView<Libro> tablaLibros;
	@FXML
	private TableColumn<Libro, String> colTitulo;
	@FXML
	private TableColumn<Libro, String> colAutor;
	@FXML
	private TableColumn<Libro, String> colEditorial;
	@FXML
	private TableColumn<Libro, String> colEstado;

	private ObservableList<Libro> libros;

	@FXML
	private Button btnPrestar;
	@FXML
	private Button btnNuevoLibro;
	@FXML
	private Button btnEditarLibro;
	@FXML
	private Button btnBorrarLibro;
	@FXML
	private TextField buscarLibro;

	@FXML
	void verInformes(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Informes.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Informes");
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	// Event Listener on Button[#btnHistorial].onAction
	@FXML
	public void verHistorial(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HistorioPrestamos.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Historial prestamos");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	// Event Listener on Button[#btnDevolver].onAction
	@FXML
	public void devolverLibro(ActionEvent event) {
		Prestamo prestamo = tablaPrestamos.getSelectionModel().getSelectedItem();
		if (prestamo == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar un prestamo para poder devolverlo");
			alert.showAndWait();
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DevolverLibro.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				DevolverLibroController controlador = loader.getController();
				controlador.setPrestamo(prestamo);
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle("Devolver libro");
				stage.showAndWait();
				cargarLibros();
				cargarPrestamos();
			} catch (IOException e) {
				e.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Ha ocurrido un error");
				alert.showAndWait();
			}
		}
	}

	// Event Listener on Button[#btnPrestar].onAction
	@FXML
	public void prestarLibro(ActionEvent event) {
		Libro libro = tablaLibros.getSelectionModel().getSelectedItem();
		if (libro == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar un libro para poder prestarlo");
			alert.showAndWait();
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PrestarLibro.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				PrestarLibroController controlador = loader.getController();
				controlador.setLibro(libro);
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle("Prestar libro");
				stage.showAndWait();
				cargarLibros();
				cargarPrestamos();
			} catch (IOException e) {
				e.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Ha ocurrido un error");
				alert.showAndWait();
			}
		}
	}

	// Event Listener on Button[#btnNueboLibro].onAction
	@FXML
	public void nuevoLibro(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoEditarLibro.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Nuevo libro");
			stage.showAndWait();
			cargarLibros();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	// Event Listener on Button[#btnEditarLibro].onAction
	@FXML
	public void editarLibro(ActionEvent event) {
		Libro libro = tablaLibros.getSelectionModel().getSelectedItem();
		if (libro == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar un libro para poder editarlo");
			alert.showAndWait();
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoEditarLibro.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				NuevoEditarLibroController controlador = loader.getController();
				controlador.setLibro(libro);
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
				stage.initOwner(myStage);
				stage.setScene(scene);
				stage.setTitle("Editar libro");
				stage.showAndWait();
				cargarLibros();
			} catch (IOException e) {
				e.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
	}

	// Event Listener on Button[#btnBorrarLibro].onAction
	@FXML
	public void borrarLibro(ActionEvent event) {
		GestionLibros gl = new GestionLibros();
		Libro libro = tablaLibros.getSelectionModel().getSelectedItem();
		if (libro == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar un libro para poder borrarlo");
			alert.showAndWait();
		} else {
			Alert alert1 = new Alert(AlertType.CONFIRMATION);
			alert1.setHeaderText(null);
			alert1.setTitle("Seguro?");
			alert1.setContentText("Estas seguro de borrar el libro: " + libro + " ?");
			Optional<ButtonType> result = alert1.showAndWait();

			if (result.get() == ButtonType.OK) {

				if (gl.borrarLibro(libro)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Libro borrado");
					alert.showAndWait();
					cargarLibros();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al borrar el libro");
					alert.showAndWait();
				}
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		libros = FXCollections.observableArrayList();
		tablaLibros.setItems(libros);
		colTitulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
		colAutor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
		colEditorial.setCellValueFactory(new PropertyValueFactory<Libro, String>("editorial"));
		colEstado.setCellValueFactory(new PropertyValueFactory<Libro, String>("estado"));

		FilteredList<Libro> filteredData = new FilteredList<>(libros, p -> true);

		buscarLibro.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(libro -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (libro.getTitulo().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Libro> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tablaLibros.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		tablaLibros.setItems(sortedData);

		cargarLibros();

		prestamos = FXCollections.observableArrayList();
		tablaPrestamos.setItems(prestamos);
		colAlumno.setCellValueFactory(new PropertyValueFactory<Prestamo, Alumno>("alumno"));
		colLibro.setCellValueFactory(new PropertyValueFactory<Prestamo, Libro>("libro"));
		colFecha.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fechaPrestamo"));

		cargarPrestamos();
	}

	public void cargarLibros() {
		GestionLibros gl = new GestionLibros();

		ArrayList<Libro> p = gl.getLibrosNoBajaNoPrestado();

		libros.clear();
		libros.addAll(p);
	}

	public void cargarPrestamos() {
		GestionPrestamos gp = new GestionPrestamos();

		ArrayList<Prestamo> p = gp.getPrestamos();

		prestamos.clear();
		prestamos.addAll(p);
	}

	// Event Listener on MenuItem.onAction
	@FXML
	public void verAlumnos(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Alumnos.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Alumnos");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void verAyuda(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ayuda.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ayuda");
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnNuevoLibro.getScene().getWindow();
			stage.initOwner(myStage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
}
