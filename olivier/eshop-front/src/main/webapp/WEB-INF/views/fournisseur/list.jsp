<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>liste des fournisseurs</h1>
		<table class="table">
			<thead>
				<th>id</th>
				<th>prenom</th>
				<th>nom</th>
				<th>societe</th>
				<th>adresse</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach var="f" items="${fournisseurs}">
					<tr>
						<td>${f.id}</td>
						<td>${f.prenom}</td>
						<td>${f.nom}</td>
						<td>${f.societe}</td>
						<td>${f.adresse.adresse}</td>
						<td><a href="${base}/fournisseur/edit?id=${f.id}"
							class="btn btn-outline-primary">editer</a></td>
						<td><a href="${base}/fournisseur/delete?id=${f.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${base}/fournisseur/add" class="btn btn-link">nouveau
			fournisseur</a>
	</div>
</body>
</html>