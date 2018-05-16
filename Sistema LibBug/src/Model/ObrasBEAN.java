package Model;

import java.util.Date;

public class ObrasBEAN {
   
   private int codigoObra;
   private String titulo;
   private String subtitulo;
   private int codigoEditora; 
   private int codigoCidade;
   private int edicao;
   private Date ano;
   private int codigoCategoria;
   private String situacao;
   private String status;
   private String codBarras;
   private int qtdEstoqueTotal;
   private int qtdEstoqueDisponivel;

    public ObrasBEAN(int codigoObra, String titulo, String subititulo, int codigoEditora, int codigoCidade, int edicao, Date ano, int codigoCategoria, String situacao, String status, String codBarras, int qtdEstoqueTotal, int qtdEstoqueDisponivel) {
        this.codigoObra = codigoObra;
        this.titulo = titulo;
        this.subtitulo = subititulo;
        this.codigoEditora = codigoEditora;
        this.codigoCidade = codigoCidade;
        this.edicao = edicao;
        this.ano = ano;
        this.codigoCategoria = codigoCategoria;
        this.situacao = situacao;
        this.status = status;
        this.codBarras = codBarras;
        this.qtdEstoqueTotal = qtdEstoqueTotal;
        this.qtdEstoqueDisponivel = qtdEstoqueDisponivel;
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

    public String getSubititulo() {
        return subtitulo;
    }

    public void setSubititulo(String subititulo) {
        this.subtitulo = subititulo;
    }

    public int getCodigoEditora() {
        return codigoEditora;
    }

    public void setCodigoEditora(int codigoEditora) {
        this.codigoEditora = codigoEditora;
    }

    public int getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public int getQtdEstoqueTotal() {
        return qtdEstoqueTotal;
    }

    public void setQtdEstoqueTotal(int qtdEstoqueTotal) {
        this.qtdEstoqueTotal = qtdEstoqueTotal;
    }

    public int getQtdEstoqueDisponivel() {
        return qtdEstoqueDisponivel;
    }

    public void setQtdEstoqueDisponivel(int qtdEstoqueDisponivel) {
        this.qtdEstoqueDisponivel = qtdEstoqueDisponivel;
    }
   
   

}
