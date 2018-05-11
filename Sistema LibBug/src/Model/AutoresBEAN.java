package Model;

public class AutoresBEAN {
    private int codigoAutor;
    private String nome;
    private String status;
    private String conteudo;
    private String cpf;

    public AutoresBEAN(int codigoAutor, String nome, String status, String conteudo, String cpf) {
        this.codigoAutor = codigoAutor;
        this.nome = nome;
        this.status = status;
        this.conteudo = conteudo;
        this.cpf = cpf;
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
