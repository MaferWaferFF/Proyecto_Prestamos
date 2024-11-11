package com.unu.Prestamos_web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.Prestamos_web.beans.prestamos;
import com.unu.Prestamos_web.model.clientesModel;
import com.unu.Prestamos_web.model.prestamoModel;

public class prestamoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	prestamoModel model = new prestamoModel();
	clientesModel modelC = new clientesModel();

    public prestamoController() {
        super();
    }

    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			int idC =Integer.parseInt(request.getParameter("id"));
			//System.out.println("nuevo-"+idC);
			request.setAttribute("idC", idC);
			request.getRequestDispatcher("/prestamos/nuevoPrestamo.jsp").forward(request, response);		
			break;
		case "ingresar":
			ingresar(request, response);
			break;
		/*case "obtener":
			obtener(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;
		case "prestamo":
			eliminar(request, response);
			break;*/
		}
	}
    
    protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("->"+id);
			request.setAttribute("listarPrestamos", model.listarPrestamo(id));
			request.setAttribute("idCliente", id);
			request.setAttribute("cliente", modelC.obtenerClientes(id).getNombre()+" "+modelC.obtenerClientes(id).getApellido());
			request.getRequestDispatcher("/prestamos/listarPrestamo.jsp").forward(request, response);
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
    
   protected void ingresar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			prestamos p = new prestamos();
			int idC = Integer.parseInt(request.getParameter("id"));	
			System.out.println("agregar->"+idC);
			p.setFechaP(Date.valueOf(request.getParameter("fecha")));
			p.setMonto(Float.parseFloat(request.getParameter("mon")));
			p.setIdC((modelC.obtenerClientes(idC).getNombre()+" "+modelC.obtenerClientes(idC).getApellido()));
			p.setInteres(Integer.parseInt(request.getParameter("int")));
			p.setNumCuotas(Integer.parseInt(request.getParameter("cuotas")));
			if (model.agregarPrestamo(p, idC)>0) {
				response.sendRedirect(request.getContextPath()+"/prestamoController?op=listar&id="+idC);
			}			
		} catch (IOException e) {
			Logger.getLogger(clientesModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
