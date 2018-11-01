package com.flock.flyboardingAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.base.baseTestSuite;
import com.flock.constants.Auth;
import com.flock.constants.EndPoints;
import com.flock.utilities.DefaultStrings;

import io.restassured.response.Response;

public class resetPassword extends baseTestSuite {
	
	private static final Logger log = LogManager.getLogger(resetPassword.class.getName());
	private String otp = "";

	
	@Test
  public void signInUsingOTP() throws Exception { 
	
		driver.switchTo().frame(fl.onboardingframe);
		fl.enterEmail(DefaultStrings.DESKTOP_TESTER_002_Email);
		Thread.sleep(1000);
		fl.clickForgotPassword();
		Thread.sleep(5000);
		Response res =                       //Fetch OTP
				given()
					.spec(reqSpec)
					.param("actor", Auth.ACTOR_OTP)
					.param("email", DefaultStrings.DESKTOP_TESTER_002_Email)
				.when()
					.get(EndPoints.FETCH_OTP)
				.then()
					.spec(resSpec)
					.body("otps.used",hasItem(false))
					.extract().response();
		otp = res.path("otps[-1].code");
		log.info("OTP generated is : " + otp);
		//fl.fetchOTP(DefaultStrings.DESKTOP_TESTER_002_Email);
		Thread.sleep(2000);
		fl.enterOTP(otp);                  //Enter OTP
		fl.clickVerifyButton();	
		fl.clickEnterPassword();
		fl.enterPasswordField.sendKeys(DefaultStrings.TESTER_PASSWORD);  //reset password
		fl.clickRepeatPasswordField();
		fl.repeatPaswwordField.sendKeys(DefaultStrings.TESTER_PASSWORD);  
		fl.clickResetPasswordButton();
		driver.switchTo().defaultContent();
  }
}
