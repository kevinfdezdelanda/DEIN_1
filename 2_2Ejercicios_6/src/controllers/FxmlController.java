package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FxmlController implements Initializable{
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
	private TextField filtrado;
	@FXML
	private Button importar;
	@FXML
	private Button exportar;

	// Event Listener on Button[#importar].onAction
	@FXML
	public void importar(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File f = fileChooser.showOpenDialog(null);
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
		    String line = br.readLine();

		    while (line != null) {
		        String[] partes = line.split(";");
		        Persona p = new Persona(partes[0], partes[1], Integer.parseInt(partes[2]));
		        personas.add(p);
		        line = br.readLine();
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Event Listener on Button[#exportar].onAction
	@FXML
	public void exportar(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("personas.txt");
		dialog.setTitle("Archivo a exportar");
		dialog.setHeaderText(null);
		dialog.setContentText("Introduce el nombre del archivo a exportar:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    String nombre = result.get();
		    try {
		        FileWriter myWriter = new FileWriter(nombre);
		        String texto = "";
		        for (int i = 0; i < personas.size(); i++) {
					texto += personas.get(i).getNombre()+";"+personas.get(i).getApellidos()+";"+personas.get(i).getEdad()+"\n";
				}
		        myWriter.write(texto);
		        myWriter.close();
		       
		        Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Archivo creado");
		        alert.setHeaderText(null);
		        alert.setContentText("Exito arhivo creado");

		        alert.showAndWait();
		      } catch (IOException e) {
		        e.printStackTrace();
		        Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Error");
		        alert.setHeaderText(null);
		        alert.setContentText("Ha ocurrido un error al crear el archivo");

		        alert.showAndWait();
		      }
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
			
			FilteredList<Persona> filteredData = new FilteredList<>(personas, p -> true);
			
			filtrado.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(person -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					// Compare first name and last name of every person with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
					
					if (person.getNombre().toLowerCase().contains(lowerCaseFilter)) {
						return true; // Filter matches first name.
					}
					return false; // Does not match.
				});
			});
			
			// 3. Wrap the FilteredList in a SortedList. 
			SortedList<Persona> sortedData = new SortedList<>(filteredData);
			
			// 4. Bind the SortedList comparator to the TableView comparator.
			sortedData.comparatorProperty().bind(tabla.comparatorProperty());
			
			// 5. Add sorted (and filtered) data to the table.
			tabla.setItems(sortedData);
			
		}
		
}
