package com.flock.flyboardingAutomation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.base.baseTestSuite;
import com.flock.constants.Auth;
import com.flock.constants.EndPoints;
import com.flock.models.deleteUserModel;
import com.flock.utilities.DefaultStrings;

public class deleteUser extends baseTestSuite {
	
	private static final Logger log = LogManager.getLogger(deleteUser.class.getName());
	String otp = "" ;	
	
	@Test
  public void deleteProfile() throws Exception { 
		//fl.deleteUser(DefaultStrings.FARZAN_TEST);
		ArrayList <String> entities = new ArrayList<String>();
		entities.add(DefaultStrings.EMAIl_PAID_AUTOJOIN_GOC);
		
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
}
