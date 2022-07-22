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

import model.Intervenant;
import model.Prestation;

public class DAOPrestation implements IDAO<Prestation,Integer> {

	@Override
	public Prestation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestation insert(Prestation p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("INSERT INTO prestation (date_debut, heure_debut, date_fin, heure_fin,id_intervenant, id_festival) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);



			ps.setString(1, p.getDateDebut().toString());
			ps.setString(2, p.getHeureDebut().toString());
			ps.setString(3, p.getDateFin().toString());
			ps.setString(4, p.getHeureFin().toString());
			ps.setInt(5, p.getIntervenant().getId());
			ps.setInt(6, p.getFestival().getId());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				p.setId(rs.getInt(1));
			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Prestation update(Prestation o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public static List<Prestation> findPrestationsByIdEvent(Integer idEvent) {
		DAOIntervenant daoI = new DAOIntervenant();
		
		List<Prestation> prestations= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT * from prestation where id_festival=?");
			ps.setInt(1,idEvent);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Intervenant i = daoI.findById(rs.getInt("id_intervenant"));

				Prestation p  = new Prestation (rs.getInt("id"),LocalDate.parse(rs.getString("date_debut")), LocalTime.parse(rs.getString("heure_debut")), LocalDate.parse(rs.getString("date_fin")), LocalTime.parse(rs.getString("heure_fin")),i,null);
				prestations.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestations;

	}

}
