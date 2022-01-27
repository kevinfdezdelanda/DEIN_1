package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import dao.GestionAlumnos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Alumno;

public class NuevoEditarAlumnoController implements Initializable {
	@FXML
	private TextField txtDniNum;
	@FXML
	private TextField txtDniLetra;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApe1;
	@FXML
	private TextField txtApe2;

	private Alumno alumno;
	
	// Event Listener on Button.onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Button b = (Button) event.getSource(); 
		Stage myStage = (Stage) b.getScene().getWindow();
		myStage.close();
	}

	// Event Listener on Button.onAction
	@FXML
	public void aceptar(ActionEvent event) {
		String dniNum = txtDniNum.getText();
		String dniLetra = txtDniLetra.getText();
		String nombre = txtNombre.getText();
		String ape1 = txtApe1.getText();
		String ape2 = txtApe2.getText();
		
		String error = "";
		if(dniLetra.equals("")) {
			error += "Introduce un dni valido\n";
		}
		
		if(nombre.equals("") || ape1.equals("") || ape2.equals("")) {
			error += "Debes rellenar todos los campos";
		}
		
		if(error.equals("")) {
			Alumno a = new Alumno();
			a.setDni(dniNum+dniLetra);
			a.setNombre(nombre);
			a.setApellido1(ape1);
			a.setApellido2(ape2);
			
			GestionAlumnos ga = new GestionAlumnos();
			
			if(alumno==null) {
				if(ga.nuevoAlumno(a)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Alumno creado");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al crear el alumno");
					alert.showAndWait();
				}
			}else {
				if(ga.editarAlumno(a)) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Exito");
					alert.setContentText("Alumno editado");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error al editar el alumno");
					alert.showAndWait();
				}
			}
			
			Button b = (Button) event.getSource(); 
			Stage myStage = (Stage) b.getScene().getWindow();
			myStage.close();
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText(error);
			alert.showAndWait();
		}
		
	}
	
	public void setAlumno(Alumno a) {
		alumno = a;
		
		txtDniNum.setText(a.getDni().substring(0, 8));
		txtDniLetra.setText(a.getDni().substring(8));
		txtNombre.setText(a.getNombre());
		txtApe1.setText(a.getApellido1());
		txtApe2.setText(a.getApellido2());
		
		txtDniNum.setEditable(false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comprobarDni();

	}

	public void comprobarDni() {
		txtDniNum.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					txtDniNum.setText(newValue.replaceAll("[^\\d]", ""));
				}

				if (txtDniNum.getText().length() > 8) {
					String s = txtDniNum.getText().substring(0, 8);
					txtDniNum.setText(s);
				}

				if (txtDniNum.getText().length() == 8) {
					char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
							'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

					String num = txtDniNum.getText();
					int ind = 0;

					ind = Integer.parseInt(num);

					ind %= 23;

					txtDniLetra.setText(letraDni[ind]+"");
				} else {
					txtDniLetra.setText("");
				}
			}
		});
	}
}
