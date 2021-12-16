package com.intbanking.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.intbanking.pageobjects.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test()
	public void testLogin()
	{
		LoginPage l1=new LoginPage(driver);
		log.info("Calling LoginPage from Pom");
		l1.setUserName(username);
		log.info("Enterd Username");
		l1.setPassword(password);
		log.info("Enterned Password");
		l1.clickSubmit();
		log.info("Clicked on submit button");
		
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		log.info("Test is pass");
		
	}

}
