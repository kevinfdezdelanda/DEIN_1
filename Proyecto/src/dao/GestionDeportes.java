package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Evento;
import model.Olimpiada;
import util.ConexionDB;

public class GestionDeportes {
	public GestionDeportes() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Deporte> getDeportes(){
		
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Deporte";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Deporte d = new Deporte();
				
				d.setId(rs.getInt("id_deporte"));
				d.setNombre(rs.getString("nombre"));
								
				deportes.add(d);
			}
			return deportes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return deportes;
		}
		
	}
	
	public boolean nuevoDeporte(Deporte d) {
		try {
			String sql = "insert into olimpiadas.Deporte (nombre) values (?)";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, d.getNombre());
			
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
