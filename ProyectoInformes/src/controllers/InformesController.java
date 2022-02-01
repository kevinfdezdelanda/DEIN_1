package controllers;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionDB;

public class InformesController {

    @FXML
    private Button btnInforme1;

    @FXML
    private Button btnInforme2;

    @FXML
    private Button btnInforme3;

    @FXML
    void verInforme1(ActionEvent event) {
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
    void verInforme2(ActionEvent event) {
    	try {
			ConexionDB con = new ConexionDB();
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/informe3.jasper"));
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
    void verInforme3(ActionEvent event) {
    	try {
			ConexionDB con = new ConexionDB();
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/informes/informe4.jasper"));
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

}
