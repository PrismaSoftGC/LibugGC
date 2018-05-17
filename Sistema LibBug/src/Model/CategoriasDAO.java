
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriasDAO {
    
    private static CategoriasDAO instance;

    private CategoriasDAO() {
        MySQLDAO.getConnection();
    }

    public static CategoriasDAO getInstance() {
        if (instance == null) {
            instance = new CategoriasDAO();
        }
        return instance;
    }

    public ArrayList<CategoriasBEAN> findAllCategoria() {
        return listaCategorias("SELECT * FROM CATEGORIA");
    }

    public ArrayList<CategoriasBEAN> listaCategorias(String query) {
        ArrayList<CategoriasBEAN> lista = new ArrayList<CategoriasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new CategoriasBEAN(rs.getInt("codigoCategoria"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public CategoriasBEAN findCategoriaCodigo(int codigoCategoria) {
        CategoriasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CATEGORIA WHERE codigoCategoria=?", codigoCategoria);
        try {
            if (rs.next()) {
                result = new CategoriasBEAN(rs.getInt("codigoCategoria"), rs.getString("nome"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<CategoriasBEAN> findCategoriaNome (String categoria) {
        ArrayList<CategoriasBEAN> lista = new ArrayList<CategoriasBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CATEGORIA WHERE nome like ?", "%" +categoria+ "%");
        try {
            while (rs.next()) {
                lista.add( new CategoriasBEAN(rs.getInt("codigoCategoria"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(CategoriasBEAN categoria) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CATEGORIA WHERE nome= ?",
                categoria.getNome());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoCategoria");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoCategoria) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CATEGORIA WHERE codigoCategoria= ?", codigoCategoria);
        try {
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int lastId() {
        int result =0 ;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT LAST INSERT ID");
        try {
            if (rs.next()) {
                result = rs.getInt("codigoCategoria");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
