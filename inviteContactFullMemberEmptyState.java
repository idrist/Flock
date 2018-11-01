package com.inviteContacts;

import java.util.ArrayList;

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
import com.utilities.clientElement;

public class inviteContactFullMemberEmptyState extends BaseTestSuite {

	/*
	 * Created on 10th August 2017 By Farzan Shaikh Refactored on 28th Oct 2017
	 * Refactored on 12th Jan 2018 By Farzan Shaikh
	 */

	ExtentTest test;
	WebDriver driver = null;
	private GenericMethods gm;
	private clientElement ce;

	private static final Logger log = LogManager.getLogger(inviteContactFullMemberEmptyState.class.getName());

	public inviteContactFullMemberEmptyState(WebDriver webDriver, ExtentTest test) {
		this.driver = webDriver;
		this.test = test;
		gm = new GenericMethods(this.driver);
		ce = new clientElement(this.driver, this.test);
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

	public void inviteModalBackButton() throws Exception {
		Thread.sleep(2000);

		if (ce.backButtonInviteModalDisplayed()) {
			Thread.sleep(3000);
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

	public void blockedExternalContact(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.inviteModalInputSendKey(emails);
			test.log(LogStatus.INFO, "Blocked Ext Contact is" + emails);
			log.info("Blocked Ext Contact is" + emails);
			ce.inviteModalInviteButtonClick();
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
			ce.inviteModalInputSendKey(emails);
			test.log(LogStatus.INFO, "Admin Only Invite Contact is" + emails);
			log.info("Admin Only Invite Contact is" + emails);
			Thread.sleep(1000);
			ce.inviteModalInviteButtonClick();
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

	public void inviteModalTextContent() {
		gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);

		gm.elementDisplayed(By.xpath("//span[@id='back-btn']"), "Back Button on the Full Member Invite Modal");

		gm.elementDisplayed(By.xpath("//h2[@id='invite-heading']"), "Invite Modal Header");
		gm.getInnerText(By.xpath("//h2[@id='invite-heading']"));
		gm.compareText(By.xpath("//h2[@id='invite-heading']"), "Invite Team Members");

		gm.elementDisplayed(By.xpath("//div[@id='invite-container']/label"), "Invite Modal SubHeader");
		gm.getInnerText(By.xpath("//div[@id='invite-container']/label"));
		gm.compareText(By.xpath("//div[@id='invite-container']/label"), "Enter email address to invite");

		gm.isElementPresent("//div[@id='invite-container']/div[2]/input", "xpath");
		gm.getInnerText(By.xpath("//div[@id='invite-container']/div[2]/input"));
		gm.compareText(By.xpath("//div[@id='invite-container']/div[2]/input"), "Type an email ID");

		gm.isElementPresent("invite-btn", "id");
		gm.getInnerText(By.id("invite-btn"));
		gm.compareText(By.id("invite-btn"), "Send invites");

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

	public void inviteModalInLineError() throws Exception {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			Thread.sleep(2000);
			ce.inviteModalInviteButtonClick();
			inviteModalBlankErrorState();
			boolean result = driver.findElement(By.id("error0")) != null;
			Assert.assertTrue(result);
			Thread.sleep(1000);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteModalError Test Passed");
			log.info("inviteModalError Test Passed");
		} else {
			test.log(LogStatus.PASS, "inviteModalError Test FAILED");
			log.error("inviteModalError Test FAILED");
		}
	}

	public void inviteModalBlankErrorState() {
		gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
		gm.isElementPresent("error0", "id");
		gm.elementDisplayed(By.id("error0"), "Invite Modal Error State");
		gm.getText(By.id("error0"));
		gm.compareText(By.id("error0"), "Enter a valid email address");
	}

	public void inviteAddInvalidEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.inviteModalInputSendKey(emails);
			ce.inviteModalInviteButtonClick();
			test.log(LogStatus.INFO, "Wrong Email ID entered in the field" + emails);
			log.info("Wrong Email ID entered in the field" + emails);

			ce.inviteModalInputsClear();

			boolean result = driver.findElement(By.id("error0")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteModalBlankErrorState Test Passed");
			log.info("inviteModalBlankErrorState Test Passed");
		} else {
			test.log(LogStatus.PASS, "inviteModalBlankErrorState Test FAILED");
			log.error("inviteModalBlankErrorState Test FAILED");
		}
	}

	public void inviteAddValidEmail(String emails) throws InterruptedException {
		Thread.sleep(2000);

		if (ce.inviteContactModalDisplayed()) {
			gm.waitForElement(By.xpath("//button[@id='invite-btn']"), 10);
			ce.inviteModalInputSendKey(emails);
			test.log(LogStatus.INFO, "Correct Email ID entered in the field" + emails);
			log.info("Correct Email ID entered in the field" + emails);
			Thread.sleep(1000);
			ce.inviteModalInviteButtonClick();

			Thread.sleep(1000);
			inviteModalinviteSucess();
			Thread.sleep(1000);
			boolean result = driver.findElement(By.id("notification")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "inviteAddValidEmail Test Passed");
			log.info("inviteAddValidEmail Test Passed");
		} else {
			test.log(LogStatus.FAIL, "inviteAddValidEmail Test FAILED");
			log.error("inviteAddValidEmail Test FAILED");
		}
	}

	public void inviteModalinviteSucess() {
		gm.elementDisplayed(By.id("notification"), "Invite Sucess Notification");
		gm.getText(By.id("notification"));
		gm.compareText(By.id("notification"), "Invite sent to test@directi.com");
	}
	
	public void emptyStateProHook() throws InterruptedException{
		SoftAssert sa = new SoftAssert();
		if(ce.inviteProHookScreen.isDisplayed()){
			log.info("inside");
			gm.elementDisplayed(By.xpath("//div[@class='paywall-block']"), "Paywall Block");
			gm.getInnerText(By.xpath("//div[@class='paywall-block']"));
			
			gm.elementDisplayed(By.xpath("//div[@class='paywall-block']/a[text()='Upgrade to PRO']"), "Updgrade to pro hook");
			gm.getInnerText(By.xpath("//div[@class='paywall-block']/a[text()='Upgrade to PRO']"));
			gm.compareText(By.xpath("//div[@class='paywall-block']/a[text()='Upgrade to PRO']"), "Upgrade to PRO");
			
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//div[@class='paywall-block']/a[text()='Upgrade to PRO']"));
			action.moveToElement(we).click().build().perform();
			
			ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(applink.get(1));
			Thread.sleep(5000);
			sa.assertEquals(driver.getCurrentUrl(),
					"https://auth.flock-staging.com/login/?auth_token=ci2pvp2l0pp2000cla2pya0vcy0a2yys&platform=desktop&guid=d0ayyz1pypyukr0a&redirect_uri=https://admin.flock-staging.com/billing/email&config=preprod&platform=desktop");
			log.info("Url's matched");
			driver.close();
			driver.switchTo().window(applink.get(0));
			ce.clickInviteContactCancel();
		}else{
			test.log(LogStatus.FAIL, "emptyStateProHook Test FAILED");
			log.error("emptyStateProHook Test FAILED");
		}
		
	}
}
