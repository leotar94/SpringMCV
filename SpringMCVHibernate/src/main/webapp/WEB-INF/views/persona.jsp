<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix = "spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<html>
<head>
<title>Persona</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<link href="https://unpkg.com/browse/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<body>
<div type="container">
	<div class="row">
		<div class="col-md-4">
		<h1>
		Aggiungi una persona
	</h1>
		<c:url var="addAction" value="/persona/add" />
	
	<form:form action="${addAction}" commandName="persona">
		<table border="1" class="table table-striped">
			<c:if test="${!empty persona.nome }">
				<tr>
					<td>
						<form:label path="id">
							<spring:message text="ID" />
						</form:label>
					</td>
					<td>
						<form:input path="id" readonly="true" size="8" disabled="true"/>
						<form:hidden path="id"/>
					</td>
			</c:if>
			<tr>
				<td>
					<form:label path="nome">
						<spring:message text="Nome" />
					</form:label>
				</td>
				<td>
					<form:input path="nome" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="cognome">
						<spring:message text="Cognome" />
					</form:label>
				</td>
				<td>
					<form:input path="cognome" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="residenza">
						<spring:message text="Residenza" />
					</form:label>
				</td>
				<td>
					<form:input path="residenza" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${!empty persona.nome }">
						<button class="btn btn-outline-warning" value="<spring:message text="Modifica" />" type="submit">
							<span class="spinner-grow spinner-grow-sm"></span>
							Modifica..
						</button>						
					</c:if>
					<c:if test="${empty persona.nome }">
						<input type="submit" value="<spring:message text="Aggiungi" />" />
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
		</div>
		<div class="col-md-8">
		<h1>
		Persone presenti
	</h1>
	<c:if test="${!empty listaPersone }">
		<table class="table table-hover">
			<tr>
				<th class="table-dark">Lista DB</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Residenza</th>
				<th>Modifica</th>
				<th>Elimina</th>
			</tr>
			<c:forEach items="${listaPersone }" var="persona">
				<tr>
					<td>${persona.id }</td>
					<td>${persona.nome }</td>
					<td>${persona.cognome }</td>
					<td>${persona.residenza }</td>
					<td><a href="<c:url value='/edit/${persona.id }' />">Modifica</a></td>
					<td><a href="<c:url value='/remove/${persona.id }' />">Elimina</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		</div>
	</div>
	<br />
</div>
</body>
</html>