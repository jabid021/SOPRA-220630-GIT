
<style>
#choixSport {
	display: none;
}
</style>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

	<h1>Gestion des évenements</h1>
	<button id="btnAdd" class="btn btn-success">Ajouter</button>

	<table class="table table-striped">

		<thead>

			<tr>
				<th>libelle</th>
				<th>date debut</th>
				<th>heure debut</th>
				<th>date fin</th>
				<th>heure fin</th>
				<th>prix</th>
				<th>type evenement</th>
				<th>numero</th>
				<th>voie</th>
				<th>ville</th>
				<th>cp</th>
				<th>choix sport</th>
				<th>gagnant</th>
				<th>actions</th>
			</tr>

		</thead>

		<tbody>
			<c:forEach items="${evenements}" var="e">
				<tr>
					<td>${e.libelle}</td>
					<td>${e.dateDebut}</td>
					<td>${e.heureDebut}</td>
					<td>${e.dateFin}</td>
					<td>${e.heureFin}</td>
					<td>${e.prix}€</td>
					<td>${e.getClass().getSimpleName()}</td>
					<td>${e.adresse.numero}</td>
					<td>${e.adresse.voie}</td>
					<td>${e.adresse.ville}</td>
					<td>${e.adresse.cp}</td>
					<c:choose>

						<c:when
							test="${e.getClass().getSimpleName().equals('Competition')}">
							<td>${e.sport}</td>
							<c:choose>
								<c:when test="${e.gagnant!=null}">
									<td>${e.gagnant.id}</td>
								</c:when>
								<c:otherwise>
									<td>Pas de gagnant</td>
								</c:otherwise>
							</c:choose>

						</c:when>
						<c:otherwise>
							<td>-</td>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<td><a href="evenements?id=${e.id}"><button
								class="btn btn-warning">Modifier</button></a>
						<form action="evenement.java" method="post">
							<input type="hidden" name="tache" value="modifier"> <input
								type="hidden" name="id" value="${e.id}"> <input
								type="submit" value="Supprimer" class="btn btn-danger">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div id="formAjout" align="center">
		<h3>Ajouter un evenement</h3>
		<form action="evenements" method="post">
			<input type="hidden" name="tache" value="ajouter"> Libellé :
			<input required name="libelle" type="text"
				placeholder="Libelle evenement"><br> <br> Date de
			début : <input required name="dateDebut" type="date"> <br>
			<br> Heure de début : <input required name="heureDebut"
				type="time"><br> <br> Date fin : <input required
				name="dateFin" type="date"><br> <br> Heure fin : <input
				required name="heureFin" type="time"><br> <br>
			Prix : <input name="prix" step="0.01" required type="number"
				placeholder="Prix" min="0"><br> <br>


			<fieldset>
				<legend>Adresse</legend>

				Numero : <input name="numero" type="text" required> Voie : <input
					name="voie" type="text" required> Code postale : <input
					name="cp" type="text" required> Ville : <input name="ville"
					type="text" required>
			</fieldset>
			<br> Type d'évenement : <input required name="typeEvenement"
				checked value="festival" id="Efestival" type="radio">
			Festival <input name="typeEvenement" value="competition"
				id="Ecompetition" type="radio"> Compétition<br>

			<div id="choixSport">
				<br> Choix du Sport : <select name="sport">
					<option>Judo</option>
					<option>Foot</option>
					<option>LoL</option>
					<option>Autre</option>
				</select><br>

			</div>
			<br> <input type="submit" value="Ajouter"
				class="btn btn-primary">
		</form>
	</div>
	<a href="menu">Retour</a>


</body>

<script>
	Ecompetition.onchange = displaySport;
	Efestival.onchange = displaySport;

	function displaySport() {
		if (document.getElementById("Ecompetition").checked) {
			choixSport.style.display = "block";
		} else {
			choixSport.style.display = "none";
		}

	}
	btnAdd.onclick = function() {
		formAjout.style.display = "block";
	}
</script>
</html>
