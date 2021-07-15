package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuperSaverScreen extends ScreenBase {
    TestBase testBase = new TestBase();
    public SuperSaverScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(css = ".Header-subtitle")
    public WebElement cardDescription;

    @FindBy(xpath = "//app-subscription-details-page/div[2]/div[1]/div[2]/div/div/h2")
    public WebElement activeSSText;

    public String getCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardDescription, 15, "Card description is not visible");
        return cardDescription.getText();

    }

    public String getActiveSSText() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(activeSSText,15, "active text is not visible");
        return activeSSText.getText();
    }
}
