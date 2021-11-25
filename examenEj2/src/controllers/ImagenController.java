package controllers;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenController {
	@FXML
	private ImageView imagen;

	public void cargarImagen(String strImagen) {
		File file = new File("src/imagenes/"+strImagen);
        Image image = new Image(file.toURI().toString());
		imagen.setImage(image);
	}
	
	
}
