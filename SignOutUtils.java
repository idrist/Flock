package com.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignOutUtils {
	private WebDriver driver;
	ExtentTest test; 
    private GenericMethods gm;
    private static final Logger log = LogManager.getLogger(SignOutUtils.class.getName());
    
    public SignOutUtils(WebDriver webDriver, ExtentTest test) {
        this.driver = webDriver;
        this.test = test;
        gm = new GenericMethods(this.driver);
    }
    
    public void flockSignOut() throws Exception{
    	gm.click(By.xpath("//div[@class='app_menu_body']"), 2);
		gm.click(By.id("app-menu-item-sing-out"), 1);
		gm.click(By.xpath("//div[@class='action__buttons']//button[contains(text(),'Sign out')]"), 1);
		log.info("The test user has been signed out");
		test.log(LogStatus.INFO, "The test user has been signed out");
		Thread.sleep(8000);
    }
    
    public void clearUserAccount() throws Exception{
    	Thread.sleep(2000);
    	if (gm.isElementPresent("//div[@class='app_menu_body']", "xpath")) {
			log.info("App not logged out. Try logging out from the default test account.");
			test.log(LogStatus.INFO, "App not logged out. Try logging out from the default test account.");
			flockSignOut();
		} else {
			log.info("App user already logged out");
		}
    }
}
