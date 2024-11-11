package com.unu.Prestamos_web.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.Prestamos_web.beans.clientes;
import com.unu.Prestamos_web.util.Conexion;

import java.sql.*;

public class clientesModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<clientes> listarClientes(){
		try {
			List<clientes> lista = new ArrayList<>();
			String sql = "call sp_listarCliente()";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				clientes c = new clientes();
				c.setId(rs.getInt("idclientes"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDni(rs.getString("dni"));
				c.setFechaN(rs.getDate("fechaNacimiento"));
				c.setDireccion(rs.getString("direccion"));
				lista.add(c);
			}
			this.cerrarConexion();
			return lista;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int ingresarClientes (clientes c) {
		try {
			String sql = "call sp_insertarCliente(?,?,?,?,?)";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setString(1, c.getNombre());
			cs.setString(2, c.getApellido());
			cs.setString(3, c.getDni());
			cs.setDate(4, c.getFechaN());
			cs.setString(5, c.getDireccion());
			int filasA = cs.executeUpdate();
			return filasA;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public clientes obtenerClientes (int id) {
		try {
			String sql = "call sp_obtenerCliente(?);";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				clientes c = new clientes();
				c.setId(rs.getInt("idclientes"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDni(rs.getString("dni"));
				c.setFechaN(rs.getDate("fechaNacimiento"));
				c.setDireccion(rs.getString("direccion"));
				this.cerrarConexion();
				return c;
			}
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return null;
		}
		return null;
	}
	
	public int modificarCliente (clientes c) {
		try {
			String sql = "call sp_modificarCliente(?,?,?,?,?,?)";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, c.getId());
			cs.setString(2, c.getNombre());
			cs.setString(3, c.getApellido());
			cs.setString(4, c.getDni());
			cs.setDate(5, c.getFechaN());
			cs.setString(6, c.getDireccion());
			int filasA = cs.executeUpdate();
			return filasA;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminarCliente (int id) {
		try {
			String sql = "call sp_eliminarCliente(?);";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			int filasA = cs.executeUpdate();
			this.cerrarConexion();
			return filasA;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
}
