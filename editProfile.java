package com.Flock.HydraAutomation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class editProfile extends BaseTestSuite {


    @Test
    public void changeStatus() throws Exception { //Change and Verify Status using TextBox
        if (!ce1.settingDropDownDisplayed()) {
            ce1.clickSettingDropDwon();
            Thread.sleep(1000);
            changeStatusCase();
        } else {
            changeStatusCase();
        }
    }

    public void changeStatusCase() throws Exception {
        if (ce1.editIconPresent()) {
            Thread.sleep(1000);
            ce1.clickEditIcon();
            Thread.sleep(2000);
            ce1.clearCustomStatusField();
            ce1.customStatusField.sendKeys("Test Status");
            ce1.clickStatusUpdateButton();
            ce1.statusButtonAfterClickDisplayed();    // Checking Update button transition
            ce1.clickEditProfileClose();
            Thread.sleep(2000);
            ce1.contactAvatarStatus1Displayed();
        }
    }

    @Test
    public void statusTogglePresent() throws Exception { //Check all the status toggle button
        if (!ce1.settingDropDownDisplayed()) {
            ce1.clickSettingDropDwon();
            Thread.sleep(1000);
            statusTogglePresentCase();
        } else {
            statusTogglePresentCase();
        }
    }
    
    public void statusTogglePresentCase() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        ce1.clickEditIcon();
        Thread.sleep(2000);
        sa.assertEquals(ce1.listofStatusToggles.get(1).getAttribute("value"), "Available");
        sa.assertEquals(ce1.listofStatusToggles.get(2).getAttribute("value"), "Busy");
        sa.assertEquals(ce1.listofStatusToggles.get(3).getAttribute("value"), "Away from desk");
        sa.assertEquals(ce1.listofStatusToggles.get(4).getAttribute("value"), "Working from home");
        sa.assertEquals(ce1.listofStatusToggles.get(5).getAttribute("value"), "On leave");
        ce1.clickEditProfileClose();
        Thread.sleep(2000);
        sa.assertAll();
        log.info("All status toggle present");
        test.log(LogStatus.PASS, "All status toggle present");
    }

    @Test
    public void clickStatusToggles() throws Exception { //Click on all the Status toggle button
        if (!ce1.settingDropDownDisplayed()) {
            ce1.clickSettingDropDwon();
            Thread.sleep(1000);
            clickStatusTogglesCase();
        } else {
            clickStatusTogglesCase();
        }
    }
    
    public void clickStatusTogglesCase() throws Exception {
        boolean value = false;
        ce1.clickEditIcon();
        Thread.sleep(2000);
        int size = ce1.listofStatusToggles.size();
        System.out.println("Size of the status toggle list is: " + size);
        for (int i = 1; i < size; i++) {
            ce1.listofStatusToggles.get(i).click();
            value = ce1.listofStatusToggles.get(i).isSelected();
            if (value == true) {
                test.log(LogStatus.INFO, ce1.listofStatusToggles.get(i).getAttribute("value") + " Status Toggle Selected");
            }
            value = false;

        }
        ce1.clickEditProfileClose();
        Thread.sleep(2000);
        ce1.contactAvatarStatus2Displayed();
    }
    
    @Test
    public void updateUserDetails() throws Exception{
    	ce.dismissCalendarPrompt();
    	if (!ce1.settingDropDownDisplayed()) {
            ce1.clickSettingDropDwon();
            Thread.sleep(1000);
            updateUserDetailsCase();
        } else {
        	updateUserDetailsCase();
        }
    }
    
    public void updateUserDetailsCase() throws Exception {
   
    	SoftAssert sa = new SoftAssert();
    	ce1.clickEditIcon();
    	Thread.sleep(2000);
    	ce1.clickUserNameEditProfile();
    	try{
    	ce1.emailFieldDisplayed(); // Check Email Field
    	test.log(LogStatus.PASS, "Correct email address is displayed");
    	ce1.clearFirstNameEditProfile();
    	ce1.clearLastNameEditProfile();
    	ce1.clickSaveEditProfile();
    	ce1.firstNameErrorDisplayed();  // Check First Name Error State
    	test.log(LogStatus.PASS, "First Name error displayed");
    	ce1.lastNameErrorDisplayed();   // Check Last Name Error State
    	test.log(LogStatus.PASS, "Last Name error displayed");
    	ce1.firstNameEditProfile.sendKeys("FirstNametest");
    	ce1.lastNameEditProfile.sendKeys("LastNametest");
    	ce1.clearMobileNumberEditProfile();
    	ce1.mobileNumberEditProfile.sendKeys("abc");
    	ce1.clickSaveEditProfile();
    	ce1.phoneNumberErrorDisplayed();  // Check Phone Number Error State
    	test.log(LogStatus.PASS, "Phone number error displayed");
    	ce1.clearMobileNumberEditProfile();
    	ce1.mobileNumberEditProfile.sendKeys("523456789");
    	ce1.clickSaveEditProfile();
    	Thread.sleep(2000);
    	ce1.clickSettingDropDwon();
    	ce1.clickEditIcon();
    	Thread.sleep(2000);
    	sa.assertEquals(ce1.userNameEditProfile.getText(), "FirstNametest LastNametest");
    	sa.assertEquals(ce1.userEmailEditProfile.getText(), "flockdesktop1@flock.com");
    	sa.assertEquals(ce1.userPhoneNumberEditProfile.getText(), "+91 523456789");
    	sa.assertAll();
    	ce1.clickEditProfileClose();
    	Thread.sleep(2000);
    	test.log(LogStatus.PASS, "Correct user deatails are present inside the first page of Edit Profile");
    	ce1.resetUserDetails();
    	}catch(Exception e){
    		ce1.clickEditProfileClose();
    		test.log(LogStatus.FAIL, "Correct user deatails are not present inside the first page of Edit Profile");
    		log.error("Correct user deatails are not present inside the first page of Edit Profile");
			sa.assertTrue(false, "Correct user deatails are not present inside the first page of Edit Profile");
			sa.assertAll();
    	}
    }
    
    @Test
    public void profileImage() throws Exception{
    	if (!ce1.settingDropDownDisplayed()) {
            ce1.clickSettingDropDwon();
            Thread.sleep(1000);
            profileImageCase();
        } else {
        	profileImageCase();
        }
    }
    
    public void profileImageCase() throws Exception {
    	SoftAssert sa = new SoftAssert();
    	try{
    	ce1.clickEditIcon();
    	Thread.sleep(2000);
    	ce1.clickUserNameEditProfile();
    	Thread.sleep(2000);
    	ce1.userAvatar.sendKeys("C:\\Users\\idris.t\\Pictures\\evernote.png");
    	Thread.sleep(2000);
    	ce1.clickSaveEditProfile();
    	Thread.sleep(4000); 
    	}catch(Exception e){
    		test.log(LogStatus.FAIL, "Avatar not set");
    		log.error("Avatar not set");
    		ce1.clickSaveEditProfile();
    		Thread.sleep(4000);
    		sa.assertTrue(false, "Avatar is not present on user computer or failed to set the avatar");
			sa.assertAll();

    	}
    }    
     
     
}