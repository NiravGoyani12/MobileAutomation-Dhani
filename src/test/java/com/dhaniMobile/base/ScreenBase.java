package com.dhaniMobile.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dhaniMobile.base.TestBase.sleep;

public class ScreenBase {
	
	public static AppiumDriver<MobileElement> driver;
	
	//screen base constructor
	public ScreenBase(AppiumDriver<MobileElement> driver) {
		
		this.driver=driver;
	}
	
	public void hideKeyboard() {
		
		
		driver.hideKeyboard();
		
		
	}
	
	public void enter() {
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
	}


}
