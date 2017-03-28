<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario</title>
</head>
<body>

<form:form action ="confirmacion" modelAttribute="persona" role="form" method="POST">
	<div class="form-group">
		<form:label path="Nombre"></form:label>
		<form:input id="nombre" class="form-control" type="text" path="nombre" placeholder="Ingresar Nombre"></form:input>
	</div>
	<div class="form-group">
		<form:label path="Apellido"></form:label>
		<form:input id="apellido" class="form-control" type="text" path="apellido" placeholder="Ingresar Apellido"></form:input>
	</div>
	<button type= "submit" >Enviar</button>
</form:form>

	
</body>
</html>