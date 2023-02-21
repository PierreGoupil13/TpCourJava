package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {
	
	List<Fournisseur> extraire() throws Exception;
	
	void insert( Fournisseur fournisseur )throws Exception;
	
	int update( String ancienNom, String nouveauNom ) throws SQLException;
	
	boolean delete( Fournisseur fournisseur ) throws SQLException;

	Fournisseur extraireUnique(int id) throws Exception;
}
