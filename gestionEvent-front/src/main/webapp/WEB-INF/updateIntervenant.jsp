
<!DOCTYPE html>
<html>
<head>

<title>Fiche Intervenant</title>
</head>
<body>

<h1>Modifier Intervenant</h1>


<form action="intervenants" method="post">
  <input type="hidden" name="tache" value="modifier">
  <input type="hidden" name="id" value="${intervenant.id}">
  Nom : <input required name="nom" type="text" placeholder="nom intervenant" value="${intervenant.nom}" ><br>
 Talents : 
		<c:forEach items="${talents}" var="talent">
		<input <c:if test="${intervenant.talents.contains(talent)}">checked</c:if> name="${talent}" type="checkbox">${talent} 

		</c:forEach><br> 
 <input type="submit" class="btn btnViolet" value="Modifier">
  <a href="intervenants"><button class="btn btn-dark" type="button">Annuler</button></a>
</form>



</body>
</html>