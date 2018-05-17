package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class ObrasDAO {
    
    private static ObrasDAO instance;

    private ObrasDAO() {
        MySQLDAO.getConnection();
    }

    public static ObrasDAO getInstance() {
        if (instance == null) {
            instance = new ObrasDAO();
        }
        return instance;
    }

    public long create(ObrasBEAN obra) {
        String query = "INSERT INTO OBRA ( titulo,subtitulo, editora_codigoEditora,cidade_codigoCidade, edicao,ano,categoria_codigoCategoria, situacao, status,"
                + " codBarras, qtdEstoqueTotal, qtdEstoqueDisponivel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, obra.getTitulo(),obra.getSubititulo(), obra.getCodigoEditora(),obra.getCodigoCidade(),obra.getEdicao(),
                obra.getAno(),obra.getCodigoCategoria(), obra.getSituacao(), obra.getStatus(), 
                obra.getCodBarras(),obra.getQtdEstoqueTotal(), obra.getQtdEstoqueDisponivel());
    }

    public void update(ObrasBEAN obra) {
        String query = "UPDATE OBRA SET titulo=?,subtitulo=?, editora_codigoEditora=?, cidade_codigoCidade=?, edicao=?,ano=?, categoria_codigoCategoria=?, situacao=?, status=?,"
                + " codBarras=?, qtdEstoqueTotal=?, qtdEstoqueDisponivel=? WHERE codigoObra =?";

        MySQLDAO.executeQuery(query, obra.getTitulo(),obra.getSubititulo(), obra.getCodigoEditora(),obra.getCodigoCidade(),
                obra.getEdicao(),obra.getAno(),obra.getCodigoCategoria(), obra.getSituacao(), obra.getStatus(), 
                obra.getCodBarras(),obra.getQtdEstoqueTotal(), obra.getQtdEstoqueDisponivel(), obra.getCodigoObra());
    }

    public void updateStatus(ObrasBEAN obra) {
        String query = "UPDATE OBRA SET situacao=? WHERE codigoObra =?";

        MySQLDAO.executeQuery(query, obra.getSituacao(), obra.getCodigoObra());
    }
    
    public void delete(ObrasBEAN obra) {
        MySQLDAO.executeQuery("DELETE FROM OBRA WHERE codigoObra = ?", obra.getCodigoObra());
    }

    public ArrayList<ObrasBEAN> findAllObra() {
        return listaObras("SELECT * FROM OBRA ORDER BY titulo");
    }

    public ArrayList<ObrasBEAN> listaObras(String query) {
        ArrayList<ObrasBEAN> lista = new ArrayList<ObrasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"),rs.getInt("editora_codigoEditora"),
                        rs.getInt("cidade_codigoCidade"),rs.getInt("edicao"),rs.getDate("ano"),rs.getInt("categoria_codigoCategoria"), rs.getString("situacao"), rs.getString("status"),
                        rs.getString("codBarras"),rs.getInt("qtdEstoqueTotal"),rs.getInt("qtdEstoqueDisponivel")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ObrasBEAN findObraCodigo(int codigoObra) {
        ObrasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE codigoObra=?", codigoObra);
        try {
            if (rs.next()) {
                result = new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"),rs.getInt("editora_codigoEditora"),
                        rs.getInt("cidade_codigoCidade"),rs.getInt("edicao"),rs.getDate("ano"),rs.getInt("categoria_codigoCategoria"), rs.getString("situacao"), rs.getString("status"),
                        rs.getString("codBarras"),rs.getInt("qtdEstoqueTotal"),rs.getInt("qtdEstoqueDisponivel"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ArrayList<ObrasBEAN> findObraTitulo (String titulo) {
        ArrayList<ObrasBEAN> lista = new ArrayList<ObrasBEAN>();
        
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE titulo like ?", "%" +titulo+ "%");
        try {
            while (rs.next()) {
                lista.add( new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"),rs.getInt("editora_codigoEditora"),
                        rs.getInt("cidade_codigoCidade"),rs.getInt("edicao"),rs.getDate("ano"),rs.getInt("categoria_codigoCategoria"), rs.getString("situacao"), rs.getString("status"),
                        rs.getString("codBarras"),rs.getInt("qtdEstoqueTotal"),rs.getInt("qtdEstoqueDisponivel")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public int findId(ObrasBEAN obra) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE titulo= ? and editora_codigoEditora= ? and edicao = ? and situacao =? and status =?",
                obra.getTitulo(), obra.getCodigoEditora(), obra.getEdicao(), obra.getSituacao(), obra.getStatus());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoObra");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int codigoObra) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE codigoObra= ?", codigoObra);
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
                result = rs.getInt("codigoObra");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
