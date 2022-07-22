package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOEvenement;
import dao.DAOIntervenant;
import dao.DAOPrestation;
import model.Admin;
import model.Adresse;
import model.Competition;
import model.Compte;
import model.Evenement;
import model.Festival;
import model.Intervenant;
import model.Prestation;
import model.Sport;
import model.Talent;
import model.User;

public class App {

	static Compte connected;
	static DAOCompte daoC = new DAOCompte();
	static DAOEvenement daoE = new DAOEvenement();
	static DAOIntervenant daoI = new DAOIntervenant();
	static DAOPrestation daoP = new DAOPrestation();


	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int val =sc.nextInt();
		return val;
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextBoolean();
	}




	public static void menuPrincipal() 
	{
		System.out.println("\nMenu principal");
		System.out.println("1- Se connecter");
		System.out.println("2- Inscription");
		System.out.println("3- Stop");

		int choix = saisieInt("Choisir un menu");


		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);
		}
		menuPrincipal();
	}





	public static void inscription() {
		System.out.println("inscription :");
		String login = saisieString("Saisir votre login :");
		String password = saisieString("Saisir votre password :");
		String nom = saisieString("Saisir votre nom : ");
		String prenom = saisieString("Saisir votre prenom : ");
		String naissance = saisieString("Saisir votre date de naissance : ");
		String tel = saisieString("Saisir votre numéro de téléphone : ");
		String numero = saisieString("Saisir votre numero de voie :");
		String voie = saisieString("Saisir votre nom de voie :");
		String ville = saisieString("Saisir votre ville :");
		String cp = saisieString("Saisir votre code postal :");

		Adresse a = new Adresse(numero, voie, ville, cp);

		User u = new User(login,password,nom,prenom,LocalDate.parse(naissance),tel,a);
		daoC.insert(u);
		System.out.println("Nous vous avons bien inscrit ! ");

	}

	public static void connexion() 
	{
		System.out.println("connexion :");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected = daoC.seConnecter(login, password);

		if(connected instanceof Admin) {menuAdmin();}
		else if(connected instanceof User) {menuUser();}
		else {System.out.println("Identifiants invalides");}
	}



	public static void menuUser() {
		System.out.println("\nMenu User");
		System.out.println("1 - Afficher les events");
		System.out.println("2 - Suivre un evenement");
		System.out.println("3 - Participer � une competition");
		System.out.println("4 - Se deconnecter");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherEvents(); break;
		case 2 : suivreEvenement(); break;
		case 3 : participerCompetition(); break;
		case 4 : menuPrincipal(); break;
		}
		menuUser();
	}

	public static void participerCompetition() {
		afficherCompetitions();
		int idEvent = saisieInt("Saisir l'id de la competition");
		daoC.insertParticipant(connected.getId(), idEvent);

	}



	public static void suivreEvenement() {
		afficherEvents();
		int idEvent = saisieInt("Saisir l'id de l'event");
		daoC.insertSpectateur(connected.getId(), idEvent);
	}



	public static void menuAdmin() {
		System.out.println("\nMenu Admin");
		System.out.println("1 - Creer un event");
		System.out.println("2 - Afficher les events");
		System.out.println("3 - Gestion d'un event");
		System.out.println("4 - Se deconnecter");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : creerEvent(); break;
		case 2 : afficherEvents(); break;
		case 3 : menuGestionEvent(saisieInt("Saisir l'id de l'event"));break;
		case 4 : menuPrincipal(); break;
		}
		menuAdmin();

	}

	public static void menuGestionEvent(Integer idEvent) {
		System.out.println("\nGestion de l'event "+idEvent);

		System.out.println("1 - Afficher les spectateurs d'un event");
		System.out.println("2 - Afficher les participants d'une competition");
		System.out.println("3 - Designer le gagnant d'une competition");
		System.out.println("4 - Afficher les prestations");
		System.out.println("5 - Ajouter une prestation");
		System.out.println("6 - Retour");

		int choix=saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherSpectateurs(idEvent); break;
		case 2 : afficherParticipants(idEvent); break;
		case 3 : designerGagnant(idEvent); break;
		case 4 : afficherPrestation(idEvent); break;
		case 5 : ajouterPrestation(idEvent); break;
		case 6 : menuAdmin(); break;
		}
		menuGestionEvent(idEvent);

	}


	public static void ajouterPrestation(Integer idEvent) {

		List<Intervenant> intervenants = daoI.findAll();
		for(Intervenant i : intervenants) 
		{
			System.out.println(i);
		}
		int idIntervenant = saisieInt("Saisir l'id de l'intervenant (0 pour en creer un nouveau)" );

		Intervenant i = null;
		if(idIntervenant==0) 
		{
			//Faire saisir son nom puis autant de talents que necessaire
			String nom = saisieString("Saisissez le nom de votre intervenant");
			List<Talent> listTalent = new ArrayList();
			String reponse="y";
			while (reponse.equals("y")) {
				listTalent.add(Talent.valueOf(saisieString("Saisissez un talent pour votre intervenant parmi : " + Arrays.toString(Talent.values()))));
				reponse=saisieString("Avez-vous un autre talent ? (y/n)");
			}

			i = new Intervenant(nom);
			i.setTalents(listTalent);

			daoI.insert(i);


		}
		else 
		{
			i = daoI.findById(idIntervenant);
		}


		//Faire saisir les dates / heures debut et fin
		//affecter l'id de l'evenement (festival) + id de l'intervenant

		LocalTime heureDebut= LocalTime.parse(saisieString("Saisir l'heure de début de la prestation (hh:mm)"));
		LocalDate dateDebut = LocalDate.parse(saisieString("Saisir la date de début de la prestation (yyyy-mm-dd)"));	//"2007-12-03", 
		LocalTime heureFin= LocalTime.parse(saisieString("Saisir l'heure de fin de la prestation (hh:mm)"));
		LocalDate dateFin = LocalDate.parse(saisieString("Saisir la date de fin de la prestation (yyyy-mm-dd)"));
		Festival f = (Festival) daoE.findById(idEvent);
		Prestation p = new Prestation( dateDebut, heureDebut, dateFin, heureFin, i, f);
		daoP.insert(p);



	}

	public static void afficherPrestation(Integer idEvent) {
		List<Prestation> prestations = daoP.findPrestationsByIdEvent(idEvent);
		if(prestations.isEmpty()) {System.out.println("Pas de prestation");}
		for(Prestation p  : prestations) 
		{
			System.out.println(p);
		}

	}

	public static void designerGagnant(Integer idCompetition) {

		afficherParticipants(idCompetition);

		int idGagnant = saisieInt("Saisir l'id du gagnant");
		daoE.updateGagant(idGagnant, idCompetition);
		


	}



	public static void afficherParticipants(Integer idEvent) {
		List<User> participants = daoC.findParticipants(idEvent);
		if(participants.isEmpty()) {System.out.println("Pas de participant");}
		for(User u  : participants) 
		{
			System.out.println(u);
		}

	}

	public static void afficherSpectateurs(Integer idEvent) {
		List<User> spectateurs = daoC.findSpectateurs(idEvent);
		if(spectateurs.isEmpty()) {System.out.println("Pas de spectateur");}
		for(User u  : spectateurs) 
		{
			System.out.println(u);
		}
	}

	public static void creerEvent() {
		String libelle= saisieString("saisir le libelle");
		String dateDebut= saisieString("saisir la date de debut");
		String dateFin= saisieString("saisir la date de fin");
		String heureDebut=saisieString("saisir l'heure de debut");
		String heureFin=saisieString("saisir l'heure de fin");


		double prix = saisieDouble("Saisir le prix");
		String numero = saisieString("saisir le numero");
		String voie = saisieString("saisir la voie");
		String ville = saisieString("saisir la ville");
		String cp = saisieString("saisir le code postal");

		Adresse a = new Adresse(numero,voie,ville,cp);

		String choixEvenement = saisieString("Festival / Competition");

		Evenement e;
		if(choixEvenement.equals("Festival")) {
			e=new Festival(libelle, LocalDate.parse(dateDebut), LocalTime.parse(heureDebut), LocalDate.parse(dateFin), LocalTime.parse(heureFin), prix, a);
		}
		else 
		{ 
			System.out.println(Arrays.toString(Sport.values()));
			String choixSport = saisieString("Saisir sport");
			e=new Competition(libelle, LocalDate.parse(dateDebut), LocalTime.parse(heureDebut), LocalDate.parse(dateFin), LocalTime.parse(heureFin), prix,Sport.valueOf(choixSport),a);

		}


		daoE.insert(e);

	}

	public static void afficherEvents() {
		List<Evenement> events = daoE.findAll();

		if(events.isEmpty()) {System.out.println("Aucun evenement");}

		for(Evenement e : events) 
		{
			System.out.println(e);
		}

	}

	public static void afficherCompetitions() {
		List<Competition> events = daoE.findAllCompetition();
		if(events.isEmpty()) {System.out.println("Aucun evenement");}
		for(Competition c : events) 
		{
			System.out.println(c);
		}

	}
	public static void main(String[] args) {

		menuPrincipal();

	}

}
