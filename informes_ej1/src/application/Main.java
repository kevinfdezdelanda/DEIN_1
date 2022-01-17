package application;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionDB;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ConexionDB con = new ConexionDB(); 

			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
