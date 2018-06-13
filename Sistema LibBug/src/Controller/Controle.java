package Controller;

import java.util.ArrayList;
import Model.AutoresBEAN;
import Model.AutoresDAO;
import Model.AuxAutorObraBEAN;
import Model.AuxAutorObraDAO;
import Model.AuxEmprestimoObraBEAN;
import Model.AuxEmprestimoObraDAO;
import Model.CategoriasBEAN;
import Model.CategoriasDAO;
import Model.CidadesBEAN;
import Model.CidadesDAO;
import Model.ClientesBEAN;
import Model.ClientesDAO;
import Model.EditorasBEAN;
import Model.EditorasDAO;
import Model.EmprestimoBEAN;
import Model.EmprestimoDAO;
import Model.EnderecosBEAN;
import Model.EnderecosDAO;
import Model.EstadosBEAN;
import Model.EstadosDAO;
import Model.ObrasBEAN;
import Model.ObrasDAO;
import Model.TelefonesBEAN;
import Model.TelefonesDAO;
import Model.UsuariosBEAN;
import Model.UsuariosDAO;
import java.sql.Date;


public class Controle {
    
    public Controle(){    
    }
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela autor.
    
    public void addAutor(AutoresBEAN autor) {
        AutoresDAO.getInstance().create(autor);
    }

    public void updateAutor(AutoresBEAN autor) {
        AutoresDAO.getInstance().update(autor);
    }

    public void deleteAutor(AutoresBEAN autor) {
        AutoresDAO.getInstance().delete(autor);
    }

    public AutoresBEAN findAutorCodigo(int codigo) {
        return AutoresDAO.getInstance().findAutorCodigo(codigo);
    }
    
    public ArrayList<AutoresBEAN> findAutorNome(String nome) {
        return AutoresDAO.getInstance().findAutorNome(nome);
    }
     
    public int findAutor(AutoresBEAN autor) {
        return AutoresDAO.getInstance().findId(autor);
    }

    public Boolean isExistAutor(int id) {
        return AutoresDAO.getInstance().isExist(id);
    }

    public ArrayList<AutoresBEAN> listaAutores() {
        return AutoresDAO.getInstance().findAllAutor();
    }
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela cliente.
    
    
     public void addCliente(ClientesBEAN cliente) {
        ClientesDAO.getInstance().create(cliente);
    }

    public void updateCliente(ClientesBEAN cliente) {
        ClientesDAO.getInstance().update(cliente);
    }
    
    public void deleteCliente(ClientesBEAN cliente) {
        ClientesDAO.getInstance().delete(cliente);
    }

    public ClientesBEAN findClienteCodigo(int id) {
        return ClientesDAO.getInstance().findClienteCodigo(id);
    }
    
     public ClientesBEAN findClienteCpf(long cpf) {
        return ClientesDAO.getInstance().findClienteCpf(cpf);
    }
    
    public ArrayList<ClientesBEAN> findClienteNome(String nomeCliente) {
        return ClientesDAO.getInstance().findClienteNome(nomeCliente);
    }
     
    public int findCliente(ClientesBEAN cliente) {
        return ClientesDAO.getInstance().findId(cliente);
    }

    public Boolean isExistCliente(int id) {
        return ClientesDAO.getInstance().isExist(id);
    }

    public ArrayList<ClientesBEAN> listaClientes() {
        return ClientesDAO.getInstance().findAllCliente();
    }

    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela categoria.


    public CategoriasBEAN findCategoriaCodigo(int id) {
        return CategoriasDAO.getInstance().findCategoriaCodigo(id);
    }
    
    public ArrayList<CategoriasBEAN> findCategoriaNome(String nomeCategoria) {
        return CategoriasDAO.getInstance().findCategoriaNome(nomeCategoria);
    }
     
    public int findCategoria(CategoriasBEAN categoria) {
        return CategoriasDAO.getInstance().findId(categoria);
    }

    public Boolean isExistCategoria(int id) {
        return CategoriasDAO.getInstance().isExist(id);
    }

    public ArrayList<CategoriasBEAN> listaCategorias() {
        return CategoriasDAO.getInstance().findAllCategoria();
    }
    
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela cidade.
    
    

    public CidadesBEAN findCidadeCodigo(int id) {
        return CidadesDAO.getInstance().findCidadeCodigo(id);
    }
    
    public ArrayList<CidadesBEAN> findCidadeNome(String nomeCidade) {
        return CidadesDAO.getInstance().findCidadeNome(nomeCidade);
    }
     
    public int findCidade(CidadesBEAN cidade) {
        return CidadesDAO.getInstance().findId(cidade);
    }

