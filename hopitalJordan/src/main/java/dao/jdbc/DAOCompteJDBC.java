package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.IDAOCompte;
import model.Compte;
import model.Medecin;
import model.Secretaire;

public class DAOCompteJDBC implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		return null;
	}

	@Override
	public List<Compte> findAll() {
		return null;
	}

	@Override
	public void insert(Compte o) {
	}

	@Override
	public void update(Compte o) {
	}

	@Override
	public void delete(Compte o) {
	}
	
	public Compte connect(String login,String password) 
	{
		Compte connected = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = connect.prepareStatement("SELECT * from compte where login=? and password=? ");
			ps.setString(1, login);
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery();
		
			
			while(rs.next()) 
			{
					if(rs.getString("type_compte").equals("Medecin")) 
					{
						connected=new Medecin(rs.getInt("id"),login);
					}
					else if(rs.getString("type_compte").equals("Secretaire"))
					{
						connected=new Secretaire(login);
					} 
			}
			
			rs.close();
			ps.close();
			connect.close();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return connected;
	}

}
