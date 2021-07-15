package com.dhaniMobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class CommonUtils {


	private static AppiumDriver<MobileElement> driver;
	private static URL serverUrl;
	private static DesiredCapabilities cap = new DesiredCapabilities();
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String PLATFORM_NAME;
	private static String DEVICE_NAME;
	private static String PLATFORM_VERSION;
	private static String UI_AUTOMATOR;

	private static Properties prop = new Properties();
	private static FileInputStream fis;
	public static String NO_KYC_USER_PHONE;
	public static String MIN_KYC_USER_PHONE;
	public static String FULL_KYC_USER_PHONE;
	public static String USER_WITH_CARD_PHONE;
	public static String SS_ACTIVE_USER_PHONE;
	public static String SS_INACTIVE_USER_PHONE;
	public static String ADD_BANK_MONEY_USER_PHONE;
	public static String TRANSFER_MONEY_USER_PHONE;
	public static String EXISTING_ACTIVE_WITH_CARD_USER;

	public static String OPERATING_SYSTEM;
	private static String APK_FILE;
	public static String NO_KYC_USER_PSW;
	public static String MIN_KYC_USER_PSW;
	public static String FULL_KYC_USER_PSW;
	public static String USER_WITH_CARD_PSW;
	public static String NEW_USER;
	public static String SS_ACTIVE_USER_PASSWORD;
	public static String SS_INACTIVE_USER_PASSWORD;
	public static String ADD_BANK_MONEY_USER_PASSWORD;
	public static String TRANSFER_MONEY_USER_PASSWORD;
	public static String EXISTING_ACTIVE_WITHOUT_CARD_USER;
	public static String EXISTING_ACTIVE_WITHOUT_CARD_USER_PASSWORD;
	public static String EXISTING_ACTIVE_WITH_CARD_USER_PASSWORD;

	public static void loadAndroidConfProp(String loadPropertyFile) {


		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+loadPropertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BASE_PKG = prop.getProperty("base.pgk");
		APP_ACTIVITY = prop.getProperty("application.activity");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		UI_AUTOMATOR = prop.getProperty("ui.automator");
		OPERATING_SYSTEM = prop.getProperty("operating.system");
		APK_FILE = prop.getProperty("apk.file");
	}

	public static void loadTestDataProp(String testDataPropertyFile) {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+testDataPropertyFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		NO_KYC_USER_PHONE = prop.getProperty("no.kyc.user.phone");
		MIN_KYC_USER_PHONE = prop.getProperty("min.kyc.user.phone");
		FULL_KYC_USER_PHONE = prop.getProperty("full.kyc.user.phone");
		USER_WITH_CARD_PHONE = prop.getProperty("user.with.card.phone");
		SS_ACTIVE_USER_PHONE = prop.getProperty("ss.active.user");
		SS_INACTIVE_USER_PHONE = prop.getProperty("ss.inactive.user");
		ADD_BANK_MONEY_USER_PHONE = prop.getProperty("add.bank.money.user");
		TRANSFER_MONEY_USER_PHONE = prop.getProperty("transfer.money.user");
		EXISTING_ACTIVE_WITHOUT_CARD_USER = prop.getProperty("existing.active.without.card.user");
		EXISTING_ACTIVE_WITH_CARD_USER = prop.getProperty("existing.active.with.card.user");

		NO_KYC_USER_PSW = prop.getProperty("no.kyc.user.psw");
		MIN_KYC_USER_PSW = prop.getProperty("min.kyc.user.psw");
		FULL_KYC_USER_PSW = prop.getProperty("full.kyc.user.psw");
		USER_WITH_CARD_PSW = prop.getProperty("user.with.card.psw");
		NEW_USER = prop.getProperty("new.user");
		SS_ACTIVE_USER_PASSWORD = prop.getProperty("ss.active.user.psw");
		SS_INACTIVE_USER_PASSWORD = prop.getProperty("ss.inactive.user.psw");
		ADD_BANK_MONEY_USER_PASSWORD = prop.getProperty("add.bank.money.user.psw");
		TRANSFER_MONEY_USER_PASSWORD = prop.getProperty("transfer.money.user.psw");
		EXISTING_ACTIVE_WITHOUT_CARD_USER_PASSWORD = prop.getProperty("existing.active.without.card.user.psw");
		EXISTING_ACTIVE_WITH_CARD_USER_PASSWORD = prop.getProperty("existing.active.with.card.user.psw");

	}

	//setting android cap
	public static void setAndroidCapabilities() {

		File appDir = new File("src");
		File app = new File(appDir, APK_FILE);

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.VERSION, PLATFORM_VERSION);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, UI_AUTOMATOR);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, APP_ACTIVITY);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		if(!OPERATING_SYSTEM.equalsIgnoreCase("windows")) {
			cap.setCapability("chromedriverExecutable", "/Applications/chromedriver");
			cap.setCapability("chromedriverUseSystemExecutable", false);
		}
		cap.setCapability("autoGrantPermissions", true);
	}

	public static AppiumDriver<MobileElement> getAndroidDriver() {

		try {
			serverUrl=new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverUrl,cap);
		return driver;
	}


}