    public Boolean isExistCidade(int id) {
        return CidadesDAO.getInstance().isExist(id);
    }

    public ArrayList<CidadesBEAN> listaCidades() {
        return CidadesDAO.getInstance().findAllCidade();
    }
    
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela endereco.
    
    
    public void addEndereco(EnderecosBEAN endereco) {
        EnderecosDAO.getInstance().create(endereco);
    }

    public void updateEndereco(EnderecosBEAN endereco) {
        EnderecosDAO.getInstance().update(endereco);
    }
    
    public void deleteEndereco(EnderecosBEAN endereco) {
        EnderecosDAO.getInstance().delete(endereco);
    }

    public EnderecosBEAN findEnderecoCodigo(int id) {
        return EnderecosDAO.getInstance().findEnderecoCodigo(id);
    }
    
    public ArrayList<EnderecosBEAN> findEnderecoRua(String ruaEndereco) {
        return EnderecosDAO.getInstance().findEnderecoRua(ruaEndereco);
    }
     
    public int findEndereco(EnderecosBEAN endereco) {
        return EnderecosDAO.getInstance().findId(endereco);
    }

    public Boolean isExistEndereco(int id) {
        return EnderecosDAO.getInstance().isExist(id);
    }

    public ArrayList<EnderecosBEAN> listaEnderecos() {
        return EnderecosDAO.getInstance().findAllEndereco();
    }
    
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela estado.
    

    public EstadosBEAN findEstadoCodigo(int id) {
        return EstadosDAO.getInstance().findEstadoCodigo(id);
    }
    
    public ArrayList<EstadosBEAN> findEstadoNome(String nomeEstado) {
        return EstadosDAO.getInstance().findEstadoNome(nomeEstado);
    }
     
    public int findEstado(EstadosBEAN estado) {
        return EstadosDAO.getInstance().findId(estado);
    }

    public Boolean isExistEstado(int id) {
        return EstadosDAO.getInstance().isExist(id);
    }

    public ArrayList<EstadosBEAN> listaEstados() {
        return EstadosDAO.getInstance().findAllEstado();
    }
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela telefone.
    
    
    public void addTelefone(TelefonesBEAN telefone) {
        TelefonesDAO.getInstance().create(telefone);
    }

    public void updateTelefone(TelefonesBEAN telefone) {
        TelefonesDAO.getInstance().update(telefone);
    }
    
    public void deleteTelefone(TelefonesBEAN telefone) {
        TelefonesDAO.getInstance().delete(telefone);
    }

    public TelefonesBEAN findTelefoneCodigo(int id) {
        return TelefonesDAO.getInstance().findTelefoneCodigo(id);
    }

    public ArrayList<TelefonesBEAN> findTelefoneNumero(int numeroTelefone) {
        return TelefonesDAO.getInstance().findTelefoneNumero(numeroTelefone);
    }
     
    public int findTelefone(TelefonesBEAN telefone) {
        return TelefonesDAO.getInstance().findId(telefone);
    }

    public Boolean isExistTelefone(int id) {
        return TelefonesDAO.getInstance().isExist(id);
    }

    public ArrayList<TelefonesBEAN> listaTelefones() {
        return TelefonesDAO.getInstance().findAllTelefone();
    }
    
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela usuario.
    
    
    public void addUsuario(UsuariosBEAN usuario) {
        UsuariosDAO.getInstance().create(usuario);
    }

    public void updateUsuario(UsuariosBEAN usuario) {
        UsuariosDAO.getInstance().update(usuario);
    }
    
    public void deleteUsuario(UsuariosBEAN usuario) {
        UsuariosDAO.getInstance().delete(usuario);
    }

    public UsuariosBEAN findUsuarioCodigo(int id) {
        return UsuariosDAO.getInstance().findUsuarioCodigo(id);
    }

    public ArrayList<UsuariosBEAN> findUsuarioNome(String nomeUsuario) {
        return UsuariosDAO.getInstance().findUsuarioNome(nomeUsuario);
    }
     
    public int findUsuario(UsuariosBEAN usuario) {
        return UsuariosDAO.getInstance().findId(usuario);
    }

    public ArrayList<UsuariosBEAN> listaUsuarios() {
        return UsuariosDAO.getInstance().findAllUsuario();
    }
    
    public boolean autenticUser(String login, String senha){
        return UsuariosDAO.getInstance().autenticaUsuario(login, senha);
    }
    
    public boolean autenticAdmin(String login, String senha, int perfil){
        return UsuariosDAO.getInstance().autenticaAdministrador(login, senha, perfil);
    }
    
