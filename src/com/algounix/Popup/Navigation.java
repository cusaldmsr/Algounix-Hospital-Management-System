/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.algounix.Popup;

import com.algounix.Dashboards.DashboardAdmin;
import com.algounix.Dashboards.DashboardBackOffice;
import com.algounix.Dashboards.DashboardDoctor;
import com.algounix.Dashboards.DashboardPharmacy;
import com.algounix.Dashboards.DashboardReception;
import com.algounix.GUI.SignOut;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author kusal
 */
public class Navigation extends javax.swing.JPanel {

    /**
     * Creates new form Navigation
     */
    public Navigation() {
        setOpaque(false);
        initComponents();

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminICO = new javax.swing.JLabel();
        receptionICO = new javax.swing.JLabel();
        doctorICO = new javax.swing.JLabel();
        pharmacyICO = new javax.swing.JLabel();
        backOfficeICO = new javax.swing.JLabel();
        signOutICO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        adminICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/Admin.png"))); // NOI18N
        adminICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminICOMouseClicked(evt);
            }
        });

        receptionICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receptionICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/calendar-appointment.png"))); // NOI18N
        receptionICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionICOMouseClicked(evt);
            }
        });

        doctorICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/stethoscope.png"))); // NOI18N
        doctorICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorICOMouseClicked(evt);
            }
        });

        pharmacyICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pharmacyICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/medicine.png"))); // NOI18N
        pharmacyICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacyICOMouseClicked(evt);
            }
        });

        backOfficeICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backOfficeICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/ambulance.png"))); // NOI18N
        backOfficeICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backOfficeICOMouseClicked(evt);
            }
        });

        signOutICO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOutICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/PNG/unlock-padlock.png"))); // NOI18N
        signOutICO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutICOMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins Light", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Navigation Panel");

        jLabel2.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Dashboard");

        jLabel3.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reception ");

        jLabel4.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Doctor");

        jLabel5.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SignOut");

        jLabel6.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Back Office");

        jLabel7.setFont(new java.awt.Font("Poppins Light", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pharmacy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(adminICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(pharmacyICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backOfficeICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(signOutICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(receptionICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(doctorICO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorICO, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receptionICO, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminICO, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pharmacyICO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signOutICO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backOfficeICO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adminICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminICOMouseClicked
        // TODO add your handling code here:

        DashboardAdmin newFrame = new DashboardAdmin();
        newFrame.setVisible(true);
        GlassPanePopup.closePopupLast();

    }//GEN-LAST:event_adminICOMouseClicked

    private void receptionICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionICOMouseClicked
        // TODO add your handling code here:
        DashboardReception newFrame = new DashboardReception();
                newFrame.setVisible(true);
                GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_receptionICOMouseClicked

    private void doctorICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorICOMouseClicked
        // TODO add your handling code here:
        DashboardDoctor newFrame = new DashboardDoctor();
                newFrame.setVisible(true);
                GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_doctorICOMouseClicked

    private void pharmacyICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacyICOMouseClicked
        // TODO add your handling code here:
        DashboardPharmacy newFrame = new DashboardPharmacy();
                newFrame.setVisible(true);
                GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_pharmacyICOMouseClicked

    private void backOfficeICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backOfficeICOMouseClicked
        // TODO add your handling code here:
        DashboardBackOffice newFrame = new DashboardBackOffice();
                newFrame.setVisible(true);
                GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_backOfficeICOMouseClicked

    private void signOutICOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutICOMouseClicked
        // TODO add your handling code here:
        new SignOut().setVisible(true);
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_signOutICOMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminICO;
    private javax.swing.JLabel backOfficeICO;
    private javax.swing.JLabel doctorICO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel pharmacyICO;
    private javax.swing.JLabel receptionICO;
    private javax.swing.JLabel signOutICO;
    // End of variables declaration//GEN-END:variables
}
