package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaySecurelyScreen extends ScreenBase {
    public PaySecurelyScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestBase testBase = new TestBase();

    @FindBy(xpath = "/html/body/app-root/div/app-pay-page/div[2]")
//    @FindBy(className = "PayPage-top")
    public WebElement payPageTop;

    public boolean isDisplayed() {
        testBase.sleep(5000);
        testBase.getWebView();
        return payPageTop.isDisplayed();
    }

    public boolean displaysAmount(String amount) {
        testBase.getWebView();
        return payPageTop.getText().contains(amount);
    }
}
