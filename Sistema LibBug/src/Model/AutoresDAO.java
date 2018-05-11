package Model;

import static com.sun.javafx.fxml.expression.Expression.and;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javafx.beans.binding.Bindings.and;
import static javax.management.Query.and;


public class AutoresDAO {
    

    private static AutoresDAO instance;

    private AutoresDAO() {
        MySQLDAO.getConnection();
    }

    public static AutoresDAO getInstance() {
        if (instance == null) {
            instance = new AutoresDAO();
        }
        return instance;
    }

    public long create(AutoresBEAN autor) {
        String query = "INSERT INTO AUTOR (nome, status, conteudo, cpf) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus(), autor.getConteudo(), autor.getCpf());
    }

    public void update(AutoresBEAN autor) {
        String query = "UPDATE AUTOR SET nome=?, status=?, conteudo=?, cpf=? WHERE codigoAutor = ?";
        MySQLDAO.executeQuery(query, autor.getNome(), autor.getStatus(), autor.getConteudo(), autor.getCpf(), autor.getCodigoAutor());
    }

    public void delete(AutoresBEAN autor) {
        MySQLDAO.executeQuery("DELETE FROM AUTOR WHERE codigoAutor = ?", autor.getCodigoAutor());
    }

    public ArrayList<AutoresBEAN> findAllAutor() {
        return listaAutores("SELECT * FROM AUTOR ORDER BY nome");
    }
    
    public ArrayList<AutoresBEAN> listaAutores(String query) {
        ArrayList<AutoresBEAN> lista = new ArrayList<AutoresBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new AutoresBEAN(rs.getInt("codigoAutor"), rs.getString("nome"), rs.getString("status"), rs.getString("conteudo"), rs.getString("cpf")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    public AutoresBEAN findAutorCodigo(int codigoAutor) {
        AutoresBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE codigoAutor=?", codigoAutor);
        try {
            if (rs.next()) {
                result = new AutoresBEAN(rs.getInt("codigoAutor"), rs.getString("nome"), rs.getString("status"), rs.getString("conteudo"), rs.getString("cpf"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<AutoresBEAN> findAutorNome(String nomeAutor) {
        ArrayList<AutoresBEAN> lista = new ArrayList<AutoresBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE nome like ?", "%" +nomeAutor+ "%");
        try {
            while (rs.next()) {
                lista.add( new AutoresBEAN(rs.getInt("codigoAutor"), rs.getString("nome"), rs.getString("status"), rs.getString("conteudo"), rs.getString("cpf")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int findId(AutoresBEAN autor) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE nome= ? and status= ? and conteudo= ? amd cpf= ?",autor.getNome(), autor.getStatus());

 try {
            if (rs.next()) {
                result = rs.getInt("codigoAutor");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoAutor) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE codigoAutor= ?", codigoAutor);
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
