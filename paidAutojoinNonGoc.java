package com.flock.flyboardingAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import java.awt.AWTException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.baseTestSuite;
import com.flock.constants.Auth;
import com.flock.constants.EndPoints;
import com.flock.models.deleteUserModel;
import com.flock.models.signupModel;
import com.flock.utilities.DefaultStrings;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;

public class paidAutojoinNonGoc extends baseTestSuite {
	
	private static final Logger log = LogManager.getLogger(paidCanjoinNonGoc.class.getName());
	
	private String emailUsed = DefaultStrings.EMAIL_PAID_AUTOJOIN;
 
	
	@Test(priority = 1) // fetch the signUp response
	public void signUpResponse() {
		signupModel email = new signupModel();
		email.setEmail(emailUsed);
		Response res = // signUp Response
				given().spec(reqSpec).body(email).when().post(EndPoints.SIGNUP).then().log().all().spec(resSpec)
						.body("isPasswordSet", equalTo(false)).extract().response();

		isPasswordSet = res.path("isPasswordSet"); // check status of password
													// is set
		log.info("Is the user password set: " + isPasswordSet);

		isFreeDomain = res.path("isFreeDomain"); // check status of domain type
		log.info("Is the email from free domain: " + isFreeDomain);

		isGoogleAppDomain = res.path("isGoogleAppDomain"); // check status of
															// gApp domain
		log.info("Is it a google apps domain: " + isGoogleAppDomain);

		if (isGoogleAppDomain == true) {
			googleAuthCompulsory = res.path("googleAuthInfo.googleAuthCompulsory");
			log.info("Is google auth compulsary: " + googleAuthCompulsory);
		}

		boolean result = isPasswordSet == false;
		Assert.assertTrue(result);
		log.info("signUpResponse Passed");
		test.log(LogStatus.PASS, "signUpResponse Passed");
	}
	
	@Test(priority=2, dependsOnMethods="signUpResponse") //Enter email + skip public domain screen
	public void enterEmailScreen() throws Exception{
		cc.emailScreenTest(emailUsed);
		boolean result = fl.googleSignInButton.isDisplayed();
		Assert.assertTrue(result);
		log.info("enterEmailScreen Passed");
		test.log(LogStatus.PASS, "enterEmailScreen Passed");
	}
	
	@Test(priority=3, dependsOnMethods="enterEmailScreen") //Fetch + Enter OTP
	public void enterOtpScreen() throws InterruptedException{
		fl.verifyYourEmailClick();
		Response res =                       //Fetch OTP
				given()
					.spec(reqSpec)
					.param("actor", Auth.ACTOR_OTP)
					.param("email", emailUsed)
				.when()
					.get(EndPoints.FETCH_OTP)
				.then()
					.spec(resSpec)
					.body("otps.used",hasItem(false))
					.extract().response();
		otp = res.path("otps[-1].code");
		log.info("OTP generated is : " + otp);
		Thread.sleep(2000);
		
		cc.enterAndVerifyOTP(otp);
		
		boolean result = fl.autoJoinPageHeading.isDisplayed() == true;
		Assert.assertTrue(result);
		log.info("enterOtpScreen Passed");
		test.log(LogStatus.PASS, "enterOtpScreen Passed");
	}
	
	@Test(priority=4, dependsOnMethods="enterOtpScreen") //Get authentication response
	public void getAuthResponse(){
		Response res =                       //Fetch OTP
				given()
					.spec(reqSpec)
					.param("token", Auth.ACTOR_AUTHENTICATE)
					.param("email", emailUsed)
				.when()
					.get(EndPoints.USER_AUTH_RESPONSE)
				.then()
					.spec(resSpec)
					.body("isFirstAuth",equalTo(true))
					.extract().response();
		showPasswordScreen = res.path("showPasswordScreen"); //check status to show password screen
		log.info("Show the user password screen : "+showPasswordScreen);
		
		showProfileScreen = res.path("showProfileScreen");//check status to show profile screen
		log.info("Show the user profile screen : "+showProfileScreen);
		
		showInviteScreen = res.path("showInviteScreen");//check status to show invite screen
		log.info("Show the user Invite screen : "+showInviteScreen);
		
		userToken = res.path("token.token"); //Fetch the user token
		log.info("The user token is : "+userToken);
		
		teamName = res.path("teams[0].teamName"); //Fetch the team name
		log.info("The user is a part of: "+teamName);
		
		teamUrl = res.path("teamUrl"); //Fetch team Url
		log.info("The team url is: "+teamURL);
	}
	
