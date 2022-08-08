package gEvent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gEvent.context.Singleton;
import gEvent.model.Intervenant;
import gEvent.model.Talent;

@WebServlet("/users")
public class UserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("talents", Talent.values());
		
		if(request.getParameter("id")==null) 
		{
			List<Intervenant> intervenants = Singleton.getInstance().getDaoIntervenant().findAll();
		
			request.setAttribute("intervenants",intervenants);
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/intervenants.jsp").forward(request, response);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Intervenant i = Singleton.getInstance().getDaoIntervenant().findById(id);
			request.setAttribute("intervenant", i);
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateIntervenant.jsp").forward(request, response);

			
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tache = request.getParameter("tache");
		
		
		if(tache.equals("ajouter")) 
		{
			String nom = request.getParameter("nom");
			Intervenant i = new Intervenant(nom);

			for(Talent t : Talent.values()) 
			{
				if(request.getParameter(t.toString())!=null) 
				{
				 i.getTalents().add(t);	
				}
			}
			Singleton.getInstance().getDaoIntervenant().save(i);
		}
		
		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			//J
			int version = Singleton.getInstance().getDaoIntervenant().findById(id).getVersion();
			
			
			String nom = request.getParameter("nom");
			Intervenant i = new Intervenant(nom);
			i.setId(id);
			i.setVersion(version);
			for(Talent t : Talent.values()) 
			{
				if(request.getParameter(t.toString())!=null) 
				{
				 i.getTalents().add(t);	
				}
			}
			Singleton.getInstance().getDaoIntervenant().save(i);
		}
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Singleton.getInstance().getDaoIntervenant().delete(id);
		}
		
		response.sendRedirect("intervenants");
	}

}
