package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewAllYourTweets {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "select tweets from tweet where email=?;";
    
    public static boolean viewAllYourTweets() {
    	
    	boolean a=false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {
            Scanner sc = new Scanner(System.in);
        
            ps.setString(1,SignIn.email1);
            ResultSet rs=ps.executeQuery();
        	while(rs.next()) {
        		System.out.println(rs.getString("tweets"));
        		a=true;
        	}
            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            a=false;
	        }
			return a;
	    }
	
	}
