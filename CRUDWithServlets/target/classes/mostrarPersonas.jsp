<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="es.springboot.application.model.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mostrar personas</title>
	</head>
	<body>
		<h1>Lista de persona</h1>
		<%
			List<Persona> listaPersonas = (List) request.getSession().getAttribute("listaPersonas");
			int cont=0;
			for(Persona pers:listaPersonas){
				cont++;
		%>
			<p><b>Persona N°<%=cont%></b></p>
			<p>Nombre: <%=pers.getNombre()%></p>
			<p>Apellido: <%=pers.getApellido()%></p>
			<p>Email: <%=pers.getEmail()%></p>
			<p>Telefono: <%=pers.getTelefono()%></p>
		
		<%
			}
		%>

	</body>	
	
</html>
