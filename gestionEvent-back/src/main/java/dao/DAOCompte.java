package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Adresse;
import model.Compte;
import model.User;

public class DAOCompte implements IDAO<Compte,Integer>{

	@Override
	public Compte findById(Integer id) {
		User c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1,id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("User"))	
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c = new User(rs.getInt("id"),rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), LocalDate.parse(rs.getString("naissance")), rs.getString("telephone"), a);
				}
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte insert(Compte compte) {
		User u = (User) compte;
		try {
			// Connexion à la BDD
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			Adresse adresseUser = u.getAdresse();			

			// Insertion d'un nouvel utilisateur
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,naissance,telephone,numero,voie,ville,cp,type_compte) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNom());
			ps.setString(4, u.getPrenom());
			ps.setString(5, u.getNaissance().toString());
			ps.setString(6, u.getTelephone());
			ps.setString(7, adresseUser.getNumero());
			ps.setString(8, adresseUser.getVoie());
			ps.setString(9, adresseUser.getVille());
			ps.setString(10, adresseUser.getCp());
			ps.setString(11, "User");


			System.out.println("L'utilisateur " + u.getLogin() + " a bien été ajouté !");

			ps.executeUpdate();

			// Clôture des flux
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Compte update(Compte o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void insertSpectateur(Integer idUser,Integer idEvent) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn= DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps= conn.prepareStatement("INSERT INTO SPECTATEURS (id_user,id_evenement) VALUES(?,?)");
			ps.setInt(1,idUser);
			ps.setInt(2,idEvent);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findSpectateurs(Integer idEvent)
	{
		List<User> spectateurs = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT id_user from spectateurs where id_evenement=?");
			ps.setInt(1,idEvent);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				User u  = (User) findById(rs.getInt("id_user"));
				spectateurs.add(u);

			}


			rs.close();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spectateurs;
	}
	
	
	
	public void insertParticipant(Integer idUser,Integer idCompet) 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Participants(id_user,id_competition) VALUES(?,?)");

			ps.setInt(1, idUser);
			ps.setInt(2, idCompet);


			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	public List<User> findParticipants(Integer idEvent) {
		List<User> allParticipants = new ArrayList();
		try{
			// Connexion à la BDD
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM evenement JOIN participants ON evenement.id = participants.id_competition JOIN compte ON compte.id = participants.id_user WHERE evenement.id = ?");
			ps.setInt(1,idEvent);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{
				Adresse adresseUser = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				User e = new User(
						rs.getInt("id_user"),
						rs.getString("login"),
						rs.getString("password"),
						rs.getString("nom"), 
						rs.getString("prenom"),
						LocalDate.parse(rs.getString("naissance")),
						rs.getString("telephone"),
						adresseUser);

				allParticipants.add(e);
			}


			// Clôture des flux
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allParticipants;
	}
	
	
	public Compte seConnecter(String login,String password) 
	{
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2, password);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("User"))	
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c = new User(rs.getInt("id"),login, password, rs.getString("nom"), rs.getString("prenom"), LocalDate.parse(rs.getString("naissance")), rs.getString("telephone"), a);
				}
				else 
				{
					c = new Admin(rs.getInt("id"),login, password);
				}
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
