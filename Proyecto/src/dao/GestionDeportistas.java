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
	
	public boolean nuevoDeportista(Deportista d) {
		try {
			String sql = "INSERT INTO `Deportista` (`nombre`, `sexo`, `peso`, `altura`) VALUES (?, ?, ?, ?)";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, d.getNombre());
			ps.setString(2, d.getSexo());
			ps.setInt(3, d.getPeso());
			ps.setInt(4, d.getAltura());

			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean editarDeportista(Deportista d) {
		try {
			String sql = "UPDATE `Deportista` SET `nombre` = ?, `sexo` = ?, `peso` = ?, `altura` = ? WHERE `id_deportista` = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, d.getNombre());
			ps.setString(2, d.getSexo());
			ps.setInt(3, d.getPeso());
			ps.setInt(4, d.getAltura());
			ps.setInt(5, d.getId());

			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean borrarDeportista(Deportista d) {
		try {
			String sql = "DELETE FROM `Deportista` WHERE `deportista`.`id_deportista` = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setInt(1, d.getId());

			if (ps.executeUpdate() == 0) {
				c.cerrarConexion();
				ps.close();
				return false;
			} else {
				c.cerrarConexion();
				ps.close();
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
}
