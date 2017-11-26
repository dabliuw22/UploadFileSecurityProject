<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div id="noticia">
		<h1>Nueva Noticia</h1>
		<c:url value="/" var="noticiaUrl"/>
		<form:form method="POST" action="${noticiaUrl}" modelAttribute="noticia">
			<div>
				<label>Titulo</label>
				<form:input path="titulo" type="text"/>
				<form:errors path="titulo"/>
			</div>
			<div>
				<label>Contenido</label>
				<form:input path="contenido" type="text"/>
				<form:errors path="contenido"/>
			</div>
			<div>
				<input type="submit" value="Crear">
			</div>
		</form:form>
	</div>
	<div id="list-noticia">
		<table>
			<thead>
			 	<tr>
			 		<th>Noticia</th>
			 		<th>Imagen</th>
			 	</tr>
			</thead>
			<tbody>
				<c:forEach items="${noticias}" var="noticia">
					<tr>
						<td>${noticia.titulo}</td>
						<c:if test="${noticia.imagen != '' }">
							<td><img src="data:image/png;base64,${noticia.imagen}"/></td>
						</c:if>
						<c:if test="${noticia.imagen == '' }">
							<td><img src="${pageContext.request.contextPath}/resources/img/default.png"/></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
