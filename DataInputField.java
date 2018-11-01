package com.signIn;

import org.testng.annotations.DataProvider;

public class DataInputField {
	@DataProvider(name="emails")
	public static Object[][] emailInputs(){
		return new Object[][]{{""},{"jffhfhfh"},{"jffhfhfh@jdjdjjdj"}};
	}
	
	@DataProvider(name="otp")
	public static Object[][]otpInputs(){
		return new Object[][]{{""},{"jffhfh"},{"1q2q3q"}};
	}

}
