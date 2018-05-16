
package Model;

public class CidadesBEAN {
    
    private int codigoCidade;
    private String nome;
    private int estado_codigoEstado;

    public CidadesBEAN(int codigoCidade, String nome, int estado_codigoEstado) {
        this.codigoCidade = codigoCidade;
        this.nome = nome;
        this.estado_codigoEstado = estado_codigoEstado;
    }

    public CidadesBEAN(String nome, int estado_codigoEstado) {
        this.nome = nome;
        this.estado_codigoEstado = estado_codigoEstado;
    }
    
    public CidadesBEAN(){
        
    }

    public int getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstado_codigoEstado() {
        return estado_codigoEstado;
    }

    public void setEstado_codigoEstado(int estado_codigoEstado) {
        this.estado_codigoEstado = estado_codigoEstado;
    }
    
}
