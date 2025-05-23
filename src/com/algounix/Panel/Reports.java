package com.algounix.Panel;

import com.algounix.Components.ScrollBar;

// JFreeChart
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;

// JDBC
import com.algounix.Model.MySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.sql.ResultSet;
import org.jfree.chart.renderer.category.BarRenderer;

public class Reports extends javax.swing.JPanel {

    public Reports() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        displayCharts();

    }

    private void displayCharts() {
        // Add charts to panels in ascending order
        chart1.add(createPieChartPanel(createPatientBloodGroupDataset(), "Patient Blood Group Distribution")); // ok
        chart2.add(createBarChartPanel(createNewPatientsThisMonthDataset(), "New Patients This Month")); // ok
        chart3.add(createBarChartPanel(createPharmacyFastMovingItemDataset(), "Last Month Fast-Moving Medicines in Pharmacy Stock")); // ok
        chart4.add(createLineChartPanel(createIncomeGrowthDataset(), "Income Growth Comparison"));
        chart5.add(createBarChartPanel(createMostVisitedDoctorDataset(), "Most Visited Doctor")); // ok
        chart6.add(createBarChartPanel(createTopFiveSellingMedicinesDataset(), "Top 5 Selling Medicines by Revenue")); // ok
        chart7.add(createPieChartPanel(createRoomOccupancyDataset(), "Room Occupancy Rate")); // ok
        chart8.add(createBarChartPanel(createTotalRevenuebyHospitalServDataset(), "Total Revenue from Hospital Services")); // ok
        chart9.add(createPieChartPanel(createPatientAgeGroupDataset(), "Patient Age Group Distribution")); // ok
        chart10.add(createPieChartPanel(createTopPrescribedMedicinesPieDataset(), " Top 5 Prescribed Medicines")); // ok
        chart11.add(createPieChartPanel(createTestTypeDataset(), "Lab Test Type Distribution")); // ok
        chart12.add(createLineChartPanel(createIncomeLineChartDataset(), "Monthly Income "));

        // Repaint and revalidate charts
        chart1.repaint();
        chart1.revalidate();
        chart2.repaint();
        chart2.revalidate();
        chart3.repaint();
        chart3.revalidate();
        chart4.repaint();
        chart4.revalidate();
        chart5.repaint();
        chart5.revalidate();
        chart6.repaint();
        chart6.revalidate();
        chart7.repaint();
        chart7.revalidate();
        chart8.repaint();
        chart8.revalidate();
        chart9.repaint();
        chart9.revalidate();
        chart10.repaint();
        chart10.revalidate();
        chart11.repaint();
        chart11.revalidate();
        chart12.repaint();
        chart12.revalidate();

        // Set layouts
        chart1.setLayout(new java.awt.GridLayout(1, 1));
        chart2.setLayout(new java.awt.GridLayout(1, 1));
        chart3.setLayout(new java.awt.GridLayout(1, 1));
        chart4.setLayout(new java.awt.GridLayout(1, 1));
        chart5.setLayout(new java.awt.GridLayout(1, 1));
        chart6.setLayout(new java.awt.GridLayout(1, 1));
        chart7.setLayout(new java.awt.GridLayout(1, 1));
        chart8.setLayout(new java.awt.GridLayout(1, 1));
        chart9.setLayout(new java.awt.GridLayout(1, 1));
        chart10.setLayout(new java.awt.GridLayout(1, 1));
        chart11.setLayout(new java.awt.GridLayout(1, 1));
        chart12.setLayout(new java.awt.GridLayout(1, 1));
    }

    //barchart panel
    private ChartPanel createBarChartPanel(DefaultCategoryDataset dataset, String chartTitle) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Item",
                "Quantity",
                dataset
        );
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        plot.getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        plot.setBackgroundPaint(Color.WHITE);
        barChart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 12));
        barChart.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 10));

        // Apply multicolor effect
        BarRenderer renderer = new BarRenderer() {
            @Override
            public Paint getItemPaint(int row, int column) {
                // Use different colors for each bar (based on column index)
                Paint[] colors = new Paint[]{
                    new Color(79, 129, 189),
                    new Color(192, 80, 77),
                    new Color(155, 187, 89),
                    new Color(128, 100, 162),
                    new Color(75, 172, 198),
                    new Color(247, 150, 70)
                };
                return colors[column % colors.length];
            }
        };

        plot.setRenderer(renderer);

        return new ChartPanel(barChart);
    }

    private ChartPanel createPieChartPanel(DefaultPieDataset dataset, String chartTitle) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                chartTitle,
                dataset,
                true,
                true,
                false
        );

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        pieChart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 12));
        pieChart.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 10));

        Paint[] colors = new Paint[]{
            new Color(79, 129, 189),
            new Color(192, 80, 77),
            new Color(155, 187, 89),
            new Color(128, 100, 162),
            new Color(75, 172, 198),
            new Color(247, 150, 70)
        };

        int i = 0;
        for (Object key : dataset.getKeys()) {
            plot.setSectionPaint((Comparable) key, colors[i % colors.length]);
            i++;
        }

        return new ChartPanel(pieChart);
    }

    //linechart panel
    private ChartPanel createLineChartPanel(DefaultCategoryDataset dataset, String chartTitle) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Date",
                "Income",
                dataset
        );

        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.getDomainAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        plot.getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        lineChart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 12));
        lineChart.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 10));
        return new ChartPanel(lineChart);
    }

    //patient by blood group
    private DefaultPieDataset createPatientBloodGroupDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT bg.name AS blood_group, COUNT(*) AS total FROM patient p JOIN blood_group bg ON p.blood_group_id = bg.id GROUP BY bg.name;");
            while (rs.next()) {
                dataset.setValue(rs.getString("blood_group"), rs.getInt("total"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //new Patients
    private DefaultCategoryDataset createNewPatientsThisMonthDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT DATE(patient.register_date) AS reg_date, COUNT(*) AS total \n"
                    + "FROM patient \n"
                    + "WHERE MONTH(patient.register_date) = MONTH(CURDATE()) GROUP BY DATE(patient.register_date)");
            while (rs.next()) {
                dataset.addValue(rs.getInt("total"), "New Patients", rs.getString("reg_date"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }
private DefaultPieDataset createTopPrescribedMedicinesPieDataset() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try {
        ResultSet rs = MySQL.executeSearch("SELECT m.name AS medicine_name, COUNT(*) AS prescription_count\n"
                + "FROM prescription_item pi\n"
                + "JOIN prescription p ON pi.prescription_id = p.id\n"
                + "JOIN medicine m ON pi.medicine_id = m.id\n"
                + "WHERE p.date >= CURDATE() - INTERVAL 1 MONTH\n"
                + "GROUP BY m.name\n"
                + "ORDER BY prescription_count DESC\n"
                + "LIMIT 5");
        while (rs.next()) {
            String name = rs.getString("medicine_name");
            int count = rs.getInt("prescription_count");
            dataset.setValue(name, count);
        }
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dataset;
}


    //Last Month Fast-Moving Medicines in Pharmacy Stock – Weekly Comparison
    private DefaultCategoryDataset createPharmacyFastMovingItemDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT WEEK(phi.date) AS week_number, m.name, SUM(pii.qty) AS total_sold\n"
                    + "FROM pharmacy_invoice_item pii\n"
                    + "JOIN pharmacy_stock ps ON pii.parmacy_stock_id = ps.id\n"
                    + "JOIN main_stock ms ON ps.main_stock_id = ms.id\n"
                    + "JOIN medicine m ON ms.medicine_id = m.id\n"
                    + "JOIN pharmacy_invoice phi ON pii.pharmacy_invoice_id = phi.id\n"
                    + "WHERE phi.date >= CURDATE() - INTERVAL 1 MONTH\n"
                    + "GROUP BY WEEK(phi.date), m.name\n"
                    + "ORDER BY total_sold DESC\n"
                    + "LIMIT 10");
            while (rs.next()) {
                dataset.addValue(rs.getInt("week_number"), rs.getString("m.name"), rs.getString("total_sold"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }
    

    //Income Growth Comparison
    private DefaultCategoryDataset createIncomeGrowthDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT DATE_FORMAT(date, '%Y-%m') AS month, SUM(payment) AS total_income\n"
                    + "FROM hospital_invoice\n"
                    + "GROUP BY DATE_FORMAT(date, '%Y-%m')\n"
                    + "ORDER BY month");

            while (rs.next()) {
                String date = rs.getString("month");
                double income = rs.getDouble("total_income");
                dataset.addValue(income, "Income", date);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //Top 5 Selling Medicines by Revenue
    private DefaultCategoryDataset createTopFiveSellingMedicinesDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT m.name, SUM(pii.qty * ps.selling_price) AS revenue\n"
                    + "FROM pharmacy_invoice_item pii\n"
                    + "JOIN pharmacy_stock ps ON pii.parmacy_stock_id = ps.id\n"
                    + "JOIN main_stock ms ON ps.main_stock_id = ms.id\n"
                    + "JOIN medicine m ON ms.medicine_id = m.id\n"
                    + "GROUP BY m.name\n"
                    + "ORDER BY revenue DESC\n"
                    + "LIMIT 5");
            while (rs.next()) {
                dataset.addValue(rs.getInt("revenue"), "Medicine", rs.getString("m.name"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //most visited doctor
    private DefaultCategoryDataset createMostVisitedDoctorDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT d.first_name, COUNT(*) AS visits\n"
                    + "FROM appoinment a\n"
                    + "JOIN doctor_has_units dhu ON a.doctor_has_units_id = dhu.id\n"
                    + "JOIN doctor d ON dhu.doctor_id = d.id\n"
                    + "GROUP BY d.first_name\n"
                    + "ORDER BY visits DESC\n"
                    + "LIMIT 5");
            while (rs.next()) {
                dataset.addValue(rs.getInt("visits"), "Doctor", rs.getString("d.first_name"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //Room Occupy
    private DefaultPieDataset createRoomOccupancyDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch(
                    "SELECT "
                    + "(SELECT COUNT(*) FROM room WHERE room.room_status_id = (SELECT id FROM room_status WHERE name = 'Non-Available')) AS occupied, "
                    + "(SELECT COUNT(*) FROM room WHERE room.room_status_id = (SELECT id FROM room_status WHERE name = 'Available')) AS available;"
            );

            if (rs.next()) {
                int occupied = rs.getInt("occupied");
                int available = rs.getInt("available");
                dataset.setValue("Occupied", occupied);
                dataset.setValue("Available", available);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //total revenue by hospital services
    private DefaultCategoryDataset createTotalRevenuebyHospitalServDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT DATE(date) AS day, SUM(payment) AS total\n"
                    + "FROM hospital_invoice\n"
                    + "GROUP BY DATE(date)\n"
                    + "ORDER BY day DESC\n"
                    + "LIMIT 10");
            while (rs.next()) {
                dataset.addValue(rs.getInt("total"), "Revenue", rs.getString("day"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //patient age
    private DefaultPieDataset createPatientAgeGroupDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT\n"
                    + "  CASE\n"
                    + "    WHEN TIMESTAMPDIFF(YEAR, p.birthday, CURDATE()) < 18 THEN '0-17'\n"
                    + "    WHEN TIMESTAMPDIFF(YEAR, p.birthday, CURDATE()) BETWEEN 18 AND 35 THEN '18-35'\n"
                    + "    WHEN TIMESTAMPDIFF(YEAR, p.birthday, CURDATE()) BETWEEN 36 AND 60 THEN '36-60'\n"
                    + "    ELSE '60+'\n"
                    + "  END AS age_group,\n"
                    + "  COUNT(*) AS total\n"
                    + "FROM patient AS p\n"
                    + "GROUP BY age_group");

            while (rs.next()) {
                String ageGroup = rs.getString("age_group");
                int count = rs.getInt("total");
                dataset.setValue(ageGroup, count);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //test type
    private DefaultPieDataset createTestTypeDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT lt.name AS test_type, COUNT(*) AS total_tests "
                    + "FROM test_type lt "
                    + "GROUP BY lt.name");

            while (rs.next()) {
                String testType = rs.getString("test_type");
                int count = rs.getInt("total_tests");
                dataset.setValue(testType, count);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    //Weekly New Patient Registrations (Last 4 Weeks)
    private DefaultCategoryDataset createWeeklyNEWPatientsDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch(
                    "SELECT\n"
                    + "  WEEK(p.register_date) AS week_number,\n"
                    + "  COUNT(*) AS total_registrations\n"
                    + "FROM patient AS p\n"
                    + "WHERE p.register_date >= CURDATE() - INTERVAL 28 DAY\n"
                    + "GROUP BY WEEK(p.register_date)\n"
                    + "ORDER BY WEEK(p.register_date)"
            );

            while (rs.next()) {
                int total = rs.getInt("total_registrations");
                String week = "Week " + rs.getInt("week_number");
                dataset.addValue(total, "Registrations", week);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    private DefaultCategoryDataset createIncomeLineChartDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            String query = "SELECT\n"
                    + "  DATE_FORMAT(date, '%Y-%m') AS month,\n"
                    + "  SUM(payment) AS total_income\n"
                    + "FROM hospital_invoice\n"
                    + "GROUP BY DATE_FORMAT(date, '%Y-%m')\n"
                    + "ORDER BY DATE_FORMAT(date, '%Y-%m');";

            ResultSet rs = MySQL.executeSearch(query);

            while (rs.next()) {
                String month = rs.getString("month");
                double income = rs.getDouble("total_income");
                dataset.addValue(income, "Income", month);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        chart1 = new javax.swing.JPanel();
        chart2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        chart3 = new javax.swing.JPanel();
        chart5 = new javax.swing.JPanel();
        chart4 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        chart6 = new javax.swing.JPanel();
        chart8 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        chart7 = new javax.swing.JPanel();
        chart9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        chart11 = new javax.swing.JPanel();
        chart12 = new javax.swing.JPanel();
        chart10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(205, 245, 253));

        jScrollPane1.setBackground(new java.awt.Color(205, 245, 253));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(205, 245, 253));

        jPanel5.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        chart1.setBackground(new java.awt.Color(205, 245, 253));
        chart1.setOpaque(false);

        javax.swing.GroupLayout chart1Layout = new javax.swing.GroupLayout(chart1);
        chart1.setLayout(chart1Layout);
        chart1Layout.setHorizontalGroup(
            chart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart1Layout.setVerticalGroup(
            chart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart2.setBackground(new java.awt.Color(205, 245, 253));
        chart2.setOpaque(false);

        javax.swing.GroupLayout chart2Layout = new javax.swing.GroupLayout(chart2);
        chart2.setLayout(chart2Layout);
        chart2Layout.setHorizontalGroup(
            chart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart2Layout.setVerticalGroup(
            chart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);

        chart3.setBackground(new java.awt.Color(205, 245, 253));
        chart3.setOpaque(false);

        javax.swing.GroupLayout chart3Layout = new javax.swing.GroupLayout(chart3);
        chart3.setLayout(chart3Layout);
        chart3Layout.setHorizontalGroup(
            chart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart3Layout.setVerticalGroup(
            chart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart5.setBackground(new java.awt.Color(205, 245, 253));
        chart5.setOpaque(false);

        javax.swing.GroupLayout chart5Layout = new javax.swing.GroupLayout(chart5);
        chart5.setLayout(chart5Layout);
        chart5Layout.setHorizontalGroup(
            chart5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart5Layout.setVerticalGroup(
            chart5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart4.setBackground(new java.awt.Color(205, 245, 253));
        chart4.setOpaque(false);

        javax.swing.GroupLayout chart4Layout = new javax.swing.GroupLayout(chart4);
        chart4.setLayout(chart4Layout);
        chart4Layout.setHorizontalGroup(
            chart4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart4Layout.setVerticalGroup(
            chart4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chart4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chart3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setOpaque(false);

        chart6.setBackground(new java.awt.Color(205, 245, 253));
        chart6.setOpaque(false);

        javax.swing.GroupLayout chart6Layout = new javax.swing.GroupLayout(chart6);
        chart6.setLayout(chart6Layout);
        chart6Layout.setHorizontalGroup(
            chart6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart6Layout.setVerticalGroup(
            chart6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart8.setBackground(new java.awt.Color(205, 245, 253));
        chart8.setOpaque(false);

        javax.swing.GroupLayout chart8Layout = new javax.swing.GroupLayout(chart8);
        chart8.setLayout(chart8Layout);
        chart8Layout.setHorizontalGroup(
            chart8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart8Layout.setVerticalGroup(
            chart8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setOpaque(false);

        chart7.setBackground(new java.awt.Color(205, 245, 253));
        chart7.setOpaque(false);

        javax.swing.GroupLayout chart7Layout = new javax.swing.GroupLayout(chart7);
        chart7.setLayout(chart7Layout);
        chart7Layout.setHorizontalGroup(
            chart7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart7Layout.setVerticalGroup(
            chart7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart9.setBackground(new java.awt.Color(205, 245, 253));
        chart9.setOpaque(false);

        javax.swing.GroupLayout chart9Layout = new javax.swing.GroupLayout(chart9);
        chart9.setLayout(chart9Layout);
        chart9Layout.setHorizontalGroup(
            chart9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart9Layout.setVerticalGroup(
            chart9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);

        chart11.setBackground(new java.awt.Color(205, 245, 253));
        chart11.setOpaque(false);

        javax.swing.GroupLayout chart11Layout = new javax.swing.GroupLayout(chart11);
        chart11.setLayout(chart11Layout);
        chart11Layout.setHorizontalGroup(
            chart11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart11Layout.setVerticalGroup(
            chart11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart12.setBackground(new java.awt.Color(205, 245, 253));
        chart12.setOpaque(false);

        javax.swing.GroupLayout chart12Layout = new javax.swing.GroupLayout(chart12);
        chart12.setLayout(chart12Layout);
        chart12Layout.setHorizontalGroup(
            chart12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chart12Layout.setVerticalGroup(
            chart12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        chart10.setBackground(new java.awt.Color(205, 245, 253));
        chart10.setOpaque(false);

        javax.swing.GroupLayout chart10Layout = new javax.swing.GroupLayout(chart10);
        chart10.setLayout(chart10Layout);
        chart10Layout.setHorizontalGroup(
            chart10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        chart10Layout.setVerticalGroup(
            chart10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("KPI Reports");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel64)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart10;
    private javax.swing.JPanel chart11;
    private javax.swing.JPanel chart12;
    private javax.swing.JPanel chart2;
    private javax.swing.JPanel chart3;
    private javax.swing.JPanel chart4;
    private javax.swing.JPanel chart5;
    private javax.swing.JPanel chart6;
    private javax.swing.JPanel chart7;
    private javax.swing.JPanel chart8;
    private javax.swing.JPanel chart9;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
