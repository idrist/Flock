package com.flockApps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class flockmlActions extends BaseTestSuite {
	/*
	 * Created on 15th May 2018 By Farzan Shaikh
	 */

	private static final Logger log = LogManager.getLogger(flockmlActions.class.getName());

	@Test(priority = 1)
	public void openChannel() throws Exception {

		ce1.openChannelRoster("Flockml Channel");
		Thread.sleep(2000);
		driver.switchTo().frame(ce1.appIframe);
		log.info("Test channel opened and focus shifted to the channel iframe");
	}

	@Test(priority = 2) // pinned a message
	public void pinMessage() throws Exception {
		Thread.sleep(2000);
		ce1.textEditor.sendKeys("Test message");
		ce1.textEditor.sendKeys(Keys.ENTER);
		log.info("Test message sent in the channel");

		Thread.sleep(2000);

		Actions action = new Actions(driver);
		int size = ce.messageActionDropDown.size();
		log.info("Size of the list: " + size);
		int finalSize = size - 1;
		log.info("Size of the final list: " + finalSize);
		int msg = ce.lastMessage.size();
		log.info("List of last message " + msg);
		int msgSize = msg - 1;

		action.moveToElement(ce.lastMessage.get(msgSize)).moveToElement(ce.messageActionDropDown.get(finalSize)).click()
				.build().perform();

		Thread.sleep(2000);
		gm.getElementList(
				".message_area_root .daySeparator:last-child .minute_separator:last-child .overlay-menu-arrow", "css");
		gm.isElementPresent(
				".message_area_root .daySeparator:last-child .minute_separator:last-child .overlay-menu-arrow", "css");

		if (gm.elementDisplayed(
				By.xpath("//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]"),
				"App action dropdown")) {
			log.info("Inside the popup");
			gm.click(
					By.xpath(
							"//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]//div[@data-buttonid='app___f6d27d29-8031-443e-9ea2-9446e0c4b7b4']"),
					0);
			Thread.sleep(3000);
			if (gm.elementDisplayed(
					By.xpath(
							"//div[@id='conversationViewFooter']//div[contains(@class,'successRemind')]//span[@dojoattachpoint='notification']"),
					"Pinned Bot Message Notification")) {

				gm.elementDisplayed(
						By.xpath(
								"//div[@id='conversationViewFooter']//div[contains(@class,'successRemind')]//span[@dojoattachpoint='notification']"),
						"Pinned Bot Message Notification");
				gm.getInnerText(By.xpath(
						"//div[@id='conversationViewFooter']//div[contains(@class,'successRemind')]//span[@dojoattachpoint='notification']"));
				
				Thread.sleep(5000);
				
				int MessageSize =ce.lastMessage.size();
				ce.lastMessage.get(MessageSize-1).isDisplayed();
				String lastMessage = ce.lastMessage.get(MessageSize-1).getText();
				log.info(lastMessage);
				ce.lastMessage.get(MessageSize-1).getText().contains("Flockdesktop1 TestUser pinned an item to this conversation. You can access it via the Files App.");

				int itemSize = ce.pinItemLinks.size();
				ce.pinItemLinks.get(itemSize-1).isDisplayed();
				String itemText = ce.pinItemLinks.get(itemSize-1).getText();
				gm.compareString(itemText, "item");
				ce.pinItemLinks.get(itemSize-1).click();
				//ce.filesSelected.isDisplayed();
				
				int fileSize = ce.pinFilesLinks.size();
				ce.pinItemLinks.get(fileSize-1).isDisplayed();
				String fileText = ce.pinFilesLinks.get(itemSize-1).getText();
				gm.compareString(fileText, "Files");
				ce.pinItemLinks.get(fileSize-1).click();
				//ce.filesSelected.isDisplayed();

				driver.switchTo().defaultContent();
				ce.filesSelected.isDisplayed();
				boolean result = ce.filesSelected != null;
				Assert.assertTrue(result);
				test.log(LogStatus.PASS, "pinMessage Test Passed");
				log.error("pinMessage Test Passed");

			} else {
				test.log(LogStatus.FAIL, "pinMessage Test FAILED because the pinned chat bot message is not triggered");
				log.error("pinMessage Test FAILED because the pinned chat bot message is not triggered");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The pinned chat bot message is not triggered");
				sa.assertAll();
			}
		} else {
			test.log(LogStatus.FAIL,
					"pinMessage Test FAILED because the message action button dropdown is not dispalyed");
			log.error("pinMessage Test FAILED because the message action button dropdown is not dispalyed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The message action button dropdown is not dispalyed");
			sa.assertAll();
		}
	}

	@Test(priority = 3)
	public void setReminder() throws Exception {
		driver.switchTo().frame(ce1.appIframe);
		Thread.sleep(2000);
		ce1.textEditor.sendKeys("/remind all in 1 sec to TEST");
		if (ce1.slashRemindDisplayed()) {
			ce1.slashRemindParamDisplayed();
			ce1.slashRemindDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Press the enter key after /remind");
			test.log(LogStatus.INFO, "Press the enter key after /remind");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			if (ce.reminderActiveChatAreaFlockml.isDisplayed()) {
				log.info("reminder set succesfully using /remind");
				test.log(LogStatus.PASS, "reminder set succesfully using /remind");
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
				int size = ce.reminderViewButton.size();
				log.info("Size of the list: " + size);
				int finalSize = size - 1;
				log.info("Size of the final list: " + finalSize);
				if (ce.reminderViewButton.get(finalSize).isDisplayed()) {
					ce.reminderViewButton.get(finalSize).click();
					driver.switchTo().defaultContent();
					ce.reminderSelected.isDisplayed();
					boolean result = ce.reminderSelected != null;
					Assert.assertTrue(result);
					test.log(LogStatus.PASS, "Reminder View Button Click Test Passed");
					log.info("Reminder View Button Click Test Passed");
					driver.switchTo().frame(ce1.appIframe);
					
				} else {
					log.error("The view button below the reminder ack is not displayed");
					test.log(LogStatus.FAIL, "The view button below the reminder ack is not displayed");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The view button below the reminder ack is not displayed");
					sa.assertAll();
				}
				Thread.sleep(10000);
				int size1 = ce.messageActionButtonList.size();
				log.info("Size of the list: " + size1);
				int finalSize1 = size1 - 1;
				log.info("Size of the final list: " + finalSize1);
				if (ce.messageActionButtonList.get(finalSize1).isDisplayed()) {
					ce.messageActionButtonList.get(finalSize1).click();
					test.log(LogStatus.PASS, "Reminder Snooze button click Test Passed");
					log.info("Reminder Snooze button click Test Passed");
					Thread.sleep(2000);
					driver.switchTo().defaultContent();
					if (ce.snoozeReminderModalDisplayed()) {
						ce.snoozeReminderCancelClick();
						test.log(LogStatus.PASS, "Reminder Snooze Button Click Test Passed");
						log.info("Reminder Snooze Button Click Test Passed");
					} else {
						log.error("The snooze reminder modal below the reminder ack is not displayed");
						test.log(LogStatus.FAIL, "The snooze reminder modal below the reminder ack is not displayed");
					}
				} else {
					log.error("The snooze button below the reminder ack is not displayed");
					test.log(LogStatus.FAIL, "The snooze button below the reminder ack is not displayed");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "The snooze button below the reminder ack is not displayed");
					sa.assertAll();
				}
				driver.switchTo().frame(ce1.appIframe);
			} else {
				driver.switchTo().frame(ce1.appIframe);
				log.error("reminder was not set succesfully using /remind");
				test.log(LogStatus.FAIL, "reminder was not set succesfully using /remind");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "reminder was not set succesfully using /remind");
				sa.assertAll();
			}
		}
	}

	@Test(priority = 4)
	public void createTodo() throws Exception {
		driver.switchTo().defaultContent();
		ce.dismissCalendarPrompt();
		driver.switchTo().frame(ce1.appIframe);
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		Thread.sleep(1000);
		ce1.textEditor.sendKeys("/todo" + " " + generatedString);
		if (ce1.slashTodoDisplayed()) {
			ce1.slashTodoParamDisplayed();
			ce1.slashTodoDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			log.info("Press the enter key after /todo");
			test.log(LogStatus.INFO, "Press the enter key after /todo");
			int size = ce.lastToDoMessage.size();
			log.info(ce.lastToDoMessage.get(size-1).getText());
			assertEquals(ce.lastToDoMessage.get(size-1).getText(), generatedString);
			log.info("Todo created succesfully using /todo");
			test.log(LogStatus.PASS, "Todo created succesfully using /todo");

			int size2 = ce.todoViewButton.size();
			log.info("Size of the list: " + size2);
			int finalSize2 = size2 - 1;
			log.info("Size of the final list: " + finalSize2);
			if (ce.todoViewButton.get(finalSize2).isDisplayed()) {
				ce.todoViewButton.get(finalSize2).click();
				driver.switchTo().defaultContent();
				ce.todosSelected.isDisplayed();
				boolean result = ce.todosSelected != null;
				Assert.assertTrue(result);
				log.info("View button below the todo message clicked");
				test.log(LogStatus.PASS, "View button below the todo message clicked");
				driver.switchTo().frame(ce1.appIframe);
			} else {
				log.error("View button below the todo message not clicked");
				test.log(LogStatus.FAIL, "View button below the todo message not clicked");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "View button below the todo message not clicked");
				sa.assertAll();
			}
			int size1 = ce.messageActionButtonList.size();
			log.info("Size of the list: " + size1);
			int finalSize1 = size1 - 1;
			log.info("Size of the final list: " + finalSize1);
			if (ce.messageActionButtonList.get(finalSize1).isDisplayed()) {
				ce.messageActionButtonList.get(finalSize1).click();
				Thread.sleep(10000);
				List<WebElement> completedToDo=  driver.findElements(By.xpath("//div/del"));
				int completedSize = completedToDo.size();
				log.info(completedToDo.get(completedSize-1).getText());
				assertEquals(completedToDo.get(completedSize-1).getText(), generatedString);
				test.log(LogStatus.PASS, "Mark as done button click Test Passed");
				log.info("Mark as done button Test Passed");
			} else {
				log.error("Mark as done button Test not clicked");
				test.log(LogStatus.FAIL, "Mark as done button Test not clicked");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Mark as done button Test not clicked");
				sa.assertAll();
			}
			Thread.sleep(3000);
			int size3 = ce.messageActionButtonList.size();
			log.info("Size of the list: " + size3);
			int finalSize3 = size3 - 1;
			log.info("Size of the final list: " + finalSize3);
			if (ce.messageActionButtonList.get(finalSize3).isDisplayed()) {
				ce.messageActionButtonList.get(finalSize3).click();
				Thread.sleep(5000);
				log.info(ce.lastToDoMessage.get(size-1).getText());
				assertEquals(ce.lastToDoMessage.get(size-1).getText(), generatedString);
				test.log(LogStatus.PASS, "Reopen button click Test Passed");
				log.info("Reopen button Test Passed");
			} else {
				log.error("Reopen button Test not clicked");
				test.log(LogStatus.FAIL, "Reopen button Test not clicked");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Reopen button Test not clicked");
				sa.assertAll();
			}

		} else {
			log.info("Slash Todo command was not displayed");
			test.log(LogStatus.FAIL, "Slash Todo command was not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Slash Todo command was not displayed");
			sa.assertAll();
		}
	}

	@Test(priority = 5)
	public void startVideo() throws Exception {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		Thread.sleep(1000);
		ce1.textEditor.sendKeys("/video" + " " + generatedString);
		if (ce1.slashVideoDisplayed()) {
			ce1.slashVideoParamDisplayed();
			ce1.slashVideoDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(applink.get(1));	
			log.info("Url opened");
			driver.close();
			driver.switchTo().window(applink.get(0));
			log.info("Press the enter key after /video");
			test.log(LogStatus.INFO, "Press the enter key after /video");
			driver.switchTo().frame(ce1.appIframe);
			List<WebElement> appearLinks = driver.findElements(By.cssSelector(".message_area_root .daySeparator:last-child .minute_separator:last-child .message_text>span>a"));
			int size = appearLinks.size();
			assertTrue(appearLinks.get(size - 1).getText().contains("https://flockv2.flock-staging.com/call/"));
			log.info("video conference link shared succesfully using /video");
			test.log(LogStatus.PASS, "video conference link shared succesfully using /video");
			
		} else {
			log.info("Slash video command was not displayed");
			test.log(LogStatus.FAIL, "Slash video command was not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Slash video command was not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority = 6) // React a message
	public void reactMessage() throws Exception {
		Thread.sleep(2000);
		ce1.textEditor.sendKeys("React to this message");
		ce1.textEditor.sendKeys(Keys.ENTER);
		log.info("Test message sent in the channel");
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		
		int size = ce.messageActionDropDown.size();
		log.info("Size of the list: " + size);
		int finalSize = size - 1;
		log.info("Size of the final list: " + finalSize);
		int msg = ce.lastMessage.size();
		log.info("List of last message " + msg);
		int msgSize = msg - 1;

		action.moveToElement(ce.lastMessage.get(msgSize)).moveToElement(ce.messageActionDropDown.get(finalSize)).click()
				.build().perform();

		Thread.sleep(2000);
		gm.getElementList(
				".message_area_root .daySeparator:last-child .minute_separator:last-child .overlay-menu-arrow", "css");
		gm.isElementPresent(
				".message_area_root .daySeparator:last-child .minute_separator:last-child .overlay-menu-arrow", "css");
		if (gm.elementDisplayed(
				By.xpath("//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]"),
				"App action dropdown")) {
			log.info("Inside the popup");
			gm.click(
					By.xpath(
							"//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]//div[@data-buttonid='app___7101d22f-0f12-46ef-a7fa-310b7fc6900e']"),
					0);
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			if(ce.reactionModal.isDisplayed()){
				
				driver.switchTo().frame(ce.reactFrame);
				log.info("Inside the frame");
				driver.findElement(By.xpath("//ul[@id='select-reaction-container']/li[1]")
						).click();
				Thread.sleep(3000);
				driver.switchTo().frame(ce1.appIframe);
				
				int reactFrame = ce.reactedFrame.size();
				driver.switchTo().frame(ce.reactedFrame.get(reactFrame-1));
				log.info("inside the reacted frane");
				Thread.sleep(5000);
				assertEquals(driver.findElement(By.xpath("//a[@id='preview-text']/span")).getText(), "Flockdesktop1");
				log.info("Reacted to the test message");
				test.log(LogStatus.PASS, "Reacted to the test message");
			}else{
				test.log(LogStatus.FAIL,
						"reactMessage Test FAILED because the reaction modal not dispalyed");
				log.error("reactMessage Test FAILED because the reaction modal is not dispalyed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The reaction modal is not dispalyed");
				sa.assertAll();
			}
			
		} else {
			test.log(LogStatus.FAIL,
					"reactMessage Test FAILED because the message action button dropdown is not dispalyed");
			log.error("reactMessage Test FAILED because the message action button dropdown is not dispalyed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The message action button dropdown is not dispalyed");
			sa.assertAll();
		}
	}
	
	@Test(priority=7)
	public void gitHub() throws Exception{
		SoftAssert sas = new SoftAssert();
        driver.switchTo().defaultContent();
		ce.rosterSideBar.click();
		ce1.openChannelRoster("gitHub");
		Thread.sleep(2000);
		driver.switchTo().frame(ce1.appIframe);
		
		int MessageSize =ce.lastGithubMessage.size();
		ce.lastGithubMessage.get(MessageSize-1).isDisplayed();
		String text = ce.lastGithubMessage.get(MessageSize-1).getText();
		text.equals("talk-to/horus");
		log.info(text);
		if(ce.lastGithubMessage.get(MessageSize-1).isDisplayed()){
			ce.lastGithubMessage.get(MessageSize-1).click();
			Thread.sleep(2000);
			ArrayList<String> applink = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(applink.get(1));
			sas.assertEquals(driver.getCurrentUrl(),
					"https://github.com/talk-to/horus");
			log.info("Url opened");
			driver.close();
			driver.switchTo().window(applink.get(0));
			log.info("Repo link opened from the github message");
			test.log(LogStatus.PASS, "Repo link opened from the github message");
		}else{
			test.log(LogStatus.FAIL,
					"The gitHub bot message is not displayed");
			log.error("The gitHub bot message is not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The gitHub bot message is not displayed");
			sa.assertAll();
		}
		
	}
	
}
