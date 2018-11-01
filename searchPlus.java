package com.Flock.HydraAutomation;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTestSuite;
import com.relevantcodes.extentreports.LogStatus;

public class searchPlus extends BaseTestSuite{
	
	/*
	Created on 9th August 2017
	By Farzan Shaikh
	*/
	
	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());

	@Test(priority=1)
	public void searchPlusChannelOption() throws Exception 
	{
		StopWatch watch = new StopWatch();
		
		if (ce.univerlSearchPlusIconPresent()) 
		{
			
			ce.clickUniverlSearchPlusIcon();

			searchPlusContentOption1();
			ce.clickSearchPlusCreateChannel();
			watch.start();
			
			gm.switchToiFrame("channel-create");
			log.debug("Inside the iframe channel-create");
			
			gm.waitForElement(By.xpath("//div[@class='channel-options__about']"), 5);
			double seconds =(double)watch.getTime()/1000.0;
			watch.reset();
			
			log.info("Time taken to fully load the channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the channel modal: " + seconds + " seconds");
			boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickStartChannelModalClose();
			
			test.log(LogStatus.PASS, "searchPlusChannelOption Test Passed");
		}
	}
	
	
	public void searchPlusContentOption1() throws Exception 
	{

		Thread.sleep(2000);
		
			if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_2", "id")) 
			{
				gm.elementDisplayed(By.xpath("//div[@class='plus-item__icon group']"),
						"Create-Channel-icon");
				gm.elementDisplayed(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
						"Create-Channel-label");
				gm.getInnerText(
						By.xpath("//*[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[2]"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
						"Create a new channel");
				gm.elementDisplayed(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
						"Create-Channel-sublabel");
				gm.getInnerText(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
				gm.compareText(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
						"For your projects or topics");
				test.log(LogStatus.INFO, "The create a channel option is present");
			} else {
				test.log(LogStatus.FAIL, "The create a channel option is not present");
			}		
	}
	
	
	@Test(priority=2)
	public void searchPlusJoinChannelOption() throws Exception 
	{
		StopWatch watch = new StopWatch();
		Thread.sleep(2000);
		
		if (ce.univerlSearchPlusIconPresent()) {
			
			ce.clickUniverlSearchPlusIcon();

			searchPlusContentOption2();	
			
			ce.clickSearchPlusJoinChannel();
			watch.start();
			gm.waitForElement(By.xpath("//div[contains(text(),'Public Channels')]"), 5);
			
			double seconds =(double)watch.getTime()/1000.0;
			watch.reset();
			log.info("Time taken to fully load the discover public channel modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the discover public channel modal: " + seconds + " seconds");
			
			boolean result = driver.findElement(By.xpath("//div[contains(text(),'Public Channels')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickJoinChannelModalClose();
			test.log(LogStatus.PASS, "searchPlusJoinChannelOption Test Passed");
		}
	}
	
	
	public void searchPlusContentOption2() throws Exception
	{
		if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_1", "id")) 
		{

			gm.elementDisplayed(By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[contains(@class,'plus-item__icon') and contains(@class,'join_channel')]"),

					"Join Channel Icon");
			gm.elementDisplayed(
					By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__label']"),
					"Join Channel Label");
			gm.getInnerText(
					By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__label']"));
			gm.compareText(By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__label']"),
					"Join Public Channels");
			gm.elementDisplayed(
					By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__sublabel']"),
					"Join Channel Sub label");
			gm.getInnerText(
					By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__sublabel']"));
			gm.compareText(
					By.xpath("//table[contains(@class,'plusOptions')]//tr[3]//div[@class='plus-item__sublabel']"),
					"Discover shared interests");
			test.log(LogStatus.INFO, "The join a channel option is present");
		} else {
			test.log(LogStatus.FAIL, "The join a channel option is not present");
		}
	}
	
	
	@Test(priority=3)
	public void searchPlusInviteOption() throws Exception {
		StopWatch watch = new StopWatch();
		Thread.sleep(2000);
		
		if (ce.univerlSearchPlusIconPresent())
		{

			ce.clickUniverlSearchPlusIcon();

			ce.clickSearchPlusInviteButton();
			watch.start();
			gm.switchToiFrame("invite-contact");

			searchPlusContentOption3();

			log.debug("Inside the iframe invite-fork");
			gm.waitForElement(By.id("invite-heading"), 5);

			double seconds = (double) watch.getTime() / 1000.0;
			watch.reset();
			log.info("Time taken to fully load the invite modal: " + seconds + " seconds");
			test.log(LogStatus.INFO, "Time taken to fully load the invite modal: " + seconds + " seconds");

			boolean result = driver.findElement(By.id("invite-heading")) != null;
			Assert.assertTrue(result);

			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "searchPlusInviteOption Test Passed");
		}
	}
	
	public void searchPlusContentOption3() throws Exception
	{
		if (gm.isElementPresent("invite-heading", "id")) 
		{
			gm.elementDisplayed(By.id("invite-heading"), "Invite Heading on the fork page");
			gm.getInnerText(By.id("invite-heading"));
			gm.compareText(By.id("invite-heading"), "Invite people to riva");
			
			gm.elementDisplayed(By.xpath("//div[@id='invite-type-screen']/label"), "Invite Sub Heading on the fork page");
			gm.getInnerText(By.xpath("//div[@id='invite-type-screen']/label"));
			gm.compareText(By.xpath("//div[@id='invite-type-screen']/label"), "Whom would you like to invite?");
			
			gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-image') and contains(@class,'invite-guests')]"), "Guest Invite Icon");
			
			gm.elementDisplayed(By.xpath("//div[@id='team-members']//div[@class='title']"), "Full Members heading on the fork page");
			gm.getInnerText(By.xpath("//div[@id='team-members']//div[@class='title']"));
			gm.compareText(By.xpath("//div[@id='team-members']//div[@class='title']"), "Full Members");
			
					
			gm.elementDisplayed(By.xpath("//div[@id='team-members']//div[@class='sub-title']"), "Full Members description on the fork page");
			gm.getInnerText(By.xpath("//div[@id='team-members']//div[@class='sub-title']"));
			gm.compareText(By.xpath("//div[@id='team-members']//div[@class='sub-title']"), "Use this for Employees who belong to your organization. They will get access to all other employees and all public channels");
			
			gm.elementDisplayed(By.xpath("//div[contains(@class,'invite-image') and contains(@class,'invite-guests')]"), "Guest Invite Icon");
			
			gm.elementDisplayed(By.xpath("//div[@id='guest-members']//div[@class='title']"), "Guest Members heading on the fork page");
			gm.getInnerText(By.xpath("//div[@id='guest-members']//div[@class='title']"));
			gm.compareText(By.xpath("//div[@id='guest-members']//div[@class='title']"), "Guests");
			
			gm.elementDisplayed(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"), "Guest Members description on the fork page");
			gm.getInnerText(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"));
			gm.compareText(By.xpath("//div[@id='guest-members']//div[@class='sub-title']"), "Use this for external clients, vendors, candidates. They will only be able to chat with restricted people and in restricted channels");
			test.log(LogStatus.INFO, "The invite option is present");
		} else 
		{
			test.log(LogStatus.FAIL, "The invite option is not present");
		}
	}

}


