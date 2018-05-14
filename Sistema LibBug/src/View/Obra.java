package View;

import Controller.Controle;
import Model.AutoresBEAN;
import Model.AuxAutorObraBEAN;
import Model.EditorasBEAN;
import Model.ObrasBEAN;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Obra extends javax.swing.JDialog {

    static Controle controle = new Controle();
    private javax.swing.table.DefaultTableModel modelo1; 
    private javax.swing.table.DefaultTableModel modelo2;
    private javax.swing.table.DefaultTableModel modelo3;
    private javax.swing.table.DefaultTableModel modelo4;
    
    int cont,contador=0;
    
    public Obra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
        textCodigo.setEditable(false);
        tabelaObra.setVisible(false);
        tabelaAutores.setVisible(false);
        comboEditora();
        Desabilita();
        botao();
    }
    
    public void Desabilita(){
        textTitulo.setEditable(false);
        cbEditora.setEnabled(false);
        textEdicao.setEditable(false);
        cbSituacao.setEnabled(false);
        cbStatus.setEnabled(false);
        TabelaDestino.setVisible(false);
        tabelaObra.setVisible(false);
        tabelaAutores.setVisible(false);
    }

    public void Habilita(){
        textTitulo.setEditable(true);
        cbEditora.setEnabled(true);
        textEdicao.setEditable(true);
        cbSituacao.setEnabled(true);
        cbStatus.setEnabled(true);
        TabelaDestino.setVisible(true);
        tabelaObra.setVisible(true);
        tabelaAutores.setVisible(true);
    }
    
    public void Limpar(){
        textCodigo.setText("");
        textTitulo.setText("");
        cbEditora.setSelectedIndex(0);
        textEdicao.setText("");
        cbSituacao.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
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
                cbEditora.addItem(editora.getNomeFantasia());
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
            modelo3.addRow(new Object[]{obra.getCodigoObra(), obra.getTitulo(), nomeEditora, obra.getEdicao(),
            obra.getSituacao(), obra.getStatus()});
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
                modelo3.addRow(new Object[]{listaObras.get(i).getCodigoObra(), listaObras.get(i).getTitulo(), listaEditoras.get(i).getNomeFantasia() ,
                    listaObras.get(i).getEdicao(), listaObras.get(i).getSituacao(), listaObras.get(i).getStatus()});
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
        labelCpf = new javax.swing.JLabel();
        textEdicao = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        labelEdit = new javax.swing.JLabel();
        cbEditora = new javax.swing.JComboBox<>();
        cbSituacao = new javax.swing.JComboBox<>();
        labelSitu = new javax.swing.JLabel();
        textAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaDestino = new javax.swing.JTable();
        labelAutor = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        textSubtitulo = new javax.swing.JTextField();
        labelSubtitulo = new javax.swing.JLabel();
        textCidade = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        calendarioAno = new com.toedter.calendar.JDateChooser();
        labelAno = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        labelCategoria = new javax.swing.JLabel();
        textBarras = new javax.swing.JTextField();
        labelBarras = new javax.swing.JLabel();
        textEstoqueTotal = new javax.swing.JTextField();
        labelEstoqueTotal = new javax.swing.JLabel();
        textEstoqueDisponivel = new javax.swing.JTextField();
        labelEstoqueDisponivel = new javax.swing.JLabel();

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

        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setForeground(new java.awt.Color(204, 204, 204));
        labelEditora.setText("Obra");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 50, 20);

        labelTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTitulo2.setText("Titulo");
        jPanel1.add(labelTitulo2);
        labelTitulo2.setBounds(70, 10, 80, 15);

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

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTitulo.setText("Título*");
        jPanel3.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 20));
        jPanel3.add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        labelCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCpf.setText("Edicao");
        jPanel3.add(labelCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        textEdicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEdicaoKeyTyped(evt);
            }
        });
        jPanel3.add(textEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 160, 30));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });
        jPanel3.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 110, 30));

        labelStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelStatus.setText("Status*");
        jPanel3.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        labelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        labelEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEdit.setText("Editora*");
        jPanel3.add(labelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 20));

        cbEditora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel3.add(cbEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 190, 30));

        cbSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prateleira", "Emprestado" }));
        jPanel3.add(cbSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        labelSitu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, 30));

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

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));
        jPanel3.add(textSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 200, 30));

        labelSubtitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSubtitulo.setText("Subtitulo");
        jPanel3.add(labelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 20));

        textCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCidadeKeyTyped(evt);
            }
        });
        jPanel3.add(textCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 30));

        labelCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCidade.setText("Cidade");
        jPanel3.add(labelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel3.add(calendarioAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 130, 30));

        labelAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelAno.setText("Ano*");
        jPanel3.add(labelAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, 20));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel3.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 250, 30));

        labelCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCategoria.setText("Categoria*");
        jPanel3.add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, 20));

        textBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBarrasKeyTyped(evt);
            }
        });
        jPanel3.add(textBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 160, 30));

        labelBarras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelBarras.setText("Cod. Barras");
        jPanel3.add(labelBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        textEstoqueTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEstoqueTotalKeyTyped(evt);
            }
        });
        jPanel3.add(textEstoqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 130, 30));

        labelEstoqueTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEstoqueTotal.setText("Estoque Total*");
        jPanel3.add(labelEstoqueTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        textEstoqueDisponivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEstoqueDisponivelKeyTyped(evt);
            }
        });
        jPanel3.add(textEstoqueDisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 160, 30));

        labelEstoqueDisponivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEstoqueDisponivel.setText("Estoque Disponível*");
        jPanel3.add(labelEstoqueDisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 150, -1));

        abas.addTab("Cadastro / Edição", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 985, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEditora)
                    .addGap(213, 213, 213)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(abas)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(labelEditora))
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 28, Short.MAX_VALUE)))
        );

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
        cbStatus.setEnabled(false);
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

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        modelo2 = (javax.swing.table.DefaultTableModel) TabelaDestino.getModel();
        int valor = TabelaDestino.getRowCount();

        if (textTitulo.getText().equals("") || cbEditora.getSelectedItem().equals("Selecione") || textEdicao.getText().equals("") || valor <=0) {
            JOptionPane.showMessageDialog(null, "Preencha para prosseguir");
        } else {

            try {
                ObrasBEAN obra = new ObrasBEAN();

                obra.setTitulo(textTitulo.getText());

                String nome = (String) cbEditora.getSelectedItem();
                ArrayList<EditorasBEAN> lista = new ArrayList<>();

                lista = controle.findEditoraNome(nome);
                int codigoEditora=0;

                for(EditorasBEAN lis : lista){
                    if(lis.getNomeFantasia().equals(nome)){
                        codigoEditora= lis.getCodigoEditora();
                    }
                }

                obra.setCodigoEditora(codigoEditora);
                int codigoEdicao = Integer.parseInt(textEdicao.getText());
                obra.setEdicao(codigoEdicao);
                String situacao = (String) cbSituacao.getSelectedItem();
                obra.setSituacao(situacao);
                String status = (String) cbStatus.getSelectedItem();
                obra.setStatus(status);

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

            textCodigo.setText(tabelaObra.getValueAt(linha, 0).toString());
            textTitulo.setText(tabelaObra.getValueAt(linha, 1).toString());
            cbEditora.setSelectedItem(tabelaObra.getValueAt(linha, 2));
            textEdicao.setText(tabelaObra.getValueAt(linha, 3).toString());
            cbSituacao.setSelectedItem(tabelaObra.getValueAt(linha, 4));
            cbStatus.setSelectedItem(tabelaObra.getValueAt(linha, 5));

            //preenchendo a tabela de autor selecionado.
            int qtdLinhaAutores = tabelaAutores.getRowCount();

            //     int vetor[] = new int[qtdLinhaAutores];

            modelo2.setNumRows(contador);

            for (int i = 0; i < qtdLinhaAutores; i++) {
                modelo2.addRow(new Object[]{tabelaAutores.getValueAt(i, 0), tabelaAutores.getValueAt(i, 1)});
                //   vetor[i] = (int) tabelaAutores.getValueAt(i, 0);
            }

            //     ArrayList<AutoresBEAN> listaAutores = controle.listaAutores();
            /*
            for (int j = 0; j < listaAutores.size(); j++) {
                for (int i = 0; i < vetor.length; i++) {
                    if (listaAutores.get(j).getCodigoAutor() == vetor[i]) {
                        listaAutores.remove(j);
                        break;
                    }
                }
            }
            */
            //   preencher_tabela(listaAutores);
            //  listaAutores = null;
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

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void textAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAutorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            BuscaAutor janela = new BuscaAutor(this, true, textAutor.getText(),this);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_textAutorKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscaAutor janela = new BuscaAutor(this, true, textAutor.getText(),this);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modelo2 = (javax.swing.table.DefaultTableModel)TabelaDestino.getModel();
        int linha = TabelaDestino.getSelectedRow();
        
        if(linha<0){
            JOptionPane.showMessageDialog(null, "Selecione para remover");
        }
        else{
        modelo2.removeRow(linha);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCidadeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textCidadeKeyTyped

    private void textBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarrasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBarrasKeyTyped

    private void textEstoqueTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEstoqueTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstoqueTotalKeyTyped

    private void textEstoqueDisponivelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEstoqueDisponivelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstoqueDisponivelKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Obra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Obra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Obra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Obra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Obra dialog = new Obra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaDestino;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoListar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private com.toedter.calendar.JDateChooser calendarioAno;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEditora;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel labelCpf;
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
    private javax.swing.JTextField textCidade;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textEdicao;
    private javax.swing.JTextField textEstoqueDisponivel;
    private javax.swing.JTextField textEstoqueTotal;
    private javax.swing.JTextField textSubtitulo;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
