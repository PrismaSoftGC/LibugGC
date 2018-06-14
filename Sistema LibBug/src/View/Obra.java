package View;

import Controller.Controle;
import Model.AutoresBEAN;
import Model.AuxAutorObraBEAN;
import Model.CategoriasBEAN;
import Model.CidadesBEAN;
import Model.EditorasBEAN;
import Model.ObrasBEAN;
import Model.UsuariosBEAN;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Obra extends javax.swing.JDialog {

    static Controle controle = new Controle();
    private javax.swing.table.DefaultTableModel modelo1; 
    private javax.swing.table.DefaultTableModel modelo2;
    private javax.swing.table.DefaultTableModel modelo3;
    private javax.swing.table.DefaultTableModel modelo4;
    private UsuariosBEAN usuario = null;
    int cont,contador=0;
    
    public Obra(UsuariosBEAN usuario) {
        this.usuario = usuario;
        initComponents();
        
        if (usuario.getPerfil() == 0) {
            comboboxStatus.setVisible(false);
            labelStatus.setVisible(false);
        }
        textEstoqueDisponivel.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
        textCodigo.setEditable(false);
        tabelaObra.setVisible(false);
        tabelaAutores.setVisible(false);
        comboEditora();
        comboCategoria();
        comboCidade();
        Desabilita();
        botao();
        
        Date datando = new Date();
        calendarioAno.setDate(datando);
    }
    
    public void Desabilita(){
        textTitulo.setEditable(false);
        cbEditora1.setEnabled(false);
        textEdicao.setEditable(false);
        cbSituacao.setEnabled(false);
        comboboxStatus.setEnabled(false);
        cbEditora1.setEnabled(false);
        cbCidade.setEnabled(false);
        cbCategoria.setEnabled(false);
        textSubtitulo.setEditable(false);
        calendarioAno.setEnabled(false);
        textBarras.setEditable(false);
        textEstoqueTotal.setEditable(false);
        textEstoqueDisponivel.setEditable(false);
        TabelaDestino.setVisible(false);
        tabelaObra.setVisible(false);
        tabelaAutores.setVisible(false);
        btnBuscaAutor.setEnabled(false);
        btnRemover.setEnabled(false);
        textAutor.setEditable(false);
    }

    public void Habilita(){
        textTitulo.setEditable(true);
        cbEditora1.setEnabled(true);
        textEdicao.setEditable(true);
        cbSituacao.setEnabled(true);
        cbCidade.setEnabled(true);
        cbCategoria.setEnabled(true);
        textSubtitulo.setEditable(true);
        calendarioAno.setEnabled(true);
        textBarras.setEditable(true);
        textEstoqueTotal.setEditable(true);
        textEstoqueDisponivel.setEditable(true);
        comboboxStatus.setEnabled(true);
        TabelaDestino.setVisible(true);
        tabelaObra.setVisible(true);
        tabelaAutores.setVisible(true);
        btnBuscaAutor.setEnabled(true);
        btnRemover.setEnabled(true);
        textAutor.setEditable(true);
    }
    
    public void Limpar(){
        textCodigo.setText("");
        textTitulo.setText("");
        cbEditora1.setSelectedIndex(0);
        cbCidade.setSelectedIndex(0);
        cbCategoria.setSelectedIndex(0);
        textEdicao.setText("");
        textSubtitulo.setText("");
        textEstoqueTotal.setText("");
        textEstoqueDisponivel.setText("");
        textBarras.setText("");
        cbSituacao.setSelectedIndex(0);
        comboboxStatus.setSelectedIndex(0);
        modelo2 = (javax.swing.table.DefaultTableModel)TabelaDestino.getModel();
        modelo2.setNumRows(0);
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaAutores.getModel();
        modelo4.setNumRows(0);
        TabelaDestino.setVisible(true);
    }
    
     public void botao(){
        //botao novo
        botaoNovo.setBorderPainted( false );
        botaoNovo.setContentAreaFilled( false );
        botaoNovo.setFocusPainted( false );
        
        // botao salvar
        botaoSalvar.setBorderPainted( false );
        botaoSalvar.setContentAreaFilled( false );
        botaoSalvar.setFocusPainted( false );
        
        // botao cancelar
        botaoCancelar.setBorderPainted( false );
        botaoCancelar.setContentAreaFilled( false );
        botaoCancelar.setFocusPainted( false );
    }
    
    public void comboEditora(){
        ArrayList<EditorasBEAN> listaEditoras = controle.listaEditoras();
        
        try {
            for (EditorasBEAN editora : listaEditoras) {
                if(editora.getStatus().equals("Ativado"))
                cbEditora1.addItem(editora.getNomeFantasia());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    public void comboCategoria(){
        ArrayList<CategoriasBEAN> listaCategorias = controle.listaCategorias();
        
        try {
            for (CategoriasBEAN cat : listaCategorias) {
                 cbCategoria.addItem(cat.getNome());
            }  
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    public void comboCidade(){
        ArrayList<CidadesBEAN> listaCidades = controle.listaCidades();
        
        try {
            for (CidadesBEAN cida : listaCidades) {
                 cbCidade.addItem(cida.getNome());
            }  
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    int cont2=0;
     
    public void preencher_tabela(AutoresBEAN autor) {
       
        modelo2 = (javax.swing.table.DefaultTableModel)TabelaDestino.getModel();
      //  modelo2.setNumRows(cont2);

        try {
            modelo2.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome()});
         //   cont2++;
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
     
     public void preencher_tabela(ObrasBEAN obra, String nomeEditora){
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);

        try {
            modelo3.addRow(new Object[]{obra.getCodigoObra(), obra.getTitulo(), obra.getSubititulo(), nomeEditora,
                obra.getEdicao(), obra.getQtdEstoqueTotal(), obra.getQtdEstoqueDisponivel(),obra.getSituacao(), obra.getStatus()});
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
     
      public void preencher_tabela(ArrayList<AutoresBEAN> listaAutores){
       // modelo1 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo1.setNumRows(0);

        try {
            for (AutoresBEAN autor : listaAutores) {
                if(autor.getStatus().equals("Ativado"))
                modelo1.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
  
     public void preencher_tabela2(ArrayList<ObrasBEAN> listaObras, ArrayList<EditorasBEAN> listaEditoras){
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);

        try {
            for (int i=0; i<listaObras.size();i++) {
                modelo3.addRow(new Object[]{listaObras.get(i).getCodigoObra(), listaObras.get(i).getTitulo(),listaObras.get(i).getSubititulo(),
                    listaEditoras.get(i).getNomeFantasia(), listaObras.get(i).getEdicao(), listaObras.get(i).getQtdEstoqueTotal(), 
                    listaObras.get(i).getQtdEstoqueDisponivel(), listaObras.get(i).getSituacao(), listaObras.get(i).getStatus()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
     
      public void AutoresSelecionados(ArrayList<AuxAutorObraBEAN> listaAux){
        AutoresBEAN autor = new AutoresBEAN();
        
        for (int i = 0; i < listaAux.size(); i++) {
                autor = controle.findAutorCodigo(listaAux.get(i).getCodigoAutor());

                modelo4 = (javax.swing.table.DefaultTableModel) tabelaAutores.getModel();

                modelo4.setNumRows(contador);

                modelo4.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome()});
                contador++;
            }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        labelEditora = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textBuscaNome = new javax.swing.JTextField();
        botaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaObra = new javax.swing.JTable();
        textBuscaCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelTitulo2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaAutores = new javax.swing.JTable();
        labelAutores1 = new javax.swing.JLabel();
        botaoListar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        labelEdicao = new javax.swing.JLabel();
        textEdicao = new javax.swing.JTextField();
        comboboxStatus = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        labelEdit = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox<>();
        cbSituacao = new javax.swing.JComboBox<>();
        labelSitu = new javax.swing.JLabel();
        textAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscaAutor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaDestino = new javax.swing.JTable();
        labelAutor = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        textSubtitulo = new javax.swing.JTextField();
        labelSubtitulo = new javax.swing.JLabel();
        labelCidade = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        labelCategoria = new javax.swing.JLabel();
        textBarras = new javax.swing.JTextField();
        labelBarras = new javax.swing.JLabel();
        textEstoqueTotal = new javax.swing.JTextField();
        labelEstoqueTotal = new javax.swing.JLabel();
        textEstoqueDisponivel = new javax.swing.JTextField();
        labelEstoqueDisponivel = new javax.swing.JLabel();
        calendarioAno = new com.toedter.calendar.JDateChooser();
        cbEditora1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEditora.setBackground(new java.awt.Color(0, 0, 0));
        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setText("Obra");
        getContentPane().add(labelEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 11, -1, -1));

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Cancel_icon-icons.com_73703.png"))); // NOI18N
        botaoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoCancelarMouseExited(evt);
            }
        });
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 34, 50, 50));

        botaoNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/new_page_document_16676 (1).png"))); // NOI18N
        botaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoNovoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoNovoMouseReleased(evt);
            }
        });
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 34, 50, 50));

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Save_37110 (1).png"))); // NOI18N
        botaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoSalvarMouseExited(evt);
            }
        });
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 34, 50, 50));

        jPanel1.setLayout(null);

        textBuscaNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textBuscaNomeFocusLost(evt);
            }
        });
        textBuscaNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textBuscaNomeMouseClicked(evt);
            }
        });
        textBuscaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscaNomeActionPerformed(evt);
            }
        });
        textBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscaNomeKeyTyped(evt);
            }
        });
        jPanel1.add(textBuscaNome);
        textBuscaNome.setBounds(70, 30, 180, 30);

        botaoBusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/search-good_icon-icons.com_51027.png"))); // NOI18N
        botaoBusca.setText("Pesquisar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(botaoBusca);
        botaoBusca.setBounds(270, 30, 140, 30);

        tabelaObra.setBackground(new java.awt.Color(153, 204, 255));
        tabelaObra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Título", "Subtitulo", "Editora", "Edicao", "Estoque Total", "Estoque Disponível", "Situação", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaObra.setToolTipText("");
        tabelaObra.setColumnSelectionAllowed(true);
        tabelaObra.getTableHeader().setReorderingAllowed(false);
        tabelaObra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelaObraFocusLost(evt);
            }
        });
        tabelaObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaObraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaObraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaObra);
        tabelaObra.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabelaObra.getColumnModel().getColumnCount() > 0) {
            tabelaObra.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 920, 130);

        textBuscaCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textBuscaCodigoFocusLost(evt);
            }
        });
        textBuscaCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textBuscaCodigoMouseClicked(evt);
            }
        });
        textBuscaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscaCodigoActionPerformed(evt);
            }
        });
        textBuscaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscaCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(textBuscaCodigo);
        textBuscaCodigo.setBounds(10, 30, 50, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 50, 20);

        labelTitulo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTitulo2.setText("Titulo");
        jPanel1.add(labelTitulo2);
        labelTitulo2.setBounds(70, 10, 80, 20);

        tabelaAutores.setBackground(new java.awt.Color(153, 204, 255));
        tabelaAutores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Código", "Título"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAutores.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabelaAutores);

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(10, 280, 440, 100);

        labelAutores1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAutores1.setText("Autor(es) desta Obra");
        jPanel1.add(labelAutores1);
        labelAutores1.setBounds(160, 260, 170, 17);

        botaoListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/list_tasks_22372.png"))); // NOI18N
        botaoListar.setText("ListarTodos");
        botaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoListar);
        botaoListar.setBounds(430, 30, 150, 30);

        abas.addTab("Pesquisa", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTitulo.setText("Título*");
        jPanel3.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 20));
        jPanel3.add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        labelEdicao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEdicao.setText("Edicao");
        jPanel3.add(labelEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        textEdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEdicaoKeyTyped(evt);
            }
        });
        jPanel3.add(textEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 160, 30));

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));
        comboboxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxStatusActionPerformed(evt);
            }
        });
        jPanel3.add(comboboxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 110, 30));

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelStatus.setText("Status*");
        jPanel3.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        labelEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEdit.setText("Editora*");
        jPanel3.add(labelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 20));

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel3.add(cbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 30));

        cbSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prateleira", "Emprestado" }));
        jPanel3.add(cbSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        labelSitu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSitu.setText("Situacão*");
        jPanel3.add(labelSitu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        textAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAutorKeyPressed(evt);
            }
        });
        jPanel3.add(textAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Pesquise aqui o autor");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        btnBuscaAutor.setText("Buscar");
        btnBuscaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaAutorActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, 30));

        TabelaDestino.setBackground(new java.awt.Color(153, 204, 255));
        TabelaDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TabelaDestino);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 330, 112));

        labelAutor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAutor.setText("Autores Selecionados");
        jPanel3.add(labelAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel3.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));
        jPanel3.add(textSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 200, 30));

        labelSubtitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSubtitulo.setText("Subtitulo");
        jPanel3.add(labelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 20));

        labelCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCidade.setText("Cidade");
        jPanel3.add(labelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        labelAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelAno.setText("Ano*");
        jPanel3.add(labelAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 20));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel3.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 30));

        labelCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCategoria.setText("Categoria*");
        jPanel3.add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, 20));

        textBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBarrasKeyTyped(evt);
            }
        });
        jPanel3.add(textBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 160, 30));

        labelBarras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelBarras.setText("Cod. Barras");
        jPanel3.add(labelBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        textEstoqueTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textEstoqueTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEstoqueTotalKeyTyped(evt);
            }
        });
        jPanel3.add(textEstoqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 130, 30));

        labelEstoqueTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEstoqueTotal.setText("Estoque Total*");
        jPanel3.add(labelEstoqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        textEstoqueDisponivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEstoqueDisponivelKeyTyped(evt);
            }
        });
        jPanel3.add(textEstoqueDisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 160, 30));

        labelEstoqueDisponivel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEstoqueDisponivel.setText("Estoque Disponível*");
        jPanel3.add(labelEstoqueDisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 150, -1));
        jPanel3.add(calendarioAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 130, 30));

        cbEditora1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel3.add(cbEditora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 190, 30));

        abas.addTab("Cadastro / Edição", jPanel3);

        getContentPane().add(abas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 975, 517));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseEntered
        botaoCancelar.setBorderPainted( true );
        botaoCancelar.setContentAreaFilled( true );
        botaoCancelar.setFocusPainted( true );
    }//GEN-LAST:event_botaoCancelarMouseEntered

    private void botaoCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCancelarMouseExited
        botaoCancelar.setBorderPainted( false );
        botaoCancelar.setContentAreaFilled( false );
        botaoCancelar.setFocusPainted( false );
    }//GEN-LAST:event_botaoCancelarMouseExited

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        Limpar();
        Desabilita();
        botaoNovo.setEnabled(true);
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
        abas.setSelectedIndex(0);
        abas.setEnabled(true);
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaAutores.getModel();
        modelo4.setNumRows(0);

    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNovoMouseEntered
        botaoNovo.setOpaque(true);
        botaoNovo.setBorderPainted( true );
        botaoNovo.setContentAreaFilled( true );
        botaoNovo.setFocusPainted( true );
    }//GEN-LAST:event_botaoNovoMouseEntered

    private void botaoNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNovoMouseExited
        botaoNovo.setBorderPainted(false );
        botaoNovo.setContentAreaFilled( false );
        botaoNovo.setFocusPainted( false );
    }//GEN-LAST:event_botaoNovoMouseExited

    private void botaoNovoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoNovoMouseReleased

    }//GEN-LAST:event_botaoNovoMouseReleased

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        abas.setEnabled(false);

        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaAutores.getModel();
        modelo4.setNumRows(0);

        Habilita();
        botaoCancelar.setEnabled(true);
        botaoSalvar.setEnabled(true);

        abas.setSelectedIndex(1);
        botaoNovo.setEnabled(false);
        comboboxStatus.setEnabled(false);
        cbSituacao.setEnabled(false);

    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseEntered
        botaoSalvar.setBorderPainted( true );
        botaoSalvar.setContentAreaFilled( true );
        botaoSalvar.setFocusPainted( true );
    }//GEN-LAST:event_botaoSalvarMouseEntered

    private void botaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseExited
        botaoSalvar.setBorderPainted( false );
        botaoSalvar.setContentAreaFilled( false );
        botaoSalvar.setFocusPainted( false );
    }//GEN-LAST:event_botaoSalvarMouseExited

    public int BuscaEditora(String nome){
        ArrayList<EditorasBEAN> lista = new ArrayList<>();

        lista = controle.findEditoraNome(nome);
        int codigoEditora = 0;

        for (EditorasBEAN lis : lista) {
            if (lis.getNomeFantasia().equals(nome)) {
                codigoEditora = lis.getCodigoEditora();
            }
        }
        return codigoEditora;

    }
    
     public int BuscaCidade(String cidade){
        ArrayList<CidadesBEAN> lista = new ArrayList<>();

        lista = controle.findCidadeNome(cidade);
        int codigoCidade = 0;

        for (CidadesBEAN lis : lista) {
            if (lis.getNome().equals(cidade)) {
                codigoCidade = lis.getCodigoCidade();
            }
        }
        return codigoCidade;
    }
     
        public int BuscaCat(String cat){
        ArrayList<CategoriasBEAN> lista = new ArrayList<>();

        lista = controle.findCategoriaNome(cat);
        int codigoCategoria = 0;

        for (CategoriasBEAN lis : lista) {
            if (lis.getNome().equals(cat)) {
                codigoCategoria = lis.getCodigoCategoria();
            }
        }
        return codigoCategoria;
    }
    
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        modelo2 = (javax.swing.table.DefaultTableModel) TabelaDestino.getModel();
        int valor = TabelaDestino.getRowCount();
        
        Date datando2 = calendarioAno.getCalendar().getTime();
        
        if (textTitulo.getText().equals("") || cbEditora1.getSelectedItem().equals("Selecione")
                || cbCategoria.getSelectedItem().equals("Selecione") || textEstoqueTotal.getText().equals("") || 
                textEstoqueDisponivel.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha para prosseguir");
            
        } else {
                    try {
                        ObrasBEAN obra = new ObrasBEAN();
                        obra.setTitulo(textTitulo.getText());
                        obra.setSubititulo(textSubtitulo.getText());
                        
                        String nomeEd = (String) cbEditora1.getSelectedItem();
                        obra.setCodigoEditora(BuscaEditora(nomeEd));
                        
                        String nomeCid = (String) cbCidade.getSelectedItem();
                        obra.setCodigoCidade(BuscaCidade(nomeCid));
                        
                        int codigoEdicao = Integer.parseInt(textEdicao.getText());
                        obra.setEdicao(codigoEdicao);
                        
                    //    Date calend = calendarioAno.getCalendar().getTime();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                        String pesquisaData = sdf.format(datando2);

                        java.sql.Date data = new java.sql.Date(sdf.parse(pesquisaData).getTime());
                        obra.setAno(data);
                        
                        String categNome = (String) cbCategoria.getSelectedItem();
                        obra.setCodigoCategoria(BuscaCat(categNome));
                        
                        String situacao = (String) cbSituacao.getSelectedItem();
                        obra.setSituacao(situacao);
                        String status = (String) comboboxStatus.getSelectedItem();
                        obra.setStatus(status);
                        obra.setCodBarras(textBarras.getText());
                        int estoqueT = Integer.parseInt(textEstoqueTotal.getText());
                        obra.setQtdEstoqueTotal(estoqueT);
                        int estoqueD = Integer.parseInt(textEstoqueDisponivel.getText());
                        obra.setQtdEstoqueDisponivel(estoqueD);
                        
                        AuxAutorObraBEAN aux = new AuxAutorObraBEAN();

                        if (textCodigo.getText().equals("")) {

                            controle.addObra(obra);

                            int linhasCadastro = TabelaDestino.getRowCount();
                            int codigoObra = controle.findObra(obra);

                            for (int i = 0; i < linhasCadastro; i++) {
                                aux.setCodigoObra(codigoObra);
                                aux.setCodigoAutor((int) TabelaDestino.getValueAt(i, 0));

                                controle.addAuxObra(aux);
                            }
                            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                            Limpar();
                            Desabilita();
                            botaoSalvar.setEnabled(false);
                            botaoCancelar.setEnabled(false);
                            botaoNovo.setEnabled(true);
                            abas.setSelectedIndex(0);
                            abas.setEnabled(true);
                        } else {
                            if(Integer.parseInt(textEstoqueTotal.getText())<Integer.parseInt(textEstoqueDisponivel.getText())){
                                JOptionPane.showMessageDialog(null, "Valor total não pode ser menor que o disponivel");
                            }else{
                                int codigo = Integer.parseInt(textCodigo.getText());

                                obra.setCodigoObra(codigo);
                                controle.updateObra(obra);

                                int codigoObra = controle.findObra(obra);
                                int linhasAtualiza = TabelaDestino.getRowCount();

                                for (int i = 0; i < linhasAtualiza; i++) {
                                    aux.setCodigoObra(codigoObra);
                                    controle.deleteAuxObra(aux);
                                }

                                for (int i = 0; i < linhasAtualiza; i++) {
                                    aux.setCodigoObra(codigoObra);
                                    aux.setCodigoAutor((int) TabelaDestino.getValueAt(i, 0));
                                    controle.addAuxObra(aux);
                                }

                                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                                Limpar();
                                Desabilita();
                                botaoSalvar.setEnabled(false);
                                botaoCancelar.setEnabled(false);
                                botaoNovo.setEnabled(true);
                                abas.setSelectedIndex(0);
                                abas.setEnabled(true);
                            }
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
               

        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void textBuscaNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textBuscaNomeFocusLost
        textBuscaCodigo.setEnabled(true);
    }//GEN-LAST:event_textBuscaNomeFocusLost

    private void textBuscaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscaNomeMouseClicked
        textBuscaCodigo.setEnabled(false);
        textBuscaCodigo.setText("");
    }//GEN-LAST:event_textBuscaNomeMouseClicked

    private void textBuscaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscaNomeActionPerformed

    private void textBuscaNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaNomeKeyTyped
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaNomeKeyTyped

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaAutores.getModel();
        modelo4.setNumRows(0);

        EditorasBEAN editora = new EditorasBEAN();

        try {
            if (textBuscaCodigo.getText().length() > 0) {

                ObrasBEAN obra = new ObrasBEAN();

                int codigo = Integer.parseInt(textBuscaCodigo.getText());
                obra = controle.findObraCodigo(codigo);
                editora = controle.findEditoraCodigo(obra.getCodigoEditora());

                tabelaObra.setVisible(true);
                tabelaAutores.setVisible(true);

                preencher_tabela(obra, editora.getNomeFantasia());

                ArrayList<AuxAutorObraBEAN> listaAux = controle.listaAux(obra.getCodigoObra());
                AutoresSelecionados(listaAux);
                contador = 0;

            } else if (textBuscaNome.getText().length() > 0) {
                String nome = textBuscaNome.getText();
                ArrayList<ObrasBEAN> listaObras = new ArrayList<ObrasBEAN>();
                ArrayList<EditorasBEAN> listaEditoras = new ArrayList<EditorasBEAN>();

                listaObras = controle.findObraTitulo(nome);

                for(ObrasBEAN obras : listaObras){
                    editora = controle.findEditoraCodigo(obras.getCodigoEditora());
                    listaEditoras.add(editora);
                }

                tabelaObra.setVisible(true);
                tabelaAutores.setVisible(true);
                preencher_tabela2(listaObras, listaEditoras);

                int codigoObra = (int) tabelaObra.getValueAt(0, 0);

                ArrayList<AuxAutorObraBEAN> listaAux = controle.listaAux(codigoObra);
                AutoresSelecionados(listaAux);
                contador = 0;

            } else if ((textBuscaCodigo.getText().isEmpty() && textBuscaNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Digite algo para pesquisar!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Registro não encontrado");
        }
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void tabelaObraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaObraFocusLost

    }//GEN-LAST:event_tabelaObraFocusLost

    private void tabelaObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaObraMouseClicked
        if(evt.getClickCount() == 1){
            int linha = tabelaObra.getSelectedRow();
            int codigoObra = (int) tabelaObra.getValueAt(linha, 0);

            ArrayList<AuxAutorObraBEAN> listaAux = controle.listaAux(codigoObra);
            AutoresSelecionados(listaAux);
            contador = 0;
        }
        else if (evt.getClickCount() == 2) {

            botaoNovo.setEnabled(false);
            botaoCancelar.setEnabled(true);
            botaoSalvar.setEnabled(true);

            Habilita();
            modelo2 = (javax.swing.table.DefaultTableModel) TabelaDestino.getModel();

            abas.setSelectedIndex(1);
            textCodigo.setEditable(false);

            int linha = tabelaObra.getSelectedRow();
            int codigoObra = (int) tabelaObra.getValueAt(linha, 0);
            
            ObrasBEAN obra = controle.findObraCodigo(codigoObra);
            CidadesBEAN cidade = controle.findCidadeCodigo(obra.getCodigoCidade());
            CategoriasBEAN categoria = controle.findCategoriaCodigo(obra.getCodigoCategoria());
            
            Date anoObra = obra.getAno();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dataFormatada = sdf.format(anoObra);
                     

            textCodigo.setText(tabelaObra.getValueAt(linha, 0).toString());
            textTitulo.setText(tabelaObra.getValueAt(linha, 1).toString());
            textSubtitulo.setText(tabelaObra.getValueAt(linha, 2).toString());
            cbEditora1.setSelectedItem(tabelaObra.getValueAt(linha, 3));
            cbCidade.setSelectedItem(cidade.getNome());
            textEdicao.setText(tabelaObra.getValueAt(linha, 4).toString());
            try {
                java.sql.Date dataBrasil = new java.sql.Date(sdf.parse(dataFormatada).getTime());
                calendarioAno.setDate(dataBrasil);
            } catch (ParseException ex) {
                Logger.getLogger(Obra.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbCategoria.setSelectedItem(categoria.getNome());
            cbSituacao.setSelectedItem(tabelaObra.getValueAt(linha, 7));
            comboboxStatus.setSelectedItem(tabelaObra.getValueAt(linha, 8));
            textBarras.setText(obra.getCodBarras());
            textEstoqueTotal.setText(String.valueOf(obra.getQtdEstoqueTotal()));
            textEstoqueDisponivel.setText(String.valueOf(obra.getQtdEstoqueDisponivel()));
           
            int qtdLinhaAutores = tabelaAutores.getRowCount();

            modelo2.setNumRows(contador);

            for (int i = 0; i < qtdLinhaAutores; i++) {
                modelo2.addRow(new Object[]{tabelaAutores.getValueAt(i, 0), tabelaAutores.getValueAt(i, 1)});
            }

        }
    }//GEN-LAST:event_tabelaObraMouseClicked

    private void tabelaObraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaObraMousePressed

    }//GEN-LAST:event_tabelaObraMousePressed

    private void textBuscaCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textBuscaCodigoFocusLost
        // textBuscaCodigo.setText("");
        textBuscaNome.setEnabled(true);
    }//GEN-LAST:event_textBuscaCodigoFocusLost

    private void textBuscaCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscaCodigoMouseClicked
        textBuscaNome.setText("");
        textBuscaNome.setEnabled(false);
    }//GEN-LAST:event_textBuscaCodigoMouseClicked

    private void textBuscaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscaCodigoActionPerformed

    private void textBuscaCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaCodigoKeyTyped

    private void botaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarActionPerformed
        tabelaObra.setVisible(true);
        tabelaAutores.setVisible(true);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaAutores.getModel();
        modelo4.setNumRows(0);

        ArrayList<ObrasBEAN> lista = controle.listaObras();
        ArrayList<EditorasBEAN> listaEditoras = new ArrayList();
        EditorasBEAN editora = new EditorasBEAN();

        for(ObrasBEAN obra : lista){
            editora = controle.findEditoraCodigo(obra.getCodigoEditora());
            listaEditoras.add(editora);
        }

        preencher_tabela2(lista, listaEditoras);

        int codigoObra = (int) tabelaObra.getValueAt(0, 0);

        ArrayList<AuxAutorObraBEAN> listaAux = controle.listaAux(codigoObra);
        AutoresSelecionados(listaAux);
        contador = 0;
    }//GEN-LAST:event_botaoListarActionPerformed

    private void textEdicaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEdicaoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textEdicaoKeyTyped

    private void comboboxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxStatusActionPerformed

    private void textAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAutorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            BuscaAutor janela = new BuscaAutor(this, true, textAutor.getText(),this);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_textAutorKeyPressed

    private void btnBuscaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaAutorActionPerformed
        BuscaAutor janela = new BuscaAutor(this, true, textAutor.getText(),this);
        janela.setVisible(true);
    }//GEN-LAST:event_btnBuscaAutorActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        modelo2 = (javax.swing.table.DefaultTableModel)TabelaDestino.getModel();
        int linha = TabelaDestino.getSelectedRow();
        
        if(linha<0){
            JOptionPane.showMessageDialog(null, "Selecione para remover");
        }
        else{
        modelo2.removeRow(linha);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void textBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarrasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarrasKeyTyped

    private void textEstoqueTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEstoqueTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstoqueTotalKeyTyped

    private void textEstoqueDisponivelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEstoqueDisponivelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstoqueDisponivelKeyTyped

    private void textEstoqueTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEstoqueTotalKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            textEstoqueDisponivel.setText(textEstoqueTotal.getText());
        }

    }//GEN-LAST:event_textEstoqueTotalKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaDestino;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoListar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton btnBuscaAutor;
    private javax.swing.JButton btnRemover;
    private com.toedter.calendar.JDateChooser calendarioAno;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbEditora1;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JComboBox<String> comboboxStatus;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelAutores1;
    private javax.swing.JLabel labelBarras;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEdicao;
    private javax.swing.JLabel labelEdit;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelEstoqueDisponivel;
    private javax.swing.JLabel labelEstoqueTotal;
    private javax.swing.JLabel labelSitu;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelSubtitulo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JTable tabelaAutores;
    public javax.swing.JTable tabelaObra;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextField textBarras;
    private javax.swing.JTextField textBuscaCodigo;
    private javax.swing.JTextField textBuscaNome;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textEdicao;
    private javax.swing.JTextField textEstoqueDisponivel;
    private javax.swing.JTextField textEstoqueTotal;
    private javax.swing.JTextField textSubtitulo;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
