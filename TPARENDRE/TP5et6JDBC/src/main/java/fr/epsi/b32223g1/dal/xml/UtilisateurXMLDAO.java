package fr.epsi.b32223g1.dal.xml;

import fr.epsi.b32223g1.bo.Utilisateur;
import fr.epsi.b32223g1.dal.UtilisateurDAO;

public class UtilisateurXMLDAO implements UtilisateurDAO {
	@Override
	public Utilisateur authentification( String login, String pwd ) throws Exception {
		return null;
	}
	
	@Override
	public Utilisateur authentificationSecurisee( String login, String mdp ) throws Exception {
		return null;
	}
}
