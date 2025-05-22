/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algounix.Components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class RoundPanel extends JPanel {

    public RoundPanel() {
        init();
    }

    public void init(){
        this.putClientProperty(FlatClientProperties.STYLE, "arc:20");
    }

}
