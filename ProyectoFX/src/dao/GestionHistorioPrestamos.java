package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alumno;
import model.HistorioPrestamos;
import model.Libro;
import util.ConexionDB;

public class GestionHistorioPrestamos {
	
	public GestionHistorioPrestamos() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<HistorioPrestamos> getHistorioPrestamos() {

		ArrayList<HistorioPrestamos> hprestamos = new ArrayList<HistorioPrestamos>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM libros.historico_prestamo hp, libros.alumno a, libros.Libro l WHERE a.dni = hp.dni_alumno and hp.codigo_libro = l.codigo";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				HistorioPrestamos hp = new HistorioPrestamos();
				
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
				
				hp.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				hp.setFechaDevolucion(rs.getDate("fecha_devolucion"));
				hp.setAlumno(a);
				hp.setLibro(l);
				
				hp.setIdPrestamo(rs.getInt("id_prestamo"));

				hprestamos.add(hp);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return hprestamos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return hprestamos;
		}

	}

	public boolean nuevoHistorioPrestamo(HistorioPrestamos hp) {		
		try {
			String sql = "INSERT INTO `historico_prestamo` (`id_prestamo`, `dni_alumno`, `codigo_libro`, `fecha_prestamo`, `fecha_devolucion`) VALUES (?, ?, ?, ?, ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, hp.getIdPrestamo());
			ps.setString(2, hp.getAlumno().getDni());
			ps.setInt(3, hp.getLibro().getCodigo());
			ps.setDate(4, hp.getFechaPrestamo());
			ps.setDate(5, hp.getFechaDevolucion());
			
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

	public boolean editarHistorioPrestamo(HistorioPrestamos hp) {
		try {
			String sql = "UPDATE `historico_prestamo` SET `dni_alumno` = ?, `codigo_libro` = ?, `fecha_prestamo` = ?, `fecha_devolucion` = ? WHERE `historico_prestamo`.`id_prestamo` = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, hp.getAlumno().getDni());
			ps.setInt(2, hp.getLibro().getCodigo());
			ps.setDate(3, hp.getFechaPrestamo());
			ps.setDate(4, hp.getFechaDevolucion());
			ps.setInt(5, hp.getIdPrestamo());
			
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

	public boolean borrarHistorioPrestamo(HistorioPrestamos hp) {
		try {
			String sql = "DELETE FROM `historico_prestamo` WHERE `historico_prestamo`.`id_prestamo` = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, hp.getIdPrestamo());
			
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
