<!--<%@ include file="/libs.jsp"  %>-->
<!DOCTYPE html>
<html>
<head>

<title>Page Produits</title>

</head>
<body>

	<!-- EL => Expression Language-->
	<button id="btnAdd" class="btn btn-success">Ajouter</button>



	<div id="content">


		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Libelle</th>
				<th>Prix</th>
				<th>Fournisseur</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.libelle}</td>
					<td>${p.prix}</td>
					<td>${p.fournisseur.nom}${p.fournisseur.prenom}-
						${p.fournisseur.societe}</td>
					<td><a href="produits?id=${p.id}"><button
								class="btn btn-warning">Modifier</button></a>
						<form action="produits" method="post">
							<input type="hidden" name="tache" value="supprimer"> <input
								type="hidden" name="id" value="${p.id}"> <input
								type="submit" class="btn btn-danger" value="Supprimer">
						</form></td>
				</tr>
			</c:forEach>



		</table>

		<div id="formAjout">
			<form action="produits" method="post">
				<input type="hidden" name="tache" value="ajouter"> Libelle :
				<input type="text" name="libelle" placeholder="Libelle"><br>
				Prix : <input type="number" step="0.01" name="prix"
					placeholder="Prix"><br> Fournisseur : <select
					name="fournisseur">
					<c:forEach items="${fournisseurs}" var="f">
						<option value="${f.id}">${f.nom} ${f.prenom}</option>
					</c:forEach>
				</select><br> <input type="submit" class="btn btn-primary"
					value="Ajouter">

			</form>

		</div>

	</div>

</body>
</html>


<script>
	btnAdd.onclick = function() {
		formAjout.style.display = "block";
	}
</script>