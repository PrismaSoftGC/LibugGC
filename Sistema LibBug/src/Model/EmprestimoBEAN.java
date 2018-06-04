package Model;

import java.util.Date;

public class EmprestimoBEAN {
    
    int codigoEmprestimo;
    int funcionario_codigoFuncionario;
    Date saida;
    int cliente_codigoCliente;
    Date devolucao;

    public EmprestimoBEAN(int codigoEmprestimo,int funcionario_codigoFuncionario ,Date saida, int cliente_codigoCliente, Date devolucao) {
        this.codigoEmprestimo = codigoEmprestimo;
        this.saida = saida;
        this.cliente_codigoCliente = cliente_codigoCliente;
        this.devolucao = devolucao;
        this.funcionario_codigoFuncionario = funcionario_codigoFuncionario;
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
        return cliente_codigoCliente;
    }

    public void setCodigoCliente(int cliente_codigoCliente) {
        this.cliente_codigoCliente = cliente_codigoCliente;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public int getCodigoFuncionario() {
        return funcionario_codigoFuncionario;
    }

    public void setCodigoFuncionario(int funcionario_codigoFuncionario) {
        this.funcionario_codigoFuncionario = funcionario_codigoFuncionario;
    }
    
    
    
}
