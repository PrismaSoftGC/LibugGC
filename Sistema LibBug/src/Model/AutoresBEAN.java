package Model;

public class AutoresBEAN {
    private int codigoAutor;
    private String nome;
    private String status;

    public AutoresBEAN(int codigoAutor, String nome, String status) {
        this.codigoAutor = codigoAutor;
        this.nome = nome;
        this.status = status;
    }

    public AutoresBEAN(){
        
    }

    public int getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(int codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
