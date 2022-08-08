
<!DOCTYPE html>
<html>
<head>
<title>Fiche Evenement</title>
</head>
<body>

	<h3>Modifier un evenement</h3>
	<form action="evenements" method="post">
		<input type="hidden" name="tache" value="modifier">
		
		<input type="hidden" name="id" value="${evenement.id}">
		 Libellé : <input
			required name="libelle" type="text" placeholder="Libelle evenement"
			value="${evenement.libelle}"><br> <br> Date de
		début : <input required name="dateDebut" type="date"
			value="${evenement.dateDebut}"> <br> <br> Heure de
		début : <input required name="heureDebut" type="time"
			value="${evenement.heureDebut}"><br> <br> Date fin
		: <input required name="dateFin" type="date"
			value="${evenement.dateFin}"><br> <br> Heure fin :
		<input required name="heureFin" type="time"
			value="${evenement.heureFin}"><br> <br> Prix : <input
			name="prix" required type="number" placeholder="Prix" min="0"
			value="${evenement.prix}"><br> <br>


		<fieldset>
			<legend>Adresse</legend>

			Numero : <input name="numero" type="text"
				value="${evenement.adresse.numero}" > 
				Voie : <input name="voie" type="text" value="${evenement.adresse.voie}" >
			Code postale : <input name="cp" type="text"
				value="${evenement.adresse.cp}" > Ville : <input
				name="ville" type="text" value="${evenement.adresse.ville}">
		</fieldset>
		<br> Type d'évenement : <input
			<c:if test="${evenement.getClass().getSimpleName().equals('Festival')}">checked</c:if>
			required name="typeEvenement" value="festival" id="Efestival"
			type="radio"> Festival <input
			<c:if test="${evenement.getClass().getSimpleName().equals('Competition')}">checked</c:if>
			name="typeEvenement" value="competition" id="Ecompetition"
			type="radio"> Compétition<br>

		<div id="choixSport">
			<br> Choix du Sport : <select name="sport">
				<option>Judo</option>
				<option>Foot</option>
				<option>LoL</option>
				<option>Autre</option>
			</select><br> Gagnant : <select name="gagnant">
				<c:forEach items="${participants}" var="p">
					<option value="${p.id}">${p.nom}</option>
				</c:forEach>

			</select><br> <br>
		</div>
		<input type="submit" class="btn btnViolet" value="Modifier"> <a
			href="evenements"><button class="btn btn-dark" type="button">Annuler</button></a>
	</form>
</body>
<script>
Ecompetition.onchange = displaySport;
Efestival.onchange = displaySport; 
displaySport();
function displaySport(){
	if (document.getElementById("Ecompetition").checked){
		choixSport.style.display="block";
	}else {
		choixSport.style.display="none";
	}
	
}
</script>
</html>