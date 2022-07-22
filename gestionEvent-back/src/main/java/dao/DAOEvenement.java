package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Adresse;
import model.Competition;
import model.Evenement;
import model.Festival;
import model.Sport;
import model.User;

public class DAOEvenement implements IDAO<Evenement,Integer> {

	@Override
	public Evenement findById(Integer id) {
		
		DAOCompte daoC = new DAOCompte();
		
		Evenement event = null;

		try {
			// Connexion à la BDD
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 

			// Récupération de tous les festivals
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM evenement JOIN festival ON evenement.id = festival.id where evenement.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{			
				Adresse adresseFestival = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				event = new Festival(rs.getInt("id"),
						rs.getString("libelle"),
						LocalDate.parse(rs.getString("date_debut")),
						LocalTime.parse(rs.getString("heure_debut")),
						LocalDate.parse(rs.getString("date_fin")),
						LocalTime.parse(rs.getString("heure_fin")),
						rs.getDouble("prix"),
						adresseFestival);
			}		

			ps = conn.prepareStatement("SELECT * FROM evenement JOIN competition ON evenement.id = competition.id where evenement.id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();


			while(rs.next()) 
			{
				User gagnant = (User) daoC.findById(rs.getInt("gagnant"));
				Adresse adresseCompetition = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				Sport sport = Sport.valueOf(rs.getString("sport"));
				event = new Competition(rs.getInt("id"),
						rs.getString("libelle"),
						LocalDate.parse(rs.getString("date_debut")),
						LocalTime.parse(rs.getString("heure_debut")),
						LocalDate.parse(rs.getString("date_fin")),
						LocalTime.parse(rs.getString("heure_fin")),
						rs.getDouble("prix"),
						sport,
						adresseCompetition);

				((Competition) event).setGagnant(gagnant);

			}			


			rs.close();
			ps.close();
			conn.close();



		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	@Override
	public List<Evenement> findAll() {
		List<Evenement> listEvenements= new ArrayList();

		try {
			// Connexion à la BDD
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 

			// Récupération de tous les festivals
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM evenement JOIN festival ON evenement.id = festival.id");
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{			
				Adresse adresseFestival = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				Festival f = new Festival(	rs.getInt("id"),
						rs.getString("libelle"),
						LocalDate.parse(rs.getString("date_debut")),
						LocalTime.parse(rs.getString("heure_debut")),
						LocalDate.parse(rs.getString("date_fin")),
						LocalTime.parse(rs.getString("heure_fin")),
						rs.getDouble("prix"),
						adresseFestival);

				listEvenements.add(f);							
			}			

			rs.close();
			ps.close();
			conn.close();

			// Récupération de toutes les competions

			List<Competition> listeCompetitions =  findAllCompetition();
			listEvenements.addAll(listeCompetitions);


		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEvenements;
	}

	@Override
	public Evenement insert(Evenement event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn= DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO EVENEMENT (libelle, date_debut, heure_debut, date_fin, heure_fin, prix, numero, voie, ville, cp) VALUES(?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);


			ps.setString(1, event.getLibelle());
			ps.setString(2, event.getDateDebut().toString());
			ps.setString(3, event.getHeureDebut().toString());
			ps.setString(4, event.getDateDebut().toString());
			ps.setString(5, event.getHeureDebut().toString());
			ps.setDouble(6, event.getPrix());
			ps.setString(7, event.getAdresse().getNumero());
			ps.setString(8, event.getAdresse().getVoie());
			ps.setString(9, event.getAdresse().getVille());
			ps.setString(10, event.getAdresse().getCp(

					));

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				event.setId(rs.getInt(1));
			}

			if(event instanceof Festival) {
				ps = conn.prepareStatement("INSERT INTO festival VALUES(?)");
				ps.setInt(1 ,event.getId());
			}
			else {
				ps = conn.prepareStatement("INSERT INTO competition VALUES(?,?,null)");
				ps.setInt(1 ,event.getId());
				ps.setString(2,((Competition) event).getSport().toString());
			}
			ps.executeUpdate();
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Evenement update(Evenement o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}


	public void updateGagant(Integer idUser, Integer idEvent) {


		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("UPDATE competition set gagnant=? where id=?");

			ps.setInt(1, idUser);
			ps.setInt(2, idEvent);



			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}




	public List<Competition> findAllCompetition() 

	{

		DAOCompte daoC = new DAOCompte();

		List<Competition> listCompetitons= new ArrayList();

		try {
			// Connexion à la BDD
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM evenement JOIN competition ON evenement.id = competition.id");
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{
				User gagnant = (User) daoC.findById(rs.getInt("gagnant"));

				Adresse adresseCompetition = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				Sport sport = Sport.valueOf(rs.getString("sport"));
				Competition c = new Competition(rs.getInt("id"),
						rs.getString("libelle"),
						LocalDate.parse(rs.getString("date_debut")),
						LocalTime.parse(rs.getString("heure_debut")),
						LocalDate.parse(rs.getString("date_fin")),
						LocalTime.parse(rs.getString("heure_fin")),
						rs.getDouble("prix"),
						sport,
						adresseCompetition);
				c.setGagnant(gagnant);
				listCompetitons.add(c);							
			}			

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listCompetitons;
	}


}
