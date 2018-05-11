package Model;
public class ClientesBEAN {
    private int codigoCliente;
    private String nome;
    private String status;
    private String cpf;
    private int idade;
    private String rua;
    private String bairro;
    private String complemento;
    private String cidade;

    public ClientesBEAN(int codigoCliente, String nome, String status, String cpf, int idade, String rua, String bairro, String complemento, String cidade) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.status = status;
        this.cpf = cpf;
        this.idade = idade;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
    }
    
    public ClientesBEAN(){
        
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    

}
