<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Agrgar imagen para ${noticia}</h1>
		<form:form method="POST" action="" modelAttribute="imagen" enctype="multipart/form-data">
			<div>
				<label>Imagen</label>
				<form:input path="file" type="file"/>
				<form:errors path="file"/>
			</div>
			<div>
				<input type="submit" value="Cargar">
			</div>
		</form:form>
	</div>
</body>
</html>