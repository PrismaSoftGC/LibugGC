package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AuxEmprestimoObraDAO {
    private static AuxEmprestimoObraDAO instance;

    private AuxEmprestimoObraDAO() {
        MySQLDAO.getConnection();
    }

    public static AuxEmprestimoObraDAO getInstance() {
        if (instance == null) {
            instance = new AuxEmprestimoObraDAO();
        }
        return instance;
    }

    public long create(AuxEmprestimoObraBEAN aux) {
        String query = "INSERT INTO aux_emprestimo_obra (codigoEmprestimo, codigoObra, chegada) VALUES (?,?,?)";
        return MySQLDAO.executeQuery(query, aux.getCodigoEmprestimo(), aux.getCodigoObra(), aux.getChegada());
    }
    
    public void delete(int codigo) {
        MySQLDAO.executeQuery("DELETE FROM aux_emprestimo_obra WHERE codigoEmprestimo = ? ",codigo );
    }
    
    public ArrayList<AuxEmprestimoObraBEAN> findAllAux2(int codigoEmprestimo) {
        return listaAux("SELECT * FROM aux_emprestimo_obra WHERE codigoEmprestimo = '"+codigoEmprestimo+"' ");
    }
    
    public ArrayList<AuxEmprestimoObraBEAN> findAllAux3(int codigoObra) {
        return listaAux("SELECT * FROM aux_emprestimo_obra WHERE codigoObra = '"+codigoObra+"' ");
    }

    public ArrayList<AuxEmprestimoObraBEAN> listaAux(String query) {
        ArrayList<AuxEmprestimoObraBEAN> lista = new ArrayList<>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new AuxEmprestimoObraBEAN(rs.getInt("codigoEmprestimo"), rs.getInt("codigoObra"), rs.getDate("chegada")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
