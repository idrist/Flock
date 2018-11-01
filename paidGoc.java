package com.flock.flyboardingAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

public class paidGoc extends baseTestSuite {
	private static final Logger log = LogManager.getLogger(publicNonGoc.class.getName());

	private String emailUsed = DefaultStrings.EMAIl_PAID_GOC;

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

	@Test(priority = 2, dependsOnMethods = "signUpResponse") // Enter email +
																// skip public
																// domain screen
	public void enterEmailScreen() throws Exception {
		cc.emailScreenTest(emailUsed);
		boolean result = fl.googleSignInButton.isDisplayed();
		Assert.assertTrue(result);
		log.info("enterEmailScreen Passed");
		test.log(LogStatus.PASS, "enterEmailScreen Passed");
	}

	@Test(priority = 3, dependsOnMethods = "enterEmailScreen")
	public void googleAuthScreen() throws InterruptedException, AWTException {
		if (googleAuthCompulsory == false) {
			cc.userGAuth();
			boolean result = fl.enterTeamNameField.isDisplayed() == true;
			Assert.assertTrue(result);
			log.info("googleAuthScreen Passed");
			test.log(LogStatus.PASS, "googleAuthScreen Passed");
		}
	}

	@Test(priority = 4, dependsOnMethods = "googleAuthScreen") // Get
																// authentication
																// response
	public void getAuthResponse() {
		Response res = // Fetch OTP
				given()
					.spec(reqSpec)
					.param("token", Auth.ACTOR_AUTHENTICATE)
					.param("email", emailUsed)
				.when()
					.get(EndPoints.USER_AUTH_RESPONSE)
				.then()
					.spec(resSpec)
					.body("isFirstAuth", equalTo(true))
					.extract().response();
		showPasswordScreen = res.path("showPasswordScreen"); // check status to
																// show password
																// screen
		log.info("Show the user password screen : " + showPasswordScreen);

		showProfileScreen = res.path("showProfileScreen");// check status to
															// show profile
															// screen
		log.info("Show the user profile screen : " + showProfileScreen);

		showInviteScreen = res.path("showInviteScreen");// check status to show
														// invite screen
		log.info("Show the user Invite screen : " + showInviteScreen);

		userToken = res.path("token.token"); // Fetch the user token
		log.info("The user token is : " + userToken);
	}

	@Test(priority = 5, dependsOnMethods = "getAuthResponse") // Validate url +
																// Approve GDPR
																// + Create Team
	public void createTeamScreen() throws InterruptedException {
		cc.discoveTeamPublicDomain(); 
		
		Response res = // Validate Team URL
				given().spec(reqSpec).param("token", userToken).param("url", teamURL).when()
						.get(EndPoints.TEAM_URL_AVAILABILITY).then().spec(resSpec).extract().response();

		urlAvailable = res.path("isAvailable");
		cc.checkUrlAvailability();
		cc.acceptGDPR();
		Thread.sleep(2000);
		boolean result = fl.updateProfilePic != null;
		Assert.assertTrue(result);
		log.info("getURLAvailibilty Passed");
		test.log(LogStatus.PASS, "getURLAvailibilty Passed");
	}

	@Test(priority = 6, dependsOnMethods = "createTeamScreen") // Set user
																// profile
	public void setUserProfile() throws Exception {
		if (fl.showProfileScreen == true) {
			cc.setupUserProfile();
			Thread.sleep(2000);
			boolean result = fl.enterPasswordField.isDisplayed();
			Assert.assertTrue(result);
			log.info("setUserProfile Passed");
			test.log(LogStatus.PASS, "setUserProfile Passed");
		} else {
			log.error("Profile screen not to be shown. Maybe profile is already set");
			test.log(LogStatus.PASS, "Profile screen not to be shown. Maybe profile is already set");
		}
	}

	@Test(priority = 7, dependsOnMethods = "setUserProfile") // Validate if the
																// user profile
																// set is true
	public void fetchUserGuid() {
		Response res = // Fetch OTP
				given().spec(reqSpec).param("token", Auth.ACTOR_AUTHENTICATE).param("email", emailUsed).when()
						.get(EndPoints.USER_AUTH_RESPONSE).then().log().all().spec(resSpec)
						.body("isFirstAuth", equalTo(true)).extract().response();
		String userGuid1 = res.path("teams.guid").toString(); // extract user
																// guid
		userGuid = userGuid1.substring(1, userGuid1.length() - 1);
		log.info("The user guid is: " + userGuid);

		boolean result2 = userGuid != null;
		Assert.assertTrue(result2);
		log.info("fetchUserGuid Passed");
		test.log(LogStatus.PASS, "fetchUserGuid Passed");
	}

	@Test(priority = 8) // invite User
	public void inviteUser() throws Exception {
		if (showInviteScreen == true) {
			Thread.sleep(5000);
			cc.checkTeamUrl();
			cc.inviteUser();

			Boolean result = fl.addToGoogleChromeButton != null;
			Assert.assertTrue(result);

			log.info("User Invite Sucessfully");
			test.log(LogStatus.PASS, "User Invite Sucessfully");

		} else {
			log.error("Invite Screen is set to false");
			test.log(LogStatus.FAIL, "Invite Screen is set to false");
		}
	}

	@Test(priority = 9, dependsOnMethods = "inviteUser")
	public void addFlockCrx() {
		cc.skipCrxScreenCreateChannel();
	}

	@Test(priority = 10)
	public void deleteProfile() throws Exception { // Delete User completely
		ArrayList<String> entities = new ArrayList<String>();
		entities.add(emailUsed);

		deleteUserModel deleteUser = new deleteUserModel();
		deleteUser.setActor(Auth.ACTOR_DELETE);
		deleteUser.setEntities(entities);

		given().spec(reqSpec).body(deleteUser).when().post(EndPoints.DELETE_USERS).then().spec(resSpec).extract()
				.response();
		driver.navigate().refresh();

		cc.clearGoogleAppPermission();

		log.info("User Sucessfully Delete. Test Suite: Passed");
		test.log(LogStatus.PASS, "User Sucessfully Delete. Test Suite: Passed");
	}

}
