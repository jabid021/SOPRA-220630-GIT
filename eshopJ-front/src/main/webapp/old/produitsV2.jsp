<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="eshop.model.Produit" %>
	<%@ page import="eshop.context.Singleton" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


	<% out.println("<h1>LISTE des PRODUITS</h1>"); %>
	<%= "<h1>Titre 2</h1>" %>

	<table border>
		<tr>
			<th>ID</th>
			<th>Libelle</th>
			<th>Prix</th>
			<th>Fournisseur</th>
		</tr>
		
		
		<%
		//MVC => Model (DAO+Model) - Vue (Affichage) - Controller() : 
		List<Produit> produits = Singleton.getInstance().getDaoProduit().findAll();
		
		for(Produit p : produits)
		{
			out.println("<tr>");
			out.println("<th>"+p.getId()+"</th>");
			out.println("<th>"+p.getLibelle()+"</th>");
			out.println("<th>"+p.getPrix()+"</th>");
			out.println("<th>"+p.getFournisseur().getPrenom()+"</th>");
			out.println("</tr>");
		}
		
		
		%>
		
		
		
		
		
	</table>
</body>
</html>