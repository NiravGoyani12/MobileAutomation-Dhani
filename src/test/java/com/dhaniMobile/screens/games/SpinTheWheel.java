package com.dhaniMobile.screens.games;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpinTheWheel  extends ScreenBase {

    TestBase testBase = new TestBase();

    public SpinTheWheel(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Image[@text='button_spinkaro']")
    public WebElement spinNowBtn;

    @AndroidFindBy(xpath = "//android.widget.Image[@text='spinnow']")
    public WebElement secondSpinNowBtn;

    @FindBy(xpath = "//*[@id=\"results\"]/div/div[2]/span[1]")
    public WebElement spinDailyText;


    public void clickSpinNow() {
        testBase.waitForElementVisibility(spinNowBtn, 10, "First Spin Now button is not displayed");
        spinNowBtn.click();
    }

    public void clickSecondSpinNow() {
        testBase.waitForElementVisibility(secondSpinNowBtn, 5, "Second Spin Now button is not displayed");
        secondSpinNowBtn.click();
    }

    public void waitUntilWheelStopped() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(spinDailyText, 30, "Wheel has not stopped ");
    }

    public String getTextForBasketball() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(spinDailyText, 15, "spin daily text is not displayed");
        return spinDailyText.getText();
    }
}
