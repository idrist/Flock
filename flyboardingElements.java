package com.flock.utilities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

import com.base.baseTestSuite;
import com.flock.constants.Auth;
import com.flock.constants.EndPoints;
import com.flock.models.deleteUserModel;

public class flyboardingElements extends baseTestSuite{

	ExtentTest test;
	WebDriver driver;
	WebElement element = null;
	public String otp="";

	private static final Logger log = LogManager.getLogger(flyboardingElements.class.getName());

	public flyboardingElements(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='onboarding']/iframe") // Iframe under onboarding 
	public WebElement onboardingframe;
	
	@FindBy(xpath = "//h2[contains(text(),'Teams you can join')]")  
	public WebElement canJoinPageHeading;
	
	@FindBy(xpath = "//h2[contains(text(),'found your teams')]")  
	public WebElement autoJoinPageHeading;

	@FindBy(xpath = "//a[contains(text(),'Forgot password')]")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Enter your work emai')]")
	public WebElement enterEmailField;
	
	@FindBy(xpath = "//div[contains(@class,'canJoin')]//button[contains(text(),'Join')]")
	public WebElement joinButton;
	
	@FindBy(xpath = "//div[contains(@class,'join-team')]//button[contains(text(),'Joined')]")
	public WebElement joinedTick;
	
	@FindBy(xpath = "//button[contains(text(),'Login or Create a Team')]")
	public WebElement loginButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter verification PIN']")
	public WebElement enterOTPField;
	
	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	public WebElement verifyButton;
	
	@FindBy(xpath = "//a[contains(text(),'Verify your email')]")
	public WebElement verifyYourEmailButton;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter password')]")
	public WebElement enterPasswordField;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Repeat your password')]")
	public WebElement repeatPaswwordField;
	
	@FindBy(xpath = "//button[contains(text(),'Reset password')]")
	public WebElement resetPasswordButton;
	
	@FindBy(className="modal-box")
	public WebElement publicEMailConfirmModal;
	
	@FindBy(xpath="//a[@class='skip-button']")
	public WebElement skipPublicModal;
	
	@FindBy(xpath="//input[@placeholder='Team Name']")
	public WebElement enterTeamNameField;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	public WebElement nextButton;
	
	@FindBy(xpath="//div[@id='widgets_GDPRAgreement_0']/div[@class='modal-box']")
	public WebElement gdprAgreementModal;
	
	@FindBy(xpath="//button[contains(text(),'I Agree')]")
	public WebElement gdprAgreeButton;
	
	@FindBy(xpath="//div[@class='profile-image-wrap']")
	public WebElement updateProfilePic;
	
	@FindBy(xpath="//label[contains(text(),'Your first name')]")
	public WebElement fnameHeading;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	public WebElement fNameField;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	public WebElement lNameField;
	
	@FindBy(xpath="//input[@placeholder='Type a number']")
	public WebElement phoneNumberField;
	
	@FindBy(xpath="//table[contains(@class,'team-purpose')]")
	public WebElement roleField;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	public WebElement profileNextButton;
	
	@FindBy(xpath="//button[contains(text(),'Set password')]")
	public WebElement setPasswordButton;
	
	@FindBy (xpath="//div[@class='contacts-team-url-multicolor-container']")
	public WebElement teamUrlInviteScreen;
	
	@FindBy(xpath="//div[@class='contacts-team-url-multicolor user-selectable']//span[@class='contacts-team-url-base']")
	public WebElement baseTeamUrl;
	
	@FindBy(xpath="//span[@class='contacts-team-url-query']")
	public WebElement teamUrlQuery;
	
	@FindBy(xpath="//div[@id='widgets_InputBox_4']/input")
	public WebElement gocInviteFieldList;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")
	public WebElement inviteUserButton;
	
	@FindBy(xpath="//button[contains(text(),'Add to Google Chrome')]")
	public WebElement addToGoogleChromeButton;
	
	@FindBy(xpath="//a[@class='skip-button']")
	public WebElement skipAddCrx;
	
	@FindBy(xpath="//div[@class='group-discovery-list']")
	public WebElement discoverChannelModal;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	public WebElement skipButton;
	
	@FindBy(xpath="//input[@type='file']") //Avatar under Edit Profile
	public WebElement userAvatar;
	
	@FindBy(xpath="//span[contains(text(),'Sign in with Google')]")
	public WebElement googleSignInButton;
	
	@FindBy(xpath="//button[contains(text(),'Discover Teams')]")
	public WebElement discoverTeamButton;
	
