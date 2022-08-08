package gEvent.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gEvent.context.Singleton;
import gEvent.model.Adresse;
import gEvent.model.Compte;
import gEvent.model.User;

@WebServlet("/users")
public class UserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TEST");
		
		if(request.getParameter("id")==null) 
		{
			List<User> comptes = Singleton.getInstance().getDaoCompte().findAllUsers();
		
			request.setAttribute("users",comptes);
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
		}
		else 
		{
		
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			User user= (User) Singleton.getInstance().getDaoCompte().findById(id);
			request.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(request, response);
		
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tache = request.getParameter("tache");
		
		if(tache.equals("ajouter")) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			LocalDate naissance = LocalDate.parse(request.getParameter("dateNaissance"));
			String tel = request.getParameter("tel");
			String numVoie = request.getParameter("numVoie");
			String nomVoie = request.getParameter("nomVoie");
			String cp = request.getParameter("cp");
			String ville = request.getParameter("ville");
			
			
			
			
			Adresse a = new Adresse(numVoie,nomVoie,ville,cp);
			Compte u = new User(login,password,nom,prenom,naissance,tel,a);


	
			Singleton.getInstance().getDaoCompte().save(u);
		}
		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			int version = Singleton.getInstance().getDaoCompte().findById(id).getVersion();
			
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			LocalDate naissance = LocalDate.parse(request.getParameter("dateNaissance"));
			String tel = request.getParameter("tel");
			String numVoie = request.getParameter("numVoie");
			String nomVoie = request.getParameter("nomVoie");
			String cp = request.getParameter("cp");
			String ville = request.getParameter("ville");
			
			Adresse a = new Adresse(numVoie,nomVoie,ville,cp);
			User u = new User(login,password,nom,prenom,naissance,tel,a);
			
			u.setId(id);
			u.setVersion(version);
			
			Singleton.getInstance().getDaoCompte().save(u);
		}
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Singleton.getInstance().getDaoCompte().delete(id);
		}
		
		response.sendRedirect("users");
	}

}
