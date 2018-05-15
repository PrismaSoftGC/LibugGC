package Model;
public class ClientesBEAN {
    private int codigoCliente;
    private String nome;
    private String status;
    private String cpf;
    private int idade;
    private String email;

    public ClientesBEAN(int codigoCliente, String nome, String status, String cpf, int idade, String email) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.status = status;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
