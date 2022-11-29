package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SignIn {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "select * from registration where email=? AND password=?;";
    int flag=0;
    static String email1="";

    public boolean signIn() {
    	
    	boolean a=false;
    	
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {
            Scanner sc = new Scanner(System.in);
        
            System.out.println("enter email");
            String email = sc.nextLine();
            System.out.println("password");
            String password = sc.nextLine();

            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	System.out.println("login successful");
            	flag=1;
            	email1=email;
            	a=true;
            	
            }
            else {
            	System.out.println("login fail");
            	a=false;
            }
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            a=false;
        }
		return a;
    }
}

