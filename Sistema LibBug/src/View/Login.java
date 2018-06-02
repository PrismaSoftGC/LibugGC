package View;

import Controller.Controle;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

static Controle controle = new Controle();
    
    public Login() {
        initComponents();
        textLogin.getFocusAccelerator();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textLogin = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        botaoAutentica = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Autenticação do Funcionário");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 26));
        getContentPane().add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 148, 27));
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 148, 29));

        labelLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(204, 204, 204));
        labelLogin.setText("Login");
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        labelSenha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(204, 204, 204));
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/background-670936_960_720.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        CadastroUsuario cadUser = new CadastroUsuario(this,true);
        cadUser.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAutentica;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JTextField textLogin;
    private javax.swing.JTextField textSenha;
    // End of variables declaration//GEN-END:variables
}
