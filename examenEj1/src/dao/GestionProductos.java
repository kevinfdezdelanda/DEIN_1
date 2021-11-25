package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Producto;
import util.ConexionDB;

public class GestionProductos {
	public GestionProductos() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Producto> getProductos(){
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen1.productos";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			while(rs.next()) {
				Producto p = new Producto();
				
				p.setCodigo(rs.getString("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getFloat("precio"));
				p.setDisponible(rs.getInt("disponible"));
								
				productos.add(p);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return productos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return productos;
		}
		
	}
	
public ArrayList<Producto> getProductosFiltrados(String filtro){
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM examen1.productos where codigo like ? or nombre like ? or precio like ?;";
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, "%"+filtro+"%");
			ps.setString(2, "%"+filtro+"%");
			ps.setString(3, "%"+filtro+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto p = new Producto();
				
				p.setCodigo(rs.getString("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getFloat("precio"));
				p.setDisponible(rs.getInt("disponible"));
								
				productos.add(p);
			}
			c.cerrarConexion();
			ps.close();
			rs.close();
			return productos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return productos;
		}
		
	}
	
	public boolean nuevoProducto(Producto p) {
		try {
			String sql = "INSERT INTO `examen1`.`productos` (`codigo`, `nombre`, `precio`, `disponible`) VALUES (?, ?, ?, ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, (float) p.getPrecio());
			ps.setInt(4, p.getDisponible());
			
			if(ps.executeUpdate()==0) {
				c.cerrarConexion();
				ps.close();	
				return false;
			}else {
				c.cerrarConexion();
				ps.close();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean editarProducto(Producto p) {
		try {
			String sql = "UPDATE `examen1`.`productos` SET `codigo` = ?, `nombre` = ?, `precio` = ?, `disponible` = ? WHERE (`codigo` = ?);";

			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);

			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, (float) p.getPrecio());
			ps.setInt(4, p.getDisponible());
			ps.setString(5, p.getCodigo());
			
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
	
	public boolean borrarProducto(Producto p) {
		try {
			String sql = "DELETE FROM `examen1`.`productos` WHERE (`codigo` = ?);";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, p.getCodigo());
			
			if(ps.executeUpdate()==0) {
				c.cerrarConexion();
				ps.close();	
				return false;
			}else {
				c.cerrarConexion();
				ps.close();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean existeCodigo(String codigo) {
		try {
			String sql = "SELECT * FROM examen1.productos where codigo = ?";
			
			ConexionDB c = new ConexionDB();
			PreparedStatement ps = c.getConexion().prepareStatement(sql);
			
			ps.setString(1, codigo);
			
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = c.ejecutarConsulta(sql);
			if(rs.next()) {
				ps.close();
				rs.close();
				return true;
			}else {
				ps.close();
				rs.close();
				return false;
			}
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			return true;
		}
	}
}
