package com.Flock.HydraAutomation;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.DataInputs;

public class inviteContact extends BaseTestSuite {
	/*
	 * Created on 11th Jan 2018 By Farzan Shaikh By Farzan Shaikh
	 */

	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());

	@Test(priority = 1) // Invite Fork page content
	public void inviteFullMember() throws Exception {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				google.forkModalContent();
				boolean result = driver.findElement(By.id("invite-heading")) != null;
				Assert.assertTrue(result);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "inviteForkModalContent Test Passed");
				log.info("inviteForkModalContent Test Passed");
			} else {
				ce.clickInviteContactCancel();
				log.error("inviteAddValidEmail Test FAILED");
				test.log(LogStatus.FAIL, "inviteAddValidEmail Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 2)
	public void fullMemberInviteModal() {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.fullMemberInviteModalContent();
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.fullMemberInviteModalContent();
				} else {
					ce.clickInviteContactCancel();
					log.info("fullMemberInviteModal Test FAILED");
					test.log(LogStatus.FAIL, "fullMemberInviteModal Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("fullMemberInviteModal Test FAILED");
				test.log(LogStatus.FAIL, "fullMemberInviteModal Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 3)
	public void inviteBackAction() throws Exception {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.inviteModalBackButton();
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.inviteModalBackButton();
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteBackAction Test FAILED");
					test.log(LogStatus.FAIL, "inviteBackAction Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed ");
					sa.assertAll();
				}
			} else {
				log.info("inviteBackAction Test FAILED");
				test.log(LogStatus.FAIL, "inviteBackAction Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork Modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 4, dataProvider = "wrongEmails", dataProviderClass = DataInputs.class)
	public void inviteInvalidEmail(String emails) throws Exception {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.inviteAddInvalidEmail(emails);
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.inviteAddInvalidEmail(emails);
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteInvalidEmail Test FAILED");
					test.log(LogStatus.FAIL, "inviteInvalidEmail Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("inviteInvalidEmail Test FAILED");
				test.log(LogStatus.FAIL, "inviteInvalidEmail Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "TThe fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 5, dataProvider = "wrongEmails", dataProviderClass = DataInputs.class)
	public void inviteInvalidEmailGoogleScreen(String emails) throws Exception {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.inviteAddInvalidEmailGoogleImport(emails);
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteInvalidEmailGoogleScreen Test FAILED");
					test.log(LogStatus.FAIL, "inviteInvalidEmailGoogleScreen Test FAILED");
				}
			} else {
				log.info("inviteInvalidEmailGoogleScreen Test FAILED");
				test.log(LogStatus.FAIL, "inviteInvalidEmailGoogleScreen Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 6)
	public void inviteRoasterOpen() throws InterruptedException {
		ce.dismissCalendarPrompt();
		google.inviteRecentOpen();
	}

	@Test(priority = 8)
	public void inviteAddValidEmail() throws Exception {
		String emails = RandomStringUtils.randomAlphabetic(10) + "@flock.com";
		Thread.sleep(3000);
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			Thread.sleep(3000);
			gm.switchToiFrame("invite-contact");
			Thread.sleep(3000);
			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.inviteAddValidEmail(emails);
					Thread.sleep(2000);
					google.inviteAddValidFieldEmail(emails);
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.inviteAddValidEmail(emails);
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteAddValidEmail Test FAILED");
					test.log(LogStatus.FAIL, "inviteAddValidEmail Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("inviteAddValidEmail Test FAILED");
				test.log(LogStatus.FAIL, "inviteAddValidEmail Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 7)
	public void inviteRecentOpen() throws InterruptedException {
		google.inviteRecentOpen();
	}

	@Test(priority = 9)
	public void inviteModalContactTab() throws InterruptedException {

		if (ce.inviteAppMenuPresent()) {
			ce.clickInviteRecent();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.fullMemberInviteModalContent();
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.fullMemberInviteModalContent();
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteModalContactTab Test FAILED");
					test.log(LogStatus.FAIL, "inviteModalContactTab Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("inviteModalContactTab Test FAILED");
				test.log(LogStatus.FAIL, "inviteModalContactTab Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 10)
	public void inviteModalNoSearchResult() throws InterruptedException {
		google.inviteModalNoSearchResult();
	}

	@Test(priority = 11)
	public void universalSearchInviteContent() throws InterruptedException {
		google.universalSearchInviteContent();
	}

	@Test(priority = 12)
	public void universearchBlockedContact() throws InterruptedException {
		google.universearchBlockedContact();
	}

	@Test(priority = 13)
	public void universearchInviteUser() throws InterruptedException {
		google.universearchInviteUser();
	}

	@Test(priority = 14)
	public void blockedExternalContact() throws InterruptedException {
		gm.click(By.id("shell_teamSwitcher_Team_2"), 0);
		String emails = RandomStringUtils.randomAlphabetic(10) + "@riva.com";
		Thread.sleep(2000);
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();

				if (ce.googleImportSearchFieldDisplayed()) {
					google.blockedExternalContact(emails);
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.blockedExternalContact(emails);
				} else {
					ce.clickInviteContactCancel();
					log.info("blockedExternalContact Test FAILED");
					test.log(LogStatus.FAIL, "blockedExternalContact Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("blockedExternalContact Test FAILED");
				test.log(LogStatus.FAIL, "blockedExternalContact Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 15)
	public void inviteAdminInviteOnly() throws InterruptedException {
		String emails = RandomStringUtils.randomAlphabetic(10) + "@riva.com";
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.googleImportSearchFieldDisplayed()) {
					google.inviteAdminInviteOnly(emails);
				} else if (ce.fullMemberInviteContainerDisplayed()) {
					fe.inviteAdminInviteOnly(emails);
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteAdminInviteOnly Test FAILED");
					test.log(LogStatus.FAIL, "inviteAdminInviteOnly Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("inviteAdminInviteOnly Test FAILED");
				test.log(LogStatus.FAIL, "inviteAdminInviteOnly Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 16)
	public void recentEmptyContactInviteModal() throws Exception {
		google.recentEmptyContactInviteModal();
	}

	@Test(priority = 17)
	public void rosterTabInviteModal() throws Exception {
		google.rosterTabInviteModal();
	}

	@Test(priority = 18)
	public void inviteModalInLineError() throws Exception {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");

			if (ce.forkModalDisplayed()) {
				ce.fullMemberHookClick();
				if (ce.fullMemberInviteContainerDisplayed()) {
					fe.inviteModalInLineError();
				} else {
					ce.clickInviteContactCancel();
					log.info("inviteModalInLineError Test FAILED");
					test.log(LogStatus.FAIL, "inviteModalInLineError Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The full member invite modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("inviteModalInLineError Test FAILED");
				test.log(LogStatus.FAIL, "inviteModalInLineError Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 19)
	public void activeChatInviteModal() throws Exception {
		google.activeChatInvite();
	}

	@Test(priority = 20)
	public void inviteGuestModalContent() throws InterruptedException {
		ge.guestMemberModalContent();
	}

	@Test(priority = 21)
	public void inviteGuestModalInLineError() throws Exception {
		ge.inviteModalInLineError();
	}

	@Test(priority = 22)
	public void guestInviteMoreFieldOpen() throws Exception {
		ge.guestInviteMoreButton();
	}

	@Test(priority = 23)
	public void validtyReminderContent() throws InterruptedException {
		ge.validtyReminderHook();
	}

	@Test(priority = 24, dataProvider = "wrongEmails", dataProviderClass = DataInputs.class)
	public void guestInviteInvalidEmail(String emails) throws InterruptedException {
		ge.inviteGuestAddInvalidEmail(emails);
	}

	@Test(priority = 25)
	public void setValidityReminder() throws InterruptedException {
		ge.setValidityReminder();
	}

	@Test(priority = 26)
	public void guestInviteValidEmail() throws Exception {
		String emails = RandomStringUtils.randomAlphabetic(10) + "@yopmail.com";
		ge.inviteGuestAddValidEmail(emails);
		Thread.sleep(2000);
		ge.setGuestAccessContent();
		Thread.sleep(1000);
		ge.setGuestAccess();
		Thread.sleep(2000);
		ce.doneButtonGuestAccessClick();
		Thread.sleep(2000);
		ge.guestSucessScreen();
		Thread.sleep(3000);
		clearTestChannel();
		driver.switchTo().defaultContent();

	}

	public void clearTestChannel() throws Exception {
		Thread.sleep(2000);
		ce1.openChannelRoster("Testers Channel");
		Thread.sleep(2000);
		driver.switchTo().frame(ce1.appIframe);

		ce1.textEditor.click();
		ce1.textEditor.sendKeys("/leave");
		if (ce1.slashLeaveDisplayed()) {
			ce1.slashLeaveDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash leave shortcuts using enter");
			test.log(LogStatus.INFO, "Selected the leave keyboard shortcuts using enter");
			driver.switchTo().defaultContent();
			if (ce1.leaveChannelConfirmationTitlePresent()) {
				ce1.leaveDeleteChannelButton.click();
				log.info("Left channel using slash Leave");
				test.log(LogStatus.PASS, "Left channel using slash Leave");
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
			} else {
				driver.switchTo().frame(ce1.appIframe);
				log.info("Leave Channel Confirmation Box was not displayed using slash Leave");
				test.log(LogStatus.FAIL, "Leave Channel Confirmation Box was not displayed using slash Leave");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Leave Channel Confirmation Box was not displayed using slash Leave");
				sa.assertAll();
			}
		}
	}

}
