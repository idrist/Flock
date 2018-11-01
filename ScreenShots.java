package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
	
	public void takeScreenShot(WebDriver driver) throws IOException {
	       String fileName = getRandomString(10) + ".png";
	       String directory = "C:\\Users\\farzan.s.DIRECTI\\Desktop\\LetsKodeIt\\";
	        
	        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(sourceFile, new File(directory+fileName));
	        //FileUtils.copyFile(sourceFile, new File(C:\\Users\\farzan.s.DIRECTI\\Desktop\\LetsKodeIt\jfjfnfh.png));   
	    }
}
