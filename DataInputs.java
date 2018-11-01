package com.utilities;

import org.testng.annotations.DataProvider;

public class DataInputs {
	
	
	@DataProvider(name="wrongEmails")
	public static Object[][] emailInputs(){
		return new Object[][]{{"jffhfhfh"},{"jffhfhfh@jdjdjjdj"},{"ehheehh@dhdhhd@hh"},{"blank space@email.com"},{"test@test."}};
	}
	
	@DataProvider(name="correctEmails")
	public static Object[][] emailInput(){
		return new Object[][]{{"test@flock.com"}};
	}
	
	@DataProvider(name="BlockeddContats")
	public static Object[][] blockedInput(){
		return new Object[][]{{"test@directi.com"}};
	}
	
	@DataProvider(name="guestContacts")
	public static Object[][] guestContacts(){
		return new Object[][]{{"test@mailinator.com"}};
	}
}
