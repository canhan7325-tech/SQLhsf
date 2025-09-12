package com.annguyen.supperapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "12345";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");
            // TAOJ CLASS PREPAREDSTATEMENT dung de quan li cau sql (where, insert, update, delete)
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM Subject");
            ResultSet rs = pstm.executeQuery(); // thuc thi cau sql va tra ve ResultSet
            // giong ArrayList, chua nhiu dong/record, moi dong la 1 info cua mon hoc
            //Code|name|credit|....
            //vong lap cay cac dong, moi dong chu dong nho ten cot table, lat cot
            //nhuoc diem cua JDBC thuan
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int credit = rs.getInt("credits");
                int hour = rs.getInt("studyhours");
                //vasghjdfaisdgaksjdkasjhdkajhsdkashdjashda
                
                //System.out.println(code + "\t" + name + "\t" + credit + "\t" + hour);
                System.out.printf("|%10s|%-40s|%2d|%4d\n", code, name, credit, hour);// in gióng lề

            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
