package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Evento;
import model.Olimpiada;
import util.ConexionDB;

public class GestionEventos {
	public GestionEventos() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Evento> getEventos(Olimpiada o){
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Evento e, olimpiadas.Deporte d, olimpiadas.Olimpiada o where e.id_deporte = d.id_deporte and ? = e.id_olimpiada and e.id_olimpiada = o.id_olimpiada";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setInt(1, o.getId());
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Evento e = new Evento();
				Deporte d = new Deporte();
				
				e.setId(rs.getInt("id_evento"));
				e.setNombre(rs.getString("e.nombre"));
				d.setId(rs.getInt("e.id_deporte"));
				d.setNombre(rs.getString("d.nombre"));
				
				e.setOlimpiada(o);
				e.setDeporte(d);
				
				eventos.add(e);
			}
			return eventos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return eventos;
		}
		
	}
	
	public boolean nuevoEvento(Evento e) {
		try {
			String sql = "insert into olimpiadas.Evento (nombre,id_olimpiada, id_deporte) values (?,?,?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getOlimpiada().getId());
			ps.setInt(3, e.getDeporte().getId());
			
			if(ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean editarEvento(Evento e) {
		try {
			String sql = "update olimpiadas.Evento set nombre = ?, id_olimpiada = ?, id_deporte = ? where id_evento = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getOlimpiada().getId());
			ps.setInt(3, e.getDeporte().getId());
			ps.setInt(4, e.getId());
			
			if(ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