	@Test(priority=5, dependsOnMethods="getAuthResponse") //Join can-join team
	public void autoJoinTeams() throws Exception{
		if (fl.autoJoinedTeam.isDisplayed()) {
			String teamNameDisplayed = fl.joinedTeamName.getText();
			fl.joinedConfirmationDisplayed();
			boolean result = teamNameDisplayed.equalsIgnoreCase(teamName);
			Assert.assertTrue(result);
			log.info("The joined Team is correct");
			test.log(LogStatus.PASS, "The joined Team is correct");
			fl.autoJoinContinueClick();
			boolean result1 = fl.gdprHeadingDisplayed();
			Assert.assertTrue(result1);
			log.info("Join Team Passed");
			test.log(LogStatus.PASS, "Join Team Passed");
		}else{
			log.error("The joined Team screen is not displayed");
			test.log(LogStatus.FAIL, "The joined Team screen is not displayed");
		}
	}
	
	
	@Test(priority=6, dependsOnMethods="autoJoinTeams")
	public void gdprScreen(){
		cc.gdprScreen();
	}
	
	@Test(priority=7, dependsOnMethods="gdprScreen") //Set user profile
	public void setUserProfile() throws Exception{
		if(showProfileScreen == true) {
			cc.setupUserProfile(); 
			
			Thread.sleep(2000);
			boolean result = fl.enterPasswordField != null;
			Assert.assertTrue(result);
			log.info("setUserProfile Passed");
			test.log(LogStatus.PASS, "setUserProfile Passed");
			}else{
				log.error("Profile screen not to be shown. Maybe profile is already set");
				test.log(LogStatus.PASS, "Profile screen not to be shown. Maybe profile is already set");
			}
	}
	
	@Test(priority=8, dependsOnMethods = "setUserProfile") //Validate if the user profile set is true
	public void verifyProfileDetails(){
		Response res =                       //Fetch OTP
				given()
					.spec(reqSpec)
					.param("token", Auth.ACTOR_AUTHENTICATE)
					.param("email", emailUsed)
				.when()
					.get(EndPoints.USER_AUTH_RESPONSE)
				.then()
					.log().all()
					.spec(resSpec)
					.body("isFirstAuth",equalTo(true))
					.extract().response();
		String userGuid1 = res.path("teams.guid").toString(); //extract user guid
		userGuid = userGuid1.substring(1, userGuid1.length()-1);
		log.info("The user guid is: "+ userGuid);
		
		String enteredFName1 = res.path("teams.name.firstName").toString();
		enteredFName = enteredFName1.substring(1,enteredFName1.length()-1);
		log.info("The users enterd first name is: "+enteredFName);
		log.info("The actual first name is: " + DefaultStrings.EMAIL_LHS );
		boolean result1 = enteredFName.equals(DefaultStrings.TESTER_FNAME);
		Assert.assertTrue(result1);
		log.info("Entered fName is correct. Passed");
		test.log(LogStatus.PASS, "Entered fName is correct. Passed");
		
		String enteredLName1 = res.path("teams.name.lastName").toString();
		enteredLName = enteredLName1.substring(1,enteredLName1.length()-1);
		log.info("The users enterd last name is: "+enteredLName);
		boolean result2 = enteredLName.equals(DefaultStrings.TESTER_LNAME);
		Assert.assertTrue(result2);
		log.info("Entered lName is correct. Passed");
		test.log(LogStatus.PASS, "Entered lName is correct. Passed");
	}
	
	@Test(priority=9, dependsOnMethods="verifyProfileDetails") //set user password
	public void setPassword() throws InterruptedException{
		if(showPasswordScreen==true){
		cc.setUserPassword();;
		}else{
			log.error("Password screen not to be shown. Maybe password is already set");
			test.log(LogStatus.FAIL, "Password screen not to be shown. Maybe password is already set");
		}
	}
	
	@Test(priority=10, dependsOnMethods="setPassword")//invite User 
	public void inviteUserScreen() throws Exception{
		if(showInviteScreen == true){
			Thread.sleep(5000);
			if(fl.teamUrlInviteScreen.isDisplayed()){
				String displayedBaseUrl = fl.baseTeamUrl.getText();
				log.info("The displayed base url is: "+displayedBaseUrl);
				
				boolean result = displayedBaseUrl.equalsIgnoreCase("flockv22.flock.com");
				Assert.assertTrue(result);
				log.info("The displayed Team URL is correct");
				test.log(LogStatus.PASS, "The displayed Team URL is correct");
				
			}else{
				log.error("Team URL not displayed");
				test.log(LogStatus.FAIL, "Team URL not displayed");
			}
			cc.inviteUser();
		}else{
			log.error("Invite Screen is set to false");
			test.log(LogStatus.FAIL, "Invite Screen is set to false");
		}
	}

	
	@Test(priority=11, dependsOnMethods="inviteUserScreen")
	public void addFlockCrx(){
		cc.skipCrxScreenCreateChannel();
	}
	
	@Test(priority=12)
	public void deleteProfile() throws Exception{ //Delete User completely 
		ArrayList <String> entities = new ArrayList<String>();
		entities.add(emailUsed);
		
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
		driver.navigate().refresh();
		
		log.info("User Sucessfully Delete. Test Suite: Passed");
		test.log(LogStatus.PASS, "User Sucessfully Delete. Test Suite: Passed");
  }
	
}
