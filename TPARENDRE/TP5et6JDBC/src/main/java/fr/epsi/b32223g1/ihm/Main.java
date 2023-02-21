package fr.epsi.b32223g1.ihm;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.bo.Utilisateur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.DAOFactory;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.UtilisateurDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		//authentification();
		
		//authentificationSecurisee();
		try {
			//tp5();
			tp6();
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}

	/*
	private static void authentificationSecurisee() {
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("********** Bienvenue dans mon App Sécurisée ****");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentificationSecurisee( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void authentification() {
		
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("************ Bienvenue dans mon App ************");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentification( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}

	 */

	private static void tp5() throws Exception {

		// Instanciation d'un dao
		FournisseurDAO dao = DAOFactory.getFournisseurDAO();

		//Ajout d'un nouveau fournisseur
		dao.insert(new Fournisseur( "Titouan Corp" ) );
		// Ajout d'un fournisseur avec une simple quote
		//dao.insert(new Fournisseur( "L'Titouan Corp" ) );

		//Extraction des fournisseurs
		List<Fournisseur> fournisseurs = dao.extraire();

		// Suprime un fournisseur
		//boolean suppr = dao.delete(fournisseurs.get(1));
		// Vérification de la suppression
		//System.out.println(suppr);

		// Update un nom de fournisseur
		//dao.update("Pedro's company","Pedro supply chain");

		//Extraction des fournisseurs après modifications
		fournisseurs = dao.extraire();

		// Impression des fournisseurs
		for ( Fournisseur item : fournisseurs ) {
			System.out.println( item );
		}


	}

	private static void tp6() throws Exception {
		// Instancie un dao fournisseur et article
		FournisseurDAO dao = DAOFactory.getFournisseurDAO();

		// TODO : Inserer le fournisseur maison peinture
		ArticleDAO daoArt = DAOFactory.getArticleDAO();

		/* Recup la liste des Articles (BON)
		List<Article> articles = daoArt.extraire();
		System.out.println(articles.get(0));
		for (Article art: articles
			 ) {
			System.out.println(art);
		}
		 */
		// Inserer un article

		Fournisseur fournisseurNouvelArticle = dao.extraireUnique(1);
		Article nouvelArticle = new Article("Peinture blanche 1L", 12.5F,fournisseurNouvelArticle,"A08");
		daoArt.insert(nouvelArticle);
		System.out.println(nouvelArticle);

		/*
		// Update un article
		Integer lignes_update = daoArt.update("Peinture blanche 1L", "Vis 9mm");
		System.out.println(lignes_update);

		 */

		// Delete un article
		//boolean isDelete = daoArt.deletebyID();
		//System.out.println(isDelete);

		// Tâches du TP :
		// Ajout des articles :
		Fournisseur fournisseurAjoutArt = dao.extraireUnique(1);
		Article art1 = new Article("Peinture blanche 1L", 12.5F,fournisseurNouvelArticle,"A08");
		Article art2 = new Article("Peinture rouge mate 1L", 12.5F,fournisseurNouvelArticle,"A08");
		Article art3 = new Article("Peinture noire laquée 1L", 12.5F,fournisseurNouvelArticle,"A08");
		Article art4 = new Article("Peinture bleu mate 1L", 12.5F,fournisseurNouvelArticle,"A08");
		daoArt.insert(art1);
		daoArt.insert(art2);
		daoArt.insert(art3);
		daoArt.insert(art4);

		// Diminuer prix peintures mates :
			// Faire en SQL
		// Lister tout les articles :
		List<Article> articles = daoArt.extraire();
		for (Article art: articles
		) {
			System.out.println(art);
		}

		// Requete moyenne des prix des articles et afficher (faire en base aps en code) :
		Integer avg = daoArt.averagePrice();
		System.out.println(avg);
		// Supprimer articles avec nom Peinture (voir SQL ou code) redef la methode
		daoArt.deletebyName("Peinture");
		// Supprimer le fournisseur La maison de la peinture :
		daoArt.deletebyName("La maison de la peinture");




	}
}

