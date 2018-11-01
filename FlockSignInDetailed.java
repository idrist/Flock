package com.signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.SignInTestSuite;
import com.utilities.DefaultStrings;

public class FlockSignInDetailed extends SignInTestSuite {
	

	
	public WebDriver getDriver(){
		return driver;
	}
	
	
	
	/*@DataProvider(name="emails")
	public static Object[][] emailInputs(){
		return new Object[][]{{""},{"jffhfhfh"},{"jffhfhfh@jdjdjjdj"}};
	}
	
	@DataProvider(name="otp")
	public static Object[][]otpInputs(){
		return new Object[][]{{""},{"jffhfh"},{"1q2q3q"}};
	}*/

	@Test(priority = 0) //Get title of the page
	public void windowTitle(){
		gm.getTitle();
		
	}
	
	@Test(priority =1)
	public void languageSwitcher(){
		gm.implicitWait(40);
		gm.SwitchToiFrameNo(0);
		gm.elementDisplayed(By.xpath("//td[@class='dijitReset dijitStretch dijitButtonContents dijitButtonNode']"), "Country-DropDown-FlagList");
		gm.elementDisplayed(By.xpath("//td[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton']"), "Country-DropDown-Tick");
		
		/*gm.elementDisplayed(By.xpath("//span[@class='dijitReset dijitInline currentLanguage en-us']"));
		gm.getText(By.xpath("//span[@class='dijitReset dijitInline currentLanguage en-us']"));
		gm.compareText(By.xpath("//span[@class='dijitReset dijitInline currentLanguage en-us']"));
		gm.click(By.xpath("//td[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton']"), 1);
		gm.webelementsText(By.xpath("//td[@data-dojo-attach-point='containerNode']"));
		gm.click(By.xpath("//td[@id='dijit_MenuItem_1_text']"), 1);*/
	}
		
	@Test(priority = 2) //check the heading content
	public void Heading(){
		
		gm.waitForElement(By.xpath("//div[@id='uniqName_15_0']//h2"), 10);
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_15_0']//h2"), "EmailPage-Header");
		gm.getText(By.xpath("//div[@id='uniqName_15_0']//h2"));
		gm.compareText(By.xpath("//div[@id='uniqName_15_0']//h2"), "Get started with Flock");
	}
	
