
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelefonesDAO {
    
    private static TelefonesDAO instance;

    private TelefonesDAO() {
        MySQLDAO.getConnection();
    }

    public static TelefonesDAO getInstance() {
        if (instance == null) {
            instance = new TelefonesDAO();
        }
        return instance;
    }

    public long create(TelefonesBEAN telefone) {
        String query = "INSERT INTO TELEFONE (ddd, numero, cliente_codigoCliente, editora_ideditora) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, telefone.getDdd(), telefone.getNumero(), telefone.getCliente_codigoCliente(), telefone.getEditora_codigoEditora());
    }

    public void update(TelefonesBEAN telefone) {
        String query = "UPDATE TELEFONE SET ddd=?, numero=?, cliente_codigoCliente=?, editora_codigoEditora=? WHERE codigoTelefone =?";

        MySQLDAO.executeQuery(query,  telefone.getDdd(), telefone.getNumero(), telefone.getCliente_codigoCliente(), telefone.getEditora_codigoEditora(), telefone.getCodigoTelefone());
    }
    
    public void delete(TelefonesBEAN telefone) {
        MySQLDAO.executeQuery("DELETE FROM TELEFONE WHERE codigoTelefone = ?", telefone.getCodigoTelefone());
    }

    public ArrayList<TelefonesBEAN> findAllTelefone() {
        return listaTelefones("SELECT * FROM TELEFONE");
    }

    public ArrayList<TelefonesBEAN> listaTelefones(String query) {
        ArrayList<TelefonesBEAN> lista = new ArrayList<TelefonesBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new TelefonesBEAN(rs.getInt("codigoTelefone"), rs.getInt("ddd"), rs.getInt("numero"), 
                        rs.getInt("cliente_codigoCliente"), rs.getInt("editora_codigoEditora")));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public TelefonesBEAN findTelefoneCodigo(int codigoTelefone) {
        TelefonesBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM TELEFONE WHERE codigoTelefone=?", codigoTelefone);
        try {
            if (rs.next()) {
                result = new TelefonesBEAN(rs.getInt("codigoTelefone"), rs.getInt("ddd"), rs.getInt("numero"), 
                        rs.getInt("cliente_codigoCliente"), rs.getInt("editora_codigoEditora"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<TelefonesBEAN> findTelefoneNumero (int numero) {
        ArrayList<TelefonesBEAN> lista = new ArrayList<TelefonesBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM TELEFONE WHERE numero like ?", "%" +numero+ "%");
        try {
            while (rs.next()) {
                lista.add( new TelefonesBEAN(rs.getInt("codigoTelefone"), rs.getInt("ddd"), rs.getInt("numero"), 
                        rs.getInt("cliente_codigoCliente"), rs.getInt("editora_codigoEditora")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(TelefonesBEAN telefone) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM TELEFONE WHERE ddd= ? and numero= ? and cliente_codigoCliente = ? and editora_codigoEditora =?",
                telefone.getDdd(), telefone.getNumero(), telefone.getCliente_codigoCliente(), telefone.getEditora_codigoEditora());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoTelefone");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoTelefone) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM TELEFONE WHERE codigoTelefone= ?", codigoTelefone);
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

    public int LastId() {
        int result =0 ;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT LAST INSERT ID");
        try {
            if (rs.next()) {
                result = rs.getInt("codigoTelefone");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
