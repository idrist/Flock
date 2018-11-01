package com.Flock.HydraAutomation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class roster extends BaseTestSuite {
	/*
	 * Created on 11th Jan 2018 By Farzan Shaikh By Farzan Shaikh
	 */

	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());
	
	

	@Test(priority=0)
	public void roasterOpen() throws Exception {
		if(ce.globalAppSidebarDisplayed()){
			if(ce.rosterSideBarDisplayed()){
				
				boolean result = driver.findElement(By.xpath("//div[contains(@class,'app-item--on')]")) != null;
				Assert.assertTrue(result);
				test.log(LogStatus.PASS, "roasterOpen Test Passed");
				log.info("roasterOpen Test Passed");
			}else{
				log.error("roasterOpen Test FAILED");
				test.log(LogStatus.FAIL, "roasterOpen Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The roster icon in the side bar  is not displayed");
				sa.assertAll();
			}
		}else{
			log.error("roasterOpen Test FAILED");
			test.log(LogStatus.FAIL, "roasterOpen Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The App side bar  is not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority=1)
	public void rosterContent() throws InterruptedException{
		if(ce.rosterSideBarDisplayed()){
			Thread.sleep(2000);
			rosterTabContent();
			test.log(LogStatus.PASS, "rosterContent Test Passed");
			log.info("rosterContent Test Passed");
		}else{
			log.error("rosterContent Test FAILED");
			test.log(LogStatus.FAIL, "rosterContent Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar  is not displayed");
			sa.assertAll();
		}
	}
	
	public void rosterTabContent(){
		if(gm.elementDisplayed(By.className("roster"), "Roster is displayed")){
		gm.elementDisplayed(By.xpath("//div[@class='app-container__title']"), "Roster heading");
		gm.getInnerText(By.xpath("//div[@class='app-container__title']"));
		gm.compareText(By.xpath("//div[@class='app-container__title']"), "Channels & Contacts");
		
		gm.elementDisplayed(By.className("app-container__close"), "Close button in the roster");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'openRecent')]/span[@class='roster-image']"), "Recent Tab icon in the roster header");
		gm.elementDisplayed(By.xpath("//div[contains(@class,'openGroups')]/span[@class='roster-image']"), "Channel Tab icon in the roster header");
		gm.elementDisplayed(By.xpath("//div[contains(@class,'openContacts')]/span[@class='roster-image']"), "Contacts icon in tthe roster header");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='joinChannel']"), "Recent Channels Header");
		gm.getInnerText(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='joinChannel']"));
		gm.compareText(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='joinChannel']"), "RECENT CHANNELS");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='newChannel']"), "New Channel hook in the Recent Channels Header");
		gm.getInnerText(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='newChannel']"));
		gm.compareText(By.xpath("//div[contains(@class,'group-contacts')]//div[@id='newChannel']"), "New Channel");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'join__channels')]"), "Join channel icon in the Recent Channels Header");
		
		gm.elementDisplayed(By.className("roster__actions__text"), "Join Channel hook in the Recent Channels Header");
		gm.getInnerText(By.className("roster__actions__text"));
		gm.compareText(By.className("roster__actions__text"), "Join Channels");
		
		gm.elementDisplayed(By.xpath("//img[@src='https://g.flockusercontent.com/channel-type-project.png']"), "Roster Channel Avatar");
		gm.elementDisplayed(By.xpath("//span[@title='Slash Command Test Channel']"), "Roster Channel Name");
		gm.getInnerText(By.xpath("//span[@title='Slash Command Test Channel']"));
		gm.compareText(By.xpath("//span[@title='Slash Command Test Channel']"), "Slash Command Test Channel");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"))).click().build().perform();
		
		gm.elementDisplayed(By.xpath("//img[contains(@class,'profile-item-image--visible')]"), "Channel Avataar in the channel card");
		gm.elementDisplayed(By.xpath("//div[@class='info_area']/div[@class='name']"), "Channel name in the channel card in dropdown");
		
		gm.getInnerText(By.xpath("//div[@class='info_area']/div[@class='name']"));
		gm.compareText(By.xpath("//div[@class='info_area']/div[@class='name']"), "Slash Command Test Channel");
		
		/*gm.elementDisplayed(By.xpath("//span[@data-dojo-attach-point='_memberCount']"), "Member count in the channel card in dropdown");
		gm.getInnerText(By.xpath("//span[@data-dojo-attach-point='_memberCount']"));
		gm.compareText(By.xpath("//span[@data-dojo-attach-point='_memberCount']"), "2 Member");*/
		
		/*gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_2_text"), "Mute Channel Hook in the channel card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_2_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_2_text"), "Mute Channel");*/
		
		/*gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_1_text"), "Leave Channel Hook in the channel card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_1_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_1_text"), "Leave Channel");*/
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='joinChannel']"), "Recent Direct Messages Header");
		gm.getInnerText(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='joinChannel']"));
		gm.compareText(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='joinChannel']"), "RECENT DIRECT MESSAGES");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='newChannel']"), "Invite Contact hook in the Recent Direct Messa Header");
		gm.getInnerText(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='newChannel']"));
		gm.compareText(By.xpath("//div[contains(@class,'dm-contacts')]//div[@id='newChannel']"), "Invite Contacts");
		
		
		Actions action1 = new Actions(driver);
		WebElement w = driver.findElement(By.xpath("//div[contains(@data-sortkey,'akshay abrol')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'akshay abrol')]//span[contains(@class,'contextMenuTarget')]"), "Dropdown arrow next to the contact name");
		action1.moveToElement(w).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'akshay abrol')]//span[contains(@class,'contextMenuTarget')]"))).click().build().perform();
		
		gm.elementDisplayed(By.xpath("//div[@id='widgets_ProfilePicWithPresence_0']/img"), "Profile Avataar in the contact card");
		gm.elementDisplayed(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@class='name']"), "Contact name in the contact card in dropdown");
		gm.getInnerText(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@class='name']"));
		gm.compareText(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@class='name']"), "Akshay Abrol");
		
		gm.elementDisplayed(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@data-dojo-attach-point='_email']"), "Contact emails in the contact card in dropdown");
		gm.getInnerText(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@data-dojo-attach-point='_email']"));
		gm.compareText(By.xpath("//div[@id='widgets_menuitems_ProfileItem_0_text']//div[@data-dojo-attach-point='_email']"), "akshaya@flock.com");
		
		gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_4_text"), "Send Message Hook in the contact card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_4_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_4_text"), "Send Message");
		
		}else{
			log.error("roasterOpen Test FAILED");
			test.log(LogStatus.FAIL, "roasterOpen Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster is not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority=2)
	public void rosterHooksClick() throws InterruptedException{
		if(ce.rosterSideBarDisplayed()){
			Thread.sleep(2000);
			rosterHooks();
			
			log.info("rosterHooksClick Test Passed");
			test.log(LogStatus.PASS, "rosterHooksClick Test Passed");
		}else{
			log.error("roasrosterHooksClick terOpen Test FAILED");
			test.log(LogStatus.FAIL, "rosterHooksClick Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void rosterHooks() throws InterruptedException{
		if(ce.newChannelHookRosterDisplayed()){
			ce.newChannelHookRosterClick();
			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");
			
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickStartChannelModalClose();
			
			log.info("newChannelHookRoster Test Passed");
			test.log(LogStatus.PASS, "newChannelHookRoster Test Passed");
		}else{
			log.error("newChannelHookRoster Test FAILED");
			test.log(LogStatus.FAIL, "newChannelHookRoster Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The new channel hook in the roster not displayed");
			sa.assertAll();
		}
		
		if(ce.joinChannelHookRosterDisplayed()){
			ce.joinChannelHookRosterClick();
			
			boolean result = driver.findElement(By.className("group-discovery-list")) != null;
			Assert.assertTrue(result);
			
			ce.cancelHookDiscoverChannelClick();
		}else{
			log.error("joinChannelHookRoster Test FAILED");
			test.log(LogStatus.FAIL, "joinChannelHookRoster Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The discover channel hook in the roster not displayed");
			sa.assertAll();
		}
		
		if(ce.inviteRecentDisplayed()){
			Thread.sleep(2000);
			ce.clickInviteRecent();
			gm.switchToiFrame("invite-contact");
			log.debug("Inside the iframe invite-contact");
			
			boolean result = driver.findElement(By.id("invite-heading")) != null;
			Assert.assertTrue(result);
			ce.clickInviteContactCancel();
		}else{
			log.error("inviteRecent Test FAILED");
			test.log(LogStatus.FAIL, "inviteRecent Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The Invite Contact hook in the roster not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority=3)
	public void channelTab() throws InterruptedException{
		if(ce.channelTabDisplayed()){
			ce.channelTabClick();
			Thread.sleep(2000);
		
			channelTabContent();
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
		}else{
			log.error("channelTab Test FAILED");
			test.log(LogStatus.FAIL, "channelTab Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void channelTabContent(){
		gm.elementDisplayed(By.className("rosterSearch__input"), "Channel Search Field");
		gm.getInnerText(By.className("rosterSearch__input"));
		gm.compareText(By.className("rosterSearch__input"), "Search for Channels");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'roster__create__group')]"), "Create channel hook next to the search field");
		
		gm.elementDisplayed(By.xpath("//img[@src='https://g.flockusercontent.com/channel-type-project.png']"), "Roster Channel Avatar");
		gm.elementDisplayed(By.xpath("//span[@title='Slash Command Test Channel']"), "Roster Channel Name");
		gm.getInnerText(By.xpath("//span[@title='Slash Command Test Channel']"));
		gm.compareText(By.xpath("//span[@title='Slash Command Test Channel']"), "Slash Command Test Channel");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"))).click().build().perform();
		
		gm.elementDisplayed(By.xpath("//img[contains(@class,'image') and contains(@class,'profile-item-image--visible')]"), "Channel Avataar in the channel card");
		gm.elementDisplayed(By.xpath("//div[@class='info_area']/div[@class='name']"), "Channel name in the channel card in dropdown");
		
		gm.getInnerText(By.xpath("//div[@class='info_area']/div[@class='name']"));
		gm.compareText(By.xpath("//div[@class='info_area']/div[@class='name']"), "Slash Command Test Channel");
		
		gm.elementDisplayed(By.xpath("//span[@data-dojo-attach-point='_memberCount']"), "Member count in the channel card in dropdown");
		gm.getInnerText(By.xpath("//span[@data-dojo-attach-point='_memberCount']"));
		gm.compareText(By.xpath("//span[@data-dojo-attach-point='_memberCount']"), "1 Member");
		
		gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_2_text"), "Mute Channel Hook in the channel card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_2_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_2_text"), "Mute Channel");
		
		gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_1_text"), "Leave Channel Hook in the channel card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_1_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_1_text"), "Leave Channel");
		
		/*if(gm.elementDisplayed(By.xpath("//div[contains(@class,'groups-all-empty')]"), "Empty State")){
			gm.elementDisplayed(By.className("emptyImage"), "Smiley icon in the channel empty state blurb");
			gm.elementDisplayed(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"), "Info text in the channel empty state blurb");
			gm.getInnerText(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"));
			gm.compareText(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"), "Channels are where the magic happens in Flock! Create one for every project.");
			gm.elementDisplayed(By.xpath("//a[contains(@class,'btn--action')]"), "Create Channel button in channel empty state blurb");
			gm.getInnerText(By.xpath("//a[contains(@class,'btn--action')]"));
			gm.compareText(By.xpath("//a[contains(@class,'btn--action')]"), "Create Channels");
	
		}else{
			log.info("The empty state for the channel is not displayed");
		}*/
	}
	
	@Test(priority=3)
	public void channelTabHook() throws InterruptedException{
		ce.dismissCalendarPrompt();
		if(ce.channelTabDisplayed()){
		
			channelTabHookClick();
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
		}else{
			log.error("channelTabHook Test FAILED");
			test.log(LogStatus.FAIL, "channelTabHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void channelTabHookClick() throws InterruptedException{
		if(ce.createChannelPlusIconDisplayed()){
			
			ce.createChannelPlusIconClick();
			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");
			
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickStartChannelModalClose();
			
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
		}else{
			log.error("channelTabHook Test FAILED");
			test.log(LogStatus.FAIL, "channelTabHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
		
		if(ce.emptyStateChannelTabDisplayed()){
			ce.createChannelEmptyStateClick();
			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");
			
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickStartChannelModalClose();
			
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
		}else{
			log.error("channelTab Test FAILED");
			test.log(LogStatus.FAIL, "channelTab Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority=4)
	public void muteChannelTab(){
		if(ce.channelTabDisplayed()){
			muteChannel();
			boolean result = driver.findElement(By.xpath("//div[contains(@data-sortkey,'farzan testaccount')]/div[2]")) != null ;
			Assert.assertTrue(result);
			
			log.info("muteChannelTab Test Passed");
			test.log(LogStatus.PASS, "muteChannelTab Test Passed");
		}else{
			log.error("muteChannelTab Test FAILED");
			test.log(LogStatus.FAIL, "muteChannelTab Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The channel tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void muteChannel(){
		gm.elementDisplayed(By.xpath("//span[@title='Slash Command Test Channel']"), "Roster Channel Name");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"))).click().build().perform();
		
		gm.click(By.id("widgets_menuitems_MenuItem_2_text"), 0);
		
	}
	
	@Test(priority=5)
	public void leaveChannelTab(){
		if(ce.channelTabDisplayed()){
			leaveChannel();
			boolean result = driver.findElement(By.xpath("//div[contains(@data-sortkey,'farzan testaccount')]/div[2]")) != null ;
			Assert.assertTrue(result);
			
			log.info("leaveChannelTab Test Passed");
			test.log(LogStatus.PASS, "leaveChannelTab Test Passed");
		}else{
			log.error("leaveChannelTab Test FAILED");
			test.log(LogStatus.FAIL, "leaveChannelTab Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The channel tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void leaveChannel(){
		ce.channelTabSearchFieldClick();
		
		gm.elementDisplayed(By.xpath("//span[@title='Slash Command Test Channel']"), "Roster Channel Name");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"))).click().build().perform();
		
		/*gm.click(By.xpath("//div[contains(@data-sortkey,'slash command test channel')]/span"), 2);*/
		
		gm.click(By.id("widgets_menuitems_MenuItem_1_text"), 0);
		if(gm.elementDisplayed(By.xpath("//div[@class='title']"), "Header of leave channel modal")){
			
		gm.elementDisplayed(By.xpath("//div[@class='title']"), "Leave Channel Header");
		gm.getInnerText(By.xpath("//div[@class='title']"));
		gm.compareText(By.xpath("//div[@class='title']"), "Leave Channel?");
		
		gm.elementDisplayed(By.xpath("//div[@class='sub-title']"), "Leave Channel Sub-Header");
		gm.getInnerText(By.xpath("//div[@class='sub-title']"));
		gm.compareText(By.xpath("//div[@class='sub-title']"), "This channel will be deleted since you are the last member. Are you sure?");
		
		gm.elementDisplayed(By.xpath("//button[contains(@class,'btn--cancel')]"), "Cancel Button");
		gm.getInnerText(By.xpath("//button[contains(@class,'btn--cancel')]"));
		gm.compareText(By.xpath("//button[contains(@class,'btn--cancel')]"), "Cancel");
		
		gm.elementDisplayed(By.xpath("//button[contains(@class,'btn--action')]"), " Leave Channel Button");
		gm.getInnerText(By.xpath("//button[contains(@class,'btn--action')]"));
		gm.compareText(By.xpath("//button[contains(@class,'btn--action')]"), "Yes, Leave and Delete");
		
		gm.click(By.xpath("//button[contains(@class,'btn--cancel')]"), 0);
		
			
		}else{
			log.error("leaveChannel Test FAILED");
			test.log(LogStatus.FAIL, "leaveChannel Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The leave channel modal is not displayed");
			sa.assertAll();
		}
		
	}
	
	@Test(priority=6)
	public void channelSearch() throws InterruptedException{
		if(ce.channelTabDisplayed()){
			search();
			boolean result = driver.findElement(By.xpath("//div[contains(@class,'group') and contains(@class,'selected')]")) != null;
			Assert.assertTrue(result);
			
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
			ce.channelTabSearchFieldClick();
			
		}else{
			log.error("channelTabHook Test FAILED");
			test.log(LogStatus.FAIL, "channelTabHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void search() throws InterruptedException{
		if(ce.channelTabSearchFieldDisplayed()){
			ce.channelTabSearchFieldClick();
			ce.channelTabSearchFieldSendKey("farzan testaccount");
			if(gm.elementDisplayed(By.xpath("//img[@src='https://g.flockusercontent-staging.com/5c1dc7c1518765750552508a']"), "farzan testaccount channel is displayed")){
				gm.click(By.xpath("//img[@src='https://g.flockusercontent-staging.com/5c1dc7c1518765750552508a']"), 2);
				Thread.sleep(2000);
				gm.elementDisplayed(By.xpath("//div[contains(@data-id,'session_uv67v8exsum7emm6@go.to/c09a4b0103d84af98bc2466eade97e1a@groups.go.to')]"), "farzan testaccount opened in the active chat are");
				
			}else{
				log.error("channelSearch Test FAILED");
				test.log(LogStatus.FAIL, "channelSearch Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The tester's channel is not displayed in the search results");
				sa.assertAll();
			}
		}else{
			log.error("channelSearch Test FAILED");
			test.log(LogStatus.FAIL, "channelSearch Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The search field in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	@Test(priority=6)
	public void channelSearchNoResults() throws InterruptedException{
		if(ce.channelTabDisplayed()){
			searchNoResults();
			boolean result = driver.findElement(By.className("noResult")) != null;
			Assert.assertTrue(result);
			
			log.info("channelSearchNoResults Test Passed");
			test.log(LogStatus.PASS, "channelSearchNoResults Test Passed");
			
		}else{
			log.error("channelSearchNoResults Test FAILED");
			test.log(LogStatus.FAIL, "channelSearchNoResults Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void searchNoResults() throws InterruptedException{
		if(ce.channelTabSearchFieldDisplayed()){
			ce.channelTabSearchFieldClick();
			ce.channelTabSearchFieldSendKey("farzan testaccountddddddd");
			if(gm.elementDisplayed(By.className("noResult"), "No channel is displayed")){
				gm.elementDisplayed(By.className("noResult"), "No results found text");
				gm.getInnerText(By.className("noResult"));
				gm.compareText(By.className("noResult"), "No results found");
				

				if(gm.elementDisplayed(By.xpath("//div[contains(@class,'groups-all-empty')]"), "Empty State")){
					gm.elementDisplayed(By.className("emptyImage"), "Smiley icon in the channel empty state blurb");
					gm.elementDisplayed(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"), "Info text in the channel empty state blurb");
					gm.getInnerText(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"));
					gm.compareText(By.xpath("//p[@data-dojo-attach-point='blankTextNode']"), "Channels are where the magic happens in Flock! Create one for every project.");
					gm.elementDisplayed(By.xpath("//a[contains(@class,'btn--action')]"), "Create Channel button in channel empty state blurb");
					gm.getInnerText(By.xpath("//a[contains(@class,'btn--action')]"));
					gm.compareText(By.xpath("//a[contains(@class,'btn--action')]"), "Create Channels");
			
				}else{
					log.info("The empty state for the channel is not displayed");
				}
			}else{
				log.error("searchNoResults Test FAILED");
				test.log(LogStatus.FAIL, "searchNoResults Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The tester's channel is not displayed in the search results");
				sa.assertAll();
			}
		}else{
			log.error("searchNoResults Test FAILED");
			test.log(LogStatus.FAIL, "searchNoResults Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The search field in the channel tab is not displayed");
			sa.assertAll();
		}
	}

	
	@Test(priority=7)
	public void contactTab() throws InterruptedException{
		if(ce.contactTabDisplayed()){
			ce.contactTabClick();
			Thread.sleep(2000);
		
			contactTabContent();
			log.info("contactTab Test Passed");
			test.log(LogStatus.PASS, "contactTab Test Passed");
		}else{
			log.error("contactTab Test FAILED");
			test.log(LogStatus.FAIL, "contactTab Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The roster icon in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void contactTabContent(){
		gm.elementDisplayed(By.className("rosterSearch__input"), "Contact Search Field");
		gm.getInnerText(By.className("rosterSearch__input"));
		gm.compareText(By.className("rosterSearch__input"), "Search for Contacts");
		
		gm.elementDisplayed(By.xpath("//div[contains(@class,'roster__invite__contact')]"), "Create channel hook next to the search field");
		
		gm.elementDisplayed(By.xpath("//img[@src='https://i.flockusercontent-staging.com/e7140a71507109285134d455']"), "Contact Avatar");
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'1 2')]//span[@class='dijitTreeLabel']"), "Contact Name");
		gm.getInnerText(By.xpath("//div[contains(@data-sortkey,'1 2')]//span[@class='dijitTreeLabel']"));
		gm.compareText(By.xpath("//div[contains(@data-sortkey,'1 2')]//span[@class='dijitTreeLabel']"), "1 2");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'1 2')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'1 2')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'1 2')]/span"))).click().build().perform();
		
		gm.elementDisplayed(By.xpath("//div[@id='widgets_ProfilePicWithPresence_0']/img"), "Contact Avataar in the contact card");
		gm.elementDisplayed(By.xpath("//div[@class='info_area']/div[@class='name']"), "Contact name in the contact card in dropdown");
		
		gm.getInnerText(By.xpath("//div[@class='info_area']/div[@class='name']"));
		gm.compareText(By.xpath("//div[@class='info_area']/div[@class='name']"), "1 2");
		
		gm.elementDisplayed(By.xpath("//div[@data-dojo-attach-point='_email']"), "Email in the contact card in dropdown");
		gm.getInnerText(By.xpath("//div[@data-dojo-attach-point='_email']"));
		gm.compareText(By.xpath("//div[@data-dojo-attach-point='_email']"), "prashant.p+8@flock.com");
		
		gm.elementDisplayed(By.id("widgets_menuitems_MenuItem_4_text"), "Send Message Hook in the contact card in dropdown");
		gm.getInnerText(By.id("widgets_menuitems_MenuItem_4_text"));
		gm.compareText(By.id("widgets_menuitems_MenuItem_4_text"), "Send Message");
		
		/*if(gm.elementDisplayed(By.xpath("//div[contains(@class,'contacts-all-empty')]"), "Empty State")){
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
			gm.compareText(By.xpath("//span[@class='contacts-team-url-query']"), "?i=uv67v8exsum7emm6");
	
		}else{
			log.info("The empty state for the contact is not displayed");
		}*/
	}

	@Test(priority=8)
	public void contactTabHook() throws InterruptedException{
		if(ce.contactTabDisplayed()){
		
			contactTabHookClick();
			log.info("contactTabHook Test Passed");
			test.log(LogStatus.PASS, "contactTabHook Test Passed");
		}else{
			log.error("contactTabHook Test FAILED");
			test.log(LogStatus.FAIL, "contactTabHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void contactTabHookClick() throws InterruptedException{
		if(ce.contactTabInviteContactIconDisplayed()){
			
			ce.contactTabInviteContactIconClick();
			Thread.sleep(3000);
			gm.switchToiFrame("invite-contact");
			log.debug("Inside the iframe invite-contact");
			
			boolean result = driver.findElement(By.id("invite-heading")) != null;
			Assert.assertTrue(result);
			
			ce.clickInviteContactCancel();
			
			log.info("channelTab Test Passed");
			test.log(LogStatus.PASS, "channelTab Test Passed");
		}else{
			log.error("contactTabHookClick Test FAILED");
			test.log(LogStatus.FAIL, "contactTab Hook Click Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab invite contact icon is not displayed");
			sa.assertAll();
		}
		
	}

	@Test(priority=9)
	public void contactTabOpenContact() throws InterruptedException{
		if(ce.contactTabDisplayed()){
		
			openContactChat();
			Thread.sleep(2000);
			boolean result = driver.findElement(By.xpath("//div[contains(@class,'buddy') and contains(@class,'selected')]")) != null;
			Assert.assertTrue(result);
			
			log.info("contactTabHook Test Passed");
			test.log(LogStatus.PASS, "contactTabHook Test Passed");
		}else{
			log.error("contactTabHook Test FAILED");
			test.log(LogStatus.FAIL, "contactTabHook Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void openContactChat(){
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'1 2')]//span[@class='dijitTreeLabel']"), "Contact Name");
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[contains(@data-sortkey,'1 2')]"));
		gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'1 2')]/span"), "Dropdown arrow next to the channel name");
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//div[contains(@data-sortkey,'1 2')]/span"))).click().build().perform();
		
		gm.click(By.id("widgets_menuitems_MenuItem_4_text"), 0);
	}
	
	@Test(priority=10)
	public void contactSearch() throws InterruptedException{
		if(ce.contactTabDisplayed()){
		
			searchBuddy();
			Thread.sleep(2000);
			boolean result = driver.findElement(By.xpath("//div[contains(@class,'buddy') and contains(@class,'selected')]")) != null;
			Assert.assertTrue(result);
			
			log.info("contactSearch Test Passed");
			test.log(LogStatus.PASS, "contactSearch Test Passed");
		}else{
			log.error("contactSearch Test FAILED");
			test.log(LogStatus.FAIL, "contactSearch Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void searchBuddy() throws InterruptedException{
		if(ce.contactTabSearchFieldDisplayed()){
			ce.contactTabSearchFieldClick();
			ce.contactTabSearchFieldSendKey("Anikait Shivam");
			if(gm.elementDisplayed(By.xpath("//div[contains(@data-sortkey,'anikait shivam')]"), "1 2 contact is displayed")){
				gm.click(By.xpath("//div[contains(@data-sortkey,'anikait shivam')]"), 2);
				Thread.sleep(2000);
				gm.elementDisplayed(By.xpath("//div[contains(@class,'buddy') and contains(@class,'selected')]"), "Buddy conversation opened in the active chat are");
				
			}else{
				log.error("searchBuddy Test FAILED");
				test.log(LogStatus.FAIL, "searchBuddy Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The contact is not displayed in the search results");
				sa.assertAll();
			}
		}else{
			log.error("searchBuddy Test FAILED");
			test.log(LogStatus.FAIL, "searchBuddy Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The search field in the channel tab is not displayed");
			sa.assertAll();
		}
	}
	
	@Test(priority=11)
	public void contactSearchNoMatch() throws InterruptedException{
		if(ce.contactTabDisplayed()){
		
			searchBuddyNoMatch();
			Thread.sleep(2000);
			boolean result = driver.findElements(By.className("noResult")) != null;
			Assert.assertTrue(result);
			
			log.info("contactSearch Test Passed");
			test.log(LogStatus.PASS, "contactSearch Test Passed");
		}else{
			log.error("contactSearch Test FAILED");
			test.log(LogStatus.FAIL, "contactSearch Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The contact tab in the side bar is not displayed");
			sa.assertAll();
		}
	}
	
	public void searchBuddyNoMatch() throws InterruptedException{
		if(ce.contactTabSearchFieldDisplayed()){
			ce.contactTabSearchFieldClick();
			ce.contactTabSearchFieldSendKey("Anikait Shivam hdhhdhdh");
			if(gm.elementDisplayed(By.className("noResult"), "no result state is displayed")){
				
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
					gm.compareText(By.xpath("//div[contains(@class,'emptyContacts ')]//div[@class='empty-text']"), "Invite team members");
					
					gm.elementDisplayed(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"), "Invite Hook in empty state");
					gm.getInnerText(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"));
					gm.compareText(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"), "Invite team members");
					gm.click(By.xpath("//div[@class='empty-chat-links']//div[@data-dojo-attach-point='inviteLink']"), 0);
					
					gm.switchToiFrame("invite-contact");
					log.debug("Inside the iframe invite-contact");
					
					boolean result = driver.findElement(By.id("invite-heading")) != null;
					Assert.assertTrue(result);
					ce.clickInviteContactCancel();
				}
				
			}else{
				log.error("searchBuddyNoMatch Test FAILED");
				test.log(LogStatus.FAIL, "searchBuddyNoMatch Test FAILED");
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(false, "The contact is not displayed in the search results");
				sa.assertAll();
			}
		}else{
			log.error("searchBuddyNoMatch Test FAILED");
			test.log(LogStatus.FAIL, "searchBuddyNoMatch Test FAILED");
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(false, "The search field in the channel tab is not displayed");
			sa.assertAll();
		}
	}
}
