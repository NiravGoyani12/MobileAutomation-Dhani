package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class ShoppingScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public ShoppingScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Shopping']")
    public WebElement noKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/browser_label")
    public WebElement fullKycCardDescription;

    public String getCardDescription(String userType) {

        testBase.getNativeView();
        switch(userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycCardDescription, 7, "text is not displayed");
                return noKycCardDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycCardDescription, 10, "text is not displayed");
                return fullKycCardDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }
}
