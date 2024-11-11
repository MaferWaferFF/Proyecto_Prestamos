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
	int id = (int)(request.getAttribute("idC")); 
	%>
	<h2 class="text-center my-2">NUEVO PRESTAMO</h2>
	<div class="container">
		<button onclick = "location.href='<%=url%>prestamoController?op=listar&id=<%=id%>'" class="btn btn-outline-secondary" >Volver</button>
	</div>		
	<hr class="border border-dark border-2 opacity-50">
	<div  class = "container">
		<form action="<%=url%>prestamoController" method="post">
			<input type="hidden" name="op" value="ingresar">
			<input type="hidden" name="id" value="<%=id%>">
			<label for="fecha">Fecha Prestamo:</label><br>
			<input class="form-control" name = "fecha" placeholder="Ingrese la fecha(yyyy-mm-dd)"><br>
			<label for="mon">Monto:</label><br>
			<input class="form-control" name = "mon" placeholder="Ingrese el monto"><br>
			<label for="int">Interes:</label><br>
			<input class="form-control" name = "int" placeholder="Ingrese el interes(%)"><br>
			<label for="cuotas">Número de Cuotas:</label><br>
			<input class="form-control" name = "cuotas" placeholder="Ingrese el numero de cuotas"><br>
			<button type="submit" id ="ingresar" name="ingresar"  type ="button" class = "btn btn-secondary" >Guardar</button>
		</form>
	</div>
</body>
</html>