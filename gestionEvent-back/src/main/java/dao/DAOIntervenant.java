package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Intervenant;
import model.Talent;

public class DAOIntervenant implements IDAO<Intervenant,Integer> {

	@Override
	public Intervenant findById(Integer id) {
		Intervenant i = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT * from intervenant join talents on intervenant.id=id_intervenant WHERE intervenant.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if (i == null) {
					i = new Intervenant(rs.getInt("id"),rs.getString("nom"));
				}
				i.getTalents().add(Talent.valueOf(rs.getString("talent")));

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	@Override
	public List<Intervenant> findAll() {
		List<Intervenant> intervenants= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 
			PreparedStatement ps = conn.prepareStatement("SELECT * from intervenant join talents on intervenant.id=id_intervenant");
			ResultSet rs = ps.executeQuery();
			Intervenant i = null;
			while(rs.next()) 
			{
				if ( i == null || i.getId() != rs.getInt("id")) {
					i = new Intervenant(rs.getString("nom"));
					i.setId(rs.getInt("id"));
					intervenants.add(i);
				}
				i.getTalents().add(Talent.valueOf(rs.getString("talent")));

			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return intervenants;
	}

	@Override
	public Intervenant insert(Intervenant i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 

			PreparedStatement ps = conn.prepareStatement("INSERT INTO intervenant (nom) VALUES(?)");
			ps.setString(1, i.getNom());

			ps.executeUpdate();

			//on récupère l'id inséré en base
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				i.setId(rs.getInt(1));
			}

			//on ajoute tous ses talents en base
			for (Talent t : i.getTalents()) {
				insertTalent(i, t);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Intervenant update(Intervenant o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public  void insertTalent(Intervenant i, Talent t) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 

			PreparedStatement ps = conn.prepareStatement("INSERT INTO talents (id_intervenant, talent) VALUES(?,?)");

			ps.setInt(1,i.getId());
			ps.setString(2, t.toString());

			ps.executeUpdate();

			ps.close();
			conn.close();




		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	
}
