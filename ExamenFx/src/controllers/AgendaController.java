package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.GestionPersonas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Persona;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionDB;

public class AgendaController implements Initializable {
	private ArrayList<Persona> personas;
	private static int posicion;

	@FXML
	private Label tituloPersona;
	@FXML
	private ListView<String> listEmails;
	private ObservableList<String> emails;

	@FXML
	private ListView<String> listTelefonos;
	private ObservableList<String> telefonos;

	@FXML
	private Button btnNuevoMail;
	@FXML
	private Button btnBorrarMail;
	@FXML
	private Button btnNuevoTel;
	@FXML
	private Button btnBorrarTel;
	@FXML
	private Label numPag;
	@FXML
	private Button btnAnterior;
	@FXML
	private Button btnSiguiente;

	// Event Listener on Button[#btnNuevoMail].onAction
	@FXML
	public void nuevoMail(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo Email");

		dialog.setHeaderText(null);
		dialog.setContentText("Nuevo email: ");
		Optional<String> dato = dialog.showAndWait();
		if (dato.isPresent()) {
			String mail = dato.get();
			
			Boolean correcto = true;
			
			GestionPersonas gp = new GestionPersonas();
			if (!mail.contains("@")){
				correcto = false;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Email no valido");
				alert.showAndWait();
			}
			
			if(gp.existeMail(mail)) {
				correcto = false;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("El email ya existe");
				alert.showAndWait();
			}
			
			if(correcto) {
				if(gp.nuevoMail(personas.get(posicion).getDni(), mail)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Email creado");
					alert.showAndWait();
					
					cargarEmails();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al crear el Email");
					alert.showAndWait();
				}
			}
		}
	}

	// Event Listener on Button[#btnBorrarMail].onAction
	@FXML
	public void borrarMail(ActionEvent event) {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setHeaderText(null);
		alert1.setTitle("Seguro?");
		alert1.setContentText("Estas seguro de borrar el email: " + listEmails.getSelectionModel().getSelectedItem() + " ?");
		Optional<ButtonType> result = alert1.showAndWait();

		if (result.get() == ButtonType.OK) {
			GestionPersonas gp = new GestionPersonas();
			if (gp.borrarMail(personas.get(posicion).getDni(), listEmails.getSelectionModel().getSelectedItem())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Exito");
				alert.setContentText("Email borrado");
				alert.showAndWait();
				cargarEmails();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error al borrar el email");
				alert.showAndWait();
			}
		}
	}

	// Event Listener on Button[#btnNuevoTel].onAction
	@FXML
	public void nuevoTel(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo Telefono");

		dialog.setHeaderText(null);
		dialog.setContentText("Nuevo Telefono: ");
		Optional<String> dato = dialog.showAndWait();
		if (dato.isPresent()) {
			String tel = dato.get();
			
			Boolean correcto = true;
			
			if(tel.length()!=9) {
				correcto = false;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Telefono no valido");
				alert.showAndWait();
				
			}else {
				try {
					Integer.parseInt(tel);
				}catch (NumberFormatException e) {
					correcto = false;
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Telefono no valido");
					alert.showAndWait();
				}
			}
			
			
			GestionPersonas gp = new GestionPersonas();
			if(gp.existeTel(tel)) {
				correcto = false;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("El telefono ya existe");
				alert.showAndWait();
			}
			
			if(correcto) {
				if(gp.nuevoTelefono(personas.get(posicion).getDni(), tel)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Telefono creado");
					alert.showAndWait();
					
					cargarTelefonos();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al crear el telefono");
					alert.showAndWait();
				}
			}
		}
		
		
	}

	// Event Listener on Button[#btnBorrarTel].onAction
	@FXML
	public void borrarTel(ActionEvent event) {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setHeaderText(null);
		alert1.setTitle("Seguro?");
		alert1.setContentText("Estas seguro de borrar el telefono: " + listTelefonos.getSelectionModel().getSelectedItem() + " ?");
		Optional<ButtonType> result = alert1.showAndWait();

		if (result.get() == ButtonType.OK) {
			GestionPersonas gp = new GestionPersonas();
			if (gp.borrarTelefono(personas.get(posicion).getDni(), listTelefonos.getSelectionModel().getSelectedItem())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Exito");
				alert.setContentText("Telefono borrado");
				alert.showAndWait();
				cargarTelefonos();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error al borrar el telefono");
				alert.showAndWait();
			}
		}
	}

	// Event Listener on Button[#btnAnterior].onAction
	@FXML
	public void anterior(ActionEvent event) {
		posicion--;
		cargarDatosPersona();
	}

	// Event Listener on Button[#btnSiguiente].onAction
	@FXML
	public void siguiente(ActionEvent event) {
		posicion++;
		cargarDatosPersona();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		posicion = 0;
		
		GestionPersonas gp = new GestionPersonas();
		personas = gp.getPersonas();
		
		if(personas.size()==0) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			
			Stage myStage = (Stage) btnAnterior.getScene().getWindow();
			myStage.close();
		}

		telefonos = FXCollections.observableArrayList();
		listTelefonos.setItems(telefonos);

		emails = FXCollections.observableArrayList();
		listEmails.setItems(emails);

		cargarDatosPersona();
		
		listEmails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        // Your action here
		        if(newValue!=null) {
		        	btnBorrarMail.setDisable(false);
		        }else {
		        	btnBorrarMail.setDisable(true);
		        }
		    }
		});
		
		listTelefonos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        // Your action here
		        if(newValue!=null) {
		        	btnBorrarTel.setDisable(false);
		        }else {
		        	btnBorrarTel.setDisable(true);
		        }
		    }
		});
	}

	public void cargarEmails() {
		ArrayList<String> emailsArray = new ArrayList<>();

		GestionPersonas gp = new GestionPersonas();
		emailsArray = gp.getEmails(personas.get(posicion).getDni());

		emails.clear();
		emails.addAll(emailsArray);
	}

	public void cargarTelefonos() {
		ArrayList<String> telefonosArray = new ArrayList<>();

		GestionPersonas gp = new GestionPersonas();
		telefonosArray = gp.getTelefonos(personas.get(posicion).getDni());

		telefonos.clear();
		telefonos.addAll(telefonosArray);
	}

	public void cargarDatosPersona() {
		tituloPersona.setText(personas.get(posicion).toString());
		numPag.setText((posicion + 1) + " / " + personas.size());

		System.out.println(posicion + " - " + personas.size());

		if (posicion == 0) {
			btnAnterior.setDisable(true);
		} else {
			btnAnterior.setDisable(false);
		}

		if (posicion == (personas.size() - 1)) {
			btnSiguiente.setDisable(true);
		} else {
			btnSiguiente.setDisable(false);
		}

		cargarEmails();
		cargarTelefonos();
	}
	
	@FXML
    void abrirInforme1(ActionEvent event) {
		try {
			ConexionDB con = new ConexionDB();
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/informe1.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setHeaderText(null);
			alert1.setTitle("Error");
			alert1.setContentText("Error al cargar el informe");
			alert1.showAndWait();
		} 
    }

    @FXML
    void abrirInforme2(ActionEvent event) {
    	try {
			ConexionDB con = new ConexionDB();
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/informe2.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setHeaderText(null);
			alert1.setTitle("Error");
			alert1.setContentText("Error al cargar el informe");
			alert1.showAndWait();
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
			Stage myStage = (Stage) this.btnAnterior.getScene().getWindow();
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

    @FXML
    void verAyudaOnline(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AyudaOnline.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ayuda Online");
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage = (Stage) this.btnAnterior.getScene().getWindow();
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
