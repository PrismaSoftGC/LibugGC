package View;

import Controller.Controle;
import Mail.JavaMailApp;
import Model.AuxEmprestimoObraBEAN;
import Model.ClientesBEAN;
import Model.EmprestimoBEAN;
import Model.ObrasBEAN;
import Model.UsuariosBEAN;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Emprestimo extends javax.swing.JDialog {
    
    private javax.swing.table.DefaultTableModel modelo1; 
    private javax.swing.table.DefaultTableModel modelo2;
    private javax.swing.table.DefaultTableModel modelo3;
    private javax.swing.table.DefaultTableModel modelo4;
    
    static  Controle controle = new Controle();
    private UsuariosBEAN usuario = null;
   
    int cont,contador=0;

    public Emprestimo(UsuariosBEAN usuario) {
        this.usuario = usuario;
        
        initComponents();
        tabelaEmprestimo.setDefaultRenderer(Object.class, new CellRenderer());
        
        comboCliente();
        Desabilita();
        
        tabelaOrigem.setVisible(false);
        tabelaEmprestimo.setVisible(false);
        tabelaObras.setVisible(false);
       
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        textCodigo.setEditable(false);
        textCpf.setEnabled(false);
        calendario2.setEnabled(false);
        
        MaskFormatter formater2 = new MaskFormatter(); 
        try {         
            formater2.setMask("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        formater2.install(calendario2);
        
        Mascara();
        
    }
    
     public void Mascara(){
        MaskFormatter formater = new MaskFormatter(); 
        try {         
            formater.setMask("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        formater.install(dataSaida);
        
    }
    
     public void preencher_tabela(ArrayList<ObrasBEAN> listaObras){
       // modelo1 = (javax.swing.table.DefaultTableModel)tabelaObra.getModel();
        modelo1.setNumRows(0);

        try {
            for (ObrasBEAN obra : listaObras) {
                if(obra.getStatus().equals("Ativado") && (obra.getQtdEstoqueDisponivel()!=1)){
                    
                    modelo1.addRow(new Object[]{obra.getCodigoObra(), obra.getTitulo()});
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
    
    public void comboCliente(){
        ArrayList<ClientesBEAN> listaClientes = controle.listaClientes();
        
        try {
            for (ClientesBEAN cliente : listaClientes) {
                if(cliente.getStatus().equals("Ativado"))
                cbCliente.addItem(cliente.getNome());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
     public void preencher_tabela2(ArrayList<EmprestimoBEAN> listaEmpres){
        ClientesBEAN cli = new ClientesBEAN();
        ArrayList<ClientesBEAN> listaCli = new ArrayList<ClientesBEAN>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaEmprestimo.getModel();
        modelo3.setNumRows(0);

        try {
            for (int i=0; i<listaEmpres.size();i++) {
                cli = controle.findClienteCodigo(listaEmpres.get(i).getCodigoCliente());
                modelo3.addRow(new Object[]{listaEmpres.get(i).getCodigoEmprestimo(), sdf.format(listaEmpres.get(i).getSaida()), 
                cli.getNome() , sdf.format(listaEmpres.get(i).getDevolucao())});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
    
    public void Limpar(){
        textCodigo.setText("");
        cbCliente.setSelectedIndex(0);
        dataSaida.setText("");
//        dataDevolucao.setText("");
        
        modelo1 = (javax.swing.table.DefaultTableModel)tabelaOrigem.getModel();
        modelo1.setNumRows(0);
        modelo2 = (javax.swing.table.DefaultTableModel)tabelaDestino.getModel();
        modelo2.setNumRows(0);
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaEmprestimo.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaObras.getModel();
        modelo4.setNumRows(0);
        tabelaOrigem.setVisible(true);
        tabelaDestino.setVisible(true);
    }
    
    public void Desabilita(){
        cbCliente.setEnabled(false);
        dataSaida.setEnabled(false);
//        dataDevolucao.setEnabled(false);
        botaoAdicionar.setEnabled(false);
        botaoRemover.setEnabled(false);
        
    }
    
    public void Habilita(){
        cbCliente.setEnabled(true);
        dataSaida.setEnabled(true);
//        dataDevolucao.setEnabled(true);
        botaoAdicionar.setEnabled(true);
        botaoRemover.setEnabled(true);
    }
    
    public void ObrasSelecionadas(ArrayList<AuxEmprestimoObraBEAN> listaAux){
        ObrasBEAN obra;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (int i = 0; i < listaAux.size(); i++) {
                obra = controle.findObraCodigo(listaAux.get(i).getCodigoObra());

                modelo4 = (javax.swing.table.DefaultTableModel) tabelaObras.getModel();

                modelo4.setNumRows(contador);

                modelo4.addRow(new Object[]{obra.getCodigoObra(), obra.getTitulo(), sdf.format(listaAux.get(i).getChegada())});
                contador++;
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEditora = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        botaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimo = new javax.swing.JTable();
        textCpf = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        labelTitulo2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaObras = new javax.swing.JTable();
        labelAutores1 = new javax.swing.JLabel();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        calendario2 = new com.toedter.calendar.JDateChooser();
        textObra = new javax.swing.JTextField();
        labelCliente1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        labelCalend = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaOrigem = new javax.swing.JTable();
        labelObras = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaDestino = new javax.swing.JTable();
        labelObraSelecionada = new javax.swing.JLabel();
        botaoRemover = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        labelEdit1 = new javax.swing.JLabel();
        labelEdit2 = new javax.swing.JLabel();
        dataSaida = new javax.swing.JFormattedTextField();
        calendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEditora.setBackground(new java.awt.Color(0, 0, 0));
        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setText("Empréstimo");
        getContentPane().add(labelEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

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
        getContentPane().add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 39, -1));

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
        getContentPane().add(botaoNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 41, -1));

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
        getContentPane().add(botaoSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 39, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoBusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/search-good_icon-icons.com_51027.png"))); // NOI18N
        botaoBusca.setText("Pesquisar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(botaoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 140, 30));

        tabelaEmprestimo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo do Emprestimo", "Data Saída", "Cliente", "Data Devolucao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEmprestimo.setToolTipText("");
        tabelaEmprestimo.setColumnSelectionAllowed(true);
        tabelaEmprestimo.getTableHeader().setReorderingAllowed(false);
        tabelaEmprestimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelaEmprestimoFocusLost(evt);
            }
        });
        tabelaEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmprestimoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaEmprestimoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEmprestimo);
        tabelaEmprestimo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 710, 130));

        textCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textCpfFocusLost(evt);
            }
        });
        textCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textCpfMouseClicked(evt);
            }
        });
        textCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCpfActionPerformed(evt);
            }
        });
        textCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCpfKeyTyped(evt);
            }
        });
        jPanel1.add(textCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 30));

        labelCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCliente.setText("CPF");
        jPanel1.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

        labelTitulo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTitulo2.setText("Data de devolução");
        jPanel1.add(labelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, -1));

        tabelaObras.setBackground(new java.awt.Color(153, 204, 255));
        tabelaObras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Título", "Data Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaObras.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabelaObras);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 440, 100));

        labelAutores1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAutores1.setText("Obra(s) deste Emprestimo");
        jPanel1.add(labelAutores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 170, -1));

        radio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio1ActionPerformed(evt);
            }
        });
        jPanel1.add(radio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        radio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio2ActionPerformed(evt);
            }
        });
        jPanel1.add(radio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));
        jPanel1.add(calendario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 110, 30));

        textObra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textObraFocusLost(evt);
            }
        });
        textObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textObraMouseClicked(evt);
            }
        });
        textObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textObraActionPerformed(evt);
            }
        });
        textObra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textObraKeyTyped(evt);
            }
        });
        jPanel1.add(textObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, 30));

        labelCliente1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCliente1.setText("Obra");
        jPanel1.add(labelCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 90, 20));

        abas.addTab("Pesquisa", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        labelCalend.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCalend.setText("Data Devolução");
        jPanel3.add(labelCalend, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 20));

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });
        jPanel3.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 230, 30));

        tabelaOrigem.setBackground(new java.awt.Color(153, 204, 255));
        tabelaOrigem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaOrigem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Título"
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
        tabelaOrigem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaOrigemMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaOrigem);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 330, 90));

        labelObras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelObras.setText("Obras");
        jPanel3.add(labelObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        tabelaDestino.setBackground(new java.awt.Color(153, 204, 255));
        tabelaDestino.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Título"
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
        jScrollPane3.setViewportView(tabelaDestino);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 330, 90));

        labelObraSelecionada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelObraSelecionada.setText("Obras Selecionadas");
        jPanel3.add(labelObraSelecionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, -1, -1));

        botaoRemover.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoRemover.setText("Remover<<");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        jPanel3.add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 110, 30));

        botaoAdicionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoAdicionar.setText("Adicionar >>");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        jPanel3.add(botaoAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 110, 30));

        labelEdit1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEdit1.setText("Cliente*");
        jPanel3.add(labelEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 20));

        labelEdit2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEdit2.setText("Data Saída");
        jPanel3.add(labelEdit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 20));

        dataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSaidaActionPerformed(evt);
            }
        });
        jPanel3.add(dataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 120, 30));
        jPanel3.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 40, 130, 30));

        abas.addTab("Cadastro / Devolução", jPanel3);

        getContentPane().add(abas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 940, 430));

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
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaEmprestimo.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaObras.getModel();
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
        abas.setSelectedIndex(1);
        modelo3 = (javax.swing.table.DefaultTableModel)tabelaEmprestimo.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel)tabelaObras.getModel();
        modelo4.setNumRows(0);

        Date saida = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataSaida.setText(sdf.format(saida));

        Habilita();
        dataSaida.setEditable(false);
        //        dataDevolucao.setEditable(false);
        //  dataDevolucao.setVisible(true);

        botaoCancelar.setEnabled(true);
        botaoSalvar.setEnabled(true);
        tabelaOrigem.setVisible(true);
        modelo1 = (javax.swing.table.DefaultTableModel)tabelaOrigem.getModel();
        abas.setSelectedIndex(1);
        botaoNovo.setEnabled(false);

        ArrayList<ObrasBEAN> listaObras = controle.listaObras();

        preencher_tabela(listaObras);
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
        modelo2 = (javax.swing.table.DefaultTableModel) tabelaDestino.getModel();
        int valor = tabelaDestino.getRowCount();
        Boolean result = false;
        if (valor <= 0) {
            result = true;
        }

        //ATUALIZA EMPRESTIMO
        if (textCodigo.getText().length() > 0) {

            int codigoEmp = Integer.parseInt(textCodigo.getText());
            int linhasAtualiza = tabelaDestino.getRowCount();
            int linhasOrigem = tabelaOrigem.getRowCount();
            AuxEmprestimoObraBEAN aux = new AuxEmprestimoObraBEAN();
            ObrasBEAN obra2 = new ObrasBEAN();

            controle.deleteAuxEmprestimo(codigoEmp);

            for(int i=0; i<linhasOrigem; i++){ // Alteração Felipe
                int id_obra = (int) tabelaOrigem.getValueAt(i, 0);
                obra2 = controle.findObraCodigo(id_obra);
                obra2.setSituacao("Prateleira");
                obra2.setQtdEstoqueDisponivel((obra2.getQtdEstoqueDisponivel()+1));
                controle.updateObraStatus(obra2);
                controle.updateObraEstoque(obra2);
            } // Alteração Felipe

            if (valor>=0) {
                Date data1 = new Date();

                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String data2 = format.format(data1);
                try {
                    java.sql.Date data3 = new java.sql.Date(format.parse(data2).getTime());
                    aux.setChegada(data3);
                } catch (ParseException ex) {
                    Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < linhasAtualiza; i++) {
                    aux.setCodigoEmprestimo(codigoEmp);
                    aux.setCodigoObra((int) tabelaDestino.getValueAt(i, 0));
                    controle.addAuxEmprestimoObra(aux);
                }
            }

            JOptionPane.showMessageDialog(null, "Devolvido com sucesso");
            Limpar();
            Desabilita();
            botaoSalvar.setEnabled(false);
            botaoCancelar.setEnabled(false);
            botaoNovo.setEnabled(true);
            abas.setSelectedIndex(0);

        } else if (cbCliente.getSelectedItem().equals("Selecione") || valor <= 0 || calendario.isEnabled()==false)  {
            JOptionPane.showMessageDialog(null, "Preencha para prosseguir");
        } else {

            //SALVA O EMPRESTIMO

            Date data2 = new Date();
            Date calend2 = calendario.getCalendar().getTime();

            if(calend2.before(data2)){
                JOptionPane.showMessageDialog(null, "Não e possivel salvar emprestimo com data retroativa ou data atual");
            }
            else{

                try {
                    EmprestimoBEAN emprestimo = new EmprestimoBEAN();

                    String nomeCliente = (String) cbCliente.getSelectedItem();
                    ArrayList<ClientesBEAN> lista = controle.findClienteNome(nomeCliente);

                    int codigoCliente = 0;

                    for (ClientesBEAN lis : lista) {
                        if (lis.getNome().equals(nomeCliente)) {
                            codigoCliente = lis.getCodigoCliente();
                        }
                    }
                    
                    emprestimo.setCodigoFuncionario(usuario.getCodigoUsuario());

                    emprestimo.setCodigoCliente(codigoCliente);
                    //recebe a string do jtext e converte em variavel do tipo data
                    String saida = dataSaida.getText();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(format.parse(saida).getTime());
                    emprestimo.setSaida(data);

                    Date calend = calendario.getCalendar().getTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String pesquisaData = sdf.format(calend);

                    data = new java.sql.Date(sdf.parse(pesquisaData).getTime());

                    emprestimo.setDevolucao(data);
                    
                    int validador = 0;
                    int linhaDestino = tabelaDestino.getRowCount();
                    AuxEmprestimoObraBEAN aux = new AuxEmprestimoObraBEAN();
                    ObrasBEAN obra = new ObrasBEAN();
                    
                    for (int i = 0; i < linhaDestino; i++) {
                        int cod_obra = (int) tabelaDestino.getValueAt(i, 0);
                        obra = controle.findObraCodigo(cod_obra);
                        ArrayList<AuxEmprestimoObraBEAN> obras = controle.listaAuxEmprestimoObra(cod_obra);
                        ArrayList<EmprestimoBEAN> emprestimoAux = controle.findEmprestimoCodigo(codigoCliente);
                        for (AuxEmprestimoObraBEAN obraAux : obras) {
                            for (EmprestimoBEAN emprestimoT : emprestimoAux) {
                                if (emprestimoT.getCodigoEmprestimo() == obraAux.getCodigoEmprestimo()) {
                                    JOptionPane.showMessageDialog(null, "Obra selecionada já emprestada para este cliente, limite atingido!");
                                    validador = 1;
                                }
                            }
                        }
                        
                        int contador = 0;
                        for (EmprestimoBEAN emprestimoT : emprestimoAux) {
                            contador++;
                        }
                        
                        if (contador > 4) {
                            validador = 1;
                        }
                        
                     }
                    
                    if (validador == 0) {
                        controle.addEmprestimo(emprestimo);
                        
                        obra = new ObrasBEAN();
                        int codigoEmprestimo = controle.findEmprestimo(emprestimo);

                        for (int i = 0; i < linhaDestino; i++) { // Alteração Felipe
                            int cod_obra = (int) tabelaDestino.getValueAt(i, 0);
                            if(controle.findObraCodigo(cod_obra).getQtdEstoqueDisponivel()>1){
                                aux.setCodigoEmprestimo(codigoEmprestimo);
                                aux.setCodigoObra(cod_obra);
                                aux.setChegada(data);
                                controle.addAuxEmprestimoObra(aux);
                                obra = controle.findObraCodigo(cod_obra);
                                obra.setSituacao("Emprestado");
                                obra.setQtdEstoqueDisponivel((obra.getQtdEstoqueDisponivel()-1));
                                controle.updateObraEstoque(obra);
                                controle.updateObraStatus(obra);
                            }else{
                                JOptionPane.showMessageDialog(null, "Quantidade Minima atingida!");
                            }                      
                        }// Alteração Felipe

                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                        Limpar();
                        //   Desabilita();
                        botaoSalvar.setEnabled(false);
                        botaoCancelar.setEnabled(false);
                        botaoNovo.setEnabled(true);
                        abas.setSelectedIndex(0);
                        new JavaMailApp().email(codigoCliente); ///parei aqui todo
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        tabelaEmprestimo.setVisible(true);
        tabelaObras.setVisible(true);

        modelo3 = (javax.swing.table.DefaultTableModel)tabelaEmprestimo.getModel();
        modelo3.setNumRows(0);
        modelo4 = (javax.swing.table.DefaultTableModel) tabelaObras.getModel();
        modelo4.setNumRows(0);
        
       
        try {
            if(textCpf.getText().length() > 0) {
                long cpf = (long) Long.parseLong(textCpf.getText());
                
                ClientesBEAN cli = controle.findClienteCpf((long) cpf);
                
                int codigoCliente = cli.getCodigoCliente();
                
                ArrayList<EmprestimoBEAN> listaCli = controle.findEmprestimoCodigo(codigoCliente);
                
                preencher_tabela2(listaCli);

            }

            //   if (dataPesquisa.getText().length() > 0) {
                else{
                    Date calend = calendario2.getCalendar().getTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String pesquisaData = sdf.format(calend);
                    java.sql.Date data3 = new java.sql.Date(sdf.parse(pesquisaData).getTime());
                    //       java.sql.Date data = new java.sql.Date(format.parse(calend).getTime());

                    ArrayList<EmprestimoBEAN> listaEmprestimos = controle.findEmprestimoData((java.sql.Date) data3);
                    ArrayList<ClientesBEAN> listaClientes = null;
                    ClientesBEAN cliente = new ClientesBEAN();

                    tabelaEmprestimo.setVisible(true);
                    tabelaObras.setVisible(true);

                    preencher_tabela2(listaEmprestimos);

                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Registro nao encontrado");
            }
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void tabelaEmprestimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaEmprestimoFocusLost

    }//GEN-LAST:event_tabelaEmprestimoFocusLost

    private void tabelaEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmprestimoMouseClicked
        tabelaOrigem.setVisible(true);
        if(evt.getClickCount() == 1){
            int linha = tabelaEmprestimo.getSelectedRow();
            int codigoEmprestimo = (int) tabelaEmprestimo.getValueAt(linha, 0);

            ArrayList<AuxEmprestimoObraBEAN> listaAux = controle.listaAuxEmprestimo(codigoEmprestimo);
            ObrasSelecionadas(listaAux);
            contador = 0;
        }
        else if(evt.getClickCount() == 2){
            botaoRemover.setEnabled(true);
            botaoRemover.setText("<< Devolver");
            botaoAdicionar.setEnabled(false);
            botaoNovo.setEnabled(false);
            botaoCancelar.setEnabled(true);
            botaoSalvar.setEnabled(true);

            modelo2 = (javax.swing.table.DefaultTableModel) tabelaDestino.getModel();
            modelo1 = (javax.swing.table.DefaultTableModel) tabelaOrigem.getModel();
            modelo1.setNumRows(0);

            abas.setSelectedIndex(1);
            textCodigo.setEditable(false);

            cbCliente.setEnabled(false);
            dataSaida.setEditable(false);
            //            dataDevolucao.setEditable(false);

            int linha = tabelaEmprestimo.getSelectedRow();
            textCodigo.setText(tabelaEmprestimo.getValueAt(linha, 0).toString());
            dataSaida.setText((String) tabelaEmprestimo.getValueAt(linha, 1));
            cbCliente.setSelectedItem(tabelaEmprestimo.getValueAt(linha, 2));
            //     dataDevolucao.setText((String) tabelaEmprestimo.getValueAt(linha, 3));

            int linhaObraSelec = tabelaObras.getRowCount();
            int vetor[] = new int[linhaObraSelec];

            modelo2.setNumRows(contador);

            //Preenchendo a tabela de obra emprestada
            for (int i = 0; i < linhaObraSelec; i++) {
                modelo2.addRow(new Object[]{tabelaObras.getValueAt(i, 0), tabelaObras.getValueAt(i, 1)});
                vetor[i] = (int) tabelaObras.getValueAt(i, 0);
            }

            /*
            ArrayList<ObrasBEAN> listaObras = controle.listaObras();

            for(int i=0; i<listaObras.size();i++){
                for(int j=0; j<vetor.length;j++){
                    if(listaObras.get(i).getCodigoObra() == vetor[j]){
                        listaObras.remove(i);
                        break;
                    }
                }
            }

            preencher_tabela(listaObras);
            listaObras = null;

            */
        }
    }//GEN-LAST:event_tabelaEmprestimoMouseClicked

    private void tabelaEmprestimoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmprestimoMousePressed

    }//GEN-LAST:event_tabelaEmprestimoMousePressed

    private void textCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCpfFocusLost

    }//GEN-LAST:event_textCpfFocusLost

    private void textCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textCpfMouseClicked

    }//GEN-LAST:event_textCpfMouseClicked

    private void textCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCpfActionPerformed

    }//GEN-LAST:event_textCpfActionPerformed

    private void textCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCpfKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textCpfKeyTyped

    private void radio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio1ActionPerformed
        if(radio1.isSelected()){
            if(textCpf.isCursorSet()){
                calendario2.setEnabled(false);
                textCpf.setEnabled(true);
            }
            radio2.setSelected(false);
        }
    }//GEN-LAST:event_radio1ActionPerformed

    private void radio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio2ActionPerformed
        if(radio2.isSelected()){
            if(calendario2.isEnabled() == false){
                textCpf.setEnabled(false);
                calendario2.setEnabled(true);
            }
            radio1.setSelected(false);
        }
    }//GEN-LAST:event_radio2ActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteActionPerformed

    private void tabelaOrigemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOrigemMousePressed

    }//GEN-LAST:event_tabelaOrigemMousePressed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        //    modelo1 = (javax.swing.table.DefaultTableModel)tabelaOrigem.getModel();
        modelo2 = (javax.swing.table.DefaultTableModel)tabelaDestino.getModel();

        //if (textCodigo.getText().length() > 0) {
        //  modelo1.setNumRows(0);
        //}

        int linha = tabelaDestino.getSelectedRow();

        Object obra1 = tabelaDestino.getValueAt(linha,0);

        ObrasBEAN obr =  controle.findObraCodigo((int) obra1);

        modelo1.addRow(new Object[]{obr.getCodigoObra(), obr.getTitulo()});

        modelo2.removeRow(linha);

    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed

        modelo1 = (javax.swing.table.DefaultTableModel)tabelaOrigem.getModel();
        modelo2 = (javax.swing.table.DefaultTableModel)tabelaDestino.getModel();

        int linha = tabelaOrigem.getSelectedRow();

        Object obra1 = tabelaOrigem.getValueAt(linha,0);

        ObrasBEAN obr =  controle.findObraCodigo((int) obra1);
        int qtdLinhas = tabelaDestino.getRowCount();
        int aux=0;

        if(qtdLinhas==0){
            aux=cont;
            modelo2.setNumRows(aux);
        }
        if(qtdLinhas>0){
            aux=qtdLinhas;
            modelo2.setNumRows(aux);
        }

        modelo2.addRow(new Object[]{obr.getCodigoObra(), obr.getTitulo()});
        aux++;

        modelo1.removeRow(linha);
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void dataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataSaidaActionPerformed

    private void textObraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textObraFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textObraFocusLost

    private void textObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textObraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_textObraMouseClicked

    private void textObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textObraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textObraActionPerformed

    private void textObraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textObraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textObraKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSalvar;
    private com.toedter.calendar.JDateChooser calendario;
    private com.toedter.calendar.JDateChooser calendario2;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JFormattedTextField dataSaida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelAutores1;
    private javax.swing.JLabel labelCalend;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCliente1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEdit1;
    private javax.swing.JLabel labelEdit2;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelObraSelecionada;
    private javax.swing.JLabel labelObras;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JTable tabelaDestino;
    public javax.swing.JTable tabelaEmprestimo;
    private javax.swing.JTable tabelaObras;
    private javax.swing.JTable tabelaOrigem;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textCpf;
    private javax.swing.JTextField textObra;
    // End of variables declaration//GEN-END:variables
}
