
package View;

import Model.AutoresBEAN;
import static View.Autor.controle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BuscaAutor extends javax.swing.JDialog {
    
    private JFrame parent;
    private JDialog par;
    
    private javax.swing.table.DefaultTableModel modelo;
    
    public BuscaAutor(java.awt.Dialog parent, boolean modal, String nome, JDialog p){
        super(parent, modal);
        
        initComponents();
        this.par = p;
        modelo = (javax.swing.table.DefaultTableModel) tbBuscaAutor.getModel();

        ArrayList<AutoresBEAN> listaAutores = new ArrayList<AutoresBEAN>();
        listaAutores = controle.findAutorNome(nome);
        preencher_tabela(listaAutores);
    }

     public void preencher_tabela(ArrayList<AutoresBEAN> listaAutores) {
        modelo.setNumRows(0);

        try {
            for (AutoresBEAN autor : listaAutores) {
                modelo.addRow(new Object[]{autor.getCodigoAutor(), autor.getNome(), autor.getCpf(), autor.getStatus(), autor.getConteudo()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados - " + erro);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuscaAutor = new javax.swing.JTable();
        pesqAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoBusca = new javax.swing.JButton();
        botaoAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbBuscaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF", "Status", "Conteudo"
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
        tbBuscaAutor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbBuscaAutor);

        pesqAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesqAutorKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Pesquise aqui o autor");

        botaoBusca.setText("Buscar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });

        botaoAdd.setText("Adicionar");
        botaoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(650, Short.MAX_VALUE)
                .addComponent(botaoAdd)
                .addGap(83, 83, 83))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(pesqAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(81, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(botaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel2)
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesqAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pesqAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqAutorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            JOptionPane.showMessageDialog(null, "enter pressionado");
        }
    }//GEN-LAST:event_pesqAutorKeyPressed

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        
        ArrayList<AutoresBEAN> listaAutores;
        listaAutores = controle.findAutorNome(pesqAutor.getText());
        preencher_tabela(listaAutores); 
        
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void botaoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddActionPerformed
        AutoresBEAN autor = new AutoresBEAN();
        int linha = tbBuscaAutor.getSelectedRow();
        
        autor.setCodigoAutor((int) tbBuscaAutor.getValueAt(linha, 0));
        autor.setNome((String) tbBuscaAutor.getValueAt(linha, 1));
      
        
        Obra obra = (Obra) par;
        obra.preencher_tabela(autor);
        obra.setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_botaoAddActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoBusca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesqAutor;
    private javax.swing.JTable tbBuscaAutor;
    // End of variables declaration//GEN-END:variables
}
