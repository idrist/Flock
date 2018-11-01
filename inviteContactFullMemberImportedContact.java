package com.inviteContacts;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericMethods;
import com.utilities.OnBoardingUtils;
import com.utilities.clientElement;

public class inviteContactFullMemberImportedContact extends BaseTestSuite {

	/*
	 * Created on 5th Jan 2018 By Farzan Shaikh Refactored on 12th Jan 2018 By
	 * Farzan Shaikh
	 */

	ExtentTest test;
	WebDriver driver = null;
	private GenericMethods gm;
	private clientElement ce;

	private static final Logger log = LogManager.getLogger(OnBoardingUtils.class.getName());

	public inviteContactFullMemberImportedContact(WebDriver webDriver, ExtentTest test) {
		this.driver = webDriver;
		this.test = test;
		gm = new GenericMethods(this.driver);
		ce = new clientElement(this.driver, this.test);
	}

	public void inviteForkModalContent() {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				forkModalContent();

				boolean result = driver.findElement(By.id("invite-heading")) != null;
				Assert.assertTrue(result);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "inviteForkModalContent Test Passed");
				log.info("inviteForkModalContent Test Passed");
			} else {
				test.log(LogStatus.FAIL, "inviteForkModalContent Test FAILED");
				log.error("inviteForkModalContent Test FAILED");
			}
		}

	}

	public void forkModalContent() {
		gm.elementDisplayed(By.id("invite-heading"), "Invite Heading on the fork page");
		gm.getInnerText(By.id("invite-heading"));
		gm.compareText(By.id("invite-heading"), "Invite people to Flock.com");

		gm.elementDisplayed(By.xpath("//div[@id='invite-type-screen']/label"), "Invite Sub Heading on the fork page");
		gm.getInnerText(By.xpath("//div[@id='invite-type-screen']/label"));
		gm.compareText(By.xpath("//div[@id='invite-type-screen']/label"), "Whom would you like to invite?");

		gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-image') and contains(@class,'invite-guests')]"),
				"Guest Invite Icon");

		gm.elementDisplayed(By.xpath("//div[@id='team-members']//div[@class='title']"),
				"Full Members heading on the fork page");
		gm.getText(By.xpath("//div[@id='team-members']//div[@class='title']"));
		gm.compareText(By.xpath("//div[@id='team-members']//div[@class='title']"), "Full Members");

		gm.elementDisplayed(By.xpath("//div[@id='team-members']//div[@class='sub-title']"),
				"Full Members description on the fork page");
		gm.getInnerText(By.xpath("//div[@id='team-members']//div[@class='sub-title']"));
		gm.compareText(By.xpath("//div[@id='team-members']//div[@class='sub-title']"),
				"Use this for Employees who belong to your organization. They will get access to all other employees and all public channels");

		gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-image') and contains(@class,'invite-guests')]"),
				"Guest Invite Icon");

		gm.elementDisplayed(By.xpath("//div[@id='guest-members']//div[@class='title']"),
				"Guest Members heading on the fork page");
		gm.getInnerText(By.xpath("//div[@id='guest-members']//div[@class='title']"));
		gm.compareText(By.xpath("//div[@id='guest-members']//div[@class='title']"), "Guests");

		gm.elementDisplayed(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"),
				"Guest Members description on the fork page");
		gm.getInnerText(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"));
		gm.compareText(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"),
				"Use this for external clients, vendors, candidates. They will only be able to chat with restricted people and in restricted channels");
	}

	public void fullMemberInviteModalContent() {

		if (ce.inviteContactModalDisplayed()) {

			inviteModalTextContent();

			boolean result = driver.findElement(By.xpath("//div[@id='invite-container']/div[2]/input")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "fullMemberInviteModalContent Test Passed");
			log.info("fullMemberInviteModalContent Test Passed");
		} else {
			test.log(LogStatus.FAIL, "fullMemberInviteModalContent Test FAILED");
			log.error("fullMemberInviteModalContent Test FAILED");
		}
	}

	public void inviteModalTextContent() {
		gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);

		gm.elementDisplayed(By.xpath("//span[@id='back-btn']"), "Back Button on the Full Member Invite Modal");

		gm.elementDisplayed(By.xpath("//h2[@id='invite-heading']"), "Invite Modal Header");
		gm.getInnerText(By.xpath("//h2[@id='invite-heading']"));
		gm.compareText(By.xpath("//h2[@id='invite-heading']"), "Invite Team Members");

		gm.elementDisplayed(By.xpath("//div[@id='google-container']/label[@class='invite-colleagues']"),
				"Google Import Modal SubHeader");
		gm.getInnerText(By.xpath("//div[@id='google-container']/label[@class='invite-colleagues']"));
		gm.compareText(By.xpath("//div[@id='google-container']/label[@class='invite-colleagues']"),
				"Invite colleagues from your directory");

		gm.elementDisplayed(By.xpath("//input[@id='search-filter']"), "Google Import Modal search bar");
		gm.getInnerText(By.xpath("//input[@id='search-filter']"));
		gm.compareText(By.xpath("//input[@id='search-filter']"), "Enter email address to invite");

		/*if (gm.elementDisplayed(By.xpath("//div[@id='google-contacts']"), "Google Import section")) {
			gm.elementDisplayed(By.xpath("//div[@id='google-contacts']/div[1]/img"), "Google Import Avatar");

			gm.elementDisplayed(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[1]"),
					"Google Import Contact Name");
			gm.getInnerText(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[1]"));
			gm.compareText(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[1]"), "Akshat Gandhi");

			gm.elementDisplayed(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[2]"),
					"Google Import Contact Email");
			gm.getInnerText(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[2]"));
			gm.compareText(By.xpath("//div[@id='google-contacts']/div[1]/div[1]/div[2]"), "aksmangandhi@yahoo.co.in");

			gm.elementDisplayed(By.xpath("//div[@id='aksmangandhi@yahoo.co.in']"), "Google Import Contact Email");
			gm.getInnerText(By.xpath("//div[@id='aksmangandhi@yahoo.co.in']"));
			gm.compareText(By.xpath("//div[@id='aksmangandhi@yahoo.co.in']"), "Invite");
		} else {
			log.error("Google imported contact section not displayed");
		}*/

		gm.elementDisplayed(By.xpath("//div[@id='google-container']/label[2]"), "Enter Email Modal SubHeader");
		gm.getInnerText(By.xpath("//div[@id='google-container']/label[2]"));
		gm.compareText(By.xpath("//div[@id='google-container']/label[2]"),
				"Can't find someone in the list above? Enter emails");

		gm.elementDisplayed(By.xpath("//input[@id='email-input']"), "Enter Email Modal SubHeader");
		gm.getInnerText(By.xpath("//input[@id='email-input']"));
		gm.compareText(By.xpath("//input[@id='email-input']"), "Emails separated by space");

		gm.elementDisplayed(By.xpath("//button[@id='invite-emails']"), "Invite Button in Enter Email section");
		gm.getInnerText(By.xpath("//button[@id='invite-emails']"));
		gm.compareText(By.xpath("//button[@id='invite-emails']"), "Invite");

		gm.isElementPresent("//span[@class='sub-label']", "xpath");
		gm.getInnerText(By.xpath("//span[@class='sub-label']"));
		gm.compareText(By.xpath("//span[@class='sub-label']"), "Or share this url for people to join directly");

		gm.isElementPresent("team-url-btn", "id");
		gm.elementDisplayed(By.id("team-url-btn"), "URL Copy Icon");
		gm.click(By.id("team-url-btn"), 1);

		gm.elementDisplayed(By.id("team-url-lnk"), "Base Team URL");
		gm.getInnerText(By.id("team-url-lnk"));
		gm.compareText(By.id("team-url-lnk"), "riva.flock.com?i=vtbyzvbp2fbbf1qt");

		gm.elementDisplayed(By.xpath("//span[@id='close-btn']"), "Invite Modal Cancel Button");
	}

	public void inviteModalBackButton() throws Exception {
		Thread.sleep(2000);

		if (ce.backButtonInviteModalDisplayed()) {
			Thread.sleep(2000);
			ce.backButtonInviteModalClick();
			boolean result = driver.findElement(By.id("invite-heading")) != null;
			Assert.assertTrue(result);
			Thread.sleep(1000);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteModalBackButton Test Passed");
			log.info("inviteMoinviteModalBackButtondalError Test Passed");
		} else {
			test.log(LogStatus.PASS, "inviteModalBackButton Test FAILED");
			log.error("inviteModalBackButton Test FAILED");
		}
	}

	public void inviteAddInvalidEmail(String emails) throws InterruptedException {

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.EmailFieldImportScreenSendKey(emails);
			test.log(LogStatus.INFO, "Wrong Email ID entered in the field" + emails);
			log.info("Wrong Email ID entered in the field" + emails);

			boolean result = driver.findElement(
					By.xpath("//button[contains(@class,'invite-emails-btn') and contains(@class,'disabled')]")) != null;
			Assert.assertTrue(result);
			ce.EmailFieldImportScreenClear();
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteModalBlankErrorState on import screen Test Passed");
			log.info("inviteModalBlankErrorState on import screen Test Passed");
		} else {
			test.log(LogStatus.PASS, "inviteModalBlankErrorState on import screen Test FAILED");
			log.error("inviteModalBlankErrorState on import screen Test FAILED");
		}
	}

	public void inviteAddInvalidEmailGoogleImport(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.googleImportSearchFieldSendKey(emails);
			test.log(LogStatus.INFO, "Wrong Email ID entered in the field" + emails);
			log.info("Wrong Email ID entered in the field" + emails);

			boolean result = driver.findElement(
					By.xpath("//div[contains(@class,'profile-btn') and contains(@class,'disabled')]")) != null;
			Assert.assertTrue(result);
			ce.googleImportSearchFieldClear();
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteModalBlankErrorState on import screen Test Passed");
			log.info("inviteModalBlankErrorState on import screen Test Passed");
		} else {
			test.log(LogStatus.PASS, "inviteModalBlankErrorState on import screen Test FAILED");
			log.error("inviteModalBlankErrorState on import screen Test FAILED");
		}
	}

	public void inviteRoasterOpen() throws InterruptedException {
		Thread.sleep(2000);
		ce.rosterSideBarClick();
		Thread.sleep(2000);
		if (ce.inviteRosterPresent()) {
			ce.clickInviteRoster();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();

				if (ce.inviteContactModalDisplayed()) {
					gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
					inviteModalTextContent();

					boolean result = driver.findElement(By.xpath("//div[@id='invite-container']/div[2]/input")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
					test.log(LogStatus.PASS, "inviteModalContent (Roster Hook) Test Passed");
					log.info("inviteModalContent (Roster Hook) Test Passed");
				} else {
					test.log(LogStatus.FAIL, "inviteModalContent (Roster Hook) Test FAILED");
					log.error("inviteModalContent (Roster Hook) Test FAILED");
				}
			}
		}
	}

	public void inviteRecentOpen() throws InterruptedException {
		Thread.sleep(3000);
		//ce.rosterSideBarClick();
		if (ce.inviteRecentPresent()) {
			ce.clickInviteRecent();
			gm.switchToiFrame("invite-contact");
			Thread.sleep(2000);
			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();

				if (ce.inviteContactModalDisplayed()) {
					gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
					inviteModalTextContent();

					boolean result = driver.findElement(By.xpath("//div[@id='invite-container']/div[2]/input")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
					test.log(LogStatus.PASS, "inviteModalContent (Invite Hook Recent) Test Passed");
					log.info("inviteModalContent (Invite Hook Recent) Test Passed");
				} else {
					ce.clickInviteContactCancel();
					test.log(LogStatus.FAIL, "inviteModalContent (Invite Hook Recent) Test FAILED");
					log.error("inviteModalContent (Invite Hook Recent) Test FAILED");
				}
			}
		}
	}

	public void inviteAddValidEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);

		
			if (ce.inviteContactModalDisplayed()) {
				gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
				ce.googleImportSearchFieldSendKey(emails);
				test.log(LogStatus.INFO, "Email ID entered in the field" + emails);
				log.info("Email ID entered in the field" + emails);
				Thread.sleep(1000);
				ce.inviteButtonGoogleImportClick();

				Thread.sleep(1000);
				inviteModalinviteSucessState();
				Thread.sleep(1000);
				boolean result = driver.findElement(
						By.xpath("//div[contains(@class,'profile-btn') and contains(@class,'invite-send')]")) != null;
				Assert.assertTrue(result);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "inviteAddValidEmail Test Passed");
				log.info("inviteAddValidEmail Test Passed");
			} else {
				test.log(LogStatus.FAIL, "inviteAddValidEmail Test FAILED");
				log.error("inviteAddValidEmail Test FAILED");
			}
	}

	public void inviteModalinviteSucessState() {
		gm.elementDisplayed(By.xpath("//div[contains(@class,'profile-btn') and contains(@class,'invite-send')]"),
				"Invite Sucess sent confirmation");
		gm.getText(By.xpath("//div[contains(@class,'profile-btn') and contains(@class,'invite-send')]"));
		gm.compareText(By.xpath("//div[contains(@class,'profile-btn') and contains(@class,'invite-send')]"),
				"Invite sent");
	}

	public void inviteAddValidFieldEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.EmailFieldImportScreenSendKey(emails);
			test.log(LogStatus.INFO, "Email ID entered in the field" + emails);
			log.info("Email ID entered in the field" + emails);
			Thread.sleep(1000);
			ce.inviteButtonFieldImportClick();

			Thread.sleep(1000);
			inviteModalinviteSucess();
			Thread.sleep(1000);
			boolean result = driver.findElement(By.id("notification")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteAddValidFieldEmail Test Passed");
			log.info("inviteAddValidFieldEmail Test Passed");
		} else {
			test.log(LogStatus.FAIL, "inviteAddValidFieldEmail Test FAILED");
			log.error("inviteAddValidFieldEmail Test FAILED");
		}
	}

	public void inviteModalinviteSucess() {
		gm.elementDisplayed(By.id("notification"), "Invite Sucess Notification");
		gm.getText(By.id("notification"));
		gm.compareText(By.id("notification"), "Invite sent to test@directi.com");
	}

	public void inviteModalContactTab() throws InterruptedException {
		Thread.sleep(2000);
		if (ce.rosterContactTabDisplayed()) {
			ce.rosterContactTabClick();
			Thread.sleep(1000);

			if (ce.inviteHookContactTabDisplayed()) {
				ce.inviteHookContactTabClick();

				gm.switchToiFrame("invite-contact");

				if (ce.forkModalDisplayed()) {
					ce.fullMemberHookClick();

					Thread.sleep(2000);
					inviteModalTextContent();
					boolean result = driver.findElement(By.xpath("//div[@id='invite-container']/div[2]/input")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
					test.log(LogStatus.PASS, "inviteModalContent (Contact tab) Test Passed");
					log.info("inviteModalContent (Contact tab) Test Passed");
				} else {
					test.log(LogStatus.FAIL, "inviteModalContent (Contact tab) Test Failed");
					log.error("inviteModalContent (Contact tab) Test Failed");
				}
			}
		}
	}

	public void inviteModalNoSearchResult() throws InterruptedException {
		Thread.sleep(2000);
		if (ce.rosterContactTabDisplayed()) {
			ce.rosterContactTabClick();
			Thread.sleep(1000);
			if (ce.searchFieldContactTabDisplayed()) {
				ce.searchFieldContactTabClick();
				Thread.sleep(1000);
				ce.searchFieldContactTabSendKey("dhdhhfdjdkkdkdk");
				Thread.sleep(1000);
				emptyContactTabInviteModalContent();
				boolean result = driver.findElement(By.xpath(
						"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]")) != null;
				Assert.assertTrue(result);
				test.log(LogStatus.PASS, "inviteModalNoSearchResult Test Passed");
				log.info("inviteModalNoSearchResult Test Passed");
			}
		} else {
			test.log(LogStatus.PASS, "inviteModalNoSearchResult Test Failed");
			log.error("inviteModalNoSearchResult Test Failed");
		}
	}

	public void emptyContactTabInviteModalContent() {
		if (gm.elementDisplayed(By.className("noResult"), "No channel is displayed")) {
			gm.elementDisplayed(By.className("noResult"), "No results found text");
			gm.getInnerText(By.className("noResult"));
			gm.compareText(By.className("noResult"), "No results found");

			if (gm.elementDisplayed(
					By.xpath("//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]"),
					"Invite Modal for Empty Contact List")) {

				gm.elementDisplayed(By.xpath("//div[@class='empty-invite-img']"), "Envelope Icon in the empty state");

				gm.elementDisplayed(By.xpath("//div[contains(@class,'emptyContacts ')]//div[@class='empty-text']"),
						"Empty Contact Sub Header");
				gm.getInnerText(By.xpath("//div[contains(@class,'emptyContacts ')]//div[@class='empty-text']"));
				gm.compareText(By.xpath("//div[contains(@class,'emptyContacts ')]//div[@class='empty-text']"),
						"Invite team members");

				gm.elementDisplayed(
						By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"),
						"Invite Hook in empty state");
				gm.getInnerText(
						By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"));
				gm.compareText(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"),
						"Invite team members");
				gm.click(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"), 0);

				gm.switchToiFrame("invite-contact");
				log.debug("Inside the iframe invite-contact");

				boolean result = driver.findElement(By.id("invite-heading")) != null;
				Assert.assertTrue(result);
				ce.clickInviteContactCancel();

			} else {
				log.error("emptyContactTabInviteModalContent Test FAILED");
				test.log(LogStatus.FAIL, "emptyContactTabInviteModalContent Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The contact empty state is not displayed");
				sa.assertAll();
			}
		} else {
			log.error("emptyContactTabInviteModalContent Test FAILED");
			test.log(LogStatus.FAIL, "emptyContactTabInviteModalContent Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The tester's contact is not displayed in the search results");
			sa.assertAll();
		}
	}

	public void universalSearchInviteContent() throws InterruptedException {
		Thread.sleep(2000);
		if (ce.universalSearchBarEditorPresent()) {
			universalSearchContent();
			boolean result = driver.findElement(By.id("convSearch")) != null;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "universalSearchInviteContact Test pass");
			log.info("universalSearchInviteContact Test pass");
		} else {
			test.log(LogStatus.FAIL, "universalSearchInviteContact Test Failed");
			log.error("universalSearchInviteContact Test Failed");
		}
	}

	public void universalSearchContent() {
		gm.elementDisplayed(By.xpath("//div[@class='search__handle-search']"),
				"Magnify glass icon in universal search bar");

		gm.elementDisplayed(By.id("convSearch"), "Universal Serch Place Holder");
		gm.getText(By.id("convSearch"));
		gm.compareText(By.id("convSearch"), "Start 99+ chat (Ctrl+K)");
	}

	public void universearchInviteUser() throws InterruptedException {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		Thread.sleep(2000);
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click();
			actions.sendKeys(generatedString+"@flock.com");
			actions.build().perform();
			Thread.sleep(1000);

			ce.inviteContactUniversalSearchClick();
			Thread.sleep(5000);
			String contactName= ce.selectedChannelName.getText();
			log.info(contactName);
			log.info(generatedString);
			
			int var = generatedString.compareToIgnoreCase(contactName);
			boolean result = var == 0;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "universearchInviteUser Test pass");
			log.info("universearchInviteUser Test pass");

		}else{
			log.info("universearchInviteUser Test FAILED");
			test.log(LogStatus.FAIL, "universearchInviteUser Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Universal Search bar Editore is not displayed");
			sa.assertAll();
		}
	}
	
	public void universearchBlockedContact() throws InterruptedException{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		Thread.sleep(2000);
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click();
			actions.sendKeys(generatedString+"@directi.com");
			actions.build().perform();
			Thread.sleep(1000);

			ce.inviteContactUniversalSearchClick();
			Thread.sleep(2000);
			
			inviteRestrictionModal();
			
			boolean result = ce.inviteRestrictionModal != null;
			Assert.assertTrue(result);
			Thread.sleep(3000);
			ce.inviteRestrictionCanel.click();
		}else{
			log.info("universearchBlockedContact Test FAILED");
			test.log(LogStatus.FAIL, "universearchBlockedContact Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Universal Search bar Editore is not displayed");
			sa.assertAll();
		}
	}
	
	public void inviteRestrictionModal(){
		if(ce.inviteRestrictionModal.isDisplayed()){
			gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='title']"), "Invite Restriction Heading");
			gm.getText(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='title']"));
			gm.compareText(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='title']"), "Could not send invites");
			
			gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='sub-title']"), "Invite Restriction Sub-Heading");
			gm.getText(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='sub-title']"));
			gm.compareText(By.xpath("//div[contains(@class,'invite-restriction')]//div[@class='sub-title']"), "Sorry, you are not allowed to take this action. Please contact team administrator for help.");
			
			ce.inviteRestrictionCanel.isDisplayed();
			ce.inviteRestrictionCanel.getText().contentEquals("Cancel");
			
			ce.inviteRestrictionShowAdmin.isDisplayed();
			ce.inviteRestrictionShowAdmin.getText().contentEquals("Show Team Admins");
			
		}else{
			log.info("inviteRestrictionModal Test FAILED");
			test.log(LogStatus.FAIL, "inviteRestrictionModal Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The invite restriction modal is not displayed");
			sa.assertAll();
		}
	}

	public void blockedExternalContact(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.googleImportSearchFieldSendKey(emails);
			test.log(LogStatus.INFO, "Blocked Ext Contact is" + emails);
			log.info("Blocked Ext Contact is" + emails);
			ce.inviteButtonGoogleImportClick();
			Thread.sleep(1000);
			inviteBlockExtContError();
			Thread.sleep(1000);
			boolean result = driver.findElement(By.id("notification")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "blockedExternalContact Test Passed");
			log.info("blockedExternalContact Test Passed");

		} else {
			ce.clickInviteContactCancel();
			test.log(LogStatus.FAIL, "blockedExternalContact Test FAILED");
			log.error("blockedExternalContact Test FAILED");
		}
	}

	public void inviteBlockExtContError() {
		gm.elementDisplayed(By.id("notification"), "Invite Blocked Ext Contact Notification");
		gm.getText(By.id("notification"));
		gm.compareText(By.id("notification"), "You do not have privileges to invite members to this team");
	}

	public void inviteAdminInviteOnly(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.googleImportSearchFieldSendKey(emails);
			test.log(LogStatus.INFO, "Admin Only Invite Contact is" + emails);
			log.info("Admin Only Invite Contact is" + emails);
			Thread.sleep(1000);
			ce.inviteButtonGoogleImportClick();
			Thread.sleep(1000);
			inviteAdminOnlyError();
			Thread.sleep(1000);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteAdminInviteOnly Test Passed");
			log.info("inviteAdminInviteOnly Test Passed");
		} else {
			test.log(LogStatus.FAIL, "inviteAdminInviteOnly Test FAILED");
			log.error("inviteAdminInviteOnly Test FAILED");
		}

	}

	public void inviteAdminOnlyError() {
		gm.elementDisplayed(By.id("notification"), "Invite Blocked Ext Contact Notification");
		gm.getText(By.id("notification"));
		gm.compareText(By.id("notification"), "You do not have privileges to invite members to this team");
	}

	public void recentEmptyContactInviteModal() throws Exception {

		Thread.sleep(2000);
		if(ce.emptyContactTeamDisplayed()){
			ce.emptyContactTeamClick();
			if (ce.rosterRecentTabDisplayed()) {
				Thread.sleep(1000);
				emptyRecentContactInviteModalContent();
				boolean result = driver.findElement(By.xpath(
						"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]")) != null;
				Assert.assertTrue(result);
				test.log(LogStatus.PASS, "recentEmptyContactInviteModal Test Passed");
				log.info("recentEmptyContactInviteModal Test Passed");
			} else {
				test.log(LogStatus.FAIL, "recentEmptyContactInviteModal Test FAILED");
				log.info("recentEmptyContactInviteModal Test FAILED");
			}
		}	
		}

	

		

	public void rosterTabInviteModal() throws Exception {
		Thread.sleep(2000);
		if (ce.rosterContactTabDisplayed()) {
			ce.rosterContactTabClick();
			Thread.sleep(1000);
			emptyContactInviteModalContent();
			boolean result = driver.findElement(By.xpath(
					"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]")) != null;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "recentEmptyContactInviteModal Test Passed");
			log.info("recentEmptyContactInviteModal Test Passed");
			ce.primaryTeamClick();
		} else {
			test.log(LogStatus.FAIL, "recentEmptyContactInviteModal Test Failed");
			log.error("recentEmptyContactInviteModal Test Failed");
		}
	}

	public void emptyContactInviteModalContent() {
		if (gm.elementDisplayed(
				By.xpath("//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]"),
				"Invite Modal for Empty Contact List")) {

			gm.elementDisplayed(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"),
					"Empty Contact List Invite Modal Header");
			gm.getInnerText(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"));
			gm.compareText(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"), "Invite team members");

			gm.elementDisplayed(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_6']"), "Email input Field");
			gm.getInnerText(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_6']/input"));
			gm.compareText(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_6']/input"),
					"Enter an email ID");

			gm.elementDisplayed(
					By.xpath(
							"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"),
					"Invite button");
			gm.getInnerText(By.xpath(
					"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"));
			gm.compareText(
					By.xpath(
							"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"),
					"Invite");

			gm.elementDisplayed(
					By.xpath(
							"//div[@class='roster-link-share']/p"),
					"Team URL header ");
			gm.getInnerText(By.xpath(
					"//div[@class='roster-link-share']/p"));
			gm.compareText(
					By.xpath(
							"//div[@class='roster-link-share']/p"),
					"Or share this URL with your team");

			gm.elementDisplayed(By.xpath("//div[@class='contacts-team-url-multicolor-container']"), "Team URL Field");
			gm.elementDisplayed(By.xpath("//div[@class='copy-team-url']"), "Team URL Copy Icons");
			gm.click(By.xpath("//div[@class='copy-team-url']"), 0);
			gm.elementDisplayed(By.xpath("//span[@class='contacts-team-url-base']"), "Base Team URL");
			gm.getText(By.xpath("//span[@class='contacts-team-url-base']"));
			gm.compareText(By.xpath("//span[@class='contacts-team-url-base']"), "nomembers.flock.com");
			gm.elementDisplayed(By.xpath("//span[@class='contacts-team-url-query']"), "Base Team URL Invitor Guid");
			gm.getText(By.xpath("//span[@class='contacts-team-url-query']"));
			gm.compareText(By.xpath("//span[@class='contacts-team-url-query']"), "?i=qq2qgo48o1941g41");
		}
	}

	public void emptyRecentContactInviteModalContent() {
		if (gm.elementDisplayed(
				By.xpath("//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]"),
				"Invite Modal for Empty Contact List")) {

			gm.elementDisplayed(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"),
					"Empty Contact List Invite Modal Header");
			gm.getInnerText(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"));
			gm.compareText(By.xpath("//div[@class='emptyRosterDiv']/div[@class='title']"), "Invite team members");

			gm.elementDisplayed(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_4']"), "Email input Field");
			gm.getInnerText(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_4']/input"));
			gm.compareText(By.xpath("//div[@id='widgets_contact_search_UniversalSearch_4']/input"),
					"Enter an email ID");

			gm.elementDisplayed(
					By.xpath(
							"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"),
					"Invite button");
			gm.getInnerText(By.xpath(
					"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"));
			gm.compareText(
					By.xpath(
							"//div[contains(@class,'emptyContacts') and contains(@class,'contacts-all-empty')]//button"),
					"Invite");

			gm.elementDisplayed(
					By.xpath(
							"//div[@class='roster-link-share']/p"),
					"Team URL header ");
			gm.getInnerText(By.xpath(
					"//div[@class='roster-link-share']/p"));
			gm.compareText(
					By.xpath(
							"//div[@class='roster-link-share']/p"),
					"Or share this URL with your team");

			gm.elementDisplayed(By.xpath("//div[@class='contacts-team-url-multicolor-container']"), "Team URL Field");
			gm.elementDisplayed(By.xpath("//div[@class='copy-team-url']"), "Team URL Copy Icons");
			gm.click(By.xpath("//div[@class='copy-team-url']"), 0);
			gm.elementDisplayed(By.xpath("//span[@class='contacts-team-url-base']"), "Base Team URL");
			gm.getText(By.xpath("//span[@class='contacts-team-url-base']"));
			gm.compareText(By.xpath("//span[@class='contacts-team-url-base']"), "nomembers.flock.com");
			gm.elementDisplayed(By.xpath("//span[@class='contacts-team-url-query']"), "Base Team URL Invitor Guid");
			gm.getText(By.xpath("//span[@class='contacts-team-url-query']"));
			gm.compareText(By.xpath("//span[@class='contacts-team-url-query']"), "?i=qq2qgo48o1941g41");
		}
	}
	
	public void activeChatInvite() throws Exception {
		Thread.sleep(2000);
		if (ce.activeChatDisplayed()) {
			
			activChatInviteContent();
			boolean result = driver.findElement(By.xpath(
					"//div[@data-dojo-attach-point='activeBucketInvite']")) != null;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "activeChatInvite Test Passed");
			log.info("activeChatInvite Test Passed");
			ce.primaryTeamClick();
		} else {
			test.log(LogStatus.FAIL, "activeChatInvite Test Failed");
			log.error("activeChatInvite Test Failed");
		}
	}
	
	public void activChatInviteContent(){
		if(gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']"), "Active Chat Invite Blurb")){
			
			gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//div[@class='title']"),
					"Active Chat Invite Modal Header");
			gm.getInnerText(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//div[@class='title']"));
			gm.compareText(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//div[@class='title']"), "Invite team members");
			
			gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//input[@placeholder='Enter an email ID']"),
					"Active Chat Invite Modal Field");
			gm.getInnerText(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//input[@placeholder='Enter an email ID']"));
			gm.compareText(By.xpath("//div[@data-dojo-attach-point='activeBucketInvite']//input[@placeholder='Enter an email ID']"), "Enter an email ID");
			
			gm.elementDisplayed(By.xpath("//div[@class='invite-link-share-label']"),
					"Active Chat Invite Modal URL share header");
			gm.getInnerText(By.xpath("//div[@class='invite-link-share-label']"));
			gm.compareText(By.xpath("//div[@class='invite-link-share-label']"), "Or share your team URL");
			
			gm.elementDisplayed(By.xpath("//span[@class='contacts-team-url-base']"),
					"Active Chat Invite Modal URL");
			gm.getInnerText(By.xpath("//span[@class='contacts-team-url-base']"));
			gm.compareText(By.xpath("//span[@class='contacts-team-url-base']"), "nomemberteam.flock.com");
			
			gm.click(By.xpath("//span[@class='contacts-team-url-base']"), 0);
			
		}else{
			test.log(LogStatus.FAIL, "activChatInviteContent Test Failed");
			log.error("activChatInviteContent Test Failed");
		}
	}

}
