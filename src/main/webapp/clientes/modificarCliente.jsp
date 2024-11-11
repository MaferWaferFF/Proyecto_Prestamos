<%@page import="com.unu.Prestamos_web.beans.clientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	String url = "http://localhost:8080/Prestamos_web/";
	clientes c = (clientes)request.getAttribute("cliente");
	%>
	<h2 class="text-center my-2">NUEVO CLIENTE</h2>
	<div class="container">
		<button onclick = "location.href='<%=url%>clientesControllers?=listar'" class="btn btn-outline-secondary" >Volver</button>
	</div>		
	<hr class="border border-dark border-2 opacity-50">
	<div  class = "container">
		<form action="<%=url%>clientesControllers" method="post">
			<input type="hidden" name="op" value="modificar">
			<input type="hidden" name="id" value="<%=c.getId()%>"> 
			<label for="nom">Nombre:</label><br>
			<input class="form-control" name = "nom" value="<%=c.getNombre() %>"><br>
			<label for="ape">Apellido:</label><br>
			<input class="form-control" name = "ape" value="<%=c.getApellido() %>"><br>
			<label for="dni">DNI:</label><br>
			<input class="form-control" name = "dni" value="<%=c.getDni() %>"><br>
			<label for="fecha">Fecha de Nacimiento:</label><br>
			<input class="form-control" name = "fecha" value="<%=c.getFechaN() %>""><br>
			<label for="dire">Dirección:</label><br>
			<input class="form-control" name = "dire" value="<%=c.getDireccion() %>"><br>
			<button type="submit" id ="modificar" name="modificar"  type ="button" class = "btn btn-secondary" >Modificar</button>
		</form>
	</div>
</body>
</html>