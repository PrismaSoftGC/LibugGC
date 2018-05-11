package Model;

public class ObrasBEAN {
   private int codigoObra;
   private String titulo;
   private int codigoEditora;
   private int edicao;
   private String situacao;
   private String status;

    public ObrasBEAN(int codigoObra, String titulo, int codigoEditora, int edicao, String situacao, String status) {
        this.codigoObra = codigoObra;
        this.titulo = titulo;
        this.codigoEditora = codigoEditora;
        this.edicao = edicao;
        this.situacao = situacao;
        this.status = status;
    }
    
    public ObrasBEAN(){
        
    }

    public int getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(int codigoObra) {
        this.codigoObra = codigoObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigoEditora() {
        return codigoEditora;
    }

    public void setCodigoEditora(int codigoEditora) {
        this.codigoEditora = codigoEditora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
   

}
