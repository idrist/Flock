package com.Flock.HydraAutomation;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class createChannel extends BaseTestSuite {

	/*
	 * Created on 9th August 2017 By Farzan Shaikh
	 */

	private static final Logger log = LogManager.getLogger(createChannel.class.getName());

	@Test(priority = 1)
	public void searchPlusChannelOption() throws Exception {
		StopWatch watch = new StopWatch();

		if (ce.univerlSearchPlusIconPresent()) {

			ce.clickUniverlSearchPlusIcon();

			searchPlusChannelContent();
			ce.clickSearchPlusCreateChannel();
			watch.start();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			startChannelContent();

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
			double seconds = (double) watch.getTime() / 1000.0;
			watch.reset();

			log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);

			ce.clickStartChannelModalClose();

			test.log(LogStatus.PASS, "searchPlusChannelOption Test Passed");
			log.info("searchPlusChannelOption Test Passed");
		} else {
			log.error("searchPlusChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "searchPlusChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The search plus icon is not displayed");
			sa.assertAll();
		}
	}

	public void searchPlusChannelContent() throws Exception {

		Thread.sleep(2000);

		if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_2", "id")) {
			gm.elementDisplayed(By.xpath("//div[@class='plus-item__icon group']"), "Create-Channel-icon");
			gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
					"Create-Channel-label");
			gm.getInnerText(By.xpath("//*[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[2]"));
			gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
					"Create a new channel");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
					"Create-Channel-sublabel");
			gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
			gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
					"For your projects or topics");
			test.log(LogStatus.INFO, "The create a channel option is present");
		} else {
			test.log(LogStatus.FAIL, "The create a channel option is not present");
		}
	}

	@Test(priority = 2)
	public void rosterRecentChannelOption() throws Exception {

		StopWatch watch = new StopWatch();

		if (ce.recentsNewChannelDisplayed()) {

			ce.recentsNewChannelClick();
			watch.start();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
			double seconds = (double) watch.getTime() / 1000.0;
			watch.reset();

			log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);

			ce.clickStartChannelModalClose();

			test.log(LogStatus.PASS, "rosterRecentChannelOption");
			log.info("rosterRecentChannelOption");
		} else {
			log.error("rosterRecentChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "rosterRecentChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel hook in Recents section in roster is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 3)
	public void rosterRecentJoinChannelOption() throws Exception {
		StopWatch watch = new StopWatch();

		if (ce.joinChannelHookRosterDisplayed()) {

			ce.joinChannelHookRosterClick();
			Thread.sleep(2000);
			ce.createChannelJoinModalClick();
			watch.start();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
			double seconds = (double) watch.getTime() / 1000.0;
			watch.reset();

			log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);

			ce.clickStartChannelModalClose();
			ce.cancelHookDiscoverChannelClick();

			test.log(LogStatus.PASS, "rosterRecentJoinChannelOption Test Passed");
			log.info("rosterRecentJoinChannelOption Test Passed");
		} else {
			log.error("rosterRecentJoinChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "rosterRecentJoinChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The join channel hook in the roster is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 4)
	public void channelTabChannelOption() throws Exception {
		StopWatch watch = new StopWatch();

		if (ce.channelTabDisplayed()) {
			Thread.sleep(2000);
			ce.channelTabClick();

			ce.createChannelPlusIconClick();
			watch.start();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
			double seconds = (double) watch.getTime() / 1000.0;
			watch.reset();

			log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);

			ce.clickStartChannelModalClose();

			test.log(LogStatus.PASS, "channelTabChannelOption Test Passed");
			log.info("channelTabChannelOption Test Passed");
		} else {
			log.error("channelTabChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "channelTabChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	public void startChannelContent() throws InterruptedException {
		if (gm.elementDisplayed(By.xpath("//div[contains(@class,'channel-start')]"), "Start a New Channel Modal")) {

			gm.elementDisplayed(By.xpath("//h2"), "Start a new channel header");
			gm.getInnerText(By.xpath("//h2"));
			gm.compareText(By.xpath("//h2"), "Start a New Channel");

			gm.elementDisplayed(By.xpath("//h5"), "Start a new channel Sub-header");
			gm.getInnerText(By.xpath("//h5"));
			gm.compareText(By.xpath("//h5"), "Channels are where your team communicates. Watch a short video");

			gm.elementDisplayed(By.className("channel-options__about"), "Channel Option Header");
			gm.getInnerText(By.className("channel-options__about"));
			gm.compareText(By.className("channel-options__about"), "What is your channel about?");

			List<WebElement> liElements = driver.findElements(By.xpath("//div[@id='theme-desktop']//ul/li"));

			System.out.println(liElements.size());

			for (int i = 1; i < liElements.size() + 1; i++) {
				WebElement linkElement = driver.findElement(By.xpath("//div[@id='theme-desktop']//ul/li[" + i + "]/a"));

				System.out.println(linkElement.getText());
			}
			gm.elementDisplayed(By.xpath("//span[contains(@class,'project')]"), "Project Icon");
			gm.elementDisplayed(By.xpath("//span[contains(@class,'department')]"), "Department Icon");
			gm.elementDisplayed(By.xpath("//span[contains(@class,'others')]"), "Others Icon");

			gm.elementDisplayed(By.className("watch-video"), "Watch Video Hook");
			gm.click(By.className("watch-video"), 0);
			Thread.sleep(5000);
			gm.elementDisplayed(By.className("channel-video"), "Youtube Video");
			log.info("Youtube video is displayed");
			test.log(LogStatus.INFO, "Youtube video is displayed");
			gm.click(By.className("modal-box__close"), 0);

		} else {
			ce.clickStartChannelModalClose();
			log.error("The Start a New Channel modal is not displayed");
			test.log(LogStatus.FAIL, "The Start a New Channel modal is not displayed");
		}
	}

	@Test(priority = 5)
	public void channelTabEmptyChannelOption() throws Exception {
		Thread.sleep(5000);
		ce.dismissCalendarPrompt();

		StopWatch watch = new StopWatch();

		if (ce.channelTabDisplayed()) {
			ce.channelTabSearchFieldClick();
			ce.channelTabSearchFieldSendKey("farzandjdjdtestaccount");

			if (ce.channelEmptyStateDisplayed()) {
				ce.channelEmptyStateButtonClick();
				watch.start();

				gm.switchToiFrame("channel-create");
				log.debug("Inside the iframe channel-create");

				gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
				double seconds = (double) watch.getTime() / 1000.0;
				watch.reset();

				log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
				test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
				boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
				Assert.assertTrue(result);

				ce.clickStartChannelModalClose();

				test.log(LogStatus.PASS, "channelTabEmptyChannelOption Test Passed");
				log.info("channelTabEmptyChannelOption Test Passed");
			} else {

			}
		} else {
			log.error("channelTabChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "channelTabChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 6)
	public void ChannelCreationModal() throws Exception {

		if (ce.rosterRecentTabDisplayed()) {
			Thread.sleep(2000);
			ce.rosterRecentTabClick();

			ce.recentsNewChannelClick();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);

			gm.click(
					By.xpath(
							"//div[@id='theme-desktop']//span[contains(@class,'icon') and contains(@class,'project')]"),
					0);

			channelCreationContent();

			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);

			ce.clickStartChannelModalClose();

			test.log(LogStatus.PASS, "ChannelCreationModal Test Passed");
			log.info("ChannelCreationModal Passed");
		} else {
			log.error("ChannelCreationModal Test FAILED");
			test.log(LogStatus.FAIL, "ChannelCreationModal Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	public void channelCreationContent() {
		gm.click(By.xpath("//div[@id='theme-desktop']//li[1]"), 0);

		if (gm.elementDisplayed(By.xpath("//h2"), "Heading of the modal")) {

			gm.elementDisplayed(By.className("modal-box__back"), "Back Button");
			gm.elementDisplayed(By.className("modal-box__close"), "Cancel Button");

			gm.elementDisplayed(By.xpath("//h2"), "Start new channel header");
			gm.getInnerText(By.xpath("//h2"));
			gm.compareText(By.xpath("//h2"), "Start a New Channel");

			gm.elementDisplayed(By.xpath("//h5"), "Start new channel header");
			gm.getInnerText(By.xpath("//h5"));
			gm.compareText(By.xpath("//h5"),
					"Discuss and share everything related to the project and make it available for everyone.");

			gm.elementDisplayed(By.xpath("//div[@class='channel-type']//label[@class='channel-type__label']"),
					"Channel type heading");
			gm.getInnerText(By.xpath("//div[@class='channel-type']//label[@class='channel-type__label']"));
			gm.compareText(By.xpath("//div[@class='channel-type']//label[@class='channel-type__label']"),
					"Channel Type");

			gm.elementDisplayed(By.xpath("//i[contains (@class,'icon__global')]"), "Global Icon");
			gm.elementDisplayed(
					By.xpath("//button[contains(@class,'slider__button--selected')]//span[@class='slider__label']"),
					"public channel text");
			gm.getInnerText(
					By.xpath("//button[contains(@class,'slider__button--selected')]//span[@class='slider__label']"));
			gm.compareText(
					By.xpath("//button[contains(@class,'slider__button--selected')]//span[@class='slider__label']"),
					"Public");

			gm.elementDisplayed(By.xpath("//i[contains (@class,'icon__lock')]"), "Lock Icon");
			gm.elementDisplayed(By.xpath("//button[contains(@class,'slider__button')]//span[@class='slider__label']"),
					"public channel text");
			gm.getInnerText(By.xpath("//button[contains(@class,'slider__button')]//span[@class='slider__label']"));
			gm.compareText(By.xpath("//button[contains(@class,'slider__button')]//span[@class='slider__label']"),
					"Public");

			if (gm.elementDisplayed(By.xpath("//button[contains(@class,'slider__button--selected')]"),
					"Selected Slider ")) {
				gm.getInnerText(By
						.xpath("//button[contains(@class,'slider__button--selected')]//span[@class='slider__label']"));
				gm.elementDisplayed(By.xpath("//div[@class='inline-note']"),
						"Sub heading below the channel type toggle");
				gm.getInnerText(By.xpath("//div[@class='inline-note']"));
				gm.compareText(By.xpath("//div[@class='inline-note']"),
						"Public channels can be joined by anyone in your team");

				gm.click(By.xpath("//i[contains (@class,'icon__lock')]"), 0);
				gm.getInnerText(By
						.xpath("//button[contains(@class,'slider__button--selected')]//span[@class='slider__label']"));
				gm.elementDisplayed(By.xpath("//div[@class='inline-note']"),
						"Sub heading below the channel type toggle");
				gm.getInnerText(By.xpath("//div[@class='inline-note']"));
				gm.compareText(By.xpath("//div[@class='inline-note']"),
						"Only invited members can search and join Private Channels");

				gm.click(By.xpath("//i[contains (@class,'icon__global')]"), 0);
			} else {
				log.error("The Channel Type toggle is not displayed");
			}

			gm.elementDisplayed(By.xpath("//label[@for='channelName']"), "Channel name Heading");
			gm.getInnerText(By.xpath("//label[@for='channelName']"));
			gm.compareText(By.xpath("//label[@for='channelName']"), "Name your channel");

			gm.elementDisplayed(By.xpath("//input[@id='channelName']"), "Channel Name Placeholder");
			gm.getInnerText(By.xpath("//input[@id='channelName']"));
			gm.getInnerText(By.xpath("//span[@class='max-length']"));

			gm.elementDisplayed(By.xpath("//label[@for='memberInput']"), "Add Channel Member Heading");
			gm.getInnerText(By.xpath("//label[@for='memberInput']"));
			gm.compareText(By.xpath("//label[@for='memberInput']"), "Add colleagues to your channel");

			gm.elementDisplayed(By.xpath("//div[@class='Select-placeholder']"), "Add Channel Member Placeholder");
			gm.getInnerText(By.xpath("//div[@class='Select-placeholder']"));
			gm.compareText(By.xpath("//div[@class='Select-placeholder']"), "Type a name or email id to add colleagues");

			gm.elementDisplayed(By.xpath("//button[contains(@class,'btn__disabled')]"), "Create Channel Button");
			gm.getInnerText(By.xpath("//button[contains(@class,'btn__disabled')]"));
			gm.compareText(By.xpath("//button[contains(@class,'btn__disabled')]"), "Create Channel");

			gm.elementDisplayed(By.xpath("//div[@class='btn-help-note']"), "Browse Public Channel Hook");
			gm.getInnerText(By.xpath("//div[@class='btn-help-note']"));
			gm.compareText(By.xpath("//div[@class='btn-help-note']"), "Browse public channels in your team");

		} else {
			log.error("channelCreation Test FAILED");
			test.log(LogStatus.FAIL, "channelCreation Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The start a new channel modal is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 7)
	public void browserChannelHookCreateChannel() throws InterruptedException {

		if (ce.rosterRecentTabDisplayed()) {
			Thread.sleep(2000);
			ce.rosterRecentTabClick();

			ce.recentsNewChannelClick();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);

			gm.click(
					By.xpath(
							"//div[@id='theme-desktop']//span[contains(@class,'icon') and contains(@class,'project')]"),
					0);

			browseChannelHook();

			boolean result = driver.findElement(By.xpath("//div[@class='title']")) != null;
			Assert.assertTrue(result);

			ce.clickJoinChannelModalClose();

			test.log(LogStatus.PASS, "projectChannelCreation Test Passed");
			log.info("projectChannelCreation");
		} else {
			log.error("channelTabChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "channelTabChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	public void browseChannelHook() throws InterruptedException {
		if (gm.elementDisplayed(By.xpath("//div[@class='btn-help-note']"), "Browse Public Channel Hook")) {
			gm.click(By.xpath("//div[@class='btn-help-note']"), 0);
			Thread.sleep(2000);
			if (gm.elementDisplayed(By.xpath("//div[@class='group-discovery-list']"),
					"Discover and Join Public Channel Screen")) {

				gm.elementDisplayed(
						By.xpath(
								"//div[contains(@class,'group-discovery')]//span[contains(@class,'dijitDialogCloseIcon')]"),
						"Cancel button");

				gm.elementDisplayed(By.xpath("//div[@class='group-discovery-list']//div[@class='title']"),
						"Discover and Join Public Channel Heading");
				gm.getInnerText(By.xpath("//div[@class='group-discovery-list']//div[@class='title']"));
				gm.compareText(By.xpath("//div[@class='group-discovery-list']//div[@class='title']"),
						"Discover and Join Public Channels");

				gm.elementDisplayed(By.xpath("//div[@class='group-discovery-list']//p"),
						"Discover and Join Public Channel SubHeading");
				gm.getInnerText(By.xpath("//div[@class='group-discovery-list']//p"));
				gm.compareText(By.xpath("//div[@class='group-discovery-list']//p"),
						"Below is the list of public channels in your team.");

				gm.elementDisplayed(By.xpath("//div[@class='group-discovery-list']//input"),
						"Search field for the channel");
				gm.getInnerText(By.xpath("//div[@class='group-discovery-list']//input"));
				gm.compareText(By.xpath("//div[@class='group-discovery-list']//input"), "Search Channels");

				if (gm.elementDisplayed(By.xpath("//div[@class='groupList']"), "Channel list")) {
					log.info("Inside this condition");
					gm.elementDisplayed(By.xpath("//img[@class='groupImage']"), "Channel Avataar");

					gm.elementDisplayed(By.xpath("//div[@class='groupList']/div[1]"),
							"Channel Name in the channel list");
					gm.getInnerText(By.xpath("//div[@class='groupList']/div[1]"));
					gm.compareText(By.xpath("//div[@class='groupList']/div[1]"), "Flock.com Hub");

					gm.elementDisplayed(
							By.xpath("//div[@class='groupList']/div[1]//button[contains(@class,'btn__line--green')]"),
							"join button in the channel list");
					gm.getInnerText(
							By.xpath("//div[@class='groupList']/div[1]//button[contains(@class,'btn__line--green')]"));
					gm.compareText(
							By.xpath("//div[@class='groupList']/div[1]//button[contains(@class,'btn__line--green')]"),
							"Join");

					gm.elementDisplayed(By.xpath("//div[@class='groupList']/div[1]//div[@class='memberCount']"),
							"Member Count in the channel list");
					gm.getInnerText(By.xpath("//div[@class='groupList']/div[1]//div[@class='memberCount']"));
					gm.compareText(By.xpath("//div[@class='groupList']/div[1]//div[@class='memberCount']"),
							"72 Members");

					gm.elementDisplayed(By.xpath("//div[@class='groupList']/div[1]//div[@class='groupDescription']"),
							"Channel Description in the channel list");
					gm.getInnerText(By.xpath("//div[@class='groupList']/div[1]//div[@class='groupDescription']"));

					gm.elementDisplayed(By.xpath("//div[@class='groupList']/div[1]//div[@class='createdBy']"),
							"Channel creator name in the channel list");
					gm.getInnerText(By.xpath("//div[@class='groupList']/div[1]//div[@class='createdBy']"));
					gm.compareText(By.xpath("//div[@class='groupList']/div[1]//div[@class='createdBy']"),
							"Created by Tejas C");

					gm.elementDisplayed(By.xpath("//a[@class='new-channel']"), "Start a new channel hook");
					gm.getInnerText(By.xpath("//a[@class='new-channel']"));
					gm.compareText(By.xpath("//a[@class='new-channel']"), "Start a New Channel");
				} else {
					log.error("browseChannelHook Test FAILED");
					test.log(LogStatus.FAIL, "browseChannelHook Test FAILED");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The channel list is not displayed");
					sa.assertAll();
				}

			} else if (gm.elementDisplayed(By.xpath("//div[@class='no-groups']"), "No public channel screen")) {
				gm.elementDisplayed(
						By.xpath(
								"//div[contains(@class,'group-discovery')]//span[contains(@class,'dijitDialogCloseIcon')]"),
						"Cancel button");

				gm.elementDisplayed(By.xpath("//img[@data-dojo-attach-point='noGroupsImage']"),
						"No public channels to join Image");

				gm.elementDisplayed(By.xpath("//div[@class='no-groups']//div[@class='title']"),
						"No Public Channel Header");
				gm.getInnerText(By.xpath("//div[@class='no-groups']//div[@class='title']"));
				gm.compareText(By.xpath("//div[@class='no-groups']//div[@class='title']"),
						"Looks like there are no Public Channels to join");

				gm.elementDisplayed(By.xpath("//div[@class='content-group']"), "No Public Channel Sub Header");
				gm.getInnerText(By.xpath("//div[@class='content-group']"));

				gm.elementDisplayed(By.xpath("//button[@data-dojo-attach-point='addButton']"),
						"Create a channel button");
				gm.getInnerText(By.xpath("//button[@data-dojo-attach-point='addButton']"));
				gm.compareText(By.xpath("//button[@data-dojo-attach-point='addButton']"), "Create a Channel");
			} else {
				log.error("browseChannelHook Test FAILED");
				test.log(LogStatus.FAIL, "browseChannelHook Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The Discover and Join Public Channel/No public channel Hook not displayed");
				sa.assertAll();
			}
		} else {
			log.error("browseChannelHook Test FAILED");
			test.log(LogStatus.FAIL, "browseChannelHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The browse channel hook not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 8)
	public void joinAndLeavePublicChannel() throws InterruptedException {
		if (ce.rosterRecentTabDisplayed()) {
			Thread.sleep(2000);
			ce.rosterRecentTabClick();
			ce.joinChannelHookRosterClick();

			ce.joinChannelSearchField.sendKeys("mm");
			Thread.sleep(3000);
			if (ce.joinChannelButton.isDisplayed()) {
				ce.joinChannelButton.click();
				boolean result = driver.findElement(By.xpath(
						"//div[@class='groupItem']//div[@class='joinGroup']/button[@data-dojo-attach-point='openButton']")) != null;
				Assert.assertTrue(result);
				test.log(LogStatus.PASS, "Join Channel Test Passed");
				log.info("Join Channel Test passed");

				Thread.sleep(3000);

				driver.findElement(By
						.xpath("//div[@class='groupItem']//div[@class='joinGroup']/button[@data-dojo-attach-point='openButton']"))
						.click();

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
						log.info("Leave Channel Confirmation Box opens using slash Leave");
						test.log(LogStatus.PASS, "Leave Channel Confirmation Box opens using slash Leave");
						ce1.leaveDeleteChannelButton.click();
						if (ce.joinChannelHookRosterDisplayed()) {
							ce.joinChannelHookRosterClick();

							ce.joinChannelSearchField.sendKeys("mm");
							boolean result1 = driver.findElement(
									By.xpath("//div[@class='groupItem']//div[@class='joinGroup']")) != null;
							Assert.assertTrue(result1);
							test.log(LogStatus.PASS, "Join Channel Test Passed");
							log.info("Join Channel Test passed");
							ce.clickJoinChannelModalClose();
						} else {
							log.info("The user has not left the public channel");
							test.log(LogStatus.FAIL, "The user has not left the public channel");
							SoftAssert sa = new SoftAssert();
							sa.assertTrue(false, "The user has not left the public channel");
							sa.assertAll();
						}
					} else {
						ce.clickJoinChannelModalClose();
						log.info("The user has not left the public channel");
						test.log(LogStatus.FAIL, "The user has not left the public channel");
						SoftAssert sa = new SoftAssert();
						sa.assertTrue(false, "The user has not left the public channel");
						sa.assertAll();
					}

				} else {
					log.info("Leave Channel Confirmation Box was not displayed using slash Leave");
					test.log(LogStatus.FAIL, "Leave Channel Confirmation Box was not displayed using slash Leave");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "Leave Channel Confirmation Box was not displayed using slash Leave");
					sa.assertAll();
				}

			} else {
				ce.clickJoinChannelModalClose();
				log.error("channelTabChannelOption Test FAILED");
				test.log(LogStatus.FAIL, "channelTabChannelOption Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The join channel button is not displayed");
				sa.assertAll();
			}

		} else {
			ce.clickJoinChannelModalClose();
			log.error("channelTabChannelOption Test FAILED");
			test.log(LogStatus.FAIL, "channelTabChannelOption Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 9)
	public void createPublicChannel() throws Exception {
		if (ce.rosterRecentTabDisplayed()) {
			Thread.sleep(2000);
			ce.rosterRecentTabClick();

			ce.recentsNewChannelClick();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);

			gm.click(
					By.xpath(
							"//div[@id='theme-desktop']//span[contains(@class,'icon') and contains(@class,'project')]"),
					0);

			if (gm.elementDisplayed(
					By.xpath(
							"//div[@class='channel-create']//button[contains(@class,'btn') and contains(@class,'btn__disabled')]"),
					"Disabled Create Channel Button")) {
				if (gm.elementDisplayed(
						By.xpath(
								"//button[contains(@class,'slider__button--selected')]/i[contains(@class,'icon__global')]"),
						"Public Channel Icon")) {
					createChannelData();
				} else {
					gm.click(By.xpath("//i[contains(@class,'icon__global')]"), 0);
					createChannelData();
				}
			} else {
				log.info("Create channel modal is not displayed");
				test.log(LogStatus.FAIL, "Create channel modal is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Create channel modal is not displayed");
				sa.assertAll();
			}
			Thread.sleep(3000);
			ce.channelTabClick();
			ce.channelTabSearchFieldSendKey("createChannel Script");

			Thread.sleep(3000);
			boolean result = driver
					.findElement(By.xpath("//div[@class='rosterList']//span[@title='createChannel Script']")) != null;
			Assert.assertTrue(result);

			test.log(LogStatus.PASS, "createPublicChannel Test Passed");
			log.info("createPublicChannel Passed");

			gm.click(By.xpath("//div[@class='rosterList']//span[@title='createChannel Script']"), 0);
			Thread.sleep(2000);
			driver.switchTo().frame(ce1.appIframe);
			Thread.sleep(2000);
			addMoreAdd();
			Thread.sleep(2000);
			makeAdmin();
			Thread.sleep(2000);
			slashLeave();

		} else {
			log.error("ChannelCreationModal Test FAILED");
			test.log(LogStatus.FAIL, "ChannelCreationModal Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 10)
	public void createPrivateChannel() throws Exception {
		driver.switchTo().defaultContent();
		if (ce.channelTabCreateChannelHook.isDisplayed()) {
			Thread.sleep(2000);
			ce.channelTabCreateChannelHook.click();

			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");

			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);

			gm.click(
					By.xpath(
							"//div[@id='theme-desktop']//span[contains(@class,'icon') and contains(@class,'project')]"),
					0);

			if (gm.elementDisplayed(
					By.xpath(
							"//div[@class='channel-create']//button[contains(@class,'btn') and contains(@class,'btn__disabled')]"),
					"Disabled Create Channel Button")) {
				if (gm.elementDisplayed(By.xpath("//i[contains(@class,'icon__lock')]"), "Private Channel Icon")) {
					gm.click(By.xpath("//i[contains(@class,'icon__lock')]"), 0);
					createChannelData();
				} else {
					log.info("Create channel modal is not displayed");
					test.log(LogStatus.FAIL, "Create channel modal is not displayed");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "Create channel modal is not displayed");
					sa.assertAll();
				}
			} else {
				log.info("Create channel modal is not displayed");
				test.log(LogStatus.FAIL, "Create channel modal is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Create channel modal is not displayed");
				sa.assertAll();
			}
			Thread.sleep(5000);
			ce.channelTabClick();
			ce.channelTabSearchFieldSendKey("createChannel Script");

			Thread.sleep(3000);
			boolean result = driver
					.findElement(By.xpath("//div[@class='rosterList']//span[@title='createChannel Script']")) != null;
			Assert.assertTrue(result);

			test.log(LogStatus.PASS, "createPublicChannel Test Passed");
			log.info("createPublicChannel Passed");

			gm.click(By.xpath("//div[@class='rosterList']//span[@title='createChannel Script']"), 0);
			Thread.sleep(2000);
			driver.switchTo().frame(ce1.appIframe);
			removeMember();
			Thread.sleep(2000);
			slashLeave();

		} else {
			log.error("ChannelCreationModal Test FAILED");
			test.log(LogStatus.FAIL, "ChannelCreationModal Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel option in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 11)
	public void channelAddUser() throws Exception {
		driver.switchTo().defaultContent();
		String email = RandomStringUtils.randomAlphabetic(10);
		ce.channelTabClick();
		ce.channelTabSearchFieldClick();
		ce.channelTabSearchFieldclear();
		WebElement channel = driver
				.findElement(By.xpath("//span[@class='dijitTreeLabel' and contains(text(),'SlashInvite')]"));
		channel.click();
		ce1.openChannelRoster("SlashInvite");
		Thread.sleep(4000);
		driver.switchTo().frame(ce1.appIframe);
		ce1.textEditor.sendKeys("/add");

		if (ce1.slashAddDisplayed()) {
			ce1.slashAddParamDisplayed();
			ce1.slashAddDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			ce1.textEditor.sendKeys(email + "@flock.com");
			Thread.sleep(1000);
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the user from magic list");
			test.log(LogStatus.INFO, "Selected the user from magic list");
			Thread.sleep(2000);
			ce1.textEditor.sendKeys(Keys.ENTER);

			log.info("Added the user inside Channel");
			test.log(LogStatus.INFO, "Added the user inside Channel");
		} else {
			log.info("slashInviteUser Test FAILED");
			test.log(LogStatus.FAIL, "slashInviteUser Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The slash add command is not displayed");
			sa.assertAll();
		}

	}

	@Test(priority = 12)
	public void conferenceChat() throws Exception {
		driver.switchTo().defaultContent();
		ce.rosterRecentTabClick();
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click();
			actions.sendKeys(RandomStringUtils.randomAlphabetic(5) + "@flock.com");
			actions.sendKeys(Keys.TAB);
			Thread.sleep(5000);
			actions.sendKeys("a@b.com");
			actions.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			actions.sendKeys("andj@flock.com");
			actions.sendKeys(Keys.TAB);
			actions.sendKeys(Keys.ENTER);
			actions.build().perform();
			Thread.sleep(6000);

			String channelName = ce.selectedChannelName.getText();
			if(channelName.equals("A, A L, Flockdesktop1 TestUser and others")){
				test.log(LogStatus.PASS, "conferenceChat Test pass");
				log.info("conferenceChat Test pass");
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
				slashLeave();
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(true, "The conference chat is created with an email acccount");
				sa.assertAll();
				}else{
					log.error("conferenceChat Test FAILED");
					test.log(LogStatus.FAIL, "conferenceChat Test FAILED");
					driver.switchTo().frame(ce1.appIframe);
					Thread.sleep(2000);
					slashLeave();
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The conference chat is not created with an email acccount");
					sa.assertAll();
				}
		} else {
			log.info("conferenceChat Test FAILED");
			test.log(LogStatus.FAIL, "conferenceChat Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Universal Search bar Editore is not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority = 13)
	public void conferenceChatIcon() throws Exception {
		driver.switchTo().defaultContent();
		ce.rosterRecentTabClick();
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click().sendKeys("Flockdesktop2");
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(6000);
			driver.switchTo().frame(ce1.appIframe);
			WebElement addMemberIcon = driver.findElement(By.xpath("//div[@class='add-member-icon']"));
			actions.moveToElement(addMemberIcon).click().build().perform();
			Thread.sleep(6000);
			driver.switchTo().defaultContent();
			String channelName = ce.selectedChannelName.getText();
			assertEquals(channelName, "Flockdesktop1 TestUser, Flockdesktop2 TestUser");
			test.log(LogStatus.PASS, "conferenceChatIcon Test pass");
			log.info("conferenceChatIcon Test pass");
			driver.switchTo().frame(ce1.appIframe);
			Thread.sleep(2000);
			renameChannel();
			driver.switchTo().defaultContent();

		} else {
			log.info("universearchInviteUser Test FAILED");
			test.log(LogStatus.FAIL, "universearchInviteUser Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Universal Search bar Editore is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 14)
	public void slashAddConnference() throws Exception {
		String email =RandomStringUtils.randomAlphabetic(5);
		driver.switchTo().defaultContent();
		ce.rosterRecentTabClick();
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click().sendKeys("Flockdesktop2");
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(6000);
			driver.switchTo().frame(ce1.appIframe);
			ce1.textEditor.sendKeys("/add");
			if (ce1.slashAddDisplayed()) {
				ce1.slashAddParamDisplayed();
				ce1.slashAddDescriptionDisplayed();
				ce1.textEditor.sendKeys(Keys.ENTER);
				ce1.textEditor.sendKeys(email + "@flock.com");
				Thread.sleep(5000);
				ce1.textEditor.sendKeys(Keys.ENTER);
				test.log(LogStatus.INFO, "Selected the user from magic list");
				Thread.sleep(5000);
				ce1.textEditor.sendKeys(Keys.ENTER);
				
			} else {
				log.info("slashAddDisplayed Test FAILED");
				test.log(LogStatus.FAIL, "slashAddDisplayed Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The slash add command is not displayed");
				sa.assertAll();
			}
			Thread.sleep(6000);
			driver.switchTo().defaultContent();
			String channelName = ce.selectedChannelName.getText();
			
			if(channelName.equals("Flockdesktop1 TestUser, Flockdesktop2 TestUser, "+email)){
			test.log(LogStatus.PASS, "conferenceChatIcon Test pass");
			log.info("conferenceChatIcon Test pass");
			driver.switchTo().frame(ce1.appIframe);
			Thread.sleep(2000);
			slashLeave();
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(true, "The slash add conference chat with an email account is created");
			sa.assertAll();
			}else{
				log.error("universearchInviteUser Test FAILED");
				test.log(LogStatus.FAIL, "universearchInviteUser Test FAILED");
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
				slashLeave();
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The slash add conference chat with an email account is not created");
				sa.assertAll();
			}

		} else {
			log.info("universearchInviteUser Test FAILED");
			test.log(LogStatus.FAIL, "universearchInviteUser Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Universal Search bar Editore is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 15)
	public void tagChannelContent() throws InterruptedException {
		String tagMessage = "Checking for tag a channel #";
		driver.switchTo().defaultContent();
		if (ce.meTab.isDisplayed()) {
			ce.meTab.click();
			driver.switchTo().frame(ce1.appIframe);
			ce1.textEditor.click();
			ce1.textEditor.sendKeys(tagMessage);
			log.info("Entered the string to check for the dropdown list");
			Thread.sleep(4000);
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			String channelName = driver
					.findElement(By
							.xpath("//div[contains(@class,'conversation') and contains(@class,'selected')]//div[@class='name']/div[@class='channel-name']"))
					.getText();
			log.info(channelName);
			
			Assert.assertTrue(channelName!= null);
			test.log(LogStatus.PASS, "tagChannelContent Test pass");
			log.info("tagChannelContent Test pass");
		} else {
			log.info("tagChannelContent Test FAILED");
			test.log(LogStatus.FAIL, "tagChannelContent Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The me tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 16)
	public void joinTaggedChannel() throws Exception {
		ce.rosterRecentTabClick();
		/*driver.switchTo().defaultContent();*/
		Actions actions = new Actions(driver);
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='convSearch']/div[2]"));
		if (ce.universalSearchBarEditorPresent()) {
			ce.clickUniversalSearchBarEditor();

			actions.moveToElement(searchBar);
			actions.click().sendKeys("Flockdesktop2");
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(6000);
			driver.switchTo().frame(ce1.appIframe);
			int buttonCount = ce.taggedChannelActionButtonText.size();
			String buttonText = ce.taggedChannelActionButtonText.get(buttonCount - 1).getText();
			log.info(buttonText);
			if (gm.compareString(buttonText, "Join")) {
				int buttonC = ce.taggedChannelActionButton.size();
				ce.taggedChannelActionButton.get(buttonC - 1).click();
				Thread.sleep(4000);

				driver.switchTo().defaultContent();
				ce.channelTabClick();
				ce.channelTabSearchFieldClick();
				ce.channelTabSearchFieldclear();
				WebElement channel = driver
						.findElement(By.xpath("//span[@class='dijitTreeLabel' and contains(text(),'Tagged Channel')]"));
				test.log(LogStatus.PASS, "joinTaggedChannel Test pass");
				log.info("joinTaggedChannel Test pass");
				channel.click();
				ce1.openChannelRoster("Tagged Channel");
				Thread.sleep(2000);
				driver.switchTo().frame(ce1.appIframe);
				slashLeave();
			} else {
				log.info("joinTaggedChannel Test FAILED");
				test.log(LogStatus.FAIL, "joinTaggedChannel Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The Join Button is not displayed");
				sa.assertAll();
			}
		} else {
			log.info("joinTaggedChannel Test FAILED");
			test.log(LogStatus.FAIL, "joinTaggedChannel Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab in roster is not displayed");
			sa.assertAll();
		}

	}

	public void createChannelData() throws InterruptedException {
		if (gm.elementDisplayed(By.xpath("//input[@id='channelName']"), "Channel Name Placeholder")) {

			ce.channelNameField.sendKeys("createChannel Script");
			log.info("Channel Name Entered");

			gm.elementDisplayed(By.xpath("//span[@class='max-length']"), "Characters count in the field");
			gm.getInnerText(By.xpath("//span[@class='max-length']"));
			gm.compareText(By.xpath("//span[@class='max-length']"), "20/50");

			gm.elementDisplayed(By.className("Select-placeholder"), "Add colleagues fields");
			gm.getInnerText(By.className("Select-placeholder"));
			gm.compareText(By.className("Select-placeholder"), "Type a name or email id to add colleagues");
			gm.click(By.className("Select-placeholder"), 0);

			gm.SendKey(By.xpath("//div[@class='Select-input']/input"), 0, "Test 1");
			Thread.sleep(2000);
			gm.click(By.xpath("//div[@class='Select-menu-outer']//div[contains(@class,'is-focused')]"), 0);
			Thread.sleep(2000);

			String email = RandomStringUtils.randomAlphabetic(10);
			gm.SendKey(By.xpath("//div[@class='Select-input']/input"), 0, email + "@flock.com");
			Thread.sleep(4000);
			gm.click(By.xpath("//div[@class='Select-menu-outer']//div[contains(@class,'is-focused')]"), 0);
			Thread.sleep(2000);

			ce.createChannelButton.click();
			Thread.sleep(2000);
			ce.appDoorCancel.click();
		} else {
			ce.clickStartChannelModalClose();
			log.info("Channel Name Field is not displayed");
			test.log(LogStatus.FAIL, "Channel Name Field is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Channel Name Field is not displayed");
			sa.assertAll();
		}
	}

	public void removeMember() throws InterruptedException {
		if (ce.contactHeaderConversation.isDisplayed()) {
			Actions action = new Actions(driver);
			WebElement groupInfoCard = driver
					.findElement(By.xpath("//div[@class='group']//div[contains(@class,'group-dropdown')]"));
			action.moveToElement(groupInfoCard).click().build().perform();
			if (ce.channelContactCard.isDisplayed()) {
				WebElement teamMember = driver.findElement(By.xpath("//div[@class='flatList']/div[2]"));
				action.moveToElement(teamMember)
						.moveToElement(driver.findElement(
								By.xpath("//div[@class='flatList']/div[2]/span[contains(@class,'optionsButton')]")))
						.click().build().perform();
				Thread.sleep(2000);
				WebElement admin = driver.findElement(By.xpath("//div[@class='member-association']//li[1]"));
				WebElement removeMember = driver.findElement(By.xpath("//div[@class='member-association']//li[2]"));
				action.moveToElement(admin).moveToElement(removeMember).click().build().perform();
				driver.switchTo().defaultContent();
				ce1.clickLeaveDeleteChannelButton();
				driver.switchTo().frame(ce1.appIframe);
				test.log(LogStatus.PASS, "removeMember Test Passed");
				log.info("Member Remived from channel");
			} else {
				log.error("Channel contact card not displayed");
				test.log(LogStatus.FAIL, "Channel contact card is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Channel contact card is not displayed");
				sa.assertAll();
			}
		} else {
			log.error("Channel Header in the conversation iframe is not displayed");
			test.log(LogStatus.FAIL, "Channel Header in the conversation iframe is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Channel Header in the conversation iframe is not displayed");
			sa.assertAll();
		}
	}

	public void makeAdmin() throws InterruptedException {
		Thread.sleep(2000);
		if (ce.contactHeaderConversation.isDisplayed()) {
			Actions action = new Actions(driver);
			WebElement groupInfoCard = driver
					.findElement(By.xpath("//div[@class='group']//div[contains(@class,'group-dropdown')]"));
			action.moveToElement(groupInfoCard).click().build().perform();
			if (ce.channelContactCard.isDisplayed()) {
				WebElement teamMember = driver.findElement(By.xpath("//div[@class='flatList']/div[2]"));
				action.moveToElement(teamMember)
						.moveToElement(driver.findElement(
								By.xpath("//div[@class='flatList']/div[2]/span[contains(@class,'optionsButton')]")))
						.click().build().perform();
				Thread.sleep(2000);
				WebElement makeAdmin = driver.findElement(By.xpath("//div[@class='member-association']//li[1]"));
				action.moveToElement(makeAdmin).click().build().perform();

				test.log(LogStatus.PASS, "make Admin Test Passed");
				log.info("Made Channel Admin");
			} else {
				log.error("Channel contact card not displayed");
				test.log(LogStatus.FAIL, "Channel contact card is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Channel contact card is not displayed");
				sa.assertAll();
			}
		} else {
			log.error("Channel Header in the conversation iframe is not displayed");
			test.log(LogStatus.FAIL, "Channel Header in the conversation iframe is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Channel Header in the conversation iframe is not displayed");
			sa.assertAll();
		}
	}

	public void addMoreInvite() throws InterruptedException {
		if (ce.addMoreChannel.isDisplayed()) {
			ce.addMoreChannel.click();
			ce.addMoreInviteField.click();
			ce.addMoreInviteField.sendKeys(RandomStringUtils.randomAlphabetic(5) + "@flock.com");
			driver.findElement(By
					.xpath("//div[contains(@class,'inviteBoxSuggestionPopup')]/li[contains(@class,'dijitMenuItemSelected')]"))
					.click();
			log.info("new member added using +add");	
		} else {
			log.error("Add more hook in channel is not displayed");
			test.log(LogStatus.FAIL, "Add more hook in channel is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Add more hook in channel is not displayed");
			sa.assertAll();
		}
	}

	public void addMoreAdd() {
		if (ce.addMoreChannel.isDisplayed()) {
			ce.addMoreChannel.click();
			if (ce.addMoreInviteField.isDisplayed()) {
				ce.addMoreInviteField.click();
				ce.addMoreInviteField.sendKeys("Krralcijnm");
				ce.addMoreInviteField.sendKeys(Keys.ENTER);
				log.info("new member added using +add");
				ce.addMoreInviteField.sendKeys(RandomStringUtils.randomAlphabetic(5) + "@flock.com");
				ce.addMoreInviteField.sendKeys(Keys.ENTER);
				log.info("new email added using +add");
			} else {
				log.error("Add more invite field is not displayed");
				test.log(LogStatus.FAIL, "Add more invite field is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Add more  invite field is not displayed");
				sa.assertAll();
			}
		} else {
			log.error("Add more hook in channel is not displayed");
			test.log(LogStatus.FAIL, "Add more hook in channel is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Add more hook in channel is not displayed");
			sa.assertAll();
		}
	}

	public void renameChannel() throws Exception {
		if (ce.contactHeaderConversation.isDisplayed()) {

			Actions action = new Actions(driver);
			WebElement groupInfoCard = driver
					.findElement(By.xpath("//div[@class='group']//div[contains(@class,'group-dropdown')]"));
			action.moveToElement(groupInfoCard).click().build().perform();
			if (ce.channelContactCard.isDisplayed()) {
				WebElement channelNameEditor = driver.findElement(By.xpath(
						"//div[contains(@class,'group-info-widget-dropdown')]//textarea[@placeholder='Set channel name']"));
				action.moveToElement(channelNameEditor).click();
				action.moveToElement(channelNameEditor).sendKeys("Name");
				action.moveToElement(channelNameEditor).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				
				driver.switchTo().defaultContent();
				String channelName = ce.selectedChannelName.getText();
				
				if(channelName.equals("Flockdesktop1 TestUser, Flockdesktop2 TestUserName")){
				test.log(LogStatus.PASS, "renameChannel Test pass");
				log.info("renameChannel Test pass");
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
				slashLeave();
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(true, "The slash add conference chat with an email account is created");
				sa.assertAll();
				}else{
					log.error("renameChannel Test FAILED");
					test.log(LogStatus.FAIL, "renameChannel Test FAILED");
					driver.switchTo().frame(ce1.appIframe);
					Thread.sleep(2000);
					slashLeave();
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The renamed channel name is not created");
					sa.assertAll();
				}
				
			} else {
				log.error("channelContactCard is not displayed");
				test.log(LogStatus.FAIL, "channelContactCard is not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "channelContactCard is not displayed");
				sa.assertAll();
			}

		} else {
			log.error("Channel Member Count is not displayed");
			test.log(LogStatus.FAIL, "Channel Member Count is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Channel Member Count is not displayed");
			sa.assertAll();
		}
	}

	public void slashLeave() throws Exception {

		ce1.textEditor.click();
		ce1.textEditor.sendKeys("/leave");
		if (ce1.slashLeaveDisplayed()) {
			ce1.slashLeaveDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash leave shortcuts using enter");
			test.log(LogStatus.INFO, "Selected the leave keyboard shortcuts using enter");
			driver.switchTo().defaultContent();
			if (ce1.leaveChannelConfirmationTitlePresent()) {
				log.info("Leave Channel Confirmation Box opens using slash Leave");
				test.log(LogStatus.PASS, "Leave Channel Confirmation Box opens using slash Leave");
				ce1.clickLeaveDeleteChannelButton();
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
