package com.base;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Flock.HydraAutomation.searchPlus;
import com.inviteContacts.inviteContactFullMemberEmptyState;
import com.inviteContacts.inviteContactFullMemberImportedContact;
import com.inviteContacts.inviteContactGuestMember;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.DefaultStrings;
import com.utilities.ExtentFactory;
import com.utilities.GenericMethods;
import com.utilities.OnBoardingUtils;
import com.utilities.SignOutUtils;
import com.utilities.clientElement;
import com.utilities.clientElement1;
import com.Flock.HydraAutomation.slashCommands;

public class BaseTestSuite{
	
	public WebDriver driver;
	private ResourceBundle bundle;
	protected ExtentReports report;
	protected ExtentTest test;
	protected GenericMethods gm;
	protected OnBoardingUtils onboard;
	protected SignOutUtils signOut;
	protected clientElement ce;
	protected clientElement1 ce1;
	protected inviteContactFullMemberImportedContact google;
	protected inviteContactFullMemberEmptyState fe;
	protected inviteContactGuestMember ge;
	protected static final Logger log = LogManager.getLogger(searchPlus.class.getName());
	

	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional(DefaultStrings.CHROME) String browser) {
		 
		
		bundle = ResourceBundle.getBundle("config", Locale.getDefault());
		System.out.println("BaseTestSuite -> Before Class");
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {

			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, bundle.getString("firefox_driver_path"));

			ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			driver = new FirefoxDriver(profile);
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, bundle.getString("chrome_driver_path"));
			DesiredCapabilities capabilities = getDesiredCapabilities();
	
			driver = new ChromeDriver(capabilities);
		}
		
		if (driver != null) {
            //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
		ce = new clientElement(driver, test);
		ce1 = new clientElement1(driver, test);
	

		google = new inviteContactFullMemberImportedContact(driver, test);
		fe = new inviteContactFullMemberEmptyState(driver, test);
		ge = new inviteContactGuestMember(driver, test);
	
	}
	
	private void getLatestFlockApp() {
        driver.get(DefaultStrings.LATEST_FLOCK_LINK);
       List<WebElement> tbody = driver.findElements(By.cssSelector("body > table > tbody >tr"));
       for (WebElement tr : tbody) {
            if (tr.getText().contains("fl_hydra_web")) {
                WebElement link = tr.findElement(By.cssSelector("td:nth-child(2) > a"));
                String linkText = link.getAttribute("href");
                String stagingLinkText = linkText+"?s=qa&config=preprod"+DefaultStrings.DESKTOP_TESTER_001_MagicLink;
                driver.get(stagingLinkText);
                log.info("Opening the lastest webclient");
                break;
            }
        }
	}
	
	 @BeforeClass
	 public void beforeClass() throws Exception{
		 onboard.enterPassword();
		 Thread.sleep(7000);
		 gm.click(By.xpath("//div[contains(@class,'app-item--recent')]"), 1);
		 //onboard.skipFeatureTour();
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
		 signOut.clearUserAccount();
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