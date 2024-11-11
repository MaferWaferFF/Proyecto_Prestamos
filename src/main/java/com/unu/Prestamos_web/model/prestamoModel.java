package com.unu.Prestamos_web.model;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.Prestamos_web.beans.clientes;
import com.unu.Prestamos_web.beans.prestamos;
import com.unu.Prestamos_web.util.Conexion;

public class prestamoModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<prestamos> listarPrestamo(int id){
		try {
			List<prestamos> lista = new ArrayList<>();
			String sql = "call sp_listarPrestamo(?)";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			while (rs.next()) {
				prestamos p = new prestamos();
				p.setIdP(rs.getInt("idprestamos"));
				p.setFechaP(rs.getDate("fechaPrestamo"));
				p.setMonto(rs.getFloat("monto"));
				p.setIdC(rs.getString("cliente"));
				p.setInteres(rs.getInt("interes"));
				p.setNumCuotas(rs.getInt("numCuotas"));
				System.out.println("-idprestamo "+p.getIdP());
 				lista.add(p);
			}
			this.cerrarConexion();
			return lista;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,"problema con listar prestamo",e);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int agregarPrestamo (prestamos p, int idC) {
		try {
			String sql = "call sp_ingresarPrestamo(?,?,?,?,?)";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setDate(1, p.getFechaP());
			cs.setFloat(2, p.getMonto());
			cs.setInt(3, idC);
			cs.setInt(4, p.getInteres());
			cs.setInt(5, p.getNumCuotas());
			int filas = cs.executeUpdate();			
			this.cerrarConexion();
			return filas;
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,"problema con obtener",e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public prestamos obtenerPrestamo(int id) {
		try {
			String sql = "call sp_obtenerPrestamo(?)";
			this.abrirConexion();
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if (rs.next()) {
				prestamos p = new prestamos();
				p.setIdP(rs.getInt("idprestamos"));
				p.setFechaP(rs.getDate("fechaPrestamo"));
				p.setMonto(rs.getFloat("monto"));
				p.setIdC(rs.getString("cliente"));
				p.setInteres(rs.getInt("interes"));
				p.setNumCuotas(rs.getInt("numCuotas"));
				return p;
			}
			this.cerrarConexion();
		}catch (SQLException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE,"problema con obtener",e);
			this.cerrarConexion();
			return null;
		}
		return null;
	}

}
