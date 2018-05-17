
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecosDAO {
    
    private static EnderecosDAO instance;

    private EnderecosDAO() {
        MySQLDAO.getConnection();
    }

    public static EnderecosDAO getInstance() {
        if (instance == null) {
            instance = new EnderecosDAO();
        }
        return instance;
    }

    public long create(EnderecosBEAN endereco) {
        String query = "INSERT INTO ENDERECO (editora_codigoEditora, cliente_codigoCliente, cidade_codigoCidade, rua, bairro, complemento) VALUES (?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, endereco.getEditora_codigoEditora(), endereco.getCliente_codigoCliente(), endereco.getCidade_codigoCidade(), endereco.getRua(),endereco.getBairro(), endereco.getComplemento());
    }

    public void update(EnderecosBEAN endereco) {
        String query = "UPDATE ENDERECO SET editora_codigoEditora=?, cliente_codigoCliente=?, cidade_codigoCidade=?, rua=?, bairro=?, complemento=? WHERE codigoEndereco =?";

        MySQLDAO.executeQuery(query, endereco.getEditora_codigoEditora(), endereco.getCliente_codigoCliente(), endereco.getCidade_codigoCidade(), endereco.getRua(), endereco.getBairro(), endereco.getComplemento(), endereco.getCodigoEndereco());
    }
    
    public void delete(EnderecosBEAN endereco) {
        MySQLDAO.executeQuery("DELETE FROM ENDERECO WHERE codigoEndereco = ?", endereco.getCodigoEndereco());
    }

    public ArrayList<EnderecosBEAN> findAllEndereco() {
        return listaEnderecos("SELECT * FROM ENDERECO");
    }

    public ArrayList<EnderecosBEAN> listaEnderecos(String query) {
        ArrayList<EnderecosBEAN> lista = new ArrayList<EnderecosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new EnderecosBEAN(rs.getInt("codigoEndereco"), rs.getInt("editora_codigoEditora"), rs.getInt("cliente_codigoCliente"),
                rs.getInt("cidade_codigoCidade"),rs.getString("rua"),rs.getString("bairro"),rs.getString("complemento")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EnderecosBEAN findEnderecoCodigo(int codigoEndereco) {
        EnderecosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE codigoTelefone=?", codigoEndereco);
        try {
            if (rs.next()) {
                result = new EnderecosBEAN(rs.getInt("codigoEndereco"), rs.getInt("editora_codigoEditora"), rs.getInt("cliente_codigoCliente"),
                rs.getInt("cidade_codigoCidade"),rs.getString("rua"),rs.getString("bairro"),rs.getString("complemento"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<EnderecosBEAN> findEnderecoRua (String rua) {
        ArrayList<EnderecosBEAN> lista = new ArrayList<EnderecosBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE rua like ?", "%" +rua+ "%");
        try {
            while (rs.next()) {
                lista.add( new EnderecosBEAN(rs.getInt("codigoEndereco"), rs.getInt("editora_codigoEditora"), rs.getInt("cliente_codigoCliente"),
                rs.getInt("cidade_codigoCidade"),rs.getString("rua"),rs.getString("bairro"),rs.getString("complemento")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(EnderecosBEAN endereco) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE editora_codigoEditora= ? and cliente_codigoCliente= ? and cidade_codigoCidade= ? and rua=? and bairro=? and complemento=?",
                endereco.getEditora_codigoEditora(), endereco.getCliente_codigoCliente(), endereco.getCidade_codigoCidade(), endereco.getRua(), endereco.getBairro(), endereco.getComplemento());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoEndereco");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoEndereco) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE codigoEndereco= ?", codigoEndereco);
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
                result = rs.getInt("codigoEndereco");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
