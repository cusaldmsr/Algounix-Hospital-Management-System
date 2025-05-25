/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.algounix.Panel.Doctor;

import com.algounix.GUI.SignIn;
import com.algounix.Model.MySQL;
import com.algounix.Panel.BackOffice.Product;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kusal
 */
public class Prescription extends javax.swing.JFrame {

    private HashMap<String, String> presDetails;
    private DoctorChanelling docChanelling;
    private PatientAdmit patientAdmit;
    private PatientDischarge patientDischarge;
    private OpdList opdList;

    private boolean isDischarge = false;

    public Prescription() {
        initComponents();
        loadUI();
    }

    public Prescription(HashMap<String, String> presDetails, DoctorChanelling chanelling) {
        initComponents();
        loadUI();
        this.isDischarge = false;
        this.presDetails = presDetails;
        this.docChanelling = chanelling;
        setPrescriptionDetails();
        jTextField1.setText(generatePrescriptionID());
        validateSpinner1();
        validateSpinner2();
        clearAll();
    }

    public Prescription(HashMap<String, String> presDetails, PatientAdmit admit) {
        initComponents();
        loadUI();
        this.isDischarge = false;
        this.presDetails = presDetails;
        this.patientAdmit = admit;
        setPrescriptionDetails();
        jTextField1.setText(generatePrescriptionID());
        validateSpinner1();
        validateSpinner2();
        clearAll();
    }

    public Prescription(HashMap<String, String> presDetails, PatientDischarge discharge) {
        initComponents();
        loadUI();
        this.isDischarge = true;
        this.presDetails = presDetails;
        this.patientDischarge = discharge;
        setPrescriptionDetails();
        jTextField1.setText(generatePrescriptionID());
        validateSpinner1();
        validateSpinner2();
        clearAll();      
    }
    
    
    public Prescription(HashMap<String, String> presDetails, OpdList opdList) {
        initComponents();
        loadUI();
        this.isDischarge = false;
        this.presDetails = presDetails;
        this.opdList = opdList;
        setPrescriptionDetails();
        jTextField1.setText(generatePrescriptionID());
        validateSpinner1();
        validateSpinner2();
        clearAll();      
    }


    private void loadUI() {
        Image icon = new ImageIcon(this.getClass().getResource("/com/algounix/Resources/HMS-Logo.png")).getImage();
        this.setIconImage(icon);
    }

    //return jTextField2 
    public JTextField getMedicineNameField() {
        return jTextField2;
    }

    //return jLabel60
    public JLabel getMedicineIDLabel() {
        return jLabel60;
    }

    //return jLabel57
    public JLabel getCategoryLabel() {
        return jLabel57;
    }

    //return jLabel54
    public JLabel getPriceLabel() {
        return jLabel54;
    }

    //return jLabel56
    public JLabel getExpLabel() {
        return jLabel56;
    }

    //return availability status label
    public JLabel getAvailabilityStatusLabel() {
        return jLabel51;
    }

    //return jButton4
    public JButton getAddtoPrescriptionButton() {
        return jButton4;
    }

