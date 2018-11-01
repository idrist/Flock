package com.base;


import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utilities.DefaultStrings;
import com.utilities.ExtentFactory;
import com.utilities.GenericMethods;

public class SignInTestSuite{
	
	public WebDriver driver;
	//private ResourceBundle bundle;
	protected ExtentReports report;
	protected ExtentTest test;
	protected GenericMethods gm;
	
	
	
	 @BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional(DefaultStrings.CHROME) String browser) {
		 
		 
		//bundle = ResourceBundle.getBundle("config", Locale.getDefault());
		System.out.println("BaseTestSuite -> Before Class");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {
			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, DefaultStrings.FIREFOX_DRIVER_PATH);
			ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			driver = new FirefoxDriver(profile);
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, DefaultStrings.CHROME_DRIVER_PATH);
			DesiredCapabilities capabilities = getDesiredCapabilities();
			driver = new ChromeDriver(capabilities);
		}
		
		if (driver != null) {
            //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(DefaultStrings.FLOCK_WEB_PREPROD);
        } else {
            System.out.println("Not able to initialise driver! Failing tests explicitly");
            fail();
        }
		
		report = ExtentFactory.getInstance();
		gm = new GenericMethods(driver);
		test = report.startTest("Search Plus");
	}
	 
	 private DesiredCapabilities getDesiredCapabilities() {
	        System.out.println("Inside getDesiredCapabilities");
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        options.addArguments("--disable-notifications"); // Note: Disabled notifications to avoid chrome ok notifications dialog
	        capabilities.setCapability("chrome.binary", DefaultStrings.CHROME_DRIVER_PATH);
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        return capabilities;
	    }
	 
	 
	 @AfterTest
	 public void afterTest() throws Exception{
		 Thread.sleep(3000);
		 if (driver != null) {
	            driver.quit();
	            report.endTest(test);
	    		report.flush();
	        }
	 }
	 
	 @BeforeSuite
		public void beforeSuite() {
			System.out.println("BaseTestSuite -> After Test Suite");
		}
	 
	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> After Test Suite");
	}

}
