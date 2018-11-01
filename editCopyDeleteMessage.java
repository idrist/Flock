package com.Flock.HydraAutomation;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class editCopyDeleteMessage extends BaseTestSuite {
	/*
	 * Created on 15th May 2018 By Farzan Shaikh
	 */

	private static final Logger log = LogManager.getLogger(editCopyDeleteMessage.class.getName());

	@Test(priority = 1)
	public void openChannel() throws Exception {

		ce1.openChannelRoster("Flockml Channel");
		Thread.sleep(2000);
		driver.switchTo().frame(ce1.appIframe);
		log.info("Test channel opened and focus shifted to the channel iframe");
	}

	@Test(priority = 2)
	public void editMessage() throws InterruptedException {
		Thread.sleep(2000);
		ce1.textEditor.sendKeys("Edit message");
		ce1.textEditor.sendKeys(Keys.ENTER);
		log.info("Test message sent in the channel");

		Actions action = new Actions(driver);
		int size = ce.messageActionDropDown.size();
		log.info("Size of the list: " + size);
		int finalSize = size - 1;
		log.info("Size of the final list: " + finalSize);
		int msg = ce.lastMessage.size();
		log.info("List of last message " + msg);
		int msgSize = msg - 1;

		Thread.sleep(7000);

		action.moveToElement(ce.lastMessage.get(msgSize)).moveToElement(ce.messageActionDropDown.get(finalSize)).build()
				.perform();

		int size1 = ce.editMessageIconList.size();
		log.info(size1);
		ce.editMessageIconList.get(size1 - 1).click();

		ce1.textEditor.clear();
		ce1.textEditor.sendKeys("Edited");
		ce1.textEditor.sendKeys(Keys.ENTER);

		int size2 = ce.editedLabelList.size();
		if (ce.editedLabelList.get(size2 - 1).isDisplayed()) {
			boolean result = ce.editedLabelList.get(size2 - 1) != null;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "editMessage Test Passed");
			log.info("editMessage Test Passed");
		} else {
			test.log(LogStatus.FAIL, "editMessage Test FAILED because the message is not edited");
			log.error("editMessage Test FAILED because the message is not edited");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The message is not edited");
			sa.assertAll();
		}
	}

	@Test(priority = 3)
	public void editMessageUpKey() throws InterruptedException {
		Thread.sleep(3000);
		ce1.textEditor.sendKeys(Keys.UP);
		if (ce.editMessageModal.isDisplayed()) {
			editModalContent();	 
			boolean result = ce.editMessageModal != null;
			Assert.assertTrue(result);
			test.log(LogStatus.PASS, "editMessageUpKey Test Passed");
			log.info("editMessageUpKey Test Passed");
			ce.editCancelButton.click();
		} else {
			test.log(LogStatus.FAIL, "editMessageUpKey Test FAILED because the edit message modal did not open");
			log.error("editMessageUpKey Test FAILED because the edit message modal did not open");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The edit message modal did not open");
			sa.assertAll();
		}
	}
	
	public void editModalContent(){
		gm.elementDisplayed(By.xpath("//div[@class='edit-message']//textarea[@id='whatsNewHookEditorArea']"), "Message editor in the edit message modal");
		
		gm.elementDisplayed(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_cancelButton']"), "Cancel button in edit message modal");
		gm.getText(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_cancelButton']"));
		gm.compareText(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_cancelButton']"), "Cancel");
		
		gm.elementDisplayed(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_saveButton']"), "Cancel button in edit message modal");
		gm.getText(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_saveButton']"));
		gm.compareText(By.xpath("//div[@class='edit-message']//button[@data-dojo-attach-point='_saveButton']"), "Save");
	}
	
	@Test(priority = 4)
	public void editMessageNoChange() throws InterruptedException {
		Thread.sleep(3000);
		ce1.textEditor.sendKeys(Keys.UP);
		if (ce.editMessageModal.isDisplayed()) {
			Thread.sleep(2000);
			ce.editSaveButton.click();
		
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "editMessageNoChange Test Passed");
			log.info("editMessageNoChange Test Passed");
		} else {
			test.log(LogStatus.FAIL, "editMessageUpKey Test FAILED because the edit message modal did not open");
			log.error("editMessageUpKey Test FAILED because the edit message modal did not open");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The edit message modal did not open");
			sa.assertAll();
		}
		
	}
	
	@Test(priority=5
			)
	public void deleteMessageCancel() throws InterruptedException{
		Actions action = new Actions(driver);
		int size = ce.messageActionDropDown.size();
		log.info("Size of the list: " + size);
		int finalSize = size - 1;
		log.info("Size of the final list: " + finalSize);
		int msg = ce.lastMessage.size();
		log.info("List of last message " + msg);
		int msgSize = msg - 1;

		action.moveToElement(ce.lastMessage.get(msgSize)).build().perform();
		String lastMessage = ce.lastMessage.get(msgSize).getText();
		action.moveToElement(ce.messageActionDropDown.get(finalSize)).click()
				.build().perform();
		if (gm.elementDisplayed(
				By.xpath("//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]"),
				"App action dropdown")) {
			log.info("Inside the popup");
			gm.click(
					By.xpath(
							"//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]//div[@data-buttonid='deleteIcon']"),
					0);
			Thread.sleep(3000);
			deleteMessageContent();
			
			ce.cancelButton.click();
			driver.switchTo().frame(ce1.appIframe);
			if(ce.lastMessage.get(msgSize).getText().contains("Edited")){
				test.log(LogStatus.PASS, "deleteMessage Test Passed");
				log.info("deleteMessage Test Passed");
				}else
				{test.log(LogStatus.FAIL,
						"deleteMessage Test FAILED because the message is not deleted");
				log.error("deleteMessage Test FAILED because the message is not deleted");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The message is not deleted");
				sa.assertAll();	
				}
			}
	}
	
	public void deleteMessageContent() throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		gm.elementDisplayed(By.xpath("//div[@class='title']"), "Delete message heading");
		gm.getText(By.xpath("//div[@class='title']"));
		gm.compareText(By.xpath("//div[@class='title']"), "Delete message?");
		
		gm.elementDisplayed(By.xpath("//div[@class='sub-title']"), "Delete message Sub Title");
		gm.getText(By.xpath("//div[@class='sub-title']"));
		
		gm.elementDisplayed(By.xpath("//button[@data-dojo-attach-point='cancelLink']"), "Cancel button");
		gm.getText(By.xpath("//button[@data-dojo-attach-point='cancelLink']"));
		gm.compareText(By.xpath("//button[@data-dojo-attach-point='cancelLink']"), "Cancel");
		
		gm.elementDisplayed(By.xpath("//button[@data-dojo-attach-point='okButton']"), "Delete button");
		gm.getText(By.xpath("//button[@data-dojo-attach-point='okButton']"));
		gm.compareText(By.xpath("//button[@data-dojo-attach-point='okButton']"), "Yes, delete");
	}
	
	@Test(priority= 6)
	public void deleteMessage() throws InterruptedException{
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
							"//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]//div[@data-buttonid='deleteIcon']"),
					0);
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			ce.deleteMessageButton.click();
			driver.switchTo().frame(ce1.appIframe);
			Thread.sleep(3000);
			if(ce.lastMessage.get(msgSize).getText().contains("Edited")){
				test.log(LogStatus.FAIL,
						"deleteMessage Test FAILED because the message is not deleted");
				log.error("deleteMessage Test FAILED because the message is not deleted");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The message is not deleted");
				sa.assertAll();
				}else
				{
					test.log(LogStatus.PASS, "deleteMessage Test Passed");
					log.info("deleteMessage Test Passed");
				}
		} else {
			test.log(LogStatus.FAIL,
					"deleteMessage Test FAILED because the message action button dropdown is not dispalyed");
			log.error("deleteMessage Test FAILED because the message action button dropdown is not dispalyed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The message action button dropdown is not dispalyed");
			sa.assertAll();
		}
	}
	
	@Test(priority=7)
	public void copyMessage() throws InterruptedException{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		Thread.sleep(1000);
		ce1.textEditor.sendKeys(generatedString);
		ce1.textEditor.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		int size = ce.messageActionDropDown.size();
		log.info("Size of the list: " + size);
		int finalSize = size - 1;
		log.info("Size of the final list: " + finalSize);
		int msg = ce.lastMessage.size();
		log.info("List of last message " + msg);
		int msgSize = msg - 1;

		action.moveToElement(ce.lastMessage.get(msgSize)).build().perform();
		String lastMessage = ce.lastMessage.get(msgSize).getText();
		action.moveToElement(ce.messageActionDropDown.get(finalSize)).click()
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
							"//div[contains(@class,'message-overlay-menu') and contains(@class,'messageContext')]//div[@data-buttonid='copyIcon']"),
					0);
			Thread.sleep(3000);
			ce1.textEditor.sendKeys(Keys.CONTROL+"V");
			ce1.textEditor.sendKeys(Keys.ENTER);

			Thread.sleep(3000);
			
			if(lastMessage.contains(generatedString)){
				test.log(LogStatus.PASS, "copyMessage Test Passed");
				log.info("copyMessage Test Passed");
			}else {
				test.log(LogStatus.FAIL,
						"pinMessage Test FAILED because copied message do not match");
				log.error("pinMessage Test FAILED because copied message do not match");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The copied message do not match");
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
	
}
