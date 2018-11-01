package com.utilities;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class clientElement extends BaseTestSuite {
	ExtentTest test;
	WebDriver driver;
	WebElement element = null;

	// private static GenericMethods gm ;
	private static final Logger log = LogManager.getLogger(clientElement.class.getName());

	public clientElement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "shell_plus_PlusWidget_0") // + icon in the universal search
											// bar
	public WebElement univerlSearchPlusIcon;

	@FindBy(xpath = "//div[@class='plus-item__icon group']") // channel creation
																// button in
																// searchPlus
	WebElement searchPlusCreateChannelButton;

	@FindBy(xpath = "//span[@class='modal-box__close']") // channel creation
															// cancel button
	WebElement startNewChannelCancel;

	@FindBy(xpath = "//div[@class='plus-item__icon join_channel']") // Join
																	// channel
																	// button in
																	// searchPlus
	WebElement searchPlusJoinChannelButton;

	@FindBy(xpath = "//div[contains(@class,'group-discovery')]//span[contains(@role,'button')]") // Join
																									// channel
																									// cancel
																									// button
	WebElement joinChannelCancel;

	@FindBy(xpath = "//div[@class='plus-item__icon invite']") // Invite button
																// in searchPlus
	WebElement searchPlusInviteButton;

	@FindBy(id = "close-btn") // Invite modal cancel button
	WebElement inviteContactCancel;

	@FindBy(xpath = "//div[contains(@class,'app_menu_invite')]") // Invite hook
																	// above
																	// setting
																	// dropdown
	WebElement inviteAppMenu;

	@FindBy(className = "invite__contacts") // Invite hook in roster
	WebElement inviteRoster;

	@FindBy(xpath = "//div[contains(@class,'dm-contacts')]//div[@id='newChannel']") // Invite hook in in recent tab
	WebElement inviteRecent;

	@FindBy(className = "conv-search__editor") // Universal search bar editor area
	public WebElement universalSearchBarEditor;

	@FindBy(className = "search__handle-search") // Magnify glass in universal search bar
	WebElement universalSearchBarIcon;

	@FindBy(xpath = "//li[contains(@class,'temp_search') and contains(@style,'display: block;')]")
	WebElement inviteContactUniversalSearchBar;

	@FindBy(xpath = "//li[contains(@class,'temp_search') and contains(@style,'display: block;')]")
	WebElement inviteContactIconUniversalSearch;

	@FindBy(xpath = "//div[@id='super-container']") // Invite contact modal
	WebElement inviteContactModal;

	@FindBy(id = "invite-btn") // Invite button in the invite modal
	WebElement inviteModalInviteButton;

	@FindBy(xpath = "//div[@id='invite-container']/div[2]/input") // Input
																	// fields in
																	// the
																	// invite
																	// modal
	WebElement inviteModalInputField;

	@FindBy(xpath = "//div[@id='convSearch']") // Universal Search Field
	public WebElement universalSearch;

	@FindBy(xpath = "//div[@id='shell_teamSwitcher_Team_0']") // First team in
																// the team
																// switcher bar
	WebElement primaryTeam;

	@FindBy(xpath = "//div[@id='shell_teamSwitcher_Team_1']") // Team with empty
																// contact list
	WebElement emptyContactTeam;

	@FindBy(xpath = "//div[contains(@class,'openContacts')]") // Contact tab in
																// roster
	WebElement rosterContactTab;

	@FindBy(xpath = "//div[contains(@class,'openGroups')]") // Channel tab in roster
	WebElement rosterChannelTab;

	@FindBy(xpath = "//div[contains(@class,'openRecent')]") // Recent tab in roster
	WebElement rosterRecentTab;

	@FindBy(xpath = "//div[contains(@class,'roster__invite__contact protip-item')]") // invite contact hook in contact tab																					
	WebElement inviteHookContactTab;

	@FindBy(xpath = "//input[@placeholder='Search for Contacts']") // contact search in contact tab
	WebElement searchFieldContactTab;

	@FindBy(id = "team-members")
	WebElement forkModal;

	@FindBy(id = "team-members")
	WebElement fullMember;

	@FindBy(xpath = "//div[contains(@class,'invite-image') and contains(@class,'invite-guests')]")
	WebElement guestMember;

	@FindBy(id = "back-btn")
	WebElement backButtonInviteModal;

	@FindBy(xpath = "//input[@id='email-input']")
	WebElement EmailFieldImportScreen;

	@FindBy(xpath = "//button[@id='invite-emails']")
	WebElement sendButtonFieldImportScreen;

	@FindBy(xpath = "//input[@id='search-filter']")
	WebElement googleImportSearchField;

	@FindBy(xpath = "//div[@class='profile-btn']")
	WebElement inviteButtonGoogleImport;

	@FindBy(id = "invite-container")
	WebElement fullMemberInviteContainer;

	@FindBy(id = "invite-guest-btn")
	WebElement guestInviteButton;

	@FindBy(id = "invite-more")
	WebElement guestInviteMoreButton;

	@FindBy(id = "reminder-title")
	WebElement validityReminder;

	@FindBy(id = "reminder-input")
	WebElement validityReminderField;

	@FindBy(xpath = "//div[contains(@class,'datepicker') and contains(@style,'display: block; left: 0px;')]")
	WebElement validityDatePicker;

	@FindBy(xpath = "//div[@id='input-list']/div[1]/input")
	WebElement guestInputField;

	@FindBy(id = "contact-input")
	WebElement guestContactAccessField;

	@FindBy(id = "owner-name")
	WebElement ownerNameGuestAccess;

	@FindBy(id = "channel-input")
	WebElement guestChannelAccessField;

	@FindBy(id = "new-channel-link")
	WebElement guestNewChannelCreate;

	@FindBy(id = "new-channel-name")
	WebElement guestNewChannelField;

	@FindBy(id = "create-channel-btn")
	WebElement guestCreateChannelButton;

	@FindBy(id = "done-btn")
	WebElement doneButtonGuestAccess;

	@FindBy(id = "contact-list")
	WebElement guestAccessMagicList;

	@FindBy(id = "globalButtonApps") // First team in the team switcher bar
	WebElement globalAppSidebar;
	
	@FindBy(xpath="//div[contains(@class,'app-item--recent')]") //roster icon in the side bar
	public WebElement rosterSideBar;
	
	@FindBy(xpath="//div[contains(@class,'group-contacts')]//div[@id='newChannel']") //New Channel hook in roster
	WebElement newChannelHookRoster;
	
	@FindBy(className="roster__actions__text") //Join channel hook in roster
	WebElement joinChannelHookRoster;
	
	@FindBy(xpath="//div[@class='group-discovery-list']//input")
	public WebElement joinChannelSearchField;
	
	@FindBy(xpath="//div[@class='groupItem']//div[@class='joinGroup']")
	public WebElement joinChannelButton;
	
	@FindBy(xpath="//div[contains(@class,'group-discovery')]//span[@class='dijitDialogCloseIcon']") //Close icon in the discover channel modal
	WebElement cancelHookDiscoverChannel;
	
	@FindBy(xpath="//div[@id='createGroupRecent']//span[@data-dojo-attach-point='openGroupsCount']")
	public WebElement joinChannelCount;
	
	@FindBy(xpath="//div[contains(@class,'openGroups')]/span[@class='roster-image']")//Channel tab icon in roster
	WebElement channelTab;
	
	@FindBy(xpath="//div[contains(@class,'roster__create__group')]")
	WebElement createChannelPlusIcon;
	
	@FindBy(xpath="//div[contains(@class,'groups-all-empty')]")
	WebElement emptyStateChannelTab;
	
	@FindBy(xpath="//a[contains(@class,'btn--action')]")
	WebElement createChannelEmptyState;
	
	@FindBy(className="rosterSearch__input")
	WebElement channelTabSearchField;
	
	@FindBy(xpath="//div[contains(@class,'openContacts')]")
	WebElement contactTab;
	
	@FindBy(xpath="//div[contains(@class,'roster__invite__contact')]")
	WebElement contactTabInvite;
	
	@FindBy(xpath="//input[@placeholder='Search for Contacts']")
	WebElement contactTabSearchField;
	
	@FindBy(xpath="//div[contains(@class,'roster__create__group')]")
	public WebElement channelTabCreateChannelHook;

	@FindBy(xpath="//div[contains(@class,'group-contacts')]//div[@id='newChannel']")
	WebElement recentsNewChannel;
	
	@FindBy(xpath="//a[@class='new-channel']")
	WebElement createChannelJoinModal;
	
	@FindBy(xpath="//div[contains(@class,'groups-all-empty')]")
	WebElement channelEmptyState;
	
	@FindBy(xpath="//div[@class='emptyRosterDiv']/a")
	WebElement ChannelEmptyStateButton;

	@FindBy(xpath="//div[contains(@class,'active-bucket')]")
	public WebElement activeChat;
	
	@FindBy(xpath="//div[@data-dojo-attach-point='activeBucketInvite']")
	public WebElement activeChatInvite;
	
	@FindBy(xpath="//div[contains(@class,'theme-desktop') and contains(@class,'page-wrapper')]")
	public WebElement guestSucessPage;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .overlay-menu-arrow")
	public List<WebElement> messageActionDropDown;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .message_text")
	public List<WebElement> lastMessage;
	
	@FindBy(css=".flockml-action-link")
	public List<WebElement> flockmlMessage;
	
	@FindBy(xpath="//div[@data-buttonid='app___ack']")
	public List<WebElement> reminderViewButton;
	
	@FindBy(xpath="//div[contains(@class,'attachment_button--custom_icon')]")
	public List<WebElement> messageActionButtonList;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .minute_child:last-child .chat_message .chat_message_body .attachmentContainerDiv .attachmentDiv")
	public List <WebElement> lastToDoMessage;
	
	@FindBy(xpath="//div[@title='Reminders']//span[@role='button']")
	public WebElement snoozeReminderCancel;
	
	@FindBy(xpath="//div[contains(@data-dojo-attach-point,'titleBar') and contains(@title,'Reminders') ]")
	public WebElement snoozeReminderModal;
	
	@FindBy(xpath="//div[contains(@data-dojo-attach-point,'titleBar') and contains(@title,'Reactions') ]")
	public WebElement reactionModal;
	
	@FindBy(xpath="//div[@data-buttonid='editIcon']")
	public List<WebElement> editMessageIconList;
	
	@FindBy(xpath="//span[contains(@class,'edited-label')]")
	public List<WebElement> editedLabelList;
	
	@FindBy(xpath="//button[contains(@class,'btn--red')]")
	public WebElement deleteMessageButton;

	
	@FindBy(xpath="//div/a[text()='item']")
	public List<WebElement> pinItemLinks;
	
	@FindBy(xpath="//div/a[text()='Files']")
	public List<WebElement> pinFilesLinks;
	
	public boolean univerlSearchPlusIconPresent() {
		if (univerlSearchPlusIcon != null) {
			log.info("The universal SearchPlus Icon is present");
			test.log(LogStatus.INFO, "The universal SearchPlus Icon is present");
			return true;
		} else {
			log.info("The universal SearchPlus Icon is present");
			test.log(LogStatus.FAIL, "The universal SearchPlus Icon is present");
			return false;
		}
	}

	public void clickUniverlSearchPlusIcon() {
		if (univerlSearchPlusIcon.getSize() != null) {

			univerlSearchPlusIcon.click();
			log.info("Clicked on the Universal Search Button");
			test.log(LogStatus.INFO, "Clicked on the sUniversal Search Button");
		} else {
			log.info("Not clicked on the Universal Search Button");
			test.log(LogStatus.INFO, "Not clicked on the Universal Search Button");
		}
	}

	public void clickSearchPlusCreateChannel() {
		if (searchPlusCreateChannelButton.getSize() != null) {
			searchPlusCreateChannelButton.click();
			test.log(LogStatus.INFO, "The Create Channel Option is clicked");
			log.info("The Create Channel Option is not clicked");
		} else {
			test.log(LogStatus.ERROR, "The Create Channel Option is not clicked");
			log.info("The Create Channel Option is not clicked");
		}
	}

	public void clickStartChannelModalClose() {
		if (startNewChannelCancel.getSize() != null) {
			startNewChannelCancel.click();
			test.log(LogStatus.INFO, "The Cancle option in StartNewChannel Modal is clicked");
			log.info("The Cancle option in StartNewChannel Modal is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Cancle option in StartNewChanne Modal is not clicked");
			log.info("The Cancle option in StartNewChannel Modal is not clicked");
		}
	}

	public void clickSearchPlusJoinChannel() {
		if (searchPlusJoinChannelButton.getSize() != null) {
			searchPlusJoinChannelButton.click();
			test.log(LogStatus.INFO, "The Join Channel Button is clicked");
			log.info("The Join Channel Button is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Join Channel Button could not be clicked clicked");
			log.info("The Join Channel Button could not be clicked clicked");
		}
	}

	public void clickJoinChannelModalClose() {
		if (joinChannelCancel.getSize() != null) {
			joinChannelCancel.click();
			test.log(LogStatus.INFO, "The Cancle option in Join Channel Modal is clicked");
			log.info("The Cancle option in Join Channel Modal is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Cancle option in Join Channel Modal is not clicked");
			log.info("The Cancle option in Join Channel Modal is not clicked");
		}
	}

	public void clickSearchPlusInviteButton() {
		if (searchPlusInviteButton.getSize() != null) {
			searchPlusInviteButton.click();
			test.log(LogStatus.INFO, "The Invite Contact Button is clicked");
			log.info("The Invite Contact Button is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Invite Contact Button could not be clicked clicked");
			log.info("The Invite Contact Button could not be clicked clicked");
		}
	}

	public void clickInviteContactCancel() {
		if (inviteContactCancel.getSize() != null) {
			inviteContactCancel.click();
			test.log(LogStatus.INFO, "The Cancle option in Invite Contact Modal is clicked");
			log.info("The Cancle option in Invite Contact Modal is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Cancle option in Invite Contact Modal is not clicked");
			log.info("The Cancle option in Invite Contact Modal is not clicked");
		}
	}

	public boolean inviteAppMenuPresent() {
		if (inviteAppMenu != null) {
			log.info("The Invite hook in the App Menu is present");
			test.log(LogStatus.INFO, "The Invite hook in the App Menu is present");
			return true;
		} else {
			log.info("The Invite hook in the App Menu is present");
			test.log(LogStatus.FAIL, "The Invite hook in the App Menu is present");
			return false;
		}
	}

	public void clickinviteAppMenu() {
		if (inviteAppMenu != null) {
			inviteAppMenu.click();
			test.log(LogStatus.INFO, "The Invite Option in the App Menu is clicked");
			log.info("The Invite Option in the App Menu is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Invite Option in the App Menul is not clicked");
			log.info("The Invite Option in the App Menu is not clicked");
		}
	}

	public boolean inviteRosterPresent() {
		if (inviteRoster != null) {
			log.info("The Invite Option in Roster is present");
			test.log(LogStatus.INFO, "The Invite Option in Roster is present");
			return true;
		} else {
			log.info("The Invite Option in Roster is not present");
			test.log(LogStatus.FAIL, "The Invite Option in Roster is not present");
			return false;
		}
	}

	public void clickInviteRoster() {
		if (inviteRoster != null) {
			inviteRoster.click();
			test.log(LogStatus.INFO, "The Invite Option in the Roster is clicked");
			log.info("The Invite Option in the Roster is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Invite Option in the Roster is not clicked");
			log.info("The Invite Option in the Roster is not clicked");
		}
	}

	public boolean inviteRecentPresent() {
		if (inviteRecent != null) {
			log.info("The Invite Option in Recents is present");
			test.log(LogStatus.INFO, "The Invite Option in Recents is present");
			return true;
		} else {
			WebElement close = driver.findElement(By.id("close-btn"));
			close.click();
			log.info("The Invite Option in Recents is not present");
			test.log(LogStatus.FAIL, "The Invite Option in Recents is not present");
			return false;
		}
	}
	
	public boolean inviteRecentDisplayed() {
		if (inviteRecent.isDisplayed()) {
			log.info("The Invite Option in Recents is displayed");
			test.log(LogStatus.INFO, "The Invite Option in Recents is displayed");
			return true;
		} else {
			log.info("The Invite Option in Recents is not displayed");
			test.log(LogStatus.FAIL, "The Invite Option in Recents is not displayed");
			return false;
		}
	}

	public void clickInviteRecent() {
		if (inviteRecent != null) {
			inviteRecent.click();
			test.log(LogStatus.INFO, "The Invite Option in the Recent is clicked");
			log.info("The Invite Option in the Recent is clicked");
		} else {
			test.log(LogStatus.ERROR, "The Invite Option in the Recent is not clicked");
			log.info("The Invite Option in the Recent is not clicked");
		}
	}

	public boolean universalSearchBarEditorPresent() {
		if (universalSearchBarEditor != null) {
			log.info("The universal search bar editor is present");
			test.log(LogStatus.INFO, "The uuniversal search bar editor is present");
			return true;
		} else {
			log.info("The universal search bar editor is present");
			test.log(LogStatus.FAIL, "The universal search bar editor is present");
			return false;
		}
	}

	public void clickUniversalSearchBarEditor() {
		if (universalSearchBarEditor != null) {
			universalSearchBarEditor.click();
			test.log(LogStatus.INFO, "Clicked inside the universal search bar editor");
			log.info("Clicked inside the universal search bar editor");
		} else {
			test.log(LogStatus.ERROR, "Can not click inside the universal search bar editor");
			log.info("Can not click inside the universal search bar editor");
		}
	}

	public void universalSearchInputSendKey(String email) {
		if (universalSearchBarEditor.isDisplayed()) {
			universalSearchBarEditor.sendKeys(email);
			test.log(LogStatus.INFO, "Email ID Entered in the universal search bar");
			log.info("Email ID Entered in the universal search bar");
		} else {
			test.log(LogStatus.FAIL, "Unable to enter Email ID in the universal search bar");
			log.info("Unable to enter Email ID in the universal search bar");
		}
	}

	public void clickUniversalSearchBarIcon() {
		if (universalSearchBarIcon != null) {
			universalSearchBarIcon.click();
			test.log(LogStatus.INFO, "Clicked on the universal search magnifying glass icon");
			log.info("Clicked  on the universal search magnifying glass icon");
		} else {
			test.log(LogStatus.ERROR, "Can not click on the universal search magnifying glass icon");
			log.info("Can not click on the universal search magnifying glass icon");
		}
	}

	public boolean universalSearchBarIconPresent() {
		if (universalSearchBarIcon != null) {
			log.info("The universal search bar icon is present");
			test.log(LogStatus.INFO, "The uuniversal search bar icon is present");
			return true;
		} else {
			log.info("The universal search bar icon is present");
			test.log(LogStatus.FAIL, "The universal search bar icon is present");
			return false;
		}
	}

	public boolean inviteContactModalDisplayed() {
		if (inviteContactModal.isDisplayed()) {
			log.info("The Invite Contact Modal is displayed");
			test.log(LogStatus.INFO, "The Invite Contact Modal is displayed");
			return true;
		} else {
			log.info("The Invite Contact Modal is not displayed");
			test.log(LogStatus.FAIL, "The Invite Contact Modal is not displayed");
			return false;
		}
	}

	public boolean inviteContactModalPresent() {
		if (inviteContactModal != null) {
			log.info("The Invite Contact Modal is present");
			test.log(LogStatus.INFO, "The Invite Contact Modal is present");
			return true;
		} else {
			log.info("The Invite Contact Modal is not present");
			test.log(LogStatus.FAIL, "The Invite Contact Modal is not present");
			return false;
		}
	}

	public void inviteModalInviteButtonClick() {
		inviteModalInviteButton.click();
		log.info("The Invite Button is clicked");
		test.log(LogStatus.INFO, "The Invite Button is clicked");
	}

	public boolean googleImportSearchFieldDisplayed() {
		if (googleImportSearchField.isDisplayed()) {
			log.info("The search field on the google invite modal is displayed");
			test.log(LogStatus.INFO, "The search field on the google invite modal is displayed");
			return true;
		} else {
			log.info("The search field on the google invite modal is not displayed");
			test.log(LogStatus.FAIL, "The search field on the google invite modal is not displayed");
			return false;
		}

	}

	public void googleImportSearchFieldSendKey(String email) {
		if (googleImportSearchField.isDisplayed()) {
			googleImportSearchField.sendKeys(email);
			test.log(LogStatus.INFO, "Email ID Entered in the Invite Field");
			log.info("Email ID Entered in the Invite Field");
		} else {
			test.log(LogStatus.FAIL, "Unable to enter Email ID in the Invite Field");
			log.info("Unable to enter Email ID in the Invite Field");
		}
	}

	public void googleImportSearchFieldClear() {
		if (googleImportSearchField.isDisplayed()) {
			googleImportSearchField.clear();
			test.log(LogStatus.INFO, "The Invite Field is cleared");
			log.info("The Invite Field is cleared");
		} else {
			test.log(LogStatus.FAIL, "The Invite Field can not be cleared");
			log.info("The Invite Field can not be cleared");
		}
	}

	public void EmailFieldImportScreenSendKey(String email) {
		if (EmailFieldImportScreen.isDisplayed()) {
			EmailFieldImportScreen.sendKeys(email);
			test.log(LogStatus.INFO, "Email ID Entered in the Invite Field");
			log.info("Email ID Entered in the Invite Field");
		} else {
			test.log(LogStatus.FAIL, "Unable to enter Email ID in the Invite Field");
			log.info("Unable to enter Email ID in the Invite Field");
		}
	}

	public void EmailFieldImportScreenClear() {
		if (EmailFieldImportScreen.isDisplayed()) {
			EmailFieldImportScreen.clear();
			test.log(LogStatus.INFO, "The Invite Field is cleared");
			log.info("The Invite Field is cleared");
		} else {
			test.log(LogStatus.FAIL, "The Invite Field can not be cleared");
			log.info("The Invite Field can not be cleared");
		}
	}

	public void inviteModalInputSendKey(String email) {
		if (inviteModalInputField.isDisplayed()) {
			inviteModalInputField.sendKeys(email);
			test.log(LogStatus.INFO, "Email ID Entered in the Invite Field");
			log.info("Email ID Entered in the Invite Field");
		} else {
			test.log(LogStatus.FAIL, "Unable to enter Email ID in the Invite Field");
			log.info("Unable to enter Email ID in the Invite Field");
		}
	}

	public void inviteModalInputsClear() {
		if (inviteModalInputField.isDisplayed()) {
			inviteModalInputField.clear();
			test.log(LogStatus.INFO, "The Invite Field is cleared");
			log.info("The Invite Field is cleared");
		} else {
			test.log(LogStatus.FAIL, "The Invite Field can not be cleared");
			log.info("The Invite Field can not be cleared");
		}
	}

	public void universalSearchSendKeys(String email) throws Exception { // Search
																			// a
																			// user
																			// in
																			// Universal
																			// Search
																			// Field
																			// and
																			// Click
																			// on
																			// it
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		if (universalSearchBarEditorPresent()) {
			clickUniversalSearchBarEditor();
			actions.moveToElement(universalSearch);
			actions.click();
			actions.sendKeys(email);
			actions.build().perform();
			Thread.sleep(1000);
		}
	}

	public boolean primaryTeamDisplayed() {
		if (primaryTeam.isDisplayed()) {
			test.log(LogStatus.INFO, "The primary team in the team switcher bar is displayed");
			log.info("The primary team in the team switcher bar is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The primary team in the team switcher bar is NOT displayed");
			log.info("The primary team in the team switcher bar is NOT displayed");
			return false;
		}
	}

	public void primaryTeamClick() {
		if (primaryTeam.isDisplayed()) {
			primaryTeam.click();
			test.log(LogStatus.INFO, "The primary team icon in the team switcher bar is click");
			log.info("The primary team icon in the team switcher bar is click");
		} else {
			test.log(LogStatus.FAIL, "The primary team icon in the team switcher bar is NOT click");
			log.info("The primary team icon in the team switcher bar is NOT click");
		}
	}

	public boolean emptyContactTeamDisplayed() {
		if (emptyContactTeam.isDisplayed()) {
			test.log(LogStatus.INFO, "The empty contact team in the team switcher bar is displayed");
			log.info("The empty contact team in the team switcher bar is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The empty contact team in the team switcher bar is NOT displayed");
			log.info("The empty contact team in the team switcher bar is NOT displayed");
			return false;
		}
	}

	public void emptyContactTeamClick() {
		if (emptyContactTeam.isDisplayed()) {
			emptyContactTeam.click();
			test.log(LogStatus.INFO, "The empty contact team icon in the team switcher bar is click");
			log.info("The empty contact team icon in the team switcher bar is click");
		} else {
			test.log(LogStatus.FAIL, "The empty contact team icon in the team switcher bar is NOT click");
			log.info("The empty contact team icon in the team switcher bar is NOT click");
		}
	}

	public boolean rosterRecentTabDisplayed() {
		if (rosterRecentTab.isDisplayed()) {
			test.log(LogStatus.INFO, "The recent tab in roster is displayed");
			log.info("The recent tab in roster is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The recent tab in roster is NOT displayed");
			log.info("The recent tab in roster is NOT displayed");
			return false;
		}
	}

	public void rosterRecentTabClick() {
		if (rosterRecentTab.isDisplayed()) {
			rosterRecentTab.click();
			test.log(LogStatus.INFO, "The recent tab in roster is click");
			log.info("The recent tab in roster is click");
		} else {
			test.log(LogStatus.FAIL, "The recent tab in roster is NOT click");
			log.info("The recent tab in roster is NOT click");
		}
	}

	public boolean rosterChannelTabDisplayed() {
		if (rosterChannelTab.isDisplayed()) {
			test.log(LogStatus.INFO, "The channel tab in roster is displayed");
			log.info("The channel tab in roster is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The channel tab in roster is NOT displayed");
			log.info("The channel tab in roster is NOT displayed");
			return false;
		}
	}

	public void rosterChannelTabClick() {
		if (rosterChannelTab.isDisplayed()) {
			rosterChannelTab.click();
			test.log(LogStatus.INFO, "The channel tab in roster is click");
			log.info("The channel tab in roster is click");
		} else {
			test.log(LogStatus.FAIL, "The channel tab in roster is NOT click");
			log.info("The channel tab in roster is NOT click");
		}
	}

	public boolean rosterContactTabDisplayed() {
		if (rosterContactTab.isDisplayed()) {
			test.log(LogStatus.INFO, "The contact tab in roster is displayed");
			log.info("The contact tab in roster is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The contact tab in roster is NOT displayed");
			log.info("The contact tab in roster is NOT displayed");
			return false;
		}
	}

	public void rosterContactTabClick() {
		if (rosterContactTab.isDisplayed()) {
			rosterContactTab.click();
			test.log(LogStatus.INFO, "The contact tab in roster is click");
			log.info("The contact tab in roster is click");
		} else {
			test.log(LogStatus.FAIL, "The contact tab in roster is NOT click");
			log.info("The contact tab in roster is NOT click");
		}
	}

	public boolean inviteHookContactTabDisplayed() {
		if (inviteHookContactTab.isDisplayed()) {
			test.log(LogStatus.INFO, "The Invite Hook in Contact Tab displayed");
			log.info("The Invite Hook in Contact Tab displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The Invite Hook in Contact Tab NOT displayed");
			log.info("The Invite Hook in Contact Tab NOT displayed");
			return false;
		}
	}

	public void inviteHookContactTabClick() {
		if (inviteHookContactTab.isDisplayed()) {
			inviteHookContactTab.click();
			test.log(LogStatus.INFO, "The Invite Hook in Contact Tabs clicked");
			log.info("The Invite Hook in Contact Tabs clicked");
		} else {
			test.log(LogStatus.FAIL, "The Invite Hook in Contact Tabs NOT clicked");
			log.info("The Invite Hook in Contact Tabs NOT clicked");
		}
	}

	public boolean inviteContactUniversalSearchDispalyed() {
		if (inviteContactUniversalSearchBar.isDisplayed()) {
			test.log(LogStatus.INFO, "The Invite Hook in Universal Search Bar displayed");
			log.info("The Invite Hook in Universal Search Bar displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The Invite Hook in Universal Search Bar NOT displayed");
			log.info("The Invite Hook in Universal Search Bar NOT displayed");
			return false;
		}
	}

	public void inviteContactUniversalSearchClick() {
		if (inviteContactUniversalSearchBar.isDisplayed()) {
			inviteContactUniversalSearchBar.click();
			test.log(LogStatus.INFO, "The Invite Hook in Universal Search Bar clicked");
			log.info("The Invite Hook in Universal Search Bar clicked");
		} else {
			test.log(LogStatus.FAIL, "The Invite Hook in Universal Search Bar NOT clicked");
			log.info("The Invite Hook in Universal Search Bar NOT clicked");
		}
	}

	public boolean searchFieldContactTabDisplayed() {
		if (searchFieldContactTab.isDisplayed()) {
			test.log(LogStatus.INFO, "The search field in the contact tab is displayed");
			log.info("The search field in the contact tab is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The search field in the contact tab is NOT displayed");
			log.info("TThe search field in the contact tab is NOT displayed");
			return false;
		}
	}

	public void searchFieldContactTabClick() {
		if (searchFieldContactTab.isDisplayed()) {
			searchFieldContactTab.click();
			test.log(LogStatus.INFO, "The search field in the contact tab is clicked");
			log.info("The search field in the contact tab is clicked");
		} else {
			test.log(LogStatus.FAIL, "The search field in the contact tab is NOT clicked");
			log.info("The search field in the contact tab is NOT clicked");
		}
	}

	public void searchFieldContactTabSendKey(String email) {
		if (searchFieldContactTab.isDisplayed()) {
			searchFieldContactTab.sendKeys(email);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public boolean forkModalDisplayed() {
		if (forkModal.isDisplayed()) {
			test.log(LogStatus.INFO, "The fork modal is displayed");
			log.info("The fork modal is displayed");
			return true;
		} else {
			WebElement close = driver.findElement(By.id("close-btn"));
			close.click();
			test.log(LogStatus.FAIL, "The fork modal is NOT displayed");
			log.info("The fork modal is NOT displayed");
			return false;
		}
	}

	public boolean fullMemberHookDisplayed() {
		if (fullMember.isDisplayed()) {
			test.log(LogStatus.INFO, "The full member hook is displayed");
			log.info("The full member hook is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The full member hook is NOT displayed");
			log.info("The full member hook is NOT displayed");
			return false;
		}
	}

	public void fullMemberHookClick() {
		if (fullMember.isDisplayed()) {
			fullMember.click();
			test.log(LogStatus.INFO, "The full member hook is clicked");
			log.info("The full member hook is is clicked");
		} else {
			test.log(LogStatus.FAIL, "The full member hook is NOT clicked");
			log.info("The full member hook is NOT clicked");
		}
	}

	public boolean guestMemberHookDisplayed() {
		if (guestMember.isDisplayed()) {
			test.log(LogStatus.INFO, "The guest member hook is displayed");
			log.info("The guest member hook is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The guest member hook is NOT displayed");
			log.info("The guest member hook is NOT displayed");
			return false;
		}
	}

	public void guestMemberHookClick() {
		if (guestMember.isDisplayed()) {
			guestMember.click();
			test.log(LogStatus.INFO, "The guest member hook is clicked");
			log.info("The guest member hook is clicked");
		} else {
			test.log(LogStatus.FAIL, "The guest member hook is NOT clicked");
			log.info("The guest member hook is NOT clicked");
		}
	}

	public boolean backButtonInviteModalDisplayed() {
		if (backButtonInviteModal.isDisplayed()) {
			test.log(LogStatus.INFO, "The back button hook in invite modal is displayed");
			log.info("The back button hook in invite is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The back button hook in invite is NOT displayed");
			log.info("The back button hook in invite is NOT displayed");
			return false;
		}
	}

	public void backButtonInviteModalClick() {
		if (backButtonInviteModal.isDisplayed()) {
			backButtonInviteModal.click();
			test.log(LogStatus.INFO, "The back button hook in invite modal is clicked");
			log.info("The back button hook in invite modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The back button hook in invite modal is NOT clicked");
			log.info("The back button hook in invite modal is NOT clicked");
		}
	}

	public boolean inviteButtonGoogleImportDisplayed() {
		if (inviteButtonGoogleImport.isDisplayed()) {
			test.log(LogStatus.INFO, "The invite button inside the google imported section is displayed");
			log.info("The invite button inside the google imported section is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The invite button inside the google imported section is NOT displayed");
			log.info("The invite button inside the google imported section is NOT displayed");
			return false;
		}
	}

	public void inviteButtonGoogleImportClick() {
		if (inviteButtonGoogleImport.isDisplayed()) {
			inviteButtonGoogleImport.click();
			test.log(LogStatus.INFO, "The invite button inside the google imported section is clicked");
			log.info("The invite button inside the google imported section is clicked");
		} else {
			test.log(LogStatus.FAIL, "The invite button inside the google imported section is NOT clicked");
			log.info("The invite button inside the google imported section is NOT clicked");
		}
	}

	public boolean fullMemberInviteContainerDisplayed() {
		if (fullMemberInviteContainer.isDisplayed()) {
			test.log(LogStatus.INFO, "The Full Member Invite Container section is displayed");
			log.info("The Full Member Invite Container section is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The Full Member Invite Container section is NOT displayed");
			log.info("The Full Member Invite Container sectionn is NOT displayed");
			return false;
		}
	}

	public boolean inviteButtonFieldImportDisplayed() {
		if (sendButtonFieldImportScreen.isDisplayed()) {
			test.log(LogStatus.INFO, "The invite button inside the field imported section is displayed");
			log.info("The invite button inside the field imported section is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The invite button inside the field imported section is NOT displayed");
			log.info("The invite button inside the field imported section is NOT displayed");
			return false;
		}
	}

	public void inviteButtonFieldImportClick() {
		if (sendButtonFieldImportScreen.isDisplayed()) {
			sendButtonFieldImportScreen.click();
			test.log(LogStatus.INFO, "The invite button inside the field imported section is clicked");
			log.info("The invite button inside the field imported section is clicked");
		} else {
			test.log(LogStatus.FAIL, "The invite button inside the field imported section is NOT clicked");
			log.info("The invite button inside the field imported section is NOT clicked");
		}
	}

	public boolean guestInviteButtonDisplayed() {
		if (guestInviteButton.isDisplayed()) {
			test.log(LogStatus.INFO, "The invite button on the Guest Invite Modal is displayed");
			log.info("The invite button on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The invite button on the Guest Invite Modal is NOT displayed");
			log.info("The invite button on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public void guestInviteButtonClick() {
		if (guestInviteButton.isDisplayed()) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			guestInviteButton.click();
			test.log(LogStatus.INFO, "The invite button on the Guest Invite Modal is clicked");
			log.info("The invite button on the Guest Invite Modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The invite button on the Guest Invite Modal is NOT clicked");
			log.info("The invite button on the Guest Invite Modal is NOT clicked");
		}
	}

	public boolean guestInviteMoreButtonDisplayed() {
		if (guestInviteMoreButton.isDisplayed()) {
			test.log(LogStatus.INFO, "The invite more button on the Guest Invite Modal is displayed");
			log.info("The invite more button on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The invite button on the Guest Invite Modal is NOT displayed");
			log.info("The invite button on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public void guestInviteMoreButtonClick() {
		if (guestInviteMoreButton.isDisplayed()) {
			guestInviteMoreButton.click();
			test.log(LogStatus.INFO, "The invite more button on the Guest Invite Modal is clicked");
			log.info("The invite more button on the Guest Invite Modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The invite more button on the Guest Invite Modal is NOT clicked");
			log.info("The invite more button on the Guest Invite Modal is NOT clicked");
		}
	}

	public boolean validityReminderHookDisplayed() {
		if (validityReminder.isDisplayed()) {
			test.log(LogStatus.INFO, "The validity reminder hook on the Guest Invite Modal is displayed");
			log.info("The validity reminder hook on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The validity reminder hook on the Guest Invite Modal is NOT displayed");
			log.info("The validity reminder hook on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public void validityReminderHookClick() {
		if (validityReminder.isDisplayed()) {
			validityReminder.click();
			test.log(LogStatus.INFO, "The validity reminder hook on the Guest Invite Modal is clicked");
			log.info("The validity reminder hook on the Guest Invite Modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The validity reminder hook on the Guest Invite Modal is NOT clicked");
			log.info("The validity reminder hook on the Guest Invite Modal is NOT clicked");
		}
	}

	public boolean validityReminderFieldDisplayed() {
		if (validityReminderField.isDisplayed()) {
			test.log(LogStatus.INFO, "The validity reminder field on the Guest Invite Modal is displayed");
			log.info("The validity reminder field on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The validity reminder field on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public void validityReminderFieldClick() {
		if (validityReminderField.isDisplayed()) {
			validityReminderField.click();
			test.log(LogStatus.INFO, "The validity reminder field on the Guest Invite Modal is clicked");
			log.info("The validity reminder field on the Guest Invite Modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The validity reminder field on the Guest Invite Modal is NOT clicked");
			log.info("The validity reminder field on the Guest Invite Modal is NOT clicked");
		}
	}

	public boolean validityDatePickerDisplayed() {
		if (validityDatePicker.isDisplayed()) {
			test.log(LogStatus.INFO, "The validity reminder date picker on the Guest Invite Modal is displayed");
			log.info("The validity reminder date picker on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The validity reminder date picker on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public boolean guestInputFieldDisplayed() {
		if (guestInputField.isDisplayed()) {
			test.log(LogStatus.INFO, "The Guest Invite Field on the Guest Invite Modal is displayed");
			log.info("The Guest Invite Field on the Guest Invite Modal is displayed");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The Guest Invite Field on the Guest Invite Modal is NOT displayed");
			return false;
		}
	}

	public void clickGuestInputField() {
		if (guestInputField != null) {
			guestInputField.click();
			test.log(LogStatus.INFO, "Clicked inside the Guest Invite Field");
			log.info("Clicked inside theGuest Invite Field");
		} else {
			test.log(LogStatus.ERROR, "Can not click inside the Guest Invite Field");
			log.info("Can not click inside the Guest Invite Field");
		}
	}

	public void guestInputFieldSendKey(String email) {
		if (guestInputField.isDisplayed()) {
			guestInputField.sendKeys(email);
			test.log(LogStatus.INFO, "Email ID Entered in the Guest Invite Field");
			log.info("Email ID Entered in the Guest Invite Field");
		} else {
			test.log(LogStatus.FAIL, "Unable to enter Email ID in the Guest Invite Field");
			log.info("Unable to enter Email ID in the Guest Invite Field");
		}
	}

	public boolean guestContactAccessFieldDisplayed() {
		if (guestContactAccessField.isDisplayed()) {
			test.log(LogStatus.INFO, "The guest email access field is displayed on the Guest Member Access Screen");
			log.info("The guest email access field is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The guest email access field is not displayed on the Guest Member Access Screen");
			log.info("The guest email access field is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void guestContactAccessFieldClick() {
		if (guestContactAccessField.isDisplayed()) {
			guestContactAccessField.click();
			test.log(LogStatus.INFO, "The guest email access field is Clciked on the Guest Member Access Screen");
			log.info("The guest email access field is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL, "The guest email access field is not clicked on the Guest Member Access Screen");
			log.info("The guest email access field is not clicked on the Guest Member Access Screen");
		}
	}

	public void guestContactAccessFieldSendKey(String email) {
		if (guestContactAccessField.isDisplayed()) {
			guestContactAccessField.sendKeys(email);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public boolean ownerNameGuestAccessDisplayed() {
		if (ownerNameGuestAccess.isDisplayed()) {
			test.log(LogStatus.INFO,
					"The Inviter name in pilled contact field is displayed on the Guest Member Access Screen");
			log.info("The Inviter name in pilled contact field is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL,
					"The Inviter name in pilled contact field is not displayed on the Guest Member Access Screen");
			log.info("The Inviter name in pilled contact field is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public boolean guestChannelAccessFieldDisplayed() {
		if (guestChannelAccessField.isDisplayed()) {
			test.log(LogStatus.INFO, "The guest channel access field is displayed on the Guest Member Access Screen");
			log.info("The guest channel access field is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL,
					"The guest channel access field is not displayed on the Guest Member Access Screen");
			log.info("The guest access channel field is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void guestChannelAccessFieldClick() {
		if (guestChannelAccessField.isDisplayed()) {
			guestChannelAccessField.click();
			test.log(LogStatus.INFO, "The guest channe; access field is Clciked on the Guest Member Access Screen");
			log.info("The guest channel access field is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL, "The guest access field is not clicked on the Guest Member Access Screen");
			log.info("The guest access field is not clicked on the Guest Member Access Screen");
		}
	}

	public void guestChannelAccessFieldSendKey(String channelName) {
		if (guestChannelAccessField.isDisplayed()) {
			guestChannelAccessField.sendKeys(channelName);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public boolean guestNewChannelCreateDisplayed() {
		if (guestNewChannelCreate.isDisplayed()) {
			test.log(LogStatus.INFO, "The guest creat channel hook is displayed on the Guest Member Access Screen");
			log.info("The guest creat channel hook is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The guest creat channel hook is not displayed on the Guest Member Access Screen");
			log.info("The guest creat channel hook is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void guestNewChannelCreateHookClick() {
		if (guestNewChannelCreate.isDisplayed()) {
			guestNewChannelCreate.click();
			test.log(LogStatus.INFO, "The guest creat channel hook is Clciked on the Guest Member Access Screen");
			log.info("The guest creat channel hook is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL, "The guest creat channel hook is not clicked on the Guest Member Access Screen");
			log.info("Theguest creat channel hook is not clicked on the Guest Member Access Screen");
		}
	}

	public boolean guestNewChannelFieldDisplayed() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		if (guestNewChannelField.isDisplayed()) {
			test.log(LogStatus.INFO,
					"The guest create new channel field is displayed on the Guest Member Access Screen");
			log.info("The guest create new channel hook is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL,
					"The guest create new channel hook is not displayed on the Guest Member Access Screen");
			log.info("The guest create new channel hook is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void guestNewChannelFieldClick() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		if (guestNewChannelField.isDisplayed()) {
			guestNewChannelField.click();
			test.log(LogStatus.INFO, "The guest create new channel hook is Clciked on the Guest Member Access Screen");
			log.info("The guest create new channel hook is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL,
					"The guest create new channel hook is not clicked on the Guest Member Access Screen");
			log.info("Theguest create new channel hook is not clicked on the Guest Member Access Screen");
		}
	}

	public void guestNewChannelFieldSendKey(String channelName) {
		if (guestNewChannelField.isDisplayed()) {
			guestNewChannelField.sendKeys(channelName);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public boolean guestCreateChannelButtonDisplayed() {
		if (guestCreateChannelButton.isDisplayed()) {
			test.log(LogStatus.INFO, "The guest creat channel button is displayed on the Guest Member Access Screen");
			log.info("The guest creat channel button is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL,
					"The guest creat channel button is not displayed on the Guest Member Access Screen");
			log.info("The guest creat channel button is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void guestCreateChannelButtonClick() {
		if (guestCreateChannelButton.isDisplayed()) {
			guestCreateChannelButton.click();
			test.log(LogStatus.INFO, "The guest creat channel button is Clciked on the Guest Member Access Screen");
			log.info("The guest creat channel button is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL, "The guest creat channel button is not clicked on the Guest Member Access Screen");
			log.info("The guest creat channel button is not clicked on the Guest Member Access Screen");
		}
	}

	public boolean doneButtonGuestAccessDisplayed() {
		if (doneButtonGuestAccess.isDisplayed()) {
			test.log(LogStatus.INFO, "The Done button is displayed on the Guest Member Access Screen");
			log.info("The Done button is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL, "The Done button is not displayed on the Guest Member Access Screen");
			log.info("The Done button is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public void doneButtonGuestAccessClick() {
		if (doneButtonGuestAccess.isDisplayed()) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			doneButtonGuestAccess.click();

			test.log(LogStatus.INFO, "The Done button is Clciked on the Guest Member Access Screen");
			log.info("The Done button is clicled on the Guest Member Access Screen");
		} else {
			test.log(LogStatus.FAIL, "The Done button is not clicked on the Guest Member Access Screen");
			log.info("The Done button is not clicked on the Guest Member Access Screen");
		}
	}

	public boolean guestAccessMagicListDisplayed() {
		if (guestAccessMagicList.isDisplayed()) {
			test.log(LogStatus.INFO,
					"The magic list in the email field is displayed on the Guest Member Access Screen");
			log.info("The magic list in the email field is displayed on the Guest Member Access Screen");
			return true;
		} else {
			test.log(LogStatus.FAIL,
					"The magic list in the email field is not displayed on the Guest Member Access Screen");
			log.info("The magic list in the email field is not displayed on the Guest Member Access Screen");
			return false;
		}
	}

	public boolean globalAppSidebarPresent() {
		if (globalAppSidebar != null) {
			log.info("The App side bar is present");
			test.log(LogStatus.INFO, "The App side bar is present");
			return true;
		} else {
			log.info("The App side bar is present");
			test.log(LogStatus.FAIL, "The App side bar is present");
			return false;
		}
	}

	public boolean globalAppSidebarDisplayed() {
		if (globalAppSidebar.isDisplayed()) {
			log.info("The App side bar is displayed");
			test.log(LogStatus.INFO, "The App side bar is displayed");
			return true;
		} else {
			log.info("The App side bar is not displayed");
			test.log(LogStatus.FAIL, "The App side bar is not displayed");
			return false;
		}
	}
	public boolean rosterSideBarPresent() {
		if (rosterSideBar != null) {
			log.info("The roster icon in the  App side bar is present");
			test.log(LogStatus.INFO, "The roster icon in the  App side bar is present");
			return true;
		} else {
			log.info("The roster icon in the  App side bar is not present");
			test.log(LogStatus.FAIL, "The roster icon App side bar is not present");
			return false;
		}
	}

	public boolean rosterSideBarDisplayed() {
		if (rosterSideBar.isDisplayed()) {
			log.info("The roster icon in the  App side bar is displayed");
			test.log(LogStatus.INFO, "The roster icon in the  App side bar is displayed");
			return true;
		} else {
			log.info("The the roster icon in the App side bar is not displayed");
			test.log(LogStatus.FAIL, "The roster icon in the  App side bar is not displayed");
			return false;
		}
	}
	
	public void rosterSideBarClick() {
		if (rosterSideBar.isDisplayed()) {
			rosterSideBar.click();
			test.log(LogStatus.INFO, "The roster icon in the  App side bar is clicked");
			log.info("The roster icon in the  App side bar is clicked");
		} else {
			test.log(LogStatus.FAIL, "The roster icon in the  App side bar is not clicked");
			log.info("The roster icon in the  App side bar is not clicked");
		}
	}
	
	public boolean newChannelHookRosterPresent() {
		if (newChannelHookRoster != null) {
			log.info("The New Channel hook in roster is present");
			test.log(LogStatus.INFO, "The New Channel hook in roster is present");
			return true;
		} else {
			log.info("The New Channel hook in roster is not present");
			test.log(LogStatus.FAIL, "TheNew Channel hook in roster is not present");
			return false;
		}
	}

	public boolean newChannelHookRosterDisplayed() {
		if (newChannelHookRoster.isDisplayed()) {
			log.info("The rNew Channel hook in roster is displayed");
			test.log(LogStatus.INFO, "The New Channel hook in roster is displayed");
			return true;
		} else {
			log.info("The New Channel hook in roster not displayed");
			test.log(LogStatus.FAIL, "The rNew Channel hook in roster is not displayed");
			return false;
		}
	}
	
	public void newChannelHookRosterClick() {
		if (newChannelHookRoster.isDisplayed()) {
			newChannelHookRoster.click();
			test.log(LogStatus.INFO, "The New Channel hook in roster is clicked");
			log.info("The New Channel hook in roster is clicked");
		} else {
			test.log(LogStatus.FAIL, "TheNew Channel hook in roster is not clicked");
			log.info("The New Channel hook in roster is not clicked");
		}
	}
	
	public boolean joinChannelHookRosterPresent() {
		if (joinChannelHookRoster != null) {
			log.info("The join Channel hook in roster is present");
			test.log(LogStatus.INFO, "The join Channel hook in roster is present");
			return true;
		} else {
			log.info("The join Channel hook in roster is not present");
			test.log(LogStatus.FAIL, "The join Channel hook in roster is not present");
			return false;
		}
	}

	public boolean joinChannelHookRosterDisplayed() {
		if (joinChannelHookRoster.isDisplayed()) {
			log.info("The join Channel hook in roster is displayed");
			test.log(LogStatus.INFO, "The join Channel hook in roster is displayed");
			return true;
		} else {
			log.info("The join Channel hook in roster not displayed");
			test.log(LogStatus.FAIL, "The join Channel hook in roster is not displayed");
			return false;
		}
	}
	
	public void joinChannelHookRosterClick() {
		if (joinChannelHookRoster.isDisplayed()) {
			joinChannelHookRoster.click();
			test.log(LogStatus.INFO, "The join Channel hook in roster is clicked");
			log.info("The join Channel hook in roster is clicked");
		} else {
			test.log(LogStatus.FAIL, "The join Channel hook in roster is not clicked");
			log.info("The join Channel hook in roster is not clicked");
		}
	}
	
	public boolean cancelHookDiscoverChannelrPresent() {
		if (cancelHookDiscoverChannel != null) {
			log.info("The cancle hook in the discover channel modal is present");
			test.log(LogStatus.INFO, "The cancle hook in the discover channel modal is present");
			return true;
		} else {
			log.info("The cancle hook in the discover channel modal is not present");
			test.log(LogStatus.FAIL, "The cancle hook in the discover channel modal is not present");
			return false;
		}
	}

	public boolean cancelHookDiscoverChannelDisplayed() {
		if (cancelHookDiscoverChannel.isDisplayed()) {
			log.info("The cancle hook in the discover channel modal is displayed");
			test.log(LogStatus.INFO, "The cancle hook in the discover channel modal is displayed");
			return true;
		} else {
			log.info("The cancle hook in the discover channel modal is not displayed");
			test.log(LogStatus.FAIL, "The cancle hook in the discover channel modal is not displayed");
			return false;
		}
	}
	
	public void cancelHookDiscoverChannelClick() {
		if (cancelHookDiscoverChannel.isDisplayed()) {
			cancelHookDiscoverChannel.click();
			test.log(LogStatus.INFO, "The cancle hook in the discover channel modal is clicked");
			log.info("The cancle hook in the discover channel modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The cancle hook in the discover channel modal is not clicked");
			log.info("The cancle hook in the discover channel modal is not clicked");
		}
	}
	
	public boolean channelTabPresent() {
		if (channelTab != null) {
			log.info("The channel tab in the roster is present");
			test.log(LogStatus.INFO, "The channel tab in the roster is present");
			return true;
		} else {
			log.info("The channel tab in the roster is not present");
			test.log(LogStatus.FAIL, "The channel tab in the roster is not present");
			return false;
		}
	}

	public boolean channelTabDisplayed() {
		if (channelTab.isDisplayed()) {
			log.info("The channel tab in the roster is displayed");
			test.log(LogStatus.INFO, "The channel tab in the roster is displayed");
			return true;
		} else {
			log.info("The channel tab in the roster is not displayed");
			test.log(LogStatus.FAIL, "The channel tab in the roster is not displayed");
			return false;
		}
	}
	
	public void channelTabClick() {
		if (channelTab.isDisplayed()) {
			channelTab.click();
			test.log(LogStatus.INFO, "The channel tab in the roster is clicked");
			log.info("The channel tab in the roster is clicked");
		} else {
			test.log(LogStatus.FAIL, "The channel tab in the roster is not clicked");
			log.info("The channel tab in the roster is not clicked");
		}
	}
	
	public boolean createChannelPlusIconPresent() {
		if (createChannelPlusIcon != null) {
			log.info("The create channel + icon in the channel tab is present");
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is present");
			return true;
		} else {
			log.info("The create channel + icon in the channel tab is not present");
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not present");
			return false;
		}
	}

	public boolean createChannelPlusIconDisplayed() {
		if (createChannelPlusIcon.isDisplayed()) {
			log.info("The create channel + icon in the channel tab is displayed");
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is displayed");
			return true;
		} else {
			log.info("The create channel + icon in the channel tab is not displayed");
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not displayed");
			return false;
		}
	}
	
	public void createChannelPlusIconClick() {
		if (createChannelPlusIcon.isDisplayed()) {
			createChannelPlusIcon.click();
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is clicked");
			log.info("The create channel + icon in the channel tab is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not clicked");
			log.info("The create channel + icon in the channel tab is not clicked");
		}
	}
	
	public boolean emptyStateChannelTabDisplayed() {
		if (emptyStateChannelTab.isDisplayed()) {
			log.info("The empty state in the channel tab is displayed");
			test.log(LogStatus.INFO, "The empty state in the channel tab is displayed");
			return true;
		} else {
			log.info("The empty state in the channel tab is not displayed");
			test.log(LogStatus.FAIL, "The cempty state in the channel tab is not displayed");
			return false;
		}
	}
	
	public boolean createChannelEmptyStatePresent() {
		if (createChannelEmptyState != null) {
			log.info("The create channel in the channel empty state is present");
			test.log(LogStatus.INFO, "The create channel in the channel empty state is present");
			return true;
		} else {
			log.info("The create channel in the channel empty state is not present");
			test.log(LogStatus.FAIL, "The create channel in the channel empty state is not present");
			return false;
		}
	}

	public boolean createChannelEmptyStateDisplayed() {
		if (createChannelEmptyState.isDisplayed()) {
			log.info("The create channel in the channel empty state is displayed");
			test.log(LogStatus.INFO, "The create channelin the channel empty state is displayed");
			return true;
		} else {
			log.info("The create channel in the channel empty state is not displayed");
			test.log(LogStatus.FAIL, "The create channel in the channel empty state is not displayed");
			return false;
		}
	}
	
	public void createChannelEmptyStateClick() {
		if (createChannelEmptyState.isDisplayed()) {
			createChannelEmptyState.click();
			test.log(LogStatus.INFO, "The create channel in the channel empty state is clicked");
			log.info("The create channel in the channel empty state is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel in the channel empty state is not clicked");
			log.info("The create channelin the channel empty state is not clicked");
		}
	}
	public boolean channelTabSearchFieldresent() {
		if (channelTabSearchField != null) {
			log.info("The search field in the channel tab is present");
			test.log(LogStatus.INFO, "The search field in the channel tab is present");
			return true;
		} else {
			log.info("The search field in the channel tab is not present");
			test.log(LogStatus.FAIL, "The search field in the channel tab is not present");
			return false;
		}
	}

	public boolean channelTabSearchFieldDisplayed() {
		if (channelTabSearchField.isDisplayed()) {
			log.info("Thesearch field in the channel tab is displayed");
			test.log(LogStatus.INFO, "The search field in the channel tab is displayed");
			return true;
		} else {
			log.info("The search field in the channel tab is not displayed");
			test.log(LogStatus.FAIL, "The search field in the channel tab is not displayed");
			return false;
		}
	}
	
	public void channelTabSearchFieldClick() {
		if (channelTabSearchField.isDisplayed()) {
			channelTabSearchField.click();
			test.log(LogStatus.INFO, "The search field in the channel tab is clicked");
			log.info("Thesearch field in the channel tabe is clicked");
		} else {
			test.log(LogStatus.FAIL, "The search field in the channel tab is not clicked");
			log.info("The search field in the channel tab is not clicked");
		}
	}
	
	public void channelTabSearchFieldSendKey(String channelName) {
		if (channelTabSearchField.isDisplayed()) {
			
			Actions actions = new Actions(driver);
			actions.moveToElement(channelTabSearchField);
			actions.click();
			actions.sendKeys(channelName).build().perform();
			//channelTabSearchField.sendKeys(channelName);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public void channelTabSearchFieldclear() {
		if (channelTabSearchField.isDisplayed()) {
			
			WebElement webElement =driver.findElement(By.xpath("//input[@placeholder='Search for Channels']"));
			webElement.sendKeys(Keys.DELETE);
			//channelTabSearchField.clear();;
			test.log(LogStatus.INFO, "String entered in the field is cleared");
			log.info("String entered in the field is cleared");
		} else {
			test.log(LogStatus.FAIL, "String can not be cleared in the field");
			log.info("String can not be cleared in the field");
		}
	}
	
	public boolean contactTabPresent() {
		if (contactTab != null) {
			log.info("The contact tab in the roster is present");
			test.log(LogStatus.INFO, "The contact tab in the roster is present");
			return true;
		} else {
			log.info("The contact tab in the roster is not present");
			test.log(LogStatus.FAIL, "The contact tab in the roster is not present");
			return false;
		}
	}

	public boolean contactTabDisplayed() {
		if (contactTab.isDisplayed()) {
			log.info("The contact tab in the roster is displayed");
			test.log(LogStatus.INFO, "The contact tab in the roster is displayed");
			return true;
		} else {
			log.info("The contact tab in the roster is not displayed");
			test.log(LogStatus.FAIL, "The contact tab in the roster is not displayed");
			return false;
		}
	}
	
	public void contactTabClick() {
		if (contactTab.isDisplayed()) {
			contactTab.click();
			test.log(LogStatus.INFO, "The contact tab in the roster is clicked");
			log.info("The contact tab in the roster is clicked");
		} else {
			test.log(LogStatus.FAIL, "The contact tab in the roster is not clicked");
			log.info("The contact tab in the roster is not clicked");
		}
	}
	
	public boolean contactTabInviteContactIconPresent() {
		if (contactTabInvite != null) {
			log.info("The create channel + icon in the channel tab is present");
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is present");
			return true;
		} else {
			log.info("The create channel + icon in the channel tab is not present");
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not present");
			return false;
		}
	}

	public boolean contactTabInviteContactIconDisplayed() {
		if (contactTabInvite.isDisplayed()) {
			log.info("The create channel + icon in the channel tab is displayed");
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is displayed");
			return true;
		} else {
			log.info("The create channel + icon in the channel tab is not displayed");
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not displayed");
			return false;
		}
	}
	
	public void contactTabInviteContactIconClick() {
		if (contactTabInvite.isDisplayed()) {
			contactTabInvite.click();
			test.log(LogStatus.INFO, "The create channel + icon in the channel tab is clicked");
			log.info("The create channel + icon in the channel tab is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel + icon in the channel tab is not clicked");
			log.info("The create channel + icon in the channel tab is not clicked");
		}
	}
	
	public boolean contactTabSearchFieldPresent() {
		if (contactTabSearchField != null) {
			log.info("The search field in the contact tab is present");
			test.log(LogStatus.INFO, "The search field in the contact tab is present");
			return true;
		} else {
			log.info("The search field in the contact tab is not present");
			test.log(LogStatus.FAIL, "The search field in the contact tab is not present");
			return false;
		}
	}

	public boolean contactTabSearchFieldDisplayed() {
		if (contactTabSearchField.isDisplayed()) {
			log.info("Thesearch field in the contact tab is displayed");
			test.log(LogStatus.INFO, "The search field in the contact tab is displayed");
			return true;
		} else {
			log.info("The search field in the contact tab is not displayed");
			test.log(LogStatus.FAIL, "The search field in the contact tab is not displayed");
			return false;
		}
	}
	
	public void contactTabSearchFieldClick() {
		if (contactTabSearchField.isDisplayed()) {
			contactTabSearchField.click();
			test.log(LogStatus.INFO, "The search field in the contact tab is clicked");
			log.info("Thesearch field in the contact tabe is clicked");
		} else {
			test.log(LogStatus.FAIL, "The search field in the contact tab is not clicked");
			log.info("The search field in the contact tab is not clicked");
		}
	}
	
	public void contactTabSearchFieldSendKey(String contactName) {
		if (contactTabSearchField.isDisplayed()) {
			
			Actions actions = new Actions(driver);
			actions.moveToElement(contactTabSearchField);
			actions.click();
			actions.sendKeys(contactName).build().perform();
			//channelTabSearchField.sendKeys(channelName);
			test.log(LogStatus.INFO, "String entered in the field");
			log.info("String entered in the field");
		} else {
			test.log(LogStatus.FAIL, "String can not be entered in the field");
			log.info("String can not be entered in the field");
		}
	}

	public void contactTabSearchFieldclear() {
		if (contactTabSearchField.isDisplayed()) {
			
			WebElement webElement =driver.findElement(By.xpath("//input[@placeholder='Search for Channels']"));
			webElement.sendKeys(Keys.DELETE);
			//channelTabSearchField.clear();;
			test.log(LogStatus.INFO, "String entered in the field is cleared");
			log.info("String entered in the field is cleared");
		} else {
			test.log(LogStatus.FAIL, "String can not be cleared in the field");
			log.info("String can not be cleared in the field");
		}
	}
	
	public boolean recentsNewChannelPresent() {
		if (recentsNewChannel != null) {
			log.info("The create channel in the recent tab is present");
			test.log(LogStatus.INFO, "The create channel in the recent tab is present");
			return true;
		} else {
			log.info("The create channel in the recent tab is not present");
			test.log(LogStatus.FAIL, "The create channel in the recent tab is not present");
			return false;
		}
	}

	public boolean recentsNewChannelDisplayed() {
		if (recentsNewChannel.isDisplayed()) {
			log.info("The create channel in the recent tab is displayed");
			test.log(LogStatus.INFO, "The create channel in the recent tab is displayed");
			return true;
		} else {
			log.info("The create channel in the recent tab is not displayed");
			test.log(LogStatus.FAIL, "The create channel in the recent tab is not displayed");
			return false;	
		}
		}
	public boolean activeChatDisplayed(){
		if (activeChat.isDisplayed()) {
			log.info("The active chat section is displayed");
			test.log(LogStatus.INFO, "The active chat section is displayed");
			return true;
		} else {
			log.info("The active chat section is not displayed");
			test.log(LogStatus.FAIL, "The active chat section is not displayed");

			return false;
		}
	}
	

	public void recentsNewChannelClick() {
		if (recentsNewChannel.isDisplayed()) {
			recentsNewChannel.click();
			test.log(LogStatus.INFO, "The create channel in the recent tab is clicked");
			log.info("The create channel in the recent tab is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel in the recent tab is not clicked");
			log.info("The create channel in the recent tab is not clicked");
		}
	}
	public boolean createChannelJoinModalPresent() {
		if (createChannelJoinModal != null) {
			log.info("The create channel in the join channel modal is present");
			test.log(LogStatus.INFO, "The create channel in the join channel modal is present");
			return true;
		} else {
			log.info("The create channel in the join channel modal is not present");
			test.log(LogStatus.FAIL, "The create channel in the in the join channel modal is not present");
			return false;
		}
	}

	public boolean activeChatInvitePresent() {
		if (activeChatInvite != null) {
			log.info("The active chat invite blurb is present");
			test.log(LogStatus.INFO, "The active chat invite blurb is present");
			return true;
		} else {
			log.info("The active chat invite blurb is not present");
			test.log(LogStatus.FAIL, "The active chat invite blurb is not present");
			return false;
		}
	}


	public boolean createChannelJoinModalDisplayed() {
		if (createChannelJoinModal.isDisplayed()) {
			log.info("The create channel in the join channel modal is displayed");
			test.log(LogStatus.INFO, "The create channel in the join channel modal is displayed");
			return true;
		} else {
			log.info("The create channel in the join channel modal is not displayed");
			test.log(LogStatus.FAIL, "The create channel in the join channel modal is not displayed");
			return false;
		}
	}

	public boolean activeChatInviteDisplayed() {
		if (activeChatInvite.isDisplayed()) {
			log.info("The active chat invite blurb is displayed");
			test.log(LogStatus.INFO, "The active chat invite blurb is displayed");
			return true;
		} else {
			log.info("The active chat invite blurb is not displayed");
			test.log(LogStatus.FAIL, "The active chat invite blurb is not displayed");
			return false;
		}
	}
	

	public void createChannelJoinModalClick() {
		if (createChannelJoinModal.isDisplayed()) {
			createChannelJoinModal.click();
			test.log(LogStatus.INFO, "The create channel in the join channel modal is clicked");
			log.info("The create channel in the join channel modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel in the join channel modal is not clicked");
			log.info("The create channel in the join channel modal is not clicked");
		}
	}
	
	public boolean channelEmptyStatePresent() {
		if (channelEmptyState != null) {
			log.info("The channel empty state in the Channel Tab is present");
			test.log(LogStatus.INFO, "Thechannel empty state in the Channel Tab is present");
			return true;
		} else {
			log.info("The channel empty state in the Channel Tab is not present");
			test.log(LogStatus.FAIL, "The channel empty state in the Channel Tab is not present");
			return false;
		}
	}

	public boolean guestSuccessScreenPresent() {
		if (guestSucessPage != null) {
			log.info("The guest sucess screen is present");
			test.log(LogStatus.INFO, "The guest sucess screen is present");
			return true;
		} else {
			log.info("The guest sucess screen is not present");
			test.log(LogStatus.FAIL, "The guest sucess screen is not present");
			return false;
		}
	}

	public boolean channelEmptyStateDisplayed() {
		if (channelEmptyState.isDisplayed()) {
			log.info("The channel empty state in the Channel Tab is displayed");
			test.log(LogStatus.INFO, "The channel empty state in the Channel Tab is displayed");
			return true;
		} else {
			log.info("The channel empty state in the Channel Tab is not displayed");
			test.log(LogStatus.FAIL, "The channel empty state in the Channel Tab is not displayed");
			return false;
		}
	}
	
	public boolean channelEmptyStateButtonPresent() {
		if (ChannelEmptyStateButton != null) {
			log.info("The create channel button in the empty channel modal is present");
			test.log(LogStatus.INFO, "The create channel button in the empty channel modal is present");
			return true;
		} else {
			log.info("The create channel button in the empty channel modal is not present");
			test.log(LogStatus.FAIL, "The create channel button in the empty channel modal is not present");
			return false;
		}
	}

	public boolean channelEmptyStateButtonDisplayed() {
		if (ChannelEmptyStateButton.isDisplayed()) {
			log.info("The create channel button in the empty channel modal is displayed");
			test.log(LogStatus.INFO, "The create channel button in the empty channel modal is displayed");
			return true;
		} else {
			log.info("The create channel button in the empty channel modal is not displayed");
			test.log(LogStatus.FAIL, "The create channel button in the empty channel modal is not displayed");
			return false;
		}
	}
	
	public void channelEmptyStateButtonClick() {
		if (ChannelEmptyStateButton.isDisplayed()) {
			ChannelEmptyStateButton.click();
			test.log(LogStatus.INFO, "The create channel button in the empty channel modal is clicked");
			log.info("The create channel button in the empty channel modal is clicked");
		} else {
			test.log(LogStatus.FAIL, "The create channel button in the empty channel modal is not clicked");
			log.info("The create channel button in the empty channel modal is not clicked");
		}
	}

	public boolean guestSuccessScreenDisplayed() {
		if (guestSucessPage.isDisplayed()) {
			log.info("The guest sucess screen is displayed");
			test.log(LogStatus.INFO, "The aguest sucess screen is displayed");
			return true;
		} else {
			log.info("The guest sucess screen is not displayed");
			test.log(LogStatus.FAIL, "The guest sucess screen is not displayed");
			return false;
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'has-unread-message')]//div[@class='chat-description']//span[contains(@class,'senderName') and contains(text(),'Reminder Bot')]")  //reminder bot notification under active chat area 
	public WebElement reminderActiveChatAreaFlockml;
	
	public boolean reminderActiveChatAreaFlockmlDisplayed(){   //reminder bot notification under active chat area
		try{
			reminderActiveChatAreaFlockml.isDisplayed();
			test.log(LogStatus.PASS, "Reminder bot notification is displayed under active chat area");
			return true;
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Reminder bot notification is NOT displayed under active chat area");
			return false;	
		}
	}
	
	public boolean snoozeReminderCancelPresent() {
		if (snoozeReminderCancel != null) {
			log.info("The Snooze reminder cancel button is present");
			test.log(LogStatus.INFO, "The Snooze reminder cancel button is present");
			return true;
		} else {
			log.info("The Snooze reminder cancel button is not present");
			test.log(LogStatus.FAIL, "The Snooze reminder cancel button is not present");
			return false;
		}
	}

	public boolean snoozeReminderCancelDisplayed() {
		if (snoozeReminderCancel.isDisplayed()) {
			log.info("The Snooze reminder cancel button is displayed");
			test.log(LogStatus.INFO, "The Snooze reminder cancel button is displayed");
			return true;
		} else {
			log.info("The Snooze reminder cancel button is not displayed");
			test.log(LogStatus.FAIL, "The Snooze reminder cancel button is not displayed");
			return false;
		}
	}
	
	public void snoozeReminderCancelClick() {
		if (snoozeReminderCancel.isDisplayed()) {
			snoozeReminderCancel.click();
			test.log(LogStatus.INFO, "The Snooze reminder cancel button is clicked");
			log.info("The Snooze reminder cancel button is clicked");
		} else {
			test.log(LogStatus.FAIL, "The Snooze reminder cancel button is not clicked");
			log.info("The Snooze reminder cancel button is not clicked");
		}
	}
	
	public boolean snoozeReminderModalDisplayed() {
		if (snoozeReminderModal.isDisplayed()) {
			log.info("The Snooze reminder modal is displayed");
			test.log(LogStatus.INFO, "The Snooze reminder modal is displayed");
			return true;
		} else {
			log.info("The Snooze reminder modal is not displayed");
			test.log(LogStatus.FAIL, "The Snooze reminder modal is not displayed");
			return false;
		}
	}
	
	@FindBy(xpath="//div[@data-buttonid='app___view']")
	public List<WebElement> todoViewButton;
	
	@FindBy(xpath="//div[@class='edit-message']")
	public WebElement editMessageModal;
	
	@FindBy(xpath="//div[@class='edit-message']//button[@data-dojo-attach-point='_saveButton']")
	public WebElement editSaveButton;
	
	@FindBy(xpath="//div[@class='edit-message']//button[@data-dojo-attach-point='_cancelButton']")
	public WebElement editCancelButton;
	
	@FindBy(xpath="//button[@data-dojo-attach-point='cancelLink']")
	public WebElement cancelButton;

	@FindBy(xpath="//input[@id='channelName']")
	public WebElement channelNameField;
	
	@FindBy(xpath="//button[contains(@class,'btn')]")
	public WebElement createChannelButton;
	
	@FindBy(xpath="//div[@id='theme-desktop']//span[@class='modal-box__close']")
	public WebElement appDoorCancel;
	
	@FindBy(xpath="//div[@class='group']//div[contains(@class,'group-dropdown')]")
	public WebElement contactHeaderConversation;
	
	@FindBy(className="open-channel")
	public WebElement openChannelConversation;
	
	@FindBy(xpath="//div[contains(@class,'Popup') and contains(@class,'group-info-widget-dropdown')]")
	public WebElement channelContactCard;
	
	@FindBy(xpath="//div[@data-dojo-attach-point='memberCountNode']//div[@class='member-count']")
	public WebElement channelMemberCount;

	@FindBy(xpath="//div[contains(@class,'appWidgetPopup')]//iframe")
	public WebElement reactFrame;
	
	@FindBy(xpath="//div[@class='app-container-frame']//iframe")
	public List<WebElement> reactedFrame;
	
	@FindBy(xpath="//div[@data-dojo-attach-point='appSidebarTitle']")
	public WebElement appSideBarHeading;
	
	@FindBy(xpath="//div[contains(@class,'appSidebarFrameContainer')]//iframe")
	public WebElement appSideBar;
	
	@FindBy(id="pin-container")
	public WebElement pinnedSideBar;
	
	@FindBy(id="content-container")
	public WebElement sharedContentSideBar;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .minute_child .chat_message .chat_message_body .message_text")
	public List<WebElement> messageInAttachment;
	
	@FindBy(xpath="//a[contains(text(),'talk-to/horus')]")
	public List<WebElement> lastGithubMessage;
	
	@FindBy(xpath="//div[contains(@class,'app-item--on') and @data-name='Files']")
	public WebElement filesSelected;
	
	@FindBy(xpath="//div[contains(@class,'app-item--on') and @data-name='Reminders']")
	public WebElement reminderSelected;
	
	@FindBy(xpath="//div[contains(@class,'app-item--on') and @data-name='Shared To-Dos']")
	public WebElement todosSelected;
	
	@FindBy(xpath="//div[@class='google-apps-prompt']")
	public WebElement googleCalendarPrompt;
	
	@FindBy(xpath="//div[@class='calendar-prompt']/span[@class='closeLink']")
	public WebElement googleCalendarPromptCancel;
	
	@FindBy(xpath="//div[@class='calendar-prompt']//button[text()='Try Google Calendar']")
	public WebElement googleCalendarPromptTry;
	
	@FindBy(xpath="//div[@class='calendar-prompt']//a")
	public WebElement googleCalendarPromptLatter;
	
	public void dismissCalendarPrompt(){
		if(googleCalendarPrompt.isDisplayed()){
			googleCalendarPromptCancel.click();
				}else{
					log.info("Google calendar prompt not displayed");
				}
	}
	
	@FindBy(xpath="//a[contains(text(),'Remind me later')]")
	public WebElement skipFeatureTour;
	
	public boolean dismissFeatureTourPrompt(){
		try{if(skipFeatureTour.isDisplayed()){
			skipFeatureTour.click();
			driver.switchTo().frame(ce1.appIframe);
			return true;
		}
				}catch(Exception e){
					log.info("Google calendar prompt not displayed");
					driver.switchTo().frame(ce1.appIframe);
				}
		return false;
	}
	
	@FindBy(xpath="//div[contains(@class,'invite-restriction')]")
	public WebElement inviteRestrictionModal;
	
	@FindBy(xpath="//div[contains(@class,'invite-restriction')]//button[@data-dojo-attach-point='cancelLink']")
	public WebElement inviteRestrictionCanel;
	
	@FindBy(xpath="//div[contains(@class,'invite-restriction')]//button[@data-dojo-attach-point='okButton']")
	public WebElement inviteRestrictionShowAdmin;
	
	@FindBy(xpath="//div[contains(@class,'conversation') and contains(@class,'selected')]//div[@class='name']/div[@class='channel-name']")
	public WebElement selectedChannelName;
	
	@FindBy(xpath="//div[contains(@class,'selected') and contains(@class,'group')]//span[@class='text']")
	public WebElement selectedConversationMessage;
	
	@FindBy(id="team-members-screen")
	public WebElement inviteProHookScreen;
	
	@FindBy(xpath="//div[@class='paywall-block']")
	public WebElement invitePayWallHook;
	
	@FindBy(xpath="//div[@class='paywall-block']/a[text()='Upgrade to PRO']")
	public WebElement upgradeToProLink;
	
	@FindBy(xpath="//div[contains(@class,'me-bot')]")
	public WebElement meTab;
	
	@FindBy(xpath="//div[contains(@class,'EditorDropDownMenu-Contacts')]")
	public WebElement tagPublicChannelDropdown;
	
	@FindBy(xpath="//div[contains(@class,'EditorDropDownMenu')]//li[1]")
	public List<WebElement> tagChannelList;

	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv")
	public List<WebElement> lastAttachmentMessage;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv .attachmentDiv .titleDiv")
	public List<WebElement> taggedChannelTitle;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv .attachmentDiv .subtitle")
	public List<WebElement> taggedChannelSubTitle;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv .attachmentDiv .description")
	public List<WebElement> taggedChannelDescription;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv .message_actions_container .attachment_button")
	public List<WebElement> taggedChannelActionButton;
	
	@FindBy(css=".message_area_root .daySeparator:last-child .minute_separator:last-child .attachmentContainerDiv .message_actions_container .attachment_button >Span")
	public List<WebElement> taggedChannelActionButtonText;
	
	@FindBy(xpath="//div[contains(@class,'addMoreText')]")
	public WebElement addMoreChannel;
	
	@FindBy(xpath="//div[contains(@class,'groupDetails')]//div[@class='profile_name_container']//input[@placeholder='Invite']")
	public WebElement addMoreInviteField;
	
	@FindBy(xpath="//div[@class='Select-menu-outer']//div[contains(@class,'is-focused')]")
	public WebElement inviteFieldCreateChannel;
	
	@FindBy(xpath="//div[@class='group-name']//textarea")
	public WebElement channelNameProfileCard;
	
	
}
