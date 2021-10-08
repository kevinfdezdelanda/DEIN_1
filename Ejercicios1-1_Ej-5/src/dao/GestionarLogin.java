package dao;

import java.sql.ResultSet;

import util.ConexionDB;

public class GestionarLogin {
	String user;
	String pass;
	
	public GestionarLogin(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	public boolean iniciarSesion() {
		try {
			ConexionDB c = new ConexionDB();
			String sql = "SELECT * FROM usuarios where usuario = '"+user+"' and password = '"+pass+"' ";
			ResultSet rs = c.ejecutarConsulta(sql);
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
}
