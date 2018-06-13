package View;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
      initComponents();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        botaoCliente = new javax.swing.JButton();
        textCliente = new javax.swing.JLabel();
        botaoAutor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botaoEditora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoObra = new javax.swing.JButton();
        labelEmprestimo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botaoRelatorio = new javax.swing.JButton();
        botaoEmprestimo = new javax.swing.JButton();
        labelEmprestimo2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jLabel2.setText("jLabel2");

        jButton2.setText("jButton2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/user_person_people_6100.png"))); // NOI18N
        botaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 82, 93));

        textCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textCliente.setText("Cliente");
        getContentPane().add(textCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 60, -1));

        botaoAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Wordpad_icon-icons.com_55518.png"))); // NOI18N
        botaoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutorActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 93));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Autor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        botaoEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/editnote_edi_9512.png"))); // NOI18N
        botaoEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Editora");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        botaoObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/book-bookmark-icon_34486.png"))); // NOI18N
        botaoObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoObraActionPerformed(evt);
            }
        });
        getContentPane().add(botaoObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 80, 90));

        labelEmprestimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEmprestimo.setText("Relatório de Empréstimo");
        getContentPane().add(labelEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/logo keyse.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 183, 127));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/logo keyse.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 183, 127));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Obra");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        botaoRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/iconeEmprestimo.png"))); // NOI18N
        botaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 80, 90));

        botaoEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/iconeEmprestimo.png"))); // NOI18N
        botaoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEmprestimoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 80, 90));

        labelEmprestimo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEmprestimo2.setText("Emprestimo");
        getContentPane().add(labelEmprestimo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));
        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoClienteActionPerformed
     
     Cliente cliente = new Cliente(this,true);
     cliente.setVisible(true);
       
    }//GEN-LAST:event_botaoClienteActionPerformed

    private void botaoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutorActionPerformed
       Autor autor = new Autor(this,true);
       autor.setVisible(true);
      
    }//GEN-LAST:event_botaoAutorActionPerformed

    private void botaoEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditoraActionPerformed
        Editora editora = new Editora(this,true);
        editora.setVisible(true);
    }//GEN-LAST:event_botaoEditoraActionPerformed

    private void botaoObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoObraActionPerformed
        Obra obra = new Obra(this,true);
        obra.setVisible(true);
    }//GEN-LAST:event_botaoObraActionPerformed

    private void botaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioActionPerformed
       RelatorioEmprestimos rel = new RelatorioEmprestimos(this,true);
       rel.setVisible(true);
    }//GEN-LAST:event_botaoRelatorioActionPerformed

    private void botaoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEmprestimoActionPerformed
        Emprestimo emp = new Emprestimo(this,true);
        emp.setVisible(true);
    }//GEN-LAST:event_botaoEmprestimoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAutor;
    private javax.swing.JButton botaoCliente;
    private javax.swing.JButton botaoEditora;
    private javax.swing.JButton botaoEmprestimo;
    private javax.swing.JButton botaoObra;
    private javax.swing.JButton botaoRelatorio;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelEmprestimo;
    private javax.swing.JLabel labelEmprestimo2;
    private javax.swing.JLabel textCliente;
    // End of variables declaration//GEN-END:variables
}
