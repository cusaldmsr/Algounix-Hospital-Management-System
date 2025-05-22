/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algounix.Model;

/**
 *
 * @author kusal
 */
import com.algounix.GUI.Setupconnection;
import com.algounix.GUI.SignIn;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL implements Serializable {

    public String ip;
    public String port;
    public String pw;
    public String un;
    public String dbname;

    public String dump;
    public String path;

    private static final String CONFIG_FILE = "dbinfo.ser";
    public static Connection connection;

    public static void createConnection() throws Exception {
        
        if (connection != null) {
            return;
        }
        
        File configFile = new File(CONFIG_FILE);
        
        if(!configFile.exists()){
            System.out.println("Configuration file does not found. Re-directing to the Setup Connection Window...");
            new Setupconnection().setVisible(true);
            return;
        }

        FileInputStream inputStream = new FileInputStream(configFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        MySQL db = (MySQL) objectInputStream.readObject();
        objectInputStream.close();

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + db.ip + ":" + db.port + "/" + db.dbname, db.un, db.pw);
        
        new SignIn().setVisible(true);

    }

    public static ResultSet executeSearch(String query) throws Exception {

        createConnection();
        return connection.createStatement().executeQuery(query);
    }

    public static Integer executeIUD(String query) throws Exception {

        createConnection();
        return connection.createStatement().executeUpdate(query);

    }
}
