package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class EmprestimoDAO {
    
    private static EmprestimoDAO instance;

    private EmprestimoDAO() {
        MySQLDAO.getConnection();
    }

    public static EmprestimoDAO getInstance() {
        if (instance == null) {
            instance = new EmprestimoDAO();
        }
        return instance;
    }
/*
    int codigoEmprestimo;
    int funcionario_codigoFuncionario;
    Date saida;
    int cliente_codigoCliente;
    Date devolucao;
    */
    public long create(EmprestimoBEAN emprestimo) {
        String query = "INSERT INTO EMPRESTIMO (funcionario_codigoFuncionario,saida, cliente_codigoCliente, devolucao) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query,emprestimo.getCodigoFuncionario() ,emprestimo.getSaida(), emprestimo.getCodigoCliente(), emprestimo.getDevolucao());
    }
    
    public void delete(EmprestimoBEAN emprestimo) {
        MySQLDAO.executeQuery("DELETE FROM EMPRETIMO WHERE codigoEmprestimo = ?", emprestimo.getCodigoEmprestimo());
    }

    public ArrayList<EmprestimoBEAN> findEmprestimoData(Date data) {
        ArrayList<EmprestimoBEAN> lista = new ArrayList<EmprestimoBEAN>();

        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM emprestimo WHERE devolucao = ?", data);
        try {
            while (rs.next()) {
                lista.add(new EmprestimoBEAN(rs.getInt("codigoEmprestimo"),rs.getInt("funcionario_codigoFuncionario") ,rs.getDate("saida"), rs.getInt("cliente_codigoCliente"), rs.getDate("devolucao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<EmprestimoBEAN> findEmprestimoCodigo(int codigoCliente) {
        ArrayList<EmprestimoBEAN> lista = new ArrayList<EmprestimoBEAN>();

        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM emprestimo WHERE codigoCliente = ?", codigoCliente);
        try {
            while (rs.next()) {
                lista.add(new EmprestimoBEAN(rs.getInt("codigoEmprestimo"), rs.getInt("funcionario_codigoFuncionario"), rs.getDate("saida"), rs.getInt("codigoCliente"), rs.getDate("devolucao")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public int findId(EmprestimoBEAN emprestimo) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EMPRESTIMO WHERE funcionario_codigoFuncionario= ? and saida= ? and cliente_codigoCliente= ? and devolucao =?",
           emprestimo.getCodigoFuncionario(),emprestimo.getSaida(), emprestimo.getCodigoCliente(), emprestimo.getDevolucao());
        try {
            if (rs.next()) {
                result = rs.getInt("codigoEmprestimo");
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
