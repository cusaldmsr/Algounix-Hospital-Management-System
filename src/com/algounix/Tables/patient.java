package com.algounix.Tables;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.algounix.Model.MySQL;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class patient extends javax.swing.JFrame {

    public patient() {
        initComponents();
        loadDeatails();
    }

    public void loadDeatails() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT patient.id AS Patient_id,\n"
                    + "patient.first_name AS First_Name,\n"
                    + "patient.last_name AS Last_Name,\n"
                    + "patient.email AS Email,\n"
                    + "patient.mobile AS Mobile,\n"
                    + "blood_group.`name` AS `Blood_group`,\n"
                    + "gender.`name` AS `Gender`,\n"
                    + "patient.register_date AS `Registered_Date`,\n"
                    + "patient_status.`name` AS `Status`\n"
                    + "\n"
                    + "FROM patient\n"
                    + "INNER JOIN blood_group on patient.blood_group_id = blood_group.id\n"
                    + "INNER JOIN gender ON patient.gender_id = gender.id\n"
                    + "INNER JOIN patient_status ON patient_status.id = patient.patient_status_id");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {

                Vector<String> v = new Vector<>();
                v.add(rs.getString("Patient_id"));
                v.add(rs.getString("First_Name"));
                v.add(rs.getString("Last_Name"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Mobile"));
                v.add(rs.getString("Blood_group"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("Registered_Date"));
                v.add(rs.getString("Status"));

                model.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "First Name", "Last Name", "Email", "Mobile", "Blood Group", "Gender", "Registered_Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try (InputStream path = this.getClass().getResourceAsStream("/com/algounix/Reports/Patient-Details-HMS.jasper")) {

            if (path == null) {
                throw new FileNotFoundException("Report file not found in the specified path.");
            }

            if (jTable1 == null || jTable1.getModel() == null) {
                throw new IllegalStateException("Table or table model is not initialized.");
            }

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, null, dataSource);

            // View the report
            JasperViewer.viewReport(jasperPrint, false);
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (JRException e) {
            System.err.println("JasperReports error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
