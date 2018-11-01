package com.utilities;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class clientElement1 {
	ExtentTest test;
	WebDriver driver;
	WebElement element = null ;
	
	//private static GenericMethods gm ;
	private static final Logger log = LogManager.getLogger(clientElement1.class.getName());
	
	public clientElement1(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath="//div[@id='app-menu-item-dnd']//div[contains(text(),'Do not disturb')]")  //DND Button inside drop-down
	public WebElement dndButton;
	
	@FindBy(xpath="//div[@class='app_menu_avatar']")  //Setting Drop-down Icon 
	public WebElement settingDropDown;
	
	@FindBy(xpath="//div[@id='app-menu-item-dnd']//div[contains(text(),'Stop receiving notification')]")  //DND Button sub label inside drop-down
	public WebElement dndSubLabel;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_0']//div[contains(text(),'For 1 hour')]")  //One Hour DND inside drop-down
	public WebElement oneHourDND;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_1']//div[contains(text(),'For 8 hour')]")  //Eight Hour DND inside drop-down
	public WebElement eightHourDND;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_2']//div[contains(text(),'For 12 hour')]")  //Twelve Hour DND inside drop-down
	public WebElement twelveHourDND;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_3']//div[contains(text(),'Until I resume')]")  //Until I resume DND inside drop-down
	public WebElement untilIResumeDND;
	
	@FindBy(xpath="//div[@id='app-menu-item-notification']//div[contains(text(),'Notification Preferences')]")  //Notification Preferences inside drop-down
	public WebElement notificationPreferences;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_4']//div[contains(text(),'Popup notifications')]")  //Pop-up notifications toggle inside drop-down
	public WebElement popupNotificationsToggle;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_5']//div[contains(text(),'Audio alerts')]")  //Audio alert toggle inside drop-down
	public WebElement audioAlertToggle;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_6']//div[contains(text(),'User online notifications')]")  //User online notifications toggle inside drop-down
	public WebElement userOnlineNotificationToggle;
	
	@FindBy(xpath="//div[@id='app-menu-item-browse-apps']//div[contains(text(),'Browse apps')]")  //Browse app inside drop-down
	public WebElement browseApps;
	
	@FindBy(xpath="//div[@id='app-menu-item-manage-apps']//div[contains(text(),'Manage your apps')]")  //Manage app inside drop-down
	public WebElement manageApps;
	
	@FindBy(xpath="//div[@id='app-menu-item-keyboard-shortcuts']//div[contains(text(),'Keyboard Shortcuts')]")  //Keyboard SHortcut inside drop-down
	public WebElement keyboardShortcuts;
	
	@FindBy(xpath="//div[contains(@class,'keyboard-shortcuts')]//span[contains(@class,'close-dialog')]")  //Keyboard SHortcut Modal Close (x) Button
	public WebElement keyboardShortcutsClose;
	
	@FindBy(xpath="//div[contains(@class,'keyboard-shortcuts')]//div[contains(text(),'Keyboard Shortcuts')]")  //Keyboard SHortcut Modal Title
	public WebElement keyboardShortcutsTitle;
	
	@FindBy(xpath="//div[@id='app-menu-item-contact-support']//div[contains(text(),'Help & Feedback')]")  //Contact Support inside drop-down
	public WebElement contactSupport;
	
	@FindBy(xpath="//div[@id='app-menu-item-report-bug']//div[contains(text(),'Report a bug')]")  //Report a bug inside drop-down
	public WebElement reportBug;
	
	@FindBy(xpath="//div[contains(@class,'report-bug')]//span[contains(@class,'dijitDialogCloseIcon')]")  //Contact Support Modal Close (x) Button
	public WebElement contactSupportClose;
	
	@FindBy(xpath="//div[contains(@class,'report-bug')]//label[contains(@class,'selected')]//span[contains(text(),'I need help setting up my team')]")  //Contact Support toggle selected
	public WebElement contactSupporttoggle;
	
	@FindBy(xpath="//div[contains(@class,'report-bug')]//label[contains(@class,'selected')]//span[contains(text(),'Something is not working')]")  //Report Bug toggle selected
	public WebElement reportBugtoggle;
	
	@FindBy(xpath="//div[@id='app-menu-item-manage-team']//div[contains(text(),'Manage your team')]")  //Manage your team inside drop-down
	public WebElement manageTeam;
	
	@FindBy(xpath="//div[@id='app-menu-item-account-preference']//div[contains(text(),'Profile and Account')]")  //Profile and Account inside drop-down
	public WebElement profileAndAccount;
	
	@FindBy(xpath="//div[@id='app-menu-item-add-team']//div[contains(text(),'Add new team')]")  //Add new team inside drop-down
	public WebElement addTeam;
	
	@FindBy(xpath="//div[@class='modal-back']")  //Add new team Modal Back Button
	public WebElement addTeamClose;
	
	@FindBy(xpath="//div[contains(@class,'center-panel')]//h2[contains(text(),'Looking to add a new team?')]")  //Add new team Modal Title
	public WebElement AddTeamTitle;
	
	@FindBy(xpath="//div[@id='app-menu-item-footer']")  //Footer inside drop-down
	public WebElement settingDropdownFooter;
	
	@FindBy(xpath="//div[contains(@class,'language-dialog')]//div[contains(text(),'Language Settings')]")  //Language setting Modal Title
	public WebElement languageSettingTitle;
	
	@FindBy(xpath="//div[contains(@class,'language-dialog')]//button[contains(@class,'btn--cancel')]")  //Language setting Modal Title
	public WebElement languageSettingCancel;
	
	@FindBy(xpath="//div[@id='app-menu-item-avatar']")  //Edit icon under setting drop down
	public WebElement editIcon;
	
	@FindBy(xpath="//input[@placeholder='Enter a custom status']")  //Custom status text field
	public WebElement customStatusField;
	
	@FindBy(xpath="//div[contains(@class,'edit-profile') and contains(@style,'opacity: 1')]//span[contains(@title,'Cancel') and contains(@role,'button')]")  //Edit Profile Close button
	public WebElement editProfileClose;
	
	@FindBy(xpath="//div[contains(@class,'set-new-status')]//button[contains(@class,'btn--action')]")  //Status Update Button
	public WebElement statusUpdateButton;
	
	@FindBy(xpath="//div[contains(@class,'set-new-status')]//button[contains(text(),'Updated')]")  //Status Update Button after click
	public WebElement statusUpdateButtonAfterClick;
	
	@FindBy(xpath="//div[contains(@class,'contact_avatar_status') and contains(text(),'Test Status')]")  //Status below Contact Avatar
	public WebElement contactAvatarStatus_1;
	
	@FindBy(xpath="//div[contains(@class,'contact_avatar_status') and contains(text(),'On leave')]")  //Status below Contact Avatar
	public WebElement contactAvatarStatus_2;
		
	@FindBy(xpath="//div[contains(@class,'set-status')]//input[contains(@type,'radio')]") //Status toggle list
	public List<WebElement> listofStatusToggles; 
	
	@FindBy(xpath="//div[@class='userDetails']//div[@class='name']") //User name under Edit Profile
	public WebElement userNameEditProfile;
	
	@FindBy(xpath="//div[@class='userDetails']//div[@class='email']") //User email under Edit Profile
	public WebElement userEmailEditProfile;
	
	@FindBy(xpath="//div[@class='userDetails']//div[@class='phoneNumber']") //User phone number under Edit Profile
	public WebElement userPhoneNumberEditProfile;
	
	@FindBy(xpath="//input[@name='firstName']") //User First name under Edit Profile
	public WebElement firstNameEditProfile;
	
	@FindBy(xpath="//input[@name='lastName']") //User Last name under Edit Profile
	public WebElement lastNameEditProfile;
	
	@FindBy(xpath="//input[@name='mobile']") //User Mobile number under Edit Profile
	public WebElement mobileNumberEditProfile;
	
	@FindBy(xpath="//div[@class='contactEmailField input' and contains(text(),'flockdesktop1@flock.com')]") //Email Field under Edit Profile
	public WebElement emailFieldEditProfile;
	
	@FindBy(xpath="//input[@name='countryCode']") //Country Drop-down under Edit Profile
	public WebElement countryDropDown;
	
	@FindBy(xpath="//div[@class='modalButton']//input[@value='Save']") //Save button inside edit Profile
	public WebElement saveEditProfile;
	
	@FindBy(xpath="//div[@class='errorMessage' and contains(text(),'Enter a valid first name')]") //First name error message
	public WebElement firstNameError;
	
	@FindBy(xpath="//div[@class='errorMessage' and contains(text(),'Enter a valid last name')]") //Last name error message
	public WebElement lastNameError;
	
	@FindBy(xpath="//div[@class='errorMessage' and contains(text(),'Enter a valid phone number')]") //Phone Number error message
	public WebElement phoneNumberError;
	
	@FindBy(xpath="//input[@type='file']") //Avatar under Edit Profile
	public WebElement userAvatar;
	
	@FindBy(xpath="//div[contains(@class,'openGroups rosterTab')]") //Browses Channel under Roster when not selected
	public WebElement rosterBrowseChannels;
	
	@FindBy(xpath="//textarea[@id='whatsNewHookEditorArea']") // Text Editor
	public WebElement textEditor;
	
	@FindBy(xpath="//span[@class='commandName' and contains(text(),'/add')]") // slash add element
	public WebElement slashAdd;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'@name')]") // slash add element Parameter
	public WebElement slashAddParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'add people to this conversation')]") // slash add element Description
	public WebElement slashAddDesc;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/mute')]") // slash Mute element
	public WebElement slashMute;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/unmute')]") // slash Unmute element
	public WebElement slashUnmute;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/status')]") // slash Status element
	public WebElement slashStatus;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/shortcuts')]") // slash Shortcuts element
	public WebElement slashShortcuts;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/leave')]") // slash leave element
	public WebElement slashLeave;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/clone')]") // slash Clone element
	public WebElement slashClone;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/remind')]") // slash Remind element
	public WebElement slashRemind;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/video')]") // slash Video element
	public WebElement slashVideo;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/poll')]") // slash Poll element
	public WebElement slashPoll;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/todo')]") // slash Todo element
	public WebElement slashTodo;
	
	@FindBy(xpath="//li[contains(@style,'display: block')]//span[@class='commandName' and contains(text(),'/giphy')]") // slash Giphy element
	public WebElement slashGiphy;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'@channelname')]") // slash mute element Parameter
	public WebElement slashMuteParam;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'optional room name')]") // slash video element Parameter
	public WebElement slashVideoParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'start a video conference')]") // slash video element Description
	public WebElement slashVideoDesc;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'mute a channel')]") // slash mute element Description
	public WebElement slashMuteDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'@channelname')]") // slash Unmute element Parameter
	public WebElement slashUnmuteParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'create a poll')]") // slash Poll element Description
	public WebElement slashPollDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'question o:option 1, option 2, ...')]") // slash Poll element Parameter
	public WebElement slashPollParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'share a random gif')]") // slash Giphy element Description
	public WebElement slashGiphyDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'name')]") // slash Giphy element Parameter
	public WebElement slashGiphyParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'create a shared to-do')]") // slash Todo element Description
	public WebElement slashTodoDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'to-do text')]") // slash Todo element Parameter
	public WebElement slashTodoParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'unmute a channel')]") // slash Unmute element Description
	public WebElement slashUnmuteDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'status message')]") // slash Status element Parameter
	public WebElement slashStatusParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'set your status')]") // slash Status element Description
	public WebElement slashStatusDesc;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'see all keyboard shortcuts')]") // slash Shortcuts element Description
	public WebElement slashShortcutsDesc;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'leave channel')]") // slash leave element Description
	public WebElement slashLeaveDesc;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'clone the current channel')]") // slash clone element Description
	public WebElement slashCloneDesc;
	
	@FindBy(xpath="//span[@class='commandParams' and contains(text(),'[me or all] in [time eg: 30 mins] to [message]')]") // slash Remind element Parameter
	public WebElement slashRemindParam;
	
	@FindBy(xpath="//div[@class='commandDesc' and contains(text(),'create new reminders')]") // slash Remind element Description
	public WebElement slashRemindDesc;
	
	@FindBy(xpath="//div[@class='occupantListTopBar' and not(contains(@style,'visibility: hidden'))]") // Channel Member List Icon
	public WebElement channelMemberListIcon;
	
	@FindBy(xpath="//ul[@class='member-association--list']//li[@class='member-association--list-item' and contains(text(),'Remove from channel')]") // Remove from channel under drop-down
	public WebElement removeFromChannelButton;
	
	@FindBy(xpath="//button[@class='btn btn--action btn--red' and contains(text(),'Yes, remove')]") // Remove from Channel Confirmation
	public WebElement removeFromChannelConfirmation;
	
	@FindBy(xpath="//a[@class='link unmute']") // Mute icon in Channel Header
	public WebElement muteIcon;
	
	@FindBy(xpath="//a[@class='link mute']") // Unmute icon in Channel Header
	public WebElement unmuteIcon;
	
	@FindBy(xpath="//div[@class='title' and contains(text(),'Leave Channel?')]") //Leave Channel Confirmation Box Title
	public WebElement leaveChannelConfirmationTitle;
	
	@FindBy(xpath="//div[@class='action__buttons']//button[contains(text(),'Cancel')]") //Cancel Button
	public WebElement cancelButton;
	
	@FindBy(xpath="//div[@class='action__buttons']//button[contains(text(),'Yes, clone')]") //"Yes, clone" Button
	public WebElement yesCloneButton;
	
	@FindBy(xpath="//div[@class='title' and contains(text(),'Clone Channel?')]") //Clone channel confirmation box title
	public WebElement cloneTitle;
	
	@FindBy(xpath="//textarea[@id='whatsNewHookEditorArea' and contains(@placeholder,'Message Tester002 a')]") //text editor of clone channel
	public WebElement cloneChannelTextEditor;
	
	@FindBy(xpath="//div[@class='action__buttons']//button[contains(text(),'Yes')]") //"Yes, Leave and Delete" Button
	public WebElement leaveDeleteChannelButton;
	
	@FindBy(xpath="//div[contains(@class,'slash-command-menu')]//li[contains(@class,'dijitMenuItemSelected')]//span[@class='commandName']") //Slash command which is selected
	public WebElement slashCommandSelected;
	
	@FindBy(xpath="//div[contains(@class,'app') and contains(@class,'dijitVisible')]//iframe[@class='appframe']")
	public WebElement appIframe; //= driver.findElement(By.className("appframe"));
		
	@FindBy(xpath="//div[@id='convSearch_dropdown']//li[contains(@class,'dijitMenuItemSelected')]")
	public WebElement universalSearchResultSelected;
	
	@FindBy(xpath="//div[@id='whatsNewHookEditorArea_dropdown']//div[contains(@class,'EditorDropDownMenu-Contacts')]")
	public WebElement textEditorContactDropDown;
	

	@FindBy(xpath="//span[contains(text(),'frequent')]") //frequent button under universal search
	public WebElement frequentbutton;
	
	@FindBy(xpath="//div[contains(@class,'app-item--recent')]") //Directory on sidebar
	public WebElement Directory;
	
	@FindBy(xpath="//div[contains(@class,'app-item--on')]//span[@class='app-label' and contains(text(),'Directory')]") //Directory on sidebar
	public WebElement directoryActive;
	
	/*@FindBy(xpath="//div[contains(@class,'app-item--on')]//div[@class='app-label' and contains(text(),'History Search')]") //App side bar active history search
	public WebElement appSidebarActiveHistorySearch;*/
	
	@FindBy(xpath="//div[@class='appSidebar']//div[contains(text(),'Search')]") //History search title
	public WebElement historySearchTitle;

	@FindBy(xpath="//div[@class='onboarding']/iframe") //Iframe under add new team page
	public WebElement addNewTeamIframe;
	
	@FindBy(xpath="//div[@id='shell_teamSwitcher_Team_2']") //Non-Admin team icon on team switcher bar
	public WebElement nonAdmimTeamIcon;
	
	@FindBy(xpath="//div[contains(@class,'app-item--recent')]") //Directory on App switcher
	public WebElement directory;
	
	@FindBy(xpath="//div[contains(@class,'conversation group')]//div[contains(text(),'Slash')]") //Slash Command group in active chat area
	public WebElement slashCommandGroupActiveChat;
	
	@FindBy(xpath="//div[@id='shell_appMenu_AppMenuItem_7']//div[contains(text(),'Email Preferences')]") //Email Preference under setting dropdown
	public WebElement emailPreferencesettingdropdown ;
	
	public void clickEmailPreferences(){           //Clicked on the email preferences
		emailPreferencesettingdropdown.click();
		log.info("Clicked on the Email preference under setting dropdown");
		test.log(LogStatus.INFO, "Clicked on the Email preference under setting dropdown");
	}
	
	public boolean slashCommandGroupActiveChatDisplayed(){      //Check if Slash command was closed using Esc
		try{
		if(slashCommandGroupActiveChat.isDisplayed()){
			test.log(LogStatus.INFO, "Slash Command Group was not closed using Esc");
			log.error("Slash Command Group was not closed using Esc");
			return false;
		    }	
		}catch(Exception e){
			test.log(LogStatus.INFO, "Slash Command Group was closed using Esc");
			log.info("Slash Command Group was closed using Esc");
		}
		return true;
	}
	
	public void clickDirectory(){           //Clicked on the directory on app switcher
		directory.click();
		log.info("Clicked on the directory on app switcher");
		test.log(LogStatus.INFO, "Clicked on the directory on app switcher");
	}
	
	public void clickNonAdminTeam(){           // Click on NonAdminTeam
		nonAdmimTeamIcon.click();
		log.info("Clicked on the NonAdminTeam");
		test.log(LogStatus.INFO, "Clicked on the NonAdminTeam");
	}

	
	public void clickSettingDropDwon(){           // Click on Setting Drop-down Icon
		settingDropDown.click();
		log.info("Clicked on the Setting Drop Down Icon");
		test.log(LogStatus.INFO, "Clicked on the Setting Drop Down Icon");
	}
	
	public void clickdndButton(){                   // Click on DND Button inside drop-dow
		
	    dndButton.click();
		log.info("Clicked on the DND Button");
		test.log(LogStatus.INFO, "Clicked on the DND Button");
	}
	
	public boolean dndPresent(){                    // Check if DND Button inside drop-down present
		if(dndButton != null){
			test.log(LogStatus.PASS, "DND toggle visible");
			log.info("DND toggle visible");
			return true;
		}else{
			test.log(LogStatus.FAIL, "DND toggle not visible");
			log.error("DND toggle not visible");
			return false;
			
		}
	}
		
	public boolean dndSubLabelDisplayed(){                    // Check if DND Button Sub-Label inside drop-down present
			if(dndSubLabel.isDisplayed()){
				test.log(LogStatus.PASS, "DND toggle sub label is DISPLAYED");
				log.info("DND toggle sub label is DISPLAYED");
				return true;
			}else{
				test.log(LogStatus.FAIL, "DND toggle sub label is NOT displayed");
				log.error("DND toggle sub label is NOT DISPLAYED");
				return false;
			}
	}
	
	public void clickDNDhour() throws Exception{            // Click on all the options under DND
		
		eightHourDND.click();
		test.log(LogStatus.INFO, "Clicked on 8 hour DND");
		log.info("Clicked on 8 hour DND");
		Thread.sleep(2000);
		twelveHourDND.click();
		test.log(LogStatus.INFO, "Clicked on 12 hour DND");
		log.info("Clicked on 12 hour DND");
		Thread.sleep(2000);
		untilIResumeDND.click();
		test.log(LogStatus.INFO, "Clicked on Until I resume DND");
		log.info("Clicked on Until I resume DND");
		Thread.sleep(2000);
		oneHourDND.click();
		test.log(LogStatus.INFO, "Clicked on 1 hour DND");
		log.info("Clicked on 1 hour DND");
		Thread.sleep(2000);
	}
	
	public void clickNotificationPreferences(){                   // Click on Notification Preferences inside drop-down
		
	    notificationPreferences.click();
		log.info("Clicked on the Notification preferences");
		test.log(LogStatus.INFO, "Clicked on the Notification preferences");
	}

	public void clickPopupNotificationsToggle(){                   // Click on Popup Notification Toggle inside drop-down
	
    popupNotificationsToggle.click();
	log.info("Clicked on the Popup Notification Toggle");
	test.log(LogStatus.INFO, "Clicked on the Popup Notification Toggle");
}
	
	public void clickUserOnlineNotificationsToggle(){                   // Click on User Online Notification Toggle inside drop-down
		
	    userOnlineNotificationToggle.click();
		log.info("Clicked on the User Online Notification Toggle");
		test.log(LogStatus.INFO, "Clicked on the User Online Notification Toggle");
	}

	public void clickAudioAlertsToggle(){                   // Click on Audio alert toggle inside drop-down
	
    audioAlertToggle.click();
	log.info("Clicked on the Audio alert toggle");
	test.log(LogStatus.INFO, "Clicked on the Audio alert toggle");
}
	
	public boolean desktopNotificationsPresent(){                    // Check if Notification Preferences inside drop-down present
		if(notificationPreferences != null){
			test.log(LogStatus.PASS, "Notification Preferences setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Notification Preferences setting absent");
			return false;
		}
}
	
	public boolean popupNotificationsToggleDisplayed(){                    // Check if Popup Notification toggle inside setting is Displayed
		if(popupNotificationsToggle.isDisplayed()){
			test.log(LogStatus.INFO, "Popup Notification Toggle is displayed");
			return true;
		}else{
			test.log(LogStatus.INFO, "Popup Notification Toggle is not displayed");
			return false;
		}
	}
	
	
	public boolean oneHourDNDDisplayed(){                    // Check if One hour DND inside setting is Displayed
		if(oneHourDND.isDisplayed()){
			test.log(LogStatus.INFO, "One hour DND displayed");
			return true;
		}else{
			test.log(LogStatus.INFO, "One hour DND is not displayed");
			return false;
		}
	}
	
	public void clickBrowseApps(){                   // Clicked on the Browse apps under setting drop down
		
	    browseApps.click();
		log.info("Clicked on the Browse apps under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Browse apps under setting drop down");
	}
	
	public boolean browseAppsPresent(){                    // Check if Browse Apps inside drop-down present
		if(browseApps != null){
			test.log(LogStatus.PASS, "Browse apps setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Browse apps setting absent");
			return false;
		}		
	}
	
	
	public boolean settingDropDownDisplayed(){      //Check if Setting Drop-down is Opened or Close
		try{
		if(dndButton.isDisplayed()){
			test.log(LogStatus.INFO, "Setting drop down is open");
			return true;
		    }	
		}catch(Exception e){
			test.log(LogStatus.INFO, "Setting drop down is not open");	
		}
		return false;
	}
	
	public boolean directoryActiveDisplayed(){      //Check if Setting Drop-down is Opened or Close
		try{
		if(directoryActive.isDisplayed()){
			test.log(LogStatus.INFO, "Directory is open");
			return true;
		    }	
		}catch(Exception e){
			test.log(LogStatus.INFO, "Directory is closed");	
		}
		return false;
	}
	
	public void clickManageApps(){                   // Clicked on the Manage apps under setting drop down
		
	    manageApps.click();
		log.info("Clicked on the Manage apps under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Manage apps under setting drop down");
	}
	
	public boolean manageAppsPresent(){                    // Check if Manage Apps inside drop-down present
		if(manageApps != null){
			test.log(LogStatus.PASS, "Manage apps setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Manage apps setting absent");
			return false;
		}		
	}
	
	public void clickKeyboardShortcuts(){                   // Clicked on the Keyboard Shortcuts under setting drop down
		
	    keyboardShortcuts.click();
		log.info("Clicked on the Keyboard Shortcuts under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Keyboard Shortcuts under setting drop down");
	}
	
	public boolean keyboardShortutsPresent(){                    // Check if Keyboard Shortcuts inside drop-down present
		if(keyboardShortcuts != null){
			test.log(LogStatus.PASS, "Keyboard Shortcuts setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Keyboard Shortcuts setting absent");
			return false;
		}		
	}
	
	public void clickKeyboardShortcutsClose(){                   // Clicked on the Keyboard Shortcuts Modal Close (x) Button
		
	    keyboardShortcutsClose.click();
		log.info("Clicked on the Keyboard Shortcuts Modal Close (x) Button");
		test.log(LogStatus.INFO, "Clicked on the Keyboard Shortcuts Modal Close (x) Button");
	}
	
	public boolean keyboardShortcutsTitleDisplayed(){            // Check if Keyboard Shortcuts Modal is Displayed
		if(keyboardShortcutsTitle.isDisplayed()){
			test.log(LogStatus.PASS, "Keyboard Shortcuts modal is open");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Keyboard Shortcut modal is not open");
			return false;
		}
	}
	
	public void clickContactSupport(){                   // Clicked on the Contact Support under setting drop down
		
	    contactSupport.click();
		log.info("Clicked on the Contact Support under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Contact Support under setting drop down");
	}
	
	public boolean contactSupportPresent(){                    // Check if Contact Support inside drop-down present
		if(contactSupport != null){
			test.log(LogStatus.PASS, "Contact Support setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Contact Support setting absent");
			return false;
		}		
	}
	
	public boolean contactSupportdefaulttoggleDisplayed(){            // Check if Contact Support Modal is Displayed
		if(contactSupporttoggle.isDisplayed()){
			test.log(LogStatus.PASS, "Contacat Support modal is open");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Contact Support modal is not open");
			return false;
		}
	}
	
	public void clickContactSupportClose(){                   // Clicked on the Contact Support Modal Close (x) Button
		
	    contactSupportClose.click();
		log.info("Clicked on the Contact Support Modal Close (x) Button");
		test.log(LogStatus.INFO, "Clicked on the Contact Support Modal Close (x) Button");
	}
	
	public void clickReportBug(){                   //Clicked on the Report a Bug under setting
		
	    reportBug.click();
		log.info("Clicked on the Report a Bug under setting");
		test.log(LogStatus.INFO, "Clicked on the Report a Bug under setting");
	}
	
	public boolean reportBugPresent(){                    // Check if Report Bug inside drop-down present
		if(reportBug != null){
			test.log(LogStatus.PASS, "Report Bug setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Report Bug setting absent");
			return false;
		}		
	}
	
	public boolean reportBugdefaulttoggleDisplayed(){            // Check if Contact Support Modal is Displayed
		if(reportBugtoggle.isDisplayed()){
			test.log(LogStatus.PASS, "Report Bug modal is open");
			return true;
		}else{
			test.log(LogStatus.FAIL, "report Bug modal is not open");
			return false;
		}
	}
	
	public void clickManageTeam(){                   // Clicked on the Manage your team under setting drop down
		
	    manageTeam.click();
		log.info("Clicked on the Manage your team under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Manage your team under setting drop down");
	}
	
	public boolean manageTeamDisplayed(){                    // Check if Manage your team inside drop-down present
		if(manageTeam.isDisplayed()){
			test.log(LogStatus.PASS, "Manage your team setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Manage your team setting absent");
			return false;
		}		
	}
	
	public void clickProfileAndAccount(){                   //Clicked on the Profile and Account under setting drop down
		
		profileAndAccount.click();
		log.info("Clicked on the Profile and Account under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Profile and Account under setting drop down");
	}
	
	public boolean profileAndAccountPresent(){                    // Check if Profile and Account inside drop-down present
		if(profileAndAccount != null){
			log.info("Profile and Account setting present");
			test.log(LogStatus.PASS, "Profile and Account setting present");
			return true;
		}else{
			log.error("Profile and Account setting absent");
			test.log(LogStatus.FAIL, "Profile and Account setting absent");
			return false;
		}		
	}
	
	public void clickAddTeam(){                   // Clicked on the Add new team under setting drop down
		
	    addTeam.click();
		log.info("Clicked on the Add new team under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Add new team under setting drop down");
	}
	
	public boolean addTeamPresent(){                    // Check if Add new team inside drop-down present
		if(addTeam != null){
			test.log(LogStatus.PASS, "Add new team setting present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Add new team setting absent");
			return false;
		}		
	}
	
	public void clickAddTeamClose(){                   // Clicked on the Add new team Close button
		
	    addTeamClose.click();
		log.info("Clicked on the Add new team Close button");
		test.log(LogStatus.INFO, "Clicked on the Add new team Close button");
	}
	
	public boolean addTeamTitleDisplayed(){            // Check if Add new team Modal is Displayed
		if(AddTeamTitle.isDisplayed()){
			test.log(LogStatus.PASS, "Add new team modal is open");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Add new team modal is not open");
			return false;
		}
	}
	
	public boolean settingDropdownFooterPresent(){                    // Check if setting drop down footer present
		if(settingDropdownFooter != null){
			test.log(LogStatus.PASS, "Setting drop down footer present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Setting drop down footer absent");
			return false;
		}		
	}
	
	public void clickSettingDropdownFooter(){                   //Clicked on the setting drop down footer
		
	    settingDropdownFooter.click();
		log.info("Clicked on the setting drop down footer");
		test.log(LogStatus.INFO, "Clicked on the setting drop down footer");
	}
	
	public void clickLanguageSettingCancel(){                   //Clicked on the language setting cancel
		
	    languageSettingCancel.click();
		log.info("Clicked on the language setting cancel");
		test.log(LogStatus.INFO, "Clicked on the language setting cancel");
	}
	
	public boolean languageSettingTitleDisplayed(){            // Check if Language setting Modal is Displayed
		if(languageSettingTitle.isDisplayed()){
			test.log(LogStatus.PASS, "Language setting modal is open");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Language setting modal is not open");
			return false;
		}
	}
	
	public boolean editIconPresent(){                    // Check if Edit Icon present
		if(editIcon != null){
			test.log(LogStatus.PASS, "Edit Icon present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Edit Icon absent");
			return false;
		}		
	}
	
	public void clickEditIcon(){                   // Clicked on the Edit Icon under setting drop down
		
	    editIcon.click();
		log.info("Clicked on the Edit icon under setting drop down");
		test.log(LogStatus.INFO, "Clicked on the Edit Icon under setting drop down");
	}
	
	public void clickCustomStatusField(){                   // Clicked on the Custom status field under Edit Profile
		
	    customStatusField.click();
		log.info("Clicked on the Custom status field under Edit Profile");
		test.log(LogStatus.INFO, "Clicked on the Custom status field under Edit Profile");
	}
	
	public void clickEditProfileClose(){                   // Clicked on the Edit profile Close button
		
	    editProfileClose.click();
		log.info("Clicked on the Edit profile Close button");
		test.log(LogStatus.INFO, "Clicked on the Edit profile Close button");
	}
	
	public void clickStatusUpdateButton(){                   // Clicked on the status update button inside Edit Profile
		
	    statusUpdateButton.click();
		log.info("Clicked on the status update button inside Edit Profile");
		test.log(LogStatus.INFO, "Clicked on the status update button inside Edit Profile");
	}
	
	public boolean contactAvatarStatus1Displayed(){   // Check correct status shown below contact avatar
		
		try{
		if(contactAvatarStatus_1.isDisplayed()){
			test.log(LogStatus.PASS, "Correct Status shown below contact avatar");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Correct Status shown below contact avatar");
		}
			return false;
		
	}
	
	public boolean contactAvatarStatus2Displayed(){            // Check correct status shown below contact avatar
		if(contactAvatarStatus_2.isDisplayed()){
			test.log(LogStatus.PASS, "Correct Status shown below contact avatar");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Correct Status shown below contact avatar");
			return false;
		}
	}
	
	public void clearCustomStatusField(){                   // Cleared the Custom status field under Edit Profile
		
	    customStatusField.clear();
		log.info("Cleared the Custom status field under Edit Profile");
		test.log(LogStatus.INFO, "Cleared the Custom status field under Edit Profile");
	}
	
	public boolean statusButtonAfterClickDisplayed(){            // Check update status button after click
		if(statusUpdateButtonAfterClick.isDisplayed()){
			test.log(LogStatus.PASS, "Update Button transistion after click was succesful");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Update Button transistion after click was succesful");
			return false;
		}
	}
	
	public void clickUserNameEditProfile(){                   // Clicked on the user name inside Edit Profile
		
	    userNameEditProfile.click();
		log.info("Clicked on the user name inside Edit Profile");
		test.log(LogStatus.INFO, "Clicked on the user name inside Edit Profile");
	}
	
	public void clearFirstNameEditProfile(){                   // Cleared the first name under Edit Profile
		
	    firstNameEditProfile.clear();
		log.info("Cleared the first name under Edit Profile");
		test.log(LogStatus.INFO, "Cleared the first name under Edit Profile");
	}

	public void clearLastNameEditProfile(){                   // Cleared the last name under Edit Profile
	
    lastNameEditProfile.clear();
	log.info("Cleared the last name under Edit Profile");
	test.log(LogStatus.INFO, "Cleared the last name under Edit Profile");
	}

	public void clearMobileNumberEditProfile(){                   // Cleared the mobile number under Edit Profile
	
    mobileNumberEditProfile.clear();
	log.info("Cleared the mobile number under Edit Profile");
	test.log(LogStatus.INFO, "Cleared the mobile number under Edit Profile");
	}
	
	public void clickSaveEditProfile(){                   // Clicked on the save button inside Edit Profile
		
	    saveEditProfile.click();
		log.info("Clicked on the save button inside Edit Profile");
		test.log(LogStatus.INFO, "Clicked on the save button inside Edit Profile");
	}
	
	public void resetUserDetails() throws Exception{
		clickSettingDropDwon();
		clickEditIcon();
		Thread.sleep(2000);
    	clickUserNameEditProfile();
    	clearFirstNameEditProfile();
    	firstNameEditProfile.sendKeys("Flockdesktop1");
    	clearLastNameEditProfile();
    	lastNameEditProfile.sendKeys("TestUser");
    	clearMobileNumberEditProfile();
    	mobileNumberEditProfile.sendKeys("1234567890");
    	clickSaveEditProfile();
    	Thread.sleep(2000);
	}
	
	public boolean firstNameErrorDisplayed(){            // First name error message is displayed
		if(firstNameError.isDisplayed()){
			test.log(LogStatus.PASS, "First name error message is displayed");
			return true;
		}else{
			test.log(LogStatus.FAIL, "First name error message is displayed");
			return false;
		}
	}
	
	public boolean lastNameErrorDisplayed(){            // Last name error message is displayed
		if(lastNameError.isDisplayed()){
			test.log(LogStatus.PASS, "Last name error message is displayed");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Last name error message is displayed");
			return false;
		}
	}
	
	public boolean phoneNumberErrorDisplayed(){            // Phone Number error message is displayed
		if(lastNameError.isDisplayed()){
			test.log(LogStatus.PASS, "Phone Number error message is displayed");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Phone Number error message is displayed");
			return false;
		}
	}
	
	public boolean emailFieldDisplayed(){            // Email Field is displayed
		if(emailFieldEditProfile.isDisplayed()){
			test.log(LogStatus.PASS, "Email Field is displayed");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Email Field is not displayed");
			return false;
		}
	}
	
	public void clickBrowseChannelsRoster(){                   // Clicked on the Channels icon under Roster
		
	    rosterBrowseChannels.click();
		log.info("Clicked on the Channels icon under Roster");
		test.log(LogStatus.INFO, "Clicked on the Channels icon under Roster");
	}
	
	public void openChannelRoster(String channelName) throws Exception{   //Open a channel from Roster
		rosterBrowseChannels.click();
		Thread.sleep(1000);
		 WebElement channel = driver.findElement(By.xpath("//span[@class='dijitTreeLabel' and contains(text(),'" + channelName +"')]"));
		 channel.click();
	}
	
	public void clickSlashAddCommand(){                   // Clicked on the slash Add Command
		
	    slashAdd.click();
		log.info("Clicked on the slash Add Command");
		test.log(LogStatus.INFO, "Clicked on the slash Add Command");
	}
	
	public boolean slashAddDisplayed(){            // Slash Add is displayed
		try{if(slashAdd.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Add Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Add Command is not displayed");
		}
		return false;
	}
	
	public boolean slashAddParamDisplayed(){            // Slash Add Parameter is displayed
		try{if(slashAddParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Add Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Add Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashAddDescriptionDisplayed(){            // Slash Add Description is displayed
		try{if(slashAddDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Add Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Add Command Description is not displayed");
		}
		return false;
	}
	
	public void clickSlashAdd(){                   // Clicked on the Slash Add Command
		
	    slashAdd.click();
		log.info("Clicked on the Slash Add Command");
		test.log(LogStatus.INFO, "Clicked on the Slash Add Command");
	}
	
	public boolean channelMemberListIconPresent(){                    // Channel Member list Icon Present
		if(channelMemberListIcon != null){
			test.log(LogStatus.PASS, "Channel Member list Icon Present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Channel Member list Icon Present");
			return false;
		}		
	}
	
	public void clickChannelMemberListIcon(){                   // Clicked on the Channel member list Icon
		
	    channelMemberListIcon.click();
		log.info("Clicked on the Channel member list Icon");
		test.log(LogStatus.INFO, "Clicked on the Channel member list Icon");
	}
	
	public void removeFromChannel(String userName) throws Exception{                   //Remove a user from Channel using  channel member list drop-down
		Actions action = new Actions(driver);
		WebElement user = driver.findElement(By.xpath("//div[@class='memberName' and contains(text(),'" + userName + "')]"));
		action.moveToElement(user).build().perform();
		Thread.sleep(1000);
		WebElement dropdown = driver.findElement(By.xpath("//span[contains(@class,'optionsButton') and not(contains(@style,'display: none'))]"));
		action.moveToElement(dropdown).click().build().perform();
	    Thread.sleep(2000);
	    removeFromChannelButton.click();
	    log.info("Clicked on Remove from Channel Button under Channel member list drop-down");
		test.log(LogStatus.INFO, "Clicked on Remove from Channel Button under Channel member list drop-down");
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    log.info("Switched bax to default frame");
		test.log(LogStatus.INFO, "Switched bax to default frame");
	    Thread.sleep(1000);
	    removeFromChannelConfirmation.click();
	    log.info("Clicked on the confirmation button inside remove from Channel confirmation box");
		test.log(LogStatus.INFO, "Clicked on the confirmation button inside remove from Channel confirmation box");
	    Thread.sleep(1000);
		driver.switchTo().frame(appIframe);
		log.info("Switched to chat tab iFrame");
		test.log(LogStatus.INFO, "Switched to chat tab iFrame");
		clickChannelMemberListIcon();
		int user1 = driver.findElements(By.xpath("//div[@class='memberName' and contains(text(),'" + userName + "')]")).size();
		if(user1 > 0 ){
			log.info("User was not Removed from the Channel");
			test.log(LogStatus.FAIL, "User was not Removed from the Channel");
		}else{
			log.info("User was Removed successfully from the Channel");
			test.log(LogStatus.PASS, "User was Removed successfully from the Channel");
		}
		//driver.switchTo().defaultContent();
		clickChannelMemberListIcon();
	}
	
	public boolean slashMuteDisplayed(){            // Slash Mute is displayed
		try{if(slashMute.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Mute Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Mute Command is not displayed");
		}
		return false;
	}
	
	public boolean slashUnmuteDisplayed(){            // Slash Unmute is displayed
		try{if(slashUnmute.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Unmute Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Unmute Command is not displayed");
		}
		return false;
	}
	
	public boolean slashShortcutsDisplayed(){            // Slash Shortcuts is displayed
		try{if(slashShortcuts.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Shortcut Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Shortcut Command is not displayed");
		}
		return false;
	}
	
	public boolean slashLeaveDisplayed(){            // Slash Leave is displayed
		try{if(slashLeave.isDisplayed()){
			test.log(LogStatus.PASS, "Slash leave Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash leave Command is not displayed");
		}
		return false;
	}
	
	public boolean slashLeaveDescriptionDisplayed(){            // Slash Leave Description is displayed
		try{if(slashLeaveDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Leave Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Leave Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashMuteParamDisplayed(){            // Slash Mute Parameter is displayed
		try{if(slashMuteParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Mute Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Mute Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashMuteDescriptionDisplayed(){            // Slash Mute Description is displayed
		try{if(slashMuteDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Mute Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Mute Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashUnmuteParamDisplayed(){            // Slash Unmute Parameter is displayed
		try{if(slashUnmuteParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Unmute Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Unmute Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashUnmuteDescriptionDisplayed(){            // Slash Unmute Description is displayed
		try{if(slashUnmuteDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Unmute Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Unmute Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashShortcutDescriptionDisplayed(){            // Slash Unmute Description is displayed
		try{if(slashShortcutsDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Shortcut Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Shortcut Command Description is not displayed");
		}
		return false;
	}
	
	public void clickSlashMute(){                   // Clicked on the Slash Mute Command
		
	    slashMute.click();
		log.info("Clicked on the Slash Add Command");
		test.log(LogStatus.INFO, "Clicked on the Slash Add Command");
	}
	
	public boolean muteIconPresent(){                    // Mute Icon Present
		if(muteIcon != null){
			test.log(LogStatus.PASS, "Mute Icon Present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Mute Icon not Present");
			return false;
		}		
	}
	
	public boolean unmuteIconPresent(){                    // Unmute Icon Present
		if(unmuteIcon != null){
			test.log(LogStatus.PASS, "Unmute Icon Present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Unmute Icon not Present");
			return false;
		}		
	}
	
	public boolean slashStatusDisplayed(){            // Slash Status is displayed
		try{if(slashStatus.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Status Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Status Command is not displayed");
		}
		return false;
	}
	
	public boolean slashStatusParamDisplayed(){            // Slash Status Parameter is displayed
		try{if(slashStatusParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Status Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Status Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashStatusDescriptionDisplayed(){            // Slash Status Description is displayed
		try{if(slashStatusDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Status Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Status Command Description is not displayed");
		}
		return false;
	}
	
	public boolean leaveChannelConfirmationTitlePresent(){                    // Leave Channel Confirmation Box title present
		if(leaveChannelConfirmationTitle != null){
			test.log(LogStatus.PASS, "Leave Channel Confirmation Box title present");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Leave Channel Confirmation Box title present");
			return false;
		}		
	}
   
	public void clickCancelButton(){                   // Clicked on the Cancel Button
		
	    cancelButton.click();
		log.info("Clicked on the Cancel Button");
		test.log(LogStatus.INFO, "Clicked on the Cancel Button");
	}
	
	public boolean slashCloneDescriptionDisplayed(){            // Slash Clone Description is displayed
		try{if(slashCloneDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Clone Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Clone Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashCloneDisplayed(){            // Slash Clone is displayed
		try{if(slashClone.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Clone Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Clone Command is not displayed");
		}
		return false;
	}
	
	public void clickYesCloneButton(){                   // Clicked on the Yes clone Button
		
	    yesCloneButton.click();
		log.info("Clicked on the Yes clone Button");
		test.log(LogStatus.INFO, "Clicked on the Yes clone Button");
	}
	
	public boolean cloneTitlePresent(){                    // Clone confirmation box title visible
		if(cloneTitle != null){
			test.log(LogStatus.PASS, "Clone confirmation box title visible");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Clone confirmation box title not visible");
			return false;	
		}
	}
	
	public boolean cloneChannelTextEditorPresent(){                    // Clone Channel Text editor visible
		if(cloneChannelTextEditor != null){
			test.log(LogStatus.PASS, "Clone Channel Text editor visible");
			return true;
		}else{
			test.log(LogStatus.FAIL, "Clone Channel Text editor not visible");
			return false;
			
		}
	}
	
	public void clickLeaveDeleteChannelButton(){                   //Clicked on the Yes Leave and Delete Button
		
	    leaveDeleteChannelButton.click();
		log.info("Clicked on the Yes Leave and Delete Button");
		test.log(LogStatus.INFO, "Clicked on the Yes Leave and Delete Button");
	}
	
	public boolean slashRemindDisplayed(){            // Slash Remind is displayed
		try{if(slashRemind.isDisplayed()){
			test.log(LogStatus.PASS, "Slash remind Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash remind Command is not displayed");
		}
		return false;
	}
	
	public boolean slashRemindParamDisplayed(){            // Slash Remind Parameter is displayed
		try{if(slashRemindParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Remind Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash remind Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashRemindDescriptionDisplayed(){            // Slash Remind Description is displayed
		try{if(slashRemindDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash remind Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash remind Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashVideoDisplayed(){            // Slash Video is displayed
		try{if(slashVideo.isDisplayed()){
			test.log(LogStatus.PASS, "Slash video Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash video Command is not displayed");
		}
		return false;
	}
	
	public boolean slashVideoParamDisplayed(){            // Slash Video Parameter is displayed
		try{if(slashVideoParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Video Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash video Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashVideoDescriptionDisplayed(){            // Slash Video Description is displayed
		try{if(slashVideoDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash video Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash video Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashPollDisplayed(){            // Slash Poll is displayed
		try{if(slashPoll.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Poll Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Poll Command is not displayed");
		}
		return false;
	}
	
	public boolean slashPollParamDisplayed(){            // Slash Poll Parameter is displayed
		try{if(slashPollParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Poll Command Parameter is displayed");
			log.info("Slash Poll Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Poll Command Parameter is not displayed");
			log.error("Slash Poll Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashPollDescriptionDisplayed(){            // Slash Poll Description is displayed
		try{
			if(slashPollDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Poll Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Poll Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashTodoDisplayed(){            // Slash Todo is displayed
		try{
			if(slashTodo.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Todo Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Todo Command is not displayed");
		}
		return false;
	}
	
	public boolean slashTodoParamDisplayed(){            // Slash Todo Parameter is displayed
		try{
			if(slashTodoParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Todo Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Todo Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashTodoDescriptionDisplayed(){            // Slash Todo Description is displayed
		try{
			if(slashTodoDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Todo Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Todo Command Description is not displayed");
		}
		return false;
	}
	
	public boolean slashGiphyDisplayed(){            // Slash Giphy is displayed
		try{
			if(slashGiphy.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Giphy Command is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Giphy Command is not displayed");
		}
		return false;
	}
	
	public boolean slashGiphyParamDisplayed(){            // Slash Giphy Parameter is displayed
		try{
			if(slashGiphyParam.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Giphy Command Parameter is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Giphy Command Parameter is not displayed");
		}
		return false;
	}
	
	public boolean slashGiphyDescriptionDisplayed(){            // Slash Giphy Description is displayed
		try{
			if(slashTodoDesc.isDisplayed()){
			test.log(LogStatus.PASS, "Slash Giphy Command Description is displayed");
			return true;
		}
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Slash Giphy Command Description is not displayed");
		}
		return false;
	}
	

	public boolean frequentDisplayed(){            // frequent button is displayed
		if(frequentbutton.isDisplayed()){
			test.log(LogStatus.PASS, " frequent button is displayed");
			return true;
		}
		else{
			test.log(LogStatus.FAIL, " frequent button is not displayed");
			return false;
		}
	}
	
	/*public boolean appSidebarActiveHistorySearchAbsent(){                    //History search is active in app sidebar
		if(appSidebarActiveHistorySearch == null){
			log.info("History Search is active on app side bar");
			test.log(LogStatus.PASS, "History Search is active on app side bar");
			return true;
		}else{
			log.error("History Search is not active on app side bar");
			test.log(LogStatus.FAIL, "History Search is not active on app side bar");
			return false;
			
		}
	}*/
	
	public boolean hisotrySearchTitleDisplayed(){            // History Search Title
		if(historySearchTitle.isDisplayed()){
			log.info("History search title is displayed");
			test.log(LogStatus.PASS, " History search title is displayed");
			return true;
		}
		else{
			log.error("History search title is not displayed");
			test.log(LogStatus.FAIL, "History search title is not displayed");
			return false;
		}
	}
	

	@FindBy(xpath="//span[@class='text' and contains(text(),'/giphy Test')]")
	public WebElement giphyActiveChatArea;
	
	public boolean giphyDisplayed(){   // Check if giohy is displayed in active chat area
		try{
			giphyActiveChatArea.isDisplayed();
			test.log(LogStatus.PASS, "Giphy is displayed in active chat area");
			return true;
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Giphy is not displayed in active chat area");
			log.error("Giphy is not displayed in active chat area");
			return false;	
		}
	}
	
	@FindBy(xpath="//div[@class='memberName' and contains(text(),'Flockdesktop')]")  //member name under group dropdown 
	public WebElement memberNameGroupDropdown;
	
	public boolean memberNameGroupDropdownDisplayed(){   // Member is displayed under group drop down member list
		try{
			memberNameGroupDropdown.isDisplayed();
			test.log(LogStatus.PASS, "Member is displayed under group drop down member list");
			return true;
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Member is not displayed under group drop down member list");
			return false;	
		}
		
	}
	
	@FindBy(xpath="//div[contains(@class,'has-unread-message')]//div[@class='channel-name' and contains(text(),'Slash Command Test Channel')]")  //reminder bot notification under active chat area 
	public WebElement reminderActiveChatArea;
	
	public boolean reminderActiveChatAreaDisplayed(){   //reminder bot notification under active chat area
		try{
			reminderActiveChatArea.isDisplayed();
			test.log(LogStatus.PASS, "Reminder bot notification is displayed under active chat area");
			return true;
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Reminder bot notification is NOT displayed under active chat area");
			return false;	
		}
	}
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .message_text>span>div")
	public List<WebElement> toDoBotMessage;
	
	
}
		


