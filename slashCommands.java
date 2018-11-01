package com.Flock.HydraAutomation;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericMethods;
import com.utilities.clientElement;

public class slashCommands extends BaseTestSuite {	
  	
	public void openChannel() throws Exception {
		
	Thread.sleep(4000);	
	  //ce1.clickDirectory();	
	  Thread.sleep(2000);
	  ce1.openChannelRoster("Slash Command Test Channel");
	  Thread.sleep(2000);
	  driver.switchTo().frame(ce1.appIframe);		
  }
	
	@Test (priority = 0)
	public void slashAdd() throws Exception {
		
		driver.switchTo().frame(ce1.appIframe);
		
		openChannel();
		Thread.sleep(15000);
		
		ce1.textEditor.sendKeys("/add");
		if(ce1.slashAddDisplayed()){
		ce1.slashAddParamDisplayed();
		ce1.slashAddDescriptionDisplayed();
		ce1.textEditor.sendKeys(Keys.ENTER);
		ce1.textEditor.sendKeys("flockdesktop2@flock.com");
		Thread.sleep(1000);
		ce1.textEditor.sendKeys(Keys.ENTER);
		log.info("Selected the user from magic list");
		test.log(LogStatus.INFO, "Selected the user from magic list");
		Thread.sleep(2000);
		ce1.textEditor.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		log.info("Added the user inside Channel");
		test.log(LogStatus.INFO, "Added the user inside Channel");
		if(ce1.channelMemberListIconPresent()){
			ce1.clickChannelMemberListIcon();
			if(ce1.memberNameGroupDropdownDisplayed()){
				log.info("User Added successfully using /add");
				test.log(LogStatus.PASS, "User Added successfully using /add");
				ce1.removeFromChannel("Flockdesktop2 T");
			}else{
				ce1.clickChannelMemberListIcon();
				log.info("User was not added successfully using /add");
				test.log(LogStatus.FAIL, "User was not added successfully using /add");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "User was not added successfully using /add");
				sa.assertAll();
			}
		}
	}
}
	
	@Test (priority = 1)
	public void slashMute() throws Exception{
		
		/*driver.switchTo().defaultContent();
		ce.dismissCalendarPrompt();
		driver.switchTo().frame(ce1.appIframe);*/
		/*Thread.sleep(30000);
		driver.switchTo().defaultContent();
		ce.dismissFeatureTourPrompt();*/
		ce1.textEditor.click();
		ce1.textEditor.clear();
		ce1.textEditor.sendKeys("/mute");
		if(ce1.slashMuteDisplayed()){
			ce1.slashMuteParamDisplayed();
			ce1.slashMuteDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash Mute command");
			test.log(LogStatus.INFO, "Selected the slash Mute command");
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Muted the channel using enter key");
			test.log(LogStatus.INFO, "Muted the channel using enter key");
		    Thread.sleep(2000);
		    if(ce1.muteIconPresent()){
		    	log.info("Channel Muted Succesfully using slash mute");
				test.log(LogStatus.PASS, "Channel Muted Succesfully using slash mute");
				Thread.sleep(2000);
		    }else{
		    	log.info("Channel was not muted using /mute");
				test.log(LogStatus.FAIL, "Channel was not muted using /mute");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Channel was not muted using /mute");
				sa.assertAll();
		    }
		    
		}
	}
	
	@Test (priority = 2)
	public void slashUnmute() throws Exception{

		ce1.textEditor.click();
		ce1.textEditor.clear();
		ce1.textEditor.sendKeys("/unmute");
		if(ce1.slashUnmuteDisplayed()){
			ce1.slashUnmuteParamDisplayed();
			ce1.slashUnmuteDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash Unmute command");
			test.log(LogStatus.INFO, "Selected the slash Unmute command");
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Unmuted the channel using enter key");
			test.log(LogStatus.INFO, "Unmuted the channel using enter key");
		    Thread.sleep(2000);
		    if(ce1.unmuteIconPresent()){
		    	log.info("Channel Unmuted Succesfully using slash unmute");
				test.log(LogStatus.PASS, "Channel Unmuted Succesfully using slash unmute");
				Thread.sleep(2000);
		    }else{
		    	log.info("Channel was not unmuted using /unmute");
				test.log(LogStatus.FAIL, "Channel was not unmuted using /unmute");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Channel was not unmuted using /unmute");
				sa.assertAll();
		    }
		    
		}
	}
	
	@Test (priority = 3)
	public void slashStatus() throws Exception{
		
		
		ce1.textEditor.clear();
		ce1.textEditor.sendKeys("/status Test Status");
		if(ce1.slashStatusDisplayed()){
			ce1.slashStatusParamDisplayed();
			ce1.slashStatusDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Changed the status using /status");
			test.log(LogStatus.INFO, "Changed the status using /status");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			if(ce1.contactAvatarStatus1Displayed()){
				log.info("Status Changed Succesfully using slash status");
				test.log(LogStatus.PASS, "Status Changed Succesfully using slash status");
				Thread.sleep(2000);
				driver.switchTo().frame(ce1.appIframe);
				ce1.textEditor.click();
				ce1.textEditor.sendKeys("/status Available");
				ce1.textEditor.sendKeys(Keys.ENTER);
				log.info("Status Changed back to 'Available'");
				test.log(LogStatus.PASS, "Status Changed back to 'Available'");
				Thread.sleep(1000);
			}else{
				driver.switchTo().frame(ce1.appIframe);
				log.info("Status was not changed using /status");
				test.log(LogStatus.FAIL, "Status was not changed using /status");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Status was not changed using /status");
				sa.assertAll();
			}
		}
	}
	
	@Test (priority = 4)
	public void slashKeyboardShortcuts() throws Exception{
		
		ce1.textEditor.sendKeys("/shortcuts");
		if(ce1.slashShortcutsDisplayed()){
			ce1.slashShortcutDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash keyboard shortcuts using enter");
			test.log(LogStatus.INFO, "Selected the slash keyboard shortcuts using enter");
			driver.switchTo().defaultContent();
			if(ce1.keyboardShortcutsTitleDisplayed()){
				log.info("Keyboard Shortcut Modal opened using slash shortcuts");
				test.log(LogStatus.PASS, "Keyboard Shortcut Modal opened using slash shortcuts");
				ce1.clickKeyboardShortcutsClose();
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
			}else{
				log.info("Keyboard shortcut modal was not displayed using slash shortcuts");
				test.log(LogStatus.FAIL, "Keyboard shortcut modal was not displayed using slash shortcuts");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Keyboard shortcut modal was not displayed using slash shortcuts");
				sa.assertAll();	
			}
		}	
	}
	
	@Test (priority = 5)
	public void slashLeave() throws Exception{
		
		driver.switchTo().defaultContent();
		ce.dismissFeatureTourPrompt();
		driver.switchTo().frame(ce1.appIframe);
		ce1.textEditor.click();
		ce1.textEditor.sendKeys("/leave");
		if(ce1.slashLeaveDisplayed()){
			ce1.slashLeaveDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash leave shortcuts using enter");
			test.log(LogStatus.INFO, "Selected the leave keyboard shortcuts using enter");
			driver.switchTo().defaultContent();
			if(ce1.leaveChannelConfirmationTitlePresent()){
				log.info("Leave Channel Confirmation Box opens using slash Leave");
				test.log(LogStatus.PASS, "Leave Channel Confirmation Box opens using slash Leave");
				ce1.clickCancelButton();
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(2000);
			}else{
				driver.switchTo().frame(ce1.appIframe);
				log.info("Leave Channel Confirmation Box was not displayed using slash Leave");
				test.log(LogStatus.FAIL, "Leave Channel Confirmation Box was not displayed using slash Leave");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Leave Channel Confirmation Box was not displayed using slash Leave");
				sa.assertAll();	
			}
		}	
	}
	
	@Test (priority = 6)
	public void slashClone() throws Exception{
		
		ce1.textEditor.click();
		ce1.textEditor.sendKeys("/clone");
		if(ce1.slashCloneDisplayed()){
			ce1.slashCloneDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Selected the slash clone using enter");
			test.log(LogStatus.INFO, "Selected the slash clone using enter");
			driver.switchTo().defaultContent();
			if(ce1.cloneTitlePresent()){
				log.info("Clone Channel Confirmation Box opens using slash clone");
				test.log(LogStatus.PASS, "Clone Channel Confirmation Box opens using slash clone");
				ce1.clickYesCloneButton();
				driver.switchTo().frame(ce1.appIframe);
				Thread.sleep(1000);
				if(ce1.cloneChannelTextEditorPresent()){
					log.info("Channel succesfully cloned using /clone");
					test.log(LogStatus.PASS, "Channel succesfully cloned using /clone");
					ce1.textEditor.sendKeys("/leave");
					ce1.textEditor.sendKeys(Keys.ENTER);
					driver.switchTo().defaultContent();
					ce1.clickLeaveDeleteChannelButton();
					Thread.sleep(2000);
					log.info("Left the cloned channel using /leave");
					test.log(LogStatus.INFO, "Left the cloned channel /leave");	
					driver.switchTo().frame(ce1.appIframe);
					ce1.textEditor.clear();
				}else{
					driver.switchTo().frame(ce1.appIframe);
					log.info("Channel was not cloned using /clone");
					test.log(LogStatus.FAIL, "Channel was not cloned using /clone");
					SoftAssert sa = new SoftAssert();
					sa.assertTrue(false, "Channel was not cloned using /clone");
					sa.assertAll();	
				}	
			}else{
				log.info("Clone channel confirmation box was not displayed");
				test.log(LogStatus.FAIL, "Clone channel confirmation box was not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Clone channel confirmation box was not displayed");
				sa.assertAll();	
			}
		}	
	}
	
	@Test (priority = 7)
	public void slashRemind() throws Exception{
	
		ce1.textEditor.sendKeys("/remind all in 1 sec to TEST");
		if(ce1.slashRemindDisplayed()){
			ce1.slashRemindParamDisplayed();
			ce1.slashRemindDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			log.info("Press the enter key after /remind");
			test.log(LogStatus.INFO, "Press the enter key after /remind");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			if(ce1.reminderActiveChatAreaDisplayed()){
				log.info("reminder set succesfully using /remind");
				test.log(LogStatus.PASS, "reminder set succesfully using /remind");
				driver.switchTo().frame(ce1.appIframe);
			}else{
				driver.switchTo().frame(ce1.appIframe);
				log.info("reminder was not set succesfully using /remind");
				test.log(LogStatus.FAIL, "reminder was not set succesfully using /remind");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "reminder was not set succesfully using /remind");
				sa.assertAll();	
			}
		}
	}
	
	@Test (priority = 8)
	public void slashVideo() throws Exception{
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		Thread.sleep(1000);
		ce1.textEditor.sendKeys("/video" + " " + generatedString);
		if(ce1.slashVideoDisplayed()){
			ce1.slashVideoParamDisplayed();
			ce1.slashVideoDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			log.info("Press the enter key after /video");
			test.log(LogStatus.INFO, "Press the enter key after /video");
			SoftAssert sa = new SoftAssert();
			ArrayList<String> videolink = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(videolink.get(1));
			Thread.sleep(5000);	
			System.out.println(driver.getCurrentUrl());
			sa.assertTrue(driver.getCurrentUrl().contains("https://flockv2.flock-staging.com/call/"));
			driver.close();
			driver.switchTo().window(videolink.get(0));
			driver.switchTo().frame(ce1.appIframe);
			Thread.sleep(2000);
			sa.assertAll();
			/*List<WebElement> appearLinks = driver.findElements(By.xpath("//a[@class='appear-links']"));
			int size = appearLinks.size();
			log.info(appearLinks.get(size-1).getText());
			assertEquals(appearLinks.get(size-1).getText(), "https://flockv2.flock-staging.com/call/" + generatedString, "/video working");*/
			log.info("video conference link shared succesfully using /video");
			test.log(LogStatus.PASS, "video conference link shared succesfully using /video");
			}else{
				log.info("Slash video command was not displayed");
				test.log(LogStatus.FAIL, "Slash video command was not displayed");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Slash video command was not displayed");
				sa.assertAll();	
			}		
		}
	
	@Test (priority = 9)
	public void slashTodo() throws Exception{
		
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		Thread.sleep(1000);
		ce1.textEditor.sendKeys("/todo" + " " + generatedString);
		if(ce1.slashTodoDisplayed()){
		ce1.slashTodoParamDisplayed();
		ce1.slashTodoDescriptionDisplayed();
		ce1.textEditor.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		log.info("Press the enter key after /todo");
		test.log(LogStatus.INFO, "Press the enter key after /todo");
		List<WebElement> TodoLinks = driver.findElements(By.xpath("//div[@class='attachmentDiv']//p"));
		int size = TodoLinks.size();
		log.info(size);
		log.info(TodoLinks.get(size-1).getText());
		assertEquals(TodoLinks.get(size-1).getText(),generatedString, "/todo working");
		log.info("Todo created succesfully using /todo");
		test.log(LogStatus.PASS, "Todo created succesfully using /todo");
		}else{
			log.info("Slash Todo command was not displayed");
			test.log(LogStatus.FAIL, "Slash Todo command was not displayed");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Slash Todo command was not displayed");
			sa.assertAll();	
		}	
	}
	
	@Test (priority = 10)
	public void slashGiphy() throws Exception{
		
		ce1.textEditor.sendKeys("/giphy Test");
		if(ce1.slashGiphyDisplayed()){
			ce1.slashGiphyParamDisplayed();
			ce1.slashGiphyDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			log.info("Press the enter key after /giphy");
			test.log(LogStatus.INFO, "Press the enter key after /giphy");
			driver.switchTo().defaultContent();
			if(ce1.giphyDisplayed()){
				log.info("Giphy shared succesfully using /giphy");
				test.log(LogStatus.PASS, "Giphy shared succesfully using /giphy");
				driver.switchTo().frame(ce1.appIframe);
			}else{
				driver.switchTo().frame(ce1.appIframe);
				log.info("Giphy was not shared succesfully using /giphy");
				test.log(LogStatus.FAIL, "Giphy was not shared succesfully using /giphy");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Giphy was not shared succesfully using /giphy");
				sa.assertAll();	
			}
		}
	}
	
	@Test (priority = 11)
		public void slashPoll() throws Exception{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		ce1.textEditor.sendKeys("/poll This is a " + generatedString + " test question o: Option 1, Option 2");
		if(ce1.slashPollDisplayed()){
			ce1.slashPollParamDisplayed();
			ce1.slashPollDescriptionDisplayed();
			ce1.textEditor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			log.info("Press the enter key after /poll");
			test.log(LogStatus.INFO, "Press the enter key after /poll");
			List<WebElement> PollLinks = driver.findElements(By.xpath("//div[@class='titleDiv']"));
			int size = PollLinks.size();
			log.info(PollLinks.get(size-1).getText());
			assertEquals(PollLinks.get(size-1).getText(),"This is a " + generatedString + " test question", "/poll working");
			log.info("Poll created succesfully using /poll");
			test.log(LogStatus.PASS, "Poll created succesfully using /poll");
		
			}
		}
	
	@Test (priority = 12)
	public void browseSlashCommandsChannels() throws Exception{
		
		ce1.textEditor.sendKeys("/");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/add");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/mute");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/unmute");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/status");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/shortcuts");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/leave");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/clone");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/github");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/giphy");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/remind");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/audio");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/video");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/poll");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/todo");
		sa.assertAll();	
		log.info("All the slash commands are present in correct sequence");
		test.log(LogStatus.PASS, "All the slash commands are present in correct sequence");
		ce1.textEditor.clear();
		driver.switchTo().defaultContent();
	}
	
	@Test (priority = 13)
	public void browseSlashCommandsIndividualChat() throws Exception {
		
		ce.universalSearchSendKeys("flockdesktop2");
		ce1.universalSearchResultSelected.click();
		Thread.sleep(2000);
		driver.switchTo().frame(ce1.appIframe);
		ce1.textEditor.sendKeys("/");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/add");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/mute");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/unmute");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/status");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/shortcuts");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/github");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/giphy");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/remind");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/audio");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/video");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/poll");
		ce1.textEditor.sendKeys(Keys.DOWN);
		sa.assertEquals(ce1.slashCommandSelected.getText(),"/todo");
		sa.assertAll();	
		log.info("All the slash commands inside Individual Chat are present in correct sequence");
		test.log(LogStatus.PASS, "All the slash commands inside individual Chat are present in correct sequence");
		ce1.textEditor.sendKeys("mute");
		ce1.textEditor.sendKeys(Keys.ENTER);
		if(ce1.textEditorContactDropDown != null) {
			log.info("@ was appended and contact dropdown displayed using /mute under individual chat");
			test.log(LogStatus.PASS, "@ was appended and contact dropdown displayed using /mute under individual chat");
			ce1.textEditor.clear();
			driver.switchTo().defaultContent();
		}else{
			log.info("@ was not appended and contact dropdown was displayed");
			test.log(LogStatus.FAIL, "@ was not appended and contact dropdown was displayed");
			sa.assertTrue(false, "@ was not appended and contact dropdown was displayed");
			sa.assertAll();	
			driver.switchTo().defaultContent();
		}
	}
	
}	


