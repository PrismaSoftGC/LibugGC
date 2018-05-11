package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javafx.beans.binding.Bindings.and;
import static javax.management.Query.and;

public class EditorasDAO {
    
    private static EditorasDAO instance;
    
    private EditorasDAO(){
        MySQLDAO.getConnection();
    }
    
    public static EditorasDAO getInstance(){
        if(instance == null){
            instance = new EditorasDAO();
        }
        return instance;
    }
    
    public long create(EditorasBEAN editora){
        String query = "INSERT INTO EDITORA (nomeFantasia, razaoSocial, cnpj, rua, bairro, complemento, cidade, telefone, status) VALUES (?,?,?,?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, editora.getNomeFantasia(), editora.getRazaoSocial(), editora.getCnpj(), editora.getRua(),
                editora.getBairro(), editora.getComplemento(), editora.getCidade(), editora.getTelefone(), editora.getStatus());
    }
    
    public void update(EditorasBEAN editora){
        String query = "UPDATE EDITORA SET nomeFantasia=?, razaoSocial=?, cnpj=?, rua=?, bairro=?, complemento=?, cidade=?, telefone=?, status=? WHERE codigoEditora =?";
       
        MySQLDAO.executeQuery(query, editora.getNomeFantasia(), editora.getRazaoSocial(), editora.getCnpj(), editora.getRua(),
                editora.getBairro(), editora.getComplemento(), editora.getCidade(), editora.getTelefone(), editora.getStatus(), editora.getCodigoEditora());
    }
    
    public void delete(EditorasBEAN editora) {
        MySQLDAO.executeQuery("DELETE FROM EDITORA WHERE codigoEditora = ?", editora.getCodigoEditora());
    }

    public ArrayList<EditorasBEAN> findAllEditora() {
        return listaEditoras("SELECT * FROM EDITORA ORDER BY nomeFantasia");
    }

    public ArrayList<EditorasBEAN> listaEditoras(String query) {
        ArrayList<EditorasBEAN> lista = new ArrayList<EditorasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new EditorasBEAN(rs.getInt("codigoEditora"), rs.getString("nomeFantasia"), rs.getString("razaoSocial"),
                        rs.getString("cnpj"), rs.getString("rua"), rs.getString("bairro"), rs.getString("complemento"), 
                        rs.getString("cidade"), rs.getString("telefone"), rs.getString("status")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EditorasBEAN findEditoraCodigo(int codigoEditora) {
        EditorasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE codigoEditora=?", codigoEditora);
        try {
            if (rs.next()) {
                result = new EditorasBEAN(rs.getInt("codigoEditora"), rs.getString("nomeFantasia"), rs.getString("razaoSocial"),
                        rs.getString("cnpj"), rs.getString("rua"), rs.getString("bairro"), rs.getString("complemento"), 
                        rs.getString("cidade"), rs.getString("telefone"), rs.getString("status"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<EditorasBEAN> findEditoraNome(String nomeEditora) {
        ArrayList<EditorasBEAN> lista = new ArrayList<EditorasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE nomeFantasia like ?", "%" +nomeEditora+ "%");
        try {
            while (rs.next()) {
                lista.add( new EditorasBEAN(rs.getInt("codigoEditora"), rs.getString("nomeFantasia"), rs.getString("razaoSocial"),
                        rs.getString("cnpj"), rs.getString("rua"), rs.getString("bairro"), rs.getString("complemento"), 
                        rs.getString("cidade"), rs.getString("telefone"), rs.getString("status")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int findId(EditorasBEAN editora) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE nomeFantasia=? and razaoSocial=? and cnpj=?"
                + " and rua=? and bairro=? and complemento=? and cidade=? and telefone=? and status=?",
                editora.getNomeFantasia(), editora.getRazaoSocial(), editora.getCnpj(), editora.getRua(),
                editora.getBairro(), editora.getComplemento(), editora.getCidade(), editora.getStatus());
 try {
            if (rs.next()) {
                result = rs.getInt("codigoEditora");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoEditora) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE codigoEditora= ?", codigoEditora);
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

    
}
