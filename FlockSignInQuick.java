package com.signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.SignInTestSuite;
import com.utilities.DefaultStrings;

public class FlockSignInQuick extends SignInTestSuite {
	

	public WebDriver getDriver(){
		return driver;
	}
	
	
	@Test(priority =1)
	public void SignIn(){
		gm.implicitWait(40);
		gm.SwitchToiFrameNo(0);
		gm.SendKey(By.xpath("//input[@class='input']"), 1, DefaultStrings.DIRECTI_TESTER_002_Email);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), 2);
		gm.SendKey(By.xpath("//input[@class='input']"), 1, DefaultStrings.OTP);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
	}
	
	@AfterMethod
	public void afterMethod() {		
		System.out.println("BaseTestSuite -> After Method");
	}
}
