package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Libro;
import util.ConexionDB;

public class GestionLibros {
	public GestionLibros() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Libro> getLibrosNoBajaNoPrestado(){
		
		ArrayList<Libro> Libros = new ArrayList<Libro>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM libros.Libro where baja = 0 and codigo NOT IN (SELECT codigo_libro from libros.Prestamo) ";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Libro l = new Libro();
				
				l.setCodigo(rs.getInt("codigo"));
				l.setTitulo(rs.getString("Titulo"));
				l.setAutor(rs.getString("Autor"));
				l.setEditorial(rs.getString("Editorial"));
				l.setEstado(rs.getString("Estado"));
				l.setBaja(rs.getInt("Baja"));
				
				Libros.add(l);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return Libros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Libros;
		}
		
	}
	
	public boolean nuevoLibro(Libro l) {
		try {
			String sql = "INSERT INTO `libros`.`Libro` (`Titulo`, `Autor`, `Editorial`, `Estado`, `Baja`) VALUES (?, ?, ?, ?, ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getAutor());
			ps.setString(3, l.getEditorial());
			ps.setString(4, l.getEstado());
			ps.setInt(5, l.getBaja());
			
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
	
	public boolean editarLibro(Libro l) {
		try {
			String sql = "UPDATE `Libro` SET `Titulo` = ?, `Autor` = ?, `Editorial` = ?, `Estado` = ?, `Baja` = ? WHERE `Libro`.`codigo` = ?; ";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getAutor());
			ps.setString(3, l.getEditorial());
			ps.setString(4, l.getEstado());
			ps.setInt(5, l.getBaja());
			ps.setInt(6, l.getCodigo());
			
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
	
	public boolean borrarLibro(Libro l) {
		try {
			String sql = "UPDATE `Libro` SET `Baja` = 1 WHERE `Libro`.`codigo` = ?; ";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, l.getCodigo());
			
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
