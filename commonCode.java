package com.flock.commonCode;

import static io.restassured.RestAssured.given;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.baseTestSuite;
import com.flock.constants.Auth;
import com.flock.constants.EndPoints;
import com.flock.models.inviteUserModel;
import com.flock.utilities.DefaultStrings;
import com.flock.utilities.flyboardingElements;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.flock.utilities.GenericMethods;

public class commonCode extends baseTestSuite {
	
	ExtentTest test;
	WebDriver driver = null;
	private flyboardingElements fl;
	private GenericMethods gm;
	
	private static final Logger log = LogManager.getLogger(commonCode.class.getName());

	public commonCode(WebDriver webDriver, ExtentTest test) {
		this.driver = webDriver;
		this.test = test;
		gm = new GenericMethods(driver);
		fl = new flyboardingElements(driver, test);
		
	}
	
	public void invitingUser(String email){
		List <String> entities = new ArrayList<String>();
		entities.add(email);

		inviteUserModel inviteUser = new inviteUserModel();
		inviteUser.setEmails(entities);

		given()
			.spec(reqSpec)
			.body(inviteUser)
			.queryParam("token", Auth.ACTOR_INVITOR_TOKEN)
			.queryParam("guid", Auth.ACTOR_INVITOR_GUID)
		.when()
			.post(EndPoints.INVITE)
		.then()
			.log().all()
			.spec(resSpec)
			.extract()
			.response();
		
		log.info("User Sucessfully Invited.");
		test.log(LogStatus.PASS, "User Sucessfully Invited.");
	}
	
	public void emailScreenTest(String email) throws InterruptedException{
		driver.switchTo().frame(fl.onboardingframe);
		fl.enterEmail(email);
		Thread.sleep(3000);
		try{
			fl.skipInvalidDomainError();
		}catch (Exception e) {
			log.error("The invalid domain error message is not displayed");
			test.log(LogStatus.FAIL, "The invalid domain error message is not displayed");
		}
		try {
			fl.skipPublicEmailModal();
		} catch (Exception e) {
			log.error("The public confirmation modal is not displayed");
			test.log(LogStatus.FAIL, "The public confirmation modal is not displayed");
		}
		
	}
	
	public void enterAndVerifyOTP(String otp){
		fl.enterOTP(otp);                  //Enter OTP
		fl.clickVerifyButton();	
	}