     public boolean isExistUser(String login){
        return UsuariosDAO.getInstance().isExistUser(login);
    }
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela editora.
    
    public void addEditora(EditorasBEAN editora) {
        EditorasDAO.getInstance().create(editora);
    }

    public void updateEditora(EditorasBEAN editora) {
        EditorasDAO.getInstance().update(editora);
    }
    
    public void deleteEditora(EditorasBEAN editora) {
        EditorasDAO.getInstance().delete(editora);
    }

    public EditorasBEAN findEditoraCodigo(int codigo) {
        return EditorasDAO.getInstance().findEditoraCodigo(codigo);
    }
    
     
    public ArrayList<EditorasBEAN> findEditoraNome(String nomeEditora) {
        return EditorasDAO.getInstance().findEditoraNome(nomeEditora);
    }
    
    public int findEditora(EditorasBEAN editora) {
        return EditorasDAO.getInstance().findId(editora);
    }

    public Boolean isExistEditora(int id) {
        return EditorasDAO.getInstance().isExist(id);
    }

    public ArrayList<EditorasBEAN> listaEditoras() {
        return EditorasDAO.getInstance().findAllEditora();
    }

   //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela obra.
    
    public void addObra(ObrasBEAN obra) {
        ObrasDAO.getInstance().create(obra);
    }

    public void updateObra(ObrasBEAN obra) {
        ObrasDAO.getInstance().update(obra);
    }
    
    public void updateObraStatus(ObrasBEAN obra) {
        ObrasDAO.getInstance().updateStatus(obra);
    }
    
    public void updateObraEstoque(ObrasBEAN obra){
        ObrasDAO.getInstance().updateEstoque(obra);
    }
    
    public void deleteObra(ObrasBEAN obra) {
        ObrasDAO.getInstance().delete(obra);
    }

    public ObrasBEAN findObraCodigo(int codigo) {
        return ObrasDAO.getInstance().findObraCodigo(codigo);
    }
    
    public ArrayList<ObrasBEAN> findObraTitulo(String titulo) {
        return ObrasDAO.getInstance().findObraTitulo(titulo);
    }
    
    public int findObra(ObrasBEAN obra) {
        return ObrasDAO.getInstance().findId(obra);
    }

    public Boolean isExistObra(int id) {
        return ObrasDAO.getInstance().isExist(id);
    }

    public ArrayList<ObrasBEAN> listaObras() {
        return ObrasDAO.getInstance().findAllObra();
    }
    
    public int ultimoId(){
        return ObrasDAO.getInstance().LastId();
    }
    
    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela aux_autor_obra.
    
    public void addAuxObra(AuxAutorObraBEAN aux) {
        AuxAutorObraDAO.getInstance().create(aux);
    }

    public void updateAuxObra(AuxAutorObraBEAN aux) {
        AuxAutorObraDAO.getInstance().update(aux);
    }
    
    public void deleteAuxObra(AuxAutorObraBEAN aux) {
        AuxAutorObraDAO.getInstance().delete(aux);
    }

    public ArrayList<AuxAutorObraBEAN> listaAux(int codigoObra) {
        return AuxAutorObraDAO.getInstance().findAllAux(codigoObra);
    }

    //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela emprestimo.
    
    public void addEmprestimo(EmprestimoBEAN emprestimo) {
        EmprestimoDAO.getInstance().create(emprestimo);
    }
    
    public int findEmprestimo(EmprestimoBEAN emprestimo) {
        return EmprestimoDAO.getInstance().findId(emprestimo);
    }
    
    public ArrayList<EmprestimoBEAN> findEmprestimoData(Date data) {
        return EmprestimoDAO.getInstance().findEmprestimoData(data);
    }
    
    public ArrayList<EmprestimoBEAN> findEmprestimoCodigo(int id) {
        return EmprestimoDAO.getInstance().findEmprestimoCodigo(id);
    }
    

     //*****************************************************************
    // Abaixo estão os métodos controladores referentes a tabela aux_emprestimo_obra.
    
    public void addAuxEmprestimoObra(AuxEmprestimoObraBEAN aux) {
        AuxEmprestimoObraDAO.getInstance().create(aux);
    }
    
    public void deleteAuxEmprestimo(int codigo) {
        AuxEmprestimoObraDAO.getInstance().delete(codigo);
    }

    public ArrayList<AuxEmprestimoObraBEAN> listaAuxEmprestimo(int codigoEmprestimo) {
        return AuxEmprestimoObraDAO.getInstance().findAllAux2(codigoEmprestimo);
    }
    
}
