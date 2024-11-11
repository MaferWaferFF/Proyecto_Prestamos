package com.unu.Prestamos_web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.Prestamos_web.beans.clientes;
import com.unu.Prestamos_web.beans.prestamos;
import com.unu.Prestamos_web.model.clientesModel;
import com.unu.Prestamos_web.model.prestamoModel;

public class clientesControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	clientesModel model = new clientesModel();

	public clientesControllers() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return ;
			}

			String ope = request.getParameter("op");
			System.out.println(ope);
			switch (ope) {
			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/clientes/nuevoCliente.jsp").forward(request, response);
				break;
			case "ingresar":
				ingresar(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			}
			
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("listarClientes", model.listarClientes());
			request.getRequestDispatcher("/clientes/listarCliente.jsp").forward(request, response);
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	
	protected void ingresar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			clientes c= new clientes();
			c.setNombre(request.getParameter("nom"));
			c.setApellido(request.getParameter("ape"));
			c.setDni(request.getParameter("dni"));
			c.setFechaN(Date.valueOf(request.getParameter("fecha")));
			c.setDireccion(request.getParameter("dire"));
			if(model.ingresarClientes(c) > 0) {
				response.sendRedirect(request.getContextPath()+"/clientesControllers?=listar");
			}
		} catch (Exception e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	
	protected void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			clientes c = model.obtenerClientes(id);
			if ( c != null) {
				request.setAttribute("cliente", c);
				request.getRequestDispatcher("/clientes/modificarCliente.jsp").forward(request, response);;				
			}
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			clientes c= new clientes();
			//System.out.println("->");
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("->"+id);
			c.setId(id);
			c.setNombre(request.getParameter("nom"));
			c.setApellido(request.getParameter("ape"));
			c.setDni(request.getParameter("dni"));
			c.setFechaN(Date.valueOf(request.getParameter("fecha")));
			c.setDireccion(request.getParameter("dire"));
			if(model.modificarCliente(c) > 0) {
				response.sendRedirect(request.getContextPath()+"/clientesControllers?=listar");
			}
		} catch (Exception e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			clientes c = model.obtenerClientes(id);
			if ( model.eliminarCliente(id) > 0) {
				response.sendRedirect(request.getContextPath()+"/clientesControllers?op=listar");
			}
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
