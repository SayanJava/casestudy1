package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "insert into registration(first_name,email,password) values(?,?,?)";
	
	public boolean signUp(){
		
		boolean a=false;

	    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         PreparedStatement ps = conn.prepareStatement(QUERY)) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("enter  first name");
	        String fname = sc.nextLine();
	        System.out.println("enter email");
	        String email = sc.nextLine();
	        System.out.println("password");
	        String passw = sc.nextLine();
	        
	        if(fname.isEmpty()==false && email.isEmpty()==false && passw.isEmpty()==false) {
	        	if(email.contains("@") && email.contains(".com") ) {
		        	ps.setString(1, fname);
			        ps.setString(2, email);
			        ps.setString(3, passw);
			        ps.executeUpdate();
			        System.out.println("registration is successful");
			        a=true;
		        }
	        	else {
	        		System.out.println("please enter valid email");
	        		a=false;
	        	}
	        }
	        
	        else {
	        	System.out.println("please enter valid data");
	        	a=false;
	        }
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        a=false;
	    }
		return a;

	}
	
}
