
<!DOCTYPE html>
<html>
<head>

<title>Fiche Prestation</title>
</head>
<body>
	<h1>Modifier Prestation</h1>

	<form action="prestations" method="post">
		<input type="hidden" name="tache" value="modifier"> <input
			type="hidden" name="id" value="${prestation.id}"> 
			Date de début : <input required name="date_debut" type="date"
			placeholder="date de début" value="${prestation.dateDebut}"><br>
		Heure de début : <input required name="heure_debut" type="time"
			placeholder="heure de début" value="${prestation.heureDebut}"><br>
		Date de fin : <input required name="date_fin" type="date"
			placeholder="date de fin" value="${prestation.dateFin}"><br>
		Heure de fin : <input required name="heure_fin" type="time"
			placeholder="heure de fin" value="${prestation.heureFin}"><br>


	Intervenant : <select name="intervenant">
				<c:forEach items="${intervenants}" var="intervenant">
					<option <c:if test="${prestation.intervenant.id==intervenant.id}">selected</c:if> value="${intervenant.id}">${intervenant.nom}</option>
				</c:forEach>

			</select> <br> Festival : <select name="festival">
				<c:forEach items="${festivals}" var="festival">
					<option <c:if test="${prestation.festival.id==festival.id}">selected</c:if>  value="${festival.id}">${festival.libelle}</option>
				</c:forEach>
			</select>
		 <input type="submit" class="btn btnViolet" value="Modifier">
		
	</form>
<a href="prestations"><button class="btn btn-dark" type="button">Annuler</button></a>

</body>
</html>
