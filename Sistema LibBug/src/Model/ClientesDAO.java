package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO {

    private static ClientesDAO instance;

    private ClientesDAO() {
        MySQLDAO.getConnection();
    }

    public static ClientesDAO getInstance() {
        if (instance == null) {
            instance = new ClientesDAO();
        }
        return instance;
    }

    public long create(ClientesBEAN cliente) {
        String query = "INSERT INTO CLIENTE (nome, status, cpf, idade, email) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, cliente.getNome(), cliente.getStatus(),
                cliente.getCpf(), cliente.getIdade(), cliente.getEmail());
    }

    public void update(ClientesBEAN cliente) {
        String query = "UPDATE CLIENTE SET nome=?, status=?, cpf=?, idade=?, email=? WHERE codigoCliente =?";
        MySQLDAO.executeQuery(query, cliente.getNome(), cliente.getStatus(),
                cliente.getCpf(), cliente.getIdade(), cliente.getEmail());
    }

    public void delete(ClientesBEAN cliente) {
        MySQLDAO.executeQuery("DELETE FROM CLIENTE WHERE codigoCliente = ?", cliente.getCodigoCliente());
    }

    public ArrayList<ClientesBEAN> findAllCliente() {
        return listaClientes("SELECT * FROM CLIENTE ORDER BY nome");
    }
    
    public ArrayList<ClientesBEAN> listaClientes(String query) {
        ArrayList<ClientesBEAN> lista = new ArrayList<ClientesBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new ClientesBEAN(rs.getInt("codigoCliente"), rs.getString("nome"), rs.getString("status"),
                        rs.getString("cpf"), rs.getInt("idade"),rs.getString("email")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ClientesBEAN findClienteCodigo(int codigoCliente) {
        ClientesBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE codigoCliente=?", codigoCliente);
        try {
            if (rs.next()) {
                result = new ClientesBEAN(rs.getInt("codigoCliente"), rs.getString("nome"), rs.getString("status"),
                        rs.getString("cpf"), rs.getInt("idade"),rs.getString("email"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ClientesBEAN findClienteCpf(long cpf) {
        ClientesBEAN result = null;
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE cpf=?", cpf);
        try {
            if (rs.next()) {
                result = new ClientesBEAN(rs.getInt("codigoCliente"), rs.getString("nome"), rs.getString("status"),
                        rs.getString("cpf"), rs.getInt("idade"),rs.getString("email"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
     
    public ArrayList<ClientesBEAN> findClienteNome(String nomeCliente) {
        
        ArrayList<ClientesBEAN> lista = new ArrayList<ClientesBEAN>();
        ResultSet rs = null;
        
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE nome like ?", "%" +nomeCliente+ "%");
        try {
            while (rs.next()) {
                lista.add(new ClientesBEAN(rs.getInt("codigoCliente"), rs.getString("nome"), rs.getString("status"),
                        rs.getString("cpf"), rs.getInt("idade"),rs.getString("email")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int findId(ClientesBEAN cliente) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE nome= ? and status= ? and cpf = ? and idade =? ",
                cliente.getNome(), cliente.getStatus(), cliente.getCpf(),
                cliente.getIdade());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoCliente");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoCliente) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE codigoCliente= ?", codigoCliente);
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
