package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deporte;
import model.Deportista;
import model.Equipo;
import model.Evento;
import model.Participacion;
import util.ConexionDB;

public class GestionParticipaciones {
	
	public GestionParticipaciones() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Participacion> getParticipaciones(Evento e) {

		ArrayList<Participacion> Participaciones = new ArrayList<Participacion>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM olimpiadas.Participacion p, olimpiadas.Deportista d, olimpiadas.Equipo e "
					+ "where p.id_evento = ? and d.id_deportista = p.id_deportista and e.id_equipo = p.id_equipo";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();
			// ResultSet rs = c.ejecutarConsulta(sql);
			while (rs.next()) {
				Participacion p = new Participacion();

				p.setEdad(rs.getInt("p.edad"));
				p.setMedalla(rs.getString("p.medalla"));
				
				p.setEvento(e);
				
				Deportista d = new Deportista();
				d.setId(rs.getInt("d.id_deportista"));
				d.setNombre(rs.getString("d.nombre"));
				d.setAltura(rs.getInt("d.altura"));
				d.setPeso(rs.getInt("d.peso"));
				d.setSexo(rs.getString("d.sexo"));
				p.setDeportista(d);
				
				Equipo eq = new Equipo();
				eq.setId(rs.getInt("e.id_equipo"));
				eq.setNombre(rs.getString("e.nombre"));
				eq.setIniciales(rs.getString("e.iniciales"));
				p.setEquipo(eq);
				
				Participaciones.add(p);
			}
			return Participaciones;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return Participaciones;
		}

	}

	public boolean nuevoDeporte(Deporte d) {
		try {
			String sql = "insert into olimpiadas.Deporte (nombre) values (?)";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, d.getNombre());

			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}