package View;

import Controller.Controle;
import Model.AuxEmprestimoObraBEAN;
import Model.ClientesBEAN;
import Model.EmprestimoBEAN;
import Model.ObrasBEAN;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class RelatorioEmprestimos extends javax.swing.JDialog {
    
    private javax.swing.table.DefaultTableModel modelo1; 
    
    static  Controle controle = new Controle();
    DefaultTableModel modelo;

    public RelatorioEmprestimos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();   
        modelo = (DefaultTableModel) tabela_emp.getModel();
        modelo.setNumRows(0);
        cb_data.setEnabled(false);         
    }
    
    private void prencherTabela(ArrayList<EmprestimoBEAN> list){
        
        tabela_emp.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela_emp.getColumnModel().getColumn(1).setPreferredWidth(700);
        tabela_emp.getColumnModel().getColumn(2).setPreferredWidth(600);
        tabela_emp.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabela_emp.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        modelo.setNumRows(0);
        
        for (EmprestimoBEAN emp : list){
            ClientesBEAN cliente = controle.findClienteCodigo(emp.getCodigoCliente());
            ArrayList<AuxEmprestimoObraBEAN> aux = controle.listaAuxEmprestimo(emp.getCodigoEmprestimo());
            ObrasBEAN obra = null;
            for( AuxEmprestimoObraBEAN au : aux){
                obra = controle.findObraCodigo(au.getCodigoObra());
                modelo.addRow(new Object[]{emp.getCodigoEmprestimo(),obra.getTitulo(), 
                    cliente.getNome(), emp.getSaida(),emp.getDevolucao()});
            }       
        }      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEditora = new javax.swing.JLabel();
        cb_data = new com.toedter.calendar.JDateChooser();
        labelTitulo2 = new javax.swing.JLabel();
        radio2 = new javax.swing.JRadioButton();
        botaoPDF = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_emp = new javax.swing.JTable();
        botaoBusca1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(930, 510));
        setPreferredSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEditora.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelEditora.setForeground(new java.awt.Color(204, 204, 204));
        labelEditora.setText("Relatório de empréstimo");
        getContentPane().add(labelEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        getContentPane().add(cb_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 110, 30));

        labelTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTitulo2.setText("Data de devolução");
        getContentPane().add(labelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 120, -1));

        radio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio2ActionPerformed(evt);
            }
        });
        getContentPane().add(radio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 20, -1));

        botaoPDF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Save_37110 (1).png"))); // NOI18N
        botaoPDF.setText("PDF");
        botaoPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPDFActionPerformed(evt);
            }
        });
        getContentPane().add(botaoPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 140, 30));

        tabela_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Obra", "Cliente", "D. EMP", "D. DEV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane4.setViewportView(tabela_emp);
        if (tabela_emp.getColumnModel().getColumnCount() > 0) {
            tabela_emp.getColumnModel().getColumn(0).setResizable(false);
            tabela_emp.getColumnModel().getColumn(1).setResizable(false);
            tabela_emp.getColumnModel().getColumn(2).setResizable(false);
            tabela_emp.getColumnModel().getColumn(3).setResizable(false);
            tabela_emp.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 875, 390));

        botaoBusca1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoBusca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/search-good_icon-icons.com_51027.png"))); // NOI18N
        botaoBusca1.setText("Pesquisar");
        botaoBusca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBusca1ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBusca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 140, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio2ActionPerformed
        if(radio2.isSelected()){
            if(cb_data.isEnabled() == false){

                cb_data.setEnabled(true);
            }

        }
    }//GEN-LAST:event_radio2ActionPerformed

    private void botaoPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPDFActionPerformed
        ArrayList<EmprestimoBEAN> aux;
        if (cb_data.isEnabled()) {
            Date data = new Date(cb_data.getDate().getTime());
            aux = controle.findEmprestimoData(data);
        }else{
            Date data =  new Date(100);
            aux = controle.findEmprestimoData(data);
        }  
        prencherTabela(aux);
    }//GEN-LAST:event_botaoPDFActionPerformed

    private void botaoBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBusca1ActionPerformed
        ArrayList<EmprestimoBEAN> aux;
        if (cb_data.isEnabled()) {
            Date data = new Date(cb_data.getDate().getTime());
            aux = controle.findEmprestimoData(data);
        }else{
            Date data =  new Date(new java.util.Date().getTime());
            aux = controle.findEmprestimoData(data);
        }  
        prencherTabela(aux);
    }//GEN-LAST:event_botaoBusca1ActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioEmprestimos dialog = new RelatorioEmprestimos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoBusca1;
    private javax.swing.JButton botaoPDF;
    private com.toedter.calendar.JDateChooser cb_data;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JTable tabela_emp;
    // End of variables declaration//GEN-END:variables
}
