package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDAO {
    List<Article> extraire() throws Exception;

    void insert( Article article )throws Exception;

    int update(String ancienneDesignation, String nouvelDesignation) throws SQLException;

    boolean deletebyID(Article article ) throws SQLException;
    public boolean deletebyName( String suppr ) throws SQLException;
    public List<Article> extrairebyName(String name) throws Exception;
    public Integer averagePrice() throws SQLException;
}
