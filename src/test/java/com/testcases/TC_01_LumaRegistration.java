package com.testcases;

import org.testng.annotations.Test;

import com.pageobject.Lum_Registration_Page;

public class TC_01_LumaRegistration extends Luma_BaseClass 
{
	Lum_Registration_Page lr;
	@Test
	public void LumaRegisration()
	{
		lr=new Lum_Registration_Page(driver);
		lr.clickCreateAccountLink();
		log.info("Luma create account clicking activity is completed");
		lr.setFirstName(Fname);
		log.info("Firstname enterd sucessfully");
		lr.setLastName(Lname);
		log.info("Lastaname enterd sucessfully");
		lr.setEmailAddress(Emailadd);
		log.info("emailaddress enterd sucessfully");
		lr.setPassword(password);
		log.info("password enterd sucessfully");
		lr.setConfirmpasswod(Cpassword);
		log.info("confrm password");
		lr.clickCreateAccountbtn();
		log.info("createAccount button is clickable");
		}

}
