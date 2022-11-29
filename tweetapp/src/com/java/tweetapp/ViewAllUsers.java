package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllUsers {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "select first_name from registration";
    
    public static boolean viewAllUser() {
    	
    	boolean a=false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	System.out.println(rs.getString("first_name"));
            	a=true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            a=false;
        }
		return a;
    }


}
