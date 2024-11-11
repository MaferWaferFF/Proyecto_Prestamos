<%@page import="com.unu.Prestamos_web.beans.prestamos"%>
<%@page import="com.unu.Prestamos_web.beans.clientes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INICIO</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	String url = "http://localhost:8080/Prestamos_web/";
	List<prestamos> lista = (List<prestamos>) request.getAttribute("listarPrestamos");
	String cliente = (String)request.getAttribute("cliente");
	int idC = (int)(request.getAttribute("idCliente"));
	%>
	<div class=" my-3 container">
		<button onclick="location.href='<%=url%>clientesControllers?=listar'"
			class="btn btn-outline-secondary">Volver</button>
	</div>
	<h2 class="text-center my-2">LISTA DE PRESTAMOS</h2><br>
	
	<div class="d-grid gap-2 col-6 mx-auto">
		<button class="btn btn-light"
			onclick="location.href='<%=url%>prestamoController?op=nuevo&id=<%=idC%>'">Nuevo</button>
		<br>
	</div>
	<div class = "container">
		<label>CLIENTE: <%=cliente %></label>
	</div>
	<div class="text-center my-3" class="container-fluid">
		<table id="table" class="table">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>FECHA_PRES</th>
					<th>MONTO</th>
					<!-- <th>CLIENTE</th> -->
					<th>INTERES</th>
					<th>CUOTA</th>
					<th>OPERACIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (lista != null) {
					for (prestamos c : lista) {
				%>
				<tr>
					<td><%=c.getIdP()%></td>
					<td><%=c.getFechaP()%></td>
					<td><%=c.getMonto()%></td>
					<!--<td><%=c.getIdC()%></td> -->
					<td><%=c.getInteres()%></td>
					<td><%=c.getNumCuotas()%></td>
					<td>
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<%=url%>prestamoController?op=obtener&id=<%=c.getIdP()%>&idC=<%=idC%>'">Modificar</button>
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<%=url%>prestamoController?op=eliminar&id=<%=c.getIdP()%>'">Eliminar</button>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>