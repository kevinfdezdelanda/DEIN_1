package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class ConexionDB {
	private Connection conexion;

	public ConexionDB() throws SQLException {
		String host = Messages.getString("ConexionDB.0"); //$NON-NLS-1$
		String baseDatos = Messages.getString("ConexionDB.1"); //$NON-NLS-1$
		String usuario = Messages.getString("ConexionDB.2"); //$NON-NLS-1$
		String password = Messages.getString("ConexionDB.3"); //$NON-NLS-1$
		String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos + "?serverTimezone=" 
				+ TimeZone.getDefault().getID();
		conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
		conexion.setAutoCommit(true);
	}

	public ResultSet ejecutarConsulta(String SQL) throws SQLException {
		Statement statement = this.conexion.createStatement();
		return statement.executeQuery(SQL);
	}

	public void cerrarConexion() throws SQLException {
		this.conexion.close();
	}

	public Connection getConexion() {
		return conexion;
	}
}