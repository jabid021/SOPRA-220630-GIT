package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;

public class Test {
	
	static IDAOCompte daoC = Singleton.getInstance().getDaoC();
	static IDAOPatient daoP=Singleton.getInstance().getDaoP();
	static IDAOVisite daoV=Singleton.getInstance().getDaoV();
	static Compte connected;
	static boolean enPause = false;
	
	
	
	public static String saisieString(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}



	public static void menuPrincipal() {
		System.out.println("Appli Hopital");
		System.out.println("Choisir un menu");
		System.out.println("1- Se connecter");
		System.out.println("2- Fermer");

		int choix = saisieInt("");

		switch(choix)
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);
		}
		menuPrincipal();
	}

	public static void seConnecter() {
		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		connected=daoC.connect(login,password);

		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Choisir une salle (1/2)");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			menuSecretaire();
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}

		menuPrincipal();
	}

	public static void menuSecretaire() {
		System.out.println("Menu Secretaire "+connected.getLogin());
		System.out.println("Choisir un menu");
		if(enPause==false) 
		{
			System.out.println("1- Recevoir un patient");
			System.out.println("2- Afficher les visites d'un patient");
			System.out.println("3- Afficher l'etat de la file d'attente");
			System.out.println("4- Partir en pause");
			System.out.println("5 - Se deconnecter");

			int choix = saisieInt("");

			switch(choix)
			{
			case 1 : addPatient();break;
			case 2 : showVisites();break;
			case 3 : showFile();break;
			case 4 : pause();break;
			case 5 : connected=null;menuPrincipal();break;
			}
		}
		else 
		{
			System.out.println("1- Revenir de pause");
			System.out.println("2 - Se deconnecter");
			int choix = saisieInt("");

			switch(choix)
			{
			case 1 : retourPause();break;
			case 2 : connected=null;menuPrincipal();break;
			}
		}
		menuSecretaire();
	}




	public static void retourPause() {
		
		File f = new File("fileAttente.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois = new ObjectInputStream(fis))
		{
			Singleton.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
			enPause=false;
		}
		catch(Exception e) {System.err.println("Erreur pendant la déserialisation du fichier file d'attente");}
	}

	public static void pause() {
		File f = new File("fileAttente.txt");
		try(FileOutputStream fos = new FileOutputStream(f);ObjectOutputStream oos = new ObjectOutputStream(fos))
		{
			oos.writeObject(Singleton.getInstance().getFileAttente());
			enPause=true;
			Singleton.getInstance().getFileAttente().clear();
		}
		catch(Exception e) {System.err.println("Erreur pendant la serialisation du fichier file d'attente");}
	}

	public static void showFile() {

		if(Singleton.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}

		for(Patient p : Singleton.getInstance().getFileAttente()) 
		{
			System.out.println(p);
		}
	}

	public static void showVisites() {
		int idPatient= saisieInt("Saisir l'id du patient");
		List<Visite> visites = daoV.findAllByIdPatient(idPatient);

		if(visites.isEmpty()) 
		{
			System.out.println("Ce patient n'a pas de visite");
		}

		for(Visite v : visites) 
		{
			System.out.println(v);
		}

	}

	public static void addPatient() {

		int idPatient= saisieInt("Saisir l'id du patient");
		Patient p = daoP.findById(idPatient);
		if(p==null) 
		{
			System.out.println("Inscription d'un nouveau patient !");
			String nom=saisieString("Saisir le nom du patient");
			String prenom=saisieString("Saisir le prenom du patient");
			p=new Patient(idPatient,nom,prenom);
			daoP.insert(p);
		}
		Singleton.getInstance().getFileAttente().add(p);
		System.out.println("Patient "+idPatient+" ajouté à la file");

	}

	public static void menuMedecin() {

		System.out.println("Menu Medecin "+connected.getLogin());
		System.out.println("Choisir un menu");

		System.out.println("1- Recevoir un patient");
		System.out.println("2- Afficher l'etat de la file d'attente");
		System.out.println("3- Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("");

		switch(choix)
		{
		case 1 : nextPatient();break;
		case 2 : showFile();break;
		case 3 : saveVisites();break;
		case 4 : saveVisites(); connected=null;menuPrincipal();break;
		}

		menuMedecin();
	}

	public static void saveVisites() {
		Medecin m = (Medecin)connected;
		if(m.getVisites().isEmpty()) 
		{
			System.out.println("Pas de visite à  sauvegarder");
		}
		
		for(Visite v : m.getVisites()) 
		{
			daoV.insert(v);
		}
		m.getVisites().clear();
	}

	public static void nextPatient() {

		if(Singleton.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Medecin m = (Medecin)connected;

			Patient p = Singleton.getInstance().getFileAttente().poll();
			System.out.println(p);
			Visite v = new Visite(m, p);
			m.getVisites().add(v);

			if(m.getVisites().size()>=10)
			{
				saveVisites();
			}
		}

	}

	public static void main(String[] args) {
<<<<<<< HEAD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
=======
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
		
>>>>>>> groupe2
		emf.close();
		
		menuPrincipal();

	}

}
