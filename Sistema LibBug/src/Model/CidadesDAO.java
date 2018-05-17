
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CidadesDAO {
    
    private static CidadesDAO instance;

    private CidadesDAO() {
        MySQLDAO.getConnection();
    }

    public static CidadesDAO getInstance() {
        if (instance == null) {
            instance = new CidadesDAO();
        }
        return instance;
    }

    public ArrayList<CidadesBEAN> findAllCidade() {
        return listaCidades("SELECT * FROM CIDADE");
    }

    public ArrayList<CidadesBEAN> listaCidades(String query) {
        ArrayList<CidadesBEAN> lista = new ArrayList<CidadesBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new CidadesBEAN(rs.getInt("codigoCidade"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public CidadesBEAN findCidadeCodigo(int codigoCidade) {
        CidadesBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CIDADE WHERE codigoCidade=?", codigoCidade);
        try {
            if (rs.next()) {
                result = new CidadesBEAN(rs.getInt("codigoCidade"), rs.getString("nome"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<CidadesBEAN> findCidadeNome (String cidade) {
        ArrayList<CidadesBEAN> lista = new ArrayList<CidadesBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CIDADE WHERE nome like ?", "%" +cidade+ "%");
        try {
            while (rs.next()) {
                lista.add( new CidadesBEAN(rs.getInt("codigoCidade"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(CidadesBEAN cidade) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CIDADE WHERE nome= ?",
                cidade.getNome());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoCidade");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoCidade) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CIDADE WHERE codigoCidade= ?", codigoCidade);
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
                result = rs.getInt("codigoCidade");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
