package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurJDBCDAO implements FournisseurDAO {
	
	private static final String FIND_ALL_QUERY = "SELECT * FROM FOURNISSEUR";
	private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
	private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = ?  WHERE NOM = ?";
	private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ?";
	private static final String FIND_UNIQUE_QUERY = "SELECT * FROM FOURNISSEUR WHERE ID = ?";

	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle( "db" );
		DB_URL = bundle.getString( "db.url" );
		DB_USER = bundle.getString( "db.user" );
		DB_PWD = bundle.getString( "db.password" );
	}
	
	@Override
	public List<Fournisseur> extraire() throws SQLException {

		List<Fournisseur> list = new ArrayList<>();
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement pst = connection.prepareStatement(FIND_ALL_QUERY);
			  ResultSet rs = pst.executeQuery() ) {
			
			while ( rs.next() ) {
				int id = rs.getInt( "ID" );
				String nom = rs.getString( "NOM" );
				Fournisseur fournisseur = new Fournisseur( id, nom );
				list.add( fournisseur );
			}
		}
		return list;
	}


	@Override
	public void insert( Fournisseur fournisseur ) throws SQLException {
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement pst = connection.prepareStatement(INSERT_QUERY); ) {
			pst.setString(1,fournisseur.getName());
			pst.executeUpdate();
		}
	}
	
	@Override
	public int update( String ancienNom, String nouveauNom ) throws SQLException {
		int nb_lignes_modifier = 0;
		try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			 PreparedStatement pst = cnx.prepareStatement(UPDATE_QUERY)){
			pst.setString( 1, nouveauNom );
			pst.setString( 2, ancienNom );
			nb_lignes_modifier = pst.executeUpdate();

		}
		return nb_lignes_modifier;
	}
	
	@Override
	public boolean delete( Fournisseur fournisseur ) throws SQLException {
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement pst = connection.prepareStatement(DELETE_QUERY) ) {
			pst.setString(1,fournisseur.getName());

			// A vérif la validiter de cela
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public Fournisseur extraireUnique(int id) throws Exception {
		Fournisseur fournisseur = null;
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement pst = connection.prepareStatement(FIND_UNIQUE_QUERY);
			  ) {
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				int id_four = rs.getInt( "ID" );
				String nom = rs.getString( "NOM" );
				fournisseur = new Fournisseur( id_four, nom );
			}
		}
		return fournisseur;
	}
}
