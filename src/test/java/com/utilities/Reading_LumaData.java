package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reading_LumaData 
{
	Properties pro;
	public Reading_LumaData()
	{
		try
		{
		File file=new File("D:\\testng workspace\\HybridFramework_Team31\\configuration\\Data.Properties");
		FileInputStream fis=new FileInputStream(file);
		 pro=new Properties();
		 pro.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		//registration
		public String getFirstName()
		{
			String FName=pro.getProperty("FirstName");
			return FName;
		}
		public String getLastName()
		{
			String LName=pro.getProperty("LastName");
			return LName;
		}
		public String getEmailAddress()
		{
			String EmailAdd=pro.getProperty("Email");
			return EmailAdd;
		}
		public String getPassword()
		{
			String password=pro.getProperty("password");
			return password;
		}
		public String getcnfrmpassword()
		{
			String cpassword=pro.getProperty("confirmpassword");
			return cpassword;
			
		}
		
		
	

}
