package com.java.test.tweetapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.tweetapp.ForgetPassword;
import com.java.tweetapp.PostTweet;
import com.java.tweetapp.ResetPassword;
import com.java.tweetapp.SignIn;
import com.java.tweetapp.SignUp;
import com.java.tweetapp.ViewAllUserTweets;
import com.java.tweetapp.ViewAllUsers;
import com.java.tweetapp.ViewAllYourTweets;

public class TestTweet {
	
	SignIn sin=new SignIn();
	SignUp sup=new SignUp();
	ForgetPassword fp=new ForgetPassword();
	
	@Test
	public void testSignUp() {
		boolean exRes=true;
		boolean acRes=sup.signUp();
		assertEquals(exRes,acRes);
		
	}

	@Test
	public void testSignIn() {
		boolean exRes=true;
		boolean acRes=sin.signIn();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testForgetPassword() {
		boolean exRes=true;
		boolean acRes=fp.forgetPassword();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testPostTweet() {
		boolean exRes=true;
		boolean acRes=PostTweet.postATweet();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testViewAllYourTweets() {
		boolean exRes=true;
		boolean acRes=ViewAllYourTweets.viewAllYourTweets();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testViewAllUserTweets() {
		boolean exRes=true;
		boolean acRes=ViewAllUserTweets.viewAllUserTweets();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testViewAllUser() {
		boolean exRes=true;
		boolean acRes=ViewAllUsers.viewAllUser();
		assertEquals(exRes,acRes);
		
	}
	
	@Test
	public void testResetPassword() {
		boolean exRes=true;
		boolean acRes=ResetPassword.resetPassword();
		assertEquals(exRes,acRes);
		
	}
	
	
	
}
