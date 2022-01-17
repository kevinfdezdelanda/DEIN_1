module informes_ej1 {
	requires javafx.controls;
	requires jasperreports;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;

	exports application;
	
	opens application to javafx.graphics, javafx.fxml;
}
