/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Serializacao;
import backend.Sistema;
import backend.Utente;
import javax.swing.JOptionPane;


public class UtenteAlterarDados extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;
    private Utente utente;
    /**
     * Creates new form UtenteAlterarDados
     * @param sistema
     * @param bd
     * @param utente
     */
    public UtenteAlterarDados(Sistema sistema, Serializacao bd, Utente utente) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.utente=utente;
        
        this.setLocationRelativeTo(null);
        
        txtData.setText(String.valueOf(utente.getDataNasc()));
        
        if (utente.getCentro() ==null){
            txtCentro.setText("Nao tem centro atribuido");
        }else{
            txtCentro.setText(String.valueOf(utente.getCentro().getCodigo()));
        }
        if (utente.getCentro() ==null){
            txtCentro.setText("Nao tem centro atribuido");
        }else{
            txtCentro.setText(String.valueOf(utente.getCentro().getCodigo()));
        }

        if(utente.isTomouVacina()==true){
            txtTomou.setText("Sim");
            txtVacina.setText(String.valueOf(utente.getVacina().getNomeVacina()));
        }else{
            if(utente.getNumTomas()>0) {
            txtTomou.setText("Nao");
            txtVacina.setText(String.valueOf(utente.getVacina().getNomeVacina()));
        }else{
            txtTomou.setText("Nao");
            txtVacina.setText("Sem tomas"); 
            }
        } 
        /*
        if(utente.isTomouVacina()==true){
            txtTomou.setText("Sim");
            txtVacina.setText(String.valueOf(utente.getVacina()));
        }else{
            txtTomou.setText("Nao");
            txtVacina.setText(String.valueOf(utente.getVacina()));
        }
        */
        if (utente.getDoencas()!=null){
            txtDoencas.setText(String.join(",", utente.getDoencasPrevias()));
        }else{
            txtDoencas.setText("Não tem doenças prévias");
        }

        txtNome.setText(utente.getNome());
        txtUser.setText(utente.getUsername());
        txtMorada.setText(utente.getMorada());
        txtLocalidade.setText(utente.getLocalidade());
        txtTlm.setText(String.valueOf(utente.getContactoTlm()));
        txtEmail.setText(utente.getEmail());      
    }
     
    private void guardar(){
        if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu username!");            
            txtUser.requestFocus();
            return;
        }
        
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu nome!");            
            txtNome.requestFocus();
            return;
        }
        
        if (txtMorada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua morada!");            
            txtMorada.requestFocus();
            return;
        }
        
        if (txtLocalidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua localidade!");            
            txtLocalidade.requestFocus();
            return;
        }
        
        if (txtTlm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o numero do seu telemovel!");            
            txtTlm.requestFocus();
            return;
        }
        
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu email!");            
            txtEmail.requestFocus();
            return;
        }
        
        if (txtSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza a nova password!");
            txtSenha.requestFocus();
            return;
        }       
        
        if (txtConfirmacao.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza a password de confirmação!");
            txtConfirmacao.requestFocus();
            return;
        } 
        
        String password = new String(txtSenha.getPassword());
        
        if (!password.equals(new String(txtConfirmacao.getPassword()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            txtConfirmacao.requestFocus();
            return;
        }else{
            utente.setPassword(password);
            JOptionPane.showMessageDialog(this, "Password alterada com sucesso!");
            dispose();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botaoGuardar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtMorada = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtTlm = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCentro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTomou = new javax.swing.JTextField();
        txtDoencas = new javax.swing.JTextField();
        txtVacina = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(45, 62, 80));
        jPanel1.setForeground(new java.awt.Color(45, 62, 80));

        jPanel2.setBackground(new java.awt.Color(224, 60, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        botaoGuardar.setText("Guardar");
        botaoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGuardarActionPerformed(evt);
            }
        });

        botaoFechar.setText("Fechar");
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Username");

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Nome");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Morada");

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Localidade");

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Data nascimento");

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Telemovel");

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Email");

        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Centro Vacinacao");

        txtData.setEditable(false);

        txtCentro.setEditable(false);

        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Vacina");

        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Vacinado?");

        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Doencas Previas");

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Nova Password");

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Confirmar Passe");

        txtTomou.setEditable(false);

        txtDoencas.setEditable(false);

        txtVacina.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser)
                    .addComponent(txtNome)
                    .addComponent(txtMorada)
                    .addComponent(txtLocalidade)
                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtTlm)
                    .addComponent(txtEmail)
                    .addComponent(txtCentro))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVacina)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoGuardar)
                                .addGap(35, 35, 35)
                                .addComponent(botaoFechar))
                            .addComponent(txtTomou)
                            .addComponent(txtDoencas)
                            .addComponent(txtSenha)
                            .addComponent(txtConfirmacao))))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTomou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar)
                    .addComponent(botaoGuardar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_botaoGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(UtenteAlterarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UtenteAlterarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UtenteAlterarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UtenteAlterarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new UtenteAlterarDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCentro;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDoencas;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTlm;
    private javax.swing.JTextField txtTomou;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVacina;
    // End of variables declaration//GEN-END:variables
}
