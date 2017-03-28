<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recorriendo una Lista sencilla con Java dentro de HTML</title>
</head>
<body>

	Iteracion de una Lista:<br>
	<c:forEach items="${lista}" var="persona">
		${persona.apellido},
		${persona.nombre}<br>
	</c:forEach>

	<form:form action ="formulario" modelAttribute="persona" role="form" method="GET">
		<button type= "submit" >Agregar Persona</button>
	</form:form>
	
</body>
</html>