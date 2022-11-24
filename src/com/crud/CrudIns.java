package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudIns {
    static final String DB_url = "jdbc:mysql://localhost:3306/cognidemo";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "insert into customers(cust_id,cust_fname,cust_lname,cust_age,cust_address,cust_income) values(?,?,?,?,?,?)";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(Query)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter Customer Id");
            int cid = sc.nextInt();
            System.out.println("enter Customer First Name");
            String cfname = sc.next();
            System.out.println("enter Customer Last Name");
            String clname = sc.next();
            System.out.println("enter Customer Age");
            int cage = sc.nextInt();
            System.out.println("enter Customer Address");
            String cadd = sc.next();
            System.out.println("enter Customer Income");
            int cincome = sc.nextInt();

            ps.setInt(1, cid);
            ps.setString(2, cfname);
            ps.setString(3, clname);
            ps.setInt(4,cage);
            ps.setString(5, cadd);
            ps.setInt(6, cincome);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
