package eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.context.Singleton;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@WebServlet("/produits")
public class ProduitController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//S'il n'y a pas d'id en parametre, on veut un faire un findAll pour afficher notre tableau
		if(request.getParameter("id")==null) 
		{
			List<Produit> produits = Singleton.getInstance().getDaoProduit().findAll();
			
			
			request.setAttribute("produits",produits);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Produit p = Singleton.getInstance().getDaoProduit().findById(id);
			request.setAttribute("produit", p);
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateProduit.jsp").forward(request, response);

			
		}
		
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tache = request.getParameter("tache");
		
		
		if(tache.equals("ajouter")) 
		{
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Integer idFournisseur = Integer.parseInt(request.getParameter("fournisseur"));
			Fournisseur f = (Fournisseur)Singleton.getInstance().getDaoPersonne().findById(idFournisseur);
			Produit p = new Produit(libelle,prix,f);
			Singleton.getInstance().getDaoProduit().save(p);
		}
		
		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Integer idFournisseur = Integer.parseInt(request.getParameter("fournisseur"));
			Fournisseur f = (Fournisseur)Singleton.getInstance().getDaoPersonne().findById(idFournisseur);
			Produit p = new Produit(libelle,prix,f);
			p.setId(id);
			Singleton.getInstance().getDaoProduit().save(p);
		}
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Singleton.getInstance().getDaoProduit().delete(id);
		}
		
		//SendRedirect annule mode POST, et repartir vers l'url /produit en tant que requete Get
		response.sendRedirect("produits");
	}

}
