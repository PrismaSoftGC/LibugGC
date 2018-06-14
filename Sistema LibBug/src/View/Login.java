package View;

import Controller.Controle;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

  static Controle controle = new Controle();
  
    public Login() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        textLogin = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        botaoAutentica = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        labelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setBackground(new java.awt.Color(0, 0, 0));
        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTitulo.setText("Autenticação do Funcionário");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 26));
        getContentPane().add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 148, 27));
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 148, 29));

        labelLogin.setBackground(new java.awt.Color(0, 0, 0));
        labelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelLogin.setText("Login");
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        labelSenha.setBackground(new java.awt.Color(0, 0, 0));
        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSenha.setText("Senha");
        getContentPane().add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        botaoAutentica.setText("Autenticar");
        botaoAutentica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutenticaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAutentica, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, 34));

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, 34));
        getContentPane().add(labelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAutenticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutenticaActionPerformed
        String login = textLogin.getText();
        String senha = textSenha.getText();

        try {

            boolean autenticacao = controle.autenticUser(login, senha);

            if (autenticacao == true) {
                TelaMenu menu = new TelaMenu();
                menu.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Usuario ou senha incorreto", "Erro de login", JOptionPane.ERROR_MESSAGE, null);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login ou senha errado");
        }
    }//GEN-LAST:event_botaoAutenticaActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        CadastroUsuario cadUser = new CadastroUsuario(this,true);
        cadUser.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarActionPerformed
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAutentica;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JLabel labelFundo;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textLogin;
    private javax.swing.JTextField textSenha;
    // End of variables declaration//GEN-END:variables
}
