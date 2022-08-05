<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fiche Produit</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>




<h1>Fiche du produit ${produit.id} - ${produit.libelle}</h1>
	
	
	
		<form action="produits" method="post">
		<input type="hidden" name="tache" value="modifier"> 
		<input type="hidden" name="id" value="${produit.id}">
		Libelle : <input type="text" name="libelle" placeholder="Libelle" value="${produit.libelle}"><br>
		Prix : <input type="number" step="0.01"  name="prix" placeholder="Prix" value="${produit.prix}"><br>
		Fournisseur : <select name="fournisseur">
			<option value="1" selected>Abid Jordan</option>
			<option value="3">Abid Jordan2</option>
		</select><br>
		<input type="submit" value="Modifier">
		<a href="produits"><input type="button" value="Annuler"></a>

	</form>
	
</body>
</html>
