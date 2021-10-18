package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Equipo;
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
	
	public boolean nuevoEquipo(Equipo e) {
		try {
			String sql = "INSERT INTO `Equipo` (`nombre`, `iniciales`) VALUES (?, ?);";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, e.getNombre());
			ps.setString(2, e.getIniciales());

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

	public boolean editarEquipo(Equipo e) {
		try {
			String sql = "UPDATE `Equipo` SET `nombre` = ?, `iniciales` = ? WHERE `id_equipo` = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, e.getNombre());
			ps.setString(2, e.getIniciales());
			ps.setInt(3, e.getId());
			
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
	
	public boolean borrarEquipo(Equipo e) {
		try {
			String sql = "DELETE FROM `Equipo` WHERE id_equipo = ?";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setInt(1, e.getId());

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
