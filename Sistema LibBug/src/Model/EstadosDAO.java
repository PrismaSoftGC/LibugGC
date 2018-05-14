
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstadosDAO {
    
    private static EstadosDAO instance;

    private EstadosDAO() {
        MySQLDAO.getConnection();
    }

    public static EstadosDAO getInstance() {
        if (instance == null) {
            instance = new EstadosDAO();
        }
        return instance;
    }

    public ArrayList<EstadosBEAN> findAllEstado() {
        return listaEstados("SELECT * FROM ESTADO");
    }

    public ArrayList<EstadosBEAN> listaEstados(String query) {
        ArrayList<EstadosBEAN> lista = new ArrayList<EstadosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new EstadosBEAN(rs.getInt("codigoEstado"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EstadosBEAN findEstadoCodigo(int codigoEstado) {
        EstadosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ESTADO WHERE codigoEstado=?", codigoEstado);
        try {
            if (rs.next()) {
                result = new EstadosBEAN(rs.getInt("codigoEstado"), rs.getString("nome"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<EstadosBEAN> findEstadoNome (String estado) {
        ArrayList<EstadosBEAN> lista = new ArrayList<EstadosBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ESTADO WHERE nome like ?", "%" +estado+ "%");
        try {
            while (rs.next()) {
                lista.add( new EstadosBEAN(rs.getInt("codigoEstado"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(EstadosBEAN estado) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ESTADO WHERE nome= ?",
                estado.getNome());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoEstado");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoEstado) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ESTADO WHERE codigoEstado= ?", codigoEstado);
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
                result = rs.getInt("codigoEstado");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
