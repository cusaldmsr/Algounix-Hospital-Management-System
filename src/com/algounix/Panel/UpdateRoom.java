/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.algounix.Panel;

import com.algounix.Model.MySQL;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Kusal And Sadeesha
 */
public class UpdateRoom extends javax.swing.JPanel {

    private HashMap<String, String> typeMap = new HashMap<>();

    private DefaultListModel mod;
    private DefaultListModel mod1;

    /**
     * Creates new form UpdateRoom
     */
    public UpdateRoom() {
        initComponents();
        loadType();
        loadSuggestions();
        loadSuggestions2();
        addChargeListeners();
        displayChart();

//          FlatSVGIcon icon1Logo = new FlatSVGIcon("com//algounix//Resources//InchargeUpdateRoom.svg", jLabel12.getWidth(), jLabel12.getHeight());
//        jLabel12.setIcon(icon1Logo);
    }

    private void loadType() {

        try {

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM room_type");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                typeMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox1.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //load suggestions for Select Room ID :
    private void loadSuggestions() {
        jPopupMenu1.add(jPanel2);
        mod = new DefaultListModel();
        jList1.setModel(mod);
    }

    //load suggestions for Select Doctor ID:
    private void loadSuggestions2() {
        jPopupMenu2.add(jPanel4);
        mod1 = new DefaultListModel();
        jList2.setModel(mod1);
    }

    private void updateRoom() {
        String room_id = jTextField1.getText();
        String doc_id = jTextField5.getText();
        String doc_name = jLabel10.getText();
        String description = jTextArea2.getText();

        if (room_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Room ID ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (doc_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Doctor ID", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (doc_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Doctor ID", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `room` "
                        + "INNER JOIN `doctor_has_units` ON `doctor_has_units`.`room_id` = `room`.`id` "
                        + "WHERE `room`.`id` = '" + room_id + "' "
                        + "AND `room`.`discription` = '" + description + "' "
                        + "AND `doctor_has_units`.`doctor_id` = '" + doc_id + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Please Change Something to Update", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Update the room description
                    MySQL.executeIUD("UPDATE `room` "
                            + "SET `room`.`discription` = '" + description + "'"
                            + "WHERE `room`.`id` = '" + room_id + "' ");

                    //Update the doctor assigned to that room
                    MySQL.executeIUD("UPDATE `doctor_has_units` "
                            + "SET `doctor_has_units`.`doctor_id` = '" + doc_id + "'"
                            + "WHERE `doctor_has_units`.`room_id` = '" + room_id + "' ");

                    resetjPanel3();
                    JOptionPane.showMessageDialog(this, "Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void resetjPanel3() {

        jTextField1.setText("");
        jTextField5.setText("");
        jLabel10.setText(".............................................................................................");
        jTextArea2.setText("");

    }

    private void updateCharges() {
        String type = String.valueOf(jComboBox1.getSelectedItem());
        String service_Charge = jTextField2.getText();
        String food_Charge  = jTextField3.getText();
        String laundry_Charge  = jTextField4.getText();

        if (type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select a Room Type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (service_Charge.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Service Charge ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (food_Charge.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Food Charge :", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (laundry_Charge.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Laundry Charge", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `room_chargers` "
                        + "WHERE `room_chargers`.`service_charge` = '" + service_Charge + "' "
                        + "AND `room_chargers`.`food_charge` = '" + food_Charge + "' "
                        + "AND `room_chargers`.`londry_charge` = '" + laundry_Charge + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Please Change Something to Update", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.executeIUD("UPDATE `room_chargers` "
                            + "SET `room_chargers`.`service_charge` = '" + service_Charge + "'"
                            + "AND `room_chargers`.`food_charge` = '" + food_Charge + "' "
                            + "AND `room_chargers`.`londry_charge` = '" + laundry_Charge + "'");

                    resetjPanel1();
                    JOptionPane.showMessageDialog(this, "Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void resetjPanel1() {

        jComboBox1.setSelectedIndex(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jLabel8.setText(">>>>>>>>>>");

    }

    //Load Total Real Time Part 1
    private void updateTotalCharges() {
        String serviceText = jTextField2.getText().trim();
        String foodText = jTextField3.getText().trim();
        String laundryText = jTextField4.getText().trim();

        try {
            // Convert to numbers (handle empty fields)
            double service = serviceText.isEmpty() ? 0.0 : Double.parseDouble(serviceText);
            double food = foodText.isEmpty() ? 0.0 : Double.parseDouble(foodText);
            double laundry = laundryText.isEmpty() ? 0.0 : Double.parseDouble(laundryText);

            // Calculate total
            double total = service + food + laundry;

            // Display total
            jLabel8.setForeground(Color.red);
            jLabel8.setText(" Rs. " + String.format("%.2f", total));
        } catch (NumberFormatException e) {
            jLabel8.setText("Invalid");
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Warning", JOptionPane.WARNING_MESSAGE);

        }

    }

    //Load Total Real Time Part 2
    private void addChargeListeners() {
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalCharges();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalCharges();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalCharges();
            }
        };

        jTextField2.getDocument().addDocumentListener(listener);
        jTextField3.getDocument().addDocumentListener(listener);
        jTextField4.getDocument().addDocumentListener(listener);
    }

    private void displayChart() {

        chartpanel.add(createPieChartPanel(createMostSoldDistributionDataset(), "Room Type Distribution"));

        chartpanel.revalidate();
        chartpanel.repaint();

        chartpanel.setLayout(new java.awt.GridLayout(1, 2));

    }

    //    Pie Chart Panel
    private ChartPanel createPieChartPanel(PieDataset dataset, String chartTitle) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                chartTitle, // chart title
                dataset, // data
                false, // include legend
                true,
                false
        );
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        return new ChartPanel(pieChart);
    }

    //piechart 1 Dataset
    private DefaultPieDataset createMostSoldDistributionDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT rt.name AS room_type, COUNT(*) AS total_rooms\n"
                    + "FROM room r\n"
                    + "JOIN room_type rt ON r.room_type_id = rt.id\n"
                    + "GROUP BY rt.name");

            while (rs.next()) {
                String company = rs.getString("room_type");
                int count = rs.getInt("total_rooms");
                dataset.setValue(company, count);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        chartpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(205, 245, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Update Room Charges");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setText("Select Room Type :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setText("Service Charge :");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setText("Food Charge :");

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setText("Londry Charge :");

        jTextField4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setText("Total of Charges :");

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setText(">>>>>>>>>>");

        jButton1.setBackground(new java.awt.Color(205, 245, 253));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton1.setText("Update Charges ");
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
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 183, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Update Room");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(30, 30, 30))
        );

        chartpanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chartpanelLayout = new javax.swing.GroupLayout(chartpanel);
        chartpanel.setLayout(chartpanelLayout);
        chartpanelLayout.setHorizontalGroup(
            chartpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        chartpanelLayout.setVerticalGroup(
            chartpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setText("Select Room ID :");

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel11.setText("Update Room Asigned Doctor & Room Incharge ");

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel13.setText("Doctor ID:");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel14.setText("Doctor Name :");

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel16.setText("Description :");

        jButton3.setBackground(new java.awt.Color(205, 245, 253));
        jButton3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel10.setText(".............................................................................................");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(658, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chartpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateCharges();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateRoom();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String roomNo = jTextField1.getText().trim();

        if (!roomNo.isBlank()) {

            try {
                ResultSet resultSet = MySQL.executeSearch("SELECT `id` FROM `room` WHERE `id` LIKE '" + roomNo + "%'");

                if (!resultSet.isBeforeFirst()) {
                    return;
                }

                jPopupMenu1.show(jTextField1, 0, jTextField1.getHeight());
                mod.removeAllElements();

                while (resultSet.next()) {
                    mod.addElement(resultSet.getString("id"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            jPopupMenu1.setVisible(false);

        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String selectedID = jList1.getSelectedValue();
        jTextField1.setText(selectedID);
        jPopupMenu1.setVisible(false);

        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `room` "
                    + "INNER JOIN `doctor_has_units` ON `doctor_has_units`.`room_id` = `room`.`id` "
                    + "INNER JOIN `doctor` ON `doctor`.`id` = `doctor_has_units`.`doctor_id` "
                    + "WHERE `room`.`id` = '" + selectedID + "'");

            if (resultSet.next()) {
                jTextField5.setText(resultSet.getString("doctor.id"));
                jLabel10.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                jTextArea2.setText(resultSet.getString("room.discription"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String selectedItem = (String) jComboBox1.getSelectedItem();

        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `room_type` "
                    + "INNER JOIN `room_chargers` ON `room_chargers`.`id` = `room_type`.`room_chargers_id` "
                    + "WHERE `room_type`.`name` = '" + selectedItem + "'");

            if (resultSet.next()) {

                String service = resultSet.getString("service_charge");
                String food = resultSet.getString("food_charge");
                String londry = resultSet.getString("londry_charge");
                double total = Double.parseDouble(service) + Double.parseDouble(food) + Double.parseDouble(londry);

                jTextField2.setText(service);
                jTextField3.setText(food);
                jTextField4.setText(londry);
                jLabel8.setText(" Rs. " + String.format("%.2f", total));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        String doctorID = jList2.getSelectedValue();
        jTextField5.setText(doctorID);
        jPopupMenu2.setVisible(false);

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `doctor` WHERE `id`='" + doctorID + "'");

            if (resultSet.next()) {
                jLabel10.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        String text = jTextField5.getText().trim();

        if (!text.isEmpty()) {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `doctor` WHERE `id` LIKE '%" + text + "%'");

                if (!resultSet.isBeforeFirst()) {
                    return;
                }

                jPopupMenu2.show(jTextField5, 0, jTextField5.getHeight());
                mod1.removeAllElements();

                while (resultSet.next()) {
                    mod1.addElement(resultSet.getString("id"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            jPopupMenu2.setVisible(false);
        }
    }//GEN-LAST:event_jTextField5KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
