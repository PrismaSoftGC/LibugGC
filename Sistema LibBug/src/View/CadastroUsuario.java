package View;

import Controller.Controle;
import Model.UsuariosBEAN;
import javax.swing.JOptionPane;

public class CadastroUsuario extends javax.swing.JDialog {
    
    static Controle controle = new Controle();

    public CadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textLoginAdmin = new javax.swing.JTextField();
        textSenhaAdmin = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        textSenhaNovo = new javax.swing.JPasswordField();
        textLoginNovo = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        labelLogin1 = new javax.swing.JLabel();
        labelSenha1 = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        labelAutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(textLoginAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 148, 27));
        getContentPane().add(textSenhaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 148, 29));

        labelLogin.setBackground(new java.awt.Color(0, 0, 0));
        labelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelLogin.setText("Login Administrador");
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        labelSenha.setBackground(new java.awt.Color(0, 0, 0));
        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSenha.setText("Senha Administrador");
        getContentPane().add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, 30));
        getContentPane().add(textSenhaNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 148, 29));
        getContentPane().add(textLoginNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 148, 27));
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 148, 27));

        labelNome.setBackground(new java.awt.Color(0, 0, 0));
        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNome.setText("Nome ");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selecione o perfil do usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionario", "Administrador" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 165, 30));

        labelLogin1.setBackground(new java.awt.Color(0, 0, 0));
        labelLogin1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelLogin1.setText("Login");
        getContentPane().add(labelLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        labelSenha1.setBackground(new java.awt.Color(0, 0, 0));
        labelSenha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSenha1.setText("Senha");
        getContentPane().add(labelSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        labelInfo.setBackground(new java.awt.Color(0, 0, 0));
        labelInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelInfo.setText("Informações sobre o novo usuario");
        getContentPane().add(labelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        labelAutor.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelAutor.setText("Cadastro de Usuarios");
        getContentPane().add(labelAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

      public void Limpar() {
        textLoginAdmin.setText("");
        textSenhaAdmin.setText("");
        textLoginNovo.setText("");
        textSenhaNovo.setText("");
        textNome.setText("");
    }
      
    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed

        String loginAdmin = textLoginAdmin.getText();
        String senhaAdmin = textSenhaAdmin.getText();

        try {

            //1 representa perfil administrador
            //0 representa perfil funcionario
            boolean autenticaSuper = controle.autenticAdmin(loginAdmin, senhaAdmin, 1);

            if (autenticaSuper == true) {
                String nomeNovo = textNome.getText();
                String loginNovo = textLoginNovo.getText();
                String senhaNovo = textSenhaNovo.getText();

                int perfil;

                if (comboTipo.getSelectedIndex() == 0) {
                    perfil = 0;
                } else {
                    perfil = 1;
                }

                boolean existencia = controle.isExistUser(loginNovo);

                if(existencia == false){
                    UsuariosBEAN usuario = new UsuariosBEAN(perfil, loginNovo, senhaNovo, nomeNovo);
                    controle.addUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                    Limpar();
                    this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Já existe um usuario com este login, tente outro", "Erro de cadastro", JOptionPane.ERROR_MESSAGE, null);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Dados invalidos do supervisor", "Erro de cadastro", JOptionPane.ERROR_MESSAGE, null);
            }

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Exception: " + e.toString());
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelLogin1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSenha1;
    private javax.swing.JTextField textLoginAdmin;
    private javax.swing.JTextField textLoginNovo;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textSenhaAdmin;
    private javax.swing.JTextField textSenhaNovo;
    // End of variables declaration//GEN-END:variables
}
