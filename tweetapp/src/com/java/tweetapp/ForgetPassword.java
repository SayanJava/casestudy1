package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ForgetPassword {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "select * from registration where email=?;";
    static final String SQL = "update registration set password=? where email=?";
    
    public boolean forgetPassword(){
    	
    	boolean a;
    	
    	try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(SQL);
    			PreparedStatement p = conn.prepareStatement(QUERY)) {
    		Scanner sc=new Scanner(System.in);
    		System.out.println("enter email to change password");
	        String email = sc.next();
	        System.out.println("enter new password");
	        String passw = sc.next();
	        
	        p.setString(1, email);
	        ResultSet rs=p.executeQuery();
	        if(rs.next()) {
		        ps.setString(1, passw);
		        ps.setString(2, email);
	            ps.executeUpdate();
	            System.out.println("password changed successfully");
	            a=true;
            }
            else {
            	System.out.println("please enter valid email");
            	a=false;
            }

           } catch (SQLException e) {
               e.printStackTrace();
               a=false;
           }
		return a;

    }
	
}
