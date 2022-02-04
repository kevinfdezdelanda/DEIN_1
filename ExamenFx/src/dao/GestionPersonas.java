package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Persona;
import util.ConexionDB;

public class GestionPersonas {

	public GestionPersonas() {
			// TODO Auto-generated constructor stub
		}

	public ArrayList<Persona> getPersonas() {

		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen2agenda.persona";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Persona p = new Persona();

				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setNombre(rs.getString("nombre"));
				p.setDni(rs.getString("dni"));
				p.setAnioNacimiento(rs.getInt("anio_nacimiento"));
				
				//p.setEmails(getEmails(p.getDni()));
				//p.setTelefonos(getTelefonos(p.getDni()));
				
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
	
	public ArrayList<String> getEmails(String dni){
		ArrayList<String> emails = new ArrayList<String>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen2agenda.email where dni = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				emails.add( rs.getString("email"));
				
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return emails;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return emails;
		}
	}
	
	public ArrayList<String> getTelefonos(String dni){
		ArrayList<String> telefonos = new ArrayList<String>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen2agenda.telefono where dni = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				telefonos.add( rs.getString("telefono"));
				//System.out.println("dao: "+rs.getString("telefono"));
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return telefonos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return telefonos;
		}
	}
	
	public boolean nuevoTelefono(String dni, String tel) {		
		try {
			String sql = "INSERT INTO `examen2agenda`.`telefono` (`dni`, `telefono`) VALUES (?, ?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, dni);
			ps.setString(2, tel);
			
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
	
	public boolean nuevoMail(String dni, String mail) {		
		try {
			String sql = "INSERT INTO `examen2agenda`.`email` (`dni`, `email`) VALUES (?, ?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, dni);
			ps.setString(2, mail);
			
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

	public boolean borrarTelefono(String dni, String tel) {
		try {
			String sql = "DELETE FROM `examen2agenda`.`telefono` WHERE (dni = ? and telefono = ?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, dni);
			ps.setString(2, tel);
			
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
	
	public boolean borrarMail(String dni, String mail) {
		try {
			String sql = "DELETE FROM `examen2agenda`.`email` WHERE (dni = ? and email = ?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, dni);
			ps.setString(2, mail);
			
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
	
	public Boolean existeTel(String tel){
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen2agenda.telefono where telefono = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, tel);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			if (rs.next()) {
				return true;
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean existeMail(String mail){
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen2agenda.email where email = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			if (rs.next()) {
				return true;
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
