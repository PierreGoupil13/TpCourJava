package fr.epsi.b32223g1.dal.xml;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.dal.ArticleDAO;

import java.sql.SQLException;
import java.util.List;

public class ArticleXMLDAO implements ArticleDAO {
    @Override
    public List<Article> extraire() throws Exception {
        return null;
    }

    @Override
    public void insert(Article article) throws Exception {

    }

    @Override
    public int update(String ancienneDesignation, String nouvelDesignation) throws SQLException{
        return 0;
    }

    @Override
    public boolean deletebyID(Article article) throws SQLException {
        return false;
    }
    @Override
    public boolean deletebyName(String suppr) throws SQLException {
        return false;
    }

    @Override
    public List<Article> extrairebyName(String namme) throws Exception {
        return null;
    }

    @Override
    public Integer averagePrice() throws SQLException {
        return null;
    }
}
