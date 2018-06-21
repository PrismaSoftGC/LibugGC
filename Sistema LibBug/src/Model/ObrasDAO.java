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
    
    public void updateEstoque(ObrasBEAN obra){
        String query = "UPDATE OBRA SET qtdEstoqueDisponivel=? WHERE codigoObra =?";
        MySQLDAO.executeQuery(query, obra.getQtdEstoqueDisponivel(), obra.getCodigoObra());
    }
    
    public void delete(ObrasBEAN obra) {
        MySQLDAO.executeQuery("DELETE FROM OBRA WHERE codigoObra = ?", obra.getCodigoObra());
    }

    public ArrayList<ObrasBEAN> findAllObra() {
        return listaObras("SELECT obra.codigoObra, obra.titulo, obra.subtitulo, editora.nomeFantasia, cidade.nomeCidade,"
                + " obra.edicao, obra.ano, categoria.nomeCategoria, obra.situacao, obra.status, obra.codBarras, obra.qtdEstoqueTotal,"
                + " obra.qtdEstoqueDisponivel FROM obra INNER JOIN editora ON (editora.codigoEditora=obra.editora_codigoEditora)"
                + " INNER JOIN cidade ON (cidade.codigoCidade=obra.cidade_codigoCidade) INNER JOIN categoria"
                + " ON (categoria.codigoCategoria=obra.categoria_codigoCategoria) ORDER BY TITULO");
    }

    public ArrayList<ObrasBEAN> listaObras(String query) {
        ArrayList<ObrasBEAN> lista = new ArrayList<ObrasBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"), rs.getInt("edicao"), rs.getDate("ano"),
                rs.getString("situacao"), rs.getString("status"), rs.getString("codBarras"), rs.getInt("qtdEstoqueTotal"), rs.getInt("qtdEstoqueDisponivel"),
                rs.getString("nomeFantasia"), rs.getString("nomeCidade"), rs.getString("nomeCategoria")));
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
        rs = MySQLDAO.getResultSet("SELECT obra.codigoObra, obra.titulo, obra.subtitulo, editora.nomeFantasia, cidade.nomeCidade,"
                + " obra.edicao, obra.ano, categoria.nomeCategoria, obra.situacao, obra.status, obra.codBarras, obra.qtdEstoqueTotal,"
                + " obra.qtdEstoqueDisponivel FROM obra INNER JOIN editora ON (editora.codigoEditora=obra.editora_codigoEditora)"
                + " INNER JOIN cidade ON (cidade.codigoCidade=obra.cidade_codigoCidade) INNER JOIN categoria"
                + " ON (categoria.codigoCategoria=obra.categoria_codigoCategoria)WHERE codigoObra=?", codigoObra);
        try {
            if (rs.next()) {
                result = new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"), rs.getInt("edicao"), rs.getDate("ano"),
                rs.getString("situacao"), rs.getString("status"), rs.getString("codBarras"), rs.getInt("qtdEstoqueTotal"), rs.getInt("qtdEstoqueDisponivel"),
                rs.getString("nomeFantasia"), rs.getString("nomeCidade"), rs.getString("nomeCategoria"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public ObrasBEAN findObraBarras(String codBarras) {
        ObrasBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT obra.codigoObra, obra.titulo, obra.subtitulo, editora.nomeFantasia, cidade.nomeCidade,"
                + " obra.edicao, obra.ano, categoria.nomeCategoria, obra.situacao, obra.status, obra.codBarras, obra.qtdEstoqueTotal,"
                + " obra.qtdEstoqueDisponivel FROM obra INNER JOIN editora ON (editora.codigoEditora=obra.editora_codigoEditora)"
                + " INNER JOIN cidade ON (cidade.codigoCidade=obra.cidade_codigoCidade) INNER JOIN categoria"
                + " ON (categoria.codigoCategoria=obra.categoria_codigoCategoria)WHERE codBarras=?", codBarras);
        try {
            if (rs.next()) {
                result = new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"), rs.getInt("edicao"), rs.getDate("ano"),
                rs.getString("situacao"), rs.getString("status"), rs.getString("codBarras"), rs.getInt("qtdEstoqueTotal"), rs.getInt("qtdEstoqueDisponivel"),
                rs.getString("nomeFantasia"), rs.getString("nomeCidade"), rs.getString("nomeCategoria"));
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
        rs = MySQLDAO.getResultSet("SELECT obra.codigoObra, obra.titulo, obra.subtitulo, editora.nomeFantasia, cidade.nomeCidade,"
                + " obra.edicao, obra.ano, categoria.nomeCategoria, obra.situacao, obra.status, obra.codBarras, obra.qtdEstoqueTotal,"
                + " obra.qtdEstoqueDisponivel FROM obra INNER JOIN editora ON (editora.codigoEditora=obra.editora_codigoEditora)"
                + " INNER JOIN cidade ON (cidade.codigoCidade=obra.cidade_codigoCidade) INNER JOIN categoria"
                + " ON (categoria.codigoCategoria=obra.categoria_codigoCategoria) WHERE titulo like ?", "%" +titulo+ "%");
        try {
            while (rs.next()) {
                lista.add(new ObrasBEAN(rs.getInt("codigoObra"), rs.getString("titulo"),rs.getString("subtitulo"), rs.getInt("edicao"), rs.getDate("ano"),
                rs.getString("situacao"), rs.getString("status"), rs.getString("codBarras"), rs.getInt("qtdEstoqueTotal"), rs.getInt("qtdEstoqueDisponivel"),
                rs.getString("nomeFantasia"), rs.getString("nomeCidade"), rs.getString("nomeCategoria")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    public ObrasBEAN findObraAutor (int codigoObra) {
        ObrasBEAN result = null;
         
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT obra.titulo, obra.subtitulo,autor.nome,obra.edicao FROM obra INNER JOIN aux_autor_obra ON (aux_autor_obra.codigoObra = obra.codigoObra) INNER JOIN autor ON (autor.codigoAutor = aux_autor_obra.codigoAutor) WHERE obra.codigoObra=?", codigoObra);
        try {
            while (rs.next()) {
                result = new ObrasBEAN(rs.getString("titulo"),rs.getString("subtitulo"),rs.getString("nome"), rs.getInt("edicao"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
