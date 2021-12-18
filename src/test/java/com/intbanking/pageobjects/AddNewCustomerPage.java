package com.intbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	
	WebDriver ldriver;
	public AddNewCustomerPage(WebDriver driver)
	{
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	 
   @FindBy(name="name")	
	private WebElement customerName;
   
   @FindBy(name="dob")	
	private WebElement dOB;
   @FindBy(name="addr")	
	private WebElement address;
   @FindBy(name="city")	
   private WebElement city;
   @FindBy(name="state")	
   private WebElement state;
   @FindBy(name="pinno")	
   private WebElement pinNo;
   @FindBy(name="telephoneno")	
   private WebElement MobieNumber;
   @FindBy(name="emailid")	
   private WebElement emailID;
   @FindBy(name="password")	
   private WebElement password;
   
   
   public void setCustomerName(String name)
   {
	   customerName.sendKeys(name);
   }
   public void setDobDate(String day)
   {
	   dOB.sendKeys(day);
   }
   public void setDobMonth(String month)
   {
	   dOB.sendKeys(month);
   }
   public void setDobYear(String year)
   {
	   dOB.sendKeys(year);
   }
   public void setAddress(String add)
   {
	   address.sendKeys(add);
   }
   public void setCity(String c)
   {
	   city.sendKeys(c);
   }
   public void setState(String s)
   {
	   state.sendKeys(s);
   }
   public void setpinNo(String p)
   {
	   pinNo.sendKeys(p);
   }
   public void setMobileNumber(String m)
   {
	   MobieNumber.sendKeys(m);
   }
   public void setEamil(String e)
   {
	   emailID.sendKeys(e);
   }
   public void setPassword(String p)
   {
	   password.sendKeys(p);
   }
   
   
   

   
   
   

}
