package br.com.clinicaxuliapoo.telas;
import java.sql.*;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import javax.swing.JOptionPane;

public class LoginCliente extends javax.swing.JFrame {

    /**
     * Creates new form LoginCliente
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar() {
        String sql = "select * from tb_clientes where cpf_cliente=? and senha_cliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campo_login.getText());
            pst.setString(2, campo_senha.getText());
            String captura = new String (campo_senha.getPassword());
            pst.setString(2, captura);
            rs = pst.executeQuery();
            if (rs.next()) {
                MenuCliente menucli = new MenuCliente();
                menucli.setVisible(true);
                MenuCliente.lblUser.setText(rs.getString(2));
                this.dispose();
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha inválidos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cadastrar(){
        TelaCadastro telcad = new TelaCadastro();
        telcad.setVisible(true);
        this.dispose();
    }
    
    public void entrarVet(){
        LoginVeterinario lognvet = new LoginVeterinario();
        lognvet.setVisible(true);
        this.dispose();
    }
    
    public void entrarAdmin(){
        LoginAdministrador lognadm = new LoginAdministrador();
        lognadm.setVisible(true);
        this.dispose();
    }
    
    public void esqueciSenha(){}
    
    public LoginCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
        // apoio ao status de conexao -> System.out.println(conexao);
        if (conexao != null) {
            label_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/database_sucess.png")));
        } else {
            label_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/database_fail.png")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campo_senha = new javax.swing.JPasswordField();
        botao_login = new javax.swing.JButton();
        botao_cad = new javax.swing.JButton();
        label_status = new javax.swing.JLabel();
        vetlog = new javax.swing.JLabel();
        esqueceu_senha = new javax.swing.JButton();
        logvet = new javax.swing.JButton();
        logadm = new javax.swing.JButton();
        campo_login = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Veterinária Xulia's");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("Senha");

        botao_login.setBackground(new java.awt.Color(153, 204, 255));
        botao_login.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        botao_login.setText("Entrar");
        botao_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_loginActionPerformed(evt);
            }
        });

        botao_cad.setBackground(new java.awt.Color(153, 204, 255));
        botao_cad.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        botao_cad.setText("Cadastre-se");
        botao_cad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao_cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadActionPerformed(evt);
            }
        });

        label_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/database_sucess.png"))); // NOI18N
        label_status.setText("status");

        vetlog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        esqueceu_senha.setText("Esqueci minha senha.");
        esqueceu_senha.setBorder(null);
        esqueceu_senha.setBorderPainted(false);
        esqueceu_senha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esqueceu_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqueceu_senhaActionPerformed(evt);
            }
        });

        logvet.setText("Entrar como Veterinário.");
        logvet.setBorder(null);
        logvet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logvet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logvetActionPerformed(evt);
            }
        });

        logadm.setText("Entrar como Admin.");
        logadm.setBorder(null);
        logadm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logadmActionPerformed(evt);
            }
        });

        try {
            campo_login.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vetlog)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logvet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logadm)
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_cad)
                        .addGap(18, 18, 18)
                        .addComponent(botao_login, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(label_status, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(esqueceu_senha)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campo_login)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(esqueceu_senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_login, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vetlog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logvet)
                    .addComponent(logadm))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(351, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_loginActionPerformed
        //chamando o metodo logar
        logar();
    }//GEN-LAST:event_botao_loginActionPerformed

    private void botao_cadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadActionPerformed
        cadastrar();
    }//GEN-LAST:event_botao_cadActionPerformed

    private void logvetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logvetActionPerformed
        entrarVet();
    }//GEN-LAST:event_logvetActionPerformed

    private void logadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logadmActionPerformed
        entrarAdmin();
    }//GEN-LAST:event_logadmActionPerformed

    private void esqueceu_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqueceu_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esqueceu_senhaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cad;
    private javax.swing.JButton botao_login;
    private javax.swing.JFormattedTextField campo_login;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JButton esqueceu_senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_status;
    private javax.swing.JButton logadm;
    private javax.swing.JButton logvet;
    private javax.swing.JLabel vetlog;
    // End of variables declaration//GEN-END:variables
}
