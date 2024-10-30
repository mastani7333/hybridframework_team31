package com.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.Reading_LumaData;

public class Luma_BaseClass 
{
   public Logger log;
	
	Reading_LumaData rid=new Reading_LumaData();
	public static WebDriver driver;
	
	public String Fname=rid.getFirstName();
	public String Lname=rid.getLastName();
	public String Emailadd=rid.getEmailAddress();
	public String password=rid.getPassword();
	public String Cpassword=rid.getcnfrmpassword();
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br,String URl)
	{
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URl);
		driver.manage().window().maximize();
		log=Logger.getLogger("HybridFramework_Team31");
		PropertyConfigurator.configure("log4j.Properties");
		}
	public String captureScreen(String tname)
	{
		 String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		 TakesScreenshot screenshot=((TakesScreenshot) driver);
		 File source=screenshot.getScreenshotAs(OutputType.FILE);
		 //screenshot//project directory
		 String destination=System.getProperty("user.dir")+"\\Screenshot\\"+tname+"_"+timestamp+".png";
		 try
		 {
			 FileUtils.copyFile(source, new File(destination));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return destination;
		
	}
	
	
//	@AfterClass
//	public void closeApllication()
//	{
//		driver.close();
//	}
	
	

}
