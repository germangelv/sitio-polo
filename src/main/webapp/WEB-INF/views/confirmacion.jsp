<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmar - Datos</title>
</head>
<body>

<form:form action ="lista" modelAttribute="persona" role="form" method="POST">
	<div class="form-group">
		<form:label path="Nombre">Nombre: ${nombre}</form:label>
	</div>
	<div class="form-group">
		<form:label path="Nombre">Apellido: ${apellido}</form:label>
	</div>
	
	<form:input id="nombre" class="form-control" type="hidden" path="nombre" ></form:input>
	<form:input id="apellido" class="form-control" type="hidden" path="apellido" ></form:input>
	
	<button type= "submit" >Confirmar</button>
</form:form>

	
</body>
</html>