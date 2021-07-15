package com.dhaniMobile.screens.games;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReferAndEarnBannerScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public ReferAndEarnBannerScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/rewards_card")
    public WebElement referAndEarnLink;

    public void clickOnTheReferAndEarnBanner() {
        testBase.getNativeView();
        testBase.scrollIntoView("Dhani Cash Balance");
        referAndEarnLink.click();
    }
}
