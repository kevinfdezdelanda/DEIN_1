package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Deportista;
import util.ConexionDB;

public class GestionDeportistas {
	
	public ArrayList<Deportista> getDeportistas() {

		ArrayList<Deportista> deportistas= new ArrayList<Deportista>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Deportista";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Deportista d = new Deportista();

				d.setId(rs.getInt("id_deportista"));
				d.setNombre(rs.getString("nombre"));
				d.setSexo(rs.getString("sexo"));
				d.setPeso(rs.getInt("peso"));
				d.setAltura(rs.getInt("altura"));

				deportistas.add(d);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return deportistas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return deportistas;
		}

	}
}
