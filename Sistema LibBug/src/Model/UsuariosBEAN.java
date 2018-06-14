
package Model;

public class UsuariosBEAN {
    
    private int codigoUsuario;
    private int perfil;
    private String login;
    private String senha;
    private String nome;

    public UsuariosBEAN(int codigoUsuario, int perfil, String login, String senha, String nome) {
        this.codigoUsuario = codigoUsuario;
        this.perfil = perfil;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }

    public UsuariosBEAN(int perfil, String login, String senha, String nome) {
        this.perfil = perfil;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }
    
    public UsuariosBEAN(int codigoUsuario, int perfil, String nome) {
        this.codigoUsuario = codigoUsuario;
        this.perfil = perfil;
        this.nome = nome;
    }
    
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