	@Test(priority = 3)//check all elements from the contact support blurb
	public void contactSupport() throws Exception{
		
		gm.elementDisplayed(By.xpath("//span[@class='feedbackLinkSpan']"), "ContactSupport-Footer");
		gm.getText(By.xpath("//span[@class='feedbackLinkSpan']"));
		gm.compareText(By.xpath("//span[@class='feedbackLinkSpan']"), "Contact Support");
		gm.click(By.xpath("//span[@class='feedbackLinkSpan']"), 2);
		
		gm.elementDisplayed(By.xpath("//div[@class='title']"), "ContactSupportModal-Header");
		gm.getText(By.xpath("//div[@class='title']"));
		gm.compareText(By.xpath("//div[@class='title']"), "How can we help you today?");
		
		gm.elementDisplayed(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[1]/label"), "ContactSupportModal-EmailHeader");
		gm.getText(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[1]/label"));
		gm.compareText(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[1]/label"), "Email");
		
		gm.elementDisplayed(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[2]/label"), "ContactSupportModal-NameHeader");
		gm.getText(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[2]/label"));
		gm.compareText(By.xpath("//div[@id='widgets_Dialog_0']//div[2]/div[2]/div[2]/label"), "Name");
		
		gm.elementDisplayed(By.xpath("//input[@placeholder='example@domain.com']"), "ContactSupportModal-EmailField");
		gm.getText(By.xpath("//input[@placeholder='example@domain.com']"));
		gm.compareText(By.xpath("//input[@placeholder='example@domain.com']"), "example@domain.com");
		gm.SendKey(By.xpath("//input[@placeholder='example@domain.com']"), 2, "Test@mailinator.com");
		
		gm.elementDisplayed(By.xpath("//input[@placeholder='Enter your name']"), "ContactSupportModal-NameField");
		gm.getText(By.xpath("//input[@placeholder='Enter your name']"));
		gm.compareText(By.xpath("//input[@placeholder='Enter your name']"), "Enter your name");
		gm.SendKey(By.xpath("//input[@placeholder='Enter your name']"), 2, "Test Automator");
		
		gm.radioButtonIterate(By.xpath("//div[@id='widgets_Dialog_0']//input[@type='radio']"));
		
		gm.elementDisplayed(By.xpath("//textarea[@class='input']"), "ContactSupportModal-DescriptionField");
		gm.getText(By.xpath("//textarea[@class='input']"));
		gm.compareText(By.xpath("//textarea[@class='input']"), "Describe the issue and tell us a bit about your team for us to help better.");
		gm.SendKey(By.xpath("//textarea[@class='input']"), 2, "Test Message in the body");
		
		gm.elementDisplayed(By.xpath("//span[@class='attachFileLogo']"), "ContactSupportModal-LogAttachLogo");
		gm.elementDisplayed(By.xpath("//span[@class='uploadMessage']"), "ContactSupportModal-LogAttachMessage");
		gm.getText(By.xpath("//span[@class='uploadMessage']"));
		gm.compareText(By.xpath("//span[@class='uploadMessage']"), "Log file attached");
		
		gm.clearField(By.xpath("//input[@placeholder='example@domain.com']"));
		gm.clearField(By.xpath("//input[@placeholder='Enter your name']"));
		gm.clearField(By.xpath("//textarea[@class='input']"));
		
		gm.elementDisplayed(By.xpath("//button[@class='btn btn--action btn--reportBug']"), "ContactSupportModal-SendRequestButton");
		gm.getText(By.xpath("//button[@class='btn btn--action btn--reportBug']"));
		gm.compareText(By.xpath("//button[@class='btn btn--action btn--reportBug']"), "Send Request");
		gm.click(By.xpath("//button[@class='btn btn--action btn--reportBug']"), 2);
		
		Thread.sleep(3000);
		gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='_enteredEmailError']"), "ContactSupportModal-EmailError");
		gm.getText(By.xpath("//div[@data-dojo-attach-point='_enteredEmailError']"));
		gm.compareText(By.xpath("//div[@data-dojo-attach-point='_enteredEmailError']"), "Please enter your email address");
		gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='_descriptionError']"), "ContactSupportModal-DescriptionError");
		gm.getText(By.xpath("//div[@data-dojo-attach-point='_descriptionError']"));
		gm.compareText(By.xpath("//div[@data-dojo-attach-point='_descriptionError']"), "Please describe your issue");
		
		gm.elementDisplayed(By.xpath("//button[@class='btn btn--action btn--cancel btn--reportBug']"), "ContactSupportModal-CancelButton");
		gm.getText(By.xpath("//button[@class='btn btn--action btn--cancel btn--reportBug']"));
		gm.compareText(By.xpath("//button[@class='btn btn--action btn--cancel btn--reportBug']"), "Cancel");
		gm.click(By.xpath("//button[@class='btn btn--action btn--cancel btn--reportBug']"), 2);

	}
	
	@Test(priority = 4) //Subheading on Enter an email
	public void subHeading(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_15_0']//h5"), "EmailPage-SubHeader");
		gm.getText(By.xpath("//div[@id='uniqName_15_0']//h5"));
		gm.compareText(By.xpath("//div[@id='uniqName_15_0']//h5"), "Enter your official email address to continue");
	}
	
	@Test(priority = 5) //email place holder
	public void emailPlaceHolder(){
		gm.elementDisplayed(By.xpath("//input[@class='input']"), "EnterEmailField");
		gm.getText(By.xpath("//input[@class='input']"));
		gm.compareText(By.xpath("//input[@class='input']"), "Enter your work email");
	}
	
	@Test(priority = 6) //login Button
	public void loginButton(){
		gm.elementDisplayed(By.xpath("//a[@class='btn btn--action btn--block']"), "LoginButton");
		gm.getText(By.xpath("//a[@class='btn btn--action btn--block']"));
		gm.compareText(By.xpath("//a[@class='btn btn--action btn--block']"), "Login or Create a Team");	
	}
	
	@Test(priority = 7) //onboarding side bar
	public void onbaordingSideBar(){
		gm.elementDisplayed(By.xpath("//div[@class='onboarding-sidebar']"), "SideBarImage");
	}

	@Test(priority = 8, dataProvider ="emails", dataProviderClass = DataInputField.class) //Email Validations
	public void emailFieldErrorMessage(String emailIDs){
		gm.SendKey(By.xpath("//input[@class='input']"), 1, emailIDs);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		gm.elementDisplayed(By.xpath("//div[@class='errorMessage']"), "IncorrectEmailErrorMessage");
		gm.getText(By.xpath("//div[@class='errorMessage']"));
		gm.clearField(By.xpath("//input[@class='input']"));
	}
	
	@Test(priority =9)//Enter the email
	public void enterEmail(){
		gm.SendKey(By.xpath("//input[@class='input']"), 1, DefaultStrings.DIRECTI_TESTER_002_Email);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
	}
	
	@Test(priority = 10)
	public void googleAuthHeading(){
		gm.implicitWait(10);
		gm.waitForElement(By.xpath("//div[@id='uniqName_17_0']//h2"), 10);
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_17_0']//h2"), "GoogleAuthPageHeader");
		gm.getText(By.xpath("//div[@id='uniqName_17_0']//h2"));
		gm.compareText(By.xpath("//div[@id='uniqName_17_0']//h2"), "directi.com uses Google apps");
	}
	
	@Test(priority = 11)
	public void googleAuthSubHeading(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_17_0']//h5"), "GoogleAuthPageSubHeader");
		gm.getText(By.xpath("//div[@id='uniqName_17_0']//h5"));
		gm.compareText(By.xpath("//div[@id='uniqName_17_0']//h5"), "Connect with your Google account ");
	}
	
	@Test(priority = 11)
	public void googleAuthButton(){
		gm.elementDisplayed(By.xpath("//a[@class='btn btn--block btn--google']"), "SignInWithGoogleButton");
		gm.getText(By.xpath("//a[@class='btn btn--block btn--google']"));
		gm.compareText(By.xpath("//a[@class='btn btn--block btn--google']"), "Sign in with Google");
	}
	
	@Test(priority = 11)
	public void googleAuthSkipButton(){
		gm.elementDisplayed(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), "SkipGoogleAuthButton");
		gm.getText(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"));
		gm.compareText(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), "Skip this step");
	}
	
	@Test(priority = 12)
	public void googleAuthNote(){
		gm.elementDisplayed(By.xpath("//div[@class='google-auth-blurb']"), "GoogleAuthNote");
		gm.getText(By.xpath("//div[@class='google-auth-blurb']"));
		gm.compareText(By.xpath("//div[@class='google-auth-blurb']"), "Why sign in with Google?");
	}
	
	@Test(priority =13)
	public void clickSkipGoogleAuth(){
		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), 2);
	}
	
