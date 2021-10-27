package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Locale locale = new Locale("en", "GB");
			ResourceBundle bundle = ResourceBundle.getBundle("/util/messages", locale);
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("/fxml/Ej1Fxml.fxml"), bundle);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/icono.png")));
			primaryStage.setTitle("Personas");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
