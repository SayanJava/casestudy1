package com.crud;

import java.sql.*;
import java.util.Scanner;

public class CrudUpdate {
    static final String DB_url = "jdbc:mysql://localhost:3306/cognidemo";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "select * from customers";
    static final String sql = "update customers set cust_fname=?,cust_lname=?,cust_age=?,cust_address=?,cust_income=? where cust_id=?";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(Query)) {

            while (rs.next()) {
                System.out.println("customer Id=" + rs.getInt("cust_id"));
                System.out.println("customer First Name=" + rs.getString("cust_fname"));
                System.out.println("customer Last Name=" + rs.getString("cust_lname"));
                System.out.println("customer Age=" + rs.getInt("cust_age"));
                System.out.println("customer Address=" + rs.getString("cust_address"));
                System.out.println("customer Income=" + rs.getInt("cust_income"));
            }
            System.out.println("--------------------------------------");
            System.out.println("Enter customer Id");
            Scanner sc = new Scanner(System.in);
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


            ps.setString(1, cfname);
            ps.setString(2, clname);
            ps.setInt(3,cage);
            ps.setString(4, cadd);
            ps.setInt(5, cincome);
            ps.setInt(6, cid);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
