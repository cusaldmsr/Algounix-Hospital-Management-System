/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.algounix.Dashboards;

import com.algounix.Components.ScrollBar;
import com.algounix.GUI.SignOut;
import com.algounix.Panel.BackOffice.Brand;
import com.algounix.Panel.BackOffice.GRNList;
import com.algounix.Panel.BackOffice.Product;
import com.algounix.Panel.CompanyReg;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author kusal
 */
public class DashboardBackOffice extends javax.swing.JFrame {

    Timer updateTimer;
    int DELAY = 100;

    /**
     * Creates new form DashboardAdmin
     */
    public DashboardBackOffice() {
        initComponents();

        updateTimer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date currentTime = new Date();
                String TimeFormat = "HH:mm:ss";
                String DateFormat = "MMMM dd, yyyy";
                DateFormat formatTime = new SimpleDateFormat(TimeFormat);
                DateFormat formatDate = new SimpleDateFormat(DateFormat);
                String formattedTime = formatTime.format(currentTime);
                String formattedDate = formatDate.format(currentTime);
                jLabel3.setText(formattedTime);
                jLabel7.setText(formattedDate);

            }
        });

        updateTimer.start();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        FlatSVGIcon iconLogo = new FlatSVGIcon("com//algounix//Resources//HMS-Logo.svg", MenuLogo.getWidth(), MenuLogo.getHeight());
        MenuLogo.setIcon(iconLogo);
        this.setIconImage(new ImageIcon("com//algounix//MenuIcons//GRN.png").getImage());
        Image icon = new ImageIcon(this.getClass().getResource("/com/algounix/Resources/HMS-Logo.png")).getImage();
        this.setIconImage(icon);
        GlassPanePopup.install(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BackOfficeDashboard = new javax.swing.JLabel();
        GRNbtn = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        SupplierReg = new javax.swing.JLabel();
        SupplierList = new javax.swing.JLabel();
        CompanyReg = new javax.swing.JLabel();
        BrandReg = new javax.swing.JLabel();
        EmployeeReportbtn = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        AddProduct = new javax.swing.JLabel();
        EmployeeReportbtn2 = new javax.swing.JLabel();
        GRNbtn1 = new javax.swing.JLabel();
        EmployeeReportbtn1 = new javax.swing.JLabel();
        EmployeeReportbtn3 = new javax.swing.JLabel();
        Stock1 = new javax.swing.JLabel();
        MenuLogo = new javax.swing.JLabel();
        AdminDashboardSignOutbtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CardLayoutPanel = new javax.swing.JPanel();
        dashboardBackOffice1 = new com.algounix.Panel.BackOffice.DashboardBackOffice();
        gRN1 = new com.algounix.Panel.GRN();
        stock1 = new com.algounix.Panel.BackOffice.Stock();
        supplierReg1 = new com.algounix.Panel.BackOffice.SupplierReg();
        supplierList1 = new com.algounix.Panel.SupplierList();
        stockList1 = new com.algounix.Panel.BackOffice.StockList();
        reports1 = new com.algounix.Panel.Reports();
        hospitalStockTransfer1 = new com.algounix.Panel.BackOffice.HospitalStockTransfer();
        pharmacyStockTransfer1 = new com.algounix.Panel.Pharmacy.PharmacyStockTransfer();
        pharmacyStockList1 = new com.algounix.Panel.Pharmacy.PharmacyStockList();
        pharmacyStock1 = new com.algounix.Panel.Pharmacy.PharmacyStock();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(137, 207, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(290, 688));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(137, 207, 243));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/MenuIcons/Dashboard.png"))); // NOI18N
        jLabel1.setText("Dashboard");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/MenuIcons/GRN.png"))); // NOI18N
        jLabel2.setText("Stock");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/MenuIcons/Report.png"))); // NOI18N
        jLabel4.setText("Outsiders");

        BackOfficeDashboard.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        BackOfficeDashboard.setText("Backoffice Dashboard");
        BackOfficeDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackOfficeDashboardMouseClicked(evt);
            }
        });

        GRNbtn.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        GRNbtn.setText("GRN");
        GRNbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GRNbtnMouseClicked(evt);
            }
        });

        Stock.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        Stock.setText("Main Stock");
        Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockMouseClicked(evt);
            }
        });

        SupplierReg.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        SupplierReg.setText("Supplier Registration");
        SupplierReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierRegMouseClicked(evt);
            }
        });

        SupplierList.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        SupplierList.setText("Supplier List");
        SupplierList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierListMouseClicked(evt);
            }
        });

        CompanyReg.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        CompanyReg.setText("Company Registration");
        CompanyReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompanyRegMouseClicked(evt);
            }
        });

        BrandReg.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        BrandReg.setText("Brand Registration");
        BrandReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrandRegMouseClicked(evt);
            }
        });

        EmployeeReportbtn.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        EmployeeReportbtn.setText("Hospital Stock Transfer");
        EmployeeReportbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeReportbtnMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel39.setText("Reports");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/algounix/MenuIcons/Report.png"))); // NOI18N
        jLabel38.setText("Reports");

        AddProduct.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        AddProduct.setText("Add Product");
        AddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddProductMouseClicked(evt);
            }
        });

        EmployeeReportbtn2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        EmployeeReportbtn2.setText("Main Stock List");
        EmployeeReportbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeReportbtn2MouseClicked(evt);
            }
        });

        GRNbtn1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        GRNbtn1.setText("GRN List");
        GRNbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GRNbtn1MouseClicked(evt);
            }
        });

        EmployeeReportbtn1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        EmployeeReportbtn1.setText("Pharmacy Stock Transfer");
        EmployeeReportbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeReportbtn1MouseClicked(evt);
            }
        });

        EmployeeReportbtn3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        EmployeeReportbtn3.setText("Pharmacy Stock List");
        EmployeeReportbtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeReportbtn3MouseClicked(evt);
            }
        });

        Stock1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        Stock1.setText("Pharmacy Stock");
        Stock1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stock1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(BackOfficeDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EmployeeReportbtn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmployeeReportbtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmployeeReportbtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addComponent(EmployeeReportbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Stock1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Stock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GRNbtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GRNbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BrandReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompanyReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addComponent(SupplierList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SupplierReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackOfficeDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GRNbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GRNbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stock1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeReportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeReportbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeReportbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeReportbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupplierReg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupplierList, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CompanyReg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrandReg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jScrollPane1.setViewportView(jPanel3);

        AdminDashboardSignOutbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        AdminDashboardSignOutbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminDashboardSignOutbtn.setText("Sign Out");
        AdminDashboardSignOutbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDashboardSignOutbtnMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins Light", 3, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Unix Hospital");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(MenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AdminDashboardSignOutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1851, Short.MAX_VALUE)
                .addComponent(AdminDashboardSignOutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(160, 233, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(803, 40));

        jLabel3.setFont(new java.awt.Font("Poppins Light", 3, 18)); // NOI18N
        jLabel3.setText("12 : 30 AM");

        jLabel7.setFont(new java.awt.Font("Poppins Light", 3, 18)); // NOI18N
        jLabel7.setText("Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(740, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        CardLayoutPanel.setBackground(new java.awt.Color(205, 245, 253));
        CardLayoutPanel.setLayout(new java.awt.CardLayout());
        CardLayoutPanel.add(dashboardBackOffice1, "card3");
        CardLayoutPanel.add(gRN1, "card3");
        CardLayoutPanel.add(stock1, "card4");
        CardLayoutPanel.add(supplierReg1, "card5");
        CardLayoutPanel.add(supplierList1, "card6");
        CardLayoutPanel.add(stockList1, "card7");
        CardLayoutPanel.add(reports1, "card8");
        CardLayoutPanel.add(hospitalStockTransfer1, "card10");
        CardLayoutPanel.add(pharmacyStockTransfer1, "card10");
        CardLayoutPanel.add(pharmacyStockList1, "card11");
        CardLayoutPanel.add(pharmacyStock1, "card12");

        jPanel4.add(CardLayoutPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackOfficeDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackOfficeDashboardMouseClicked
        // TODO add your handling code here:
        //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(dashboardBackOffice1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_BackOfficeDashboardMouseClicked

    private void GRNbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GRNbtnMouseClicked
        // TODO add your handling code here:
        //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(gRN1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_GRNbtnMouseClicked

    private void AdminDashboardSignOutbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashboardSignOutbtnMouseClicked
        // TODO add your handling code here:
        new SignOut().setVisible(true);
    }//GEN-LAST:event_AdminDashboardSignOutbtnMouseClicked

    private void SupplierListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierListMouseClicked
        // TODO add your handling code here:
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(supplierList1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

    }//GEN-LAST:event_SupplierListMouseClicked

    private void SupplierRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierRegMouseClicked
        // TODO add your handling code here:
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(supplierReg1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

    }//GEN-LAST:event_SupplierRegMouseClicked

    private void StockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMouseClicked
        // TODO add your handling code here:
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(stock1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

    }//GEN-LAST:event_StockMouseClicked

    private void AddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductMouseClicked
        // TODO add your handling code here:
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Product AP = new Product(parentFrame, true);
        AP.setVisible(true);
    }//GEN-LAST:event_AddProductMouseClicked

    private void CompanyRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompanyRegMouseClicked

        Window window = SwingUtilities.getWindowAncestor(this);

        CompanyReg dialog = new CompanyReg((Frame) window);
        dialog.setVisible(true);
    }//GEN-LAST:event_CompanyRegMouseClicked

    private void BrandRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrandRegMouseClicked
        // TODO add your handling code here:
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Brand BR = new Brand(parentFrame, true);
        BR.setVisible(true);
    }//GEN-LAST:event_BrandRegMouseClicked

    private void EmployeeReportbtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeReportbtn2MouseClicked
        // TODO add your handling code here:
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(stockList1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

    }//GEN-LAST:event_EmployeeReportbtn2MouseClicked

    private void EmployeeReportbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeReportbtnMouseClicked
        // TODO add your handling code here:
        //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(hospitalStockTransfer1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_EmployeeReportbtnMouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(reports1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void GRNbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GRNbtn1MouseClicked
        // TODO add your handling code here:
        GRNList GRNL = new GRNList();
        GRNL.setVisible(true);
    }//GEN-LAST:event_GRNbtn1MouseClicked

    private void EmployeeReportbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeReportbtn1MouseClicked
        // TODO add your handling code here:
         //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(pharmacyStockTransfer1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_EmployeeReportbtn1MouseClicked

    private void EmployeeReportbtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeReportbtn3MouseClicked
        // TODO add your handling code here:
         //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(pharmacyStockList1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_EmployeeReportbtn3MouseClicked

    private void Stock1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stock1MouseClicked
        // TODO add your handling code here:
         //Remove Panel
        CardLayoutPanel.removeAll();
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();

        //Add Panel
        CardLayoutPanel.add(pharmacyStock1);
        CardLayoutPanel.repaint();
        CardLayoutPanel.revalidate();
    }//GEN-LAST:event_Stock1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardBackOffice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddProduct;
    private javax.swing.JLabel AdminDashboardSignOutbtn;
    private javax.swing.JLabel BackOfficeDashboard;
    private javax.swing.JLabel BrandReg;
    private javax.swing.JPanel CardLayoutPanel;
    private javax.swing.JLabel CompanyReg;
    private javax.swing.JLabel EmployeeReportbtn;
    private javax.swing.JLabel EmployeeReportbtn1;
    private javax.swing.JLabel EmployeeReportbtn2;
    private javax.swing.JLabel EmployeeReportbtn3;
    private javax.swing.JLabel GRNbtn;
    private javax.swing.JLabel GRNbtn1;
    private javax.swing.JLabel MenuLogo;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Stock1;
    private javax.swing.JLabel SupplierList;
    private javax.swing.JLabel SupplierReg;
    private com.algounix.Panel.BackOffice.DashboardBackOffice dashboardBackOffice1;
    private com.algounix.Panel.GRN gRN1;
    private com.algounix.Panel.BackOffice.HospitalStockTransfer hospitalStockTransfer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.algounix.Panel.Pharmacy.PharmacyStock pharmacyStock1;
    private com.algounix.Panel.Pharmacy.PharmacyStockList pharmacyStockList1;
    private com.algounix.Panel.Pharmacy.PharmacyStockTransfer pharmacyStockTransfer1;
    private com.algounix.Panel.Reports reports1;
    private com.algounix.Panel.BackOffice.Stock stock1;
    private com.algounix.Panel.BackOffice.StockList stockList1;
    private com.algounix.Panel.SupplierList supplierList1;
    private com.algounix.Panel.BackOffice.SupplierReg supplierReg1;
    // End of variables declaration//GEN-END:variables
}
