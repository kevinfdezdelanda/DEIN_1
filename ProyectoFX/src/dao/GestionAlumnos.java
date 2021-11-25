package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alumno;
import util.ConexionDB;

public class GestionAlumnos {
	public GestionAlumnos() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Alumno> getAlumnos() {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM libros.Alumno";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Alumno a = new Alumno();

				a.setApellido1(rs.getString("apellido1"));
				a.setApellido2(rs.getString("apellido2"));
				a.setNombre(rs.getString("nombre"));
				a.setDni(rs.getString("dni"));

				alumnos.add(a);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return alumnos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return alumnos;
		}

	}

	public boolean nuevoAlumno(Alumno a) {		
		try {
			String sql = "INSERT INTO `libros`.`Alumno` (`dni`, `nombre`, `apellido1`, `apellido2`) VALUES (?, ?, ?, ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, a.getDni());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellido1());
			ps.setString(4, a.getApellido2());
			
			if(ps.executeUpdate()==0) {
				c.cerrarConexion();
				ps.close();	
				return false;
			}else {
				c.cerrarConexion();
				ps.close();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean editarAlumno(Alumno a) {
		try {
			String sql = "UPDATE `libros`.`Alumno` SET `dni` = ?, `nombre` = ?, `apellido1` = ?, `apellido2` = ? WHERE (`dni` = ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, a.getDni());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellido1());
			ps.setString(4, a.getApellido2());
			ps.setString(5, a.getDni());
			
			if(ps.executeUpdate()==0) {
				c.cerrarConexion();
				ps.close();	
				return false;
			}else {
				c.cerrarConexion();
				ps.close();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean borrarAlumno(Alumno a) {
		try {
			String sql = "DELETE FROM `libros`.`Alumno` WHERE (`dni` = ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, a.getDni());
			
			if(ps.executeUpdate()==0) {
				c.cerrarConexion();
				ps.close();	
				return false;
			}else {
				c.cerrarConexion();
				ps.close();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
