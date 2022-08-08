<html>
<body>

	<title>Gestion Users</title>
	<h2>Tableau des Utilisateurs :</h2>

	<input id="btnAdd" type="button" value="Ajouter">


		<h3>Donnees Utilisateurs</h3>

		<input type="hidden" value="ajouter" name="tache">

		<table border width="80%">

			<thead>

				<tr>
					<th>login</th>
					<th>password</th>
					<th>nom</th>
					<th>prenom</th>
					<th>naissance</th>
					<th>telephone</th>
					<th>numero</th>
					<th>voie</th>
					<th>ville</th>
					<th>cp</th>
					<th>Actions</th>

				</tr>
			</thead>


			<tbody>

				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td>${user.nom}</td>
						<td>${user.prenom}</td>
						<td>${user.naissance}</td>
						<td>${user.telephone}</td>
						<td>${user.adresse.numero}</td>
						<td>${user.adresse.voie}</td>
						<td>${user.adresse.ville}</td>
						<td>${user.adresse.cp}</td>
						<td>
							<a href="users?id=${user.id}">
								<button>Modifier</button>
							</a>
							<form action="users" method="post">
								<input type="hidden" name="tache" value="supprimer"> 
								<input type="hidden" name="id" value="${user.id}"> 
								<input class="btn btn-danger" type="submit" value="Supprimer">
							</form>
							</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

	</form>


	<div id="formAjout" align="center">

		<h3>Ajouter un utilisateur.</h3>
		<form action="users" method="post">

			<table>
				<input type="hidden" value="ajouter" name="tache">
				<tr>
					<td>login :</td>
					<td><input required name="login" type="text"
						placeholder="login/identifiant"></td>
				</tr>
				<tr>
					<td>Mot de passe :</td>
					<td><input name="password" required pattern="[A-9]{4,8}"
						title="4 à 8 lettres !" placeholder="Saisir password"
						type="password"></td>
				</tr>
				<tr>
					<td>nom :</td>
					<td><input required name="nom" type="text" placeholder="nom"></td>
				</tr>
				<tr>
					<td>prenom :</td>
					<td><input required name="prenom" type="text"
						placeholder="prenom"></td>
				</tr>
				<tr>
					<td>Date de naissance :</td>
					<td><input name="dateNaissance" type="date" value="2000-01-01"></td>
				</tr>
				<tr>
					<td>telephone :</td>
					<td><input required name="tel" type="text"
						placeholder="telephone"></td>
				</tr>
				<tr>
					<td>numero :</td>
					<td><input required name="numVoie" type="text"
						placeholder="numero"></td>
				</tr>
				<tr>
					<td>voie :</td>
					<td><input required name="nomVoie" type="text"
						placeholder="nvoie"></td>
				</tr>
				<tr>
					<td>ville :</td>
					<td><input required name="ville" type="text"
						placeholder="ville"></td>
				</tr>
				<tr>
					<td>cp :</td>
					<td><input required name="cp" type="text"
						placeholder="code postal"></td>
				</tr>
			</table>
			<input type="submit" value="Ajouter">
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