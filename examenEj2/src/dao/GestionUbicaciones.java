package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Ubicacion;
import util.ConexionDB;

public class GestionUbicaciones {
	
	public GestionUbicaciones() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Ubicacion> obtenerUbicacions(){
		
		ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen1.ubicacion;";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Ubicacion u = new Ubicacion();

				u.setIdUbic(rs.getInt("id_ubic"));
				u.setSeccion(rs.getString("seccion"));
				u.setUbicacion(rs.getString("ubicacion"));
				u.setImagen(rs.getString("imagen"));
				
				ubicaciones.add(u);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return ubicaciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ubicaciones;
		}
		
	}
	
}
