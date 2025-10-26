/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Gestor;
import backend.Serializacao;
import backend.Sistema;
import javax.swing.JOptionPane;

public class GestorInfoCentro extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private Gestor gestor;
    
    public GestorInfoCentro(Sistema sistema, Serializacao bd, Gestor gestor) {
        initComponents();
        this.sistema = sistema;
        this.gestor=gestor;
        this.bd=bd;
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        txtCodigo.setText(gestor.getCentroAtribuido().getCodigo());
        txtMorada.setText(gestor.getCentroAtribuido().getMorada());
        txtLocalidade.setText(gestor.getCentroAtribuido().getLocalidade());
        txtNumPostos.setText(String.valueOf(gestor.getCentroAtribuido().getNumPostos()));
        txtGestor.setText(gestor.getCentroAtribuido().getGestor().getUsername());
        txtNumVacinas.setText(String.valueOf(gestor.getCentroAtribuido().getNumVacAdministradas()));
        txtMaxMarcacoes.setText(String.valueOf(gestor.getCentroAtribuido().getNumMaxMarcacoes()));
    }
    
    private void guardar(){
        if (txtNumPostos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um numero de postos!");            
             txtNumPostos.requestFocus();
            return;
        }
        
        if (txtMaxMarcacoes.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um numero de marcações máximas!");            
             txtMaxMarcacoes.requestFocus();
            return;
        }
        
        int numMarc = Integer.parseInt(txtMaxMarcacoes.getText());
        int numPostos = Integer.parseInt(txtNumPostos.getText());
        gestor.getCentroAtribuido().setNumMaxMarcacoes(numMarc);
        gestor.getCentroAtribuido().setNumPostos(numPostos);
        
        JOptionPane.showMessageDialog(this, "Informações alteradas com sucesso!");
        guardarAlteracoes(); 
        dispose();
    }
    
    private void guardarAlteracoes() {
        bd.gravaSistema(sistema);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CodigoLabel = new javax.swing.JLabel();
        MoradaLabel = new javax.swing.JLabel();
        LocalidadeLabel = new javax.swing.JLabel();
        NumPostosLabel = new javax.swing.JLabel();
        GestorLabel = new javax.swing.JLabel();
        NumVacinasLabel = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtMorada = new javax.swing.JTextField();
        txtLocalidade = new javax.swing.JTextField();
        txtNumPostos = new javax.swing.JTextField();
        txtGestor = new javax.swing.JTextField();
        txtNumVacinas = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoGuardar = new javax.swing.JButton();
        txtMaxMarcacoes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(45, 62, 80));

        CodigoLabel.setForeground(new java.awt.Color(240, 240, 240));
        CodigoLabel.setText("Codigo ");

        MoradaLabel.setForeground(new java.awt.Color(240, 240, 240));
        MoradaLabel.setText("Morada");

        LocalidadeLabel.setForeground(new java.awt.Color(240, 240, 240));
        LocalidadeLabel.setText("Localidade");

        NumPostosLabel.setForeground(new java.awt.Color(240, 240, 240));
        NumPostosLabel.setText("NumPostos");

        GestorLabel.setForeground(new java.awt.Color(240, 240, 240));
        GestorLabel.setText("Gestor");

        NumVacinasLabel.setForeground(new java.awt.Color(240, 240, 240));
        NumVacinasLabel.setText("NumVacinasAdministradas");

        txtCodigo.setEditable(false);

        txtMorada.setEditable(false);

        txtLocalidade.setEditable(false);

        txtGestor.setEditable(false);

        txtNumVacinas.setEditable(false);

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("INFORMAÇÕES CENTRO");

        botaoGuardar.setText("Guardar");
        botaoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGuardarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Nº max de marcações");

        jPanel2.setBackground(new java.awt.Color(224, 60, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NumVacinasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GestorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NumPostosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LocalidadeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MoradaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CodigoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtMorada)
                            .addComponent(txtLocalidade)
                            .addComponent(txtNumPostos)
                            .addComponent(txtGestor)
                            .addComponent(txtNumVacinas)
                            .addComponent(txtMaxMarcacoes, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodigoLabel)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoradaLabel)
                    .addComponent(txtMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalidadeLabel)
                    .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GestorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumVacinasLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumPostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumPostosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoGuardar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
       dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(GestorInfoCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorInfoCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorInfoCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorInfoCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminInfoCentros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodigoLabel;
    private javax.swing.JLabel GestorLabel;
    private javax.swing.JLabel LocalidadeLabel;
    private javax.swing.JLabel MoradaLabel;
    private javax.swing.JLabel NumPostosLabel;
    private javax.swing.JLabel NumVacinasLabel;
    private javax.swing.JButton botaoGuardar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGestor;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMaxMarcacoes;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtNumPostos;
    private javax.swing.JTextField txtNumVacinas;
    // End of variables declaration//GEN-END:variables
}
