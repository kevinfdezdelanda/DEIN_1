package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alumno;
import model.Libro;
import model.Prestamo;
import util.ConexionDB;

public class GestionPrestamos {
	public GestionPrestamos() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Prestamo> getPrestamos(){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM libros.Prestamo p, libros.Alumno a, libros.Libro l where p.codigo_libro = l.codigo and a.dni = p.dni_alumno";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Prestamo p = new Prestamo();
				
				Alumno a = new Alumno();
				a.setApellido1(rs.getString("apellido1"));
				a.setApellido2(rs.getString("apellido2"));
				a.setNombre(rs.getString("nombre"));
				a.setDni(rs.getString("dni"));

				Libro l = new Libro();
				l.setCodigo(rs.getInt("codigo"));
				l.setTitulo(rs.getString("Titulo"));
				l.setAutor(rs.getString("Autor"));
				l.setEditorial(rs.getString("Editorial"));
				l.setEstado(rs.getString("Estado"));
				l.setBaja(rs.getInt("Baja"));
				
				p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				p.setId(rs.getInt("id_prestamo"));
				p.setAlumno(a);
				p.setLibro(l);
				
				prestamos.add(p);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return prestamos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prestamos;
		}
	}
	
	public boolean nuevoPrestamo(Prestamo p) {
		try {
			String sql = "INSERT INTO `libros`.`Prestamo` (`dni_alumno`, `codigo_libro`, `fecha_prestamo`) VALUES (?, ?, ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, p.getAlumno().getDni());
			ps.setInt(2, p.getLibro().getCodigo());
			ps.setDate(3, p.getFechaPrestamo());
			
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
	
	public boolean borrarPrestamo(Prestamo p) {
		try {
			String sql = "DELETE FROM `prestamo` WHERE `prestamo`.`id_prestamo` = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, p.getId());
			
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
