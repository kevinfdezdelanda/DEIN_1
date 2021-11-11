package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Persona;
import util.ConexionDB;

public class GestionPersonas {
	
	public GestionPersonas() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Persona> obtenerPersonas(){
		
		ArrayList<Persona> personas= new ArrayList<Persona>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM personas.Persona";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Persona p = new Persona();

				p.setApellidos(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setEdad(rs.getInt("edad"));
				
				personas.add(p);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return personas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return personas;
		}
		
	}
	
	public boolean nuevaPersona(Persona p) {
		try {
			String sql = "INSERT INTO `Persona` (`nombre`, `apellido`, `edad`) VALUES (?, ?, ?);";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());
			ps.setInt(3, p.getEdad());

			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean editarPersona(Persona p, Persona p2) {
		try {
			String sql = "UPDATE `Persona` SET `nombre` = ?, `apellido` = ?, `edad` = ? WHERE `nombre` = ? and `apellido` = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());
			ps.setInt(3, p.getEdad());
			
			ps.setString(4, p2.getNombre());
			ps.setString(5, p2.getApellidos());
			
			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean borrarPersona(Persona p) {
		try {
			String sql = "DELETE FROM `Persona` WHERE nombre = ? and apellido = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellidos());

			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
