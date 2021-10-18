package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import modelo.Operaciones;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;

public class CalculadoraController implements Initializable{
	@FXML
	private TextField txtOperador1;
	@FXML
	private TextField txtOperador2;
	@FXML
	private TextField txtResultado;
	@FXML
	private RadioButton rbSumar;
	@FXML
	private ToggleGroup operaciones;
	@FXML
	private RadioButton rbRestar;
	@FXML
	private RadioButton rbMultiplicar;
	@FXML
	private RadioButton rbDividir;

	// Event Listener on Button.onAction
	@FXML
	public void operar(ActionEvent event) {
		try {
			double op1 = Double.parseDouble(this.txtOperador1.getText());
			double op2 = Double.parseDouble(this.txtOperador2.getText());
			
			Operaciones operaciones = new Operaciones(op1, op2);
			
			if(rbSumar.isSelected()) {
				txtResultado.setText(operaciones.sumar()+"");
			}else if(rbRestar.isSelected()) {
				txtResultado.setText(operaciones.restar()+"");
			}else if(rbMultiplicar.isSelected()) {
				txtResultado.setText(operaciones.multiplicar()+"");
			}else if(rbDividir.isSelected()) {
				if (op2==0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("A la hora de dividir el segundo operador no puede ser 0");
					alert.showAndWait();
				}else {
					txtResultado.setText(operaciones.dividir()+"");
				}
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Introduce valores validos");
			alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
