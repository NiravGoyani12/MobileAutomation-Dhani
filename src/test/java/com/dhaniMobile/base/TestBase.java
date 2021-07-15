package com.dhaniMobile.base;

import com.dhaniMobile.utilities.AppiumServer;
import com.dhaniMobile.utilities.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;
    public static String loadPropertyFile = "Android_dhaniApp.properties";
    public static String testDataPropertyFile = "TestData.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	public WebDriverWait wait;

	public byte[] takeScreenshot() {
		byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return bytes;
	}

	public void startAppiumServer() throws Exception {
		if (driver == null) {
			if (loadPropertyFile.startsWith("Android_")) {

				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				log.info(loadPropertyFile + " properties file loaded !!!");

				AppiumServer.start();
				log.info("Appium server started");

				CommonUtils.loadTestDataProp(testDataPropertyFile);
				log.info(testDataPropertyFile + " properties file loaded !!!");

				CommonUtils.setAndroidCapabilities();
			} else if (loadPropertyFile.startsWith("IOS_")) {
				throw new Exception("Not implemented");
			}

		}

	}

	public void closeAppiumServer() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AppiumServer.stop();
		log.info("Appium server stopped !!!");
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getView(){
		try {
			getNativeView();
		}
		catch (Exception e) {
			getWebView();
		}
	}
	public static void listDriverContexts(AppiumDriver driver) {
		Set<String> allContext = driver.getContextHandles();
		for (String context : allContext) {
			System.out.println("Context --------   " + context);
			System.out.println("URL --------   " + driver.getCurrentUrl());
		}
	}

	public static void listWindowHandles(AppiumDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			System.out.println("Handle --------   " + handle);
		}
	}

	public static void switchToMainWebWindow()
	{
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
	}

	public void getNativeView()
	{
		driver.context("NATIVE_APP");
	}

	public void getWebView()
	{
		driver.context("WEBVIEW_com.indiaBulls");
		switchToMainWebWindow();
	}

	public String getCurrentUrl(){
		sleep(5000);
		getWebView();
		return driver.getCurrentUrl();
	}

	public void applyImplicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitForElementVisibility(WebElement element, int timeout, String failureMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withMessage(failureMessage);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForTextVisibility(By locator, String text, int timeout, String failureMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withMessage(failureMessage);
		wait.until(ExpectedConditions.textToBe(locator, text));
	}



	public void waitForElementInvisibility(WebElement element, int timeout, String failureMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withMessage(failureMessage);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void scrollIntoViewSelenium(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		sleep(500);
	}

	public void scrollIntoView(String Text){
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))");
	}
}
