package com.Flock.HydraAutomation;

import static org.testng.Assert.assertEquals;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class KeyboardShortcuts extends BaseTestSuite {
  
	@Test (priority = 1)
  public void ctrlPlusSlashAndContent() {
		SoftAssert sa = new SoftAssert();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("/").keyUp(Keys.CONTROL).perform();
		try{
		if(ce1.keyboardShortcutsTitleDisplayed()){
			log.info("Ctrl+/ keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Ctrl+/ keyboard shortcut is working fine");
			List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'keyboard-shortcuts')]//td"));
			int size = list.size();
			sa.assertEquals(size, 20);
			sa.assertEquals(list.get(0).getText(),"Ctrl+K");
			sa.assertEquals(list.get(1).getText(),"New Chat");
			sa.assertEquals(list.get(2).getText(),"Ctrl+F");
			sa.assertEquals(list.get(3).getText(),"Search Conversations");
			sa.assertEquals(list.get(4).getText(),"Alt+↑");
			sa.assertEquals(list.get(5).getText(),"Cycle through open chat tabs (upward)");
			sa.assertEquals(list.get(6).getText(),"Alt+↓");
			sa.assertEquals(list.get(7).getText(),"Cycle through open chat tabs (downward)");
			sa.assertEquals(list.get(8).getText(),"Ctrl+D");
			sa.assertEquals(list.get(9).getText(),"Recent Chats and Directory");
			sa.assertEquals(list.get(10).getText(),"Ctrl+.");
			sa.assertEquals(list.get(11).getText(),"Toggle Right Sidebar");
			sa.assertEquals(list.get(12).getText(),"Esc");
			sa.assertEquals(list.get(13).getText(),"Close current chat tab");
			sa.assertEquals(list.get(14).getText(),"Shift+Esc");
			sa.assertEquals(list.get(15).getText(),"Reopen last closed chat tab");
			sa.assertEquals(list.get(16).getText(),"Ctrl+E");
			sa.assertEquals(list.get(17).getText(),"Move focus to message editor");
			sa.assertEquals(list.get(18).getText(),"Ctrl+/");
			sa.assertEquals(list.get(19).getText(),"Show this list");
			ce1.clickKeyboardShortcutsClose();
//			sa.assertAll();
			log.info("Content of keyboard shortcuts modal is correct");
			test.log(LogStatus.PASS, "Content of keyboard shortcuts modal is correct");
			}
		}catch(Exception e){
			log.error("Content of keyboard shortcuts modal is not correct");
			test.log(LogStatus.FAIL, "Content of keyboard shortcuts modal is not correct");
			ce1.clickKeyboardShortcutsClose();
		}		
	}
	
	@Test (priority = 0)
	  public void ctrlPlusK() throws Exception {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("k").keyUp(Keys.CONTROL).perform();
		if(ce1.frequentDisplayed()){
			log.info("Ctrl+k keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Ctrl+k keyboard shortcut is working fine");
		}else{
			log.error("Ctrl+k keyboard shortcut is not working fine");
			test.log(LogStatus.FAIL, "Ctrl+k keyboard shortcut is not working fine");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Ctrl+k keyboard shortcut is not working fine");
			sa.assertAll();
		}
	}

	@Test (priority = 7)
	  public void ctrlPlusF() throws Exception {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).perform();
		if(ce1.hisotrySearchTitleDisplayed()){
			log.info("Ctrl+f keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Ctrl+f keyboard shortcut is working fine");
		}else{
			log.error("Ctrl+f keyboard shortcut is not working fine");
			test.log(LogStatus.FAIL, "Ctrl+f keyboard shortcut is not working fine");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Ctrl+f keyboard shortcut is not working fine");
			sa.assertAll();
			}
		}
	
	@Test (priority = 2)
	public void altUpAndDown() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		//ce1.clickDirectory();
		Thread.sleep(1000);
		 ce1.openChannelRoster("Always Muted Channel");
		 ce1.openChannelRoster("Slash Command Test Channel");
		 Thread.sleep(1000);
		 action.keyDown(Keys.ALT).sendKeys(Keys.DOWN).keyUp(Keys.ALT).perform();
		 WebElement activechat = driver.findElement(By.xpath("//div[contains(@class,'selected')]//div[contains(text(),'All Channel Feed')]"));
		 if(activechat != null){
			 log.info("Alt+down keyboard shortcut is working fine");
			 test.log(LogStatus.PASS, "Alt+down keyboard shortcut is working fine");
		 }else{
			log.error("Alt+down keyboard shortcut is not working fine");
			test.log(LogStatus.FAIL, "Alt+down keyboard shortcut is not working fine");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Alt+down keyboard shortcut is not working fine");
			sa.assertAll();
		 }
		 action.keyDown(Keys.ALT).sendKeys(Keys.DOWN).keyUp(Keys.ALT).perform();
		 WebElement activechat1 = driver.findElement(By.xpath("//div[contains(@class,'selected')]//div[contains(text(),'Muted Channel')]"));
		 if(activechat1 != null){
			 log.info("Alt+down keyboard shortcut is working fine from open chats to muted channels");
			 test.log(LogStatus.PASS, "Alt+down keyboard shortcut is working fine from open chats to muted channels");
		 }else{
			log.error("Alt+down keyboard shortcut is not working fine from open chats to muted channels");
			test.log(LogStatus.FAIL, "Alt+down keyboard shortcut is not working fine from open chats to muted channels");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Alt+down keyboard shortcut is not working fine");
			sa.assertAll();
		 }
		 action.keyDown(Keys.ALT).sendKeys(Keys.UP).keyUp(Keys.ALT).perform();
		 action.keyDown(Keys.ALT).sendKeys(Keys.UP).keyUp(Keys.ALT).perform();
		 WebElement activechat2 = driver.findElement(By.xpath("//div[contains(@class,'selected')]//div[contains(text(),'Slash Command')]"));
		 if(activechat2 != null){
			 log.info("Alt+Up keyboard shortcut is working fine from muted channels to open chats");
			 test.log(LogStatus.PASS, "Alt+Up keyboard shortcut is working fine from muted channels to open chats");
		 }else{
			log.error("Alt+Up keyboard shortcut is not working fine from muted channels to open chats");
			test.log(LogStatus.FAIL, "Alt+Up keyboard shortcut is not working fine from muted channels to open chats");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Alt+Up keyboard shortcut is not working fine from muted channels to open chats");
			sa.assertAll();
		 }
		 action.keyDown(Keys.ALT).sendKeys(Keys.UP).keyUp(Keys.ALT).perform();
		 WebElement activechat3 = driver.findElement(By.xpath("//div[contains(@class,'selected')]//div[contains(text(),'me')]"));
		 if(activechat3 != null){
			 log.info("Alt+Up keyboard shortcut is working fine from open chats to pinned chats");
			 test.log(LogStatus.PASS, "Alt+Up keyboard shortcut is working fine from open chats to pinned chats");
		 }else{
			log.error("Alt+Up keyboard shortcut is not working fine from open chats to pinned chats");
			test.log(LogStatus.FAIL, "Ctrl+f keyboard shortcut is not working fine from open chats to pinned chats");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Ctrl+k keyboard shortcut is not working fine from open chats to pinned chats");
			sa.assertAll();
		 }
	}
	
	@Test (priority = 4)
	  public void ctrlPlusD() throws Exception {
		Actions action = new Actions(driver);
		
		if(ce1.directoryActiveDisplayed()){
			action.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).perform();
			log.info("Entered Alt+D");
			ctrlPlusDcase();		
		}else{
			action.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).perform();
			log.info("Entered Alt+D");
			action.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).perform();
			log.info("Entered Alt+D");
			ctrlPlusDcase();
		}
	}
		
	
	public void ctrlPlusDcase(){
		Actions action = new Actions(driver);
		List<WebElement> appSidebarActive = driver.findElements(By.xpath("//div[contains(@class,'app-item--on')]"));
		int size = appSidebarActive.size();
		log.info(size);
		if(size > 0 ){
			log.error("Alt+D keyboard shortcut is not working fine");
			test.log(LogStatus.FAIL, "Ctrl+D keyboard shortcut is not working fine");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Ctrl+D keyboard shortcut is not working fine");
			sa.assertAll();
		}else{
			log.info("Alt+D keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Alt+D keyboard shortcut is working fine");
			action.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).perform();
			log.info("Entered Alt+D");
			if(ce1.directoryActiveDisplayed()){
				log.info("Alt+D keyboard shortcut is working fine");
				test.log(LogStatus.PASS, "Alt+D keyboard shortcut is working fine");
			}else{
				log.error("Alt+D keyboard shortcut is not working fine");
				test.log(LogStatus.FAIL, "Ctrl+D keyboard shortcut is not working fine");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Ctrl+D keyboard shortcut is not working fine");
				sa.assertAll();
			}
		}	
	}
	
	@Test(priority = 5)
	public void ctrlPlusDot() throws Exception{
		Actions action = new Actions(driver);
		//ce.dismissCalendarPrompt();
		if(ce1.directoryActiveDisplayed()){
			action.keyDown(Keys.CONTROL).sendKeys(".").keyUp(Keys.CONTROL).perform();
			List<WebElement> appSidebarActive = driver.findElements(By.xpath("//div[contains(@class,'app-item--on')]"));
			int size = appSidebarActive.size();
			log.info(size);
			if(size == 0 ){
				log.info("Ctrl+. keyboard shortcut is working fine");
				test.log(LogStatus.PASS, "Ctrl+. keyboard shortcut is working fine");
			}else{
				log.error("Ctrl+. keyboard shortcut is not working fine");
				test.log(LogStatus.FAIL, "Ctrl+. keyboard shortcut is not working fine");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Ctrl+. keyboard shortcut is not working fine");
				sa.assertAll();
			}
		}else{
			action.keyDown(Keys.CONTROL).sendKeys(".").keyUp(Keys.CONTROL).perform();
			List<WebElement> appSidebarActive = driver.findElements(By.xpath("//div[contains(@class,'app-item--on')]"));
			int size = appSidebarActive.size();
			log.info(size);
			if(size > 0) {
				log.info("Ctrl+. keyboard shortcut is working fine");
				test.log(LogStatus.PASS, "Ctrl+. keyboard shortcut is working fine");
			}else{
				log.error("Ctrl+. keyboard shortcut is not working fine");
				test.log(LogStatus.FAIL, "Ctrl+. keyboard shortcut is not working fine");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Ctrl+. keyboard shortcut is not working fine");
				sa.assertAll();
			}
		}
	}
	
	@Test(priority = 3)
	public void ctrlPlusE() throws Exception{
		Actions action = new Actions(driver);
		driver.switchTo().frame(ce1.appIframe);
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		action.keyDown(Keys.CONTROL).sendKeys("E").keyUp(Keys.CONTROL).perform();
		log.info("Entered ctrl+E on keyboard");
		ce1.textEditor.sendKeys(generatedString);
		ce1.textEditor.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		WebElement message= driver.findElement(By.xpath("//span[@class='text' and contains(text(),'" + generatedString + "')]"));
		if(message.isDisplayed()){
			log.info("Ctrl+E keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Ctrl+E keyboard shortcut is working fine");
		}
	}
	
	@Test(priority = 6)
	public void  esc() throws Exception{
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		gm.click(By.xpath("//div[@data-id='session_uv67v8exsum7emm6@go.to/fe695bdaf9eb4a8a86a6312804767766@groups.go.to']"), 10);
		//WebElement group = driver.findElement(By.xpath("//div[contains(@class,'conversation group')]//div[contains(text(),'Slash')]"));
		//ce1.slashCommandGroupActiveChat.click();
		action.sendKeys(Keys.ESCAPE).build().perform();
		if(ce1.slashCommandGroupActiveChatDisplayed()){
			log.info("Esc keyboard shortcut is working fine");
			test.log(LogStatus.PASS, "Esc keyboard shortcut is working fine");
			Thread.sleep(1000);
			action.keyDown(Keys.SHIFT).sendKeys(Keys.ESCAPE).keyUp(Keys.SHIFT).perform();
			if(ce1.slashCommandGroupActiveChatDisplayed()){
				log.error("Shift+Esc keyboard shortcut is not working fine");
				test.log(LogStatus.FAIL, "Shift+Esc keyboard shortcut is not working fine");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "Shift+Esc keyboard shortcut is not working fine");
				sa.assertAll();
			}else{
				log.info("Shift+Esc keyboard shortcut is working fine");
				test.log(LogStatus.PASS, "Shift+Esc keyboard shortcut is working fine");
			}
		}else{
			log.error("Esc keyboard shortcut is not working fine");
			test.log(LogStatus.FAIL, "Esc keyboard shortcut is not working fine");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "Esc keyboard shortcut is not working fine");
			sa.assertAll();
		}	
	}
	
 }

