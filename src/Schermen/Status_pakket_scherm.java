
package Schermen;

import Pakketten.Pakket;
import javax.swing.*;

/**
 *
 * @author Olink
 */
public class Status_pakket_scherm extends javax.swing.JFrame {

    /**
     * Creates new form Status_pakket_scherm
     */
    public Status_pakket_scherm() {
        initComponents();
        
        Pakket p = new Pakket("Colin");
        
        this.jpakketid.setText("Status pakket #" + p.getPakketId());
        this.jkoerier.setText("Koerier: " + p.getTreinkoerier());
        
        
        
        this.setVisible(true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jpakketid = new javax.swing.JLabel();
        jkoerier = new javax.swing.JLabel();
        jopgehaald = new javax.swing.JLabel();
        jafgeleverd = new javax.swing.JLabel();
        jopgehaaldbutton = new javax.swing.JRadioButton();
        jafgeleverdbutton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1193, 579));

        jpakketid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jpakketid.setText("jpakketid");

        jkoerier.setText("jkoerier");

        jopgehaald.setText("Opgehaald:");

        jafgeleverd.setText("Afgeleverd:");

        jopgehaaldbutton.setText("jRadioButton1");
        jopgehaaldbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jopgehaaldbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jopgehaaldbuttonActionPerformed(evt);
            }
        });

        jafgeleverdbutton.setText("jRadioButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jkoerier)
                            .addComponent(jpakketid)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jopgehaald, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jafgeleverd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jafgeleverdbutton)
                                    .addComponent(jopgehaaldbutton))))))
                .addContainerGap(903, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jpakketid)
                .addGap(44, 44, 44)
                .addComponent(jkoerier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jopgehaald, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jopgehaaldbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jafgeleverd)
                    .addComponent(jafgeleverdbutton))
                .addContainerGap(351, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jopgehaaldbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jopgehaaldbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jopgehaaldbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(Status_pakket_scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status_pakket_scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status_pakket_scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status_pakket_scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Status_pakket_scherm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jafgeleverd;
    private javax.swing.JRadioButton jafgeleverdbutton;
    private javax.swing.JLabel jkoerier;
    private javax.swing.JLabel jopgehaald;
    private javax.swing.JRadioButton jopgehaaldbutton;
    private javax.swing.JLabel jpakketid;
    // End of variables declaration//GEN-END:variables
}