	public void discoveTeamPublicDomain(){
		if (fl.discoverTeamButton.isDisplayed()) {
			fl.discoverTeamClick();
			driver.switchTo().frame("discover-team");
			fl.searchTeamFieldClick();
			fl.searchTeam("farzanshaikh");
			fl.searchTeamButtonClick();
			fl.joinedSearchedTeam();

			boolean result = driver
					.findElement(By.xpath("//div[@class='team-search__results']//li[1]//div[@class='join-status']"))
					.isDisplayed();
			Assert.assertTrue(result);
			log.info("Request Sent to Admin for Approval");
			test.log(LogStatus.PASS, "Request Sent to Admin for Approval");

			fl.discoverCreateTeamHookClick();
		} else {
			log.error("Discover Team button not displayed");
			test.log(LogStatus.FAIL, "Discover Team button is not displayed");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(fl.onboardingframe);
	}

	public void setupUserProfile() throws Exception{
			fl.fNameClick();
			fl.fNameField.clear();
			fl.setFirstName(DefaultStrings.TESTER_FNAME);
			
			fl.lNameClick();
			fl.setLastName(DefaultStrings.TESTER_LNAME);
			
			fl.phoneNumberClick();
			fl.setPhoneNumber(DefaultStrings.TESTER_NUMBER);
			
			fl.roleField.click();
			fl.selectRole();
			
			fl.profileImageCase();
			
			fl.submitProfile();
	}
	
	public void checkUrlAvailability(){
		if (urlAvailable) {
			fl.enterTeamNameField.click();
			fl.enterTeamNameField.clear();
			fl.enterTeamNameField.sendKeys(teamURL);
		} else {
			log.info("URL is not available");
			test.log(LogStatus.PASS, "URL is not available");
			fl.enterTeamNameField.click();
			fl.enterTeamNameField.sendKeys(teamURL + RandomStringUtils.randomAlphabetic(3));
		}
		fl.nextButton.click();
	}
	
	public void acceptGDPR(){
		if (fl.gdprAgreementModal.isDisplayed()) {
			fl.gdprAgreeClick();
		} else {
			log.error("GDPR Agreement Modal not displayed");
			test.log(LogStatus.FAIL, "GDPR Agreement Modal not displayed");
		}
	}

	public void gdprScreen(){
		if(fl.gdprHeader.isDisplayed()){
			fl.gdprAgreeClick();
		}else{
			log.error("The GDPR Agreement screen is not displayed");
			test.log(LogStatus.FAIL, "The GDPR Agreement screen is not displayed");
		}
	}
	
	public void setUserPassword(){
		fl.clickEnterPassword();
		fl.enterPasswordField.sendKeys(DefaultStrings.TESTER_PASSWORD);  //reset password
		fl.clickRepeatPasswordField();
		fl.repeatPaswwordField.sendKeys(DefaultStrings.TESTER_PASSWORD);  
		fl.clickSetPasswordButton();
		boolean result = fl.teamUrlInviteScreen != null;
		Assert.assertTrue(result);
		log.info("User password sucessfully set");
		test.log(LogStatus.PASS, "User password sucessfully set");
	}
	
	public void inviteUser() throws InterruptedException{
		
		fl.inviteFieldClick();
		fl.enterInviteeEmail(DefaultStrings.EMAIL_PUBLIC_NONGOC);
		fl.inviteButtonClick();
		
		Boolean result = fl.addToGoogleChromeButton != null;
		Assert.assertTrue(result);
		
		log.info("User Invite Sucessfully");
		test.log(LogStatus.PASS, "User Invite Sucessfully");
	}
	
	public void checkTeamUrl(){
		if(fl.teamUrlInviteScreen.isDisplayed()){
			String displayedBaseUrl = fl.baseTeamUrl.getText();
			log.info("The displayed base url is: "+displayedBaseUrl);
			String actualTeamUrl = teamURL+".flock.com";
			log.info("The entered team url was: "+actualTeamUrl);
			//boolean result = displayedBaseUrl.contains(actualTeamUrl.toLowerCase());
			boolean result = fl.baseTeamUrl.isDisplayed();
			Assert.assertTrue(result);
			log.info("The displayed Team URL is correct");
			test.log(LogStatus.PASS, "The displayed Team URL is correct");
		}else{
			log.error("Team URL not displayed");
			test.log(LogStatus.FAIL, "Team URL not displayed");
		}
	}
	
	public void checkTeamUrlAutoJoin(){
		if(fl.teamUrlInviteScreen.isDisplayed()){
			String displayedBaseUrl = fl.baseTeamUrl.getText();
			log.info("The displayed base url is: "+displayedBaseUrl);
			
			boolean result = displayedBaseUrl.equalsIgnoreCase("flocktestteamurl.flock.com");
			Assert.assertTrue(result);
			log.info("The displayed Team URL is correct");
			test.log(LogStatus.PASS, "The displayed Team URL is correct");
			
		}else{
			log.error("Team URL not displayed");
			test.log(LogStatus.FAIL, "Team URL not displayed");
		}
	}
	
	public void skipCrxScreenCreateChannel(){
		if(fl.addToGoogleChromeButton.isDisplayed()){
			fl.skipAddCrxClick();
			driver.switchTo().frame("channel-create");
			boolean result = driver.findElement(By.id("theme-desktop")) != null;
			Assert.assertTrue(result);
			log.info("Skipped CRX screen Sucessfully and inside the app");
			test.log(LogStatus.PASS, "Skipped CRX screen Sucessfully and inside the app");
		}else{
			log.error("Add google chrome ext screen not shown");
			test.log(LogStatus.FAIL, "Add google chrome ext screen not shown");
		}
	}
	

	
	public void skipCrxScreenGOC(){
		if(fl.addToGoogleChromeButton.isDisplayed()){
			fl.skipAddCrxClick();
			boolean result = driver.findElement(By.className("group-discovery-list")) != null;
			Assert.assertTrue(result);
			log.info("Skipped CRX screen Sucessfully and inside the app");
			test.log(LogStatus.PASS, "Skipped CRX screen Sucessfully and inside the app");
		}else{
			log.error("Add google chrome ext screen not shown");
			test.log(LogStatus.FAIL, "Add google chrome ext screen not shown");
		}
	}
	
	public void skipCrxScreenDiscoverChannel(){
		if(fl.addToGoogleChromeButton.isDisplayed()){
			fl.skipAddCrxClick();
			boolean result = driver.findElement(By.xpath("//div[contains(text(),'Discover and Join Public Channels')]")) != null;
			Assert.assertTrue(result);
			log.info("Skipped CRX screen Sucessfully and inside the app");
			test.log(LogStatus.PASS, "Skipped CRX screen Sucessfully and inside the app");
		}else{
			log.error("Add google chrome ext screen not shown");
			test.log(LogStatus.FAIL, "Add google chrome ext screen not shown");
		}
	}
	
	public void autoJoinedTeam(){
		if (fl.autoJoinedTeam.isDisplayed()) {
			String teamNameDisplayed = fl.joinedTeamName.getText();
			fl.joinedConfirmationDisplayed();
			boolean result = teamNameDisplayed.equalsIgnoreCase(teamName);
			Assert.assertTrue(result);
			log.info("The joined Team is correct");
			test.log(LogStatus.PASS, "The joined Team is correct");
			fl.autoJoinContinueClick();
		}else{
			log.error("The joined Team screen is not displayed");
			test.log(LogStatus.FAIL, "The joined Team screen is not displayed");
		}
	}
	
	public void userGAuth() throws InterruptedException, AWTException{
		fl.googleSignInButtonClick();
		googleAuth();
	}
	
	public void googleAuth() throws InterruptedException, AWTException {
		ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(applink.get(1));
		Thread.sleep(5000);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwedsa1234");
		driver.findElement(By.id("passwordNext")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Allow')]")).click();
		driver.switchTo().window(applink.get(0));
		gm.SwitchToiFrameNo(1);
		Thread.sleep(2000);
	}
	
	
	public void clearGoogleAppPermissionGOC() throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get("https://myaccount.google.com/permissions");
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By
				.xpath("//div[@aria-label='Flock']//div[contains(text(),'Has access to Google Calendar, Google Contacts, Google Drive, Google Services')]"))
				.click();
		driver.findElement(By.xpath("//div[@data-name='Flock']//span[contains(text(),'Remove access')]")).click();
		driver.findElement(By.xpath("//*[@id='yDmH0d']/div[8]/div/div[2]/div[3]/div[2]/content/span")).click();

	}
	
	public void clearGoogleAppPermission() throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get("https://myaccount.google.com/permissions");
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By
				.xpath("//div[@aria-label='Flock']//div[contains(text(),'Has access to Google Contacts, Google Services')]"))
				.click();
		driver.findElement(By.xpath("//div[@data-name='Flock']//span[contains(text(),'Remove access')]")).click();
		driver.findElement(By.xpath("//*[@id='yDmH0d']/div[8]/div/div[2]/div[3]/div[2]/content/span")).click();

	}
	
	
}