	@FindBy(xpath="//a[contains(text(),'Looking for an existing team?')]")
	public WebElement canJoinTeamsDiscoverButton;
	
	@FindBy(xpath="//div[@class='team-search']//input")
	public WebElement searchTeamField;
	
	@FindBy(xpath="//div[@class='team-search']//button")
	public WebElement searchTeamButton;
	
	@FindBy(xpath="//div[@class='create-team']//span[@class='create-team__link']")
	public WebElement discoverCreateTeamHook;
	
	@FindBy(className="team-search__results")
	public WebElement teamSearchResults;
	
	@FindBy(xpath="//div[@class='team-search__results']//li[1]//button[contains(text(),'Join')]")
	public WebElement joinSearchedTeamButton;
	
	@FindBy(xpath="//div[@class='memberList']//input")
	public List<WebElement> inviteFields;
	
	@FindBy(xpath="//div[@class='discover-team-list']")
	public WebElement autoJoinedTeam;
	
	@FindBy(xpath="//div[@class='join-team']//button[contains(text(),'Joined')]")
	public WebElement joinedConfirmation;
	
	@FindBy(xpath="//div[@class='team-summary']//div[@class='team-name']")
	public WebElement joinedTeamName;
	
	@FindBy(xpath ="//button[contains(text(),'Continue')]")
	public WebElement autoJoinedContinueButton;
	
	@FindBy(xpath="//h2[contains(text(),'Review the User Terms')]")
	public WebElement gdprHeader;
	
	@FindBy(xpath="//div[contains(text(),'Looks like an invalid email address.')]")
	public WebElement invalidDomain;
	
	@FindBy(xpath="//h2[contains(text(),'Review the User Terms')]")
	public WebElement gdprHeading;
	
	public void skipInvalidDomainError(){
		if(invalidDomain.isDisplayed()){
			clickLoginButton();
		}
	}
	
	public void gdprHeaderDisplayed(){
		gdprHeader.isDisplayed();
		log.info("GDPR Header is displayed");
		test.log(LogStatus.INFO, "GDPR Header is displayed");
	}
	

	public void autoJoinContinueClick(){
		autoJoinedContinueButton.click();
		log.info("Clicked on the continue button on auto joined team screen");
		test.log(LogStatus.INFO, "Clicked on the continue button on auto joined team screen");
	}
	
	public void canJoinTeamsDiscoverClick(){
		canJoinTeamsDiscoverButton.click();
		log.info("Clicked on the Looking for an existing team?");
		test.log(LogStatus.INFO, "Clicked on the Looking for an existing team?");
	}
	

	public void joinButtonClick(){
		joinButton.click();
		log.info("Clicked on the Join button on Can-join teams page");
		test.log(LogStatus.INFO, "Clicked on the Join button on Can-join teams page");
	}
	
	public void verifyYourEmailClick(){
		verifyYourEmailButton.click();
		log.info("Clicked on the Verify Your Email Button to skip Gauth");
		test.log(LogStatus.INFO, "Clicked on the Verify Your Email Button to skip Gauth");
	}
	
	public void fetchJoinedTeamName(){
		String teamNameDisplayed = joinedTeamName.getText();
		log.info("The joined team Name is: "+teamNameDisplayed);
		test.log(LogStatus.INFO, "The joined confirmation tick is displayed");
	}
	
	public void joinedConfirmationDisplayed(){
		joinedConfirmation.isDisplayed();
		log.info("The joined confirmation tick is displayed");
		test.log(LogStatus.INFO, "The joined confirmation tick is displayed");
	}
	
	public void joinedSearchedTeam(){
		joinSearchedTeamButton.click();
		log.info("Clicked on the join button on discove team screen");
		test.log(LogStatus.INFO, "Clicked on the join button on discove team screen");
	}
	
	public void discoverCreateTeamHookClick(){
		discoverCreateTeamHook.click();
		log.info("Clicked on the create team button on discove team screen");
		test.log(LogStatus.INFO, "Clicked on the create team button on discove team screen");
	}
	
	public void searchTeamFieldClick(){
		searchTeamField.click();
		log.info("Clicked inside the search team field");
		test.log(LogStatus.INFO, "Clicked inside the search team field");
	}
	
	public void searchTeam(String teamName){
		searchTeamField.sendKeys(teamName);
		log.info("Entered team name inside the search team field");
		test.log(LogStatus.INFO, "Entered team name inside the search team field");
	}
	
