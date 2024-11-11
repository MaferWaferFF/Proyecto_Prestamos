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
	<div class="text-center my-3" class="container-fluid">
	<h2>LISTA DE CLIENTES</h2><br>
	<%
	String url = "http://localhost:8080/Prestamos_web/";
	%>
	<div class="d-grid gap-2 col-6 mx-auto">
		<button class="btn btn-light" onclick ="location.href='<%=url%>clientesControllers?op=nuevo'">Nuevo</button><br>
	</div>
	<table id="table" class ="table">
		<thead class="table-dark">
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>APELLIDO</th>
				<th>DNI</th>
				<th>FECHA_NACI</th>
				<th>DIRECCION</th>
				<th>OPERACIONES</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<clientes> lista = (List<clientes>) request.getAttribute("listarClientes");
			if (lista != null) {
				for (clientes c : lista) {
			%>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getNombre()%></td>
				<td><%=c.getApellido()%></td>
				<td><%=c.getDni()%></td>
				<td><%=c.getFechaN()%></td>
				<td><%=c.getDireccion()%></td>
				<td>
					<button type ="button" class = "btn btn-secondary" onclick="location.href='<%=url%>clientesControllers?op=obtener&id=<%=c.getId()%>'">Modificar</button>
					<button type ="button" class = "btn btn-secondary" onclick="location.href='<%=url%>prestamoController?op=listar&id=<%=c.getId()%>'">Préstamo</button>
					<button type ="button" class = "btn btn-secondary" onclick="location.href='<%=url%>clientesControllers?op=eliminar&id=<%=c.getId()%>'">Eliminar</button>
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