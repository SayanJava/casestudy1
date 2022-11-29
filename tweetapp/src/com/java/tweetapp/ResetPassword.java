package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ResetPassword {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "update registration set password=? where email=?";
    
    public static boolean resetPassword(){
    	
    	boolean a;
    	try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(QUERY);
                ) {
    		Scanner sc=new Scanner(System.in);
    		System.out.println("enter new password");
    		String pass=sc.next();
	        
    		if(pass.isEmpty()==false) {
    			ps.setString(1, pass);
    	        ps.setString(2, SignIn.email1);
                ps.executeUpdate();
                System.out.println("your password is reset successfully");
                a=true;
    		}
    		else {
    			System.out.println("please enter something");
    			a=false;
    		}
	        

           } catch (SQLException e) {
               e.printStackTrace();
               a=false;
           }
		return a;

    }

}
