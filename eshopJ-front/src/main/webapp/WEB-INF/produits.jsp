<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Produits</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style/style.css">
</head>
<body>

	<!-- EL => Expression Language-->
	<button id="btnAdd" class="btn btn-success">Ajouter</button>



	<div id="content">


		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Libelle</th>
				<th>Prix</th>
				<th>Fournisseur</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.libelle}</td>
					<td>${p.prix}</td>
					<td>${p.fournisseur.nom}
						${p.fournisseur.prenom} -
						${p.fournisseur.societe}</td>
					<td><a href="produits?id=${p.id}"><button
								class="btn btn-warning">Modifier</button></a>
						<form action="produits" method="post">
							<input type="hidden" name="tache" value="supprimer"> <input
								type="hidden" name="id" value="${p.id}"> <input
								type="submit" class="btn btn-danger" value="Supprimer">
						</form></td>
				</tr>


			</c:forEach>



		</table>

		<div id="formAjout">
			<form action="produits" method="post">
				<input type="hidden" name="tache" value="ajouter"> Libelle :
				<input type="text" name="libelle" placeholder="Libelle"><br>
				Prix : <input type="number" step="0.01" name="prix"
					placeholder="Prix"><br> Fournisseur : <select
					name="fournisseur">
					<option value="1">Abid Jordan</option>
					<option value="3">Abid Jordan2</option>
				</select><br> <input type="submit" class="btn btn-primary"
					value="Ajouter">
		</div>






		</form>

	</div>
</body>
</html>


<script>
	btnAdd.onclick = function() {
		formAjout.style.display = "block";
	}
</script>