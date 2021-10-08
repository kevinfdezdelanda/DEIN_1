package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.BranchElement;

import model.Aeropuerto;
import model.AeropuertoPrivado;
import model.AeropuertoPublico;
import model.Direccion;
import util.ConexionDB;

public class GestionarAeropuertos {
	

	private ConexionDB c;

	public GestionarAeropuertos() {
		try {
			c = new ConexionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Aeropuerto> getAeropuertosPrivados(String nombre) {
		ArrayList<Aeropuerto>  aeropuertos = new ArrayList<Aeropuerto>();
		try {
			String sql = "SELECT * FROM aeropuertos a, direcciones d, aeropuertos_privados ap where a.id_direccion = d.id and ap.id_aeropuerto = a.id and a.nombre LIKE ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, "%"+nombre+"%");
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Aeropuerto a = new Aeropuerto();
				Direccion d = new Direccion();
				AeropuertoPrivado ap = new AeropuertoPrivado(); 
				a.setId(rs.getInt("a.id"));
				a.setNombre(rs.getString("nombre"));
				d.setPais(rs.getString("pais"));
				d.setCalle(rs.getString("calle"));
				d.setCiudad(rs.getString("ciudad"));
				a.setAnio_inauguracion(rs.getInt("anio_inauguracion"));
				a.setCapacidad(rs.getInt("capacidad"));
				d.setNumero(rs.getInt("numero"));
				ap.setnSocios(rs.getInt("numero_socios"));
				ap.setIdAeropuerto(a.getId());
				a.setaPrivado(ap);
				a.setDireccion(d);
				aeropuertos.add(a);
			}
			return aeropuertos;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public ArrayList<Aeropuerto> getAeropuertosPublicos(String nombre) {
		ArrayList<Aeropuerto>  aeropuertos = new ArrayList<Aeropuerto>();
		try {
			String sql = "SELECT * FROM aeropuertos a, direcciones d, aeropuertos_publicos ap where a.id_direccion = d.id and ap.id_aeropuerto = a.id and a.nombre LIKE ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, "%"+nombre+"%");
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Aeropuerto a = new Aeropuerto();
				Direccion d = new Direccion();
				AeropuertoPublico ap = new AeropuertoPublico(); 
				a.setId(rs.getInt("a.id"));
				a.setNombre(rs.getString("nombre"));
				d.setPais(rs.getString("pais"));
				d.setCalle(rs.getString("calle"));
				d.setCiudad(rs.getString("ciudad"));
				a.setAnio_inauguracion(rs.getInt("anio_inauguracion"));
				a.setCapacidad(rs.getInt("capacidad"));
				d.setNumero(rs.getInt("numero"));
				ap.setFinanciacion(rs.getDouble("financiacion"));
				ap.setNumTrabajadores(rs.getInt("num_trabajadores"));
				ap.setIdAeropuerto(a.getId());
				a.setaPublico(ap);
				a.setDireccion(d);
				aeropuertos.add(a);
			}
			return aeropuertos;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public boolean nuevoAeropuerto(Aeropuerto a) {
		try {
			String sql = "insert into aeropuertos.direcciones (pais,ciudad,calle,numero) values(?,?,?,?)";
			
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, a.getDireccion().getPais());
			ps.setString(2, a.getDireccion().getCiudad());
			ps.setString(3, a.getDireccion().getCalle());
			ps.setInt(4, a.getDireccion().getNumero());
			
			if(ps.executeUpdate()==0) {
				throw new SQLException();
			}
			
			sql = "SELECT id FROM aeropuertos.direcciones where id = (select max(id) from aeropuertos.direcciones)";
			ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			a.getDireccion().setId(rs.getInt("id"));
			
			sql = "insert into aeropuertos.aeropuertos (id,nombre,anio_inauguracion,capacidad,id_direccion) values(null,?,?,?,?);";
			ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getAnio_inauguracion());
			ps.setInt(3, a.getCapacidad());
			ps.setInt(4, a.getDireccion().getId());
			if(ps.executeUpdate()==0) {
				throw new SQLException();
			}
			
			sql = "SELECT id FROM aeropuertos.aeropuertos where id = (select max(id) from aeropuertos.aeropuertos)";
			ps = c.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			a.setId(rs.getInt("id"));
				
			if(a.getaPublico()!=null) {
				sql = "insert into aeropuertos.aeropuertos_publicos (id_aeropuerto,financiacion,num_trabajadores) values(?,?,?)";
				PreparedStatement ps2 = c.getConexion().prepareStatement(sql);
				ps2.setInt(1, a.getId());
				ps2.setDouble(2, a.getaPublico().getFinanciacion());
				ps2.setInt(3, a.getaPublico().getNumTrabajadores());
				if(ps2.executeUpdate()==0) {
					throw new SQLException();
				}
			}else {
				sql = "insert into aeropuertos.aeropuertos_privados (id_aeropuerto,numero_socios) values(?,?)";
				PreparedStatement ps2 = c.getConexion().prepareStatement(sql);
				ps2.setInt(1, a.getId());
				ps2.setDouble(2, a.getaPrivado().getnSocios());
				if(ps2.executeUpdate()==0) {
					throw new SQLException();
				}
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	public boolean editarAeropuerto(Aeropuerto a) {
		try {
			
			String sql = "update aeropuertos.aeropuertos set nombre=?, anio_inauguracion = ?, capacidad = ? where id = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getAnio_inauguracion());
			ps.setInt(3, a.getCapacidad());
			ps.setInt(4, a.getId());
			if(ps.executeUpdate()==0) {
				throw new SQLException();
			}
			
			sql = "update aeropuertos.direcciones set pais=?, ciudad = ?, calle = ?, numero = ? where id = ? ";
			
			ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, a.getDireccion().getPais());
			ps.setString(2, a.getDireccion().getCiudad());
			ps.setString(3, a.getDireccion().getCalle());
			ps.setInt(4, a.getDireccion().getNumero());
			ps.setInt(5, a.getDireccion().getId());
			
			if(ps.executeUpdate()==0) { 
				throw new SQLException();
			}
			
				
			if(a.getaPublico()!=null) {
				sql = "update aeropuertos.aeropuertos_publicos set financiacion = ?, num_trabajadores = ? where id_aeropuerto = ?";
				PreparedStatement ps2 = c.getConexion().prepareStatement(sql);
				ps2.setInt(3, a.getId());
				ps2.setDouble(1, a.getaPublico().getFinanciacion());
				ps2.setInt(2, a.getaPublico().getNumTrabajadores());
				if(ps2.executeUpdate()==0) {
					throw new SQLException();
				}
			}else {
				sql = "update aeropuertos.aeropuertos_privados set numero_socios = ? where id_aeropuerto = ?";
				PreparedStatement ps2 = c.getConexion().prepareStatement(sql);
				ps2.setInt(2, a.getId());
				ps2.setInt(1, a.getaPrivado().getnSocios());
				if(ps2.executeUpdate()==0) {
					throw new SQLException();
				}
			}
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	public int obtenerIdDireccion(int id) {
		try {
			String sql = "SELECT id_direccion FROM aeropuertos a where a.id = ?";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("a.id_direccion");
			}else {
				return -1;
			}
			
		} catch (Exception e) {
			System.err.println(e);
			return -1;
		}
	}
}
