package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuxAutorObraDAO {

    private static AuxAutorObraDAO instance;

    private AuxAutorObraDAO() {
        MySQLDAO.getConnection();
    }

    public static AuxAutorObraDAO getInstance() {
        if (instance == null) {
            instance = new AuxAutorObraDAO();
        }
        return instance;
    }

    public long create(AuxAutorObraBEAN aux) {
        String query = "INSERT INTO aux_autor_obra (codigoAutor, codigoObra) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, aux.getCodigoAutor(), aux.getCodigoObra());
    }
        
    public void update(AuxAutorObraBEAN aux) {
        String query = "UPDATE aux_autor_obra SET codigoAutor=? WHERE codigoObra = codigoObra";

        MySQLDAO.executeQuery(query, aux.getCodigoAutor(), aux.getCodigoObra());
    }

    public void delete(AuxAutorObraBEAN aux) {
        MySQLDAO.executeQuery("DELETE FROM aux_autor_obra WHERE codigoObra = ? ",aux.getCodigoObra() );
    }

    public ArrayList<AuxAutorObraBEAN> findAllAux(int codigoObra) {
        return listaAux("SELECT * FROM aux_autor_obra WHERE codigoObra = '"+codigoObra+"' ");
    }

    public ArrayList<AuxAutorObraBEAN> listaAux(String query) {
        ArrayList<AuxAutorObraBEAN> lista = new ArrayList<>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new AuxAutorObraBEAN(rs.getInt("codigoAutor"), rs.getInt("codigoObra")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
/*
    public AuxAutorObraBEAN findAuxCodigo(int codigoAux) {
        ObrasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM aux_autor_obra WHERE codigoAutor=? and codigoObra=? ", );
        try {
            if (rs.next()) {
                result = new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"), rs.getInt("codigoEditora"),
                        rs.getInt("edicao"), rs.getString("situacao"), rs.getString("status"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
*/
   

}
