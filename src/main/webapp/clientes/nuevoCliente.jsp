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
	%>
	<h2 class="text-center my-2">NUEVO CLIENTE</h2>
	<div class="container">
		<button onclick = "location.href='<%=url%>clientesControllers?=listar'" class="btn btn-outline-secondary" >Volver</button>
	</div>		
	<hr class="border border-dark border-2 opacity-50">
	<div  class = "container">
		<form action="<%=url%>clientesControllers" method="post">
			<input type="hidden" name="op" value="ingresar">
			<label for="nom">Nombre:</label><br>
			<input class="form-control" name = "nom" placeholder="Ingrese el nombre"><br>
			<label for="ape">Apellido:</label><br>
			<input class="form-control" name = "ape" placeholder="Ingrese el apellido"><br>
			<label for="dni">DNI:</label><br>
			<input class="form-control" name = "dni" placeholder="Ingrese el dni"><br>
			<label for="fecha">Fecha de Nacimiento:</label><br>
			<input class="form-control" name = "fecha" placeholder="Ingrese el fecha(yyyy-mm-dd)"><br>
			<label for="dire">Dirección:</label><br>
			<input class="form-control" name = "dire" placeholder="Ingrese la dirección"><br>
			<button type="submit" id ="ingresar" name="ingresar"  type ="button" class = "btn btn-secondary" >Guardar</button>
		</form>
	</div>
</body>
</html>