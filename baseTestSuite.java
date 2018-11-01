package com.base;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.flock.commonCode.commonCode;
import com.flock.constants.Path;
import com.flock.flyboardingAutomation.resetPassword;
import com.flock.utilities.DefaultStrings;
import com.flock.utilities.ExtentFactory;
import com.flock.utilities.GenericMethods;
import com.flock.utilities.OnBoardingUtils;
import com.flock.utilities.RestUtilities;
import com.flock.utilities.SignOutUtils;
import com.flock.utilities.flyboardingElements;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class baseTestSuite {

	public WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;
	protected GenericMethods gm;
	protected OnBoardingUtils onboard;
	protected SignOutUtils signOut;
	public commonCode cc;
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	protected flyboardingElements fl;
	public boolean isGoogleAppDomain;
	public boolean isFreeDomain;
	public boolean isPasswordSet;
	public boolean showPasswordScreen;
	public boolean showProfileScreen;
	public boolean showInviteScreen;
	public boolean urlAvailable;
	public boolean googleAuthCompulsory;
	public String teamName ="";
	public String teamUrl ="";
	public String userToken ="";
	public String otp = "";
	public String userGuid;
	public String enteredFName;
	public String enteredLName;
	public String teamURL = DefaultStrings.GENERATE_TEAM_URL;
	
	protected static final Logger log = LogManager.getLogger(resetPassword.class.getName());

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional(DefaultStrings.CHROME) String browser) {
		 
		System.out.println("BaseTestSuite -> Before Class");
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {
			System.out.println("inside the ff path");

			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, DefaultStrings.FIREFOX_DRIVER_PATH);
			System.out.println("ff path");

			    ProfilesIni ffProfiles = new ProfilesIni();
		        FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
		        System.out.println("ff profile");
		        FirefoxOptions firefoxOptions = new FirefoxOptions();
		        firefoxOptions.setProfile(profile);
		        System.out.println("profile set");
		        driver = new FirefoxDriver(firefoxOptions);

			/*ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			driver = new FirefoxDriver(profile);*/
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, DefaultStrings.CHROME_DRIVER_PATH);
			DesiredCapabilities capabilities = getDesiredCapabilities();
	
			driver = new ChromeDriver(capabilities);
		}
		
		if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getLatestFlockApp();
        } else {
            System.out.println("Not able to initialise driver! Failing tests explicitly");
            fail();
        }
		
		report = ExtentFactory.getInstance();
		gm = new GenericMethods(driver);
		test = report.startTest("Extent Test Result");
		onboard = new OnBoardingUtils(driver, test);
		signOut = new SignOutUtils(driver, test);
		fl = new flyboardingElements(driver, test);
		cc = new commonCode(driver, test);
	}
	
	 @BeforeClass
	 public void beforeClass() throws Exception{
			reqSpec = RestUtilities.getRequestSpecification();
			reqSpec.basePath(Path.BASE_PATH);
			resSpec = RestUtilities.getResponseSpecification();
			
	 }
	
	private void getLatestFlockApp() {
        driver.get(DefaultStrings.LATEST_FLOCK_LINK);
       List<WebElement> tbody = driver.findElements(By.cssSelector("body > table > tbody >tr"));
       for (WebElement tr : tbody) {
            if (tr.getText().contains("fl_hydra_web")) {
                WebElement link = tr.findElement(By.cssSelector("td:nth-child(2) > a"));
                String linkText = link.getAttribute("href");
                String stagingLinkText = linkText+"?s=qa&config=preprod&bucket=A";
                driver.get(stagingLinkText);
                log.info("Opening the lastest webclient");
                break;
            }
        }
	}
	
	 
	 private DesiredCapabilities getDesiredCapabilities() {
	        System.out.println("Inside getDesiredCapabilities");
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        
	        options.addArguments("test-type");
	        options.addArguments("--disable-notifications"); // Note: Disabled notifications to avoid chrome ok notifications dialog
	        options.addArguments("test-type");
			options.addArguments("start-maximized"); // Start windows maximized
			options.addArguments("--js-flags=--expose-gc");  
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
	        capabilities.setCapability("chrome.binary", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");

	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        return capabilities;
	    }
	 

	 @AfterClass
		public void afterClass() throws Exception {
		 //signOut.clearUserAccount();
		 test.log(LogStatus.INFO, "Signed Out from the Client");
		 System.out.println("BaseTestSuite -> After Class");
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
}
