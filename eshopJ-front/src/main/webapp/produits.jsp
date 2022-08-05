<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Produits</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>

	<!-- EL => Expression Language-->
<button id="btnAdd">Ajouter</button>



	<table border>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Prix</th>
			<th>Fournisseur</th>
			<th>Action</th>
		</tr>

		<tr>
			<td>${produits[0].id}</td>
			<td>${produits[0].libelle}</td>
			<td>${produits[0].prix}</td>
			<td>${produits[0].fournisseur.nom}
				${produits[0].fournisseur.prenom} -
				${produits[0].fournisseur.societe}</td>
			<td><a href="produits?id=${produits[0].id}"><button>Modifier</button></a>
				<form action="produits" method="post">
					<input type="hidden" name="tache" value="supprimer"> 
					<input type="hidden" name="id" value="${produits[0].id}"> 
					<input type="submit"value="Supprimer">
				</form>
			</td>
		</tr>

		<tr>
			<td>${produits[1].id}</td>
			<td>${produits[1].libelle}</td>
			<td>${produits[1].prix}</td>
			<td>${produits[1].fournisseur.nom}
				${produits[1].fournisseur.prenom} -
				${produits[1].fournisseur.societe}</td>
			<td><a href="produits?id=${produits[1].id}"><button>Modifier</button></a>
				<form action="produits" method="post">
					<input type="hidden" name="tache" value="supprimer"> 
					<input type="hidden" name="id" value="${produits[1].id}"> 
					<input type="submit"value="Supprimer">
				</form>
			</td>
		</tr>
		
		<tr>
			<td>${produits[2].id}</td>
			<td>${produits[2].libelle}</td>
			<td>${produits[2].prix}</td>
			<td>${produits[2].fournisseur.nom}
				${produits[2].fournisseur.prenom} -
				${produits[2].fournisseur.societe}</td>
			<td><a href="produits?id=${produits[2].id}"><button>Modifier</button></a>
				<form action="produits" method="post">
					<input type="hidden" name="tache" value="supprimer"> 
					<input type="hidden" name="id" value="${produits[2].id}"> 
					<input type="submit"value="Supprimer">
				</form>
			</td>
		</tr>
		
		<tr>
			<td>${produits[3].id}</td>
			<td>${produits[3].libelle}</td>
			<td>${produits[3].prix}</td>
			<td>${produits[3].fournisseur.nom}
				${produits[3].fournisseur.prenom} -
				${produits[3].fournisseur.societe}</td>
			<td><a href="produits?id=${produits[3].id}"><button>Modifier</button></a>
				<form action="produits" method="post">
					<input type="hidden" name="tache" value="supprimer"> 
					<input type="hidden" name="id" value="${produits[3].id}"> 
					<input type="submit"value="Supprimer">
				</form>
			</td>
		</tr>
		
		
	</table>
	
	<div id="formAjout">
		<form action="produits" method="post">
		<input type="hidden" name="tache" value="ajouter"> 
		Libelle : <input type="text" name="libelle" placeholder="Libelle"><br>
		Prix : <input type="number" step="0.01"  name="prix" placeholder="Prix"><br>
		Fournisseur : <select name="fournisseur">
			<option value="1">Abid Jordan</option>
			<option value="3">Abid Jordan2</option>
		</select><br>
		<input type="submit" value="Ajouter">
	</div>
	
	
	
	
	
	
	</form>
</body>
</html>


<script>

btnAdd.onclick=function()
{
	formAjout.style.display="block";	
}

</script>