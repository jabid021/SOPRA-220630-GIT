
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche User</title>
</head>
<body>
	<h1>Modifier User</h1>

	<form action="users" method="post">
		<input type="hidden" value="modifier" name="tache"> <input
			type="hidden" name="id" value="${user.id}">
		<h3>Utilisateur Compte</h3>
		<table>
			<tr>
				<td>Login :</td>
				<td><input required name="login" type="text" value="${user.login}">
				</td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input required name="password" type="password"
					value="${user.password}"></td>
			</tr>
		</table>


		<h3>Utilisateur Détails</h3>

		<table>
			<tr>
				<td>Nom</td>
				<td><input required name="nom" type="text" value="${user.nom}">
				</td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><input required name="prenom" type="text"
					value="${user.prenom}"></td>
			</tr>

			<tr>
				<td>Date de naissance :</td>
				<td><input required name="dateNaissance" type="date"
					value="${user.naissance}"></td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td><input required name="tel" type="text" value="${user.telephone}">
				</td>
			</tr>
			<tr>
				<td>Numero :</td>
				<td><input required name="numVoie" type="text" value="${user.adresse.numero}">
				</td>
			</tr>
			<tr>
				<td>Voie</td>
				<td><input required name="nomVoie" type="text"
					value="${user.adresse.voie}"></td>
			</tr>

			<tr>
				<td>Ville</td>
				<td><input required name="ville" type="text" value="${user.adresse.ville}">
				</td>
			</tr>
			<tr>
				<td>Code postal</td>
				<td><input required name="cp" type="text" value="${user.adresse.cp}">
				</td>
			</tr>
		</table>

		<input type="submit" value="Modifier">
	</form>
	
	<a href="users">Annuler</a>
</body>
</html>