package com.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobject.Luma_Login_page;
import com.utilities.XlUtilitiesFile;

public class TC_02_LumaLogin  extends Luma_BaseClass 
{
	@Test(dataProvider="Luma_testdata1")
	public void loginTest(String Email,String Password) throws InterruptedException
	{
		Luma_Login_page lp=new Luma_Login_page(driver);
		lp.setEmail(Email);
		log.info("email entered");
		Thread.sleep(3000);
		lp.setPassword(Password);
		log.info("password is entered");
		lp.clcikButton();
		Thread.sleep(3000);
		log.info("signin button is clickable");
		lp.clearEmail();
		lp.clearpassword();
	}
	@DataProvider(name="Luma_testdata1")
	String[][] getData() throws IOException
	{
		String path="D:\\testng workspace\\HybridFramework_Team31\\src\\test\\java\\com\\testdata\\Luma_testdata1.xlsx";
		//identified the row count
		int rownum=XlUtilitiesFile.getRowCount(path, "Sheet1");
		//identify the col count
		int colcount=XlUtilitiesFile.getCellcount(path, "Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)//it will represent rows
		{
			for(int j=0;j<colcount;j++)//it will represent columns
			{
				logindata[i-1][j]=XlUtilitiesFile.getcelldata(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
