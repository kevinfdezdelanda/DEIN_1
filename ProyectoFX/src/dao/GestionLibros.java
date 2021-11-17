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
	
	public ArrayList<Libro> getLibrosNoBaja(){
		
		ArrayList<Libro> Libros = new ArrayList<Libro>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM libros.Libro where baja = 0";
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
		return true;
	}
	
	public boolean editarLibro(Libro l) {
		return true;
	}
	
	public boolean borrarLibro(Libro l) {
		return true;
	}
}