	@Test(priority = 14)
	public void otpHeading(){
		gm.implicitWait(10);
		gm.waitForElement(By.xpath("//div[@id='uniqName_16_0']//h2"), 10);
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_16_0']//h2"), "OtpPageHeader");
		gm.getText(By.xpath("//div[@id='uniqName_16_0']//h2"));
		gm.compareText(By.xpath("//div[@id='uniqName_16_0']//h2"), "Please verify your email");
	}
	
	@Test(priority = 15)
	public void otpSubHeading(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_16_0']//h5"), "OtpPageSubHeader");
		gm.getText(By.xpath("//div[@id='uniqName_16_0']//h5"));
		gm.compareText(By.xpath("//div[@id='uniqName_16_0']//h5"), "We've sent you a six digit verification PIN at");
	}
	
	@Test(priority = 16)
	public void otpPlaceHolder(){
		gm.elementDisplayed(By.xpath("//input[@class='input']"), "OtpInputField");
		gm.getText(By.xpath("//input[@class='input']"));
		gm.compareText(By.xpath("//input[@class='input']"), "Enter verification PIN");
	}
	
	@Test(priority = 17)
	public void resendOtpText(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_16_0']//div[2]/span"), "ResendOtpText");
		gm.getText(By.xpath("//div[@id='uniqName_16_0']//div[2]/span"));
		gm.compareText(By.xpath("//div[@id='uniqName_16_0']//div[2]/span"), "Didn't receive the pin?");
	}
	
