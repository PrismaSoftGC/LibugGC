package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmprestimoBEAN {
    int codigoEmprestimo;
    Date saida;
    int codigoCliente;
    Date devolucao;

    public EmprestimoBEAN(int codigoEmprestimo, Date saida, int codigoCliente, Date devolucao) {
        this.codigoEmprestimo = codigoEmprestimo;
        this.saida = saida;
        this.codigoCliente = codigoCliente;
        this.devolucao = devolucao;
    }

    public EmprestimoBEAN(){
        
    }

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
    
    
    
}
