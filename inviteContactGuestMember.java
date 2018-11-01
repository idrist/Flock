package com.inviteContacts;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericMethods;
import com.utilities.OnBoardingUtils;
import com.utilities.clientElement;

public class inviteContactGuestMember {
	/*
	 * Created on 15th Jan 2018 By Farzan Shaikh
	 */

	ExtentTest test;
	WebDriver driver = null;
	private GenericMethods gm;
	private clientElement ce;

	private static final Logger log = LogManager.getLogger(OnBoardingUtils.class.getName());

	public inviteContactGuestMember(WebDriver webDriver, ExtentTest test) {
		this.driver = webDriver;
		this.test = test;
		gm = new GenericMethods(this.driver);
		ce = new clientElement(this.driver, this.test);
	}

	public void guestMemberModalContent() throws InterruptedException {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) 
			{
				Thread.sleep(1000);
				ce.guestMemberHookClick();

				inviteGuestModalContent();

				boolean result = driver.findElement(By.id("invite-heading")) != null;
				Assert.assertTrue(result);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "inviteGuestModalContent Test Passed");
				log.info("inviteGuestModalContent Test Passed");
			} else {
				test.log(LogStatus.FAIL, "inviteGuestModalContent Test FAILED");
				log.error("inviteGuestModalContent Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
			
		}
	}

	public void inviteGuestModalContent() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		gm.elementDisplayed(By.xpath("//span[@id='back-btn']"), "Back Button on the Guest Member Invite Modal");
		gm.elementDisplayed(By.id("close-btn"), "Cancel Button on the Guest Member Invite Modal");

		gm.elementDisplayed(By.id("invite-desc"), "Invite Sub-Heading on the Guest Member Invite Modal");
		gm.getInnerText(By.id("invite-desc"));
		gm.compareText(By.id("invite-desc"), "Guests have limited access.");

		gm.elementDisplayed(By.className("learn-more"), "Learn more link on Guest Page");
		gm.getInnerText(By.className("learn-more"));
		gm.compareText(By.className("learn-more"), "Learn more");

		gm.click(By.className("learn-more"), 0);
		ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(applink.get(1));
		Thread.sleep(5000);
		sa.assertEquals(driver.getCurrentUrl(),
				"https://support.flock.com/hc/en-us/articles/115004379653-Guest-Accounts");
		log.info("Url's matched");
		driver.close();
		driver.switchTo().window(applink.get(0));
		Thread.sleep(2000);
		sa.assertAll();
		gm.switchToiFrame("invite-contact");

		gm.elementDisplayed(By.xpath("//div[@id='input-list']/div[1]"),
				"Email input field on the Guest Member Invite Modal");
		gm.getInnerText(By.xpath("//div[@id='input-list']/div[1]"));
		gm.compareText(By.xpath("//div[@id='input-list']/div[1]"), "Enter a valid email address");

		gm.elementDisplayed(By.id("invite-more"), "Invite More hook on the Guest Member Invite Modal");
		gm.getInnerText(By.id("invite-more"));
		gm.compareText(By.id("invite-more"), "Invite more");

		gm.elementDisplayed(By.id("reminder-title"), "Set Validity Reminder hook on the Guest Member Invite Modal");
		gm.getInnerText(By.id("reminder-title"));
		gm.compareText(By.id("reminder-title"), "Set a reminder to review membership (optional)");

		gm.elementDisplayed(By.id("invite-guest-btn"), "Guest Invite Button on the Guest Member Invite Modal");
		gm.getInnerText(By.id("invite-guest-btn"));
		gm.compareText(By.id("invite-guest-btn"), "Invite and Proceed");
	}

	public void lernMore() throws InterruptedException {
		SoftAssert sa = new SoftAssert();

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);

		gm.click(By.className("learn-more"), 0);

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(4000);
				sa.assertEquals(driver.getCurrentUrl(),
						"https://support.flock.com/hc/en-us/articles/115004379653-Guest-Accounts");
				Thread.sleep(2000);
				driver.close();
				sa.assertAll();
				log.info("URL's are equal");
				break;
			}
		}
		driver.switchTo().window(parentHandle);
		log.info("URL's are equal");
		gm.switchToiFrame("invite-contact");
	}

	public void inviteModalInLineError() throws Exception {
		Thread.sleep(2000);

		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();
				Thread.sleep(2000);
				ce.guestInviteButtonClick();
				inviteModalBlankErrorState();
				boolean result = driver.findElement(By.id("error0")) != null;
				Assert.assertTrue(result);
				Thread.sleep(1000);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "inviteGuestModalInLineError Test Passed");
				log.info("inviteGuestModalInLineError Test Passed");
			} else {
				test.log(LogStatus.FAIL, "inviteGuestModalInLineError Test FAILED");
				log.error("inviteGuestModalInLineError Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	public void inviteModalBlankErrorState() {
		gm.waitForElement(By.id("invite-guest-btn"), 10);
		gm.isElementPresent("guest-error0", "id");
		gm.elementDisplayed(By.id("guest-error0"), "Invite Modal Error State");
		gm.getText(By.id("guest-error0"));
		gm.compareText(By.id("guest-error0"), "Enter a valid email address");
	}

	public void guestInviteMoreButton() throws Exception {

		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();
				Thread.sleep(1000);
				ce.guestInviteMoreButtonClick();

				boolean result = driver.findElement(By.xpath("//div[@id='input-list']/div[4]")) != null;
				Assert.assertTrue(result);
				Thread.sleep(1000);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "guestInviteMoreFieldOpen Test Passed");
				log.info("guestInviteMoreFieldOpen Test Passed");
			} else {
				test.log(LogStatus.FAIL, "guestInviteMoreFieldOpen Test FAILED");
				log.error("guestInviteMoreFieldOpen Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	public void validtyReminderHook() throws InterruptedException {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();

				if (gm.isElementPresent("//div[contains(@class,'guest-reminder') and contains(@class,'toggle')]",
						"xpath")) {
					ce.validityReminderHookClick();
					validtyReminderContent();
				} else if (gm.isElementPresent("guest-reminder", "classname")) {
					validtyReminderContent();
				}

				boolean result = driver.findElement(By.id("reminder-input")) != null;
				Assert.assertTrue(result);
				Thread.sleep(1000);
				ce.clickInviteContactCancel();
				test.log(LogStatus.PASS, "validtyReminderContent Test Passed");
				log.info("validtyReminderContent Test Passed");
			} else {
				test.log(LogStatus.FAIL, "validtyReminderContent Test FAILED");
				log.error("validtyReminderContent Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	public void validtyReminderContent() {

		ce.validityReminderHookDisplayed();
		gm.getInnerText(By.id("reminder-title"));
		gm.compareText(By.id("reminder-title"), "Set a reminder to review membership (optional)");

		ce.validityReminderFieldDisplayed();
		gm.getInnerText(By.id("reminder-input"));
		gm.compareText(By.id("reminder-input"), "Set a reminder date");

		gm.elementDisplayed(By.xpath("//div[@id='reminder-div']/div[@class='note']"), "Validty Reminder Input Field");
		gm.getInnerText(By.xpath("//div[@id='reminder-div']/div[@class='note']"));
		gm.compareText(By.xpath("//div[@id='reminder-div']/div[@class='note']"),
				"Your team admin(s) will be reminded to renew or remove guest accounts");

		ce.validityReminderFieldClick();

		ce.validityDatePickerDisplayed();
	}

	public void inviteGuestAddInvalidEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();

				if (ce.guestInputFieldDisplayed()) {
					gm.waitForElement(By.id("invite-guest-btn"), 10);
					ce.guestInputFieldSendKey(emails);
					ce.guestInviteButtonClick();
					test.log(LogStatus.INFO, "Wrong Email ID entered in the field " + emails);
					log.info("Wrong Email ID entered in the field " + emails);

					ce.inviteModalInputsClear();

					boolean result = driver.findElement(By.id("guest-error0")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
					test.log(LogStatus.PASS, "guestInviteInvalidEmail Test Passed");
					log.info("guestInviteInvalidEmail Test Passed");
				} else {
					test.log(LogStatus.FAIL, "guestInviteInvalidEmail Test FAILED");
					log.error("guestInviteInvalidEmail Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The guest input field is not displayed");
					sa.assertAll();
				}
			}else{
				test.log(LogStatus.FAIL, "guestInviteInvalidEmail Test FAILED");
				log.error("guestInviteInvalidEmail Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	public void setValidityReminder() throws InterruptedException {
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();

				if (ce.validityReminderHookDisplayed()) {
					ce.validityReminderHookClick();
					ce.validityReminderFieldClick();
					datePickerContent();
					boolean result = driver.findElement(By.id("guest-error0")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
					test.log(LogStatus.PASS, "setValidityReminder Test Passed");
					log.info("setValidityReminder Test Passed");
				} else {
					test.log(LogStatus.FAIL, "setValidityReminder Test FAILED");
					log.error("setValidityReminder Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The fork modal is not displayed");
					sa.assertAll();
				}
			}
		}
	}

	public void datePickerContent() throws InterruptedException {
		if (ce.validityReminderFieldDisplayed()) {
			gm.click(By.id("reminder-input"), 0);
			gm.elementDisplayed(By.xpath("//table[@class='datepicker-body']"), "Calendar for a month");

			gm.elementDisplayed(By.className("month-year"), "Current Month of the Calendar");
			gm.getInnerText(By.className("month-year"));

			gm.elementDisplayed(By.className("prev-arrow"), "Previous month navigation arrow is displayed");
			gm.elementDisplayed(By.className("next-arrow"), "Next month Navigation arrow is displayed");

			gm.elementDisplayed(By.xpath("//td[contains(@class,'today') and contains(@class,'valid')]"), "Todays Date");
			gm.getInnerText(By.xpath("//td[contains(@class,'today') and contains(@class,'valid')]"));
			gm.click(By.xpath("//td[contains(@class,'today') and contains(@class,'valid')]"), 0);
			Thread.sleep(3000);
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(250,0)", "");
			gm.getInnerText(By.id("reminder-input"));
			ce.clickInviteContactCancel();*/
			test.log(LogStatus.PASS, "selectDate Test Passed");
			log.info("Date selected from the calendar");
		} else {
			test.log(LogStatus.FAIL, "selectDate Test Failed");
			log.info("Date not selected from the calendar");
		}

			/*WebElement calMonth = driver.findElement(By.className("datepicker-body"));

			List<WebElement> allValidDates = calMonth.findElements(By.tagName("td"));

			Thread.sleep(3000);

			for (WebElement date : allValidDates) {
				if (date.getText().equals("31")) {
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					date.click();
					test.log(LogStatus.PASS, "selectDate Test Passed");
					log.info("Date selected from the calendar");
					break;
				}
				else{
					ce.validityReminderHookClick();
					test.log(LogStatus.FAIL, "selectDate Test Failed");
					log.info("Date not selected from the calendar");
					break;
				}
			}*/

			gm.elementDisplayed(By.id("reset-btn"), "Cancel Button");
			gm.click(By.id("reset-btn"), 0);
	}

	public void inviteGuestAddValidEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);
		if (ce.inviteAppMenuPresent()) {
			ce.clickinviteAppMenu();
			gm.switchToiFrame("invite-contact");
			if (ce.forkModalDisplayed()) {
				Thread.sleep(1000);
				ce.guestMemberHookClick();

				if (ce.guestInputFieldDisplayed()) {
					gm.waitForElement(By.id("invite-guest-btn"), 10);
					ce.guestInputFieldSendKey(emails);
					Thread.sleep(2000);
					ce.validityReminderHookClick();
					datePickerContent();
					ce.guestInviteButtonClick();
					test.log(LogStatus.INFO, "Guest Email ID entered in the field " + emails);
					log.info("Guest Email ID entered in the field " + emails);

					boolean result = driver.findElement(By.id("contact-input")) != null;
					Assert.assertTrue(result);

					test.log(LogStatus.PASS, "inviteGuestAddValidEmail Test Passed");
					log.info("inviteGuestAddValidEmail Test Passed");
				} else {
					test.log(LogStatus.FAIL, "inviteGuestAddValidEmail Test FAILED");
					log.error("inviteGuestAddValidEmail Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The guest invite field is not displayed");
					sa.assertAll();
				}
			}else {
				test.log(LogStatus.FAIL, "inviteGuestAddValidEmail Test FAILED");
				log.error("inviteGuestAddValidEmail Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The fork modal is not displayed");
				sa.assertAll();
			}
		}
	}

	public void setGuestAccessContent() {

		gm.elementDisplayed(By.id("close-btn"), "Cancel Button on the Guest Member Access Screen");

		gm.elementDisplayed(By.id("invite-heading"), "Header on the Guest Member Access Screen");
		gm.getInnerText(By.id("invite-heading"));
		gm.compareText(By.id("invite-heading"), "Set guest access");

		gm.elementDisplayed(By.id("invite-desc"), "Sub Header on the Guest Member Access Screen");
		gm.getInnerText(By.id("invite-desc"));
		gm.compareText(By.id("invite-desc"), "Add guests to conversations you want them to be a part of");

		gm.elementDisplayed(By.xpath("//div[1]/label"), "Email container title on Guest Member Access Screen");
		gm.getInnerText(By.xpath("//div[1]/label"));
		gm.compareText(By.xpath("//div[1]/label"), "Specify team members your guests can talk to");

		ce.guestContactAccessFieldDisplayed();
		gm.getInnerText(By.id("contact-input"));
		gm.compareText(By.id("contact-input"), "Enter name");

		gm.elementDisplayed(By.id("pill-contacts"), "Pill Contact field");

		if (gm.elementDisplayed(By.className("pill-unit"), "Inviter Name in the pilled contact field")) {
			gm.elementDisplayed(By.className("lock-image"), "Lock icon in the pilled contact field");

			ce.ownerNameGuestAccessDisplayed();
			gm.getInnerText(By.id("owner-name"));
			gm.compareText(By.id("owner-name"), "Farzan TestAccount");
		} else {
			log.error("The inviter name in the pilled contact section is not displayed");
		}

		gm.elementDisplayed(By.xpath("//div[@id='guest-access-screen']/div[1]/div[2]"),
				"Note below the Email container field on Guest Member Access Screen");
		gm.getInnerText(By.xpath("//div[@id='guest-access-screen']/div[1]/div[2]"));
		gm.compareText(By.xpath("//div[@id='guest-access-screen']/div[1]/div[2]"),
				"Guests can initiate conversations only with people you specify");

		gm.elementDisplayed(By.xpath("//div[2]/label"), "Channel container title on Guest Member Access Screen");
		gm.getInnerText(By.xpath("//div[2]/label"));
		gm.compareText(By.xpath("//div[2]/label"), "Specify channels your guests will be added to");

		ce.guestChannelAccessFieldDisplayed();
		gm.getInnerText(By.id("channel-input"));
		gm.compareText(By.id("channel-input"), "Enter channel name");

		gm.elementDisplayed(By.xpath("//div[@id='guest-access-screen']/div[2]/div[2]"),
				"Note below the Cahnnel container field on Guest Member Access Screen");
		gm.getInnerText(By.xpath("//div[@id='guest-access-screen']/div[2]/div[2]"));
		gm.compareText(By.xpath("//div[@id='guest-access-screen']/div[2]/div[2]"),
				"Guests can access all files and messages shared in these channels");

		if (ce.guestNewChannelCreateDisplayed()) {
			ce.guestNewChannelCreateHookClick();

			gm.getInnerText(By.id("new-channel-name"));
			gm.compareText(By.id("new-channel-name"), "Enter new channel name");
			ce.guestCreateChannelButtonDisplayed();

			gm.elementDisplayed(By.xpath("//div[@id='new-channel-div']/div[@class='note']"),
					"Note below the Create new channel container field on Guest Member Access Screen");
			gm.getInnerText(By.xpath("//div[@id='new-channel-div']/div[@class='note']"));
			gm.compareText(By.xpath("//div[@id='new-channel-div']/div[@class='note']"),
					"You and your guest(s) will automatically be added to this private channel");
		} else {
			log.error("The Guest New Channel create hook is not displayed");
		}
		ce.doneButtonGuestAccessDisplayed();
	}

	public void setGuestAccess() throws InterruptedException {
		Thread.sleep(2000);

		if (ce.guestContactAccessFieldDisplayed()) {
			ce.guestContactAccessFieldClick();
			Thread.sleep(2000);
			if (ce.guestAccessMagicListDisplayed()) {

				gm.elementDisplayed(
						By.xpath("//li[contains(@class,'contact-guest-container') and contains(@class,'selected')]"),
						"Contact in the magic list");

				gm.elementDisplayed(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-name']"),
						"Name of the selected contact");
				gm.getText(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-name']"));

				gm.elementDisplayed(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-email']"),
						"Name of the selected contact");
				gm.getText(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-email']"));

				gm.click(By.xpath("//li[contains(@class,'contact-guest-container') and contains(@class,'selected')]"),
						0);
				boolean result = driver.findElement(By.className("pill-unit")) != null;
				Assert.assertTrue(result);

				test.log(LogStatus.PASS, "Contact added in the Specify Guest Access Field");
				log.info("Contact added in the Specify Guest Access Field");
			} else {
				log.info("No magic list is shown");
			}
		} else {
			test.log(LogStatus.FAIL, "inviteGuestAddValidEmail Test FAILED");
			log.error("inviteGuestAddValidEmail Test FAILED");
		}

		if (ce.guestChannelAccessFieldDisplayed()) {
			ce.guestChannelAccessFieldClick();
			Thread.sleep(2000);
			if (ce.guestAccessMagicListDisplayed()) {
				gm.elementDisplayed(
						By.xpath("//li[contains(@class,'contact-guest-container') and contains(@class,'selected')]"),
						"Contact in the magic list");

				gm.elementDisplayed(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-name']"),
						"Name of the selected contact");
				gm.getText(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-name']"));

				gm.elementDisplayed(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-email']"),
						"Name of the selected contact");
				gm.getText(By.xpath("//li[contains(@class,'selected')]//div[@class='profile-email']"));

				gm.click(By.xpath("//li[contains(@class,'contact-guest-container') and contains(@class,'selected')]"),
						0);
				boolean result = driver.findElement(By.xpath("//div[@id='pill-channels']/span[@class='pill-unit']")) != null;
				Assert.assertTrue(result);

				test.log(LogStatus.PASS, "Channel added in the Specify Guest Access Field");
				log.info("Channel added in the Specify Guest Access Field");
			} else {
				log.info("No magic list is shown");
			}

		} else {
			ce.clickInviteContactCancel();
			test.log(LogStatus.FAIL, "inviteGuestAddValidEmail Test FAILED");
			log.error("inviteGuestAddValidEmail Test FAILED");
		}
		
		
			Thread.sleep(2000);
			if(ce.guestNewChannelFieldDisplayed()){
				ce.guestNewChannelFieldClick();
				Thread.sleep(2000);
				ce.guestNewChannelFieldSendKey("Testers Channel");
				Thread.sleep(2000);
				ce.guestCreateChannelButtonClick();
				boolean result = driver.findElement(By.id("new-channel-link")) != null;
				Assert.assertTrue(result);

				test.log(LogStatus.PASS, "New Channel created and added in the Specify Guest Access Field");
				log.info("New Channel created and added in the Specify Guest Access Field");
				
			}else{
				log.info("No New Channel Create Field is shown");
			}
		}
	
	public void guestSucessScreen() throws InterruptedException{
		SoftAssert sa = new SoftAssert();
		
		if(ce.guestSuccessScreenDisplayed()){
			gm.elementDisplayed(By.xpath("//h2[@id='invite-heading']"), "Guest Invite Sucess Screen");
			gm.getInnerText(By.xpath("//h2[@id='invite-heading']"));
			gm.compareText(By.xpath("//h2[@id='invite-heading']"), "You just invited 1 guest(s)!");
			
			gm.elementDisplayed(By.xpath("//div[@class='thank-you']"), "Thank you image in the sucesss modal");
			gm.elementDisplayed(By.id("close-btn"), "Close button in the sucess modal");
			
			gm.elementDisplayed(By.xpath("//div[@class='success-desc']"), "Subheading on success screen");
			gm.getInnerText(By.xpath("//div[@class='success-desc']"));
			gm.compareText(By.xpath("//div[@class='success-desc']"), "Learn more about guests");
			
			gm.click(By.xpath("//div[@class='success-desc']//a"), 0);
			ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(applink.get(1));
			Thread.sleep(5000);
			sa.assertEquals(driver.getCurrentUrl(),
					"https://support.flock.com/hc/en-us/articles/115004379653-Guest-Accounts");
			log.info("Url's matched");
			driver.close();
			driver.switchTo().window(applink.get(0));
			Thread.sleep(2000);
			sa.assertAll();
			gm.switchToiFrame("invite-contact");
			
			gm.elementDisplayed(By.xpath("//div[@class='success-note']"), "Success Note");
			gm.getInnerText(By.xpath("//div[@class='success-note']"));
			gm.compareText(By.xpath("//div[@class='success-note']"), "Note: Team Admins can manage guest setting from Admin Panel");
			
			gm.elementDisplayed(By.id("all-done-btn"), "All Done Button");
			gm.getInnerText(By.id("all-done-btn"));
			gm.compareText(By.id("all-done-btn"), "All Done!");
			
			gm.click(By.id("all-done-btn"), 0);
			
			test.log(LogStatus.PASS, "guestSucessScreen Passed");
			log.info("guestSucessScreen passed");
		}else{
			test.log(LogStatus.FAIL, "guestSucessScreen Failed");
			log.info("guestSucessScreen Failed");
		}
	}
	

}
