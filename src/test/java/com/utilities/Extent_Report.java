package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testcases.Luma_BaseClass;

public class Extent_Report implements ITestListener
{
	public ExtentSparkReporter report;
	// it is provide the basic information of the document--> document tiitle, report name, theme of the report
	public ExtentReports extent;
	// it will provide the basic info of the user-->username, host name, environment, os, browser
	public ExtentTest test;
	//it is provide the basic info of the test cases--> Pass,fail,skip
	
	//pre-defined methods(onstart, onTestSuccess, OnTestFailure, OnTestSkipped, OnFinish)
	
	public void onStart(ITestContext tr) 
	{
   String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		
		String repname="Luma_Test_Report_"+timestamp+".html";
		
		report=new ExtentSparkReporter("D:\\testng workspace\\HybridFramework_Team31\\TestReport\\"+repname);
		
		//document tittle
		
		report.config().setDocumentTitle("Luma-Testing-Report");
		report.config().setReportName("Luma Registration test");
		report.config().setTheme(Theme.STANDARD);
		
		//provide basic info user
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		
		extent.setSystemInfo("Hostname", "Local Host");
		extent.setSystemInfo("User", "mastani");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome,Edge,Firefox");	
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	
	}
	
	public void onTestFailure(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		try 
		{
			String imgpath= new Luma_BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush(); // ==> it will remove un-nessecary data
	
	}
}
