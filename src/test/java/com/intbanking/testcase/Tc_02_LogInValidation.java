package com.intbanking.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intbanking.pageobjects.LoginPage;
import com.intbanking.utilities.XLUtilis;

public class Tc_02_LogInValidation extends BaseClass {
 
	
	@Test(dataProvider="LoginTest")
	public void LoginDataValidation(String usr,String pwd,String type) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(usr);
		lp.setPassword(pwd);
		lp.clickSubmit();
		int i=1;
		String r=type;
		if(r.equals("Valid"))
		{
			
			Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
			lp.clickLogOut();
			waitAlertPresent();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			XLUtilis.setCellData("./src/test/java/com/intbanking/testdata/Testdata.xlsx", "Login", i, 3, "Pass");
		}
		else if(r.equals("InValid"))
		{
			
			Assert.assertTrue(AlertPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			XLUtilis.setCellData("./src/test/java/com/intbanking/testdata/Testdata.xlsx", "Login", i, 3, "Pass");
		}
		i++;
		System.out.println(i);
	}
	
	
	@DataProvider(name="LoginTest")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/intbanking/testdata/Testdata.xlsx";
		int rownum=XLUtilis.getRowCount(path, "Login");
		int column=XLUtilis.getCellCount(path, "Login", 1);
		String loginDaa [][]=new String[rownum][column];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<column;j++)
			{
				loginDaa[i-1][j]=XLUtilis.getCellData(path, "Login", i, j);
			}
		}
		return loginDaa;
	}
	

}