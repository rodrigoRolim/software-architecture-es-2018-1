package com.mycompany.mavenproject1.ui;

import com.mycompany.mavenproject1.business.FacadeCountryCustomer;
import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import javax.swing.JOptionPane;

public class CustomerUI extends javax.swing.JFrame {

    private FacadeCountryCustomer facade = new FacadeCountryCustomer();
    
    private Country selectedCountry;

    /**
     * Creates new form CustomerUI
     */
    public CustomerUI() {
        initComponents();
    }

    CustomerUI(FacadeCountryCustomer facade) {
        this();

        this.facade = facade;
      

        this.facade.readAllCountry().forEach(item -> countrycombo.addItem(item.getName()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelbt = new javax.swing.JPanel();
        createbt = new javax.swing.JButton();
        listbt = new javax.swing.JButton();
        panelfield = new javax.swing.JPanel();
        namelb = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        agelb = new javax.swing.JLabel();
        agetxt = new javax.swing.JTextField();
        phonelb = new javax.swing.JLabel();
        phonetxt = new javax.swing.JTextField();
        countrylb = new javax.swing.JLabel();
        countrycombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listarea = new javax.swing.JTextArea();

        setTitle("Customer Management");
        setPreferredSize(new java.awt.Dimension(500, 250));

        createbt.setText("Create");
        createbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbtActionPerformed(evt);
            }
        });
        panelbt.add(createbt);

        listbt.setText("List");
        listbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listbtActionPerformed(evt);
            }
        });
        panelbt.add(listbt);

        getContentPane().add(panelbt, java.awt.BorderLayout.PAGE_END);

        panelfield.setLayout(new java.awt.GridLayout(4, 2));

        namelb.setText("Name");
        panelfield.add(namelb);

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        panelfield.add(nametxt);

        agelb.setText("Age");
        panelfield.add(agelb);
        panelfield.add(agetxt);

        phonelb.setText("Phone");
        panelfield.add(phonelb);
        panelfield.add(phonetxt);

        countrylb.setText("Country");
        panelfield.add(countrylb);

        countrycombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countrycomboActionPerformed(evt);
            }
        });
        panelfield.add(countrycombo);

        getContentPane().add(panelfield, java.awt.BorderLayout.NORTH);

        listarea.setColumns(20);
        listarea.setRows(5);
        jScrollPane1.setViewportView(listarea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listbtActionPerformed

        listarea.setText(facade.readAllCustomersToString());
    }//GEN-LAST:event_listbtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void createbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbtActionPerformed
        Customer c = new Customer();

        try {
            c.setName(nametxt.getText());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        try {
            c.setCountry(selectedCountry);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        try {
            c.setPhone(phonetxt.getText());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        c.setAge(new Integer(agetxt.getText()));
        c.setCreditLimit(0);

        try {
            facade.create(c);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_createbtActionPerformed

    private void countrycomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countrycomboActionPerformed

        for (Country currentCountry : facade.readAllCountry()) {
            if (currentCountry.getName().equalsIgnoreCase((String) countrycombo.getSelectedItem())) {
                selectedCountry = currentCountry;
            }
        }
    }//GEN-LAST:event_countrycomboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agelb;
    private javax.swing.JTextField agetxt;
    private javax.swing.JComboBox<String> countrycombo;
    private javax.swing.JLabel countrylb;
    private javax.swing.JButton createbt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listarea;
    private javax.swing.JButton listbt;
    private javax.swing.JLabel namelb;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPanel panelbt;
    private javax.swing.JPanel panelfield;
    private javax.swing.JLabel phonelb;
    private javax.swing.JTextField phonetxt;
    // End of variables declaration//GEN-END:variables
}
