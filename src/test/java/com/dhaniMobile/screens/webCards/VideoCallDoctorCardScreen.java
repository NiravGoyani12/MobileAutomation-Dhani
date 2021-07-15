package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoCallDoctorCardScreen extends ScreenBase {
    TestBase testBase = new TestBase();
    public VideoCallDoctorCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(css = ".MeetDoctor-title")
    public WebElement noKycCardDescription;

    @FindBy(css = ".dhani-Header")
    public WebElement fullKyccardDescription;

    public String getNoKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(noKycCardDescription, 15, "Card description is not visible");
        return noKycCardDescription.getText();
    }
    public String getFullKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(fullKyccardDescription, 15, "Card description is not visible");
        return fullKyccardDescription.getText();

    }
}
