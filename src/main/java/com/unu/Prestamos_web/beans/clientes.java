package com.unu.Prestamos_web.beans;

import java.sql.Date;

public class clientes {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaN;
	private String direccion;

	public clientes() {
		this(0,"","","",null,"");
	}

	public clientes(int id, String nombre, String apellido, String dni, Date fechaN, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaN = fechaN;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaN() {
		return fechaN;
	}

	public void setFechaN(Date fechaN) {
		this.fechaN = fechaN;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}