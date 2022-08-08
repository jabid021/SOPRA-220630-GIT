
<!DOCTYPE html>
<html>
<head>

<title>Gestion des Intervenants</title>
</head>
<body>



	<button id="btnAdd" class="btn btn-success">Ajouter</button>

	<table class="table table-striped" border width="80%">

		<thead>

			<tr>
				<th>Nom</th>
				<th>Talents</th>
				<th>Actions</th>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${intervenants}" var="i">
				<tr>
					<td>${i.nom}</td>
					<td><c:choose>

							<c:when test="${i.talents.isEmpty()}">Aucun Talent</c:when>
							<c:otherwise>${i.talents}</c:otherwise>
						</c:choose></td>
					<td><a href="intervenants?id=${i.id}"><button
								class="btn btn-warning">Modifier</button></a>
						<form action="intervenants" method="post">
							<input type="hidden" name="tache" value="supprimer"> <input
								type="hidden" name="id" value="${i.id}"> <input
								class="btn btn-danger" type="submit" value="Supprimer">
						</form></td>
				</tr>

			</c:forEach>

			<c:if test="${intervenants.isEmpty()}">

				<tr>
					<td colspan=3 align="center">Aucun intervenant</td>
				</tr>
			</c:if>




		</tbody>


	</table>

	<div id="formAjout" align="center">

		<h3>Ajouter un intervenant</h3>
		<form action="intervenants" method="post">
			<input type="hidden" name="tache" value="ajouter"> Nom : <input
				required name="nom" type="text" placeholder="nom intervenant"><br>
			Talents :
			<c:forEach items="${talents}" var="talent">
				<input name="${talent}" type="checkbox">${talent} 

		</c:forEach>

			<br> <input type="submit" value="Ajouter"
				class="btn btn-primary">
		</form>
	</div>

	<a href="menu">Retour</a>





</body>
</html>



<script>
	btnAdd.onclick = function() {
		formAjout.style.display = "block";
	}
</script>