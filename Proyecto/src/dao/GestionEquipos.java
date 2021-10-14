package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Deportista;
import model.Equipo;
import util.ConexionDB;

public class GestionEquipos {
	
	public ArrayList<Equipo> getEquipos() {

		ArrayList<Equipo> equipos= new ArrayList<Equipo>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Equipo";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Equipo e = new Equipo();

				e.setId(rs.getInt("id_equipo"));
				e.setNombre(rs.getString("nombre"));
				e.setIniciales(rs.getString("iniciales"));
				
				equipos.add(e);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return equipos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return equipos;
		}

	}
}
