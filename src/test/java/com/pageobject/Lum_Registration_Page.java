package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lum_Registration_Page 
{
	//divided into 3 parts
	//1.constructor
	public static WebDriver driver;
	public Lum_Registration_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//2.identified the web elements
	@FindBy(xpath="(//a[text()='Create an Account'])[1]")
	WebElement linkcreateAccount;
	@FindBy(id="firstname")
	WebElement txtfirstname;
	@FindBy(id="lastname")
	WebElement txtLasttname;
	@FindBy(id="email_address")
	WebElement txtEmailAddress;
	@FindBy(id="password")
	WebElement txtpassword;
	@FindBy(id="password-confirmation")
	WebElement txtcnfrmpassword;
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement btncreateAccount;
	//3.create the corresponding action
	public void clickCreateAccountLink()
	{
		linkcreateAccount.click();
	}
	public void setFirstName(String Fname)
	{
		txtfirstname.sendKeys(Fname);
	}
	public void setLastName(String Lname)
	{
		txtLasttname.sendKeys(Lname);
	}
	public void setEmailAddress(String Email)
	{
		txtEmailAddress.sendKeys(Email);
	}
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	public void setConfirmpasswod(String cpassword)
	{
		txtcnfrmpassword.sendKeys(cpassword);
	}
	public void clickCreateAccountbtn()
	{
		btncreateAccount.click();
	}
	
	

}
