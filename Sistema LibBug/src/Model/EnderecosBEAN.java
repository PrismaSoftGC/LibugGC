
package Model;

public class EnderecosBEAN {
    
    private int codigoEndereco;
    private int editora_codigoEditora;
    private int cliente_codigoCliente;
    private int cidade_codigoCidade;
    private String rua;
    private String bairro;
    private String complemento;

    public EnderecosBEAN(int codigoEndereco, int editora_codigoEditora, int cliente_codigoCliente, int cidade_codigoCidade, String rua, String bairro, String complemento) {
        this.codigoEndereco = codigoEndereco;
        this.editora_codigoEditora = editora_codigoEditora;
        this.cliente_codigoCliente = cliente_codigoCliente;
        this.cidade_codigoCidade = cidade_codigoCidade;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public EnderecosBEAN(int editora_codigoEditora, int cliente_codigoCliente, int cidade_codigoCidade, String rua, String bairro, String complemento) {
        this.editora_codigoEditora = editora_codigoEditora;
        this.cliente_codigoCliente = cliente_codigoCliente;
        this.cidade_codigoCidade = cidade_codigoCidade;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public int getEditora_codigoEditora() {
        return editora_codigoEditora;
    }

    public void setEditora_codigoEditora(int editora_codigoEditora) {
        this.editora_codigoEditora = editora_codigoEditora;
    }

    public int getCliente_codigoCliente() {
        return cliente_codigoCliente;
    }

    public void setCliente_codigoCliente(int cliente_codigoCliente) {
        this.cliente_codigoCliente = cliente_codigoCliente;
    }

    public int getCidade_codigoCidade() {
        return cidade_codigoCidade;
    }

    public void setCidade_codigoCidade(int cidade_codigoCidade) {
        this.cidade_codigoCidade = cidade_codigoCidade;
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
    
}
