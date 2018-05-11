package Model;

import java.util.Date;

public class AuxEmprestimoObraBEAN {
    int codigoEmprestimo;
    int codigoObra;
    Date chegada;
    
    public AuxEmprestimoObraBEAN(int codigoEmprestimo, int codigoObra, Date chegada){
        this.codigoEmprestimo = codigoEmprestimo;
        this.codigoObra = codigoObra;
        this.chegada = chegada;
    }
    
    public AuxEmprestimoObraBEAN(){
        
    }

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public int getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(int codigoObra) {
        this.codigoObra = codigoObra;
    }

    public Date getChegada() {
        return chegada;
    }

    public void setChegada(Date chegada) {
        this.chegada = chegada;
    }

    
}
