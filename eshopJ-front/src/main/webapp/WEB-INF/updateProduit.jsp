
<!DOCTYPE html>
<html>
<head>
<title>Fiche Produit</title>

</head>
<body>




	<h1>Fiche du produit ${produit.id} - ${produit.libelle}</h1>



	<form action="produits" method="post">
		<input type="hidden" name="tache" value="modifier"> <input
			type="hidden" name="id" value="${produit.id}"> Libelle : <input
			type="text" name="libelle" placeholder="Libelle"
			value="${produit.libelle}"><br> Prix : <input
			type="number" step="0.01" name="prix" placeholder="Prix"
			value="${produit.prix}"><br> Fournisseur : <select
			name="fournisseur">
			<c:forEach items="${fournisseurs}" var="f">

				<c:choose>
					<c:when test="${produit.fournisseur.id == f.id}">
						<option selected value="${f.id}">${f.nom} ${f.prenom}</option>
					</c:when>
					
					<c:otherwise>
						<option value="${f.id}">${f.nom} ${f.prenom}</option>
					</c:otherwise>

				</c:choose>

			</c:forEach>
			
		</select><br> <input type="submit" value="Modifier"> <a
			href="produits"><input type="button" value="Annuler"></a>

	</form>

</body>
</html>
