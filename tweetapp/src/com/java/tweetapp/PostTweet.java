package com.java.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PostTweet {
	static final String DB_URL = "jdbc:mysql://localhost:3306/casestudy";
    static final String USER = "root";
    static final String PASS = "pass@word1";
    static final String QUERY = "insert into tweet(email,tweets) values(?,?)";
	
	public static boolean postATweet(){
		
		boolean a=false;
		
	    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         PreparedStatement ps = conn.prepareStatement(QUERY)) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("post a tweet here");
	        String twt = sc.nextLine();
	        
	        if(twt.isEmpty()==false) {
	        	ps.setString(1, SignIn.email1);
		        ps.setString(2, twt);
		        ps.executeUpdate();
		        a=true;
	        }
	        else {
	        	System.out.println("please type something");
	        	a=false;
	        }
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        a=false;
	    }
		return a;


}
}
