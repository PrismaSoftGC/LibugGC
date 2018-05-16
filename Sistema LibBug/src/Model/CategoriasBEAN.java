
package Model;

public class CategoriasBEAN {
    
    private int codigoCategoria;
    private String nome;

    public CategoriasBEAN(int codigoCategoria, String nome) {
        this.codigoCategoria = codigoCategoria;
        this.nome = nome;
    }
    
    public CategoriasBEAN(String nome) {
        this.nome = nome;
    }
    
    public CategoriasBEAN(){
        
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
