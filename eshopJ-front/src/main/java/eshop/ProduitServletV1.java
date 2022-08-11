package eshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.context.Singleton;
import eshop.model.Produit;

@WebServlet("/produitsV1")
public class ProduitServletV1 extends HttpServlet {
	
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Produit> produits = Singleton.getInstance().getDaoProduit().findAll();

		
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Liste des produits</h1>");
		response.getWriter().println("<table border>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<th>ID</th>");
		response.getWriter().println("<th>Libelle</th>");
		response.getWriter().println("<th>Prix</th>");
		response.getWriter().println("<th>Fournisseur</th>");
		response.getWriter().println("</tr>");
		
		
		
		for(Produit p : produits) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<th>"+p.getId()+"</th>");
			response.getWriter().println("<th>"+p.getLibelle()+"</th>");
			response.getWriter().println("<th>"+p.getPrix()+"</th>");
			response.getWriter().println("<th>"+p.getFournisseur().getPrenom()+"</th>");
			response.getWriter().println("</tr>");
		}
		
	
		
		response.getWriter().println("</table>");
		
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