	@Test(priority = 18)
	public void resendOtpHook(){
		gm.elementDisplayed(By.xpath("//a[@data-dojo-attach-event='onclick: _resend']"), "ResendOtpButton");
		gm.getText(By.xpath("//a[@data-dojo-attach-event='onclick: _resend']"));
		gm.compareText(By.xpath("//a[@data-dojo-attach-event='onclick: _resend']"), "Resend PIN");
	}
	
	@Test(priority =19)
	public void resendOtpHookClicked(){
		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _resend']"), 2);
		gm.elementDisplayed(By.xpath("//div[@class='resend-status']"), "ResendOtpSucessMessage");
		gm.getText(By.xpath("//div[@class='resend-status']"));
		gm.compareText(By.xpath("//div[@class='resend-status']"), "PIN sent successfully");
	}
	
	@Test(priority = 20)
	public void verifyButton(){
		gm.elementDisplayed(By.xpath("//a[@class='btn btn--action btn--block']"), "VerifyButton");
		gm.getText(By.xpath("//a[@class='btn btn--action btn--block']"));
		gm.compareText(By.xpath("//a[@class='btn btn--action btn--block']"), "Verify");
	}
	
	@Test(priority = 20)
	public void checkEditButton() throws Exception{
		gm.elementDisplayed(By.xpath("//a[@data-dojo-attach-point='backLink']"), "EmailEditButton");
		gm.getText(By.xpath("//a[@data-dojo-attach-point='backLink']"));
		gm.compareText(By.xpath("//a[@data-dojo-attach-point='backLink']"), "Edit");
		gm.click(By.xpath("//a[@data-dojo-attach-point='backLink']"), 1);
		Thread.sleep(2000);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		Thread.sleep(3000);
		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), 1);
	}
	
	@Test(priority = 21, dataProvider ="otp", dataProviderClass = DataInputField.class)
	public void otpErrorMessage(String otp) throws Exception{
		System.out.println("The otp vale: "+otp);
		gm.SendKey(By.xpath("//input[@class='input']"), 1, otp);
		Thread.sleep(2000);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		gm.elementDisplayed(By.xpath("//div[@class='errorMessage']"), otp);
		gm.getText(By.xpath("//div[@class='errorMessage']"));
		driver.findElement(By.xpath("//input[@class='input']")).clear();
		//gm.clearField(By.xpath("//input[@class='input']"));
	}
	
	@Test(priority = 22)
	public void otpErrorMessage1() throws Exception{
		
		gm.SendKey(By.xpath("//input[@class='input']"), 1, "123456");
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		Thread.sleep(2000);
		gm.elementDisplayed(By.xpath("//span[@class='errorMessage']"), "OtpErrorMessage");
		gm.getText(By.xpath("//span[@class='errorMessage']"));
		gm.clearField(By.xpath("//input[@class='input']"));
	}
	
	@Test(priority = 23)
	public void enterOTP() {
		
		gm.SendKey(By.xpath("//input[@class='input']"), 1, DefaultStrings.OTP);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
	}
	
	@AfterMethod
	public void afterMethod() {		
		System.out.println("BaseTestSuite -> After Method");
	}

}