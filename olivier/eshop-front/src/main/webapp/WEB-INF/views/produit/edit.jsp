<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>edition produit</h1>
		<form action="${base}/produit/save" method="post">
			<div class="form-group">
				<label for="id">id</label> <input id="id" name="id"
					class="form-control" value="${produit.id}"
					placeholder="generation automatique" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="libelle">libellé</label> <input id="libelle"
					name="libelle" class="form-control" value="${produit.libelle}">
			</div>
			<div class="form-group">
				<label for="prix">prix</label> <input type="number" id="prix"
					name="prix" class="form-control" value="${produit.prix}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${base}/produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>