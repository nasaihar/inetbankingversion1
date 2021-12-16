package com.intbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(name="uid")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	private WebElement loginbutton;
	@FindBy(xpath="//a[text()=\"Log out\"]")
	private WebElement logout;
	
	
	public void setUserName(String name)
	{
		txtUserName.sendKeys(name);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		loginbutton.click();
	}
	
	public void clickLogOut()
	{
		logout.click();
	}
}
