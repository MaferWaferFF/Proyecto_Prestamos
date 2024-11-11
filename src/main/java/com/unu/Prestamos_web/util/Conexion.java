package com.unu.Prestamos_web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public Connection con;
	public String url = "jdbc:mysql://localhost:3306/bdprestamos";
	public String pass = "Mibb2205@fer";
	public String user = "Mareah";

	public void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			if (con != null) {
				System.out.println("Conexion ok");
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion (){
		try {			
			if (con!=null && con.isClosed()) {
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
