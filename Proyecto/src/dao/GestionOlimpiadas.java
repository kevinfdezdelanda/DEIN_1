package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Olimpiada;
import util.ConexionDB;

public class GestionOlimpiadas {
	public GestionOlimpiadas() {
		
	}
	
	public ArrayList<Olimpiada> getOlimpiadas(){
		ArrayList<Olimpiada> olimpiadas = new ArrayList<Olimpiada>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Olimpiada";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Olimpiada o = new Olimpiada();
				o.setId(rs.getInt("id_olimpiada"));
				o.setNombre(rs.getString("nombre"));
				o.setCiudad(rs.getString("ciudad"));
				o.setAnio(rs.getInt("anio"));
				o.setTemporada(rs.getString("temporada"));
				olimpiadas.add(o);
			}
			return olimpiadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return olimpiadas;
		}
		
	}
	
	public boolean nuevaOlimpiada(Olimpiada o) {
		try {
			String sql = "insert into olimpiadas.Olimpiada (nombre,anio,temporada,ciudad) values (?,?,?,?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, o.getNombre());
			ps.setInt(2, o.getAnio());
			ps.setString(3, o.getTemporada());
			ps.setString(4, o.getCiudad());
			
			if(ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean editarOlimpiada(Olimpiada o) {
		try {
			String sql = "update olimpiadas.Olimpiada set anio = ?, nombre = ?, temporada = ?, ciudad = ? where id_olimpiada = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, o.getAnio());
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getTemporada());
			ps.setString(4, o.getCiudad());
			ps.setInt(5, o.getId());
			
			if(ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean borrarOlimpiada(Olimpiada o) {
		try {
			String sql = "DELETE FROM olimpiadas.Olimpiada WHERE id_olimpiada = ?;";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setInt(1, o.getId());
			
			if(ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
