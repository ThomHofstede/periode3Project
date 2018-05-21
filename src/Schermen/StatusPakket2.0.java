/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schermen;

import Pakketten.Pakketlevering;

/**
 *
 * @author Jeffrey
 */
public class StatusPakket extends javax.swing.JFrame {

    /**
     * Creates new form StatusPakket
     */
    public StatusPakket(String pakket, String gebruikersnaam) {
        initComponents();
        
        this.pakketID = pakket;
        this.gebruikersnaam = gebruikersnaam;
        
        this.jLabel_ID.setText(pakket);
        
        Pakketlevering p = new Pakketlevering(this.gebruikersnaam);
        
        this.jLabel_Koerier.setText(this.gebruikersnaam);
        this.jAfgevelerd.setSelected(p.getAfgeleverd());
        this.jOpgehaald.setSelected(p.getOpgehaald());
        this.jIncident.setSelected(p.getIncident());
        
        this.jWijziging.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel_ID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Koerier = new javax.swing.JLabel();
        jOpgehaald = new javax.swing.JRadioButton();
        jAfgevelerd = new javax.swing.JRadioButton();
        jIncident = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jIncidentBeschrijving = new javax.swing.JTextArea();
        jVerzenden = new javax.swing.JButton();
        jTerug = new javax.swing.JButton();
        jWijziging = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_ID.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 48)); // NOI18N
        jLabel_ID.setText("PakketID");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("Koerier");

        jLabel_Koerier.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel_Koerier.setText("<NAAM>");

        buttonGroup1.add(jOpgehaald);
        jOpgehaald.setText("Opgehaald");

        buttonGroup1.add(jAfgevelerd);
        jAfgevelerd.setText("Afgeleverd");

        buttonGroup1.add(jIncident);
        jIncident.setText("Incident");

        jIncidentBeschrijving.setColumns(20);
        jIncidentBeschrijving.setRows(5);
        jIncidentBeschrijving.setText("incident...");
        jScrollPane1.setViewportView(jIncidentBeschrijving);

        jVerzenden.setText("Verzenden");
        jVerzenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerzendenActionPerformed(evt);
            }
        });

        jTerug.setText("Terug");
        jTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTerugActionPerformed(evt);
            }
        });

        jWijziging.setForeground(new java.awt.Color(255, 51, 51));
        jWijziging.setText("Wijzigingen zijn opgeslagen!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ID)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel_Koerier))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jIncident, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAfgevelerd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addComponent(jOpgehaald, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jVerzenden)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jWijziging)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTerug))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel_ID)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_Koerier))
                .addGap(39, 39, 39)
                .addComponent(jOpgehaald, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAfgevelerd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIncident, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVerzenden)
                    .addComponent(jTerug)
                    .addComponent(jWijziging))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jVerzendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerzendenActionPerformed
        //Updaten pakket's informatie gebasseerd op de aangevinkte radiobuttons
        Pakketlevering p = new Pakketlevering(this.gebruikersnaam);
        if (this.jOpgehaald.isSelected()) {
            p.updatePakket(p.getRol(), "opgehaald");
            this.jWijziging.setVisible(true);
        }
        if (this.jAfgevelerd.isSelected()) {
            p.updatePakket(p.getRol(), "afgeleverd");
            this.jWijziging.setVisible(true);
        }
        if (this.jIncident.isSelected()) {
            p.updatePakket(p.getRol(), "incident", this.jIncidentBeschrijving.getText());
            this.jWijziging.setVisible(true);
        }
    }//GEN-LAST:event_jVerzendenActionPerformed

    private void jTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTerugActionPerformed
        Treinkoerier_dashboard tb = new Treinkoerier_dashboard(this.gebruikersnaam);
        this.setVisible(false);
    }//GEN-LAST:event_jTerugActionPerformed

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
            java.util.logging.Logger.getLogger(StatusPakket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusPakket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusPakket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusPakket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and jLabel_ID the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jAfgevelerd;
    private javax.swing.JRadioButton jIncident;
    private javax.swing.JTextArea jIncidentBeschrijving;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel_ID;
    private javax.swing.JLabel jLabel_Koerier;
    private javax.swing.JRadioButton jOpgehaald;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jTerug;
    private javax.swing.JButton jVerzenden;
    private javax.swing.JLabel jWijziging;
    // End of variables declaration//GEN-END:variables
    private String gebruikersnaam;
    private String pakketID;
    




}
