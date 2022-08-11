package eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@WebServlet("/produits")
public class ProduitController extends HttpServlet {

	@Autowired
	IDAOPersonne daoPersonne;
	
	@Autowired
	IDAOProduit daoProduit;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();
		request.setAttribute("fournisseurs",fournisseurs);

		//S'il n'y a pas d'id en parametre, on veut un faire un findAll pour afficher notre tableau
		if(request.getParameter("id")==null) 
		{
			List<Produit> produits = daoProduit.findAll();


			request.setAttribute("produits",produits);


			this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Produit p = daoProduit.findById(id).get();
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
			Fournisseur f = (Fournisseur) daoPersonne.findById(idFournisseur).get();
			Produit p = new Produit(libelle,prix,f);
			daoProduit.save(p);
		}

		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Integer idFournisseur = Integer.parseInt(request.getParameter("fournisseur"));
			Fournisseur f = (Fournisseur)daoPersonne.findById(idFournisseur).get();
			Produit p = new Produit(libelle,prix,f);
			p.setId(id);
			daoProduit.save(p);
		}
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			daoProduit.deleteById(id);
		}

		//SendRedirect annule mode POST, et repartir vers l'url /produit en tant que requete Get
		response.sendRedirect("produits");
	}

}