    //Validate range of JSpinner1
    private void validateSpinner1() {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 60, 1);
        jSpinner1.setModel(spinnerModel);
    }

    //Validate range of JSpinner2
    private void validateSpinner2() {
        SpinnerNumberModel spinnerMoodel = new SpinnerNumberModel(1, 1, 100, 1);
        jSpinner2.setModel(spinnerMoodel);
    }

    //Set Prescription Details
    private void setPrescriptionDetails() {
        if (presDetails != null) {
            jLabel38.setText(presDetails.get("doctorID"));
            jLabel37.setText(presDetails.get("doctorName"));
            jLabel36.setText(presDetails.get("patientID"));
            jLabel35.setText(presDetails.get("patientName"));
            jLabel39.setText(presDetails.get("bloodGroup"));
            jLabel47.setText(presDetails.get("age"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        minimizebtn = new com.algounix.Buttons.WindowButton();
        closebtn = new com.algounix.Buttons.WindowButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel49 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(205, 245, 253));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 223, 253));

        jPanel2.setBackground(new java.awt.Color(12, 223, 253));

        minimizebtn.setBackground(new java.awt.Color(255, 204, 51));
        minimizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizebtnActionPerformed(evt);
            }
        });

        closebtn.setBackground(new java.awt.Color(255, 51, 51));
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("PRESCRIPTION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minimizebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(closebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel43.setText("Patient ID");

        jLabel44.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel44.setText("Patient Name");

        jLabel35.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel35.setText("Patient Name Here");

        jLabel36.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel36.setText("Patient ID Here");

        jLabel45.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel45.setText("Blood Group");

        jLabel39.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel39.setText("Patient ID Here");

        jLabel46.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel46.setText("Age");

        jLabel47.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel47.setText("Patient Name Here");

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PATIENT DETAILS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("MEDICINE DETAILS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Madicine Name", "Category", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton2.setText("Save Prescription");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PRESCRIPTION DETAILS");

        jLabel40.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel40.setText("Prescription ID");

        jLabel41.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel41.setText("Doctor ID");

        jLabel42.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel42.setText("Doctor Name");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel38.setText("Patient ID Here");

        jLabel37.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel37.setText("Patient Name Here");

        jLabel48.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel48.setText("Duration");

        jSpinner1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel49.setText("Days");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ADD MEDICINES");

        jLabel50.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel50.setText("Select Medicine");

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField2.setText("Name Here");

        jLabel51.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 255, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel51.setText("Availability");

        jLabel52.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel52.setText("Quantity");

        jSpinner2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel53.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel53.setText("Price");

        jLabel54.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel54.setText("Price Here if Medicine Available");

        jLabel55.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel55.setText("EXP Date");

        jLabel56.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel56.setText("EXP Date");

        jButton4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton4.setText("Add ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton5.setText("Clear All");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel57.setText("Category Here");

        jLabel58.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel58.setText("Category");

        jLabel59.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel59.setText("Medicine ID");

        jLabel60.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel60.setText("Medicine ID Here");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner2)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton1ActionPerformed
        // TODO add your handling code here:
//        this.dispose();
    }//GEN-LAST:event_closeButton1ActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed

        this.dispose();
    }//GEN-LAST:event_closebtnActionPerformed

    private void minimizebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizebtnActionPerformed

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizebtnActionPerformed

    //Select Medicine
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Product product = new Product(this, true);
        product.setPrescription(this);
        product.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clearAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    //Add prescription details to table
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        String medID1 = jLabel60.getText();
        String medicineName = jTextField2.getText();
        String category = jLabel57.getText();
        String qty = String.valueOf(jSpinner2.getValue());

        int rowCount = jTable1.getRowCount();

        boolean isFound = false;
        for (int i = 0; i < rowCount; i++) {

            String medID2 = String.valueOf(jTable1.getValueAt(i, 0));

            if (medID1.equals(medID2)) {
                String currentQty = String.valueOf(jTable1.getValueAt(i, 3));
                int subQty = Integer.valueOf(qty) + Integer.valueOf(currentQty);
                jTable1.setValueAt(subQty, i, 3);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            Vector<String> vector = new Vector<>();
            vector.add(medID1);
            vector.add(medicineName);
            vector.add(category);
            vector.add(qty);

            tableModel.addRow(vector);
        }

        clearAll();

    }//GEN-LAST:event_jButton4ActionPerformed

    //Generate prescription id 
    private String generatePrescriptionID() {
        String lastID = null;
        int nextNumber = 1;

        if (isDischarge) {
            loadPrescriptionItems();
            return presDetails.get("prescriptionID");
        }

        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT `id` FROM `prescription` ORDER BY `id` DESC LIMIT 1");

            if (resultSet.next()) {
                lastID = resultSet.getString("id");
            }

            if (lastID != null) {
                String numericVal = lastID.substring(3);
                nextNumber = Integer.parseInt(numericVal) + 1;
            }

            return String.format("PRE%05d", nextNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.format("PRE%05d", nextNumber);
    }

    //Save and print prescription
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int rowCount = jTable1.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Please add medicines to prescription first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //insert to prescription and prescription items
        String presID = jTextField1.getText();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String duration = String.valueOf(jSpinner1.getValue());
        String patientID = jLabel36.getText();

        try {
            
            if(this.isDischarge){
                
                String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String dateCount = String.valueOf(jSpinner1.getValue());
                String prescriptionId = this.presDetails.get("prescriptionID");
                
                String query = "UPDATE `prescription` SET `date`='"+dateToday+"',`duration_from_days`='"+dateCount+"' "
                        + "WHERE `id`='"+prescriptionId+"'";
                MySQL.executeIUD(query);               
                
                JOptionPane.showMessageDialog(this, "Prescription updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                this.patientDischarge.getUpdateStatusLabel().setText("Updated");
                this.patientDischarge.getUpdateStatusLabel().setForeground(Color.green);
                
            }else{
                
                //Insert to Prescription
                MySQL.executeIUD("INSERT INTO `prescription` VALUES ('" + presID + "','" + date + "','" + SignIn.docID + "','" + duration + "','" + patientID + "')");
            }
            

            //Insert to Prescription Item
            for (int i = 0; i < rowCount; i++) {
                String medID = String.valueOf(jTable1.getValueAt(i, 0));
                String qty = String.valueOf(jTable1.getValueAt(i, 3));

                MySQL.executeIUD("INSERT INTO `prescription_item` (`medicine_id`,`qty`,`prescription_id`) VALUES "
                        + "('" + medID + "','" + qty + "','" + presID + "')");
            }

            if (docChanelling != null) {
                docChanelling.getPrescriptionStatusLabel().setText("Prescription Added");
                docChanelling.getPrescriptionStatusLabel().setForeground(Color.GREEN);
                docChanelling = null;
            }

            if (patientAdmit != null) {
                patientAdmit.getPrescriptionStatusLabel().setVisible(true);
                patientAdmit.getPrescriptionStatusLabel().setText("Added");
                patientAdmit.getPrescriptionStatusLabel().setForeground(Color.GREEN);
                patientAdmit = null;
            }
            
            if(opdList != null){
                opdList.getPrescriptionStatusLabel().setText("Added");
                opdList.getPrescriptionStatusLabel().setForeground(Color.GREEN);
                opdList = null;
            }
            this.dispose();
            
            this.isDischarge = false;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    //Claear All
    private void clearAll() {
        jTextField2.setText("");
        jLabel60.setText("Medicine ID Here");
        jLabel57.setText("Category Name Here");
        jLabel54.setText("Medicine Price Here");
        jLabel56.setText("Expire Date Here");
        jSpinner2.setValue(1);
        jLabel51.setVisible(false);
        jButton4.setEnabled(false);
    }

    private void loadPrescriptionItems() {

        if (isDischarge) {
            String prescriptionId = presDetails.get("prescriptionID");

            try {
                String query = "SELECT * FROM `prescription_item` INNER JOIN `medicine` ON "
                        + "`prescription_item`.`medicine_id`=`medicine`.`id` INNER JOIN `category` ON "
                        + "`medicine`.`category_id`=`category`.`id` "
                        + "WHERE `prescription_item`.`prescription_id`='" + prescriptionId + "'";

                ResultSet resultSet = MySQL.executeSearch(query);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    Vector<String> vector = new Vector();
                    vector.add(resultSet.getString("prescription_item.medicine_id"));
                    vector.add(resultSet.getString("medicine.name"));
                    vector.add(resultSet.getString("medicine.name"));
                    vector.add(resultSet.getString("prescription_item.qty"));

                    model.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.algounix.Buttons.WindowButton closebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.algounix.Buttons.WindowButton minimizebtn;
    // End of variables declaration//GEN-END:variables
}
