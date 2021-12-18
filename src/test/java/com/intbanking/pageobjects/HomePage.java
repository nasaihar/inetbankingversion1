package com.intbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;
	public HomePage(WebDriver driver)
	{
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Customer")
	private WebElement NewCustomer;
	
	public void navigateToAddCustomerPage()
	{
		NewCustomer.click();
	}
	
}
