package View;

import Controller.CPF;
import Controller.Controle;
import Model.ClientesBEAN;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JDialog {
    
    private javax.swing.table.DefaultTableModel modelo; 
    
    static Controle controle = new Controle();

    public Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        modelo = (javax.swing.table.DefaultTableModel)tabelaCliente.getModel();
    }
    
     public void limpar(){
        textCodigo.setText("");
        textNome.setText("");
        textCpf.setText("");
        textIdade.setText("");
        comboboxStatus.setSelectedIndex(0);
        textEmail.setText("");
    }
    
      public void habilitaComp(){
       textNome.setEditable(true);
       textCpf.setEditable(true);
       textIdade.setEditable(true);
       comboboxStatus.setEnabled(true);
       textEmail.setEditable(true);
    } 
    
    public void desabilitaComp(){
       textNome.setEditable(false);
       textCpf.setEditable(false);
       textIdade.setEditable(false);
       comboboxStatus.setEnabled(false);
       textEmail.setEditable(false);
    } 
    
    public void preencher_tabela(ClientesBEAN cliente){
        
        modelo.setNumRows(0);

        try {
            modelo.addRow(new Object[]{cliente.getCodigoCliente(), cliente.getNome(), cliente.getCpf(), cliente.getIdade(), cliente.getStatus(),
            cliente.getEmail()});
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    
    public void preencher_tabela(ArrayList<ClientesBEAN> listaClientes){
        modelo.setNumRows(0);

        try {
            for (ClientesBEAN cliente : listaClientes) {
                modelo.addRow(new Object[]{cliente.getCodigoCliente(), cliente.getNome(), cliente.getCpf(), cliente.getIdade(), cliente.getStatus(),
            cliente.getEmail()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEditora = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textBuscaNome = new javax.swing.JTextField();
        botaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        botaoListar = new javax.swing.JButton();
        textBuscaCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        labelIdade = new javax.swing.JLabel();
        textIdade = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        comboboxStatus = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setForeground(new java.awt.Color(204, 204, 204));
        labelEditora.setText("Cliente");

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Cancel_icon-icons.com_73703.png"))); // NOI18N
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Save_37110 (1).png"))); // NOI18N
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/new_page_document_16676 (1).png"))); // NOI18N
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscaNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscaNomeKeyTyped(evt);
            }
        });
        jPanel1.add(textBuscaNome);
        textBuscaNome.setBounds(70, 30, 180, 30);

        botaoBusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoBusca.setText("Pesquisar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(botaoBusca);
        botaoBusca.setBounds(280, 30, 90, 30);

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF", "Idade", "Status", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        tabelaCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelaClienteFocusLost(evt);
            }
        });
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 890, 150);

        botaoListar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoListar.setText("Listar Todos");
        botaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoListar);
        botaoListar.setBounds(780, 20, 120, 30);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 10, 60, 15);

        abas.addTab("Pesquisa", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNome.setText("Nome*");
        jPanel3.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 59, -1, 20));
        jPanel3.add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 82, 250, 30));

        labelCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCpf.setText("CPF*");
        jPanel3.add(labelCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        labelIdade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelIdade.setText("Idade*");
        jPanel3.add(labelIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 62, -1, -1));

        textIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textIdadeKeyTyped(evt);
            }
        });
        jPanel3.add(textIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 82, 43, 27));

        labelCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCidade.setText("Email*");
        jPanel3.add(labelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel3.add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, 30));

        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));
        jPanel3.add(comboboxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 82, 110, 30));

        labelStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelStatus.setText("Status");
        jPanel3.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 62, -1, -1));

        labelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCodigo.setText("Codigo*");
        jPanel3.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));
        jPanel3.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 60, 30));
        jPanel3.add(textCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 150, 30));

        abas.addTab("Cadastro / Edição", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(860, 860, 860)
                            .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(720, 720, 720)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(790, 790, 790)
                            .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addComponent(labelEditora)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelEditora))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        limpar();
        abas.setSelectedIndex(0);
        botaoCancelar.setEnabled(false);
        botaoSalvar.setEnabled(false);
        botaoNovo.setEnabled(true);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        CPF cpf = new CPF(textCpf.getText());
        
        int idade = Integer.parseInt(textIdade.getText());

        if ((textCpf.getText().equals("") || textNome.getText().equals("") || idade <=0)) {
            JOptionPane.showMessageDialog(null, "Preecha os campos obrigatorios");
        } else {

            if (cpf.isCPF() == false) {
                JOptionPane.showMessageDialog(null, "Digite um Cpf Valido");
            } else {
                try {
                    ClientesBEAN cliente = new ClientesBEAN();

                    cliente.setNome(textNome.getText());
                    String status = (String) comboboxStatus.getSelectedItem();
                    cliente.setStatus(status);
                    cliente.setCpf(textCpf.getText());
                    cliente.setIdade(idade);
                    cliente.setEmail(textEmail.getText());

                    if (textCodigo.getText().equals("")) {
                        controle.addCliente(cliente);
                        JOptionPane.showMessageDialog(null, " Cadastrado com sucesso");
                        limpar();
                        desabilitaComp();
                        abas.setSelectedIndex(0);
                        botaoNovo.setEnabled(true);
                        botaoCancelar.setEnabled(false);
                        botaoSalvar.setEnabled(false);
                    } else {
                        int codigo = Integer.parseInt(textCodigo.getText());
                        cliente.setCodigoCliente(codigo);
                        controle.updateCliente(cliente);
                        JOptionPane.showMessageDialog(null, " Atualizado com sucesso");
                        limpar();
                        desabilitaComp();
                        abas.setSelectedIndex(0);
                        botaoNovo.setEnabled(true);
                        botaoCancelar.setEnabled(false);
                        botaoSalvar.setEnabled(false);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        abas.setSelectedIndex(1);
        botaoNovo.setEnabled(false);
        habilitaComp();
        botaoCancelar.setEnabled(true);
        botaoSalvar.setEnabled(true);
        comboboxStatus.setEnabled(false);
        textNome.requestFocus();
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void textIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIdadeKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_textIdadeKeyTyped

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

    private void textBuscaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaNomeKeyReleased

    }//GEN-LAST:event_textBuscaNomeKeyReleased

    private void textBuscaNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaNomeKeyTyped
        String caracteres="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaNomeKeyTyped

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        ClientesBEAN cliente = new ClientesBEAN();

        try{

            if(textBuscaCodigo.getText().length()>0){
                int codigo = Integer.parseInt(textBuscaCodigo.getText());
                cliente = controle.findClienteCodigo(codigo);
                preencher_tabela(cliente);
            }

            else if(textBuscaNome.getText().length()>0){
                ArrayList<ClientesBEAN> clienteLista = new ArrayList<ClientesBEAN>();
                String nome = textBuscaNome.getText();
                clienteLista = controle.findClienteNome(nome);
                preencher_tabela(clienteLista);
            }

            else if((textBuscaCodigo.getText().isEmpty() && textBuscaNome.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Digite algo para pesquisar!");
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
        }
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void tabelaClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaClienteFocusLost

    }//GEN-LAST:event_tabelaClienteFocusLost

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        if (evt.getClickCount() == 2) {

            habilitaComp();
            botaoSalvar.setEnabled(true);
            botaoCancelar.setEnabled(true);
            int linha = tabelaCliente.getSelectedRow();

            textCodigo.setText(tabelaCliente.getValueAt(linha, 0).toString());

            abas.setSelectedIndex(1);

            textNome.setText(tabelaCliente.getValueAt(linha, 1).toString());
            textCpf.setText(tabelaCliente.getValueAt(linha, 2).toString());
            textIdade.setText(tabelaCliente.getValueAt(linha, 3).toString());
            comboboxStatus.setSelectedItem(tabelaCliente.getValueAt(linha, 4));
            textEmail.setText(tabelaCliente.getValueAt(linha, 5).toString());

            textCodigo.setEnabled(false);
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void tabelaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMousePressed

    }//GEN-LAST:event_tabelaClienteMousePressed

    private void botaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarActionPerformed
        modelo = (javax.swing.table.DefaultTableModel)tabelaCliente.getModel();

        ArrayList<ClientesBEAN> listaClientes = controle.listaClientes();
        try{
            preencher_tabela(listaClientes);
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Nenhum registro encontrado");
        }
    }//GEN-LAST:event_botaoListarActionPerformed

    private void textBuscaCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textBuscaCodigoFocusLost
        // textBuscaCodigo.setText("");
        textBuscaNome.setEnabled(true);
    }//GEN-LAST:event_textBuscaCodigoFocusLost

    private void textBuscaCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscaCodigoMouseClicked
        textBuscaNome.setText("");
        textBuscaNome.setEnabled(false);
    }//GEN-LAST:event_textBuscaCodigoMouseClicked

    private void textBuscaCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaCodigoKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_textBuscaCodigoKeyTyped

 
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
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelStatus;
    public javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField textBuscaCodigo;
    private javax.swing.JTextField textBuscaNome;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JFormattedTextField textCpf;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textIdade;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
