package fr.epsi.b32223g1.dal.jpa;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurJPADAO implements FournisseurDAO {
	@Override
	public List<Fournisseur> extraire() throws SQLException {
		//TODO à coder
		System.out.println("JPA extraire");
		return new ArrayList<>();
	}
	
	@Override
	public void insert( Fournisseur fournisseur ) {
		System.out.println("JPA insert");
		//TODO à coder
	}
	
	@Override
	public int update( String ancienNom, String nouveauNom ) {
		//TODO à coder
		return 0;
	}
	
	@Override
	public boolean delete( Fournisseur fournisseur ) {
		//TODO à coder
		return false;
	}

	@Override
	public Fournisseur extraireUnique(int id) throws Exception {
		return null;
	}
}
