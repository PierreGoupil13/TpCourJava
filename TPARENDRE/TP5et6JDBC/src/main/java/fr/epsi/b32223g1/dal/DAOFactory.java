package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.UtilisateurJDBCDAO;
import fr.epsi.b32223g1.dal.jpa.ArticleJPADAO;
import fr.epsi.b32223g1.dal.jpa.FournisseurJPADAO;
import fr.epsi.b32223g1.dal.jpa.UtilisateurJPADAO;
import fr.epsi.b32223g1.dal.xml.ArticleXMLDAO;
import fr.epsi.b32223g1.dal.xml.FournisseurXMLDAO;
import fr.epsi.b32223g1.dal.xml.UtilisateurXMLDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.util.ResourceBundle;

public class DAOFactory {
	
	private static final String STORE_MODE;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle( "app-config" );
		STORE_MODE = bundle.getString( "store.mode" );
	}
	
	private DAOFactory() {}
	
	
	public static FournisseurDAO getFournisseurDAO() throws StoreModeNotFoundException {
		
		FournisseurDAO dao;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new FournisseurJDBCDAO();
				break;
			case "XML" :
				dao = new FournisseurXMLDAO();
				break;
			case "JPA":
				dao = new FournisseurJPADAO();
				break;
			default:
				throw new StoreModeNotFoundException(STORE_MODE);
				
		}
		return dao;
	}
	
	public static UtilisateurDAO getUtilisateurDAO() throws StoreModeNotFoundException {
		
		UtilisateurDAO dao;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new UtilisateurJDBCDAO();
				break;
			case "XML" :
				dao = new UtilisateurXMLDAO();
				break;
			case "JPA":
				dao = new UtilisateurJPADAO();
				break;
			default:
				throw new StoreModeNotFoundException(STORE_MODE);
				
		}
		return dao;
	}
	public static ArticleDAO getArticleDAO() throws StoreModeNotFoundException {

		ArticleDAO dao;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new ArticleJDBCDAO();
				break;
			case "XML" :
				dao = new ArticleXMLDAO();
				break;
			case "JPA":
				dao = new ArticleJPADAO();
				break;
			default:
				throw new StoreModeNotFoundException(STORE_MODE);

		}
		return dao;
	}
}
