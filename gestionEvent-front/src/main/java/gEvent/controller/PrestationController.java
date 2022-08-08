package gEvent.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gEvent.context.Singleton;
import gEvent.model.Evenement;
import gEvent.model.Festival;
import gEvent.model.Intervenant;
import gEvent.model.Prestation;

@WebServlet("/prestations")
public class PrestationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Intervenant> intervenants = Singleton.getInstance().getDaoIntervenant().findAll();
		request.setAttribute("intervenants",intervenants);
		List<Festival> festivals = Singleton.getInstance().getDaoEvenement().findAllFestival();
		request.setAttribute("festivals", festivals);
		
		if(request.getParameter("id")==null) 
		{
			
			List<Prestation> prestations= Singleton.getInstance().getDaoPrestation().findAll();
			request.setAttribute("prestations", prestations);
			
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/prestations.jsp").forward(request, response);
			
		
		}
		
		
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Prestation p = Singleton.getInstance().getDaoPrestation().findById(id);
			request.setAttribute("prestation", p);
			this.getServletContext().getRequestDispatcher("/WEB-INF/updatePrestation.jsp").forward(request, response);

			
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tache = request.getParameter("tache");
		
		
		if(tache.equals("ajouter")) 
		{
			LocalDate dateDebut = LocalDate.parse(request.getParameter("date_debut"));
			LocalDate dateFin= LocalDate.parse(request.getParameter("date_fin"));
			LocalTime heureDebut = LocalTime.parse(request.getParameter("heure_debut"));
			LocalTime heureFin = LocalTime.parse(request.getParameter("heure_fin"));
	
			Integer idIntervenant = Integer.parseInt(request.getParameter("intervenant"));
			Intervenant i = Singleton.getInstance().getDaoIntervenant().findById(idIntervenant);
			Integer idFestival = Integer.parseInt(request.getParameter("festival"));
			Festival f = (Festival) Singleton.getInstance().getDaoEvenement().findById(idFestival);

			Prestation p = new Prestation(dateDebut, heureDebut,dateFin,heureFin,i,f);
			Singleton.getInstance().getDaoPrestation().save(p);
		}
		
		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			//J
			int version = Singleton.getInstance().getDaoPrestation().findById(id).getVersion();
			
			
			LocalDate dateDebut = LocalDate.parse(request.getParameter("date_debut"));
			LocalDate dateFin= LocalDate.parse(request.getParameter("date_fin"));
			LocalTime heureDebut = LocalTime.parse(request.getParameter("heure_debut"));
			LocalTime heureFin = LocalTime.parse(request.getParameter("heure_fin"));
	
			Integer idIntervenant = Integer.parseInt(request.getParameter("intervenant"));
			Intervenant i = Singleton.getInstance().getDaoIntervenant().findById(idIntervenant);
			Integer idFestival = Integer.parseInt(request.getParameter("festival"));
			Festival f = (Festival) Singleton.getInstance().getDaoEvenement().findById(idFestival);

			Prestation p = new Prestation(dateDebut, heureDebut,dateFin,heureFin,i,f);
			
			
			p.setId(id);
			p.setVersion(version);
			
			Singleton.getInstance().getDaoPrestation().save(p);
			
		}
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Singleton.getInstance().getDaoPrestation().delete(id);
		}
		
		response.sendRedirect("prestations");
	}

}
