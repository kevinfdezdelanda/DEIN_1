package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionDB;

public class Main {
    public static void main(String[] args) {
        ConexionDB conexion;
        try {
            conexion = new ConexionDB();
            String SQL = "SELECT * FROM aviones";
            ResultSet rs = conexion.ejecutarConsulta(SQL);
            while (rs.next()) {
                int idAvion = rs.getInt("id");
                String modelo = rs.getString("modelo");
                int numeroAsientos = rs.getInt("numero_asientos");
                int velMax = rs.getInt("velocidad_maxima");
                int activado = rs.getInt("activado");

                System.out.println("id: " + idAvion);
                System.out.println("modelo: " + modelo);
                System.out.println("numero de asientos: " + numeroAsientos);
                System.out.println("velocidad máxima: " + velMax);
                System.out.println("activado: " + activado);
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}