package fr.epsi.b32223g1.dal.xml;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurXMLDAO implements FournisseurDAO {
	@Override
	public List<Fournisseur> extraire() throws Exception {
		//TODO à coder
		System.out.println("XML extraire");
		return new ArrayList<>();
	}
	
	@Override
	public void insert( Fournisseur fournisseur ) {
		//TODO à coder
		System.out.println("XML insert");
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
