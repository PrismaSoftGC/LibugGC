package View;

import Controller.Controle;
import Model.AutoresBEAN;
import Model.UsuariosBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Autor extends javax.swing.JDialog {
    
    static Controle controle = new Controle();
    private javax.swing.table.DefaultTableModel modelo;
    private UsuariosBEAN usuario = null;
    
    public Autor(UsuariosBEAN usuario) {
        this.usuario = usuario;
        initComponents();
        
        if (usuario.getPerfil() == 0) {
            comboboxStatus.setVisible(false);
            labelStatus.setVisible(false);
        }
        
        modelo = (javax.swing.table.DefaultTableModel)tabelaAutor.getModel();
        
        desabilitaComp();
        
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
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

    public void limpar() {
        textCodigo.setText("");
        textNome.setText("");
        comboboxStatus.setSelectedIndex(0);
    }
    
    public void habilitaComp(){
       textNome.setEditable(true);
       comboboxStatus.setEnabled(true);
    } 
    
    public void desabilitaComp(){
       textCodigo.setEditable(false);
       textNome.setEditable(false);
       comboboxStatus.setEnabled(false);
    } 
    
    public void preencher_tabela(AutoresBEAN autor) {

        modelo.setNumRows(0);

        try {
            modelo.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome(), autor.getStatus()});
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
     public void preencher_tabela(ArrayList<AutoresBEAN> listaAutores){
        modelo.setNumRows(0);
        try {
            for (AutoresBEAN autor : listaAutores) {
                modelo.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome(), autor.getStatus()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAutor = new javax.swing.JLabel();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textBuscaNome = new javax.swing.JTextField();
        botaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAutor = new javax.swing.JTable();
        botaoListar = new javax.swing.JButton();
        textBuscaCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        comboboxStatus = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        botaoCancelar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelAutor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelAutor.setText("Autor");

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
        botaoBusca.setBounds(270, 30, 170, 30);

        tabelaAutor.setBackground(new java.awt.Color(153, 204, 255));
        tabelaAutor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        tabelaAutor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Status"
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
        tabelaAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaAutor.getTableHeader().setReorderingAllowed(false);
        tabelaAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelaAutorFocusLost(evt);
            }
        });
        tabelaAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAutorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaAutorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAutor);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 930, 150);

        botaoListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/list_tasks_22372.png"))); // NOI18N
        botaoListar.setText("Listar Todos");
        botaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoListar);
        botaoListar.setBounds(790, 30, 140, 30);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 10, 50, 20);

        abas.addTab("Pesquisa", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNome.setText("Nome*");
        jPanel3.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 59, -1, 20));
        jPanel3.add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 82, 250, 30));

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));
        jPanel3.add(comboboxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 110, 30));

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelStatus.setText("Status");
        jPanel3.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 60, 30));

        abas.addTab("Cadastro/Edição", jPanel3);

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Cancel_icon-icons.com_73703.png"))); // NOI18N
        botaoCancelar.setToolTipText("Cancelar");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(labelAutor)
                .addContainerGap(441, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(740, 740, 740)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelAutor)
                .addContainerGap(442, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        AutoresBEAN autor = new AutoresBEAN();

        try{
            if (textBuscaCodigo.getText().length() > 0) {
                int codigo = Integer.parseInt(textBuscaCodigo.getText());
                autor = controle.findAutorCodigo(codigo);
                preencher_tabela(autor);
            } else if (textBuscaNome.getText().length() > 0) {
                String nome = textBuscaNome.getText();
                ArrayList<AutoresBEAN> listaAutores = new ArrayList<AutoresBEAN>();
                listaAutores = controle.findAutorNome(nome);
                preencher_tabela(listaAutores);
            } else if ((textBuscaCodigo.getText().isEmpty() && textBuscaNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Digite algo para pesquisar!");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void tabelaAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaAutorFocusLost

    }//GEN-LAST:event_tabelaAutorFocusLost

    private void tabelaAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAutorMouseClicked
        if (evt.getClickCount() == 2) {
            habilitaComp();
            textCodigo.setEditable(false);
            botaoNovo.setEnabled(false);
            botaoNovo.setBorderPainted(true);
            botaoNovo.setContentAreaFilled(true);
            botaoNovo.setFocusPainted(true);
            botaoSalvar.setEnabled(true);
            botaoCancelar.setEnabled(true);

            int linha = tabelaAutor.getSelectedRow();

            textCodigo.setText(tabelaAutor.getValueAt(linha, 0).toString());

            abas.setSelectedIndex(1);

            textNome.setText(tabelaAutor.getValueAt(linha, 1).toString());
            comboboxStatus.setSelectedItem(tabelaAutor.getValueAt(linha, 2));

            textCodigo.setEnabled(false);
        }
    }//GEN-LAST:event_tabelaAutorMouseClicked

    private void tabelaAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAutorMousePressed

    }//GEN-LAST:event_tabelaAutorMousePressed

    private void botaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarActionPerformed
        modelo = (javax.swing.table.DefaultTableModel) tabelaAutor.getModel();

        ArrayList<AutoresBEAN> listaAutores = controle.listaAutores();

        try{
            preencher_tabela(listaAutores);
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
		textBuscaNome.setEnabled(true);
        textBuscaCodigo.setText("");
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
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
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
        comboboxStatus.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoCancelar.setEnabled(true);

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

        if ((textNome.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Preencha os dados para prosseguir");
        } else {
            try {
                AutoresBEAN autor = new AutoresBEAN();
                autor.setNome(textNome.getText());;
                String status = (String) comboboxStatus.getSelectedItem();
                autor.setStatus(status);
                if (textCodigo.getText().equals("")) {
                    controle.addAutor(autor);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                    limpar();
                    desabilitaComp();
                    abas.setSelectedIndex(0);
                    botaoNovo.setEnabled(true);
                    botaoCancelar.setEnabled(false);
                    botaoSalvar.setEnabled(false);
                } else {
                    int codigo = Integer.parseInt(textCodigo.getText());
                    autor.setCodigoAutor(codigo);
                    controle.updateAutor(autor);
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                    limpar();
                    desabilitaComp();
                    abas.setSelectedIndex(0);
                    ArrayList<AutoresBEAN> listaAutores = controle.listaAutores();

                    try {
                        preencher_tabela(listaAutores);
                    } catch (Exception erro) {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
                    }

                    botaoNovo.setEnabled(true);
                    botaoCancelar.setEnabled(false);
                    botaoSalvar.setEnabled(false);
                }
                botaoNovo.setEnabled(true);
            } catch (Exception e) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelStatus;
    public javax.swing.JTable tabelaAutor;
    private javax.swing.JTextField textBuscaCodigo;
    private javax.swing.JTextField textBuscaNome;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
