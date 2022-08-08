
<!DOCTYPE html>
<html>
<head>

<title>Gestion des prestations</title>
</head>
<body>

	<button id="btnAdd" class="btn btn-success">Ajouter</button>

	<table class="table table-striped" border width="80%">
		<thead>
			<tr>
				<th>Date debut</th>
				<th>Heure debut</th>
				<th>Date fin</th>
				<th>Heure fin</th>
				<th>Id-Nom Intervenant</th>
				<th>Id-Nom Festival</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${prestations}" var="p">
				<tr>
					<td>${p.dateDebut}</td>
					<td>${p.heureDebut}</td>
					<td>${p.dateFin}</td>
					<td>${p.heureFin}</td>
					<td>${p.intervenant.id}- ${p.intervenant.nom}</td>

					<td>${p.festival.id}- ${p.festival.libelle}</td>

					<td><a href="prestations?id=${p.id}"><button
								class="btn btn-warning">Modifier</button></a>
						<form action="prestations" method="post">
							<input type="hidden" name="tache" value="supprimer"> <input
								type="hidden" name="id" value="${p.id}"> <input
								class="btn btn-danger" type="submit" value="Supprimer">
						</form></td>
				</tr>

			</c:forEach>

			<c:if test="${prestations.isEmpty()}">

				<tr>
					<td colspan=7 align="center">Aucune prestation</td>
				</tr>
			</c:if>



		</tbody>
	</table>

	<div id="formAjout" align="center">
		<h2>Ajouter une prestation</h2>


		<form action="prestations" method="post">
			<input type="hidden" value="ajouter" name="tache"> 
			Date début : <input name="date_debut" type="date"><br> <br>
			Heure début: <input name="heure_debut" type="time"><br>
			<br> Date fin : <input name="date_fin" type="date"><br>
			<br> Heure fin : <input name="heure_fin" type="time"><br>
			<br> Intervenant : <select name="intervenant">
				<c:forEach items="${intervenants}" var="intervenant">
					<option value="${intervenant.id}">${intervenant.nom}</option>
				</c:forEach>

			</select> <br> Festival : <select name="festival">
				<c:forEach items="${festivals}" var="festival">
					<option value="${festival.id}">${festival.libelle}</option>
				</c:forEach>
			</select><br> <br> <input type="submit" value="Ajouter"
				class="btn btn-primary"></input>
		</form>
	</div>

	<a href="menu"><button type="button">Retour</button></a>


</body>
</html>
<script>
	btnAdd.onclick = function() {
		formAjout.style.display = "block";
	}
</script>