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
import gEvent.model.Adresse;
import gEvent.model.Competition;
import gEvent.model.Compte;
import gEvent.model.Evenement;
import gEvent.model.Festival;
import gEvent.model.Intervenant;
import gEvent.model.Sport;
import gEvent.model.Talent;
import gEvent.model.User;

@WebServlet("/evenements")
public class EvenementController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setAttribute("talents", Talent.values());
		
		if(request.getParameter("id")==null) 
		{
			List<Evenement> evenements = Singleton.getInstance().getDaoEvenement().findAll();
		
			request.setAttribute("evenements",evenements);
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/evenements.jsp").forward(request, response);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Evenement e = Singleton.getInstance().getDaoEvenement().findById(id);
			request.setAttribute("evenement", e);
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateEvenement.jsp").forward(request, response);

			
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tache = request.getParameter("tache");
		
		
		if(tache.equals("ajouter")) 
		{
			String libelle = request.getParameter("libelle");
			LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
			LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
			LocalTime heureDebut = LocalTime.parse(request.getParameter("heureDebut"));
			LocalTime heureFin = LocalTime.parse(request.getParameter("heureFin"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			String numero = request.getParameter("numero");
			String voie = request.getParameter("voie");
			String ville = request.getParameter("ville");
			String cp = request.getParameter("cp");
			String type = request.getParameter("typeEvenement");
			
			Adresse adresse = new Adresse(numero, voie, ville, cp);
			
			Evenement e;
			if(type.equals("festival")) {
				e = new Festival(libelle, dateDebut, heureDebut, dateFin, heureFin, prix, adresse);
			} else {
				Sport sport = Sport.valueOf(request.getParameter("sport"));
				e = new Competition(libelle, dateDebut, heureDebut, dateFin, heureFin, prix, sport, adresse);
			}
			
			Singleton.getInstance().getDaoEvenement().save(e);
		}
		
		
		else if(tache.equals("modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			//J
			int version = Singleton.getInstance().getDaoEvenement().findById(id).getVersion();
			
			
			String libelle = request.getParameter("libelle");
			LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
			LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
			LocalTime heureDebut = LocalTime.parse(request.getParameter("heureDebut"));
			LocalTime heureFin = LocalTime.parse(request.getParameter("heureFin"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			String numero = request.getParameter("numero");
			String voie = request.getParameter("voie");
			String ville = request.getParameter("ville");
			String cp = request.getParameter("cp");
			String type = request.getParameter("typeEvenement");
			Integer gagnant_id = Integer.parseInt(request.getParameter("gagnant"));
			
			User compte_gagnant = (User) Singleton.getInstance().getDaoCompte().findById(gagnant_id);
			
			Adresse adresse = new Adresse(numero, voie, ville, cp);
			
			Evenement e;
			if(type.equals("festival")) {
				e = new Festival(libelle, dateDebut, heureDebut, dateFin, heureFin, prix, adresse);
			} else {
				Sport sport = Sport.valueOf(request.getParameter("sport"));
				e = new Competition(libelle, dateDebut, heureDebut, dateFin, heureFin, prix, sport, adresse);
				((Competition)e).setGagnant(compte_gagnant);
			}
			
			e.setId(id);
			e.setVersion(version);
			Singleton.getInstance().getDaoEvenement().save(e);
		}
		
		
		else if(tache.equals("supprimer")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			Singleton.getInstance().getDaoEvenement().delete(id);
		}
		
		response.sendRedirect("evenements");
	}

}
