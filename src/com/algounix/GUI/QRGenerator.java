package com.algounix.GUI;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class QRGenerator extends javax.swing.JFrame {

    BufferedImage qrImage;

    public QRGenerator() {

        initComponents();

    }

    public QRGenerator(String password) {
        initComponents();
        txtInput.setText(password);
        loadQR();
    }

    public static BufferedImage generateQR(String text, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadQR() {
        String text = txtInput.getText().trim();
        if (text.isEmpty()) {
            ImageIcon icon = new ImageIcon("src/com/algounix/Resources/QRanimation.gif");
            lblQRCode.setIcon(icon);
            return;
        }
        qrImage = QRGenerator.generateQR(text, 368, 368);
        if (qrImage != null) {
            ImageIcon icon = new ImageIcon(qrImage);
            lblQRCode.setIcon(icon);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to generate QR code.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        windowButton1 = new com.algounix.Buttons.WindowButton();
        jPanel2 = new javax.swing.JPanel();
        lblQRCode = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnPrintQR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(205, 245, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(209, 70));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QR Generator");

        windowButton1.setBackground(new java.awt.Color(255, 0, 51));
        windowButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/Resources/QRanimation.gif"))); // NOI18N

        txtInput.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        txtInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInputKeyReleased(evt);
            }
        });

        btnPrintQR.setBackground(new java.awt.Color(205, 245, 253));
        btnPrintQR.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        btnPrintQR.setText("Print QR Code");
        btnPrintQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintQRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(212, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblQRCode, javax.swing.GroupLayout.DEFAULT_SIZE, 368,
                                                Short.MAX_VALUE)
                                        .addComponent(txtInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnPrintQR, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                                .addContainerGap(213, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 368,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(btnPrintQR)
                                .addGap(40, 40, 40)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                                .addGap(7, 7, 7))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void windowButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_windowButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }// GEN-LAST:event_windowButton1ActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        String text = txtInput.getText();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input a text to generate QR!");
        } else {

            qrImage = QRGenerator.generateQR(text, 368, 368);

            if (qrImage != null) {
                ImageIcon icon = new ImageIcon(qrImage);
                lblQRCode.setIcon(icon);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to generate QR code.");
            }

        }

    }// GEN-LAST:event_btnGenerateActionPerformed

    private void btnPrintQRActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrintQRActionPerformed
        // TODO add your handling code here:
        if (qrImage == null) {
            JOptionPane.showMessageDialog(this, "Please generate a QR code first.");
            return;
        }

        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put("qrImage", qrImage);

            JasperReport report = JasperCompileManager.compileReport("src/com/algounix/Reports/qr_template.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());

            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to print QR code: " + e.getMessage());
        }
    }// GEN-LAST:event_btnPrintQRActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtInputKeyReleased
        // TODO add your handling code here:
        loadQR();
    }// GEN-LAST:event_txtInputKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatMacLightLaf.setup();
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QRGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintQR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblQRCode;
    public javax.swing.JTextField txtInput;
    private com.algounix.Buttons.WindowButton windowButton1;
    // End of variables declaration//GEN-END:variables
}
