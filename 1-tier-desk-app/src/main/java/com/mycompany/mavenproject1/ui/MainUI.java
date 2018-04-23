package com.mycompany.mavenproject1.ui;

import com.mycompany.mavenproject1.business.FacadeCountryCustomer;

public class MainUI extends javax.swing.JFrame {

    private FacadeCountryCustomer facade;

    /**
     * Creates new form MainWindow
     */
    public MainUI() {
        initComponents();
        this.facade = new FacadeCountryCustomer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerbt = new javax.swing.JButton();
        countrybt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My SA App");
        setMinimumSize(new java.awt.Dimension(300, 150));
        setPreferredSize(new java.awt.Dimension(300, 150));

        customerbt.setText("Customer");
        customerbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtActionPerformed(evt);
            }
        });
        getContentPane().add(customerbt, java.awt.BorderLayout.PAGE_START);

        countrybt.setText("Country");
        countrybt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countrybtActionPerformed(evt);
            }
        });
        getContentPane().add(countrybt, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void countrybtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countrybtActionPerformed
        new CountryUI(facade).setVisible(true);
    }//GEN-LAST:event_countrybtActionPerformed

    private void customerbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtActionPerformed
        new CustomerUI(facade).setVisible(true);
    }//GEN-LAST:event_customerbtActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton countrybt;
    private javax.swing.JButton customerbt;
    // End of variables declaration//GEN-END:variables
}
