
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosDAO {
    
    private static UsuariosDAO instance;

    private UsuariosDAO() {
        MySQLDAO.getConnection();
    }

    public static UsuariosDAO getInstance() {
        if (instance == null) {
            instance = new UsuariosDAO();
        }
        return instance;
    }

    public long create(UsuariosBEAN usuario) {
        String query = "INSERT INTO USUARIO (login, perfil, senha, nome) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, usuario.getLogin(),usuario.getPerfil(), usuario.getSenha(), usuario.getNome());
    }

    public void update(UsuariosBEAN usuario) {
        String query = "UPDATE USUARIO SET nome=?, perfil=?, login=?, senha=? WHERE codigoUsuario =?";

        MySQLDAO.executeQuery(query, usuario.getNome(), usuario.getPerfil(), usuario.getLogin(), usuario.getSenha(), usuario.getCodigoUsuario());
    }
    
    public void delete(UsuariosBEAN usuario) {
        MySQLDAO.executeQuery("DELETE FROM USUARIO WHERE codigoUsuario = ?", usuario.getCodigoUsuario());
    }

    public ArrayList<UsuariosBEAN> findAllUsuario() {
        return listaUsuarios("SELECT * FROM USUARIO");
    }

    public ArrayList<UsuariosBEAN> listaUsuarios(String query) {
        ArrayList<UsuariosBEAN> lista = new ArrayList<UsuariosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new UsuariosBEAN(rs.getInt("codigoUsuario"), rs.getInt("perfil"), rs.getString("login"),
                        rs.getString("senha"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public UsuariosBEAN findUsuarioCodigo(int codigoUsuario) {
        UsuariosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM USUARIO WHERE codigoUsuario=?", codigoUsuario);
        try {
            if (rs.next()) {
                result = new UsuariosBEAN(rs.getInt("codigoUsuario"), rs.getInt("perfil"), rs.getString("login"),
                        rs.getString("senha"), rs.getString("nome"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<UsuariosBEAN> findUsuarioNome (String nome) {
        ArrayList<UsuariosBEAN> lista = new ArrayList<UsuariosBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM USUARIO WHERE nome like ?", "%" +nome+ "%");
        try {
            while (rs.next()) {
                lista.add( new UsuariosBEAN(rs.getInt("codigoUsuario"), rs.getInt("perfil"), rs.getString("login"),
                        rs.getString("senha"), rs.getString("nome")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(UsuariosBEAN usuario) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM USUARIO WHERE login= ? and perfil= ? and senha = ? and nome =?",
                usuario.getLogin(), usuario.getPerfil(), usuario.getSenha(), usuario.getNome());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoUsuario");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoUsuario) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM USUARIO WHERE codigoUsuario= ?", codigoUsuario);
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
                result = rs.getInt("codigoUsuario");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