	public void searchTeamButtonClick(){
		searchTeamButton.click();
		log.info("Clicked on the search team button");
		test.log(LogStatus.INFO, "Clicked on the search team button");
	}
	
	public void discoverTeamClick(){
		discoverTeamButton.click();
		log.info("Clicked on the discover team button");
		test.log(LogStatus.INFO, "Clicked on the discover team button");
	}
	
	public void googleSignInButtonClick(){
		googleSignInButton.click();
		log.info("Clicked on the google sign in button");
		test.log(LogStatus.INFO, "Clicked on the google sign in button");
	}
	
	public void profileImageCase() throws Exception {
    	SoftAssert sa = new SoftAssert();
    	try{
    	Thread.sleep(2000);
    	fl.userAvatar.sendKeys("C:\\Automation\\horus.jpg");
    	}catch(Exception e){
    		test.log(LogStatus.FAIL, "Avatar not set");
    		log.error("Avatar not set");
			sa.assertAll();

    	}
    }    
	
	public void skipAddCrxClick(){//Clicked the skip flock crx
		skipAddCrx.click();
		log.info("Clicked on the Skip Button on add google crx screen");
		test.log(LogStatus.INFO, "Clicked on the Skip Button on add google crx screen");
	}
	
	public void inviteButtonClick(){//Clicked the Invite Button
		inviteUserButton.click();
		log.info("Clicked on the Invite Button");
		test.log(LogStatus.INFO, "Clicked on the Invite Button");
	}
	public void gocInviteFieldClick(){//Clicked the Invite Field
		gocInviteFieldList.click();
		//inviteField.click();
		log.info("Clicked inside the Invite Field");
		test.log(LogStatus.INFO, "Clicked inside the Invite Field");
	}
	
	public void gocEnterInviteeEmail(String email){
		gocInviteFieldList.sendKeys(email);
		log.info("Entered the invitee email");
		test.log(LogStatus.INFO, "Entered the invitee email");
	}
	
	public void inviteFieldClick(){//Clicked the Invite Field
		int size = inviteFields.size();
		inviteFields.get(size-2).click();
		log.info("Clicked inside the Invite Field");
		test.log(LogStatus.INFO, "Clicked inside the Invite Field");
	}
	
	public void enterInviteeEmail(String email){
		int size = inviteFields.size();
		inviteFields.get(size-2).sendKeys(email);
		log.info("Entered the invitee email");
		test.log(LogStatus.INFO, "Entered the invitee email");
	}
	
