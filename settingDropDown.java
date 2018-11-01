package com.Flock.HydraAutomation;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class settingDropDown extends BaseTestSuite {
  
private static final Logger log = LogManager.getLogger(searchPlus.class.getName());
	
	
	@Test
	public void DND() throws Exception {
		if(!ce1.settingDropDownDisplayed()){
		ce1.clickSettingDropDwon();
			DNDcase();
		}else{
			DNDcase();
		}
	}	
	
	public void DNDcase() throws Exception{
		if(ce1.dndPresent()){
			ce1.clickdndButton();
			Thread.sleep(1000);
			if(ce1.oneHourDNDDisplayed()){
				test.log(LogStatus.PASS, "DND setting drop-down is SUCCESSFULLY opened");
			}else{
				test.log(LogStatus.FAIL, "DND setting drop-down FAILED to open");
			}
			ce1.clickDNDhour();
			}
		
		Thread.sleep(2000);
		ce1.clickdndButton();
		if(ce1.oneHourDNDDisplayed()){
			test.log(LogStatus.FAIL, "DND setting drop-down FAILED to close");
		}else{
			test.log(LogStatus.PASS, "DND setting drop-down is SUCCESSFULLY closed");
		}
		ce1.dndSubLabelDisplayed();
	}

	
	@Test
	public void desktopnotifications() throws Exception {
		if(!ce1.settingDropDownDisplayed()){
		ce1.clickSettingDropDwon();
		desktopNotificationsCase();
		}else{
			desktopNotificationsCase();
		}
	}
	
	public void desktopNotificationsCase() throws Exception {
		if(ce1.desktopNotificationsPresent()){
			if(ce1.popupNotificationsToggleDisplayed()){
				clickNotificationPreferenceToggle();	
				
			}else{
				ce1.clickNotificationPreferences();
				if(ce1.popupNotificationsToggleDisplayed()){
					test.log(LogStatus.PASS, "Notification preferences drop-down is SUCCESSFULLY opened");
				}else{
					test.log(LogStatus.FAIL,"Notification preferences drop-down FAILED to open" );
				}
				clickNotificationPreferenceToggle();
			}
		ce1.clickNotificationPreferences();
		if(ce1.popupNotificationsToggleDisplayed()){
			test.log(LogStatus.FAIL, "Notification preferences drop-down FAILED to close");
		}else{
			test.log(LogStatus.PASS,"Notification preferences drop-down is SUCCESSFULLY closed" );
		}
	}	
}
	
	public void clickNotificationPreferenceToggle() throws Exception{    // Clicking on Notification Preference toggle buttons
		ce1.clickPopupNotificationsToggle();
		test.log(LogStatus.INFO, "Clicked on Popup notification toggle");
		log.info("Clicked on Popup notification toggle");
		if(gm.elementDisplayed(By.xpath("//div[(@id='widgets_buttons_Toggle_1') and not(contains(@class,'toggle_button-active'))]"),"popuptoggle")){
			test.log(LogStatus.PASS, "Popup notification toggle button working");
			log.info("Popup notification toggle button is working");
		}else{
			log.error("Popup notification toggle button is not working");
			test.log(LogStatus.FAIL, "Popup notification toggle button is not working");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Popup notification toggle button is not working");
			sa.assertAll();
		}
		Thread.sleep(1000);
		ce1.clickAudioAlertsToggle();
		test.log(LogStatus.INFO, "Clicked on Audio alert toggle");
		log.info("Clicked on Audio alert toggle");
		if(gm.elementDisplayed(By.xpath("//div[(@id='widgets_buttons_Toggle_2') and not(contains(@class,'toggle_button-active'))]"),"audiotoggle")){
			test.log(LogStatus.PASS, "Audio alert notification toggle button working");
			log.info("Audio alert notification toggle button is working");
		}else{
			log.error("Audio alert notification toggle button is not working");
			test.log(LogStatus.FAIL, "Audio alert notification toggle button is not working");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Audio alert notification toggle button is not working");
			sa.assertAll();
		}
		Thread.sleep(1000);
		ce1.clickUserOnlineNotificationsToggle();
		test.log(LogStatus.INFO, "Clicked on User Online Notification toggle");
		log.info("Clicked on User Online Notification toggle");
		if(gm.elementDisplayed(By.xpath("//div[(@id='widgets_buttons_Toggle_3') and not(contains(@class,'toggle_button-active'))]"),"useronlinetoggle")){
			test.log(LogStatus.PASS, "User online notification toggle button working");
			log.info("User online notification toggle button is working");
		}else{
			log.error("User online notification toggle button is not working");
			test.log(LogStatus.FAIL, "User online notification toggle button is not working");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "User online notification toggle button is not working");
			sa.assertAll();
		}
		Thread.sleep(1000);
		ce1.clickPopupNotificationsToggle();
		test.log(LogStatus.INFO, "Clicked on Popup notification toggle");
		log.info("Clicked on Popup notification toggle");
		Thread.sleep(1000);
		ce1.clickAudioAlertsToggle();
		test.log(LogStatus.INFO, "Clicked on Audio alert toggle");
		log.info("Clicked on Audio alert toggle");
		Thread.sleep(1000);
		ce1.clickUserOnlineNotificationsToggle();
		log.info("Clicked on User Online Notification toggle");
		test.log(LogStatus.INFO, "Clicked on User Online Notification toggle");
		ce1.clickEmailPreferences();
		log.info("Clicked on Email Preferences");
		test.log(LogStatus.INFO, "Clicked on Email Preferences");
		SoftAssert sa = new SoftAssert();
		ArrayList<String> applink = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(applink.get(1));
		Thread.sleep(7000);	
		sa.assertTrue(driver.getCurrentUrl().contains("https://admin.flock-staging.com/#!/email-preferences"));
		driver.close();
		driver.switchTo().window(applink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
		log.info("Email preferences link under setting drop-down working");
		test.log(LogStatus.PASS, "Email preferences link under setting drop-down working");
		
		
	}
	
	/*@Test
	public void browseApps() throws Exception {
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			if(ce1.browseAppsPresent()){
				ce1.clickBrowseApps();
				checkBrowseAppsLink();	
			}
		}else{
			if(ce1.browseAppsPresent()){
				ce1.clickBrowseApps();
				checkBrowseAppsLink();
		}
	}
}
	
	public void checkBrowseAppsLink() throws Exception{                                    // Verify Browse Apps links
		SoftAssert sa = new SoftAssert();
		ArrayList<String> applink = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(applink.get(1));
		Thread.sleep(5000);	
		sa.assertEquals(driver.getCurrentUrl(), "https://apps.flock-staging.com/?source=profilemodal");
		driver.close();
		driver.switchTo().window(applink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
		log.info("Browse apps link uder setting drop-dwon working");
		test.log(LogStatus.PASS, "Browse apps link uder setting drop-dwon working");
	}
*/	
	@Test
	public void manageApps() throws Exception {
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			if(ce1.manageAppsPresent()){
				ce1.clickManageApps();
				checkManageAppsLink();	
			}
		}else{
			if(ce1.manageAppsPresent()){
				ce1.clickManageApps();
				checkManageAppsLink();
		}
	}
}
	
	public void checkManageAppsLink() throws Exception{                                    // Verify Manage Apps links
		SoftAssert sa = new SoftAssert();
		ArrayList<String> applink = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(applink.get(1));
		Thread.sleep(5000);	
		sa.assertEquals(driver.getCurrentUrl(), "https://apps.flock-staging.com/manage?source=profilemodal");
		driver.close();
		driver.switchTo().window(applink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
		log.info("Manage apps link uder setting drop-dwon working");
		test.log(LogStatus.PASS, "Manage apps link uder setting drop-dwon working");
	}
	
	@Test
	public void keyboardShortcuts() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			checkKeyboardShortcutsCase();	
		}else{
			checkKeyboardShortcutsCase();
		}
	}
	
	public void checkKeyboardShortcutsCase() throws Exception{
		if(ce1.keyboardShortutsPresent()){
			ce1.clickKeyboardShortcuts();
			Thread.sleep(1000);
			if(ce1.keyboardShortcutsTitleDisplayed()){
			ce1.clickKeyboardShortcutsClose();
			Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void contactSupport() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			checkContactSupportCase();	
		}else{
			checkContactSupportCase();
		}
	}
	
	public void checkContactSupportCase() throws Exception{
		if(ce1.contactSupportPresent()){
			ce1.clickContactSupport();
			Thread.sleep(1000);
			if(ce1.contactSupportdefaulttoggleDisplayed()){
			ce1.clickContactSupportClose();
			Thread.sleep(2000);
			}
		}
	}
	
	/*@Test
	public void reportBug() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			checkReportBugCase();	
		}else{
			checkReportBugCase();
		}
	}
	
	public void checkReportBugCase() throws Exception{
		if(ce1.reportBugPresent()){
			ce1.clickReportBug();
			Thread.sleep(1000);
			if(ce1.reportBugdefaulttoggleDisplayed()){
			ce1.clickContactSupportClose();
			Thread.sleep(2000);
			}
		}
	}*/
	
	@Test
	public void manageTeam() throws Exception {
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			if(ce1.manageTeamDisplayed()){
				ce1.clickManageTeam();
				checkManageTeamLink();	
			}
		}else{
			if(ce1.manageTeamDisplayed()){
				ce1.clickManageTeam();
				checkManageTeamLink();
		}
	}
}
	
	public void checkManageTeamLink() throws Exception{                                    // Verify Manage Team links
		SoftAssert sa = new SoftAssert();
		ArrayList<String> teampanellink = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(teampanellink.get(1));
		Thread.sleep(5000);	
		sa.assertEquals(driver.getCurrentUrl(), "https://admin.flock-staging.com/?config=preprod&platform=BROWSER#!/overview");
		driver.close();
		driver.switchTo().window(teampanellink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
	}
	
	@Test
	public void addNewTeam() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			checkAddNewTeamCase();	
		}else{
			checkAddNewTeamCase();
		}
	}
	
	public void checkAddNewTeamCase() throws Exception{
		if(ce1.addTeamPresent()){
			ce1.clickAddTeam();
			Thread.sleep(5000);
			driver.switchTo().frame(ce1.addNewTeamIframe);
			if(ce1.addTeamTitleDisplayed()){
			ce1.clickAddTeamClose();
			Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void languageSetting() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			checkLanguageSettingCase();	
		}else{
			checkLanguageSettingCase();
		}
	}
	
	public void checkLanguageSettingCase() throws Exception{
		if(ce1.settingDropdownFooterPresent()){
			ce1.clickSettingDropdownFooter();
			Thread.sleep(1000);
			if(ce1.languageSettingTitleDisplayed()){
			ce1.clickLanguageSettingCancel();
			Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void profileAndAccount() throws Exception{
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			if(ce1.profileAndAccountPresent()){
				ce1.clickProfileAndAccount();
				checkProfileAndAccountLink();	
			}
		}else{
			if(ce1.profileAndAccountPresent()){
				ce1.clickProfileAndAccount();
				checkProfileAndAccountLink();
		}
	}
}
	
	public void checkProfileAndAccountLink() throws Exception{
		SoftAssert sa = new SoftAssert();
		ArrayList<String> teampanellink = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(teampanellink.get(1));
		Thread.sleep(5000);	
		sa.assertEquals(driver.getCurrentUrl(), "https://admin.flock-staging.com/#!/profile?config=preprod&platform=BROWSER");
		driver.close();
		driver.switchTo().window(teampanellink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
	}
	
	@Test //(dependsOnMethods = { "manageTeam" })
	public void nonAdminCase() throws Exception{
		ce1.clickNonAdminTeam();
		if(!ce1.settingDropDownDisplayed()){
			ce1.clickSettingDropDwon();
			if(ce1.manageTeamDisplayed()){
				log.error("Manage Team is present under setting dropdown for a non-admin");
				test.log(LogStatus.FAIL, "Manage Team is present under setting dropdown for a non-admin");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Status was not changed using /status");
				sa.assertAll();
			}
		}else{
			log.info("Manage Team is absent under setting dropdown for a non-admin");
			test.log(LogStatus.PASS, "Manage Team is absent under setting dropdown for a non-admin");
		}
	}
}


