package Controller;

import java.util.ArrayList;
import Model.AutoresBEAN;
import Model.AutoresDAO;
import Model.AuxAutorObraBEAN;
import Model.AuxAutorObraDAO;
import Model.AuxEmprestimoObraBEAN;
import Model.AuxEmprestimoObraDAO;
import Model.ClientesBEAN;
import Model.ClientesDAO;
import Model.EditorasBEAN;
import Model.EditorasDAO;
import Model.EmprestimoBEAN;
import Model.EmprestimoDAO;
import Model.ObrasBEAN;
import Model.ObrasDAO;
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
