package com.dhaniMobile.screens.profile;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AboutUsScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public AboutUsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/toolbar_title")
    public WebElement tcCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/toolbar_title")
    public WebElement privacyPolicyCardDescription;

    public String getTCCardDescription() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(tcCardDescription, 7, "Card description is not visible");
        return tcCardDescription.getText();
    }

    public String getPrivacyPolicyCardDescription() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(privacyPolicyCardDescription, 7, "Card description is not visible");
        return privacyPolicyCardDescription.getText();
    }
}
