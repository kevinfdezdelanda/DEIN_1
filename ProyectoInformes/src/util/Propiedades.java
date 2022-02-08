package util;

import java.io.FileInputStream;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Propiedades {
	private static Properties props = new Properties();
	static {
		try (FileInputStream input = new FileInputStream("configure.properties")) {
			props.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValor(String clave) {
		String valor = props.getProperty(clave);
		if (valor != null) {
			return valor;
		}
		throw new RuntimeException("La clave solicitada en configuration.properties no está disponible");
	}
}
