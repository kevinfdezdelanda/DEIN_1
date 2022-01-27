package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionDB;
import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

public class Ej2Controller {
	@FXML
	private RadioButton informe1;
	@FXML
	private ToggleGroup radio;
	@FXML
	private RadioButton informe2;
	@FXML
	private RadioButton informe3;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		try {
			ConexionDB con = new ConexionDB(); 
			
			if(informe1.isSelected()) {
				JasperReport report = (JasperReport) JRLoader
						.loadObject(getClass().getResource("/informes/informePersonas.jasper"));
				JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
				JasperViewer viewer = new JasperViewer(jprint, false);
				viewer.setVisible(true);
			}
			
			if(informe2.isSelected()) {
				JasperReport report = (JasperReport) JRLoader
						.loadObject(getClass().getResource("/informes/calculosPersonas.jasper"));
				JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
				JasperViewer viewer = new JasperViewer(jprint, false);
				viewer.setVisible(true);		
			}
					
			if(informe3.isSelected()) {	
				JasperReport report = (JasperReport) JRLoader
						.loadObject(getClass().getResource("/informes/subInformesPersonas.jasper"));
				JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
				JasperViewer viewer = new JasperViewer(jprint, false);
				viewer.setVisible(true);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		
	}
}
