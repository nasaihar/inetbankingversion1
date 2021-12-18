package com.intbanking.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.intbanking.pageobjects.AddNewCustomerPage;
import com.intbanking.pageobjects.HomePage;
import com.intbanking.pageobjects.LoginPage;

public class CreateUserValidation extends BaseClass {
	
	
	@Test()
	public void CustomerPageValidation() throws InterruptedException
	{
		LoginPage l1=new LoginPage(driver);
		l1.setUserName(username);
		log.info("UserName Enterned");
		l1.setPassword(password);
		log.info("Password Enterned");
		l1.clickSubmit();
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		log.info("Login Sucessfully");
		HomePage h1=new HomePage(driver);
		h1.navigateToAddCustomerPage();
		log.info("Navigate to Add Customer Page");
		waitUntilTitle();
		log.info("Successfully Navigate to Add Customer Page");
		Assert.assertTrue(driver.getPageSource().contains("Add New Customer"), "Page not contains Add New Customer Text");
		AddNewCustomerPage a=new AddNewCustomerPage(driver);
		a.setCustomerName(" ");
		log.info("Customer name enterned");
		a.setDobDate(" ");
		log.info("Customer DOB enterned");
		a.setAddress(" ");
		log.info("Customer Address enterned");
		a.setCity(" ");
		log.info("Customer City enterned");
		a.setState(" ");
		log.info("Customer State enterned");
		a.setpinNo(" ");
		log.info("Customer Pino enterned");
		a.setMobileNumber(" ");
		log.info("Customer mobile number enterned");
		a.setEamil(" ");
		log.info("Customer Email ID enterned");
		a.setPassword(" "+Keys.TAB);
		log.info("Customer Password enterned");
		log.info("Tab Pressed");
		Thread.sleep(5000);
		SoftAssert s=new SoftAssert();
		//s.assertEquals("Customer name must not be blank", driver.findElement(By.id("message")).getText());
		s.assertEquals("Date Field must not be blank", driver.findElement(By.id("message24")).getText());
		//s.assertEquals("Address Field must not be blank", driver.findElement(By.id("message3")).getText());
		s.assertAll();
	}

}
