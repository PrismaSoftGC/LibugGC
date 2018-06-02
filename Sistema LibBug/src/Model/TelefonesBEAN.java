
package Model;

public class TelefonesBEAN {
    
    private int ddd;
    private int numero;
    private int codigoTelefone;
    private int cliente_codigoCliente;
    private int editora_codigoEditora;

    public TelefonesBEAN(int ddd, int numero, int codigoTelefone, int cliente_codigoCliente, int editora_codigoEditora) {
        this.ddd = ddd;
        this.numero = numero;
        this.codigoTelefone = codigoTelefone;
        this.cliente_codigoCliente = cliente_codigoCliente;
        this.editora_codigoEditora = editora_codigoEditora;
    }

    public TelefonesBEAN(int ddd, int numero, int cliente_codigoCliente, int editora_codigoEditora) {
        this.ddd = ddd;
        this.numero = numero;
        this.cliente_codigoCliente = cliente_codigoCliente;
        this.editora_codigoEditora = editora_codigoEditora;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(int codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public int getCliente_codigoCliente() {
        return cliente_codigoCliente;
    }

    public void setCliente_codigoCliente(int cliente_codigoCliente) {
        this.cliente_codigoCliente = cliente_codigoCliente;
    }

    public int getEditora_codigoEditora() {
        return editora_codigoEditora;
    }

    public void setEditora_codigoEditora(int editora_codigoEditora) {
        this.editora_codigoEditora = editora_codigoEditora;
    }
    
}
