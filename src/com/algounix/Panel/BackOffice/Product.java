/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.algounix.Panel.BackOffice;

import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import com.algounix.Model.MySQL;
import com.algounix.Panel.Doctor.Prescription;
import com.algounix.Panel.GRN;
import com.algounix.Panel.Pharmacy.PharmacyInvoice;
import java.awt.Color;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Product extends javax.swing.JDialog {

    HashMap<String, String> brandMap = new HashMap<>();

    HashMap<String, String> categoryMap = new HashMap<>();

    HashMap<String, String> unitMap = new HashMap<>();

    private Prescription prescription;
    private PharmacyInvoice invoice;
    private GRN grn;

    /**
     * Creates new form Product
     */
    private static String PREFIX = "MED";
    //private int clickCount = 0;

    public Product(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadProducts();
        loadBrand();
        loadCategory();
        loadWeightUnits();
        jTextField1.setText("Select Category to Get ID");
    }

    //  Set Prescription to Product
    public void setPrescription(Prescription pres) {
        this.prescription = pres;
    }

    //  Set Pharmacy Stok to Product
    public void setPharmacyInvoice(PharmacyInvoice invoice) {
        this.invoice = invoice;
    }
    
    public void setGrn(GRN grn){
        this.grn = grn;
    }

    private void loadBrand() {

        try {

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM brand");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                brandMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox1.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCategory() {

        try {

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM category");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                categoryMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox2.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadProducts() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `medicine` "
                    + "INNER JOIN `brand` ON `medicine`.`brand_id` = `brand`.`id`"
                    + "INNER JOIN `category` ON `medicine`.`category_id` = `category`.`id`"
                    + "INNER JOIN `weight_unit` ON `medicine`.`weight_unit_id` = `weight_unit`.`id`"
                    + "ORDER BY `medicine`.`id` ASC");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("medicine.id"));
                vector.add(resultSet.getString("medicine.name") + " " + resultSet.getString("medicine.value") + " " + resultSet.getString("weight_unit.name"));
                vector.add(resultSet.getString("brand.name"));
                vector.add(resultSet.getString("category.name"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadWeightUnits() {
        try {

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `weight_unit`");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                unitMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            jComboBox3.setModel(new DefaultComboBoxModel<>(vector));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetProductUI() {

        jTextField2.setText("");
        jTable1.clearSelection();
        jComboBox1.setSelectedIndex(0);
        jButton1.setEnabled(true);

        jTextField1.setText("Select Category to Get ID");
        jComboBox2.setSelectedIndex(0);
        jComboBox2.setEnabled(true);
        jLabel7.setText("Selected Category Here");
        jTextField3.setText("");
        jComboBox3.setSelectedIndex(0);

    }

    private static String getNextId() {
        String lastID = getLastIdFromDatabase();
        if (lastID == null) {

            return PREFIX + "00001";
        }

        String numericPart = lastID.substring(PREFIX.length());
        int lastNumber = Integer.parseInt(numericPart);

        int nextNumber = lastNumber + 1;

        return String.format("%s%05d", PREFIX, nextNumber);
    }

    private static String getLastIdFromDatabase() {
        String lastID = null;
        try {
            ResultSet rs = MySQL.executeSearch("SELECT `id` FROM `medicine` WHERE `id` LIKE '" + PREFIX + "%' ORDER BY `id` DESC LIMIT 1");
            if (rs.next()) {
                lastID = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastID;
    }

    private String word(String word) {
        if (word.length() >= 3) {
            String firstThree = word.substring(0, 3);
            String capitalized = capitalize(firstThree);
            return capitalized;
        } else {
            return null;
        }
    }

    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 3).toUpperCase();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        windowButton1 = new com.algounix.Buttons.WindowButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(205, 245, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(209, 70));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setText("Product Id");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setText("Product Name");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setText("Brand Name");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(205, 245, 253));
        jButton1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(205, 245, 253));
        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(205, 245, 253));
        jButton3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton3.setText("Clear to Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setText("Selected Category ");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("Selected Category Here");

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setText("Select Category");

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setText("Product NET Value");

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product Name", "Brand Name", "Category "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PRODUCT DETAILS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void windowButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_windowButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        resetProductUI();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String category = String.valueOf(jComboBox2.getSelectedItem());
        String name = jTextField2.getText();
        String value = jTextField3.getText();
        String unit = String.valueOf(jComboBox3.getSelectedItem());

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (category.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a category", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a NET Value", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!value.matches("^\\d+(\\.\\d{1,3})?$")) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid NET Value", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (unit.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select NET Value unit", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `medicine` "
                        + "WHERE `id` = '" + id + "' OR (`name` = '" + name + "' AND `brand_id` = '" + brandMap.get(brand) + "' AND `category_id` = '" + categoryMap.get(category) + "')");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product already added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.executeIUD("INSERT INTO `medicine`(`id`,`name`,`brand_id`,`category_id`,`value`,`weight_unit_id`) "
                            + "VALUES('" + id + "','" + name + "','" + brandMap.get(brand) + "','" + categoryMap.get(category) + "','" + value + "','" + unitMap.get(unit) + "')");
                    loadProducts();
                    resetProductUI();
                    JOptionPane.showMessageDialog(this, "New product added", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        jTextField2.grabFocus();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        jComboBox1.grabFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jComboBox2.grabFocus();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText();
        String brand = String.valueOf(jComboBox1.getSelectedItem());
        String name = jTextField2.getText();
        String value = jTextField3.getText();
        String unit = String.valueOf(jComboBox3.getSelectedItem());

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a NET Value", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!value.matches("^\\d+(\\.\\d{1,3})?$")) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid NET Value", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (unit.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select NET Value unit", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `medicine` WHERE `name` = '" + name + "' AND `brand_id` = '" + brandMap.get(brand) + "' AND  `value` = '" + value + "' ");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Change Name or Brand or Value to Update", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.executeIUD("UPDATE `medicine` SET `brand_id` = '" + brandMap.get(brand) + "' , `name` ='" + name + "', `value` = '" + value + "'"
                            + "WHERE `id` = '" + id + "'");

                    loadProducts();
                    resetProductUI();
                    JOptionPane.showMessageDialog(this, "Product Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        //load product details to fields
        if (evt.getClickCount() == 1) {
            int row = jTable1.getSelectedRow();

            String medID = String.valueOf(jTable1.getValueAt(row, 0));

            try {
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `medicine` INNER JOIN `weight_unit` ON `medicine`.`weight_unit_id` = `weight_unit`.`id`"
                        + "WHERE `medicine`.`id` = '" + medID + "' ");

                if (resultSet.next()) {
                    String name = resultSet.getString("medicine.name");
                    String value = resultSet.getString("medicine.value");
                    String unit = resultSet.getString("weight_unit.name");

                    jTextField2.setText(name);
                    jTextField3.setText(value);
                    jComboBox3.setSelectedItem(unit);
                }

                jTextField1.setText(medID);
                jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 2)));
                jLabel7.setText(String.valueOf(jTable1.getValueAt(row, 3)));

            } catch (Exception e) {
                e.printStackTrace();
            }

            jButton1.setEnabled(false);
            jComboBox2.setEnabled(false);
        }

        //load product details to prescription
        if (evt.getClickCount() == 2) {

            int row = jTable1.getSelectedRow();

            if (prescription != null) {

                String medID = String.valueOf(jTable1.getValueAt(row, 0));

                try {
                    ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `pharmacy_stock` INNER JOIN `main_stock` ON "
                            + "`pharmacy_stock`.`main_stock_id`=`main_stock`.`id` INNER JOIN `medicine` ON "
                            + "`medicine`.`id`=`main_stock`.`medicine_id` WHERE `medicine`.`id`='" + medID + "'");

                    if (resultSet.next()) {
                        int availableQty = resultSet.getInt("pharmacy_stock.have_qty");
                        prescription.getAvailabilityStatusLabel().setVisible(true);

                        if (availableQty > 0) {
                            prescription.getAvailabilityStatusLabel().setForeground(Color.GREEN);
                            prescription.getAvailabilityStatusLabel().setText("In-Stock");
                        } else {
                            prescription.getAvailabilityStatusLabel().setForeground(Color.RED);
                            prescription.getAvailabilityStatusLabel().setText("Out-of-Stock");
                        }

                        prescription.getPriceLabel().setText(resultSet.getString("pharmacy_stock.selling_price"));
                        prescription.getExpLabel().setText(resultSet.getString("main_stock.exp"));
                    } else {
                        prescription.getAvailabilityStatusLabel().setForeground(Color.RED);
                        prescription.getAvailabilityStatusLabel().setText("Out-of-Stock");
                        prescription.getExpLabel().setText("Not in Stock");
                        prescription.getPriceLabel().setText("Not in Stock");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                prescription.getMedicineNameField().setText(String.valueOf(jTable1.getValueAt(row, 1)));
                prescription.getMedicineIDLabel().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                prescription.getCategoryLabel().setText(String.valueOf(jTable1.getValueAt(row, 3)));

                prescription.getAddtoPrescriptionButton().setEnabled(true);

                this.dispose();
            }

            if (invoice != null) {
                String id = String.valueOf(jTable1.getValueAt(row, 0));
                String name = String.valueOf(jTable1.getValueAt(row, 1));
                String brand = String.valueOf(jTable1.getValueAt(row, 2));

                invoice.setMedicineLabels(id, name, brand, name);
                this.dispose();
            }
            
            if(grn != null){
                String name = String.valueOf(jTable1.getValueAt(row, 1));
                String brand = String.valueOf(jTable1.getValueAt(row, 2));
                String category = String.valueOf(jTable1.getValueAt(row, 3));
                
                grn.setProductFeilds(name, brand, category);
                this.dispose();
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String cat = String.valueOf(jComboBox2.getSelectedItem());
        jLabel7.setText(cat);

        if (cat.equals("Select")) {
            jTextField1.setText("Select Category to Get ID");
        } else {
            PREFIX = word(cat);
            jTextField1.setText(getNextId());
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Product dialog = new Product(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private com.algounix.Buttons.WindowButton windowButton1;
    // End of variables declaration//GEN-END:variables
}
