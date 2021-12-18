package com.intbanking.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.intbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ReadConfig rg=new ReadConfig();
	
	public String baseurl=rg.getApplicationUrl();
	public String username=rg.getUserName();
	public String password=rg.getPassword();
	public static WebDriver driver;
	public static Logger log;

	
	@Parameters("browser")
	@SuppressWarnings("deprecation")
	@BeforeClass()
	public void setup(String browser)
	{
		log=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(browser.equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		log.info("Chrome Browser Launched");
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseurl);
		log.info("Base URL Enterned");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass()
	public void tearDown()
	{
		driver.quit();
		log.info("Browser Closed");
	}
	
	@SuppressWarnings("deprecation")
	public static void waitAlertPresent()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static boolean AlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
		return false;
		
		}
		
	}
	
	public static void waitUntilTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("Guru99 Bank New Customer Entry Page"));
	}
	
	public static void pressTab()
	{
		Actions a=new Actions(driver);
		a.keyDown(Keys.TAB);
	}

}
