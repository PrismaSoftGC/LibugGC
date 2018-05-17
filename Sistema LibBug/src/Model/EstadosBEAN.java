
package Model;

public class EstadosBEAN {
    
    private int codigoEstado;
    private String nome;

    public EstadosBEAN(int codigoEstado, String nome) {
        this.codigoEstado = codigoEstado;
        this.nome = nome;
    }

    public EstadosBEAN(String nome) {
        this.nome = nome;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
