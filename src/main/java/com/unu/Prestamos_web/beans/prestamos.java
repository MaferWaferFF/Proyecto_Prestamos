package com.unu.Prestamos_web.beans;

import java.sql.Date;

public class prestamos {
	private int idP;
	private Date fechaP;
	private float monto;
	private String idC;
	private int interes;
	private int numCuotas;
	
	public prestamos(int idP, Date fechaP, float monto, String idC, int interes, int numCuotas) {
		super();
		this.idP = idP;
		this.fechaP = fechaP;
		this.monto = monto;
		this.idC = idC;
		this.interes = interes;
		this.numCuotas = numCuotas;
	}

	public prestamos() {
		this(0,null,0,"",0,0);
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public Date getFechaP() {
		return fechaP;
	}

	public void setFechaP(Date fechaP) {
		this.fechaP = fechaP;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getInteres() {
		return interes;
	}

	public void setInteres(int interes) {
		this.interes = interes;
	}

	public int getNumCuotas() {
		return numCuotas;
	}

	public void setNumCuotas(int numCuotas) {
		this.numCuotas = numCuotas;
	}

	public String getIdC() {
		return idC;
	}

	public void setIdC(String idC) {
		this.idC = idC;
	}
	
	
	
}
