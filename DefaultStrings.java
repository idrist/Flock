package com.flock.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class DefaultStrings {
	public static String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	public static String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";

	public static String CHROME_DRIVER_PATH = "C:\\Automation\\chromedriver_win32\\chromedriver.exe";
	public static String FIREFOX_DRIVER_PATH = "C:\\Automation\\geckodriver-v0.16.0-win64\\geckodriver.exe";
	public static final String LATEST_FLOCK_LINK = "http://bingo.flock.co/streams.php/";
	
	public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";

	public static final String FLOCK_WEB_PREPROD = "https://web.flock.com/?s=qa&config=preprod";
	public static final String FLOCK_WEB_PROD = "https://web.flock.com/?s=qa&config=prod";
	
	public static final String DIRECTI_TESTER_002_Email = "flockdesktop1@flock.com";
	public static final String OTP = "243156";
	
	public static final String DESKTOP_TESTER_001_Email ="flockdesktop1@flock.com";
	public static final String DESKTOP_TESTER_002_Email ="flockdesktop2@flock.com";
	public static final String DESKTOP_TESTER_003_Email ="flockdesktop3@flock.com";
	public static final String DESKTOP_OTP = "243156";
	
	public static final String DESKTOP_TESTER_001_MagicLink ="&email=flockdesktop1@flock.com";
	public static final String DESKTOP_TESTER_002_MagicLink ="&email=flockdesktop2@flock.com";
	public static final String DESKTOP_TESTER_003_MagicLink ="&email=flockdesktop3@flock.com";
	public static final String DESKTOP_TESTER_004_MagicLink ="&email=flockdesktop2+3@flock.com";
	
	public static final String DESKTOP_PASSWORD="Qwedsa1234";
	
	public static String log4jConfPath = "C:\\Repos\\horus\\HydraAutomation\\src\\test\\java\\resources\\Log4j2.xml";

	public static final String FARZAN_TEST = "fuzz.shaikh@gmail.com";
	public static final String IDRIS_TEST = "idristinwala53@gmail.com";
	
	public static final String EMAIL_LHS = RandomStringUtils.randomAlphabetic(5);
	public static final String EMAIL_PUBLIC_NONGOC = EMAIL_LHS+"@mailinator.com";
	public static final String EMAIL_PUBLIC_DISCOVER = EMAIL_LHS+"@cmail.club";
	public static final String EMAIL_PUBLIC_GOC = "flockdesktopqa@gmail.com";
	public static final String EMAIL_PAID_NOAUTOJOIN = EMAIL_LHS+"@farzanshaikh.com";
	public static final String EMAIL_PAID_AUTOJOIN = EMAIL_LHS+"@flock.com";
	public static final String EMAIL_PAID_TEAMCREATE = EMAIL_LHS+"@"+EMAIL_LHS+".com";
	public static final String EMAIl_PAID_GOC = "qatest@directi.com";
	public static final String EMAIl_PAID_AUTOJOIN_GOC = "qatest@flock.com";
	
	public static final String TESTER_FNAME ="Desktop";
	public static final String TESTER_LNAME ="Tester";
	public static final String TESTER_NUMBER ="7718832477";
	public static final String TESTER_PASSWORD = "Qwedsa1234";
	
	public static final String GENERATE_TEAM_URL = RandomStringUtils.randomAlphabetic(8);
}