package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Login_page 
{//divided into 3 parts
	public static WebDriver driver;
	//constructor
	public Luma_Login_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//ientified the elements
	@FindBy(id="email")
	WebElement txtemail;
	@FindBy(id="pass")
	WebElement txtpassword;
	@FindBy(id="send2")
	WebElement btnsignin;
	//create the corresponding actions
	public void setEmail(String Email)
	{
		txtemail.sendKeys(Email);
	}
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	public void clcikButton()
	{
		btnsignin.click();
	}
	public void clearEmail()
	{
		txtemail.clear();
	}
	public void clearpassword()
	{
		txtpassword.clear();
	}

}
