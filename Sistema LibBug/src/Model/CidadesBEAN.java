
package Model;

public class CidadesBEAN {
    
    private int codigoCidade;
    private String nome;

    public CidadesBEAN(int codigoCidade, String nome) {
        this.codigoCidade = codigoCidade;
        this.nome = nome;
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

    
}
