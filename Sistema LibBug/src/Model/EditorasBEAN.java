package Model;

public class EditorasBEAN {
    private int codigoEditora;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String status;

    public EditorasBEAN(int codigoEditora, String nomeFantasia, String razaoSocial, String cnpj, String status) {
        this.codigoEditora = codigoEditora;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.status = status;
    }

    public EditorasBEAN(){
        
    }
    
    public int getCodigoEditora() {
        return codigoEditora;
    }

    public void setCodigoEditora(int codigoEditora) {
        this.codigoEditora = codigoEditora;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
}
