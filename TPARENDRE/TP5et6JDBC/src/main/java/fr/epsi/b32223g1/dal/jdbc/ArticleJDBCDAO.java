package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.DAOFactory;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArticleJDBCDAO implements ArticleDAO {
    private static final String FIND_ALL_QUERY = "SELECT * FROM ARTICLE";
    private static final String INSERT_QUERY = "INSERT INTO ARTICLE (DESIGNATION, PRIX, ID_FOU, REF) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE ARTICLE SET DESIGNATION = ? WHERE DESIGNATION = ?";
    private static final String DELETE_QUERY_ID = "DELETE FROM ARTICLE WHERE ID = ?";
    private static final String DELETE_QUERY_NAME = "DELETE FROM ARTICLE WHERE DESIGNATION LIKE ?";
    private static final String FIND_QUERY_BY_NAME = "SELECT * FROM ARTICLE WHERE DESIGNATION LIKE ?";
    private static final String AVERAGE_PRICE_QUERY = "SELECT AVG(PRIX) FROM ARTICLE";


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
    public List<Article> extraire() throws Exception {
        List<Article> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
             PreparedStatement pst = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = pst.executeQuery();) {

            FournisseurDAO dao = DAOFactory.getFournisseurDAO();
            List<Fournisseur> fournisseurs = dao.extraire();

            while ( rs.next() ) {
                int id = rs.getInt( "ID" );
                String designation = rs.getString( "DESIGNATION" );
                float prix = rs.getFloat("PRIX");
                int four_id = rs.getInt("ID_FOU");
                Fournisseur actual_fournisseur = fournisseurs.get(four_id);
                String ref = rs.getString("REF");
                Article article = new Article( id,  ref,  designation,  prix,  actual_fournisseur);
                list.add( article );
            }
        }
        return list;
    }
    @Override
    public List<Article> extrairebyName(String name) throws Exception {
        List<Article> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
             PreparedStatement pst = connection.prepareStatement(FIND_QUERY_BY_NAME);
             ) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            FournisseurDAO dao = DAOFactory.getFournisseurDAO();
            List<Fournisseur> fournisseurs = dao.extraire();

            while ( rs.next() ) {
                int id = rs.getInt( "ID" );
                String designation = rs.getString( "DESIGNATION" );
                float prix = rs.getFloat("PRIX");
                int four_id = rs.getInt("ID_FOU");
                Fournisseur actual_fournisseur = fournisseurs.get(four_id);
                String ref = rs.getString("REF");
                Article article = new Article( id,  ref,  designation,  prix,  actual_fournisseur);
                list.add( article );
            }
            rs.close();
        }
        return list;
    }

    @Override
    public Integer averagePrice() throws SQLException {
        try (Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
             PreparedStatement pst = connection.prepareStatement(AVERAGE_PRICE_QUERY);

        ){
            ResultSet avg = pst.executeQuery();
            System.out.println(avg.first());
            return 1;

        }
    }

    @Override
    public void insert( Article article ) throws SQLException {
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement pst = connection.prepareStatement(INSERT_QUERY); ) {
            pst.setString(1,article.getDesignation());
            pst.setFloat(2, article.getPrix());
            // Probleme la car pas de fournisseur en BDD
            pst.setInt(3, article.get_fournisseur().getId());
            pst.setString(4,article.getRef());

            pst.executeUpdate();
        }
    }

    @Override
    public int update(String ancienneDesignation, String nouvelDesignation) throws SQLException {
        int nb_lignes_modifier = 0;
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement pst = cnx.prepareStatement(UPDATE_QUERY)){
            pst.setString( 1, nouvelDesignation);
            pst.setString( 2, ancienneDesignation);
            nb_lignes_modifier = pst.executeUpdate();

        }
        return nb_lignes_modifier;
    }

    @Override
    public boolean deletebyID( Article article ) throws SQLException {
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement pst = connection.prepareStatement(DELETE_QUERY_ID); ) {
            pst.setInt(1, article.getId());

            if (pst.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean deletebyName( String nomaSuppr ) throws SQLException {
        // A redefinir
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement pst = connection.prepareStatement(DELETE_QUERY_NAME); ) {
            pst.setString(1, "%" + nomaSuppr + "%");

            if (pst.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
