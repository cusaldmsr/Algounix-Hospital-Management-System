package com.algounix.Panel.Doctor;

import com.algounix.GUI.SignIn;
import com.algounix.Model.MySQL;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sadee
 */
public class OpdList extends javax.swing.JPanel {

    public static final int OPD_UNIT_ID = 1;
    public static final int COMPLETED_STATUS_ID = 1;

    private int nextPatientNumber;
    private boolean isReportAdded;
    public boolean isPrescriptionAdded;

    public OpdList() {
        initComponents();
        loadPatientQueList();
        moveNextPatient(++nextPatientNumber);
        fillDoctordetails();
    }

    private void loadPatientQueList() {

        String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        try {
            String query = "SELECT * FROM `opd_list` INNER JOIN `patient` ON "
                    + "`opd_list`.`patient_id`=`patient`.`id` INNER JOIN `doctor_has_units` ON "
                    + "`opd_list`.`doctor_has_units_id`=`doctor_has_units`.`id` "
                    + "INNER JOIN `que_list_status` ON `opd_list`.`que_list_status_id`=`que_list_status`.`id` "
                    + "WHERE `opd_list`.`date`='" + dateToday + "' AND `doctor_has_units`.`units_id`='" + OPD_UNIT_ID + "' "
                    + "AND `doctor_has_units`.`doctor_id`='" + SignIn.docID + "'";

            ResultSet resultSet = MySQL.executeSearch(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector();
                vector.add(resultSet.getString("patient.id"));
                vector.add(resultSet.getString("patient.first_name") + " " + resultSet.getString("patient.last_name"));
                vector.add(resultSet.getString("opd_list.opd_number"));
                vector.add(resultSet.getString("que_list_status.name"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //set prescription status label
    private void setPrescriptionStatusLabel(){
        jLabel29.setText("Not Added");
        jLabel29.setForeground(Color.red);
    }

    //Change the patient
    private void moveNextPatient(int nextNumber) {
        int rowCount = jTable1.getRowCount();

        if (rowCount > 0) {

            if (nextNumber < rowCount) {

                String nextPatientNumber = String.valueOf(jTable1.getValueAt(nextNumber, 2));
                String currentPatientNumber = String.valueOf(jTable1.getValueAt(nextNumber - 1, 2));
                
                jTable1.setValueAt("Ongoing", nextNumber-1, 3);
                
                if(nextNumber - 2 >= 0){
                    String status = String.valueOf(jTable1.getValueAt(nextNumber - 2, 3));
                    
                    if(status.equals("Ongoing")){
                        jTable1.setValueAt("Pending", nextNumber-2, 3);
                    }
                }

                jLabel5.setText(String.format("%03d", Integer.parseInt(currentPatientNumber)));
                jLabel6.setText(String.format("%03d", Integer.parseInt(nextPatientNumber)));

                String currentPatientID = String.valueOf(jTable1.getValueAt(nextNumber - 1, 0));

                loadPatientDetails(currentPatientID);

                setReportId();
                checkOldReports(currentPatientID);
                this.isReportAdded = false;
                this.isPrescriptionAdded = false;
                setPrescriptionStatusLabel();

            } else if (nextNumber == rowCount) {
                jLabel5.setText(jLabel6.getText());
                jLabel6.setText("000");
                jButton1.setEnabled(false);

                String currentPatientID = String.valueOf(jTable1.getValueAt(nextNumber - 1, 0));
                
                jTable1.setValueAt("Ongoing", nextNumber-1, 3);
                
                if(nextNumber - 2 >= 0){
                    String status = String.valueOf(jTable1.getValueAt(nextNumber - 2, 3));
                    
                    if(status.equals("Ongoing")){
                        jTable1.setValueAt("Pending", nextNumber-2, 3);
                    }
                }

                loadPatientDetails(currentPatientID);

                setReportId();
                checkOldReports(currentPatientID);
                this.isReportAdded = false;
                this.isPrescriptionAdded = false;
                setPrescriptionStatusLabel();
            }

        } else {
            JOptionPane.showMessageDialog(this, "No patients available", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    //fil doctor details
    private void fillDoctordetails() {
        try {

            String query = "SELECT * FROM `doctor_has_units` INNER JOIN `doctor` ON "
                    + "`doctor_has_units`.`doctor_id`=`doctor`.`id` WHERE "
                    + "`doctor_id`='" + SignIn.docID + "' AND `units_id`='" + OPD_UNIT_ID + "'";

            ResultSet resultSet = MySQL.executeSearch(query);

            if (resultSet.next()) {
                String doctor_name = SignIn.docName;
                String doctor_mobile = resultSet.getString("doctor.mobile");
                String opd_room_number = resultSet.getString("doctor_has_units.room_id");

                jLabel11.setText("Dr. " + doctor_name);
                jLabel12.setText(doctor_mobile);
                jLabel13.setText(opd_room_number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //load patient details
    private void loadPatientDetails(String currentPatientID) {

        try {

            String query = "SELECT * FROM `patient` "
                    + "INNER JOIN `blood_group` ON `patient`.`blood_group_id`=`blood_group`.`id` "
                    + "WHERE `patient`.`id`='" + currentPatientID + "'";

            ResultSet resultSet = MySQL.executeSearch(query);

            if (resultSet.next()) {
                String patientName = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                String blood_group = resultSet.getString("blood_group.name");
                String age = calculateAge(resultSet.getString("patient.birthday"));
                String mobile = resultSet.getString("patient.mobile");

                jLabel20.setText(patientName);
                jLabel21.setText(currentPatientID);
                jLabel22.setText(blood_group);
                jLabel23.setText(age);
                jLabel24.setText(mobile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //calculate age
    private String calculateAge(String birthDay) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(birthDay);

        return String.valueOf(ChronoUnit.YEARS.between(birthDate, today));
    }

    //set report id
    public void setReportId() {

        int reportID = 0;

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT `id` from `patient_report` ORDER BY `id` DESC LIMIT 1");

            if (resultSet.next()) {
                reportID = resultSet.getInt("id");
            }

            jLabel27.setText(String.format("%04d", ++reportID));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Display early reports availability lable text
    private void checkOldReports(String patientID) {
        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT COUNT(`id`) AS `repo_count` FROM `patient_report` WHERE `patient_id`='" + patientID + "'");

            if (resultSet.next()) {
                int count = resultSet.getInt("repo_count");

                if (count > 0) {
                    jLabel30.setVisible(true);
                    jLabel30.setText("Have Old Reports.");
                    jLabel30.setForeground(Color.green);
                } else {
                    jLabel30.setVisible(true);
                    jLabel30.setText("No Old Reports.");
                    jLabel30.setForeground(Color.red);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save report details
    private void saveReportDetails() {

        String reportText = jTextArea1.getText();

        if (reportText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the report text", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String patientID = jLabel21.getText();

            try {

                MySQL.executeIUD("INSERT INTO `patient_report` (`date`,`description`,`patient_id`,`doctor_id`) "
                        + "VALUES ('" + date + "','" + reportText + "','" + patientID + "','" + SignIn.docID + "')");

                JOptionPane.showMessageDialog(this, "Report saved successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);

                this.isReportAdded = true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //open prescription
    private void openPrescription() {
        String patientID = jLabel21.getText();
        String patientName = jLabel20.getText();
        String bloodGroup = jLabel22.getText();
        String age = jLabel23.getText();
        String doctorID = SignIn.docID;
        String doctorName = jLabel11.getText();

        HashMap<String, String> presDetails = new HashMap<>();
        presDetails.put("patientID", patientID);
        presDetails.put("patientName", patientName);
        presDetails.put("bloodGroup", bloodGroup);
        presDetails.put("age", age);
        presDetails.put("doctorID", doctorID);
        presDetails.put("doctorName", doctorName);

//        new Prescription(presDetails, this).setVisible(true);
    }
    
    //complete process
    private void completeProcess(){
        if(!isReportAdded){
            JOptionPane.showMessageDialog(this, "Please add report first", "Warning", JOptionPane.WARNING_MESSAGE);
        }else if(!isPrescriptionAdded){
            JOptionPane.showMessageDialog(this, "Please add the prescription", "Warning", JOptionPane.WARNING_MESSAGE);
        }else {
            //update opd list table
            
            String patient_id = jLabel21.getText();
            String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int que_list_id = Integer.parseInt(jLabel5.getText());
            
            try {
                MySQL.executeIUD("UPDATE `opd_list` SET `que_list_status_id`='"+COMPLETED_STATUS_ID+"' "
                        + "WHERE `patient_id`='"+patient_id+"' AND `date`='"+dateToday+"' "
                                + "AND `opd_number`='"+que_list_id+"'");
                
                for(int i=0; i < jTable1.getRowCount(); i++){
                    
                    String list_id = String.valueOf(jTable1.getValueAt(i, 2));  
                    
                    if(Integer.parseInt(list_id) == que_list_id){
                        jTable1.setValueAt("Completed", i, 3);
                        JOptionPane.showMessageDialog(this, "Process completed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        moveNextPatient(++nextPatientNumber);
                        setReportId();
                        jTextArea1.setText("");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(160, 233, 255));
        setPreferredSize(new java.awt.Dimension(1036, 1133));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PATIENT QUE LIST");
        jLabel2.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "OPD Number", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ongoing Number");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Next Number");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("000");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 223, 253), 3));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("000");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 223, 253), 3));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DOCTOR DETAILS");
        jLabel7.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setText("Doctor Name");

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setText("Mobile Number");

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel10.setText("OPD Room No");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setText("OPD Room No");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setText("OPD Room No");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setText("OPD Room No");

        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 204, 0));
        jButton1.setText("Next Paitent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel1.setText("OPD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PATIENT DETAILS");
        jLabel14.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel15.setText("Patient Name");

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel16.setText("Patient ID");

        jLabel17.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel17.setText("Blood Group");

        jLabel18.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel18.setText("Age");

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel19.setText("Mobile");

        jLabel20.setBackground(new java.awt.Color(255, 204, 204));
        jLabel20.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel20.setText("Patient Name Here");

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel21.setText("Patient ID Here");

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel22.setText("Blood Group Here");

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel23.setText("Age Here");

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel24.setText("Mobile Number Here");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel24))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("PATIENT REPORT");
        jLabel25.setOpaque(true);

        jLabel26.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel26.setText("Report ID");

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel27.setText("Report ID");

        jLabel28.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel28.setText("Description");

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("No Old Reports");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton5.setText("Save Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jLabel30)))))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(16, 16, 16))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton3.setText("Add Prescription");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton4.setText("Complete Process");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 204, 0));
        jLabel29.setText("Added");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    //move next patient
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        moveNextPatient(++nextPatientNumber);
    }//GEN-LAST:event_jButton1ActionPerformed

    //save report utton
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        saveReportDetails();
    }//GEN-LAST:event_jButton5ActionPerformed

    //Add prescription button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        openPrescription();
    }//GEN-LAST:event_jButton3ActionPerformed

    //complete process button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        completeProcess();
    }//GEN-LAST:event_jButton4ActionPerformed

    public JLabel getPrescriptionStatusLabel(){
        return this.jLabel29;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