	public void selectRole(){
		int index = 1;
		WebElement baseTable = driver.findElement(By.xpath("//div[contains(@class,'dijitMenuPopup')]"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		tableRows.get(index).click();
		log.info("User role selected");
		test.log(LogStatus.INFO, "User role selected");
	}
	
	public void submitProfile(){
		profileNextButton.click();
		log.info("Clicked the update profile next button");
		test.log(LogStatus.INFO, "Clicked the update profile next button");
	}
	
	public void fNameClick(){//Clicked the fName Field
		fNameField.click();
		log.info("Clicked inside the fName Field");
		test.log(LogStatus.INFO, "Clicked inside the fName Field");
	}
	
	public void setFirstName(String fName){
		fNameField.sendKeys(fName);
		log.info("First Name Set");
		test.log(LogStatus.INFO, "First Name Set");
	}
	
	public void lNameClick(){//Clicked the lName Field
		lNameField.click();
		log.info("Clicked inside the lName Field");
		test.log(LogStatus.INFO, "Clicked inside the lName Field");
	}
	
	public void setLastName(String lName){
		lNameField.sendKeys(lName);
		log.info("Last Name Set");
		test.log(LogStatus.INFO, "Last Name Set");
	}
	
	public void phoneNumberClick(){//Clicked the lName Field
		phoneNumberField.click();
		log.info("Clicked inside the phone number Field");
		test.log(LogStatus.INFO, "Clicked inside the phone number Field");
	}
	
	public void setPhoneNumber(String number){
		phoneNumberField.sendKeys(number);
		log.info("Phone Number Set");
		test.log(LogStatus.INFO, "Phone Number Set");
	}
	
	public void gdprAgreeClick(){//Clicked the gdpr Agree button
		gdprAgreeButton.click();
		log.info("Clicked on agree hook in the GDPR Ageement Modal");
		test.log(LogStatus.INFO, "Clicked on agree hook in the GDPR Ageement Modal");
	}
	
	
	public void skipPublicEmailModal(){ //clicked on Skip public email confirmation
		skipPublicModal.click();
		log.info("Clicked on skip hook in the public modal confirmation");
		test.log(LogStatus.INFO, "Clicked on skip hook in the public modal confirmation");
	}
	
	public void clickEnterPassword() { // Clicked on the Enter Password Field

		enterPasswordField.click();
		log.info("Clicked on the Enter Password Field");
		test.log(LogStatus.INFO, "Clicked on the Enter Password Field");
	}
	
	public void clickRepeatPasswordField() { // Clicked on the repeat password field

		repeatPaswwordField.click();
		log.info("Clicked on the repeat password field");
		test.log(LogStatus.INFO, "Clicked on the repeat password field");
	}
	
	public void clickResetPasswordButton() { // Clicked on the reset password button

		resetPasswordButton.click();
		log.info("Clicked on the reset password button");
		test.log(LogStatus.INFO, "Clicked on the reset password button");
	}
	
	public void clickSetPasswordButton() { // Clicked on the reset password button

		setPasswordButton.click();
		log.info("Clicked on the reset password button");
		test.log(LogStatus.INFO, "Clicked on the reset password button");
	}
	
	public void clickVerifyButton() { // Click on Verify Button

		verifyButton.click();
		log.info("Clicked on the Verify Button");
		test.log(LogStatus.INFO, "Clicked on the Verify Button");
	}
	
	
	public void clickEnterOTPField() { // Click on Enter OTP Field

		enterOTPField.click();
		log.info("Clicked on the Enter Otp Field");
		test.log(LogStatus.INFO, "Clicked on the Enter Otp Field");
	}
	
	
	public void clickLoginButton() { // Click on Forgot Password

		loginButton.click();
		log.info("Clicked on the Login Button");
		test.log(LogStatus.INFO, "Clicked on the Login Button");
	}
	
	public void clickEnterEmailField() { // Click on Forgot Password

		enterEmailField.click();
		log.info("Clicked on the enter email field");
		test.log(LogStatus.INFO, "Clicked on the enter email field");
	}

	public void clickForgotPassword() { // Click on Forgot Password

		forgotPassword.click();
		log.info("Clicked on the Forgot Password");
		test.log(LogStatus.INFO, "Clicked on the Forgot Password");
	}
	
	public void fetchOTP(String userEmail){
		Response res = 
				given()
					.spec(reqSpec)
					.param("actor", Auth.ACTOR_OTP)
					.param("email", userEmail)
				.when()
					.get(EndPoints.FETCH_OTP)
				.then()
					.spec(resSpec)
					.body("otps.used",hasItem(false))
					.extract().response();
		
		otp = res.path("otps[0].code");
		log.info("OTP generated is : " + otp);
	}
	
	public void enterOTP(String otps){
		clickEnterOTPField();
		enterOTPField.sendKeys(otps);
	}
	
	
	public void enterEmail(String userEmail){
		clickEnterEmailField();
		enterEmailField.sendKeys(userEmail);
		clickLoginButton();
	}
	
	 public void deleteUser(String userEmail) throws Exception { 
			ArrayList <String> entities = new ArrayList<String>();
			entities.add(userEmail);
			
			deleteUserModel deleteUser = new deleteUserModel();
			deleteUser.setActor(Auth.ACTOR_DELETE);
			deleteUser.setEntities(entities);

					given()
						.spec(reqSpec)
						.body(deleteUser)
					.when()
						.post(EndPoints.DELETE_USERS)
					.then()
						.spec(resSpec)
						.extract().response();
			log.info("User Deleted");
	}
	
		public boolean discoverChannelModalDisplayed(){            // Discover Channel Modal displayed
			try{if(discoverChannelModal.isDisplayed()){
				test.log(LogStatus.PASS, "Discover Channel Modal is displayed");
				return true;
			}
			}catch(Exception e){
				test.log(LogStatus.FAIL, "Discover Channel Modal is not displayed");
			}
			return false;
		}
		
		public boolean joinedTickDisplayed(){            
			try{if(joinedTick.isDisplayed()){
				test.log(LogStatus.PASS, "Team joined succesfully");
				return true;
			}
			}catch(Exception e){
				test.log(LogStatus.FAIL, "Can-join Team join button not working");
			}
			return false;
		}
		
		public boolean gdprHeadingDisplayed(){            
			try{if(gdprHeading.isDisplayed()){
				test.log(LogStatus.PASS, "Gdpr heading is displayed");
				return true;
			}
			}catch(Exception e){
				test.log(LogStatus.FAIL, "Gdpr heading is displayed");
			}
			return false;
		}
}
