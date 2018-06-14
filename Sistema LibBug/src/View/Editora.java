package View;

import Controller.Controle;
import Model.EditorasBEAN;
import Model.UsuariosBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Editora extends javax.swing.JDialog {
     
    private javax.swing.table.DefaultTableModel modelo; 
    static Controle controle = new Controle();
    private UsuariosBEAN usuario = null;
    
    public Editora(UsuariosBEAN usuario) {
        this.usuario = usuario;
        initComponents();
        
        if (usuario.getPerfil() == 0) {
            comboboxStatus.setVisible(false);
            labelStatus.setVisible(false);
        }
        
        modelo = (javax.swing.table.DefaultTableModel)tebelaEditora.getModel();
        textCodigo.setEnabled(false);
        desabilitaComp();
        botao();
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
        botao();
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

    public void limpar(){
        textCodigo.setText("");
        textNome.setText("");
        textRazao.setText("");
        textCnpj.setText("");
        comboboxStatus.setSelectedIndex(0);
    }
    
    public void habilitaComp(){
       textNome.setEditable(true);
       textRazao.setEditable(true); 
       textCnpj.setEditable(true);
       comboboxStatus.setEnabled(true);
    } 
    
    public void desabilitaComp(){
       textCodigo.setEditable(false);
       textNome.setEditable(false);
       textRazao.setEditable(false);
       textCnpj.setEditable(false);
       comboboxStatus.setEnabled(false);
    } 
    
    public void preencher_tabela(EditorasBEAN editora){
        
        modelo.setNumRows(0);

        try {
            modelo.addRow(new Object[]{editora.getCodigoEditora(), editora.getNomeFantasia(), editora.getRazaoSocial(), editora.getCnpj(), editora.getStatus()});
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    public void preencher_tabela(ArrayList<EditorasBEAN> listaEditoras){
        modelo.setNumRows(0);
        
        try {
            for (EditorasBEAN editora : listaEditoras) {
               modelo.addRow(new Object[]{editora.getCodigoEditora(), editora.getNomeFantasia(), editora.getRazaoSocial(), editora.getCnpj(), editora.getStatus()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textBuscaNome = new javax.swing.JTextField();
        botaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tebelaEditora = new javax.swing.JTable();
        botaoListar = new javax.swing.JButton();
        textBuscaCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        textCnpj = new javax.swing.JTextField();
        comboboxStatus = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        labelRazao = new javax.swing.JLabel();
        textRazao = new javax.swing.JTextField();
        labelEditora = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        abas.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setLayout(null);

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
        botaoBusca.setBounds(270, 20, 140, 40);

        tebelaEditora.setBackground(new java.awt.Color(153, 204, 255));
        tebelaEditora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tebelaEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome Fantasia", "Razão Social", "Cnpj", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tebelaEditora.setToolTipText("");
        tebelaEditora.setColumnSelectionAllowed(true);
        tebelaEditora.getTableHeader().setReorderingAllowed(false);
        tebelaEditora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tebelaEditoraFocusLost(evt);
            }
        });
        tebelaEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tebelaEditoraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tebelaEditoraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tebelaEditora);
        tebelaEditora.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 940, 150);

        botaoListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/list_tasks_22372.png"))); // NOI18N
        botaoListar.setText("Todos");
        botaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoListar);
        botaoListar.setBounds(430, 20, 110, 40);

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
        jLabel1.setBounds(10, 10, 70, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 10, 50, 20);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, -240, 34, 1500);

        abas.addTab("Pesquisa", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setBackground(new java.awt.Color(0, 0, 0));
        labelNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNome.setText("Nome Fantasia*");
        jPanel3.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 20));
        jPanel3.add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        labelCpf.setBackground(new java.awt.Color(0, 0, 0));
        labelCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCpf.setText("CNPJ*");
        jPanel3.add(labelCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        textCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCnpjKeyTyped(evt);
            }
        });
        jPanel3.add(textCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 150, 28));

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));
        jPanel3.add(comboboxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 110, 30));

        labelStatus.setBackground(new java.awt.Color(0, 0, 0));
        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelStatus.setText("Status");
        jPanel3.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        labelCodigo.setBackground(new java.awt.Color(0, 0, 0));
        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 30));

        labelRazao.setBackground(new java.awt.Color(0, 0, 0));
        labelRazao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRazao.setText("Razão Social*");
        jPanel3.add(labelRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 20));
        jPanel3.add(textRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 250, 30));

        abas.addTab("Cadastro / Edição", jPanel3);

        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setText("Editora");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(400, 400, 400)
                            .addComponent(labelEditora)
                            .addGap(228, 228, 228)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
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
                    .addGap(6, 6, 6)
                    .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void textBuscaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscaNomeActionPerformed

    private void textBuscaNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaNomeKeyTyped
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaNomeKeyTyped

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        try {
            if (textBuscaCodigo.getText().length() > 0) {
                int codigo = Integer.parseInt(textBuscaCodigo.getText());
                EditorasBEAN editoraCodigo = controle.findEditoraCodigo(codigo);
                preencher_tabela(editoraCodigo);
            } else if (textBuscaNome.getText().length() > 0) {
                ArrayList<EditorasBEAN> editoras = new ArrayList<EditorasBEAN>();

                String nome = textBuscaNome.getText();
                editoras = controle.findEditoraNome(nome);
                preencher_tabela(editoras);
            } else if ((textBuscaCodigo.getText().isEmpty() && textBuscaNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Digite algo para pesquisar!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Registro não encontrado");
        }
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void tebelaEditoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tebelaEditoraFocusLost

    }//GEN-LAST:event_tebelaEditoraFocusLost

    private void tebelaEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tebelaEditoraMouseClicked
        if (evt.getClickCount() == 2) {
            habilitaComp();
            textCodigo.setEditable(false);
            botaoNovo.setEnabled(false);
            botaoNovo.setBorderPainted(true);
            botaoNovo.setContentAreaFilled(true);
            botaoNovo.setFocusPainted(true);
            botaoSalvar.setEnabled(true);
            botaoCancelar.setEnabled(true);

            int linha = tebelaEditora.getSelectedRow();

            textCodigo.setText(tebelaEditora.getValueAt(linha, 0).toString());

            abas.setSelectedIndex(1);

            textNome.setText(tebelaEditora.getValueAt(linha, 1).toString());
            textRazao.setText(tebelaEditora.getValueAt(linha, 2).toString());
            textCnpj.setText(tebelaEditora.getValueAt(linha, 3).toString());
            comboboxStatus.setSelectedItem(tebelaEditora.getValueAt(linha, 4));
        }
    }//GEN-LAST:event_tebelaEditoraMouseClicked

    private void tebelaEditoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tebelaEditoraMousePressed

    }//GEN-LAST:event_tebelaEditoraMousePressed

    private void botaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarActionPerformed
        modelo = (javax.swing.table.DefaultTableModel) tebelaEditora.getModel();

        ArrayList<EditorasBEAN> listaEditoras = controle.listaEditoras();

        try{
            preencher_tabela(listaEditoras);
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Nenhum registro encontrado");
        }
    }//GEN-LAST:event_botaoListarActionPerformed


    private void textBuscaCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscaCodigoMouseClicked
        textBuscaNome.setText("");
        textBuscaNome.setEnabled(false);
		textBuscaCodigo.setEnabled(true);
    }//GEN-LAST:event_textBuscaCodigoMouseClicked

    private void textBuscaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscaNomeMouseClicked
        textBuscaCodigo.setEnabled(false);
        textBuscaCodigo.setText("");
		textBuscaNome.setEnabled(true);
    }//GEN-LAST:event_textBuscaNomeMouseClicked
	
    private void textBuscaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscaCodigoActionPerformed

    private void textBuscaCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaCodigoKeyTyped

    private void textCnpjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCnpjKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textCnpjKeyTyped

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

        limpar();
        desabilitaComp();
        abas.setSelectedIndex(0);
        botaoNovo.setEnabled(true);
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
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
        habilitaComp();
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoCancelar.setEnabled(true);
        comboboxStatus.setEnabled(false);
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

        if (( textRazao.getText().equals("") || textCnpj.getText().equals("") || textNome.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Preencha os dados para prosseguir");
        } else {
            try {
                EditorasBEAN editora = new EditorasBEAN();

                editora.setNomeFantasia(textNome.getText());
                editora.setRazaoSocial(textRazao.getText());
                editora.setCnpj(textCnpj.getText());
                String status = (String) comboboxStatus.getSelectedItem();
                editora.setStatus(status);

                if(textCodigo.getText().equals("")){
                    controle.addEditora(editora);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                    limpar();
                    desabilitaComp();
                    abas.setSelectedIndex(0);
                    botaoNovo.setEnabled(true);
                    botaoSalvar.setEnabled(false);
                    botaoCancelar.setEnabled(false);

                }else{
                    int codigo = Integer.parseInt(textCodigo.getText());
                    editora.setCodigoEditora(codigo);
                    controle.updateEditora(editora);
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                    limpar();
                    desabilitaComp();
                    abas.setSelectedIndex(0);
                    botaoNovo.setEnabled(true);
                    botaoSalvar.setEnabled(false);
                    botaoCancelar.setEnabled(false);
                }
                botaoNovo.setEnabled(true);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoListar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox<String> comboboxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelRazao;
    private javax.swing.JLabel labelStatus;
    public javax.swing.JTable tebelaEditora;
    private javax.swing.JTextField textBuscaCodigo;
    private javax.swing.JTextField textBuscaNome;
    private javax.swing.JTextField textCnpj;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textRazao;
    // End of variables declaration//GEN-END:variables
}
