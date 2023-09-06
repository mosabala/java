<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Formulario de Prueba</title>
	</head>
	<body>
		<h1>Datos de la persona</h1>
		<form action="SvPersonas" method="post">
			<p><label>Dni: </label> <input type="text" name="dni"></p>
			<p><label>Nombre: </label> <input type="text" name="nombre"></p>
			<p><label>Apellido: </label> <input type="text" name="apellido"></p>
			<p><label>Telefono: </label> <input type="text" name="telefono"></p>
			<button type="submit">Enviar</button>
		</form>

		<br>
		<br>
		<h1>Ver lista de personas</h1>
		<p>Para ver la lista de personas haga click en el siguiente botón</p>
		<form action="SvPersonas" method="get">
			<button type="submit">Ver</button>
		</form>


	</body>	
	
</html>
