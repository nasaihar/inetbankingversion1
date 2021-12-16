package com.intbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties po;
	public ReadConfig()
	{
		File f=new File("./configuration/config.properties");
		try {
		  FileInputStream fis=new FileInputStream(f);
		  po=new Properties();
		  po.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String URL=po.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName()
	{
		String Username=po.getProperty("username");
		return Username;
	}
	
	public String getPassword()
	{
		String password= po.getProperty("password");
		return password;
	}
}
